(function() {
    'use strict';
    angular
        .module('cvgeneratorApp')
        .factory('PermissionEntity', PermissionEntity);

    PermissionEntity.$inject = ['$resource'];

    function PermissionEntity ($resource) {
        var resourceUrl =  'api/permission-entities/:id';

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
