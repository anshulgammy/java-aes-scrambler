var app = angular.module('AesApp', []);
app.controller('AesController', function($scope) {
	$scope.selectedOperation = null;
	$scope.selectJavaVersionFlag = true;
	$scope.selectedJavaVersion = null;
	$scope.selectedEncryptionBits = null;
	$scope.selectEncryptionFlag = true;
	$scope.selectedAesAlgorithm = null;
	$scope.selectAlgorithmFlag = true;
	$scope.inputKeysFlag = true;
	$scope.aesKeyValue = "";
	$scope.aesSaltValue = "";
	$scope.setOperation = function(val) {
		$scope.selectedOperation = val;
		$scope.selectJavaVersionFlag = false;
	};
	$scope.setJavaVersion = function(val) {
		$scope.selectedJavaVersion = val;
		$scope.selectEncryptionFlag = false;
	};
	$scope.setEncryptionBits = function(val) {
		$scope.selectedEncryptionBits = val;
		$scope.selectAlgorithmFlag = false;
	};
	$scope.setAesAlgorithm = function() {
		$scope.inputKeysFlag = false;
		console.log($scope.selectedAesAlgorithm);
	};
	$scope.performAesOperation = function() {
		
	};
});