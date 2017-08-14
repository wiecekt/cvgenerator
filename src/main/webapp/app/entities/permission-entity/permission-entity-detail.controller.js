(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('PermissionEntityDetailController', PermissionEntityDetailController);

    PermissionEntityDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'PermissionEntity', 'EmployeeEntity'];

    function PermissionEntityDetailController($scope, $rootScope, $stateParams, previousState, entity, PermissionEntity, EmployeeEntity) {
        var vm = this;

        vm.permissionEntity = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cvgeneratorApp:permissionEntityUpdate', function(event, result) {
            vm.permissionEntity = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
