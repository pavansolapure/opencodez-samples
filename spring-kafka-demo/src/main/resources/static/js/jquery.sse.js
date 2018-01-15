/*
 * jQuery Plugin for Server-Sent Events (SSE) EventSource Polyfill v0.1.3
 * https://github.com/byjg/jquery-sse
 *
 * This document is licensed as free software under the terms of the
 * MIT License: http://www.opensource.org/licenses/mit-license.php
 *
 * Copyright (c) 2015 by JG (João Gilberto Magalhães).
 */
(function ($) {
    $.extend({
        SSE: function (url, customSettings) {
            var sse = {instance: null, type: null};

            var settings = {
                onOpen: function (e) {
                },
                onEnd: function (e) {
                },
                onError: function (e) {
                },
                onMessage: function (e) {
                },
                options: {},
                headers: {},
                events: {}
            };

            $.extend(settings, customSettings);

            sse._url = url;
            sse._settings = settings;

            // Start the proper EventSource object or Ajax fallback
            sse._start = sse.start;
            sse.start = function () {
                if (this.instance) {
                    return false;
                }

                if (!window.EventSource || this._settings.options.forceAjax || (Object.keys(this._settings.headers).length > 0)) {
                    createAjax(this);
                } else {
                    createEventSource(this);
                }

                return true;
            };

            // Stop the proper object
            sse.stop = function () {
                if (!this.instance) {
                    return false;
                }

                if (!window.EventSource || this._settings.options.forceAjax || (Object.keys(this._settings.headers).length > 0)) {
                    // Nothing to do;
                } else {
                    this.instance.close();
                }
                this._settings.onEnd();

                this.instance = null;
                this.type = null;

                return true;

            };

            return sse;

        }
    });


    // Private Method for Handle EventSource object
    function createEventSource(me) {
        me.type = 'event';
        me.instance = new EventSource(me._url);
        me.instance.successCount = 0;

        me.instance.onmessage = me._settings.onMessage;
        me.instance.onopen = function (e) {
            if (me.instance.successCount++ === 0) {
                me._settings.onOpen(e);
            }
        };
        me.instance.onerror = function (e) {
            if (e.target.readyState === EventSource.CLOSED) {
                me._settings.onError(e);
            }
        };

        for (var key in me._settings.events) {
            me.instance.addEventListener(key, me._settings.events[key], false);
        }
    }
    
    // Handle the Ajax instance (fallback)
    function createAjax(me) {
        me.type = 'ajax';
        me.instance = {successCount: 0, id: null, retry: 3000, data: "", event: ""};
        runAjax(me);
    }
    
    // Handle the continous Ajax request (fallback)
    function runAjax(me) {
        if (!me.instance) {
            return;
        }

        var headers = {'Last-Event-ID': me.instance.id};

        $.extend(headers, me._settings.headers);

        $.ajax({
            url: me._url,
            method: 'GET',
            headers: headers,
            success: function (receivedData, status, info) {
                if (!me.instance) {
                    return;
                }

                if (me.instance.successCount++ === 0) {
                    me._settings.onOpen();
                }

                var lines = receivedData.split("\n");

                // Process the return to generate a compatible SSE response
                me.instance.data = "";
                var countBreakLine = 0;
                for (var key in lines) {
                    var separatorPos = lines[key].indexOf(":");
                    var item = [
                        lines[key].substr(0, separatorPos),
                        lines[key].substr(separatorPos + 1)
                    ];
                    switch (item[0]) {
                        // If the first part is empty, needed to check another sequence
                        case "":
                            if (!item[1] && countBreakLine++ === 1) {  // Avoid comments!
                                eventMessage = {
                                    data: me.instance.data,
                                    lastEventId: me.instance.id,
                                    origin: 'http://' + info.getResponseHeader('Host'),
                                    returnValue: true
                                };

                                // If there are a custom event then call it
                                if (me.instance.event && me._settings.events[me.instance.event]) {
                                    me._settings.events[me.instance.event](eventMessage);
                                } else {
                                    me._settings.onMessage(eventMessage);
                                }
                                me.instance.data = "";
                                me.instance.event = "";
                                countBreakLine = 0;
                            }
                            break;

                            // Define the new retry object;
                        case "retry":
                            countBreakLine = 0;
                            me.instance.retry = parseInt(item[1].trim());
                            break;

                            // Define the new ID
                        case "id":
                            countBreakLine = 0;
                            me.instance.id = item[1].trim();
                            break;

                            // Define a custom event
                        case "event":
                            countBreakLine = 0;
                            me.instance.event = item[1].trim();
                            break;

                            // Define the data to be processed.
                        case "data":
                            countBreakLine = 0;
                            me.instance.data += (me.instance.data !== "" ? "\n" : "") + item[1].trim();
                            break;

                        default:
                            countBreakLine = 0;
                    }
                }
                setTimeout(function () {
                    runAjax(me);
                }, me.instance.retry);
            },
            error: me._settings.onError
        });
    }
    
})(jQuery);

