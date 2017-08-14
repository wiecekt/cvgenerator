(function() {
    'use strict';

    angular
        .module('cvgeneratorApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('employee-entity', {
            parent: 'entity',
            url: '/employee-entity',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.employeeEntity.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/employee-entity/employee-entities.html',
                    controller: 'EmployeeEntityController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('employeeEntity');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('employee-entity-detail', {
            parent: 'employee-entity',
            url: '/employee-entity/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'cvgeneratorApp.employeeEntity.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/employee-entity/employee-entity-detail.html',
                    controller: 'EmployeeEntityDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('employeeEntity');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'EmployeeEntity', function($stateParams, EmployeeEntity) {
                    return EmployeeEntity.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'employee-entity',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('employee-entity-detail.edit', {
            parent: 'employee-entity-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/employee-entity/employee-entity-dialog.html',
                    controller: 'EmployeeEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['EmployeeEntity', function(EmployeeEntity) {
                            return EmployeeEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('employee-entity.new', {
            parent: 'employee-entity',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/employee-entity/employee-entity-dialog.html',
                    controller: 'EmployeeEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                name: null,
                                surname: null,
                                department: null,
                                division: null,
                                address: null,
                                dateOfBirth: null,
                                email: null,
                                telephone: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('employee-entity', null, { reload: 'employee-entity' });
                }, function() {
                    $state.go('employee-entity');
                });
            }]
        })
        .state('employee-entity.edit', {
            parent: 'employee-entity',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/employee-entity/employee-entity-dialog.html',
                    controller: 'EmployeeEntityDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['EmployeeEntity', function(EmployeeEntity) {
                            return EmployeeEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('employee-entity', null, { reload: 'employee-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('employee-entity.delete', {
            parent: 'employee-entity',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/employee-entity/employee-entity-delete-dialog.html',
                    controller: 'EmployeeEntityDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['EmployeeEntity', function(EmployeeEntity) {
                            return EmployeeEntity.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('employee-entity', null, { reload: 'employee-entity' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
