function newRadio() {
  document.getElementById("existing").style.display = "none";
  document.getElementById("new").style.display = null; // Revert hide
  document.getElementById("email").readOnly = false;
}

function existingRadio(radio) {
  document.getElementById("email").readOnly = true;
  document.getElementById("new").style.display = "none";
  
  var tds = radio.parentElement.parentElement.children; // radio ➡ td ➡ tr ➡ td[]
  document.getElementById("email").value = tds[1].innerText;
  document.getElementById("active").checked = tds[2].innerText != "❎";
  document.getElementById("first_name").value = tds[3].innerText;
  document.getElementById("last_name").value = tds[4].innerText;
  document.getElementById("password").value = tds[5].title;
  document.getElementById("role").value = tds[6].innerText;
  
  document.getElementById("existing").style.display = null; // Revert hide
}