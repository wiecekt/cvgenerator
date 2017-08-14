(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('LanguageEntityDetailController', LanguageEntityDetailController);

    LanguageEntityDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'LanguageEntity', 'EmployeeEntity'];

    function LanguageEntityDetailController($scope, $rootScope, $stateParams, previousState, entity, LanguageEntity, EmployeeEntity) {
        var vm = this;

        vm.languageEntity = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cvgeneratorApp:languageEntityUpdate', function(event, result) {
            vm.languageEntity = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
