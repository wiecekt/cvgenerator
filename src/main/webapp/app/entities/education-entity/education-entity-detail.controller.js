(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('EducationEntityDetailController', EducationEntityDetailController);

    EducationEntityDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'EducationEntity', 'EmployeeEntity'];

    function EducationEntityDetailController($scope, $rootScope, $stateParams, previousState, entity, EducationEntity, EmployeeEntity) {
        var vm = this;

        vm.educationEntity = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cvgeneratorApp:educationEntityUpdate', function(event, result) {
            vm.educationEntity = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
