(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('AdditionalInfoEntityController', AdditionalInfoEntityController);

    AdditionalInfoEntityController.$inject = ['AdditionalInfoEntity'];

    function AdditionalInfoEntityController(AdditionalInfoEntity) {

        var vm = this;

        vm.additionalInfoEntities = [];

        loadAll();

        function loadAll() {
            AdditionalInfoEntity.query(function(result) {
                vm.additionalInfoEntities = result;
                vm.searchQuery = null;
            });
        }
    }
})();
