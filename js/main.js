(function(){
angular.module('catpreter', []).
  config(function($routeProvider) {
    $routeProvider.
      when('/', {controller: IntroCtrl, templateUrl: 'introduction.html'}).
      when('/intro', {controller: IntroCtrl, templateUrl: 'introduction.html'}).
      when('/bnf', {controller: BNFCtrl, templateUrl: 'bnf.html'}).
      when('/code', {controller: CodeCtrl, templateUrl: 'code.html'}).
      when('/more', {controller: MoreCtrl, templateUrl: 'more.html'}).
      otherwise({redirect: '/'});
  });
 
function IntroCtrl ($scope, $location, $routeParams) {
  navigate('intro');
}

function BNFCtrl ($scope, $location, $routeParams) {
  navigate('bnf');
}

function CodeCtrl ($scope, $location, $routeParams) {
  navigate('code');
}

function MoreCtrl ($scope, $location, $routeParams) {
  navigate('more');
}

function navigate (item) {
  $('.active').removeClass('active');
  $('a[href="#/'+ item +'"]').parent().addClass('active');
};

}());
