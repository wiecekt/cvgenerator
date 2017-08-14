(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('DictionaryEntityDeleteController',DictionaryEntityDeleteController);

    DictionaryEntityDeleteController.$inject = ['$uibModalInstance', 'entity', 'DictionaryEntity'];

    function DictionaryEntityDeleteController($uibModalInstance, entity, DictionaryEntity) {
        var vm = this;

        vm.dictionaryEntity = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            DictionaryEntity.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
