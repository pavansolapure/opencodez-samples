$( document ).ready(function() {
	
	var sse = $.SSE('/kafka-messages', {
	    onMessage: function(e){ 
	        console.log(e); 
	        $('#kafka-messages tr:last').after('<tr><td>'+e.data+'</td></tr>');
	    },
	    onError: function(e){ 
	    	sse.stop();
	        console.log("Could not connect..Stopping SSE"); 
	    },
	    onEnd: function(e){ 
	        console.log("End"); 
	    }
	});
	sse.start();
  
});