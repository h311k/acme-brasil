$(document).ready(function() {
  eventoLogin($('#login'));
});

function eventoLogin(btnLogin) {
  $(btnLogin).click(function(event) {
    autenticaUsuario();
  });
}

function autenticaUsuario() {
  let usuario = {
    email: $('#email').val(),
    senha: $('#senha').val()
  }
  $.ajax({
    url: '../usuario/autentica',
    type: 'POST',
    dataType: 'json',
    data: JSON.stringify(usuario),
    contentType: 'application/json; charset=utf-8'
  })
  .done(function(data) {
    console.log(data);
    $('.desktop').load('componentes/admin/mail/novo-mail.html');
    $.getScript('componentes/admin/mail/novo-mail.js');
  })
  .fail(function(erro) {
    console.log(erro);
  })
  .always(function() {
    console.log("complete");
  });

}
