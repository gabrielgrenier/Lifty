<%-- 
    Document   : testCreateHoraire
    Created on : 2018-10-31, 09:57:53
    Author     : gabri
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="classe.Jour"%>
<%@page import="dao.JourDAO"%>
<%@page import="classe.Avertissement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./static/css/style.css" type="text/css"/>
    </head>
    </head>
    <body onLoad="uncheck()" id="profilBackground">
        <% 
            JourDAO joursDao = new JourDAO();
            List<Jour> listeJours = joursDao.findAll(174);
        %>
        <%@include  file="menu.jsp" %>            <!-- Si il y a un message à montrer -->
            <c:if test="${ !empty sessionScope['avertissement']}" >
                <c:set var = "avert" value = "${sessionScope['avertissement']}"/>
                <c:remove var="avertissement" scope="session" />
                <div class="row">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-8" style="margin:10em 0em -10em 0em;">
                        <c:if test="${ avert.getType()=='erreur' && avert!=''}" > <!-- si cest une erreur -->
                            <div class="alert alert-danger">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Erreur!</strong> ${avert.getMessage()}
                            </div>
                        </c:if>
                        <c:if test="${ avert.getType()=='succes' && avert!=''}" > <!-- si cest un succes -->
                            <div class="alert alert-success">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Succès!</strong> ${avert.getMessage()}
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:if>
        <div class="col-lg-2"></div><!-- Margin -->
        <div class="col-lg-8 contenuHoraire">
            <h1 style="color:white">Modification de votre horraire : </h1>
            <form action="./" method="post">
                <table class="table table-bordered tableHoraire">
                    <thead>
                        <tr>
                            <th style="width:5%;"></th>
                            <th style="width:19%;">Lundi<input type="checkbox" onchange="removeJour('Lun', this)" id="checkLun"></th>
                            <th style="width:19%;">Mardi<input type="checkbox" onchange="removeJour('Mar', this)" id="checkMar"></th>
                            <th style="width:19%;" >Mercredi <input type="checkbox" onchange="removeJour('Mer', this)" id="checkMer"></th>
                            <th style="width:19%;">Jeudi <input type="checkbox" onchange="removeJour('Jeu', this)" id="checkJeu"></th>
                            <th style="width:19%;" >Vendredi <input type="checkbox" onchange="removeJour('Ven', this)" id="checkVen"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <%
                                //Debuts
                                int debLun = Integer.parseInt(listeJours.get(0).getDebut().substring(0, 2));
                                int debMar = Integer.parseInt(listeJours.get(1).getDebut().substring(0, 2));
                                int debMer = Integer.parseInt(listeJours.get(2).getDebut().substring(0, 2));
                                int debJeu = Integer.parseInt(listeJours.get(3).getDebut().substring(0, 2));
                                int debVen = Integer.parseInt(listeJours.get(4).getDebut().substring(0, 2));
                                //Fins
                                int finLun = Integer.parseInt(listeJours.get(0).getFin().substring(0, 2));
                                int finMar = Integer.parseInt(listeJours.get(1).getFin().substring(0, 2));
                                int finMer = Integer.parseInt(listeJours.get(2).getFin().substring(0, 2));
                                int finJeu = Integer.parseInt(listeJours.get(3).getFin().substring(0, 2));
                                int finVen = Integer.parseInt(listeJours.get(4).getFin().substring(0, 2));
                            %>
                            <th scope="row">Début</th>
                            <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debLun" id="debLun" value="<%= (debLun == 0) ? "" : debLun %>" required>h</th>
                            <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debMar" id="debMar" value="<%= (debMar == 0) ? "" : debMar %>" required>h</th>
                            <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debMer" id="debMer" value="<%= (debMer == 0) ? "" : debMer %>" required>h</th>
                            <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debJeu" id="debJeu" value="<%= (debJeu == 0) ? "" : debJeu %>" required>h</th>
                            <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debVen" id="debVen" value="<%= (debVen == 0) ? "" : debVen %>" required>h</th>
                        </tr>
                        <tr>
                            <th scope="row">Fin </th>
                            <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finLun" id="finLun" value="<%= (finLun == 0) ? "" : finLun %>" required>h</th>
                            <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finMar" id="finMar" value="<%= (finMar == 0) ? "" : finMar %>" required>h</th>
                            <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finMer" id="finMer" value="<%= (finMer == 0) ? "" : finMer %>" required>h</th>
                            <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finJeu" id="finJeu" value="<%= (finJeu == 0) ? "" : finJeu %>" required>h</th>
                            <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finVen" id="finVen" value="<%= (finVen == 0) ? "" : finVen %>" required>h</th>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" value="createHoraire" name="action">
                <button type="submit" id="subHoraire" class="btn btn-primary">Confirmer</button>
            </form>
        </div>
    </body>
    <script>
    function validationCreate(){
        var checkbox = document.querySelectorAll('input[type=checkbox]'); 
        var vide = [].filter.call( checkbox, function( el ) {
           return el.checked
        });
        if (checkbox.length === vide.length) {
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
            document.getElementById(jourDeb).value = "";
            document.getElementById(jourFin).value = "";
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
