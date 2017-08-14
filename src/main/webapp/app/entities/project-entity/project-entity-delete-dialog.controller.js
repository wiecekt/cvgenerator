(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('ProjectEntityDeleteController',ProjectEntityDeleteController);

    ProjectEntityDeleteController.$inject = ['$uibModalInstance', 'entity', 'ProjectEntity'];

    function ProjectEntityDeleteController($uibModalInstance, entity, ProjectEntity) {
        var vm = this;

        vm.projectEntity = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            ProjectEntity.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
