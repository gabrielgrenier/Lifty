<%@page import="classe.Profil"%>
<%@page import="dao.ProfilDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>    
<%
    // MARCHE PAS PARCE QUE LA VARIABLE NE PEUX NE PAS AVOIR ETE INITIALISER
    // Initialisation des variables
    //String emailCon, pwdCon = "";
    // Gestions des valeurs entrees
    //if(request.getParameter("emailCon")!=null)emailCon=request.getParameter("emailCon");
    //if(request.getParameter("pwdCon")!=null)pwdCon=request.getParameter("pwdCon");
    %>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="menu" >

    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#parallax"><img id="logo" src="./static/images/petitLogo.png"/></a>
        </div>
        <%
        if(request.getAttribute("connecte")==null){
            // -----------------------------------------
            // Section de menu si non connecte
            %>
            <div class="collapse navbar-collapse" id="navbar-collapse-main">
                <ul class="nav navbar-nav navbar-right" style="margin-right: 1%;">
                    <li><a class="#" href="#parallax">Accueil</a></li>
                    <li><a class="#" href="#contenu1">À Propos</a></li>
                    <li><a class="#" href="#contenu2">Fonctionnalitées</a></li>
                    <li><a class="#" href="#contenu3">Nous Contacter</a></li>
                    <li><a class="#" id="inscription">Inscription</a></li>
                    <li><a class="#" id="login">Connexion</a></li>
                </ul>
            </div>
            <%
        }
        else{
            // -----------------------------------------
            // Section de menu si connecte
            %>
            <div class="collapse navbar-collapse" id="navbar-collapse-main">
                <ul class="nav navbar-nav navbar-right" style="margin-right: 1%;">
                    <li><a class="#" >Recherche</a></li>
                    <li><a class="#" >Messages</a></li>
                    <li><a class="#" id="profil">Profil</a></li>
                </ul>
            </div>

            <%
        }
        %>
        <%// ====================== FORMULAIRE DE LOGIN =====================%>
        <form method="post" action="login">
            <div class="container" id="panelLogin">
                <div class="form-group">
                    <label for="emailCon">Courriel:</label>
                    <input type="emailCon" class="form-control" id="emailCon" name="emailCon" placeholder ='JDoe@gmail.com' value="<%=(request.getParameter("emailCon")!=null)?request.getParameter("emailCon"):""%>" required>
                </div>
                <div class="form-group">
                  <label for="pwdCon">Mot de passe:</label>
                  <input type="password" class="form-control" id="pwdCon" name="pwdCon" placeholder='Mot de passe' value="<%=(request.getParameter("pwdCon")!=null)?request.getParameter("pwdCon"):""%>" required>
                </div>
                <div class="erreur">
                    <%
                    // Afficher le message d<erreur si il y en a un
                    if(request.getAttribute("errCon")!=null){%><label><%out.print(String.valueOf(request.getAttribute("errCon")));%></label><%}
                    %>
                </div>
                <div class="form-group">
                    <label id='lblLink'><u>S'insrire à Lifty</u></label>
                </div>
                <div class="form-group">
                    <input type="hidden" name="action" value="Connexion"/>
                </div>
                <div class="form-group">
                    <button type="submit" name="btnConnexion" id="btnConnexion" class="btn btn-primary">Se connecter</button>
                </div>
            </div>
        </form>
        
        <%// ====================== FORMULAIRE D'INSCRIPTION =====================%>
        <form method="post" action="register">
            <div class="container" id="panelInscription">
                <div class="form-group">
                    <label for="prenomInsc">Prénom:</label>
                    <input type="text" class="form-control" id="prenomInsc" name="prenomInsc" placeholder ='John' value="<%=(request.getParameter("prenomInsc")!=null)?request.getParameter("prenomInsc"):""%>" required>
                </div>
                <div class="form-group">
                    <label for="nomInsc">Nom:</label>
                    <input type="text" class="form-control" id="nomInsc" name="nomInsc" placeholder ='Doe' value="<%=(request.getParameter("nomInsc")!=null)?request.getParameter("nomInsc"):""%>" required>
                </div>
                <div class="form-group">
                    <label for="emailInsc">Courriel:</label>
                    <input type="email" class="form-control" id="emailInsc" name="emailInsc" placeholder ='JDoe@gmail.com' value="<%=(request.getParameter("emailInsc")!=null)?request.getParameter("emailInsc"):""%>" required>
                </div>
                <div class="form-group">
                    <label for="codePInsc">Code Postal:</label>
                    <input type="text" class="form-control" id="codePInsc" name="codePInsc" placeholder ='H0H 0H0' value="<%=(request.getParameter("codePInsc")!=null)?request.getParameter("codePInsc"):""%>" required>
                </div>
                <div class="form-group">
                    <label for="pwdInsc">Mot de passe:</label>
                    <input type="password" class="form-control" id="pwdInsc" name="pwdInsc" placeholder='Mot de passe' value="<%=(request.getParameter("pwdInsc")!=null)?request.getParameter("pwdInsc"):""%>" required>
                </div>
                <div class="form-group">
                    <label for="pwdConfInsc">Mot de passe:</label>
                    <input type="password" class="form-control" id="pwdConfInsc" name="pwdConfInsc" placeholder='Confirmation du mot de passe' value="<%=(request.getParameter("pwdConfInsc")!=null)?request.getParameter("pwdConfInsc"):""%>" required>
                </div>
                <label>Je suis un </label>
                <div class="form-group">
                    <label class="radio-inline"><input type="radio" name="type" value="condInsc" checked>: Conducteur</label>
                    <label class="radio-inline"><input type="radio" name="type" value="passInsc">: Passager</label>
                </div>
                <div class="form-group">
                    <input type="hidden" name="action" value="Inscription"/>
                </div>
                <div class="form-group">
                    <button type="submit" name="btnInscription" id="btnInscription" class="btn btn-primary">S'inscrire</button>
                </div>
            </div>
        </form>
        <%// ====================== PANNEAU DE PROFIL =====================%>
        <%
        if(request.getAttribute("connecte")!=null){
            ProfilDAO pDao = new ProfilDAO();
            Profil p = new Profil();
            p=pDao.findById(Integer.parseInt(String.valueOf(request.getAttribute("connecte"))));
            %>
        <div class="container" id="panelProfil">
            <div class="form-group">
                <label id='lblPrenomNom'><%=p.getPrenom()+" "+p.getNom()%></label>
                <label id='lblUsername'><%="@"+p.getUsername()%></label>
            </div>
            <div class="form-group">
                <label><a href="?action=preferences"><u>Preferences</u></label>
            </div>
            <div class="form-group">
                <label><a href="?action=confidentialite"><u>Confidentialite</u></a></label>
            </div>
            <div class="form-group">
                <label><a href="?action="><u>Horaire</u></a></label>
            </div>
            <div class="form-group">
                <label><a href="?action=deconnexion"><u>Deconnexion</u></a></label>
            </div>
        </div>
        <%
        }
        %>
    </div>
</nav>