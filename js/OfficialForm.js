var usernameOfficial = sessionStorage.getItem("username");
var passwordOfficial = sessionStorage.getItem("password");
var emailOffical = sessionStorage.getItem("email");
var roleOfficial = sessionStorage.getItem("role");
var urlOf =
  "http://localhost:8080/ProyectoFinal-1.0-SNAPSHOT/api/officials/" +
  usernameOfficial;

var OfficialForm = document.getElementById("formOfficial");

if (usernameOfficial != null) {
  OfficialForm.addEventListener("submit", function (e) {
    e.preventDefault();
    var data = new FormData(OfficialForm);

    fetch(urlOf, {
      method: "POST",

      body: JSON.stringify({
        username: usernameOfficial,
        password: passwordOfficial,
        email: emailOffical,
        role: roleOfficial,
        name: data.get('nameOF'),
      }),

      headers: {
        "Content-type": "application/json",
      },
    })
      .then((response) => response.text())
      .then((json) => validate_Owner2(json));
  });
}
//Funcion que lo lleva a la pagina publica

function validate_Owner2 (response){
  if(response == "The Official was successfully saved"){
    alert("su Registro a sido exitoso");
    window.location.href = "/components/official.html"
  }else{
    alert("Ocurrio un problema, verifique la informacion");
  }
}

