
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="css/style.css" media="screen">
	<script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.1.custom.min.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=places"></script>
	<script type="text/javascript" src="js/search.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
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
					<li class="bold inline link"><a href="bet.jsp">Bet</a></li>
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
		<section class="content left">
			<section id="search">
				<section id="search-location">
					<h3>Location and Place Type</h3>
					<input type="text" id="address" class="advanced-search ui-autocomplete" value="Coimbra, Portugal" name="address">
					<div id="map_canvas" style="width:550px; height:350px"></div>
					<select id="type-search-select" name="type-search-box" class="advanced-category">
						<option value="xx">Choose Place Type</option> 
						<option value="restaurant,bar,cafe,food">Food</option>
						<option value="hospital,pharmacy,doctor,health">Health</option>
						<option value="bank,atm">Banking</option>
						<option value="shopping_mall,liquor_store">Shopping</option>
						<option value="school,university,library">Education</option>
						<option value="night_club,amusement_park,casino,movie_theater,movie_rental,bowling_alley">Entertainement</option>
						<option value="bus_station,taxi_stand,train_station,gas_station,airport,subway_station">Mobility</option>			
					</select>
				</section>
				<section id="map-output"></section>
			</section>
		</section>
		<section class="mini-sidebar left">
			<section id="search-controls">
<!--
				<section id="radius">
					<h3>Radius</h3>
					<span id="dec-radius">-</span><span id="show-radius">5000 meters</span><span id="inc-radius">+</span>
				</section>
-->
			</section>
		</section>
		<div class="clear"></div>
	</section>
    </body>
</html>
