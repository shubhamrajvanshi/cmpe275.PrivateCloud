<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>

<head>

   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>CMPE275 TEAM7 SIGNIN</title>

	<!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/modern-business.css" />" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">    

    
    <style>
        body{
            font-family:verdana;
            }
    </style>
</head>

<body background="a.jpg">

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">TOGGLE</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index"><font color=blue>GET VIRTUAL</font></a>
            </div>  
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="about">About</a>
                    </li>
                    <li>
                        <a href="services">Services</a>
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

        
    </header>


    <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                   <B><font color=blue>SIGN IN HERE!</font></B> 
                </h1>
        </div>
        <div class="row">
            
            <form action="signin" method="POST" >
                   
                   Email:<br>              
                   <input id="email" type="text" name="email"/>
                    <br>
                    Password:<br>                    
                    <input type="password" id='password' name="password" />
                    <br>
                                    <br>
                <br>
                <font color=blue>
                <input id="submit" type="submit" value="Sign In" >
                </font>
            </form>
     <!--        <script>
            function send(){
               var email=document.getElementById('email').value;
               request.setAttribute("email", document.getElementById('email').value);
               //alert(document.getElementById('email').value);
            }

            </script> -->
             
       </div> 
<hr>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>TEAM 7 - CMPE275</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="<c:url value="resources/js/jquery.js" />" ></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>

