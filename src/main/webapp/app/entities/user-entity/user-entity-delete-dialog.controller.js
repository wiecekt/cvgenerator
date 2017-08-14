(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('UserEntityDeleteController',UserEntityDeleteController);

    UserEntityDeleteController.$inject = ['$uibModalInstance', 'entity', 'UserEntity'];

    function UserEntityDeleteController($uibModalInstance, entity, UserEntity) {
        var vm = this;

        vm.userEntity = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            UserEntity.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
