<%-- 
    Document   : test
    Created on : 2018-09-26, 13:57:33
    Author     : gabri
--%>
<%@page import="classe.Jour"%>
<%@page import="classe.JourDAO"%>
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
            Jour j = dao.find(1, "lundi");
            
            if(j==null){ out.println("<h1>Erreur</h1>");}
            else{
                out.println("<h1>ID :"+j.getId()+"</h1>");
                out.println("<h1>UserID : "+j.getUserId()+"</h1>");
                out.println("<h1>Journee : "+j.getJour()+"</h1>");
                out.println("<h1>Debut : "+j.getDebut()+"</h1>");
                out.println("<h1>Fin : "+j.getFin()+"</h1>");
            }
        %>
    </body>
</html>
