var loginbtn = document.getElementById("login_btn");
var username = document.getElementById("username");
var password = document.getElementById("password");
var form = document.getElementById("loginForm");
var user;
var psw;

var urlIndex = "http://localhost:8080/ProyectoFinal-1.0-SNAPSHOT/api/user";


loginbtn.addEventListener('click', () => {

    sessionStorage.setItem('username', username.value);
    sessionStorage.setItem('password', password.value);

    user = sessionStorage.getItem('username');
    psw = sessionStorage.getItem('password');

    console.log(user);
    console.log(psw);

    var headers = new Headers();

    headers.append('Content-Type', 'text/json');
    headers.append('Authorization', 'Basic ' + btoa(user + ":" + psw));

        fetch(urlIndex, {
            method: 'GET',
            headers: headers,
        })
            .then(response => response.text())
            .then(response => {
              if(response == "owner"){
                window.location.href = "/components/owner.html"
              }else if(response == "official"){
                window.location.href = "/components/official.html"
              }else if(response == "vet"){
                window.location.href = "/components/veterinary.html"
              }else{
                alert("Error! el usuario no existe!")
              }
            });

})
