<%@page import="java.sql.Time"%>
<%@page import="java.util.List"%>
<%@page import="classe.Jour"%>
<%@page import="dao.JourDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
            List<Jour> listHorraire = dao.findAll(1);
            
            //Declaration des variables
            int lundiD, lundiF,
                mardiD, mardiF,
                mercrediD, mercrediF,
                jeudiD, jeudiF,
                vendrediD, vendrediF;
            //Definition des valeurs de debut et de fin pour le user 1
            lundiD = Integer.valueOf(listHorraire.get(0).getDebut().split(":")[0]);
            lundiF = Integer.valueOf(listHorraire.get(0).getFin().split(":")[0]);
            mardiD = Integer.valueOf(listHorraire.get(1).getDebut().split(":")[0]);
            mardiF = Integer.valueOf(listHorraire.get(1).getFin().split(":")[0]);
            mercrediD = Integer.valueOf(listHorraire.get(2).getDebut().split(":")[0]);
            mercrediF = Integer.valueOf(listHorraire.get(2).getFin().split(":")[0]);
            jeudiD = Integer.valueOf(listHorraire.get(3).getDebut().split(":")[0]);
            jeudiF = Integer.valueOf(listHorraire.get(3).getFin().split(":")[0]);
            vendrediD = Integer.valueOf(listHorraire.get(4).getDebut().split(":")[0]);
            vendrediF = Integer.valueOf(listHorraire.get(4).getFin().split(":")[0]);
        %>
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
            for(int y=8; y<19; y++){ //Création des colonnes dans la table
            %>
                <tr>
                    <th scope="row"><%=y%>h</th>
                    <td style="
                        <%  //Style de la case
                            if(y>=lundiD && y<=lundiF){out.println("background-color:none");}
                            else{out.println("background-color:lightgrey");}
                        %>
                        ">
                        <%  //Si c'est le debut ou la fin
                            if(y==lundiD){out.println("Debut");}
                            else if(y==lundiF){out.println("Fin");}
                        %>
                    </td>
                    <td style="
                        <%  //Style de la case
                            if(y>=mardiD && y<=mardiF){out.println("background-color:none");}
                            else{out.println("background-color:lightgrey");}
                        %>
                    ">
                        <%  //Si c'est le debut ou la fin
                            if(y==mardiD){out.println("Debut");}
                            else if(y==mardiF){out.println("Fin");}
                        %>
                    </td>
                    <td style="
                        <%  //Style de la case
                            if(y>=mercrediD && y<=mercrediF){out.println("background-color:none");}
                            else{out.println("background-color:lightgrey");}
                        %>
                    ">
                        <%  //Si c'est le debut ou la fin
                            if(y==mercrediD){out.println("Debut");}
                            else if(y==mercrediF){out.println("Fin");}
                        %>
                    </td>
                    <td style="
                        <%  //Style de la case
                            if(y>=jeudiD && y<=jeudiF){out.println("background-color:none");}
                            else{out.println("background-color:lightgrey");}
                        %>
                    ">
                        <%  //Si c'est le debut ou la fin
                            if(y==jeudiD){out.println("Debut");}
                            else if(y==jeudiF){out.println("Fin");}
                        %>
                    </td>
                    <td style="
                        <%  //Style de la case
                            if(y>=vendrediD && y<=vendrediF){out.println("background-color:none");}
                            else{out.println("background-color:lightgrey");}
                        %>
                    ">
                        <%  //Si c'est le debut ou la fin
                            if(y==vendrediD){out.println("Debut");}
                            else if(y==vendrediF){out.println("Fin");}
                        %>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
        <!-- Table optimiée -->    
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
                    int debut = Integer.valueOf(listHorraire.get(y).getDebut().split(":")[0]);
                    int fin = Integer.valueOf(listHorraire.get(y).getFin().split(":")[0]);
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
    </body>
</html>
