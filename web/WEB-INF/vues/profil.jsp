<%-- 
    Document   : profil
    Created on : 2018-10-15, 15:00:05
    Author     : usager
--%>
<%@page import="services.Evaluation"%>
<%@page import="classe.Critique"%>
<%@page import="dao.CritiqueDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.Time"%>
<%@page import="java.util.List"%>
<%@page import="classe.Jour"%>
<%@page import="dao.JourDAO"%>
<%@page import="services.Evaluation"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./static/css/style.css" type="text/css"/>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body id="profilBackground">
            <%
            JourDAO dao = new JourDAO();
            ProfilDAO paDao = new ProfilDAO();
            CritiqueDAO cDao = new CritiqueDAO();
            //Profil currentUser = (Profil)request.getSession().getAttribute("connected");
            List<Jour> listHorraire1 = dao.findAll(1);
            Profil profil;
            List<Critique> listeCritique = null;
            try{
                if(((request.getParameter("user")==null&&request.getAttribute("userC")==null))||Integer.parseInt(String.valueOf(request.getParameter("user")))==((Profil)session.getAttribute("connected")).getId()){
                    profil = (Profil) session.getAttribute("connected") ;
                    listeCritique = cDao.findByIdUserReceveur(profil.getId());
                }
                else{
                    if(request.getParameter("user")!=null){
                        profil = paDao.findById(Integer.parseInt(String.valueOf(request.getParameter("user"))));
                    }
                    else{
                       profil = paDao.findById(Integer.parseInt(String.valueOf(request.getAttribute("userC")))); 
                    }
                    listeCritique = cDao.findByIdUserReceveur(profil.getId());
                }
            } 
            catch (Exception e) {
                 profil=null;
            }
            Evaluation e;
            %>

        <%@include  file="menu.jsp" %>
            <div class="container-fluid" id="ProfilContainer">
                <div class="row" id="InformationProfilContainer">
                    <%if(profil!=null){%>
                    <div class="row">
                        <div id="enteteProfil">
                            <div class="col-lg-4 col-md-8 col-sm-8">
                                <div id="titreProfil">
                                    <% // Affiche sur quel profil on se trouve
                                    if(profil.getId()==((Profil)session.getAttribute("connected")).getId()){%>
                                        Mon compte
                                    <%}else{%>
                                    Profil de @<%=profil.getUsername()%>
                                    <%}%>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-4 col-sm-4">
                                <div id="menuRating">
                                    <div id="test32">
                                        <div id="textEtoile">
                                           <span id="evaluation">Évaluation :</span>
                                        </div>
                                        <div id="boiteEtoile" style="margin:auto;">
                                            <% e = new Evaluation((float)profil.getRating());
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
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-3 col-md-4 col-sm-5">
                            <img  id="imageProfil"  class="img-responsive" src="./static/images/profils/default.png" />
                        </div>
                        <div class="col-lg-8 col-md-6 col-sm-6"   class="textProfil"> 
                              <table class="table table-condensed" id="infoPro">
                                <tbody>
                                  <% // Permet de savoir si c'est le compte de lutilisateur ou un autre
                                  if(profil.getId()==((Profil)session.getAttribute("connected")).getId()){
                                    // Permet de savoir si l'information du profil est en modification
                                  if(!("modifierInfo".equals(request.getParameter("modi"))||"erreur".equals((String)request.getAttribute("modInf")))){%>
                                  <tr class="TitreProf">
                                    <th>Informations <a href="?action=modInformationProfil&modi=modifierInfo" class="fa fa-pencil" style="font-size:19px;color:white"></a></th>
                                    <td></td>
                                  </tr>
                                  <tr>
                                    <th>Email:</th>
                                    <td><%=profil.getEmail()%></td>
                                  </tr>
                                  <tr>
                                    <th>Nom du profil:</th>
                                    <td><%=profil.getPrenom()%><%=" "+profil.getNom()%></td>
                                  </tr>
                                  <tr>
                                    <th>Username:</th>
                                    <td><%=profil.getUsername()%></td>
                                  </tr>
                                  <tr>
                                    <th>Date d'incription:</th>
                                    <td><%=profil.getDateInscription()%></td>
                                  </tr>
                                  <tr>
                                    <th>Dernière connexion:</th>
                                    <td><%
                                            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                            Date today = sm.parse(sm.format(new Date()));
                                            Date derniereCo = sm.parse(profil.getDateConnexion());
                                            long temps = today.getTime()-derniereCo.getTime();
                                            long Minutes = temps / (60 * 1000) % 60;
                                            long Heures = temps / (60 * 60 * 1000) % 24;
                                            long Jours = temps / (24 * 60 * 60 * 1000);
                                            long Mois = temps / (24 * 60 * 60 * 1000*30);
                                            long Annees = temps / (24 * 60 * 60 * 1000 * 30 *12);
                                            if (Annees > 1){
                                                out.println("Il y plus de "+Annees+" ans");
                                            }
                                            else if (Mois > 1){
                                                out.println("Il y plus de "+Mois+" mois");
                                            }
                                            else if (Jours > 1){
                                                out.println("Il y plus de "+Jours+" jours");
                                            }
                                            else if (Heures > 1){
                                                out.println("Il y plus de "+Heures+" heures");
                                            }
                                            else if (Minutes > 1){
                                                out.println("Il y plus de "+Minutes+" minutes");
                                            }
                                            else{
                                                out.println("Il y a moins d'une minute");
                                            }
                                        %>
                                    </td>
                                  </tr>
                                  <tr>
                                    <th>Etablisement:</th>
                                    <td><%
                                        if(profil.getEtablissement()==null ){
                                            out.println("Non défini");
                                        }
                                        else{
                                            out.println(profil.getEtablissement());
                                        }%></td>
                                  </tr>
                                  <tr>
                                    <th>Code Postal:</th>
                                    <td><%
                                        if(profil.getCodePostal()==null ){
                                            out.println("Non défini");
                                        }
                                        else{
                                            out.println(profil.getCodePostal());
                                        }%></td>
                                  </tr>
                                  <tr>
                                    <th>Status:</th>
                                    <td>
                                        <%
                                        if(profil.isConducteur()){
                                            out.println("Conducteur");
                                        }
                                        else{
                                            out.println("Passager");
                                        }%>
                                    </td>
                                  </tr>
                                  <%}
                                  else{%>
                                  <form method="get" action="./">
                                  <tr class="TitreProf">
                                    <th>Informations</th>
                                    <td></td>
                                  </tr>
                                  <tr>
                                    <th>Email :</th>
                                    <td><input type="text" name="email" value="<%=profil.getEmail()%>" /><br />
                                        <%if(request.getAttribute("erreurEmail")!=null){%><label class="mErreur"><%out.println(request.getAttribute("erreurEmail"));}%></label></td>
                                  </tr>
                                  <tr>
                                    <th>Prenom :</th>
                                    <td><input type="text" name="prenom" value="<%=profil.getPrenom()%>" /><br />
                                        <%if(request.getAttribute("erreurPre")!=null){%><label class="mErreur"><%out.println(request.getAttribute("erreurPre"));}%></label></td>
                                  </tr>
                                  <tr>
                                    <th>Nom :</th>
                                    <td><input type="text" name="nom" value="<%=profil.getNom()%>" /><br />
                                        <%if(request.getAttribute("erreurNom")!=null){%><label class="mErreur"><%out.println(request.getAttribute("erreurNom"));}%></label></td>
                                  </tr>
                                  <tr>
                                    <th>Mot de passe :</th>
                                    <td><input type="text" name="mdp" value="" /><br />
                                        <%if(request.getAttribute("erreurMdp")!=null){%><label class="mErreur"><%out.println(request.getAttribute("erreurMdp"));}%>
                                        <%if(request.getAttribute("erreurMdp2")!=null){%><label class="mErreur"><%out.println(request.getAttribute("erreurMdp2"));}%></label></td>
                                  </tr>
                                  <tr>
                                    <th>Répétez le mot de passe :</th>
                                    <td><input type="text" name="rmdp" value="" /><br />
                                        <%if(request.getAttribute("erreurRmdp")!=null){%><label class="mErreur"><%out.println(request.getAttribute("erreurRmdp"));}%></label></td>
                                  </tr>
                                  <tr>
                                    <th>Etablisement:</th>
                                    <td><input type="text" name="etablissement" value="<%=profil.getEtablissement()%>" /><br />
                                        <%if(request.getAttribute("erreurEta")!=null){%><label class="mErreur"><%out.println(request.getAttribute("erreurEta"));}%></label></td>
                                  </tr>
                                  <tr>
                                    <th>Code Postal:</th>
                                    <td><input type="text" name="codePostal" value="<%=profil.getCodePostal()%>" /><br />
                                        <%if(request.getAttribute("erreurCode")!=null){%><label class="mErreur"><%out.println(request.getAttribute("erreurCode"));}%></label></td>
                                  </tr>
                                  <tr>
                                    <th>Status:</th>
                                    <td>
                                        <select name="role" selected="selected">
                                            <%
                                            if(profil.isConducteur()){%>
                                            <option value="Conducteur">Conducteur</option>
                                            <option value="Passager">Passager</option>
                                            <%} else{
                                            %>
                                            <option value="Passager">Passager</option>
                                            <option value="Conducteur">Conducteur</option>
                                            <%
                                            }%>
                                        </select>
                                    </td>
                                  </tr>
                                    <input type="hidden" name="action" value="modInformationProfil">
                                    <td style="text-align:center;"><input type="submit" value="Enregistrer" /></td>
                                  </form>
                                  <form method="get" action="./">
                                    <input type="hidden" name="action" value="afficherProfil">
                                    <td style="text-align:center;"><input type="submit" value="Annuler" /></td>
                                  </form>
                                  <%}}

                                // Afficher le Pofil d'un autre utilisateur
                                else{%>
                                 <tr class="TitreProf">
                                                <th>Informations</a></th>
                                                <td></td>
                                              </tr>

                                              <%if(profil.isPublicNom()&&profil.isPublicPrenom()){%>
                                              <tr>
                                                <th>Nom du profil:</th>
                                                <td><%=profil.getPrenom()%><%=" "+profil.getNom()%></td>
                                              </tr>
                                              <%}%>
                                              <tr>
                                                <th>Username:</th>
                                                <td><%=profil.getUsername()%></td>
                                              </tr>
                                              <tr>
                                                <th>Date d'incription:</th>
                                                <td><%=profil.getDateInscription()%></td>
                                              </tr>
                                              <tr>
                                                <th>Dernière connexion:</th>
                                                <td><%
                                                        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                                        Date today = sm.parse(sm.format(new Date()));
                                                        Date derniereCo = sm.parse(profil.getDateConnexion());
                                                        long temps = today.getTime()-derniereCo.getTime();
                                                        long Minutes = temps / (60 * 1000) % 60;
                                                        long Heures = temps / (60 * 60 * 1000) % 24;
                                                        long Jours = temps / (24 * 60 * 60 * 1000);
                                                        long Mois = temps / (24 * 60 * 60 * 1000*30);
                                                        long Annees = temps / (24 * 60 * 60 * 1000 * 30 *12);
                                                        if (Annees > 1){
                                                            out.println("Il y plus de "+Annees+" ans");
                                                        }
                                                        else if (Mois > 1){
                                                            out.println("Il y plus de "+Mois+" mois");
                                                        }
                                                        else if (Jours > 1){
                                                            out.println("Il y plus de "+Jours+" jours");
                                                        }
                                                        else if (Heures > 1){
                                                            out.println("Il y plus de "+Heures+" heures");
                                                        }
                                                        else if (Minutes > 1){
                                                            out.println("Il y plus de "+Minutes+" minutes");
                                                        }
                                                        else{
                                                            out.println("Il y a moins d'une minute");
                                                        }
                                                    %>
                                                </td>
                                              </tr>
                                              <tr>
                                                <th>Etablisement:</th>
                                                <td><%
                                                    if(profil.getEtablissement()==null ){
                                                        out.println("Non défini");
                                                    }
                                                    else{
                                                        out.println(profil.getEtablissement());
                                                    }%></td>
                                              </tr>
                                              <tr>
                                                <th>Status:</th>
                                                <td>
                                                    <%
                                                    if(profil.isConducteur()){
                                                        out.println("Conducteur");
                                                    }
                                                    else{
                                                        out.println("Passager");
                                                    }%>
                                                </td>
                                              </tr>
                                <%}%>
                                </tbody>
                              </table>
                        </div>
                    </div>
                    <div class="row">
                        <div id="menu_button" class="col-lg-3 col-md-4 col-sm-5">
                            <% // Permet de savoir si c'est le compte de lutilisateur ou un autre
                            if(profil.getId()==((Profil)session.getAttribute("connected")).getId()){%>
                            <form method="post" action="./">
                                <input type="hidden" name="action" value="preferenceMod" />
                                <button type="submit" class="bt_mod btn btn-default">Modification des préférences</button>
                            </form>
                           <%}%>
                        </div>
                        <%if(profil.isConducteur()){%>
                        <div class="col-lg-8 col-md-6 col-sm-6"   class="textProfil"> 
                              <table class="table table-condensed" id="infoPro">
                                <tbody>
                                  <%
                                  if(profil.isConducteur()){
                                  // Permet de savoir si lu'tilisateur a un vehicule
                                  if(profil.getVehicule()!=null){
                                   // Permet de savoir si c'est le compte de lutilisateur ou un autre
                                    if(profil.getId()==((Profil)session.getAttribute("connected")).getId()){
                                      // Permet de savoir si le vehicule du profil est en modification
                                            if(!"modifierVehi".equals(request.getParameter("modi"))){%>
                                                <tr class="TitreProf">
                                                  <th>Véhicule <a href="?action=modVéhiculProfil&modi=modifierVehi" class="fa fa-pencil" style="font-size:19px;color:white"></a></th>
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
                                            <%}
                                            else{%>
                                                <tr class="TitreProf">
                                                  <th>Véhicule</a></th>
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
                                          <%}
                                        }
                                        else{%>
                                           <tr class="TitreProf">
                                              <th>Véhicule</a></th>
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
                                        <%}
                                    }else{
                                        if(profil.getId()==((Profil)session.getAttribute("connected")).getId()){%>
                                            <tr class="TitreProf">
                                              <th>Véhicule <a href="?action=modVéhiculProfil&modi=modifierVehi" class="fa fa-plus" style="font-size:19px;color:white"></a></th>
                                              <td></td>
                                            </tr>
                                            <tr>
                                              <th>Vous n'avez pas ajouter de véhicule !</th>
                                              <td></td>
                                            </tr>
                                        <%}else{%>
                                            <tr class="TitreProf">
                                              <th>Véhicule</a></th>
                                              <td></td>
                                            </tr>
                                            <tr>
                                              <th>L'utilisateur n'a pas de véhicule !</th>
                                              <td></td>
                                            </tr>
                                        <%}%>
                                    <%}
                                    }%>
                                </tbody>
                              </table>
                        </div>
                        <%}%>
                    </div>
                    <div class="row"> 
                        <div class="col-lg-12 col-md-12 col-sm-12" class="textProfil">
                            <div id="infoPro">
                                <div class="TitreProf">
                                   Horaire <a href="?action=createHoraireAff" style="float:right; margin-right:1em;"><span class="glyphicon glyphicon-edit"></span></a>
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
                        <div class="textProfil">
                            <div id="infoPro">
                                <% if(profil.getId()==((Profil)session.getAttribute("connected")).getId()){%>
                                    <div class="TitreProf">
                                       Commentaires
                                    </div>
                                <%}
                                else{%>
                                    <div class="TitreProf">
                                        Commentaires <a href="?action=ajouterCom&user=<%=profil.getId()%>" class="fa fa-pencil" style="font-size:19px;color:white"></a>
                                    </div>
                                <%}%>
                                <div id="commentaire_box">
                                    <%if(("add".equals(request.getAttribute("Commentaire"))) && !(Integer.parseInt(String.valueOf(request.getParameter("user")))==((Profil)session.getAttribute("connected")).getId())){%>
                                    <div id="ajoutCommentaire">
                                        <div class="container-fluid critique">
                                            <form method="post" action="./">
                                                Note (0 et 5): <input type="text" name="evaluation" value="" /><br />
                                                Description: <input type="text" name="commentaire" value="" /><br />
                                                <input type="hidden" name="user" value="<%=profil.getId()%>" />
                                                <input type="hidden" name="action" value="ajouterCom" />
                                                <input type="submit" value="Créer" />
                                            </form>
                                            <form method="post" action="./">
                                                <input type="hidden" name="user" value="<%=profil.getId()%>" />
                                                <input type="hidden" name="action" value="afficherProfil" />
                                                <input type="submit" value="Annuler" />
                                            </form>
                                        </div>
                                    </div>
                                    <br />
                                    <%}%>
                                    <%
                                        if(listeCritique.size() > 0){
                                            Critique critique;
                                            System.out.println(listeCritique.size());
                                            for(int i = 0;i<listeCritique.size();i++){
                                                critique = listeCritique.get(i);%>
                                                <div class="container-fluid critique">
                                                    <div class="barreHautCritique">
                                                        <div class="imageProfilC">
                                                            <img  class="imageProfilCritique" src="./static/images/profils/default.png" />
                                                        </div>
                                                        <div class="userCritique">
                                                            @<%=(paDao.findById(critique.getEnvoyeurID())).getUsername()%>
                                                        </div>
                                                        <div class="noteCritique">
                                                            <% e = new Evaluation((float)critique.getNote());
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
                                                        </div>
                                                    </div>
                                                    <div class="millieuCritique">
                                                        <div class="contenuCritique">
                                                            <%=critique.getCommentaire()%>
                                                        </div>
                                                    </div>
                                                    <div class="barreBasCritique">
                                                        <span class="reportCritique">
                                                            <input class="btn btn-danger report" type="submit" value="Signaler">
                                                        </span>
                                                        <span class="barreLike">
                                                            <span>
                                                                <a class="glyphicon glyphicon-thumbs-up likeCritique"></a> <%=critique.getLike()%>
                                                            </span>
                                                            <span>
                                                                <a class="glyphicon glyphicon-thumbs-down dislikeCritique"></a> <%=critique.getDislike()%>
                                                            </span>
                                                        </span>
                                                    </div>
                                                </div>
                                                <br />
                                    <%      }
                                        }
                                        else if(!"add".equals(request.getAttribute("Commentaire")) && listeCritique.size() <= 0){%>
                                            <div class="container-fluid critique">
                                                <span style="color:black;">Il n'y a pas de critique !</span>
                                            </div>
                                            <%
                                        }
                                    %>
                                </div>
                            </div>
                        </div>
                    </div>
                     <%}else{%>
                        <h1>Le profil que vous tentez d'accéder n'est pas valide ou n'existe pas !</h1>
                     <%}%>
                </div>
            </div>
        <%@include  file="footer.jsp" %>
    </body>
</html>
