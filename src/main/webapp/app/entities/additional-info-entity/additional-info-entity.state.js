(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('additional-info-entity', {
            parent: 'entity',
            url: '/additional-info-entity',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.additionalInfoEntity.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/additional-info-entity/additional-info-entities.html',
                    controller: 'AdditionalInfoEntityController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('additionalInfoEntity');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('additional-info-entity-detail', {
            parent: 'additional-info-entity',
            url: '/additional-info-entity/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.additionalInfoEntity.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/additional-info-entity/additional-info-entity-detail.html',
                    controller: 'AdditionalInfoEntityDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('additionalInfoEntity');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'AdditionalInfoEntity', function($stateParams, AdditionalInfoEntity) {
                    return AdditionalInfoEntity.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'additional-info-entity',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('additional-info-entity-detail.edit', {
            parent: 'additional-info-entity-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/additional-info-entity/additional-info-entity-dialog.html',
                    controller: 'AdditionalInfoEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['AdditionalInfoEntity', function(AdditionalInfoEntity) {
                            return AdditionalInfoEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('additional-info-entity.new', {
            parent: 'additional-info-entity',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/additional-info-entity/additional-info-entity-dialog.html',
                    controller: 'AdditionalInfoEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                additionalInfoName: null,
                                additionalInfoValue: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('additional-info-entity', null, { reload: 'additional-info-entity' });
                }, function() {
                    $state.go('additional-info-entity');
                });
            }]
        })
        .state('additional-info-entity.edit', {
            parent: 'additional-info-entity',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/additional-info-entity/additional-info-entity-dialog.html',
                    controller: 'AdditionalInfoEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['AdditionalInfoEntity', function(AdditionalInfoEntity) {
                            return AdditionalInfoEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('additional-info-entity', null, { reload: 'additional-info-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('additional-info-entity.delete', {
            parent: 'additional-info-entity',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/additional-info-entity/additional-info-entity-delete-dialog.html',
                    controller: 'AdditionalInfoEntityDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['AdditionalInfoEntity', function(AdditionalInfoEntity) {
                            return AdditionalInfoEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('additional-info-entity', null, { reload: 'additional-info-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
