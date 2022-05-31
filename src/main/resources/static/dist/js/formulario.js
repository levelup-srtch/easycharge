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

const mensagensDeErro = {
  nome: {
    valueMissing: 'O campo nome não pode estar vazio'
  },
  cpf: {
    valueMissing: 'O campo cpf não pode estar vazio'
  },
  telefone: {
    valueMissing: 'O campo telefone não pode estar vazio'
  },
  email: {
    valueMissing: 'O campo email não pode estar vazio',
    typeMismatch: 'O email digitado não é válido'
  },
  rua: {
    valueMissing: 'O campo rua não pode estar vazio'
  },
  numero: {
    valueMissing: 'O campo número não pode estar vazio'
  },
  cidade: {
    valueMissing: 'O campo cidade não pode estar vazio'
  },
  profissao: {
    valueMissing: 'O campo profissão não pode estar vazio'
  },
  renda: {
    valueMissing: 'O campo renda não pode estar vazio'
  }
}

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


const inputTelefone = document.getElementById("telefone");
inputTelefone.addEventListener('input', function () {
  const digitado = inputTelefone.value;

  let cleaned = ('' + digitado).replace(/\D/g, '');
  //Check if the input is of correct length
  let match = cleaned.match(/^(\d{2})(\d{5})(\d{4})$/);
  let telefoneAtualizado = '(' + match[1] + ') ' + match[2] + '-' + match[3]

  inputTelefone.value = telefoneAtualizado;
});