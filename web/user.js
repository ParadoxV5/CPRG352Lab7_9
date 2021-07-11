function newRadio() {
  document.getElementById("existing").style.display = "none";
  document.getElementById("new").style.display = null; // Revert
}

function existingRadio(radio) {
  document.getElementById("new").style.display = "none";
  document.getElementById("existing").style.display = null; // Revert
  
  //TODO: radio
}

document.onload = function() {
  document.querySelector("select#role").selectedIndex = -1;
}