(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('EducationEntityDeleteController',EducationEntityDeleteController);

    EducationEntityDeleteController.$inject = ['$uibModalInstance', 'entity', 'EducationEntity'];

    function EducationEntityDeleteController($uibModalInstance, entity, EducationEntity) {
        var vm = this;

        vm.educationEntity = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            EducationEntity.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
