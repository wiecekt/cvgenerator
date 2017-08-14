(function() {
    'use strict';
    angular
        .module('cvgeneratorApp')
        .factory('LanguageEntity', LanguageEntity);

    LanguageEntity.$inject = ['$resource'];

    function LanguageEntity ($resource) {
        var resourceUrl =  'api/language-entities/:id';

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
