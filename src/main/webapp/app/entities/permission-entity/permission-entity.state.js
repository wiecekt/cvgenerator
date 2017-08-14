(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('permission-entity', {
            parent: 'entity',
            url: '/permission-entity',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.permissionEntity.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/permission-entity/permission-entities.html',
                    controller: 'PermissionEntityController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('permissionEntity');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('permission-entity-detail', {
            parent: 'permission-entity',
            url: '/permission-entity/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.permissionEntity.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/permission-entity/permission-entity-detail.html',
                    controller: 'PermissionEntityDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('permissionEntity');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'PermissionEntity', function($stateParams, PermissionEntity) {
                    return PermissionEntity.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'permission-entity',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('permission-entity-detail.edit', {
            parent: 'permission-entity-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/permission-entity/permission-entity-dialog.html',
                    controller: 'PermissionEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PermissionEntity', function(PermissionEntity) {
                            return PermissionEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('permission-entity.new', {
            parent: 'permission-entity',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/permission-entity/permission-entity-dialog.html',
                    controller: 'PermissionEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                permissionsName: null,
                                permissionsValue: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('permission-entity', null, { reload: 'permission-entity' });
                }, function() {
                    $state.go('permission-entity');
                });
            }]
        })
        .state('permission-entity.edit', {
            parent: 'permission-entity',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/permission-entity/permission-entity-dialog.html',
                    controller: 'PermissionEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['PermissionEntity', function(PermissionEntity) {
                            return PermissionEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('permission-entity', null, { reload: 'permission-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('permission-entity.delete', {
            parent: 'permission-entity',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/permission-entity/permission-entity-delete-dialog.html',
                    controller: 'PermissionEntityDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['PermissionEntity', function(PermissionEntity) {
                            return PermissionEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('permission-entity', null, { reload: 'permission-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
