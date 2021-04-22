const form = document.getElementById("form");
const email = document.getElementById("email");
const telephone = document.getElementById("telephone");
const firstName = document.getElementById("firstname");
const surname = document.getElementById("surname");

form.addEventListener('submit', (e) => {
  e.preventDefault();
  
  checkInputs();
});

function checkInputs() {
  // get values from the inputs
  const emailValue = email.value.trim();
  const telephoneValue = telephone.value.trim();
  const firstNameValue = firstName.value.trim();
  const surnameValue = surname.value.trim();

  var countValid = 0;
  
  if(emailValue == ''){
    setErrorFor(email, 'Email cannot be blank');
  }else if(!isEmail(emailValue)){
    setErrorFor(email, 'Email is not valid');
  }else{
    setSuccessFor(email);
    countValid+=1;
  }

  if(telephoneValue == ''){
    setErrorFor(telephone, 'Telephone number cannot be blank');
  }else if(!isInteger(telephoneValue)){
    setErrorFor(telephone, 'Telephone number is not valid');
  }else{
    setSuccessFor(telephone);
    countValid+=1;
  }
  
  if(firstNameValue == ''){
    setErrorFor(firstName, 'First name cannot be blank');
  }else{
    setSuccessFor(firstName);
    countValid+=1;
  }

  if(surnameValue == ''){
    setErrorFor(surname, 'Surname cannot be blank');
  }else{
    setSuccessFor(surname);
    countValid+=1;
  }

  if(countValid == 4){
    var text = "Please confirm the details below: \n\nEmail: " + emailValue + "\nTelephone: " + telephoneValue + "\nFirst Name: " + firstNameValue + "\nSurname: " + surnameValue + "\n";
      if(confirm(text)){
        window.location.href="confirm.html";
      }
  }
}


function setErrorFor(input, message){
  const formControl = input.parentElement; // .form-control
  const small = formControl.querySelector('small');
  
  //add error message inside small
  small.innerText = message;
  
  //add error class
  formControl.className = 'form-control error';
}

function setSuccessFor(input){
  const formControl = input.parentElement; // .form-control
  formControl.className = 'form-control success';
}

function isEmail(email){
  return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

function isInteger(telephone){
  var telephoneArray = telephone.split('');
  var char;
  for(char of telephoneArray){
    if(!parseInt(char)){
      return false;
    }
  }
  return true;
}



