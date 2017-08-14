(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('ProjectEntityDetailController', ProjectEntityDetailController);

    ProjectEntityDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'ProjectEntity', 'EmployeeEntity'];

    function ProjectEntityDetailController($scope, $rootScope, $stateParams, previousState, entity, ProjectEntity, EmployeeEntity) {
        var vm = this;

        vm.projectEntity = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cvgeneratorApp:projectEntityUpdate', function(event, result) {
            vm.projectEntity = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
