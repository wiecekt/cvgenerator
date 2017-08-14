(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('AdditionalInfoEntityDialogController', AdditionalInfoEntityDialogController);

    AdditionalInfoEntityDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'AdditionalInfoEntity', 'EmployeeEntity'];

    function AdditionalInfoEntityDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, AdditionalInfoEntity, EmployeeEntity) {
        var vm = this;

        vm.additionalInfoEntity = entity;
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
            if (vm.additionalInfoEntity.id !== null) {
                AdditionalInfoEntity.update(vm.additionalInfoEntity, onSaveSuccess, onSaveError);
            } else {
                AdditionalInfoEntity.save(vm.additionalInfoEntity, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('cvgeneratorApp:additionalInfoEntityUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
