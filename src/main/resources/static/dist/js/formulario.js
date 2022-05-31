export function valida(input){
  const tipoInput = input.dataset.tipo

  if(validadores[tipoInput]){
      validadores[tipoInput](input)
  }

  if(input.validity.valid){
      input.classList.remove('is-invalid')
      input.classList.add('is-valid')
      input.parentElement.querySelector('.invalid-feedback').innerHTML = ''
  }else {
      input.classList.add('is-invalid')
      input.classList.remove('is-valid')
      input.parentElement.querySelector('.invalid-feedback').innerHTML = mostraMensagemDeError(tipoInput,input)
  }
}


const tiposDeErro = [
  'valueMissing',
  'typeMismatch',
  'customError',
  'patternMismatch'
]

const mensagensDeErro = {
  nome : {
      valueMissing: 'O campo nome não pode estar vazio'
  },
  cpf:{
      valueMissing: 'O campo cpf não pode estar vazio'
  },
  telefone:{
      valueMissing: 'O campo telefone não pode estar vazio',
      typeMismatch: 'O telefone digitado não é válido'
  },
  email: {
      valueMissing: 'O campo email não pode estar vazio',
      typeMismatch: 'o email digitado não é válido'
  },
  rua:{
      valueMissing: 'O campo rua não pode estar vazio'
  },
  numero:{
      valueMissing: 'O campo número não pode estar vazio'
  },
  bairro:{
      valueMissing: 'O campo bairro não pode estar vazio '
  },
  cidade:{
      valueMissing: 'O campo cidade não pode estar vazio'
  },
  profissao:{
      valueMissing: 'O campo profissão não pode estar vazio'
  },
  renda:{
      valueMissing: 'O campo renda não pode estar vazio',
      customError: 'A renda não pode ser zero'
  }

}

function mostraMensagemDeError(tipoDeInput, input){

  let mensagem = ''

  tiposDeErro.forEach(erro => {
      if(input.validity[erro]){
          mensagem = `${mensagem + mensagensDeErro[tipoDeInput][erro]};\n`
      }
  })

  return mensagem
}

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


const inputTelefone = document.getElementById("telefone");
inputTelefone.addEventListener('input', function () {
  const digitado = inputTelefone.value;

  let cleaned = ('' + digitado).replace(/\D/g, '');
  //Check if the input is of correct length
  let match = cleaned.match(/^(\d{2})(\d{5})(\d{4})$/);
  let telefoneAtualizado = '(' + match[1] + ') ' + match[2] + '-' + match[3]

  inputTelefone.value = telefoneAtualizado;
});