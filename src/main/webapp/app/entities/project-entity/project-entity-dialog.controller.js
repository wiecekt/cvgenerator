(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('ProjectEntityDialogController', ProjectEntityDialogController);

    ProjectEntityDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'ProjectEntity', 'EmployeeEntity'];

    function ProjectEntityDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, ProjectEntity, EmployeeEntity) {
        var vm = this;

        vm.projectEntity = entity;
        vm.clear = clear;
        vm.save = save;
        vm.employeeentities = EmployeeEntity.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.projectEntity.id !== null) {
                ProjectEntity.update(vm.projectEntity, onSaveSuccess, onSaveError);
            } else {
                ProjectEntity.save(vm.projectEntity, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('cvgeneratorApp:projectEntityUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
