const formularioCheckout = document.querySelector('.formulario-checkout');

formularioCheckout.addEventListener('submit', function(event) {
    event.preventDefault();

    const inputsObrigatorios = document.querySelectorAll('input[required]');
    inputsObrigatorios.forEach(inputObrigatorio => {
        if(!inputObrigatorio.value) {
            inputObrigatorio.classList.add('is-invalid');
        }
    });

});

const inputsObrigatorios = document.querySelectorAll('input[required]');
inputsObrigatorios.forEach(inputObrigatorio => {
    inputObrigatorio.addEventListener('blur', function() {
        if(!inputObrigatorio.value) {
            inputObrigatorio.classList.add('is-invalid');
            inputObrigatorio.classList.remove('is-valid');
        } else {
            inputObrigatorio.classList.remove('is-invalid');
            inputObrigatorio.classList.add('is-valid');
        }
    });
});