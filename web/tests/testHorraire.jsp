<%@page import="java.sql.Time"%>
<%@page import="java.util.List"%>
<%@page import="classe.Jour"%>
<%@page import="dao.JourDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lifty | TestHorraire</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../static/css/style.css" type="text/css"/>
    </head>
    <body onLoad="uncheck()">
        <%
            JourDAO dao = new JourDAO();
            List<Jour> listHorraire1 = dao.findAll(1);
            List<Jour> listHorraire2 = dao.findAll(3);
        %>
        
        <h2>Horraire user 1 :</h2>
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
                            if(x>=debut && x<=fin){out.println("background-color:none");}
                            else{out.println("background-color:lightgrey");}
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
        <h2>Horraire user 3 :</h2>
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
                    int debut = Integer.valueOf(listHorraire2.get(y).getDebut().split(":")[0]);
                    int fin = Integer.valueOf(listHorraire2.get(y).getFin().split(":")[0]);
            %>
                    <td style="
                        <%  //Style de la case
                            if(x>=debut && x<=fin){out.println("background-color:none");}
                            else{out.println("background-color:lightgrey");}
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
        <h2 style="color:red;">Comparaison de passager à conduteur : </h2>
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
            int[] constat = new int[5]; //refaire avec string qui ajoute le jour et le nombre d'heures
            for(int x=8; x<19; x++){ //Création des colonnes dans la table
            %>
            <tr>
                <th scope="row"><%=x%>h</th>
            <%
                for(int y=0; y<5; y++){
                    boolean isConducteur=false;
                    //passager
                    int debut1 = Integer.valueOf(listHorraire1.get(y).getDebut().split(":")[0]);
                    int fin1 = Integer.valueOf(listHorraire1.get(y).getFin().split(":")[0]);
                    //conducteur
                    int debut2 = Integer.valueOf(listHorraire2.get(y).getDebut().split(":")[0]);
                    int fin2 = Integer.valueOf(listHorraire2.get(y).getFin().split(":")[0]);
            %>  
                    <td style="
                        <%  //Style de la case
                                //si le jour du passager est le même que celui du conducteur
                                if(x>=debut1 && x<=fin1 && x>=debut2 && x<=fin2 && debut1==debut2 && fin1==fin2){ out.println("background-color:#ADFF9E");}
                                //Si le conducteur et le passager commence en même temps mais termine a différente heure
                                else if(x>=debut1 && x<=fin1 && debut1==debut2 || x>=debut1 && x<=fin2 && debut1==debut2){
                                    out.println("background-color:#ffe5b2");
                                    //constat[constat.length] = Math.abs((debut1+fin1) - (debut2+fin2));
                                }
                                //si le user1 n'est pas conducteur et qu'il commence apres le conducteur, compatible mais pas optimal
                                else if(x>=debut1 && x<=fin1 && fin1==fin2 && debut1>=debut2 && !isConducteur){
                                    out.println("background-color:#ffe5b2");
                                    //constat[constat.length] = Math.abs((debut1+fin1) - (debut2+fin2));
                                }
                                //si le user1 est conducteur et qu'il avant le passager, compatible mais pas optimal
                                else if(x>=debut1 && x<=fin1 && debut1<=debut2 && isConducteur || x>=debut1 && x<=fin2 && debut1<=debut2 && isConducteur){
                                    out.println("background-color:#ffe5b2");
                                    //constat[constat.length] = Math.abs((debut1+fin1) - (debut2+fin2));
                                }
                                else if(x>=debut1 && x<=fin1){out.println("");}
                                else{out.println("background-color:lightgrey");}
                        %>
                        ">
                        <%  //Si c'est le debut ou la fin
                            if(x==debut1 && x==debut2){out.println("Vous commencez en même temps");}
                            else if(x==debut1){out.println("Début de vos cours");}
                            else if(x==debut2){out.println("Début de leurs cours");}
                            
                            if(x==fin1 && x==fin2){out.println("Vous terminez en même temps");}
                            else if(x==fin1){out.println("Fin de vos cours");}
                            else if(x==fin2){out.println("Fin de leurs cours");}
                        %>
                    </td>
                   <% } %>
                </tr>
            <% } %>
            </tbody>
        </table>
        <h3>Constat : </h3>
        <% //Fonctionne pas
            for(int i=0; i<constat.length; i++){
                if(constat[i]!=0){out.println("<h4'>Le jour <b>#"+i+"</b> a un temps d'attente de <b>"+constat[i]+"h</b></h4>");}
            }
        %>
        <h1>Création des horraires :</h1>
        <form action="./" method="post">
        id user : <input type="number">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr><th style="width:5%; background-color: grey;"></th>
                        <th style="width:19%;">Lundi <input type="checkbox" onchange="removeJour('Lun', this)" id="checkLun"></th>
                        <th style="width:19%;">Mardi <input type="checkbox" onchange="removeJour('Mar', this)" id="checkMar"></th>
                        <th style="width:19%;" >Mercredi <input type="checkbox" onchange="removeJour('Mer', this)" id="checkMer"></th>
                        <th style="width:19%;">Jeudi <input type="checkbox" onchange="removeJour('Jeu', this)" id="checkJeu"></th>
                        <th style="width:19%;" >Vendredi <input type="checkbox" onchange="removeJour('Ven', this)" id="checkVen"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">Début </th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debLun" id="debLun" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debMar" id="debMar" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debMer" id="debMer" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debJeu" id="debJeu" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="8" max="17" name="debVen" id="debVen" required>h</th>
                    </tr>
                    <tr>
                        <th scope="row">Fin </th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finLun" id="finLun" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finMar" id="finMar" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finMer" id="finMer" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finJeu" id="finJeu" required>h</th>
                        <th scope="row"><input type="number" class="inputHorraireNum" min="9" max="18" name="finVen" id="finVen" required>h</th>
                    </tr>
                </tbody>
                <input type="submit" value="Créer" id="subHoraire">
            </table>
<<<<<<< HEAD
            <input type="hidden" value="createHoraire" name="action">
            <h1>Teste</h1>
=======
        <!--<input type="hidden" value="createHoraire" name="action">-->
>>>>>>> 0116ebf8e411fb955c6bcfe878222342d4c7937c
        </form>
    </body>
    <script>
    function validationCreate(){
        var checkbox = document.querySelectorAll('input[type=checkbox]'); 
        var vide = [].filter.call( checkbox, function( el ) {
           return el.checked
        });
        if (checkbox.length == vide.length) {
            document.getElementById("subHoraire").disabled = true;
        }
        else{
            document.getElementById("subHoraire").disabled = false;
        }
    }
    function removeJour(jour, check){ //Permet d'Avoir des jours libres
        var jourDeb = "deb"+jour;
        var jourFin = "fin"+jour;
        
        if(check.checked){
            document.getElementById(jourDeb).required = false;
            document.getElementById(jourFin).required = false;
            document.getElementById(jourDeb).disabled = true;
            document.getElementById(jourFin).disabled = true;
        }
        else{
            document.getElementById(jourDeb).required = true;
            document.getElementById(jourFin).required = true;
            document.getElementById(jourDeb).disabled = false;
            document.getElementById(jourFin).disabled = false;
        }
        validationCreate();
    }
   function uncheck(){ //pour firefox parce que il uncheck pas lors des refresh
        $(':checkbox:checked').prop('checked',false);
   }
</script>
<<<<<<< HEAD
</html>
=======
</html>
>>>>>>> 0116ebf8e411fb955c6bcfe878222342d4c7937c
