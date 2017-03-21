function validarEnviarOperaciones() {
    var varTamanoMatriz = Number(document.getElementById("tamanoMatriz").value);
    var varNumeroOperaciones = Number(document.getElementById("numeroOperaciones").value);
    var estadoValidacion = true;

    if (varTamanoMatriz < 1 || varTamanoMatriz > 100) {
        alert("el tamaño de la matriz debe estar entre 1 y 100");
        estadoValidacion = false;

    } else if (Number(varNumeroOperaciones) < 1 || Number(varNumeroOperaciones) > 1000) {
        alert("el tamaño de la matriz debe estar entre 1 y 100");
        estadoValidacion = false;
    }

    if (estadoValidacion) {
        //UPDATE x y z W
        //QUERY  x1 y1 z1 x2 y2 z2
        for (var i = 1; i <= varNumeroOperaciones; i++) {

            var operacionTem = document.getElementById("operacion" + i).value;
            var arrayOperacion = operacionTem.split(" ");
            arrayOperacion[0] = arrayOperacion[0].toLowerCase();

            if (arrayOperacion[0] === "update") {

                if (!validarUpdate(varTamanoMatriz, arrayOperacion, i)) {
                    return null;
                }


            } else if (arrayOperacion[0] === "query") {

                if (!validarQuery(varNumeroOperaciones, arrayOperacion, i)) {
                    return null;
                }


            } else {
                alert("operacion no reconocida");
                return null;

            }

        }

        var url = "http://localhost:8084/CubeSummation2/webresources/CubeResource";

        var data = new Object();
        data.tamanoMatriz = document.getElementById('tamanoMatriz').value;
        data.numeroOperaciones = document.getElementById('numeroOperaciones').value;

        for (var i = 1; i <= Number(document.getElementById('numeroOperaciones').value); i++) {

            eval("data.operacion" + i + "=document.getElementById('operacion'+i).value ");

        }

        var jsonData = JSON.stringify(data);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: url,
            data: jsonData,
            //success: success,
            dataType: 'json'
        }).then(function (respuestaCubo) {

            var j = 0;
            for (var property in respuestaCubo)
            {
                document.getElementById("respuesta" + (j + 1)).innerHTML = respuestaCubo[property];
                j = j + 1;

            }

        });

    }

}

function validarUpdate(varTamanoMatriz, arrayOperacion, i) {
    var estadoValidacion = true;

    if (arrayOperacion.length === 5) {
        var x = Number(arrayOperacion[1]);
        var y = Number(arrayOperacion[2]);
        var z = Number(arrayOperacion[3]);
        var w = Number(arrayOperacion[4]);

        if (x < 1 || x > varTamanoMatriz) {
            alert("error en operacion " + i + " x debe estar entre 1 y " + varTamanoMatriz);
            estadoValidacion = false;
        } else if (y < 1 || y > varTamanoMatriz) {
            alert("error en operacion " + i + " y debe estar entre 1 y " + varTamanoMatriz);
            estadoValidacion = false;
        } else if (z < 1 || z > varTamanoMatriz) {
            alert("error en operacion " + i + " z debe estar entre 1 y " + varTamanoMatriz);
            estadoValidacion = false;
        } else if (w < -10000000000 || w > 10000000000) {
            alert("error en operacion " + i + " z debe estar entre -10000000000 y 10000000000");
            estadoValidacion = false;
        }

    } else {
        alert("numero de parametros erroneo, update debe tener 5 parametros");
        estadoValidacion = false;

    }

    return estadoValidacion;

}

function validarQuery(varNumeroOperaciones, arrayOperacion, i) {
    var estadoValidacion = true;

    if (arrayOperacion.length === 7) {
        var x1 = Number(arrayOperacion[1]);
        var y1 = Number(arrayOperacion[2]);
        var z1 = Number(arrayOperacion[3]);
        var x2 = Number(arrayOperacion[4]);
        var y2 = Number(arrayOperacion[5]);
        var z2 = Number(arrayOperacion[6]);

        if (!(x1 >= 1 && x1 <= x2 && x2 <= varNumeroOperaciones)) {

            alert("error en operacion " + i + " no se cumple con la condicion 1 <= x1 <= x2 <= " + varNumeroOperaciones);
            estadoValidacion = false;
        } else if (!(y1 >= 1 && y1 <= y2 && y2 <= varNumeroOperaciones)) {

            alert("error en operacion " + i + " no se cumple con la condicion 1 <= y1 <= y2 <= " + varNumeroOperaciones);
            estadoValidacion = false;
        } else if (!(z1 >= 1 && z1 <= z2 && z2 <= varNumeroOperaciones)) {

            alert("error en operacion " + i + " no se cumple con la condicion 1 <= z1 <= z2 <= " + varNumeroOperaciones);
            estadoValidacion = false;
        }


    } else {
        alert("numero de parametros erroneo query debe tener 7 paramatro");
        estadoValidacion = false;

    }

    return estadoValidacion;

}

function generarTabla() {
    var NumOperaciones = Number(document.getElementById("numeroOperaciones").value);

    var body = document.getElementsByTagName("body")[0];
    var tabla = document.getElementById("tablaOperacion");

    if (NumOperaciones < 1 && tabla !== null) {
        tabla.parentNode.removeChild(tabla);
        return null;
    }

    if (tabla !== null) {
        tabla.parentNode.removeChild(tabla);
    }

    tabla = document.createElement("table");
    tabla.setAttribute("id", "tablaOperacion");
    tabla.setAttribute("align", "center");
    tabla.setAttribute("class", "table");

    var tblBody = document.createElement("tbody");
    tblBody.setAttribute("class", "table table-hover");


    var hileraTablaOperaciones = document.createElement("tr");
    var celdaCabezaTabalaOperaciones = document.createElement("td");

    var textoCeldaCabeza = document.createTextNode("Operaciones");
    //textoCeldaCabeza.setAttribute("align", "center");
    celdaCabezaTabalaOperaciones.appendChild(textoCeldaCabeza);
    hileraTablaOperaciones.appendChild(celdaCabezaTabalaOperaciones);

    celdaCabezaTabalaOperaciones = document.createElement("td");
    textoCeldaCabeza = document.createTextNode("Respuestas");
    //textoCeldaCabeza.setAttribute("align", "center");
    celdaCabezaTabalaOperaciones.appendChild(textoCeldaCabeza);
    hileraTablaOperaciones.appendChild(celdaCabezaTabalaOperaciones);

    tblBody.appendChild(hileraTablaOperaciones);




    for (var i = 1; i <= NumOperaciones; i++) {

        var hilera = document.createElement("tr");

        var celda = document.createElement("td");

        var textoCelda = document.createTextNode("operacion " + i + "      ");
        celda.appendChild(textoCelda);

        var x = document.createElement("INPUT");
        x.setAttribute("required", "");
        x.setAttribute("type", "text");
        x.setAttribute("name", "operacion" + i);
        x.setAttribute("id", "operacion" + i);
        x.setAttribute("class", "form-control");



        celda.appendChild(x);
        hilera.appendChild(celda);


        celda = document.createElement("td");
        var div = document.createElement("div");
        div.setAttribute("id", "respuesta" + i);
        celda.appendChild(div);
        hilera.appendChild(celda);


        tblBody.appendChild(hilera);
    }

    var hilerafinal = document.createElement("tr");
    hilerafinal.setAttribute("align", "right");
    var celdafinal = document.createElement("td");
    celdafinal.setAttribute("colspan", "2");
    var boton = document.createElement("INPUT");
    boton.setAttribute("type", "button");
    boton.setAttribute("name", "enviar");
    boton.setAttribute("id", "enviar");
    boton.setAttribute("value", "enviar");
    boton.setAttribute("onclick", "validarEnviarOperaciones()");
    boton.setAttribute("class", "btn btn-default");

    celdafinal.appendChild(boton);
    hilerafinal.appendChild(celdafinal);
    tblBody.appendChild(hilerafinal);



    tabla.appendChild(tblBody);

    body.appendChild(tabla);

    tabla.setAttribute("border", "2");
}


