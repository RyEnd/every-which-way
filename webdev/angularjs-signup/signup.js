var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
    $scope.action = "clear";
    $scope.firstName = "John";
    $scope.lastName = "Doe";
    $scope.email = "JohnD@anonymail.com"
    $scope.clearForm = function() {
        $scope.firstName = "";
        $scope.lastName = "";
        $scope.email = "";
        $scope.username = "";
        $scope.password ="";
    }
    $scope.resetForm = function() {
        $scope.firstName = "John";
        $scope.lastName = "Doe";
        $scope.email = "JohnD@anonymail.com"
    }
});
app.directive('wjValidationError', function() {
    return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctl) {
            scope.$watch(attrs['wjValidationError'], function (errorMsg) {
                elm[0].setCustomValidity(errorMsg);
                crl.$setValidity('wgValidationError', errorMsg ? false : true);
            });
        }
    };
});
app.controller('namesCtrl', function($scope) {
    $scope.names = [
        'Jani',
        'Carl',
        'Margeret',
        'Joe',
        'Mary',
        'Gustav',
        'Alex',
        'Susanna',
        'Ryan',
        'Tracy',
        'David',
        'Dan',
        'Julie',
        'Sam'
    ];
});