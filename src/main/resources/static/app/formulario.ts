export function valida(input): void{
  const tipoInput = input.dataset.tipo

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
  'patternMismatch'
]

const mensagensDeErro = {
  nome : {
      valueMissing: 'O campo nome não pode estar vazio',
      typeMismatch: 'O nome digitado não é válido',
      patternMismatch: 'O nome deve começar com uma letra maiúscula e não deve conter mais de 1 espaço entre os nomes'
  },
  cpf:{
      valueMissing: 'O campo cpf não pode estar vazio',
      patternMismatch: 'O cpf digitado não é válido. Digite apenas os números'
  },
  telefone:{
      valueMissing: 'O campo telefone não pode estar vazio',
      typeMismatch: 'O telefone digitado não é válido',
      patternMismatch: 'Digite apenas os números contendo o ddd e o 9 adicional, ou no seguinte formato:(DDD) 9xxxx-xxxx'
  },
  email: {
      valueMissing: 'O campo email não pode estar vazio',
      typeMismatch: 'O email digitado não é válido',
      patternMismatch: 'O email digitado está imcompleto'
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
      typeMismatch: 'A renda digitada não é válida',
      patternMismatch: 'A renda precisa ser maior que zero'
  }

}

function mostraMensagemDeError(tipoDeInput: string, input:HTMLInputElement): string{

  let mensagem = ''

  tiposDeErro.forEach(erro => {
      if((input.validity[erro])){
          mensagem = `${mensagem + mensagensDeErro[tipoDeInput][erro]};\n`
      }
  })

  return mensagem
}

const inputCpf = document.getElementById("cpf");
inputCpf.addEventListener('input', function (): void {
  const digitado = inputCpf.nodeValue;
  const apenasNumeros = digitado.replace(/\D/g, '');
  inputCpf.nodeValue = apenasNumeros;
  formataCPF(inputCpf);

});

function formataCPF(cpf: HTMLElement): void {
  document.getElementById("cpf").addEventListener("keydown", function () {
    const elementoAlvo = cpf;
  const cpfAtual = cpf.nodeValue;

  let cpfAtualizado;

  cpfAtualizado = cpfAtual.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/,
    (regex: any, argumento1: string, argumento2: string, argumento3: string, argumento4: string) => {
      return argumento1 + '.' + argumento2 + '.' + argumento3 + '-' + argumento4;
    })
  elementoAlvo.nodeValue = cpfAtualizado;
  });
}


const inputTelefone = document.getElementById("telefone");
inputTelefone.addEventListener('input', function (): void {
  const digitado = inputTelefone.nodeValue;

  let cleaned = ('' + digitado).replace(/\D/g, '');
  //Check if the input is of correct length
  let match = cleaned.match(/^(\d{2})(\d{5})(\d{4})$/);
  let telefoneAtualizado = '(' + match[1] + ') ' + match[2] + '-' + match[3]

  inputTelefone.nodeValue = telefoneAtualizado;
});