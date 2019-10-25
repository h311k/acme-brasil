$(document).ready(function() {
  eventoSalvaMail($('#criar-conta'));
});

function eventoSalvaMail(btnCriarConta) {
  $(btnCriarConta).click(function(event) {
    salvaMail();
  });
}

function salvaMail() {
  let mail =  {
    remetente: $('#remetente').val(),
    email: $('#email').val(),
    senha: $('#senha').val(),
    host: $('#host').val(),
    porta: $('#porta').val(),
    finalidade: $('#finalidade').val()
  }
  $.ajax({
    url: '../mail/salva',
    type: 'POST',
    dataType: 'json',
    data: JSON.stringify(mail),
    contentType: 'application/json; charset=utf-8'
  })
  .done(function(data) {
    console.log(data);
  })
  .fail(function(erro) {
    // Exibir modal de erro e botar foco no campo de email
    console.log(erro.entity);
  })
  .always(function() {
    console.log("complete");
  });
}
