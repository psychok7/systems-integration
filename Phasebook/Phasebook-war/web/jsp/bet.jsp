<%-- 
    Document   : bet
    Created on : Nov 1, 2011, 11:49:22 AM
    Author     : leandro
--%>

<%@page import="entities.Friends"%>
<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%

            User userLoggedIn = (User) request.getSession().getAttribute("login");
            List<Friends> friends = (List<Friends>) request.getSession().getAttribute("friends");

            String uri = "/home/leandro/glassfish-3.1.1/glassfish/domains/domain1/";
            String viewProfile = "";
        %>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css" media="screen">
        <script src="js/jquery-1.6.4.min.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body><header>
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
            <section class="big-content left">
                <section id="bet">
                    <h2>Bet</h2>
                    <section id="place-bet">
                        <article>
                            <p>Hey <span class="bold slogan"><%= userLoggedIn.getName()%></span></p>
                            <form action="/Phasebook-war/BetController.do" method="get">
                                <input type="hidden" id="hidMethod" name="hidMethod" value="placeBet"/>
                                <input type="hidden" id="hidMethod" name="id" value=<%= "'" + userLoggedIn.getIduser() + "'"%>/>
                                <div class="clear"></div>
                                <label>pick a number</label>
                                <div class="clear"></div>
                                <input type="text" name="number"></input>
                                <aside class="right"><input class="submit-post" type="submit" value="Submit"></aside>
                                <div class="clear"></div>
                            </form>
                        </article>
                    </section>
                </section>
            </section> 
        </section>
    </body>
</html>
