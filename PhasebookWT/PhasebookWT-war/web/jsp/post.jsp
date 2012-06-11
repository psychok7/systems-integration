<%-- 
    Document   : post
    Created on : Oct 24, 2011, 11:54:39 PM
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
						<li class="perfil"><a href="about.jsp"><img src="users/leandro/user.jpg"></a></li>						
					</ul>
					<ul id="actions" class="left">
						<li><span class="title selected">Leandro Silva</span></li>
						<li><a href="about.jsp"><span class="description">Is your Friend</span></a></li>
					</ul>
					<ul id="actions" class="left">
						<li><span class="title">Gallery</span></li>
						<li><a href="gallery.jsp"><span class="description">View Photos</span></a></li>
					</ul>
					<ul id="actions" class="left">
						<li><span class="title">Friends</span></li>
						<li><a href="friends.jsp"><span class="description">Browse Connections</span></a></li>
					</ul>
				</nav>
			</section>						
		</section>
		
		<section class="big-content left">
			<section id="wall">
				<h2>Leandro Silva</h2>
				<section id="post">
					<article class="post">
						<nav>
							<ul class="left">
								<li class="inline"><a href="#"><img class="user" src="users/khan/user.jpg"></a></li>
							</ul>
							<ul class="left">
								<li><a class="title" href="#profile.jsp">Nuno Khan</a></li>
								<li><span class="description">August, 2th</span></li>
								<li><span class="description">Public</span></li>
							</ul>
							<div class="clear"></div>
						</nav>
							<section class="post-content">
								<p>Ser um zé que é manel, é ser um zé manel.</p>	
								<p>Zé</p>				
								
							</section>
							<aside class="left comment"><a href="post.jsp">Comment</a></aside>
						<div class="clear"></div>
					</article>	
				
					<section id="newpost">
						<article class="newpost">
							<form action="#">
								<textarea id="newpost">Your comment</textarea>
								<div class="clear"></div>
								<aside class="right"><input class="submit-post" type="submit" value="Share"></aside>
								<div class="clear"></div>
							</form>
						</article>
					</section>
				</section>
			</section>
		</section>
		<div class="clear"></div>
	</section>
    </body>
</html>
