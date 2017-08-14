(function() {
    'use strict';
    angular
        .module('cvgeneratorApp')
        .factory('AdditionalInfoEntity', AdditionalInfoEntity);

    AdditionalInfoEntity.$inject = ['$resource'];

    function AdditionalInfoEntity ($resource) {
        var resourceUrl =  'api/additional-info-entities/:id';

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
