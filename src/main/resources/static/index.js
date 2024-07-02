function isMobileDevice() {
    return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent);
}

// Usage example
if (isMobileDevice())
 {
    console.log('The website is open in a mobile device.');
} else {
    console.log('The website is not open in a mobile device.');
}

// about us js
function scrollToSection(sectionId) {
  var section = document.getElementById(sectionId);
  if (section) {
      section.scrollIntoView({ behavior: 'smooth' });
  }
}



// userhome js

function showPopup(message) {
  document.getElementById("welcomeMessage").textContent = message;
  document.getElementById("popup").style.display = "block";
  setTimeout(function() {
      document.getElementById("popup").style.display = "none";
  }, 2000); // Hide the popup after 1 second (1000 milliseconds)
}

function hidePopup() {
  document.getElementById("popup").style.display = "none";
}
showPopup('Welcome, User!');

//verification
function nextInput(event, currentInput) {
  if (event.keyCode === 8 && currentInput.previousElementSibling) {
      currentInput.previousElementSibling.focus();
  } else if (event.keyCode !== 8 && currentInput.nextElementSibling) {
      currentInput.nextElementSibling.focus();
  }
}
//const inputs = document.getElementById("inputs");
 
//inputs.addEventListener("input", function (e) {
 //   const target = e.target;
 //   const val = target.value;
 
  //  if (isNaN(val)) {
   //     target.value = "";
   //     return;
   // }
   // if (val != "") {
    //    const next = target.nextElementSibling;
     //   if (next) {
     //       next.focus();
     //   }
   // }
//});
 
//inputs.addEventListener("keyup", function (e) {
 //   const target = e.target;
  //  const key = e.key.toLowerCase();
 
  //  if (key == "backspace" || key == "delete") {
  //      target.value = "";
   //     const prev = target.previousElementSibling;
   //     if (prev) {
    //        prev.focus();
    //    }
    //    return;
   // }
//});


// verification 


//signup js
// password
var myInput = document.getElementById("psw");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}