(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('ability-entity', {
            parent: 'entity',
            url: '/ability-entity',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.abilityEntity.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/ability-entity/ability-entities.html',
                    controller: 'AbilityEntityController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('abilityEntity');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('ability-entity-detail', {
            parent: 'ability-entity',
            url: '/ability-entity/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.abilityEntity.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/ability-entity/ability-entity-detail.html',
                    controller: 'AbilityEntityDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('abilityEntity');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'AbilityEntity', function($stateParams, AbilityEntity) {
                    return AbilityEntity.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'ability-entity',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('ability-entity-detail.edit', {
            parent: 'ability-entity-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/ability-entity/ability-entity-dialog.html',
                    controller: 'AbilityEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['AbilityEntity', function(AbilityEntity) {
                            return AbilityEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('ability-entity.new', {
            parent: 'ability-entity',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/ability-entity/ability-entity-dialog.html',
                    controller: 'AbilityEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                abilityType: null,
                                abilityLevel: null,
                                experience: null,
                                abilityDescription: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('ability-entity', null, { reload: 'ability-entity' });
                }, function() {
                    $state.go('ability-entity');
                });
            }]
        })
        .state('ability-entity.edit', {
            parent: 'ability-entity',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/ability-entity/ability-entity-dialog.html',
                    controller: 'AbilityEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['AbilityEntity', function(AbilityEntity) {
                            return AbilityEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('ability-entity', null, { reload: 'ability-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('ability-entity.delete', {
            parent: 'ability-entity',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/ability-entity/ability-entity-delete-dialog.html',
                    controller: 'AbilityEntityDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['AbilityEntity', function(AbilityEntity) {
                            return AbilityEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('ability-entity', null, { reload: 'ability-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
