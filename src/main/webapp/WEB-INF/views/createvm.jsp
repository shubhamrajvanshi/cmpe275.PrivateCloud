<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CMPE275 TEAM7 CREATEVM</title>

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

<body  background="a.jpg">
    
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

        <div class="row">
            <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">CREATE VIRTUAL MACHINE</h1>
                <ol class="breadcrumb">
                    <li><a href="index">Home</a>
                    </li>
                </ol>
            </div>
        </div>
            
            <form:form action="vm/email/vmname/" method="POST" modelAttribute="vMD">
                    Give name for virtual machine:<br>
                    <form:input path="vmname" />
                    <br>   
                    Select template:<br>
                    <form:radiobutton path="template" value="1" label="Virual machine 1" /><br>
                    <form:radiobutton path="template" value="2" label="Virual machine 2" /><br>
                    <form:radiobutton path="template" value="3" label="Virual machine 3" /><br>
                    <form:radiobutton path="template" value="4" label="Virual machine 4" /><br>
                    <form:radiobutton path="template" value="5" label="Virual machine 5" /><br>
                    <form:radiobutton path="template" value="6" label="Virual machine 6" /><br>
                    <form:radiobutton path="template" value="7" label="Virual machine 7" /><br>
                    <form:radiobutton path="template" value="8" label="Virual machine 8" /><br>
                    
                <br>
                <br>
                <font color=blue>
                <!--<input id="submit" type="submit" value="CREATE VIRTUAL MACHINE" onclick="alert('Login Credentials:\nusername:administrator\npassword:12!@qwQW')" />-->
                <input id="submit" type="submit" value="CREATE VIRTUAL MACHINE" onclick="sendvmdetails()" />
                
                </font>
                </form:form>
             <script>
             function sendvmdetails(){
                alert('Login Credentials:\nusername:administrator\npassword:12!@qwQW');
             }
             </script>
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
