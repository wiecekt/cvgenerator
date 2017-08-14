(function() {
    'use strict';
    angular
        .module('cvgeneratorApp')
        .factory('HistoryExperienceEntity', HistoryExperienceEntity);

    HistoryExperienceEntity.$inject = ['$resource', 'DateUtils'];

    function HistoryExperienceEntity ($resource, DateUtils) {
        var resourceUrl =  'api/history-experience-entities/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.historyStartDate = DateUtils.convertLocalDateFromServer(data.historyStartDate);
                        data.historyEndDate = DateUtils.convertLocalDateFromServer(data.historyEndDate);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.historyStartDate = DateUtils.convertLocalDateToServer(copy.historyStartDate);
                    copy.historyEndDate = DateUtils.convertLocalDateToServer(copy.historyEndDate);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.historyStartDate = DateUtils.convertLocalDateToServer(copy.historyStartDate);
                    copy.historyEndDate = DateUtils.convertLocalDateToServer(copy.historyEndDate);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
