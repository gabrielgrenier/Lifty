<%@page import="java.sql.Time"%>
<%@page import="java.util.List"%>
<%@page import="classe.Jour"%>
<%@page import="dao.JourDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lifty | TestJourDAO</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body style="font-family: sans-serif; background-color:lightgray;">
        <h1 style="text-align: center; color:white;">Teste jourDAO</h1>
        <div style="margin: 2em 4em 4em 4em; padding: 2em 1em 1em 2em; background-color:white;">
        <%
            JourDAO dao = new JourDAO();
            
            Jour j = dao.find(1, "lundi");
            out.println("<h2>Test : find(userID, journee)</h2>");
            if(j==null){out.println("<h1 style='color:red;'>Erreur</h1>");}
            else{
                out.println("<h4>ID :"+j.getId()+"</h4>");
                out.println("<h4>UserID : "+j.getUserId()+"</h4>");
                out.println("<h4>Journee : "+j.getJour()+"</h4>");
                out.println("<h4>Debut : "+j.getDebut()+"</h4>");
                out.println("<h4>Fin : "+j.getFin()+"</h4>");
            }
            out.println("<hr>");
            out.println("<h2>Test : findAll(userID)</h2>");
            List<Jour> listTest = dao.findAll(1);
            if(listTest==null){out.println("<h1 style='color:red;'>Erreur</h1>");}
            else{
                for(int i=0; i<listTest.size(); i++){
                    int nbJ = i+1;
                    out.println("<h4 style='color:red;'>Jour#"+nbJ+"</h4>");
                    out.print("<b> Jour : </b>" + listTest.get(i).getJour() + ", ");
                    out.print("<b>Debut : </b>" +listTest.get(i).getDebut() + ", ");
                    out.print("<b>Fin : </b>" +listTest.get(i).getFin());
                }
            }
            out.println("<hr>");
            out.println("<h2>Test : create(idJour, idUser, jour, debut, fin)</h2>");
            dao.create(100, 2, "mardi","10:12:12", "15:12:12");
            
            out.println("<hr>");
            out.println("<h2>Test : create(Jour j)</h2>");
            Jour objTest1 = new Jour(101, 2, "","10:10:10", "16:16:16");
            dao.create(objTest1);
           
            out.println("<hr>");
            out.println("<h2>Test : update(Jour j)</h2>");
            Jour objTest2 = new Jour(101, 2, "jeudi", "12:12:12", "16:16:16");
            dao.update(objTest2);
            
            out.println("<hr>");
            out.println("<h2>Test : Horraire</h2>");
            List<Jour> listHorraire = dao.findAll(1);
        %>
        <div class="table-responsive">
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
            </div>
        </div>
    </body>
</html>