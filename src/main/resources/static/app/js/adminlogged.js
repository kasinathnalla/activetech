/**
 * 
 */

var angularModule = angular.module('saibaba-gajwel-app');

angularModule.controller('AdminLoggedCtrl', function($scope, AdminService) {
	$scope.submitForm = function() {

		var promise = AdminService.saveDonation($scope.donation);
		promise.then(function(data) {
			$scope.message ="Data Has been saved";
			$scope.donation = null;//Success
		}, function(data) {
			$scope.data = null;//error
		}, function(data) {
			$scope.data = null;//update
		});
		console.log($scope.comments);
		alert("AdminLoggedCtrl");
	};

});
