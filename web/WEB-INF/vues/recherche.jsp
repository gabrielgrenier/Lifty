<%-- 
    Document   : recherche
    Created on : 2018-10-05, 11:49:20
    Author     : sam
--%>

<%@page import="services.Evaluation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lifty | Recherche</title>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" href="#">
    <link rel="stylesheet" href="./static/css/style.css" type="text/css"/>
</head>
    <body id="recherchePanel">
    <%@include  file="menu.jsp" %>

        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8" id="mapContainer">
                <div class="form-group">
                    <label for="filtre">Filtrer par :</label>
                    <select id="filtre">
                        <option>Établissement</option>
                    </select>
                </div>
                <iframe id="mapRecherche" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2793.648181402067!2d-73.5845177840561!3d45.55740247910211!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cc91eace22b9bcf%3A0x18799aed17aa23d9!2sColl%C3%A8ge+de+Rosemont!5e0!3m2!1sfr!2sca!4v1519943892970" width="500" height="350" frameborder="0" style="border:0" allowfullscreen=""></iframe>
                <table class="table table-hover" id="tblRecherche">
                    <thead>
                      <tr>
                        <th id="thImg"></th>
                        <th>Utilisateur</th>
                        <th>Destination</th>
                        <th>Note</th>
                      </tr>
                    </thead>
                    <tbody>
                        <%
                            ProfilDAO pDao = new ProfilDAO();
                            Profil user = (Profil) session.getAttribute("connected");
                            List<Profil> liste = rechercheService.ListeUserAround(user.getEtablissement(), user.isConducteur());
                            for(int i = 0;i<liste.size();i++){ 
                                Profil p = liste.get(i);
                           %>
                      <tr class="rowProfil">
                        <td><a href="?action=afficherProfil&user=<%=p.getId()%>"><img src="<%=p.getImageProfil()%>" class="img-responsive imgProfil" /></a></td>
                        <td><%=p.getUsername()%></td>
                        <td><%=p.getEtablissement()%></td>
                        <td>
                            <% Evaluation e = new Evaluation((float)p.getRating());
                            for(int j = 0; j<e.getEtoilePleine();++j){
                               %><img  class="imageEtoile" src="./static/images/etoiles/4.4.png"><%
                            }
                            if(e.getNote()!=5){
                                if(0.66<e.getRestant()){%><img  class="imageEtoile" src="./static/images/etoiles/3.4.png"><%}
                                else if(0.33<e.getRestant()){%><img  class="imageEtoile" src="./static/images/etoiles/2.4.png"><%}
                                else if(0<e.getRestant()){%><img  class="imageEtoile" src="./static/images/etoiles/1.4.png"><%}
                                else{%><img  class="imageEtoile" src="./static/images/etoiles/0.4.png"><%}
                            }
                            for(int j = 0; j<e.getEtoileVide();++j){
                                %><img  class="imageEtoile" src="./static/images/etoiles/0.4.png"><%
                            }%>
                        </td>
                      </tr>

                      <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    <%@include  file="footer.jsp" %>
    </body>
</html>
<script>
    $('#tblRecherche tr').click(function() {
        var href = $(this).find("a").attr("href");
        if(href) {
            window.location = href;
        }
    });
</script>