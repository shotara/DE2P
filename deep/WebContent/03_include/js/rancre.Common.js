/**
 * 
 */


/** channel Detail page using
 */

$(function() {
	$('ul.sub-tabs li a').click(function() {
		var activeTab = $(this).attr('data-tab');
		$('ul.sub-tabs li a').removeClass('active');
		$('.sub-tabcontent').removeClass('active');
		$(this).addClass('active');
		$('#' + activeTab).addClass('active');
	})
});

$(function() {
	$('div.subNav-tab a').click(function() {
		var activeTab = $(this).attr('data-tab');
		$('div.subNav-tab a').removeClass('active');
		$('.subNav-content').removeClass('active');
		$(this).addClass('active');
		$('#' + activeTab).addClass('active');
	})
});