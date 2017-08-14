(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('EmployeeEntityDetailController', EmployeeEntityDetailController);

    EmployeeEntityDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'EmployeeEntity', 'UserEntity', 'HistoryExperienceEntity', 'EducationEntity', 'AbilityEntity', 'AdditionalInfoEntity', 'PermissionEntity', 'ProjectEntity', 'LanguageEntity'];

    function EmployeeEntityDetailController($scope, $rootScope, $stateParams, previousState, entity, EmployeeEntity, UserEntity, HistoryExperienceEntity, EducationEntity, AbilityEntity, AdditionalInfoEntity, PermissionEntity, ProjectEntity, LanguageEntity) {
        var vm = this;

        vm.employeeEntity = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cvgeneratorApp:employeeEntityUpdate', function(event, result) {
            vm.employeeEntity = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
