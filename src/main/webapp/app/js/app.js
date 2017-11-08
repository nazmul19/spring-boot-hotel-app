 var hotelModule = angular.module("hotelApp", []);
  hotelModule.controller('DealDashboardCtrl', function($scope, DealService){

    $scope.page = 1;
    $scope.sortBy = undefined;

    $scope.newSearchCriteria = function(){
      if($scope.searchBy == undefined || $scope.searchBy == ''){
        $scope.loadDeals();
      } else {
        DealService.search($scope.searchBy).then(function(data){
          if(data){
            $scope.deals = [data];
          } else {
            $scope.deals = [];
          }
        })  
      }
      
    }

    $scope.sortByChanged = function(newValue){
      $scope.sortBy = newValue;
      $scope.loadDeals();      
    }

    $scope.loadDeals =  function(){
        DealService.getDeals($scope.page, $scope.sortBy).then(function(data){
          $scope.deals = data;
        })
    }

    var init = function(){
      DealService.getStats().then(function(data){
        $scope.stats = data;
      })

      $scope.loadDeals();      

    }

    init();
  });

  hotelModule.factory('DealService', function($http){
  var baseUrl = 'api/hotel-deals/';
  return {
    getStats: function() {
          return $http.get(baseUrl + "stats").then(function(result) { return result.data; });
      },
    getDeals: function(page,sortBy) {
      var param = "list?page="+ page;
      if(sortBy){
        param = param + "&sortBy="+sortBy;
      }
      return $http.get(baseUrl + param).then(function(result) { return result.data; });
    },
    search: function(searchValue) {
      var param = "search?q="+ searchValue;
      return $http.get(baseUrl + param).then(function(result) { return result.data; });
    }
  }
});

hotelModule.directive('searchEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if(event.which === 13) {
                scope.$apply(function (){
                    scope.$eval(attrs.searchEnter);
                });

                event.preventDefault();
            }
        });
    };
});