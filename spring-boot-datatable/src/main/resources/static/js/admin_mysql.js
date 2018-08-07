$( document ).ready(function() {
	$('#paginatedTable').DataTable( {
        "processing": true,
        "serverSide": true,
        "pageLength": 5,
        "ajax": {
            "url": "/users/paginated/mysql",
            "data": function ( data ) {
			 //process data before sent to server.
         }},
        "columns": [
                    { "data": "id", "name" : "ID", "title" : "ID"  },
                    { "data": "name", "name" : "Name" , "title" : "Name"},
                    { "data": "salary", "name" : "Salary" , "title" : "Salary"}
                ]    
	});
	
	$('#paginatedTable').dataTable().fnSetFilteringEnterPress();
});