export function valida(input) {
  const tipoDeInput = input.dataset.tipo;
  if(validadores[tipoDeInput]) {
    validadores[tipoDeInput](input)
  }
}

const validadores = {
  cpf:input => validaCpf(input)
}

function validaCpf(input) {
  const cpfRecebido = input.value;
}

function formataCPF(cpf) {
  document.getElementById("cpf").addEventListener("keydown", formataCPF);
  const elementoAlvo = cpf;
  const cpfAtual = cpf.value;

  let cpfAtualizado;

  cpfAtualizado = cpfAtual.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/,
    (regex, argumento1, argumento2, argumento3, argumento4) => argumento1 + '.' + argumento2 + '.' + argumento3 + '-' + argumento4)
  elementoAlvo.value = cpfAtualizado;
}