(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('AbilityEntityController', AbilityEntityController);

    AbilityEntityController.$inject = ['AbilityEntity'];

    function AbilityEntityController(AbilityEntity) {

        var vm = this;

        vm.abilityEntities = [];

        loadAll();

        function loadAll() {
            AbilityEntity.query(function(result) {
                vm.abilityEntities = result;
                vm.searchQuery = null;
            });
        }
    }
})();
