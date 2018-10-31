<%-- 
    Document   : profil
    Created on : 2018-10-15, 15:00:05
    Author     : usager
--%>
<%@page import="java.sql.Time"%>
<%@page import="java.util.List"%>
<%@page import="classe.Jour"%>
<%@page import="dao.JourDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lifty | Profil</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="./static/css/style.css" type="text/css"/>
    </head>
    <body id="profilBackground">
            <%
            JourDAO dao = new JourDAO();
            List<Jour> listHorraire1 = dao.findAll(1);
            %>

        <%@include  file="menu.jsp" %>
            <div class="container-fluid" id="ProfilContainer">
                <div class="row" id="InformationProfilContainer">
                    <div class="row">
                        <div id="enteteProfil">
                            <div class="col-sm-3">
                                <div id="titreProfil">
                                    Mon compte
                                </div>
                            </div>
                            <div class="col-lg-9">
                                <div id="menuRating">
                                    <div id="test32">
                                        <div id="textEtoile">
                                            Évaluation
                                        </div>
                                        <div style="margin:auto;">
                                            <img  class="imageEtoile" src="./static/images/etoile.png">
                                            <img  class="imageEtoile" src="./static/images/etoile.png">
                                            <img  class="imageEtoile" src="./static/images/etoile.png">
                                            <img  class="imageEtoile" src="./static/images/etoile.png">
                                            <img  class="imageEtoile" src="./static/images/etoile.png">
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <br />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <img  id="imageProfil"  class="img-responsive" src="./static/images/profils/default.png" />
                        </div>
                        <div class="col-lg-8 col-md-6 col-sm-6"   class="textProfil"> 
                              <table class="table table-condensed" id="infoPro">
                                <tbody>
                                  <tr class="TitreProf">
                                    <th>Informations</th>
                                    <td></td>
                                  </tr>
                                  <tr>
                                    <th>Nom du profil:</th>
                                    <td>Maxime Young</td>
                                  </tr>
                                  <tr>
                                    <th>Date d'incription:</th>
                                    <td>2018-10-16</td>
                                  </tr>
                                  <tr>
                                    <th>Dernière connexion:</th>
                                    <td>Il y a 5 jours</td>
                                  </tr>
                                  <tr>
                                    <th>Etablisement:</th>
                                    <td>Rosemont</td>
                                  </tr>
                                  <tr>
                                    <th>Status:</th>
                                    <td>Conducteur</td>
                                  </tr>
                                </tbody>
                              </table>
                        </div>
                    </div>
                    <div class="row"> 
                        <br />
                    </div>
                    <div class="row">
                        <div class="col-lg-3 col-md-4 col-sm-6">
                        </div>
                        <div class="col-lg-8 col-md-6 col-sm-6"   class="textProfil"> 
                              <table class="table table-condensed" id="infoPro">
                                <tbody>
                                  <tr class="TitreProf">
                                    <th>Véhicule</th>
                                    <td></td>
                                  </tr>
                                  <tr>
                                    <th>Modele:</th>
                                    <td></td>
                                  </tr>
                                  <tr>
                                    <th>Année:</th>
                                    <td></td>
                                  </tr>
                                  <tr>
                                    <th>Couleur:</th>
                                    <td></td>
                                  </tr>
                                  <tr>
                                    <th>Fumeur:</th>
                                    <td>Non</td>
                                  </tr>
                                  <tr>
                                    <th>Nombre de place:</th>
                                    <td></td>
                                  </tr>
                                </tbody>
                              </table>
                        </div>
                    </div>
                    <div class="row"> 
                        <br />
                        <div class="col-lg-12 col-md-12 col-sm-12" class="textProfil">
                            <div id="infoPro">
                                <div class="TitreProf">
                                   Horaire 
                                </div>
                                <div id="contProfHoraire">
                                    <table class="table table-hover table-bordered">
                                        <thead>
                                            <tr>
                                                <th style="width:5%;">Heure</th>
                                                <th style="width:19%;">Lundi</th>
                                                <th style="width:19%;">Mardi</th>
                                                <th style="width:19%;" >Mercredi</th>
                                                <th style="width:19%;">Jeudi</th>
                                                <th style="width:19%;" >Vendredi</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                        for(int x=8; x<19; x++){ //Création des colonnes dans la table
                                        %>
                                        <tr>
                                            <th scope="row"><%=x%>h</th>
                                        <%
                                            for(int y=0; y<5; y++){
                                                int debut = Integer.valueOf(listHorraire1.get(y).getDebut().split(":")[0]);
                                                int fin = Integer.valueOf(listHorraire1.get(y).getFin().split(":")[0]);
                                        %>
                                                <td style="
                                                    <%  //Style de la case
                                                        if(x>=debut && x<=fin){out.println("");}
                                                        else{out.println("background-color:rgba(0, 0, 0, 0.1)");}
                                                    %>
                                                    ">
                                                    <%  //Si c'est le debut ou la fin
                                                        if(x==debut){out.println("Debut");}
                                                        else if(x==fin){out.println("Fin");}
                                                    %>
                                                </td>
                                               <% } %>
                                            </tr>
                                        <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row"> 
                        <br />
                        <div class="col-lg-12 col-md-6 col-sm-6" class="textProfil">
                            <div id="infoPro">
                                <div class="TitreProf">
                                   Commentaires 
                                </div>
                                <div class="contProf">
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <%@include  file="footer.jsp" %>
    </body>
</html>
