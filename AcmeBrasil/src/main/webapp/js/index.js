$(document).ready(function() {
  redirectLogin();
});

function redirectLogin() {
  $('.desktop').load('componentes/login/login.html');
  $.getScript('componentes/login/login.js');
}
