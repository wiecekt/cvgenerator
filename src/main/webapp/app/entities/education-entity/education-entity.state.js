(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('education-entity', {
            parent: 'entity',
            url: '/education-entity',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.educationEntity.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/education-entity/education-entities.html',
                    controller: 'EducationEntityController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('educationEntity');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('education-entity-detail', {
            parent: 'education-entity',
            url: '/education-entity/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.educationEntity.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/education-entity/education-entity-detail.html',
                    controller: 'EducationEntityDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('educationEntity');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'EducationEntity', function($stateParams, EducationEntity) {
                    return EducationEntity.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'education-entity',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('education-entity-detail.edit', {
            parent: 'education-entity-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/education-entity/education-entity-dialog.html',
                    controller: 'EducationEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['EducationEntity', function(EducationEntity) {
                            return EducationEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('education-entity.new', {
            parent: 'education-entity',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/education-entity/education-entity-dialog.html',
                    controller: 'EducationEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                educationStartDate: null,
                                educationEndDate: null,
                                isLearning: null,
                                schoolName: null,
                                subject: null,
                                educationDescription: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('education-entity', null, { reload: 'education-entity' });
                }, function() {
                    $state.go('education-entity');
                });
            }]
        })
        .state('education-entity.edit', {
            parent: 'education-entity',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/education-entity/education-entity-dialog.html',
                    controller: 'EducationEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['EducationEntity', function(EducationEntity) {
                            return EducationEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('education-entity', null, { reload: 'education-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('education-entity.delete', {
            parent: 'education-entity',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/education-entity/education-entity-delete-dialog.html',
                    controller: 'EducationEntityDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['EducationEntity', function(EducationEntity) {
                            return EducationEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('education-entity', null, { reload: 'education-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
