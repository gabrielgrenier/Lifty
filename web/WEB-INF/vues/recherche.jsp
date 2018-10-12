<%-- 
    Document   : recherche
    Created on : 2018-10-05, 11:49:20
    Author     : sam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lifty | Recherche</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" href="#">
    <link rel="stylesheet" href="./static/css/style.css" type="text/css"/>
    <script> 
    $(document).ready(function(){
        // Setter les grandeurs
        $("#panelLogin").animate({right: '10px', width : '300px'});
        $("#panelInscription").animate({right: '10px', width : '300px'});
        $("#panelProfil").animate({right: '10px', width : '300px'});
        
        // Fonctions lorque l'ont clique
        $("#login").click(function(){
            if($("#panelInscription").is(':visible')){$("#panelInscription").animate({height:'toggle'});}
            $("#panelLogin").animate({height:'toggle'});
        });
        $("#inscription").click(function(){
            if($("#panelLogin").is(':visible')){$("#panelLogin").animate({height:'toggle'});}
            $("#panelInscription").animate({height:'toggle'});
        });
        $("#lblLink").click(function(){
            if($("#panelLogin").is(':visible')){$("#panelLogin").animate({height:'toggle'});}
            $("#panelInscription").animate({height:'toggle'});
        });
        $("#profil").click(function(){
            $("#panelProfil").animate({height:'toggle'});
        });
    });
    </script>
</head>
    <body id="recherchePanel">
    <%@include  file="menu.jsp" %>
    <div class="container">
        <div class="row" id="mapContainer">
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="form-group">
                    <label for="filtre">Filtrer par :</label>
                    <select id="filtre">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <iframe id ="mapRecherche" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2793.648181402067!2d-73.5845177840561!3d45.55740247910211!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cc91eace22b9bcf%3A0x18799aed17aa23d9!2sColl%C3%A8ge+de+Rosemont!5e0!3m2!1sfr!2sca!4v1519943892970"  frameborder="0" style="border:0" allowfullscreen=""></iframe>
            </div>
        </div>
        <div class="row" id="tblSecteur">
            <table class="table table-hover">
                <thead>
                  <tr>
                    <th></th>
                    <th>Utilisateur</th>
                    <th>Destination</th>
                    <th>Note</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td></td>
                    <td><%if(request.getParameter("type").equals("passInsc")){%>passager<%}%></td>
                    <td>Rosemont</td>
                    <td>4.2</td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>MCha01</td>
                    <td>Rosemont</td>
                    <td>3.4</td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>GBra</td>
                    <td>Rosemont</td>
                    <td>4</td>
                  </tr>
                </tbody>
              </table>
        </div>
        

    </div>
    <%@include  file="footer.jsp" %>
    </body>
</html>
