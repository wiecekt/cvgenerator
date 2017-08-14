(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('dictionary-entity', {
            parent: 'entity',
            url: '/dictionary-entity',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.dictionaryEntity.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/dictionary-entity/dictionary-entities.html',
                    controller: 'DictionaryEntityController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('dictionaryEntity');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('dictionary-entity-detail', {
            parent: 'dictionary-entity',
            url: '/dictionary-entity/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.dictionaryEntity.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/dictionary-entity/dictionary-entity-detail.html',
                    controller: 'DictionaryEntityDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('dictionaryEntity');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'DictionaryEntity', function($stateParams, DictionaryEntity) {
                    return DictionaryEntity.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'dictionary-entity',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('dictionary-entity-detail.edit', {
            parent: 'dictionary-entity-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/dictionary-entity/dictionary-entity-dialog.html',
                    controller: 'DictionaryEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['DictionaryEntity', function(DictionaryEntity) {
                            return DictionaryEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('dictionary-entity.new', {
            parent: 'dictionary-entity',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/dictionary-entity/dictionary-entity-dialog.html',
                    controller: 'DictionaryEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                section: null,
                                field: null,
                                value: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('dictionary-entity', null, { reload: 'dictionary-entity' });
                }, function() {
                    $state.go('dictionary-entity');
                });
            }]
        })
        .state('dictionary-entity.edit', {
            parent: 'dictionary-entity',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/dictionary-entity/dictionary-entity-dialog.html',
                    controller: 'DictionaryEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['DictionaryEntity', function(DictionaryEntity) {
                            return DictionaryEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('dictionary-entity', null, { reload: 'dictionary-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('dictionary-entity.delete', {
            parent: 'dictionary-entity',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/dictionary-entity/dictionary-entity-delete-dialog.html',
                    controller: 'DictionaryEntityDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['DictionaryEntity', function(DictionaryEntity) {
                            return DictionaryEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('dictionary-entity', null, { reload: 'dictionary-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
