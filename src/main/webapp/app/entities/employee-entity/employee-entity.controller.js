(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('EmployeeEntityController', EmployeeEntityController);

    EmployeeEntityController.$inject = ['EmployeeEntity'];

    function EmployeeEntityController(EmployeeEntity) {

        var vm = this;

        vm.employeeEntities = [];

        loadAll();

        function loadAll() {
            EmployeeEntity.query(function(result) {
                vm.employeeEntities = result;
                vm.searchQuery = null;
            });
        }
    }
})();
