var username = sessionStorage.getItem("username")
var url =  "http://localhost:8080/ProyectoFinal-1.0-SNAPSHOT/api/officials/" + username + "/getOwners";

//get data from api for table vet
fetch(url1)
  .then(response => response.json())
  .then(json =>
    tablaListado=$("#tabla1").DataTable({
        "data":json,
        "columns":[
            {"data":"idVisita"},
            {"data":"fec.creacion"},
            {"data":"tipo"},
            {"data":"descripcion"},
            {"data":"vetId"},
            {"data": "petId"}
        ],
        "columnDefs": [ {
          "targets": 6,
          "data": null,
          "defaultContent": "2"
      } ]
      })

   )




