$(document).ready(function() {
  $('.bloco-conteudo').show('slow');
  efetuaLogin();
});

function efetuaLogin() {
  $('#login').click(function(event) {
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
  })
  .fail(function() {
    console.log("error");
  })
  .always(function() {
    console.log("complete");
  });

}
