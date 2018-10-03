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
    <body>
        <h1>Teste jourDAO</h1>
        <%
            JourDAO dao = new JourDAO();
            
            out.println("<hr>");
            Jour j = dao.find(1, "lundi");
            out.println("<h2>Test : find(userID, journee)</h2>");
            if(j==null){out.println("<h1 style='color:red;'>Erreur</h1>");}
            else{
                out.println("<h4>ID :"+j.getId()+"</h4>");
                out.println("<h4>UserID : "+j.getUserId()+"</h4>");
                out.println("<h4>Journee : "+j.getJour()+"</h4>");
                out.println("<h4>Debut : "+j.getDebut()+"</h4>");
                out.println("<h4>Fin : "+j.getFin()+"</h4>");
                out.println("<hr>");
            }
            out.println("<h2>Test : findAll(userID)</h2>");
            List<Jour> listTest = dao.findAll(1);
            if(listTest==null){out.println("<h1 style='color:red;'>Erreur</h1>");}
            else{
                for(int i=0; i<listTest.size(); i++){
                    int nbJ = i+1;
                    out.println("<h4>Jour#"+nbJ+"</h4>");
                    out.println("<h4>"+listTest.get(i).getJour() +"</h4>");
                    out.println("<h4>Debut : "+listTest.get(i).getDebut() +"</h4>");
                    out.println("<h4>Fin : "+listTest.get(i).getFin() +"</h4>");
                }
            }
            out.println("<hr>");
            out.println("<h2>Test : create(idJour, idUser, jour, debut, fin)</h2>");
            dao.create(5, 2, "mardi","10:12:12", "15:12:12");
            
            out.println("<hr>");
            out.println("<h2>Test : update(Jour j)</h2>");
            Jour test = new Jour(4, 1, "jeudi","12:12:12", "16:16:16");
            dao.update(test);
        %>
    </body>
</html>
