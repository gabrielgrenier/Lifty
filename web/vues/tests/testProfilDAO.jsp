<%-- 
    Document   : accueil
    Created on : 2018-09-19, 09:19:33
    Author     : gabri
--%>

<%@page import="classe.Profil"%>
<%@page import="dao.ProfilDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Lifty | Accueil</title>
</head>

<body>
    <%
    
    ProfilDAO profilDAO = new ProfilDAO();
    Profil p=new Profil(5, "email", "Nom du profil de test", "Prenom","mot", 1,  "123", "123", "123", "123", "123", false, false, false, false, false,5,23, 22);
    %>
    <h1><%=p.getNom()%></h1>
    <%
    p = profilDAO.find("max@lifty.ca");
    out.println("<h1>"+(p==null?"ca marche pas":"Ca marche")+"</h1>");
    if(p!=null)%><h1><%=p.getNom()%></h1><%
    %>
</body>
</html>
