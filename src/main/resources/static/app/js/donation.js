/**
 * 
 */
var angularModule = angular.module('saibaba-gajwel-app');

angularModule.controller('DonationCtrl', function($scope,AdminService) {

	var promise = AdminService.getDonationList();
	promise.then(function(data) {
		
		$scope.donations = data;//Success
	}, function(data) {
		$scope.data = null;//error
	}, function(data) {
		$scope.data = null;//update
	});
	
	$scope.checkDonation = function(donation){
		alert(donation);// here can open a popup
	}
	console.log($scope.comments);
	alert("AdminLoggedCtrl");
});


