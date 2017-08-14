(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('AdditionalInfoEntityDeleteController',AdditionalInfoEntityDeleteController);

    AdditionalInfoEntityDeleteController.$inject = ['$uibModalInstance', 'entity', 'AdditionalInfoEntity'];

    function AdditionalInfoEntityDeleteController($uibModalInstance, entity, AdditionalInfoEntity) {
        var vm = this;

        vm.additionalInfoEntity = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            AdditionalInfoEntity.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
