'use strict';

describe('Controller Tests', function() {

    describe('HistoryExperienceEntity Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockHistoryExperienceEntity, MockEmployeeEntity;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockHistoryExperienceEntity = jasmine.createSpy('MockHistoryExperienceEntity');
            MockEmployeeEntity = jasmine.createSpy('MockEmployeeEntity');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'HistoryExperienceEntity': MockHistoryExperienceEntity,
                'EmployeeEntity': MockEmployeeEntity
            };
            createController = function() {
                $injector.get('$controller')("HistoryExperienceEntityDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'cvgeneratorApp:historyExperienceEntityUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
