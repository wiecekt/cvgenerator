(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('ProjectEntityController', ProjectEntityController);

    ProjectEntityController.$inject = ['ProjectEntity'];

    function ProjectEntityController(ProjectEntity) {

        var vm = this;

        vm.projectEntities = [];

        loadAll();

        function loadAll() {
            ProjectEntity.query(function(result) {
                vm.projectEntities = result;
                vm.searchQuery = null;
            });
        }
    }
})();
