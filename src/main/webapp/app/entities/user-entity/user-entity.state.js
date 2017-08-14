(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('user-entity', {
            parent: 'entity',
            url: '/user-entity',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.userEntity.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/user-entity/user-entities.html',
                    controller: 'UserEntityController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('userEntity');
                    $translatePartialLoader.addPart('accountType');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('user-entity-detail', {
            parent: 'user-entity',
            url: '/user-entity/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.userEntity.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/user-entity/user-entity-detail.html',
                    controller: 'UserEntityDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('userEntity');
                    $translatePartialLoader.addPart('accountType');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'UserEntity', function($stateParams, UserEntity) {
                    return UserEntity.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'user-entity',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('user-entity-detail.edit', {
            parent: 'user-entity-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-entity/user-entity-dialog.html',
                    controller: 'UserEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['UserEntity', function(UserEntity) {
                            return UserEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('user-entity.new', {
            parent: 'user-entity',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-entity/user-entity-dialog.html',
                    controller: 'UserEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                username: null,
                                password: null,
                                accountType: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('user-entity', null, { reload: 'user-entity' });
                }, function() {
                    $state.go('user-entity');
                });
            }]
        })
        .state('user-entity.edit', {
            parent: 'user-entity',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-entity/user-entity-dialog.html',
                    controller: 'UserEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['UserEntity', function(UserEntity) {
                            return UserEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('user-entity', null, { reload: 'user-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('user-entity.delete', {
            parent: 'user-entity',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-entity/user-entity-delete-dialog.html',
                    controller: 'UserEntityDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['UserEntity', function(UserEntity) {
                            return UserEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('user-entity', null, { reload: 'user-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
