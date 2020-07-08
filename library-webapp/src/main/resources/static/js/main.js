const number = document.getElementById('number');
const loan = document.getElementById('loan');

loadEventListeners();

// Load all event listeners
function loadEventListeners() {
  // DOM Load event
  document.addEventListener('DOMContentLoaded', disableLoanCreateBtn);

}

function disableLoanCreateBtn(){
    console.log(number);
    console.log(loan);
}