(function() {
    'use strict';
    angular
        .module('cvgeneratorApp')
        .factory('AbilityEntity', AbilityEntity);

    AbilityEntity.$inject = ['$resource'];

    function AbilityEntity ($resource) {
        var resourceUrl =  'api/ability-entities/:id';

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
