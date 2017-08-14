(function() {
    'use strict';
    angular
        .module('cvgeneratorApp')
        .factory('EmployeeEntity', EmployeeEntity);

    EmployeeEntity.$inject = ['$resource'];

    function EmployeeEntity ($resource) {
        var resourceUrl =  'api/employee-entities/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
