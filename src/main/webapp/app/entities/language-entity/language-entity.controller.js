(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('LanguageEntityController', LanguageEntityController);

    LanguageEntityController.$inject = ['LanguageEntity'];

    function LanguageEntityController(LanguageEntity) {

        var vm = this;

        vm.languageEntities = [];

        loadAll();

        function loadAll() {
            LanguageEntity.query(function(result) {
                vm.languageEntities = result;
                vm.searchQuery = null;
            });
        }
    }
})();
