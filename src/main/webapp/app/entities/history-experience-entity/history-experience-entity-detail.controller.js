(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('HistoryExperienceEntityDetailController', HistoryExperienceEntityDetailController);

    HistoryExperienceEntityDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'HistoryExperienceEntity', 'EmployeeEntity'];

    function HistoryExperienceEntityDetailController($scope, $rootScope, $stateParams, previousState, entity, HistoryExperienceEntity, EmployeeEntity) {
        var vm = this;

        vm.historyExperienceEntity = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cvgeneratorApp:historyExperienceEntityUpdate', function(event, result) {
            vm.historyExperienceEntity = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
