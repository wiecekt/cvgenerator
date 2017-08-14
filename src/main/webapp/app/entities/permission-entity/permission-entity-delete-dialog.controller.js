(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('PermissionEntityDeleteController',PermissionEntityDeleteController);

    PermissionEntityDeleteController.$inject = ['$uibModalInstance', 'entity', 'PermissionEntity'];

    function PermissionEntityDeleteController($uibModalInstance, entity, PermissionEntity) {
        var vm = this;

        vm.permissionEntity = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            PermissionEntity.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
