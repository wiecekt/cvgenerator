(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .controller('DictionaryEntityDetailController', DictionaryEntityDetailController);

    DictionaryEntityDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'DictionaryEntity'];

    function DictionaryEntityDetailController($scope, $rootScope, $stateParams, previousState, entity, DictionaryEntity) {
        var vm = this;

        vm.dictionaryEntity = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('cvgeneratorApp:dictionaryEntityUpdate', function(event, result) {
            vm.dictionaryEntity = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
