(function() {
    'use strict';
    angular
        .module('cvgeneratorApp')
        .factory('EducationEntity', EducationEntity);

    EducationEntity.$inject = ['$resource', 'DateUtils'];

    function EducationEntity ($resource, DateUtils) {
        var resourceUrl =  'api/education-entities/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.educationStartDate = DateUtils.convertLocalDateFromServer(data.educationStartDate);
                        data.educationEndDate = DateUtils.convertLocalDateFromServer(data.educationEndDate);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.educationStartDate = DateUtils.convertLocalDateToServer(copy.educationStartDate);
                    copy.educationEndDate = DateUtils.convertLocalDateToServer(copy.educationEndDate);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.educationStartDate = DateUtils.convertLocalDateToServer(copy.educationStartDate);
                    copy.educationEndDate = DateUtils.convertLocalDateToServer(copy.educationEndDate);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
