<%-- 
    Document   : accueil
    Created on : 2018-09-19, 09:19:33
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lifty | Accueil</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <%@include  file="menu.jsp" %>
    <div id="parallax">
        <div class="landing-text">
            <img src="../images/logo.png" id="imgAccueil"/>
            <h3>L'application de covoiturage pour étudiants</h3>
        </div>
    </div>
    
    <div class="padding" id="contenu1">
        <div class="container">
            <div class="col-sm-6">
                <img src="../images/covoiturage.jpg" class="img-responsive" />
            </div>
            <div class="col-sm-6 text-center">
                <h1 class='soustitre'>À Propos</h1>
                <p>Lifty est un application web qui permet aux étudiants d'effectuer
                    du covoiturage sans se soucier de trouver un chauffeur ou un 
                    passager. Lifty a été développé avec les étudiants en tête, c'est 
                    pourquoi nous avons intégré des fonctionnalités faîtes sur mesure pour 
                    leur simplifier la vie.
                </p>
            </div>
        </div>
    </div>
    <div class="padding" id="contenu2">
        <div class="container">
            <h1 class='soustitre'>Pour des étudiants, par des étudiants</h1> <br/>
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                    <h4>Création d'horraire</h4>
                    <p>Lifty permet aux utilisateurs d'entrer leur horaire pour maximiser
                        les chances de trouver un chauffeur ou un passager qui concorde avec
                        leur horaire. Cette fonctionnalité permet de sélectionner une personne qui
                        ne va pas vous ralentir le matin ou lorsque vous devez partir de votre 
                        école.</p>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                    <img src="../images/student.jpg" class="img-responsive" />
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                    <h4>Recherche automatique</h4>
                    <p>Lifty permet aux utilisateurs d'effectuer des recherches automatiques
                        de chauffeurs ou de passagers selon les informations qu'ils ont rentrés. 
                        En effet la recherche prend en compte le rayon du chauffeur, la ville ou que 
                        vous habitez et l'établissement que vous fréquenter.</p>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                    <img src="../images/pancarte.jpeg"  class="img-responsive" />
                </div>
            </div>
        </div>
    </div>
    <div id="fixed">
    </div>
    <div class="padding" id="contenu3">
        <div class="container">
            <div class="col-sm-6">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2793.648181402067!2d-73.5845177840561!3d45.55740247910211!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cc91eace22b9bcf%3A0x18799aed17aa23d9!2sColl%C3%A8ge+de+Rosemont!5e0!3m2!1sfr!2sca!4v1519943892970" width="400" height="350" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
            <div class="col-sm-6 text-center">
                <h2>Nous Contacter</h2>
                <p>Il est possible de nous rencontrer au collège de Rosemont,
                    mais il serait préférable que vous remplissiez le 
                    formulaire ci-dessous : </p>
                <form method="post" action="">
                    Votre Nom : <input type="text" name="nomContact" placeholder="Linus Torvalds" required> <br/><br/>
                    Votre Email : <input type="email" name="emailContact" placeholder="abc@xyz.com " required> <br/><br/>
                    <br><textarea name="questionContact" placeholder="Ecriver votre question ici!" required></textarea><br/><br/>
                    <input type="submit" name="btnEnvoieContact" value="Envoyer!">
                </form>
            </div>
        </div>
    </div>
    <%@include  file="footer.jsp" %>
</body>
</html>
