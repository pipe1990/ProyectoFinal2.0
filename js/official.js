var username = sessionStorage.getItem("username")
var password = sessionStorage.getItem("password")
var url2 =  "http://localhost:8080/ProyectoFinal-1.0-SNAPSHOT/api/officials/" + username + "/getOwners";
var url1 =  "http://localhost:8080/ProyectoFinal-1.0-SNAPSHOT/api/officials/" + username + "/getPets";

//get data from api for table 2 

fetch(url2,{
  method: 'GET',
  headers: headers,
})
fetch(url1)
  .then(response => response.json())
  .then(json =>
    tablaListado=$("#tabla1").DataTable({
        "data":json,
        "columns":[
            {"data":"petId"},
            {"data":"microship"},
            {"data":"name"},
            {"data":"species"},
            {"data":"race"},
            {"data": "size"},
            {"data": "sex"},
            {"data" : ""}
        ],
        "columnDefs": [ {
          "targets": 4,
          "data": null,
          "defaultContent": "2"
      } ]
      })

   )

   var headers = new Headers();
   headers.append('Authorization', 'Basic ' + btoa(username + ":" + password));
//get data from api for table 2 
fetch(url2,{
  method: 'GET',
  headers: headers,
})
  .then(response => response.json())
  .then(json =>
    tablaListado=$("#tabla2").DataTable({
        "data":json,
        "columns":[
          {"data":"address"},
            {"data":"name"},
          {"data":"neighborhood"},
        ],
        "columnDefs": [ {
          "targets": 4,
          "data": null,
        
      } ]
      })

   )



