var usernameOwnerp = sessionStorage.getItem("username") 
var passwordOwnerp = sessionStorage.getItem("password")
var emailOwnerp = sessionStorage.getItem("email")
var roleOwnerp = sessionStorage.getItem("role")
var urlOwnerp =
  "http://localhost:8080/ProyectoFinal-1.0-SNAPSHOT/api/owners/"+usernameOwnerp + "/pets";
var formpet = document.getElementById('formpet');
var espercie;
var es;
var data = new FormData(formpet);
espercie =  document.getElementById("addspecies");
es = espercie.options[espercie.selectedIndex].text;
console.log(es);

formpet.addEventListener("submit", function (e) {
    console.log("buenas");
    e.preventDefault();
    fetch(urlOwnerp, {
        method: 'POST',
        body: JSON.stringify({
          "microchip": data.get('microchip'),
          "name": data.get('pname'),
          "species": document.getElementById("addspecies").value,
          "role": roleVet,
          "name": data.get('name'),
          "address": data.get('address'),
          "neighborhood": data.get('neighborhood'),
        }),
        headers: {
          'Content-type': 'application/json',
        },
      })
        .then((response) => response.text())
        .then((json) => {validate_vet2(json)});
    })
