var uid=1;

var myApp = angular.module("myApp", [])
	.config(function($locationProvider){
		$locationProvider.html5Mode(true);
});