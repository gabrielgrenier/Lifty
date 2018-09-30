<%-- 
    Document   : test
    Created on : 2018-09-26, 13:57:33
    Author     : gabri
--%>
<%@page import="java.util.List"%>
<%@page import="classe.Jour"%>
<%@page import="dao.JourDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        %>
    </body>
</html>
