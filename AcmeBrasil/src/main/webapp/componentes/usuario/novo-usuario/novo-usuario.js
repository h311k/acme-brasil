$(document).ready(function() {
  eventoSalvarUsuario($('#criar-conta'));
});

function eventoSalvarUsuario(btnSalvar) {
  $(btnSalvar).click(function(event) {
    salvaUsuario();
  });
}

function salvaUsuario() {
  let usuario = {
    email: $('#email').val(),
    senha: $('#senha').val()
  }
  console.log(usuario);
  $.ajax({
    url: '../usuario/salva',
    type: 'POST',
    dataType: 'json',
    data: JSON.stringify(usuario),
    contentType: 'application/json; charset=utf-8'
  })
  .done(function(data) {
    console.log(data);
    //Chamar a tela de login.
  })
  .fail(function(erro) {
    // Exibir modal de erro e botar foco no campo de email
    console.log(erro.entity);
  })
  .always(function() {
    console.log("complete");
  });
}
