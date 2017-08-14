(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('PermissionEntityDialogController', PermissionEntityDialogController);

    PermissionEntityDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'PermissionEntity', 'EmployeeEntity'];

    function PermissionEntityDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, PermissionEntity, EmployeeEntity) {
        var vm = this;

        vm.permissionEntity = entity;
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
            if (vm.permissionEntity.id !== null) {
                PermissionEntity.update(vm.permissionEntity, onSaveSuccess, onSaveError);
            } else {
                PermissionEntity.save(vm.permissionEntity, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('cvgeneratorApp:permissionEntityUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
