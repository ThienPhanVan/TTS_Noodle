window.onload = ()=>{

    let x = 5;
    let input = document.querySelector('.input-group .counter-input.w-input')
    let buttons = document.querySelectorAll('.input-group .counter-button')

    buttons.forEach(b => {
        b.addEventListener('click', function() {
            let value = +input.value;

            if (this.classList.contains('counter-up')) {
                value += x
            } else if (value > 0) {
                value -= x
            }
            input.value = value
        })
    })
}
