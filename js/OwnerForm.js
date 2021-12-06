var usernameOwner = sessionStorage.getItem("username") 
var passwordOwner = sessionStorage.getItem("password")
var emailOwner = sessionStorage.getItem("email")
var roleOwner = sessionStorage.getItem("role")
var person_id=Math.floor(Math.random() * 100000);
var urlO =
  "http://localhost:8080/ProyectoFinal-1.0-SNAPSHOT/api/owners/"+usernameOwner;
var formOwner = document.getElementById("formOwner");
if(usernameOwner != null){

formOwner.addEventListener("submit", function (e) {
  e.preventDefault();
  var data = new FormData(formOwner);
   
  fetch(urlO, {
    method: 'POST',
    body: JSON.stringify({

      "username":usernameOwner,
      "password":passwordOwner,
      "email": emailOwner,
      "role": roleOwner,
      "person_id":person_id,
      "name":data.get('nameO'),
      "address":data.get('addressO'),
      "neighborhood": data.get('neigborhoodO'),
      
      
       }),
  
       headers: {
        'Content-type': 'application/json',
      },
   
  })
  
    .then((response) => response.text())
    .then((json) => {validate_Owner2(json)});
  });
}


//Funcion que lo lleva a la pagina publica
 
function validate_Owner2 (response){
 
  if(response  == "It was successfully saved by the owner"){
    alert("su Registro a sido exitoso");
    window.location.href = "/components/owner.html"
  }else{
    alert("a ocurrido un problema, porfavor verifique su informacion");
    location.reload();
  }
}



