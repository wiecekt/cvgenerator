(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('HistoryExperienceEntityController', HistoryExperienceEntityController);

    HistoryExperienceEntityController.$inject = ['HistoryExperienceEntity'];

    function HistoryExperienceEntityController(HistoryExperienceEntity) {

        var vm = this;

        vm.historyExperienceEntities = [];

        loadAll();

        function loadAll() {
            HistoryExperienceEntity.query(function(result) {
                vm.historyExperienceEntities = result;
                vm.searchQuery = null;
            });
        }
    }
})();
