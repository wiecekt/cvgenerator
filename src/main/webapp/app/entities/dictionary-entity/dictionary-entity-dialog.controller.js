(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('DictionaryEntityDialogController', DictionaryEntityDialogController);

    DictionaryEntityDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'DictionaryEntity'];

    function DictionaryEntityDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, DictionaryEntity) {
        var vm = this;

        vm.dictionaryEntity = entity;
        vm.clear = clear;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.dictionaryEntity.id !== null) {
                DictionaryEntity.update(vm.dictionaryEntity, onSaveSuccess, onSaveError);
            } else {
                DictionaryEntity.save(vm.dictionaryEntity, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('cvgeneratorApp:dictionaryEntityUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
