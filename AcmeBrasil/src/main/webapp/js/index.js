$(document).ready(function() {
  redirectLogin();
});

function redirectLogin() {
  $('.desktop').load('componentes/usuario/novo-usuario/novo-usuario.html');
  $.getScript('componentes/usuario/novo-usuario/novo-usuario.js');
}
