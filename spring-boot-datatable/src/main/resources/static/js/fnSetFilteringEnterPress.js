jQuery.fn.dataTableExt.oApi.fnSetFilteringEnterPress = function(oSettings) {
	var _that = this;

	this.each(function(i) {
		$.fn.dataTableExt.iApiIndex = i;
		var anControl = $('input', _that.fnSettings().aanFeatures.f);

		anControl.unbind('keyup search input').bind(
				'keyup search input',
				function(e) {
					if (anControl.val().length == "" || anControl.val().length > 2) {
						_that.fnFilter(anControl.val());
					}
				});
		return this;
	});
	return this;
};