(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('HistoryExperienceEntityDeleteController',HistoryExperienceEntityDeleteController);

    HistoryExperienceEntityDeleteController.$inject = ['$uibModalInstance', 'entity', 'HistoryExperienceEntity'];

    function HistoryExperienceEntityDeleteController($uibModalInstance, entity, HistoryExperienceEntity) {
        var vm = this;

        vm.historyExperienceEntity = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            HistoryExperienceEntity.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
