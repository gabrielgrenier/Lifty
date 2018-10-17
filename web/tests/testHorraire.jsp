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
    </head>
    <body>
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
        <% 
            for(int i=0; i<constat.length; i++){
                if(constat[i]!=0){out.println("<h4'>Le jour <b>#"+i+"</b> a un temps d'attente de <b>"+constat[i]+"h</b></h4>");}
            }
        %>
    </body>
</html>
