(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('PermissionEntityController', PermissionEntityController);

    PermissionEntityController.$inject = ['PermissionEntity'];

    function PermissionEntityController(PermissionEntity) {

        var vm = this;

        vm.permissionEntities = [];

        loadAll();

        function loadAll() {
            PermissionEntity.query(function(result) {
                vm.permissionEntities = result;
                vm.searchQuery = null;
            });
        }
    }
})();
