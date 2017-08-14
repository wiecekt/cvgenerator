(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('EmployeeEntityDeleteController',EmployeeEntityDeleteController);

    EmployeeEntityDeleteController.$inject = ['$uibModalInstance', 'entity', 'EmployeeEntity'];

    function EmployeeEntityDeleteController($uibModalInstance, entity, EmployeeEntity) {
        var vm = this;

        vm.employeeEntity = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            EmployeeEntity.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
