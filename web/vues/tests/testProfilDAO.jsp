<%-- 
    Document   : accueil
    Created on : 2018-09-19, 09:19:33
    Author     : gabri
--%>

<%@page import="classe.Profil"%>
<%@page import="classe.Vehicule"%>
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
        Profil p1;
    %>
    
    <h1>
        -----------------------
        <br />
        update(profil)
    </h1>
    <%  
        Profil p2;
        p1 = profilDAO.findById(0);
        p1.setUsername("maximechausse");
        p1.setEmail("max@lifty.ca");
        profilDAO.update(p1);
        p2 = profilDAO.findByUsername("maximechausse");
        out.println("<h1>"+(p2==null?"ca marche pas":"Ca marche")+"</h1>");
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
        p1=p;
        out.println("<h1>"+(p==null?"ca marche pas":"Ca marche")+"</h1>");
        if(p!=null)%><h3><%=p.getNom()%></h3>
    
    <h1>
        -----------------------
        <br />
        create(profil)
    </h1>
    <%
        p.setId(0);
        p.setUsername("samuellaverdure");
        p.setNom("Slaverdure");
        p.setPrenom("Samuel");
        p.setEmail("sam@lifty.ca");
        //p.setVehicule(new Vehicule(1, 4, "Mazda 3", "2014", "Noir", false));
                
        profilDAO.create(p);
        p=null;
        p = profilDAO.findByEmail("sam@lifty.ca");
        out.println("<h1>"+(p==null?"ca marche pas":"Ca marche")+"</h1>");
        %>
</body>
</html>
