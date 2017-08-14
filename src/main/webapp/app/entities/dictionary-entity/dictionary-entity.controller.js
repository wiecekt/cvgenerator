(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('DictionaryEntityController', DictionaryEntityController);

    DictionaryEntityController.$inject = ['DictionaryEntity'];

    function DictionaryEntityController(DictionaryEntity) {

        var vm = this;

        vm.dictionaryEntities = [];

        loadAll();

        function loadAll() {
            DictionaryEntity.query(function(result) {
                vm.dictionaryEntities = result;
                vm.searchQuery = null;
            });
        }
    }
})();
