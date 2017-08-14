(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('AbilityEntityDeleteController',AbilityEntityDeleteController);

    AbilityEntityDeleteController.$inject = ['$uibModalInstance', 'entity', 'AbilityEntity'];

    function AbilityEntityDeleteController($uibModalInstance, entity, AbilityEntity) {
        var vm = this;

        vm.abilityEntity = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            AbilityEntity.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
