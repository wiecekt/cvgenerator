'use strict';

describe('Controller Tests', function() {

    describe('PermissionEntity Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockPermissionEntity, MockEmployeeEntity;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockPermissionEntity = jasmine.createSpy('MockPermissionEntity');
            MockEmployeeEntity = jasmine.createSpy('MockEmployeeEntity');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'PermissionEntity': MockPermissionEntity,
                'EmployeeEntity': MockEmployeeEntity
            };
            createController = function() {
                $injector.get('$controller')("PermissionEntityDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'cvgeneratorApp:permissionEntityUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
