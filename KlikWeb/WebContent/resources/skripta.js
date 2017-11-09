var position = 0;
var rows = [];
$("#btnnext").click(function(){
	position++;	
	$.ajax({		
		contentType: "application/json",
		url: "/KlikWeb/next?ind="+position,
		type: "POST",		
		data: JSON.stringify(rows),
		success: function (data) {			
			if(data=="http://www.protech.rs")				
				window.location.href= "http://www.protech.rs";
			else
				$("#image").attr("src",data);		
			console.log("SUCCESS",data);               
        }
	});
})
	


$("img").click(function(e) {		
	var d = new Date();
	var date = d.getFullYear()  + "-" + (d.getMonth()+1) + "-" + d.getDate() + " " +
	d.getHours() + ":" + d.getMinutes()+":"+d.getMilliseconds();
	var offset = $(this).offset();
	var x = e.pageX - offset.left;
	var y = e.pageY - offset.top;
	var row = date.toString()+","+x+","+y;	
	rows.push(row);		
});



$(document).ready(function(){
    $("#btna").click(function(){
    	var osobe =[ 
    			{ime: "marko", prezime: "markovic"},{ime: "jovic", prezime: "jova"} 	
    	];
    		
    	$.ajax({
    		url: "/KlikWeb/ajax",
    		type: "POST",
    		contentType: "application/json",
    		data: JSON.stringify(osobe),
    		success: function (data) {
    			console.log("SUCCESS",data);
                    alert(data + "success");
            }
    	});
    });    
});