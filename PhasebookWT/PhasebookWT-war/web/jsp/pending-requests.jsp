
<%@page import="entities.Friends"%>
<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%

            User userLoggedIn = (User) request.getSession().getAttribute("login");
            User userProfile = (User) request.getSession().getAttribute("profileUser");
            List<Friends> friends = (List<Friends>) request.getSession().getAttribute("friends");
            List<Friends> pendingRequests = (List<Friends>) request.getSession().getAttribute("pendingRequests");
            List<Friends> profileFriends;
            Character status = null;

            Boolean selfProfile = false;
            if (userProfile.getIduser() == userLoggedIn.getIduser()) {
                selfProfile = true;
                profileFriends = friends;
            } else {
                profileFriends = (List<Friends>) request.getSession().getAttribute("profileFriends");
                status = (Character) request.getSession().getAttribute("status");
            }

            String uri = "/home/leandro/glassfish-3.1.1/glassfish/domains/domain1/";
            String viewProfile = "";

        %>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css" media="screen">
        <script src="js/jquery-1.6.4.min.js"></script>
        <script src="js/script.js"></script>
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

            <section class="sidebar left">
                <section id="action-profile">
                    <nav>
                        <ul id="profile" class="left">
                            <li class="perfil"><a href="about.jsp"><img src=<%=userProfile.getIduser()%>></a></li>
                        </ul>
                        <ul id="actions" class="left">
                            <li><span class="title selected"><%= userProfile.getName()%></span></li>
                            <%
                                String about = "";
                                if (selfProfile) {
                                    about = "It's You";
                                } else {
                                    if (status == null) {
                                        about = "Add as Friend";
                                    } else if (status.compareTo('p') == 0) {
                                        about = "Friendship Request Sent";
                                    } else {
                                        about = "It's your Friend";
                                    }
                                }
                            %>
                            <li><a href="about.jsp"><span class="description"><%=about%></span></a></li>
                            <li><a href="profile.jsp"><span class="description">View Profile</span></a></li>
                        </ul>
                        <ul id="actions" class="left">
                            <li><span class="title">Gallery</span></li>
                            <li><a href="gallery.jsp"><span class="description">View Photos</span></a></li>
                        </ul>
                        <ul id="actions" class="left">
                            <li><span class="title">Friends</span></li>
                            <li><a href="friends.jsp"><span class="description">Browse Connections</span></a></li>
                            <% if (selfProfile) {
                            %>
                            <li><a href="pending-requests.jsp"><span class="description">Pending Requests</span></a></li>
                            <%                                }
                            %>
                        </ul>
                    </nav>
                </section>						
            </section>

            <section class="big-content left">
                <% if (selfProfile) {%>


                <section id="friends">
                    <h2>Pending Requests</h2>
                    <nav>
                        <% if (pendingRequests != null) {
                                for (Friends f : pendingRequests) {
                                    User friend = (User) f.getUser1();
                                    if (friend.getIduser()==userLoggedIn.getIduser()){
                                        friend = (User) f.getUser();
                                    }
                                    viewProfile = "'/Phasebook-war/ProfileController.do?hidMethod=viewProfile&id" + friend.getIduser() + "'";
                        %>

                        <ul class="left">
                            <li><a href=<%= viewProfile%>><img src=""></img></a></li>
                            <li><a href=<%= viewProfile%>><%=friend.getName()%></a></li>
                            <form action="/Phasebook-war/ProfileController.do?" method="post">
                                <input type="hidden" id="hidMethod" name="hidMethod" value="acceptRequest"/>
                                <input type="hidden" id="hidMethod" name="id" value=<%= "'"+friend.getIduser() + "'" %>/>
                                <input class="action-friend" type="submit" name="add-friend" value="Accept Request"/>
                            </form>
                        </ul>
                        <%

                                }
                            }
                            viewProfile = "";
                            if (pendingRequests.isEmpty()) {
                        %>
                        <div class="clear"></div>
                        <p class="small"><span class="bold slogan"><%= userProfile.getName()%></span> has no Pending Requests</p>
                        <%}
                        %>
                        <div class="clear"></div>
                    </nav>
                </section>


                <% }%>

                <div class="clear"></div>
            </section>
            <div class="clear"></div>
        </section>
    </body>
</html>
