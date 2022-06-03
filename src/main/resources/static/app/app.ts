import {valida} from './formulario.js';

const inputs = document.querySelectorAll('input')

inputs.forEach(input => {
    input.addEventListener('blur', function () {
        valida(input)
    })
})
