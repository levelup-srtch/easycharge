const formularioCliente = document.querySelector('.formulario-cliente');

formularioCliente.addEventListener('submit', function (event) {
  event.preventDefault();

  const inputsObrigatorios = document.querySelectorAll('input[required]');
  inputsObrigatorios.forEach((inputObrigatorio) => {
    if (!inputObrigatorio.value) {
      inputObrigatorio.classList.add('is-invalid');
    }
  });

});

const inputsObrigatorios = document.querySelectorAll('input[required]');
inputsObrigatorios.forEach((inputObrigatorio) => {
  inputObrigatorio.addEventListener('blur', function () {
    if (!inputObrigatorio.value) {
      inputObrigatorio.classList.add('is-invalid');
      inputObrigatorio.classList.remove('is-valid');
    } else {
      inputObrigatorio.classList.remove('is-invalid');
      inputObrigatorio.classList.add('is-valid');
    }
  });
});


const inputCpf = document.getElementById("cpf");
inputCpf.addEventListener('input', function () {
  const digitado = inputCpf.value;
  const apenasNumeros = digitado.replace(/\D/g, '');
  inputCpf.value = apenasNumeros;
  formataCPF(inputCpf);

});

function formataCPF(cpf) {
  document.getElementById("cpf").addEventListener("keydown", formataCPF);
  const elementoAlvo = cpf;
  const cpfAtual = cpf.value;

  let cpfAtualizado;

  cpfAtualizado = cpfAtual.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/,
    (regex, argumento1, argumento2, argumento3, argumento4) => {
      return argumento1 + '.' + argumento2 + '.' + argumento3 + '-' + argumento4;
    })
  elementoAlvo.value = cpfAtualizado;
}