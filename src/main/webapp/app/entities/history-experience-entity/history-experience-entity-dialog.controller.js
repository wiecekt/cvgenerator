(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('HistoryExperienceEntityDialogController', HistoryExperienceEntityDialogController);

    HistoryExperienceEntityDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'HistoryExperienceEntity', 'EmployeeEntity'];

    function HistoryExperienceEntityDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, HistoryExperienceEntity, EmployeeEntity) {
        var vm = this;

        vm.historyExperienceEntity = entity;
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
            if (vm.historyExperienceEntity.id !== null) {
                HistoryExperienceEntity.update(vm.historyExperienceEntity, onSaveSuccess, onSaveError);
            } else {
                HistoryExperienceEntity.save(vm.historyExperienceEntity, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('cvgeneratorApp:historyExperienceEntityUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.historyStartDate = false;
        vm.datePickerOpenStatus.historyEndDate = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
