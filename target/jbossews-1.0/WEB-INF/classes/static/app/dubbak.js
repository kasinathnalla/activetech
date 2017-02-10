/*$(document).ready(function(){
	 var a =$("#content");
	$("#home-nav").click(function() {
		debugger;
		var b = a.find("#home-content");
		console.log(b);
		a.find("#home-content").addClass('show').end().siblings().addClass('hide');
		 
		
		
	});
	$("#history").click(function() {
		debugger;
		var b = a.find("#home-content");
		console.log(b);
		b.addClass('show').end().siblings().addClass('hide');
	});

});
 */
$(document).ready(function() {
	alert("fff");
	$('#display-content').html($('#home-content').html());

	$("#home-nav").click(function() {
		
		$("#display-content").html($("#home-content").html());
		// $("#display-content").addClass("show");

	});
	$("#history").click(function() {
		$('#display-content').html($('#history-content').html());

	});
	$("#contact").click(function() {
		$('#display-content').html($('#contanct-form-update').html());

	});

	$("#contact-form").submit(function(evt) {
		debugger;
		alert('a');
		evt.preventDefault();
		var comments = $('textarea[name=comment]').val();

		$('#commentsappended').prepend("<p>" + comments + "</p>");	
	});
});