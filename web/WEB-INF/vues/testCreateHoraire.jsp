<%-- 
    Document   : testCreateHoraire
    Created on : 2018-10-31, 09:57:53
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <title>Lifty | Create </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../static/css/style.css" type="text/css"/>
    </head>
    </head>
    <body>
        <h1>Création des horraires :</h1>
        <form action="./" method="post">
        <input type="number" name="idCreateHoraire">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr><th style="width:5%; background-color: grey;"></th>
                        <th style="width:19%;">Lundi <input type="checkbox" onchange="removeJour('Lun', this)" id="checkLun"></th>
                        <th style="width:19%;">Mardi <input type="checkbox" onchange="removeJour('Mar', this)" id="checkMar"></th>
                        <th style="width:19%;" >Mercredi <input type="checkbox" onchange="removeJour('Mer', this)" id="checkMer"></th>
                        <th style="width:19%;">Jeudi <input type="checkbox" onchange="removeJour('Jeu', this)" id="checkJeu"></th>
                        <th style="width:19%;" >Vendredi <input type="checkbox" onchange="removeJour('Ven', this)" id="checkVen"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">Début </th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debLun" id="debLun" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debMar" id="debMar" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debMer" id="debMer" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debJeu" id="debJeu" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debVen" id="debVen" required>h</th>
                    </tr>
                    <tr>
                        <th scope="row">Fin </th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finLun" id="finLun" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finMar" id="finMar" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finMer" id="finMer" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finJeu" id="finJeu" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finVen" id="finVen" required>h</th>
                    </tr>
                </tbody>
                <input type="submit" value="Créer" id="subHoraire">
            </table>
            <input type="hidden" value="createHoraire" name="action">
        </form>

    </body>
    <script>
    function validationCreate(){
        var checkbox = document.querySelectorAll('input[type=checkbox]'); 
        var vide = [].filter.call( checkbox, function( el ) {
           return el.checked
        });
        if (checkbox.length == vide.length) {
            document.getElementById("subHoraire").disabled = true;
        }
        else{
            document.getElementById("subHoraire").disabled = false;
        }
    }
    function removeJour(jour, check){ //Permet d'Avoir des jours libres
        var jourDeb = "deb"+jour;
        var jourFin = "fin"+jour;
        
        if(check.checked){
            document.getElementById(jourDeb).required = false;
            document.getElementById(jourFin).required = false;
            document.getElementById(jourDeb).disabled = true;
            document.getElementById(jourFin).disabled = true;
        }
        else{
            document.getElementById(jourDeb).required = true;
            document.getElementById(jourFin).required = true;
            document.getElementById(jourDeb).disabled = false;
            document.getElementById(jourFin).disabled = false;
        }
        validationCreate();
    }
   function uncheck(){ //pour firefox parce que il uncheck pas lors des refresh
        $(':checkbox:checked').prop('checked',false);
   }
</script>
</html>
