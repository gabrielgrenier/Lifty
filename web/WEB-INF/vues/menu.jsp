<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="menu" 
    <div class="container-fluid">
        <div clas="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#parallax"><img id="logo" src="./static/images/petitLogo.png"/></a>
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
                <div class="form-group">
                <label for="emailCon">Courriel:</label>
                <input type="emailCon" class="form-control" id="emailCon" placeholder ='JDoe@gmail.com' required>
                </div>
                <div class="form-group">
                  <label for="pwdCon">Mot de passe:</label>
                  <input type="password" class="form-control" id="pwdCon" placeholder='Mot de passe' required>
                </div>
                <div class="form-group">
                    <label id='lblLink'><u>S'insrire à Lifty</u></label>
                </div>
                <div class="form-group">
                    <button type="submit" name="btnConnexion" id="btnConnexion" class="btn btn-primary">Se connecter</button>
                </div>
            </div>
        </form>
        
        <form method="post" action="">
            <div class="container" id="panelInscription">
                <div class="form-group">
                <label for="prenomInsc">Prénom:</label>
                <input type="text" class="form-control" id="prenomInsc" placeholder ='John' required>
                </div>
                <div class="form-group">
                <label for="nomInsc">Nom:</label>
                <input type="text" class="form-control" id="nomInsc" placeholder ='Doe' required>
                </div>
                <div class="form-group">
                <label for="emailInsc">Courriel:</label>
                <input type="email" class="form-control" id="emailInsc" placeholder ='JDoe@gmail.com' required>
                </div>
                <div class="form-group">
                <label for="codePInsc">Code Postal:</label>
                <input type="text" class="form-control" id="codePInsc" placeholder ='H0H 0H0' required>
                </div>
                <div class="form-group">
                <label for="pwdInsc">Mot de passe:</label>
                <input type="password" class="form-control" id="pwdInsc" placeholder='Mot de passe' required>
                </div>
                <div class="form-group">
                <label for="pwdConfInsc">Mot de passe:</label>
                <input type="password" class="form-control" id="pwdConfInsc" placeholder='Confirmation du mot de passe' required>
                </div>
                <label>Je suis un </label>
                <div class="form-group">
                <label class="radio-inline"><input type="radio" name="condInsc" checked>: Conducteur</label>
                <label class="radio-inline"><input type="radio" name="passInsc">: Passager</label>
                </div>
                <div class="form-group">
                    <button type="submit" name="btnInscription" id="btnInscription" class="btn btn-primary">S'inscrire</button>
                </div>
            </div>
        </form>
    </div>
</nav>