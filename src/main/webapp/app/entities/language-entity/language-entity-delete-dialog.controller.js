(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('LanguageEntityDeleteController',LanguageEntityDeleteController);

    LanguageEntityDeleteController.$inject = ['$uibModalInstance', 'entity', 'LanguageEntity'];

    function LanguageEntityDeleteController($uibModalInstance, entity, LanguageEntity) {
        var vm = this;

        vm.languageEntity = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            LanguageEntity.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
