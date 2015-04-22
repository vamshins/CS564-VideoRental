var userApp = angular.module('userApp', [ 'ngResource', 'ui.bootstrap' ]);
userApp.factory('Users', function($resource) {
//	return $resource('http://localhost:8080/springrest/user/listallusers');
	return $resource('http://localhost:8080/springrest/user/list');
});
userApp.service('sharedProperties', function() {
	var user = {};

	return {
		getUser : function() {
			return user;
		},
		setUser : function(value) {
			user = value;
		}
	};
});

userApp.controller('ListController', function($scope, $dialog, $routeParams,
		Users, sharedProperties) {

	$scope.sortField = undefined;
	$scope.reverse = false;

	Users.query(function(users) {
		$scope.users = users;
	});

	$scope.edit = function(user) {
		sharedProperties.setUser(user);
		var loginDialog = null;
		if (!loginDialog) {
			loginDialog = $dialog.dialog();
			loginDialog
					.open('resources/tpls/users/edit.html', 'EditController')
					.then(onLoginDialogClose);
		}
	};
	
	$scope.del = function(user) {
		sharedProperties.setUser(user);
		var loginDialog = null;
		if (!loginDialog) {
			loginDialog = $dialog.dialog();
			loginDialog
					.open('resources/tpls/users/delete.html', 'EditController')
					.then(onLoginDialogClose);
		}
	};

	$scope.sort = function(sortField) {
		if ($scope.sortField == sortField) {
			$scope.reverse = !$scope.reverse;
		} else {
			$scope.sortField = sortField;
			$scope.reverse = false;
		}
	};

	function closeLoginDialog(success) {
		sharedProperties.setUser(null);
		if (loginDialog) {
			loginDialog.close(success);
			loginDialog = null;
		}
	}

	function onLoginDialogClose(success) {
		loginDialog = null;
	}
});
userApp.controller('EditController', function($scope, $http, Users,
		sharedProperties) {

	$scope.edituser = sharedProperties.getUser();
	$scope.response = "";
	$scope.showResponse = "";

	$scope.update = function(user) {
		$http.post('http://localhost:8080/springrest/user/updateuser', user)
				.then(function(response) {
					if (response.data.status === "success") {
						$scope.response = "Update Success";
						$scope.showResponse = "success";
					} else {
						$scope.response = "Update Failed";
						$scope.showResponse = "failed";
					}
				});
	};

});

userApp.controller('NewController', function($scope, $http) {
	$scope.newuser = {};
	$scope.response = "";
	$scope.showResponse = false;

	$scope.add = function(user) {
		$scope.newuser = user;
		$http.post('http://localhost:8080/springrest/user/adduser', user).then(
				function(response) {
					if (response.data.status === "success") {
						$scope.response = "Add Success";
						$scope.showResponse = "success";
					} else {
						$scope.response = "Add Failed";
						$scope.showResponse = "failed";
					}
				}, function(error) {
					$scope.response = "Add Failed";
					$scope.showResponse = "failed";
				});
	};

	$scope.checkEmail = function(email) {
		var futureResponse = $http.get(
				"http://localhost:8080/springrest/user/checkemail", {
					params : {
						emailId : email
					}
				});
		futureResponse.success(function(data, status, headers, config) {
			$scope.data = data;
			if (data.status == "exists") {
				$scope.showResponse = "exists";
				$scope.response = "Email Already Exists!";
			} else {
				$scope.showResponse = false;
				$scope.response = "";
			}
		});
		futureResponse.error(function(data, status, headers, config) {
			// throw new Error('Something went wrong...');
		});
	};

});

userApp.directive('ngBlur', function() {
	return function(scope, elem, attrs) {
		elem.bind('blur', function() {
			scope.$apply(attrs.ngBlur);
		});
	};
});

var app = angular.module('app', [ 'ngRoute', 'userApp' ]);
app.config(function($routeProvider) {
	$routeProvider.when('/list', {
		controller : 'ListController',
		templateUrl : 'resources/tpls/users/list.html'
	}).when('/edit/:id', {
		controller : 'EditController',
		templateUrl : 'resources/tpls/users/edit.html'
	}).when('/new', {
		templateUrl : 'resources/tpls/users/new.html'
	}).when('/listeditable', {
		templateUrl : 'resources/tpls/users/listeditable.html'
	}).otherwise({
		redirectTo : '/'
	});
});
app.controller('AppCtrl', function($scope) {
	$scope.home = function() {
		$location.path('/');
	};
});



