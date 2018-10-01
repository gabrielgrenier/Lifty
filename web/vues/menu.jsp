<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="menu" 
    <div class="container-fluid">
        <div clas="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#parallax"><img id="logo" src="../images/petitLogo.png"/></a>
        </div>
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
        <form method="post" action="">
            <div class="container" id="panelLogin">
                <div class="row">
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        <input type="email" name="emailLogin" placeholder="Courriel" required> <br/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        <input type="password" name="pswLogin" placeholder="Mot de passe " required> <br/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        <input type="submit" name="btnConnexion" id="btnConnexion" value="Se connecter">
                    </div>
                </div>
            </div>
        </form>
        
        <form method="post" action="">
            <div class="container" id="panelInscription">
                <div class="row">
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        <input type="text" name="prenomInscription" placeholder="Prénom" required> <br/><br/>
                    </div>
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        <input type="text" name="nomInscription" placeholder="Nom" required> <br/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        <input type="text" name="codePostaleInscription" placeholder="H0H 0H0" required> <br/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        <input type="email" name="emailInscription" placeholder="Courriel" required> <br/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        <input type="password" name="pswInscription" placeholder="Mot de passe" required> <br/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        <input type="password" name="confirmationPswInscription" placeholder="Confirmation du mot de passe" required> <br/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        Je suis un conducteur :<input type="checkbox" name="conducteurInscription" value="true" required><br/><br/>
                    </div>
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        Je suis un passager :<input type="checkbox" name="passagerInscription" value="false" required><br/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2 col-md-4 col-lg-6 text-center">
                        <input type="submit" name="btnInscription" id="btnInscription" value="S'inscrire">
                    </div>
                </div>
            </div>
        </form>
    </div>
</nav>