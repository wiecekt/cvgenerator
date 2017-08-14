(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('EducationEntityController', EducationEntityController);

    EducationEntityController.$inject = ['EducationEntity'];

    function EducationEntityController(EducationEntity) {

        var vm = this;

        vm.educationEntities = [];

        loadAll();

        function loadAll() {
            EducationEntity.query(function(result) {
                vm.educationEntities = result;
                vm.searchQuery = null;
            });
        }
    }
})();
