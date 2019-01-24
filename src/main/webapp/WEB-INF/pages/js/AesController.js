var httpProtocol = window.location.protocol;
var contextPath = window.location.host;
var getAlgorithmsEndpoint = httpProtocol + "//" + contextPath + "/"
		+ "scrambler/scramble/getalgo";
var getScrambleEndpointUrl = httpProtocol + "//" + contextPath + "/"
+ "scrambler/scramble/getscrambles";
var getUnscrambleEndpointUrl = httpProtocol + "//" + contextPath + "/"
+ "scrambler/scramble/getalgo";

var app = angular.module('AesApp', []);

app.controller('AesController', function($scope, $http) {
	$scope.selectedOperation = null;
	$scope.selectJavaVersionFlag = true;
	$scope.totalJavaAlgos = [];
	$scope.selectedJavaVersion = null;
	$scope.selectedEncryptionBits = null;
	$scope.selectEncryptionFlag = true;
	$scope.selectedAesAlgorithm = null;
	$scope.selectAlgorithmFlag = true;
	$scope.inputKeysFlag = true;
	$scope.aesKeyValue = "";
	$scope.listOfStrings = "";
	$scope.aesSaltValue = "";
	$scope.totalResponseArray = [];
	$scope.showResultSection = true;
	$scope.listOfStringsArray = [];
	$scope.setOperation = function(val) {
		$scope.selectedOperation = val;
		$scope.selectJavaVersionFlag = false;
	};
	$scope.setJavaVersion = function(val) {
		$scope.selectedJavaVersion = val;
		$scope.selectEncryptionFlag = false;
		callWebServiceToGetAlgorithms($http, getAlgorithmsEndpoint, $scope);
	};
	$scope.setEncryptionBits = function(val) {
		$scope.selectedEncryptionBits = val;
		$scope.selectAlgorithmFlag = false;
	};
	$scope.setAesAlgorithm = function() {
		$scope.inputKeysFlag = false;
	};
	$scope.performAesOperation = function() {
		if($scope.selectedOperation === "encrypt") {
			callWebServiceToScrambleUnscramble($http, getScrambleEndpointUrl, $scope);
		} else if($scope.selectedOperation === "decrypt") {
			callWebServiceToScrambleUnscramble($http, getUnscrambleEndpointUrl, $scope);
		}
	};
});

// Makes call to all the exposed Rest Services in the application to get List of
// applicable Algorithms
function callWebServiceToGetAlgorithms($http, endpointUrl, $scope) {
	console.log("inside callWebService");
	console.log(getAlgorithmsEndpoint);
	$http({
		url : endpointUrl,
		method : "POST",
		data : {
			'javaVersion' : $scope.selectedJavaVersion,
			'javaAlgorithms' : []
		}
	}).then(function(response) {
		console.log(response.data.javaAlgorithms);
		$scope.totalJavaAlgos = response.data.javaAlgorithms;
	});
}

// Makes call to all the exposed Rest Services in the application to get
// scramble/unscramble response.
function callWebServiceToScrambleUnscramble($http, endpointUrl, $scope) {
	console.log("inside callWebServiceToGetAlgorithms");
	console.log(getAlgorithmsEndpoint);
	$http({
		url : endpointUrl,
		method : "POST",
		data : {
			'javaVersion' : $scope.selectedJavaVersion,
			'aesKeyValue' : $scope.aesKeyValue,
			'aesSaltValue' : $scope.aesSaltValue,
			'selectedAesAlgorithm' : $scope.selectedAesAlgorithm,
			'listOfStrings' : $scope.listOfStrings,
			'selectedEncryptionBits' : $scope.selectedEncryptionBits,
			'userAction' : $scope.selectedOperation,
			'result' : []
		}
	}).then(function(response) {
		$scope.totalResponseArray = response.data.result;
		$scope.listOfStringsArray = ($scope.listOfStrings).split(",");
		$scope.showResultSection = false;
	});
}