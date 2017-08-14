(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('EducationEntityDialogController', EducationEntityDialogController);

    EducationEntityDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'EducationEntity', 'EmployeeEntity'];

    function EducationEntityDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, EducationEntity, EmployeeEntity) {
        var vm = this;

        vm.educationEntity = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.employeeentities = EmployeeEntity.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.educationEntity.id !== null) {
                EducationEntity.update(vm.educationEntity, onSaveSuccess, onSaveError);
            } else {
                EducationEntity.save(vm.educationEntity, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('cvgeneratorApp:educationEntityUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.educationStartDate = false;
        vm.datePickerOpenStatus.educationEndDate = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
