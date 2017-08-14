(function() {
    'use strict';
    angular
        .module('cvgeneratorApp')
        .factory('ProjectEntity', ProjectEntity);

    ProjectEntity.$inject = ['$resource'];

    function ProjectEntity ($resource) {
        var resourceUrl =  'api/project-entities/:id';

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
