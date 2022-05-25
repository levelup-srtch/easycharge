function formataCPF(input) {
    const cpfFormatado = input.value.replace(/\D/g, '');

    let cpfAtualizado;

    cpfAtualizado = cpfAtual.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/,
      function (regex, argumento1, argumento2, argumento3, argumento4) {
        return argumento1 + '.' + argumento2 + '.' + argumento3 + '-' + argumento4;
      })
    elementoAlvo.value = cpfAtualizado;
  }