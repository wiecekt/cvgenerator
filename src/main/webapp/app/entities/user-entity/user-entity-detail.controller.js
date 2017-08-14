(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('UserEntityDetailController', UserEntityDetailController);

    UserEntityDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'UserEntity', 'EmployeeEntity'];

    function UserEntityDetailController($scope, $rootScope, $stateParams, previousState, entity, UserEntity, EmployeeEntity) {
        var vm = this;

        vm.userEntity = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cvgeneratorApp:userEntityUpdate', function(event, result) {
            vm.userEntity = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
