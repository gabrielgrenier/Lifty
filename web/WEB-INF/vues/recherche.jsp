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
</head>
    <body id="recherchePanel">
        <!-- btn pour tester creation horraire -->
        <form action="./" method="post">
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <input type="submit">
            <input type="hidden" value="createHoraireAff" name="action">
        </form>
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
                    <%
                        ProfilDAO pDao = new ProfilDAO();
                        Profil user = pDao.findById(Integer.parseInt(String.valueOf(request.getAttribute("connecte"))));
                        List<Profil> liste = rechercheService.ListeUserAround(user.getEtablissement(), user.isConducteur());
                        for(int i = 0;i<liste.size();i++){ 
                            Profil p = liste.get(i);
                       %>
                  <tr>
                    <td></td>
                    <td><%=""+p.getUsername()%></td>
                    <td><%=""+p.getEtablissement()%></td>
                    <td><%=""+p.getRating()%></td>
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
    function recherche() {
        var input, filter, container, row, label;
            input = document.getElementById('rechercheBar');
            filter = input.value.toUpperCase();
            container = document.getElementById("usagerListe");
            row = container.getElementsByClassName('row');
        if(filter!==""){
            if(document.getElementById("usagerListe").style.display === "none"){
                $("#usagerListe").animate({height:'toggle'});
            }
            for (i = 0; i < row.length; i++) {
                label = row[i].getElementsByTagName("label")[0];
                if (label.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    row[i].style.display = "";
                } else {
                    row[i].style.display = "none";
                }
            }
        }
        else{
            if(document.getElementById("usagerListe").style.display !== "none"){$("#usagerListe").animate({height:'toggle'});}
        }
    }
</script>