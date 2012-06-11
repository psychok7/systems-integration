<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="entities.User"%>
<%@page import="entities.Friends"%>
<%@page import="java.util.List"%>
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
            Boolean isFriend = false;
            if (userProfile.getIduser() == userLoggedIn.getIduser()) {
                selfProfile = true;
                profileFriends = friends;
            } else {
                profileFriends = (List<Friends>) request.getSession().getAttribute("profileFriends");
                status = (Character) request.getSession().getAttribute("status");
            }

            // links da barra header
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
                            <li><img src="users/leandro/user.jpg"/></li>
                        </ul>
                        <ul class="left">
                            <li class="bold">Leandro Silva</li>
                            <li class="bold inline link"><a href="profile.jsp">Profile</a></li>
                            <li class="bold inline link"><a href="gallery.jsp">Gallery</a></li>
                            <li class="bold inline link"><a href="friends.jsp">Friends</a></li>
                            <li class="bold inline link"><a href="friends.jsp">Bet</a></li>
                            <li class="bold inline link"><a href="/Phasebook-war/LogoutController.do?hidMethod=processRequest">Log Out</a></li>
                        </ul>
                    </nav>
                    <nav id="search-nav" class="right">
                        <ul class="left">
                            <li class="inline"><form><a href="search.jsp" class="advanced"><span class="bold slogan">+</span></a><input type="text" class="search" value="search people"><input class="submit" type="submit" name="commit" value="GO"/></form></li>
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
                            <li class="perfil"><a href="about.jsp"><img src=""></a></li>						
                        </ul>
                        <ul id="actions" class="left">
                            <li><span class="title">Leandro Silva</span></li>
                            <li><a href="about.jsp"><span class="description">It's You</span></a></li>
                        </ul>
                        <ul id="actions" class="left selected">
                            <li><span class="title selected">Gallery</span></li>
                            <li><a href="gallery.jsp"><span class="description">View Photos</span></a></li>
                            <li><a href="upload-photo.jsp"><span class="description">Upload Photo</span></a></li>
                        </ul>
                        <ul id="actions" class="left">
                            <li><span class="title">Friends</span></li>
                            <li><a href="friends.jsp"><span class="description">Browse Connections</span></a></li>
                            <li><a href="friends.jsp"><span class="description">Edit Friends</span></a></li>
                        </ul>
                    </nav>
                </section>						
            </section>

            <section class="big-content left">			
                <section id="gallery">
                    <h3>Upload Photo</h3>
                    <section id="upload-photo">
                        <form id="file-upload" action="/Phasebook-war/GalleryController.do?hidMethod=upload" enctype="multipart/form-data" method="post">
                            <label>Title</label>
                            <div class="clear"></div>
                            <input class="action-upload" type="text" name="title"/>
                            <div class="clear"></div>
                            <input class="action-upload" type="file" name="file"/>
                            <div class="clear"></div>
                            <input class="action-upload" type="checkbox" name="profile"> <span class="small bold">Set as profile photo</span></input>
                            <div class="clear"></div>
                            <input class="action-upload" type="submit" name="submit" value="Upload"/>

                        </form>
                        <div class="clear"></div>
                    </section>
                </section>
                <div class="clear"></div>
            </section>
            <div class="clear"></div>
        </section>
    </body>
</html>
