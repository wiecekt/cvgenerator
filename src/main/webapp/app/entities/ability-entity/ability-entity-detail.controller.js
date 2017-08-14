(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('AbilityEntityDetailController', AbilityEntityDetailController);

    AbilityEntityDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'AbilityEntity', 'EmployeeEntity'];

    function AbilityEntityDetailController($scope, $rootScope, $stateParams, previousState, entity, AbilityEntity, EmployeeEntity) {
        var vm = this;

        vm.abilityEntity = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cvgeneratorApp:abilityEntityUpdate', function(event, result) {
            vm.abilityEntity = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
