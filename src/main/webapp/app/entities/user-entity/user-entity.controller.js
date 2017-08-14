(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('UserEntityController', UserEntityController);

    UserEntityController.$inject = ['UserEntity'];

    function UserEntityController(UserEntity) {

        var vm = this;

        vm.userEntities = [];

        loadAll();

        function loadAll() {
            UserEntity.query(function(result) {
                vm.userEntities = result;
                vm.searchQuery = null;
            });
        }
    }
})();
