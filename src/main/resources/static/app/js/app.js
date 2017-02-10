/**
 * 
 */
var angularModule = angular.module('saibaba-gajwel-app', [ 'ngRoute' ]);

angularModule.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		controller : 'HomeCtrl',
		templateUrl : 'app/html/home.html'
	}).when('/history', {
		controller : 'HistoryCtrl',
		templateUrl : 'app/html/history.html'
	}).when('/development', {
		controller : 'DevelopmentCtrl',
		templateUrl : 'app/html/development.html'
	}).when('/donation', {
		controller : 'DonationCtrl',
		templateUrl : 'app/html/donation.html'
	}).when('/gallary', {
		controller : 'GallaryCtrl',
		templateUrl : 'app/html/gallary.html'
	}).when('/contact', {
		controller : 'ContactCtrl',
		templateUrl : 'app/html/contact.html'
	}).when('/admin', {
		controller : 'AdminCtrl',
		templateUrl : 'app/html/admin.html'
	}).when('/admin-loggedin', {
		controller : 'AdminLoggedCtrl',
		templateUrl : 'app/html/adminloggedin.html'
	}).otherwise({
		redirectTo : '/home'
	});
} ]);

angularModule.controller('HomeCtrl', function($scope) {

	alert("HomeCtrl");

});

angularModule.controller('HistoryCtrl', function($scope) {

	alert("HistoryCtrl");

});

angularModule.controller('DevelopmentCtrl', function($scope) {
	alert("DevelopmentCtrl");

});




angularModule.controller('GallaryCtrl', function($scope) {
	alert("GallaryCtrl");

});

angularModule.controller('AdminCtrl',
		function($scope, $location, LoginService) {
			alert("AdminCtrl");
			$scope.submitLoginForm = function() {
				var login = {
					'j_username' : $scope.username,
					'j_password' : $scope.password,
					'submit' : 'Login'
				};

				var promise = LoginService.loginDetails(login);

				promise.then(function(data) {
					$location.path("admin-loggedin");

				}, function(data) {
					$scope.status = data;
				}, function(data) {
					$scope.status = "Notification";
				})
			}

		});

angularModule.controller('ContactCtrl',
		function($scope, CommentsService, $http) {

			// $scope.comments = CommentsService.getComments();

			console.log($scope.comments);
			var promise = CommentsService.getComments();
			promise.then(function(data) {
				$scope.comments = data;
			}, function(data) {
				$scope.comments = [];
			}, function(data) {
				$scope.comments = [];
			});
			console.log($scope.comments);
		
			$scope.submitForm = function() {
				CommentsService.postComments($scope.person);
				$scope.person = {
					name : "",
					comment : ""
				}
			};

		});

angularModule
		.service(
				'LoginService',
				function($http, $q) {
					this.loginDetails = function(login) {
						var deferred = $q.defer();
						$http(
								{
									method : 'POST',
									url : '/SaiBaba/login',
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded'
									},
									transformRequest : function(obj) {
										var str = [];
										for ( var p in obj)
											str
													.push(encodeURIComponent(p)
															+ "="
															+ encodeURIComponent(obj[p]));
										return str.join("&");
									},
									data : login
								})
								.success(function(data) {
									deferred.resolve(data);
								})
								.error(
										function(data, status, headers, config) {
											if (status === 'null'
													|| status === 'undefined'
													|| status != '401') {
												deferred
														.reject("Issue with Application . Please check back after some time or report to Administrator. Status code is "
																+ status);
											} else {
												deferred
														.reject("Issue with Credentials");
											}
										});
						return deferred.promise;
					};
				});

angularModule.service('CommentsService', function($http, $q) {

	this.getComments = function() {
		var deferred = $q.defer();
		$http.get("/SaiBaba/getComments").success(function(data) {
			deferred.resolve(data);
		}).error(function(error) {
			deferred.reject(data);
		});
		return deferred.promise;
	};

	this.postComments = function(person) {
		alert(person.name);
		$http.post("/SaiBaba/postComments", person).success(function(data) {
			console.log(data);

		}).error(function(error) {
			console.log(error);

		});

	};
});

