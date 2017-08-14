'use strict';

describe('Controller Tests', function() {

    describe('EmployeeEntity Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockEmployeeEntity, MockUserEntity, MockHistoryExperienceEntity, MockEducationEntity, MockAbilityEntity, MockAdditionalInfoEntity, MockPermissionEntity, MockProjectEntity, MockLanguageEntity;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockEmployeeEntity = jasmine.createSpy('MockEmployeeEntity');
            MockUserEntity = jasmine.createSpy('MockUserEntity');
            MockHistoryExperienceEntity = jasmine.createSpy('MockHistoryExperienceEntity');
            MockEducationEntity = jasmine.createSpy('MockEducationEntity');
            MockAbilityEntity = jasmine.createSpy('MockAbilityEntity');
            MockAdditionalInfoEntity = jasmine.createSpy('MockAdditionalInfoEntity');
            MockPermissionEntity = jasmine.createSpy('MockPermissionEntity');
            MockProjectEntity = jasmine.createSpy('MockProjectEntity');
            MockLanguageEntity = jasmine.createSpy('MockLanguageEntity');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'EmployeeEntity': MockEmployeeEntity,
                'UserEntity': MockUserEntity,
                'HistoryExperienceEntity': MockHistoryExperienceEntity,
                'EducationEntity': MockEducationEntity,
                'AbilityEntity': MockAbilityEntity,
                'AdditionalInfoEntity': MockAdditionalInfoEntity,
                'PermissionEntity': MockPermissionEntity,
                'ProjectEntity': MockProjectEntity,
                'LanguageEntity': MockLanguageEntity
            };
            createController = function() {
                $injector.get('$controller')("EmployeeEntityDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'cvgeneratorApp:employeeEntityUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
