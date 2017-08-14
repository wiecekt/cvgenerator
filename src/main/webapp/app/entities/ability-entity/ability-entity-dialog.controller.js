(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('AbilityEntityDialogController', AbilityEntityDialogController);

    AbilityEntityDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'AbilityEntity', 'EmployeeEntity'];

    function AbilityEntityDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, AbilityEntity, EmployeeEntity) {
        var vm = this;

        vm.abilityEntity = entity;
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
            if (vm.abilityEntity.id !== null) {
                AbilityEntity.update(vm.abilityEntity, onSaveSuccess, onSaveError);
            } else {
                AbilityEntity.save(vm.abilityEntity, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('cvgeneratorApp:abilityEntityUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
