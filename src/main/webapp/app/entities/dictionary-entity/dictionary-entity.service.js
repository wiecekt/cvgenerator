(function() {
    'use strict';
    angular
        .module('cvgeneratorApp')
        .factory('DictionaryEntity', DictionaryEntity);

    DictionaryEntity.$inject = ['$resource'];

    function DictionaryEntity ($resource) {
        var resourceUrl =  'api/dictionary-entities/:id';

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
