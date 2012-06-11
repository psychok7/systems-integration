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
            <section id="barline">
                <div class="clear"></div>
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
                <section id="auth">
                    <h1>Register</h1>
                    <form id="register-form" action="/Phasebook-war/UserController.do" method="post">
                        <input type="hidden" id="hidMethod" name="hidMethod" value="register"/>
                        <fieldset>
                            <label>Name</label>
                            <div class="clear"></div>
                            <input class="auth" type="text" id="name" name="name"/>
                            <div class="clear"></div>
                            <label>Email</label>
                            <div class="clear"></div>
                            <input class="auth" type="text" id="e-mail" name="e-mail"/>
                            <div class="clear"></div>
                            <label>Password</label>
                            <div class="clear"></div>
                            <input class="auth" type="password" id="password" name="password"/>
                            <div class="clear"></div>
                            <input type="submit" class="button" name="commit" value="Register"/>	
                            <div class="clear"></div>
                        </fieldset>
                    </form>
                </section>
                <section id="auth">
                    <h2><a href="login.jsp">I already have an account.</a></h2>
                </section>
            </section>
            <div class="clear"></div>
        </section>
    </body>

</html>
