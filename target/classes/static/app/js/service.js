/**
 * 
 */

var angularModule = angular.module('saibaba-gajwel-app');


angularModule.service('AdminService', function($http, $q) {

	this.saveDonation = function(donation) {
		var deferred = $q.defer();
		$http.post("/SaiBaba/saveDonation",donation).success(function(data) {
			deferred.resolve(data);
		}).error(function(error) {
			deferred.reject(error);
		});
		return deferred.promise;
	};

	
	this.getDonationList = function() {
		var deferred = $q.defer();
		$http.get("/SaiBaba/getDonationList").success(function(data) {
			deferred.resolve(data);
		}).error(function(error) {
			deferred.reject(error);
		});
		return deferred.promise;
	}
});