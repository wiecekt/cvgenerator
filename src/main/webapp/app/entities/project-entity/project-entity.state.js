(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('project-entity', {
            parent: 'entity',
            url: '/project-entity',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.projectEntity.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-entity/project-entities.html',
                    controller: 'ProjectEntityController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('projectEntity');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('project-entity-detail', {
            parent: 'project-entity',
            url: '/project-entity/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.projectEntity.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/project-entity/project-entity-detail.html',
                    controller: 'ProjectEntityDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('projectEntity');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'ProjectEntity', function($stateParams, ProjectEntity) {
                    return ProjectEntity.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'project-entity',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('project-entity-detail.edit', {
            parent: 'project-entity-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-entity/project-entity-dialog.html',
                    controller: 'ProjectEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectEntity', function(ProjectEntity) {
                            return ProjectEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-entity.new', {
            parent: 'project-entity',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-entity/project-entity-dialog.html',
                    controller: 'ProjectEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                project: null,
                                client: null,
                                technology: null,
                                duties: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('project-entity', null, { reload: 'project-entity' });
                }, function() {
                    $state.go('project-entity');
                });
            }]
        })
        .state('project-entity.edit', {
            parent: 'project-entity',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-entity/project-entity-dialog.html',
                    controller: 'ProjectEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['ProjectEntity', function(ProjectEntity) {
                            return ProjectEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-entity', null, { reload: 'project-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('project-entity.delete', {
            parent: 'project-entity',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/project-entity/project-entity-delete-dialog.html',
                    controller: 'ProjectEntityDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['ProjectEntity', function(ProjectEntity) {
                            return ProjectEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('project-entity', null, { reload: 'project-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
