var username = sessionStorage.getItem("username")
var url2 =  "http://localhost:8080/ProyectoFinal-1.0-SNAPSHOT/api/officials/" + username + "/getOwners";
var url1 =  "http://localhost:8080/ProyectoFinal-1.0-SNAPSHOT/api/officials/" + username + "/getOwners";

//get data from api for table 1
fetch(url2)
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
            { "defaultContent": `<button class = "btn buttonBlue" data-bs-toggle="modal" data-bs-target="#modalActualizar">Actualizar</button>` },
            { "defaultContent": `<button class = "btn buttonGreen" data-bs-toggle="modal" data-bs-target="#modalCrearCaso">Crear caso</button>` }
        ],
        "columnDefs": [ {
          "targets": 8,
          "data": null,
          "defaultContent": "2"
      } ]
      })

   )


//get data from api for table 2 
fetch(url2)
  .then(response => response.json())
  .then(json =>
    tablaListado=$("#tabla2").DataTable({
        "data":json,
        "columns":[
            {"data":"caseId"},
            {"data":"fecCreacion"},
            {"data":"tipo"},
            {"data":"descripcion"},
            {"data":"petId"}
        ],
        "columnDefs": [ {
          "targets": 5,
          "data": null,
          "defaultContent": "2"
      } ]
      })

   )



