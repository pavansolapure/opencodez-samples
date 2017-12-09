$(document).ready(function() {
	
	$("#divAlert").hide();
	$("#sourceCurrency").val('USD');
	$("#targetCurrency").val('INR');
	
	$(document).on("click", '#btnConvert', function(event) { 
		$("#conversionForm").submit();
	});	
	
	$(document).on("submit", '#conversionForm', function(event) {
		event.preventDefault(); 
		
		var $form = $(this);
		
	    $.ajax({
		      url: $('#urlConverter').val(),
		      data: $form.serializeArray(), 
		      error: function(xhr, textStatus, error) {
		    	  console.log(xhr.statusText);
		          console.log(textStatus);
		          console.log(error);
		      },
		      success: function(data) {
		    	  if(data.error == null) {
		    		  $("#divAlert").hide();
		    		  $('#tgtAmount').val(data.convertedValue);
		    	  } else {
		    		  $('#tgtAmount').val("0.00");
		    		  $('#divAlert').html(data.error.info);
		    		  $("#divAlert").show();
		    	  }
		      },
		      type: 'POST'
		});
	    
	});	

});
