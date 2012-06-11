

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <%
            User userLoggedIn = (User) request.getSession().getAttribute("login");

            List<User> list = (List<User>) request.getSession().getAttribute("list-results");
            String query = (String) request.getSession().getAttribute("query");

            // links da barra header
            String uri = "/home/leandro/glassfish-3.1.1/glassfish/domains/domain1/";
            String viewProfile = "";

        %>


        <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" media="screen">
        <script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <header>
            <section id="bar">
                <section id="bar-nav">
                    <nav id="user-nav" class="left">
                        <ul class="left">
                            <%
                                String src = uri + "media/" + userLoggedIn.getIduser() + "/profile/user.jpg";
                            %>
                            <li><img src=<%= src%>/></li>
                        </ul>
                        <ul class="left">
                            <%
                                viewProfile = "'/Phasebook-war/ProfileController.do?hidMethod=viewProfile&id=" + userLoggedIn.getIduser() + "'";

                            %>
                            <li class="bold"><%= userLoggedIn.getName()%></li>
                            <li class="bold inline link"><a href=<%= viewProfile%>>Profile</a></li>
                            <li class="bold inline link"><a href="gallery.jsp">Gallery</a></li>
                            <li class="bold inline link"><a href="friends.jsp">Friends</a></li>
                            <li class="bold inline link"><a href="bet.jsp">Bet</a></li>
                            <li class="bold inline link"><a href="/Phasebook-war/UserController.do?hidMethod=logout">Log Out</a></li>
                        </ul>
                    </nav>
                    <nav id="search-nav" class="right">
                        <ul class="left">
                            <li class="inline"><form action="/Phasebook-war/SearchController.do" method="post">
                                    <input type="hidden" name="hidMethod" value="processRequest"/>
                                    <a href="search.jsp" class="advanced"><span class="bold slogan">+</span></a><input type="text" name="search-people" class="search" value="search people"/><input class="submit" type="submit" name="commit" value="GO"/></form></li>
                        </ul>
                    </nav>
                    <div class="clear"></div>
                </section>
            </section>

            <section id="logo">
                <section id="logo-nav">
                    <nav>
                        <ul class="left">
                            <li class="big uppercase"><b><a id="logo" href="../index.jsp">Phasebook</a></b></li>
                            <li>A great <span class="slogan">social network</span></li>
                        </ul>
                    </nav>
                </section>
            </section>
            <div class="clear"></div>
        </header>

        <section class="main">
            <section class="content left">
                <section id="search">
                    <section id="search-results">
                       
                        <h2><%=list.size()%> Search Results for <%= query%></h2>    

                        <nav>

                            <% for (int i = 0; i < list.size(); i++) {
                                    User u = (User) list.get(i);
                                    viewProfile = "'/Phasebook-war/ProfileController.do?hidMethod=viewProfile&id=" + u.getIduser() + "'";
                            %>
                            <ul class="left">

                                <li><a href=<%= viewProfile%>><img class="user" src=""></a></li>
                                <li><a href=<%= viewProfile%>><%=u.getName()%></a></li>
                            </ul>
                            <% }%>
                        </nav>
                    </section>
                </section>
            </section>
            <section class="mini-sidebar left"></section>
            <div class="clear"></div>
        </section>
    </body>
</html>