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
    <body id='messageriePanel'>
        <%@include  file="menu.jsp" %>
        
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
                        System.out.println("messageSelect : "+String.valueOf(request.getAttribute("messageSelect")));
                        if(request.getAttribute("messageSelect") != null){
                            messageSelect = mDao.findById(Integer.parseInt(String.valueOf(request.getAttribute("messageSelect"))));
                        }
                        else{
                            messageSelect = new Message();
                            messageSelect.setId(-1);
                        }
                        messages = mDao.findAll(Integer.parseInt(String.valueOf(request.getAttribute("connecte"))));
                        for(int i=0;i<messages.length();i++){
                            sender = mDao.getSender(messages.get(i));
                            message = messages.get(i);
                            // Ouvrir le bon div si un message est selectionner
                            if(messageSelect.getId() == message.getId()){
                                out.print("<div class='unMessageSelect' onclick='ouvrirMessage("+message.getId()+")'>");}
                            else{
                                out.print("<div class='unMessage' onclick='ouvrirMessage("+message.getId()+")'>");}
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
            
            <div class='col-lg-8'>
                <div class='col-lg-12' id='messageContainer'>
                    <div class='messageHead'>
                    <div class="col-lg-4"><a><span class="glyphicon glyphicon-plus">Nouveau</span></a></div>
                    <%
                    if(request.getAttribute("messageSelect")!=null){
                        %>
                            <div class="col-lg-4"><a><span class="glyphicon glyphicon-share-alt">Repondre</span></a></div>
                            <div class="col-lg-4"><a><span class="glyphicon glyphicon-trash">Supprimer</span></a></div>
                        </div>
                        <div class='messageBody'>
                            <%
                            if(request.getAttribute("messageSelect")!=null){
                                %>
                                <div class="col-lg-12" id="messageEnvoyeur">
                                    <label id="messageEnvoyeur"><b>Envoyeur : </b></label><span><%=mDao.getSender(messageSelect.getId()).getUsername()%></span>
                                    <hr>
                                </div>
                                <div class="col-lg-12" id="messageTitre">
                                    <label id="messageTitre"><b>Titre : </b></label><span><%=messageSelect.getTitre()%></span>
                                    <hr>
                                </div>
                                <div class="col-lg-12" id="messageText">
                                    <p><%=messageSelect.getMessage()%></p>
                                </div>
                                <%
                            }
                            %>
                        </div>
                        <%
                    }
                    %>
                </div>
            </div>
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
        </script>
    </body>
</html>
