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
    // Declaration des variables
    ProfilDAO profilDAO = new ProfilDAO();
    Profil p;
    %>
    <h1>
        -----------------------
        <br />
        findByEmail(email)
    </h1>
    <%
    p = profilDAO.findByEmail("max@lifty.ca");
    out.println("<h1>"+(p==null?"ca marche pas":"Ca marche")+"</h1>");
    if(p!=null)%><h3><%=p.getNom()%></h3>

    <h1>
        -----------------------
        <br />
        findById(id)
    </h1>
    <%
    p = profilDAO.findById(1);
    out.println("<h1>"+(p==null?"ca marche pas":"Ca marche")+"</h1>");
    if(p!=null)%><h3><%=p.getNom()%></h3>
    
    <h1>
        -----------------------
        <br />
        findByUsername(username)
    </h1>
    <%
    p = profilDAO.findByUsername("maximechausse");
    out.println("<h1>"+(p==null?"ca marche pas":"Ca marche")+"</h1>");
    if(p!=null)%><h3><%=p.getNom()%></h3>
</body>
</html>
