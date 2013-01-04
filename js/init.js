angular.module('catpreter', []).
  config(function($routeProvider) {
  $routeProvider.
    when('/', {controller: IntroCtrl, templateUrl: 'template/intro.html'}).
    when('/intro', {controller: IntroCtrl, templateUrl: 'template/intro.html'}).
    when('/bnf', {controller: BNFCtrl, templateUrl: 'template/bnf.html'}).
    when('/code', {controller: CodeCtrl, templateUrl: 'template/code.html'}).
    when('/more', {controller: MoreCtrl, templateUrl: 'template/more.html'}).
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
