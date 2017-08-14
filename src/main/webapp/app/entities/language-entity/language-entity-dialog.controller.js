(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('LanguageEntityDialogController', LanguageEntityDialogController);

    LanguageEntityDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'LanguageEntity', 'EmployeeEntity'];

    function LanguageEntityDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, LanguageEntity, EmployeeEntity) {
        var vm = this;

        vm.languageEntity = entity;
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
            if (vm.languageEntity.id !== null) {
                LanguageEntity.update(vm.languageEntity, onSaveSuccess, onSaveError);
            } else {
                LanguageEntity.save(vm.languageEntity, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('cvgeneratorApp:languageEntityUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
