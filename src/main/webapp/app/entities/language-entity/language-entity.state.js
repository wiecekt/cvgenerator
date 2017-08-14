(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('language-entity', {
            parent: 'entity',
            url: '/language-entity',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.languageEntity.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/language-entity/language-entities.html',
                    controller: 'LanguageEntityController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('languageEntity');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('language-entity-detail', {
            parent: 'language-entity',
            url: '/language-entity/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.languageEntity.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/language-entity/language-entity-detail.html',
                    controller: 'LanguageEntityDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('languageEntity');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'LanguageEntity', function($stateParams, LanguageEntity) {
                    return LanguageEntity.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'language-entity',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('language-entity-detail.edit', {
            parent: 'language-entity-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/language-entity/language-entity-dialog.html',
                    controller: 'LanguageEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['LanguageEntity', function(LanguageEntity) {
                            return LanguageEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('language-entity.new', {
            parent: 'language-entity',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/language-entity/language-entity-dialog.html',
                    controller: 'LanguageEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                languageName: null,
                                languageLevel: null,
                                certificate: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('language-entity', null, { reload: 'language-entity' });
                }, function() {
                    $state.go('language-entity');
                });
            }]
        })
        .state('language-entity.edit', {
            parent: 'language-entity',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/language-entity/language-entity-dialog.html',
                    controller: 'LanguageEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['LanguageEntity', function(LanguageEntity) {
                            return LanguageEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('language-entity', null, { reload: 'language-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('language-entity.delete', {
            parent: 'language-entity',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/language-entity/language-entity-delete-dialog.html',
                    controller: 'LanguageEntityDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['LanguageEntity', function(LanguageEntity) {
                            return LanguageEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('language-entity', null, { reload: 'language-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
