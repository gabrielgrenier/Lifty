<%-- 
    Document   : messagerie
    Created on : Oct 12, 2018, 5:10:15 PM
    Author     : mchausse
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="classe.ListeMessage"%>
<%@page import="classe.Profil"%>
<%@page import="classe.Message"%>
<%@page import="dao.MessageDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Lifty | Recherche</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="shortcut icon" href="#">
        <link rel="stylesheet" href="./static/css/style.css" type="text/css"/>
    </head>
    <body id='messageriePanel'>
        <%@include  file="menu.jsp" %>
        
        <!-- ==== Section des notifications ==== -->
        <%
        if(request.getAttribute("notif1")!=null){
            %>
            <div class="col-lg-4"></div>
            <div class="alert alert-success fade in notif col-lg-4">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <div class='col-lg-2'><strong><i class="far fa-grin-alt"></i></strong></div>
                <div class='col-lg-8'><%=request.getAttribute("notif1")%></div>
            </div>
            <%
        }
        if(request.getAttribute("notif2")!=null){
            %>
            <div class="col-lg-4"></div>
            <div class="alert alert-danger fade in notif col-lg-4">
              <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <div class='col-lg-2'><strong><i class="far fa-grin-alt"></i></strong></div>
                <div class='col-lg-8'><%=request.getAttribute("notif1")%></div>
            </div>
            <%
        }
        %>
        
        <%// ======================  TABLEAU DE MESSAGERIE =====================%>
        <div class="container-fluid">
            <div class='row' id='messagerieContainer'>
                <%// ---- section de gauche ----%>
                <div class='col-lg-4'>
                    <div class='col-lg-12' id='messagesContainer'>
                        <div class='col-lg-12' id='messagesHead'>Messages</div>

                        <%// ---- section avec la liste de message ----%>
                        <div class='col-lg-12' id='messages'>
                            <%
                            Message messageSelect;
                            MessageDAO mDao = new MessageDAO();
                            Profil sender;
                            Message message;
                            ListeMessage messages;
                            if(request.getAttribute("messageSelect") != null){
                                messageSelect = mDao.findById(String.valueOf(request.getAttribute("messageSelect")));
                            }
                            else{
                                messageSelect = new Message();
                                messageSelect.setId("");
                            }
                            messages = mDao.findAll(Integer.parseInt(String.valueOf(request.getAttribute("connecte"))));
                            for(int i=0;i<messages.length();i++){
                                sender = mDao.getSender(messages.get(i));
                                message = messages.get(i);
                                // Ouvrir le bon div si un message est selectionner
                                if(messageSelect.getId() == message.getId()){
                                    %>
                                    <div class='unMessageSelect' onclick="ouvrirMessage('<%=message.getId()%>')">
                                    <%
                                }else{
                                    %>
                                    <div class='unMessage' onclick="ouvrirMessage('<%=message.getId()%>')">
                                    <%
                                }
                                %>
                                <form method="post" class="form<%=message.getId()%>">
                                    <input type="hidden" name="messageSelect" value="<%=message.getId()%>">
                                    <input type="hidden" name="action" value="ouvrirMessage"/>
                                    <div class='col-lg-3'>
                                        <div class="imgMessage"><img src="<%=sender.getImageProfil()%>" ></div>
                                    </div>
                                    <div class='col-lg-9'>
                                        <b><%=message.getTitre()%></b>
                                        <br />
                                        <span><%=sender.getUsername()%></span>
                                    </div>
                                </form>
                                <%
                                // Fermer le div en java pour eveter les problemes d'indentations
                                out.print("</div>");
                            }
                            %>
                        </div>
                    </div>
                </div>
                <%
                    // Section de gauche si un message est selectionne
                if(request.getAttribute("messageSelect") != null){
                %>
                <!-- Debut de la section de gauche -->
                <div class='col-lg-8'  id='messageContainer'>
                    <div class=' panel panel-default'>
                        
                        <!-- Heading avec les boutons -->
                        <div class='panel-heading messageHead'>
                            <div class="col-lg-4">
                                <a onclick="nouveauMessage('<%=String.valueOf(request.getAttribute("connecte"))%>','','')">
                                    <span class="glyphicon glyphicon-plus">Nouveau</span>
                                </a>
                            </div>
                            <div class="col-lg-4">
                                <a onclick="nouveauMessage('<%=String.valueOf(request.getAttribute("connecte"))%>','<%=mDao.getSender(messageSelect.getId()).getUsername()%>','<%=messageSelect.getTitre()%>')">
                                    <span class="glyphicon glyphicon-share-alt">Repondre</span>
                                </a>
                            </div>
                            <div class="col-lg-4">
                                <a>
                                    <span class="glyphicon glyphicon-trash">Supprimer</span>
                                </a>
                            </div>
                        </div>
                        
                        <!-- Section pour l'affichage d'un message selectionne -->
                        <div class='panel-body' id="messageBody">
                            <div class="col-lg-12" id="messageEnvoyeur">
                                <label id="messageEnvoyeur"><b>Envoyeur : </b></label><span><%=mDao.getSender(messageSelect.getId()).getUsername()%></span>
                                <hr>
                            </div>
                            <div class="col-lg-12" id="messageTitre">
                                <label id="messageTitre"><b>Titre : </b></label><span><%=messageSelect.getTitre()%></span>
                                <hr>
                            </div>
                            <div class="col-lg-12" id="messageTexte">
                                <p><%=messageSelect.getMessage()%></p>
                            </div>
                        </div>  
                    </div>
                </div><!-- Fin de la section de gauche -->
                <%
                }
                    // Section de gauche si un message est selectionne
                else{
                %>
                
                <!-- Debut de la section de gauche -->
                <div class='col-lg-8'  id='messageContainer'>
                    <div class=' panel panel-default'>
                        
                        <!-- Heading avec les boutons -->
                        <div class='panel-heading messageHead'>
                            <div class="col-lg-4">
                                <a onclick="nouveauMessage('<%=String.valueOf(request.getAttribute("connecte"))%>','','')">
                                <span class="glyphicon glyphicon-plus">Nouveau</span></a>
                            </div>
                        </div>
                        <div class='panel-body' id="messageBody">
                        </div>
                    </div>
                </div>
                <%
                }
                %>
            </div>
        </div>
                
        <%@include  file="footer.jsp" %>
        <script>
            $(document).ready(function(){
                $(".unMessage").mousedown(function(){
                    $(this).css("background","gray");
                    $(this).css("border","inset black 1px");
                });
                $(".unMessage").mouseup(function(){
                    $(this).css("background","white");
                    $(this).css("border","outset black 1px");
                });
                $(".unMessage").hover(function(){
                    $(this).css("background","lightgray");
                });
                $(".unMessage").mouseleave(function(){
                    $(this).css("background","white");
                });
                $("#messages").hover(function(){
                    $(this).css("overflow-y","scroll");
                });
                $("#messages").mouseleave(function(){
                    $(this).css("overflow-y","hidden");
                });
            });
            function ouvrirMessage(id){
                 $(".form"+id).submit();
            }
            function redirigerMessagerie(){
                window.location = "messagerie.jsp";
            }
            function nouveauMessage(idUser,username,titre){
                // Aller chercher le formulaire
                var form = document.getElementById("messageBody");
                
                // Ajouter RE:
                if(titre !== '')titre="RE: "+titre;
                
                // Vider le formulaire
                $("#messageBody").empty();
                
                // Remplir le formulaire
                form.innerHTML+="<form class='form-horizontal' methode='post' action=''>"+
                                    "<div class='col-sm-12 col-lg-12' id='messageEnvoyeur' class='form-group'>"+
                                        "<label class='control-label col-sm-2 col-lg-2'><b>Destinataire: </b></label>"+
                                        "<div class='col-sm-10 col-lg-9'>"+
                                            "<input type='text' class='form-control' value='"+username+"' id='username' name='usernameDestinataire' placeholder='username'>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-lg-12 col-lg-12' id='messageTitre' class='form-group'>"+
                                        "<label class='control-label col-sm-2 col-lg-2'><b>Titre: </b></label>"+
                                        "<div class='col-sm-10 col-lg-9'>"+
                                            "<input type='text' class='form-control' name='titre' value='"+titre+"' id='titre' placeholder='objet du message'>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-lg-12' id='messageTexte' class='form-group'>"+
                                        "<label class='control-label col-sm-2 col-lg-2'><b>Message: </b></label>"+
                                        "<div class='col-sm-10 col-lg-9'>"+
                                            "<textarea class='form-control' rows='10' id='texte' name='texte' ></textarea>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='form-group'>"+
                                        "<input type='hidden' name='action' value='envoyerMessage'/>"+
                                    "</div>"+
                                    "<div class='form-group'>"+
                                        "<input type='hidden' name='connecte' value='"+idUser+"'/>"+
                                    "</div>"+
                                    "<div class='form-group'>"+
                                        "<button type='submit' class='btn btn-primary' id='btnEnvoyerMessage'>Envoyer</button>"+
                                    "</div>"+
                                "</form>";              
            }
        </script>
    </body>
</html>
