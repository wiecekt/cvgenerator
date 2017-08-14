(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('UserEntityDialogController', UserEntityDialogController);

    UserEntityDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'UserEntity', 'EmployeeEntity'];

    function UserEntityDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, UserEntity, EmployeeEntity) {
        var vm = this;

        vm.userEntity = entity;
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
            if (vm.userEntity.id !== null) {
                UserEntity.update(vm.userEntity, onSaveSuccess, onSaveError);
            } else {
                UserEntity.save(vm.userEntity, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('cvgeneratorApp:userEntityUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
