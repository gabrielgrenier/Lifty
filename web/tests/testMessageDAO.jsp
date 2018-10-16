<%-- 
    Document   : accueil
    Created on : 2018-09-19, 09:19:33
    Author     : gabri
--%>

<%@page import="classe.ListeMessage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="classe.Message"%>
<%@page import="classe.Vehicule"%>
<%@page import="dao.MessageDAO"%>
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
        MessageDAO mDAO = new MessageDAO();
        Message m;
    %>
    
    <h1>
        -----------------------
        <br />
        create(Message)
    </h1>
    <%  
        m = new Message(0,"Changement dhoraire","Ce message est pour aviser un changement dhoraire","2018-10-15","07:58:59",false);
        mDAO.create(m);
        Message mRetour = mDAO.findById(2);
        out.println("<h1>"+(mRetour==null?"ca marche pas":"Ca marche")+"</h1>");
        %>
    <h1>
        -----------------------
        findAllVu()
    </h1>
    <%
    ListeMessage messages;
    messages = mDAO.findAllVu(0,1);
    out.println(messages.length());
    %>
    <table>
        <%
        for(int i=0;i<messages.length();i++)out.println("<tr><td>"+messages.get(i)+"</td></tr>");
        %>
    </table>
    
    <h1>
        -----------------------
        findAll()
    </h1>
    <%
    messages = mDAO.findAll(0,1);
    out.println(messages.length());
    %>
    <table>
        <%
        for(int i=0;i<messages.length();i++)out.println("<tr><td>"+messages.get(i)+"</td></tr>");
        %>
    </table>
    
    <h1>
        -----------------------
        countAllVu()
    </h1>
    <%
    out.println(mDAO.countNonVu(1));
    %>
    
    <h1>
        -----------------------
        getSender()
    </h1>
    <%
    out.println(mDAO.getSender(4));
    %>
</body>
</html>
