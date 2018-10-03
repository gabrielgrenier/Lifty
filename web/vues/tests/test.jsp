<%@page import="java.util.List"%>
<%@page import="classe.Jour"%>
<%@page import="dao.JourDAO"%>
<%@page import="dao.JourDAO"%>
<%@page import="classe.Jour"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test jourDAO</title>
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
            dao.create(5, 2, "mardi","10:12:12", "15:12:12");
            
            out.println("<hr>");
            out.println("<h2>Test : createFromOBJ(Jour j)</h2>");
            Jour objTest1 = new Jour(6, 2, "","10:10:10", "16:16:16");
            dao.createFromOBJ(objTest1);
           
            out.println("<hr>");
            out.println("<h2>Test : update(Jour j)</h2>");
            Jour objTest2 = new Jour(4, 1, "jeudi","12:12:12", "16:16:16");
            dao.update(objTest2);
        %>
        </div>
    </body>
</html>
