(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('history-experience-entity', {
            parent: 'entity',
            url: '/history-experience-entity',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.historyExperienceEntity.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/history-experience-entity/history-experience-entities.html',
                    controller: 'HistoryExperienceEntityController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('historyExperienceEntity');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('history-experience-entity-detail', {
            parent: 'history-experience-entity',
            url: '/history-experience-entity/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.historyExperienceEntity.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/history-experience-entity/history-experience-entity-detail.html',
                    controller: 'HistoryExperienceEntityDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('historyExperienceEntity');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'HistoryExperienceEntity', function($stateParams, HistoryExperienceEntity) {
                    return HistoryExperienceEntity.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'history-experience-entity',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('history-experience-entity-detail.edit', {
            parent: 'history-experience-entity-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/history-experience-entity/history-experience-entity-dialog.html',
                    controller: 'HistoryExperienceEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['HistoryExperienceEntity', function(HistoryExperienceEntity) {
                            return HistoryExperienceEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('history-experience-entity.new', {
            parent: 'history-experience-entity',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/history-experience-entity/history-experience-entity-dialog.html',
                    controller: 'HistoryExperienceEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                historyStartDate: null,
                                historyEndDate: null,
                                isWorking: null,
                                companyName: null,
                                position: null,
                                historyDescription: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('history-experience-entity', null, { reload: 'history-experience-entity' });
                }, function() {
                    $state.go('history-experience-entity');
                });
            }]
        })
        .state('history-experience-entity.edit', {
            parent: 'history-experience-entity',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/history-experience-entity/history-experience-entity-dialog.html',
                    controller: 'HistoryExperienceEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['HistoryExperienceEntity', function(HistoryExperienceEntity) {
                            return HistoryExperienceEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('history-experience-entity', null, { reload: 'history-experience-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('history-experience-entity.delete', {
            parent: 'history-experience-entity',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/history-experience-entity/history-experience-entity-delete-dialog.html',
                    controller: 'HistoryExperienceEntityDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['HistoryExperienceEntity', function(HistoryExperienceEntity) {
                            return HistoryExperienceEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('history-experience-entity', null, { reload: 'history-experience-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
