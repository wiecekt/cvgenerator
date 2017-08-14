'use strict';

describe('Controller Tests', function() {

    describe('AdditionalInfoEntity Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockAdditionalInfoEntity, MockEmployeeEntity;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockAdditionalInfoEntity = jasmine.createSpy('MockAdditionalInfoEntity');
            MockEmployeeEntity = jasmine.createSpy('MockEmployeeEntity');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'AdditionalInfoEntity': MockAdditionalInfoEntity,
                'EmployeeEntity': MockEmployeeEntity
            };
            createController = function() {
                $injector.get('$controller')("AdditionalInfoEntityDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'cvgeneratorApp:additionalInfoEntityUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
