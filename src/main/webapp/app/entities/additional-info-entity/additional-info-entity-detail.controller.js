(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('AdditionalInfoEntityDetailController', AdditionalInfoEntityDetailController);

    AdditionalInfoEntityDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'AdditionalInfoEntity', 'EmployeeEntity'];

    function AdditionalInfoEntityDetailController($scope, $rootScope, $stateParams, previousState, entity, AdditionalInfoEntity, EmployeeEntity) {
        var vm = this;

        vm.additionalInfoEntity = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cvgeneratorApp:additionalInfoEntityUpdate', function(event, result) {
            vm.additionalInfoEntity = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
