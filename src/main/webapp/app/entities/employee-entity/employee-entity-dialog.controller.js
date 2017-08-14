(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('EmployeeEntityDialogController', EmployeeEntityDialogController);

    EmployeeEntityDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'EmployeeEntity', 'UserEntity', 'HistoryExperienceEntity', 'EducationEntity', 'AbilityEntity', 'AdditionalInfoEntity', 'PermissionEntity', 'ProjectEntity', 'LanguageEntity'];

    function EmployeeEntityDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, EmployeeEntity, UserEntity, HistoryExperienceEntity, EducationEntity, AbilityEntity, AdditionalInfoEntity, PermissionEntity, ProjectEntity, LanguageEntity) {
        var vm = this;

        vm.employeeEntity = entity;
        vm.clear = clear;
        vm.save = save;
        vm.userentities = UserEntity.query({filter: 'employeeentity-is-null'});
        $q.all([vm.employeeEntity.$promise, vm.userentities.$promise]).then(function() {
            if (!vm.employeeEntity.userEntity || !vm.employeeEntity.userEntity.id) {
                return $q.reject();
            }
            return UserEntity.get({id : vm.employeeEntity.userEntity.id}).$promise;
        }).then(function(userEntity) {
            vm.userentities.push(userEntity);
        });
        vm.historyexperienceentities = HistoryExperienceEntity.query();
        vm.educationentities = EducationEntity.query();
        vm.abilityentities = AbilityEntity.query();
        vm.additionalinfoentities = AdditionalInfoEntity.query();
        vm.permissionentities = PermissionEntity.query();
        vm.projectentities = ProjectEntity.query();
        vm.languageentities = LanguageEntity.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.employeeEntity.id !== null) {
                EmployeeEntity.update(vm.employeeEntity, onSaveSuccess, onSaveError);
            } else {
                EmployeeEntity.save(vm.employeeEntity, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('cvgeneratorApp:employeeEntityUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
