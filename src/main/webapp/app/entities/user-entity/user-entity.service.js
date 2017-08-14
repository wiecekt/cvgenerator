(function() {
    'use strict';
    angular
        .module('cvgeneratorApp')
        .factory('UserEntity', UserEntity);

    UserEntity.$inject = ['$resource'];

    function UserEntity ($resource) {
        var resourceUrl =  'api/user-entities/:id';

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
