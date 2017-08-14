'use strict';

describe('Controller Tests', function() {

    describe('AbilityEntity Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockAbilityEntity, MockEmployeeEntity;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockAbilityEntity = jasmine.createSpy('MockAbilityEntity');
            MockEmployeeEntity = jasmine.createSpy('MockEmployeeEntity');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'AbilityEntity': MockAbilityEntity,
                'EmployeeEntity': MockEmployeeEntity
            };
            createController = function() {
                $injector.get('$controller')("AbilityEntityDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'cvgeneratorApp:abilityEntityUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
