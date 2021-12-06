var usernameVet = sessionStorage.getItem("username") 
var passwordVet = sessionStorage.getItem("password")
var emailVet = sessionStorage.getItem("email")
var roleVet = sessionStorage.getItem("role")
var vet_id=Math.floor(Math.random() * 100000);
console.log(vet_id)
var urlVet =
  "http://localhost:8080/ProyectoFinal-1.0-SNAPSHOT/api/vets/"+usernameVet;
var formVet = document.getElementById("formVet");
console.log(roleVet)
if (usernameVet != null) {
  formVet.addEventListener("submit", function (e) {
    e.preventDefault();
    var data = new FormData(formVet);
    fetch(urlVet, {
      method: 'POST',
      body: JSON.stringify({
        "username": usernameVet,
        "password": passwordVet,
        "email": emailVet,
        "role": "vet",
        "vet_id":vet_id,
        "name": data.get('name'),
        "address": data.get('addres'),
        "neighborhood": data.get('neighborhood'),
      }),
      headers: {
        'Content-type': 'application/json',
      },
    })
      .then((response) => response.text())
      .then((json) => {validate_vet2(json)});
  })
}

//Funcion que lo lleva a la pagina publica

function validate_vet2 (response){
if(response == "The vet was successfully created"){
  alert("su Registro a sido exitoso");
  window.location.href = "/components/veterinary.html"
}else{
  alert("Ocurrio un problema, verifique la informacion");
  location.reload();
}
}
