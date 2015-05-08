<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CMPE275 TEAM7 SERVICE</title>

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
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index"><font color=blue>GET VIRTUAL</a></font>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="about">About</a>
                    </li>
                    <li class="active">
                        <a href="services">Services</a>
                    </li>
                    
                    </ul>
                    
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                 <h1 class="page-header">
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index">Home</a>
                    </li>
                    <li class="active">Services</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

               

        <!-- Service Tabs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header"><font color=blue>Service Provided</h1></font>
            </div>
            <div class="col-lg-12">

                <ul id="myTab" class="nav nav-tabs nav-justified">
                    <li class="active"><a href="#service-one" data-toggle="tab"><i class="fa fa-support"></i> Service One</a>
                    </li>
                    <li class=""><a href="#service-two" data-toggle="tab"><i class="fa fa-support"></i> Service Two</a>
                    </li>
                    <li class=""><a href="#service-three" data-toggle="tab"><i class="fa fa-support"></i> Service Three</a>
                    </li>
                    
                </ul>

                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade active in" id="service-one">
                        <h4>Account Management</h4>
                        <p>1. Authentication for both admin and clients through ‘Sign on’ functionality</p>
                    </div>
                    <div class="tab-pane fade" id="service-two">
                        <h4>Admin Function</h4>
                        <p>1. Host Creation</p>
                        <p>2. Host Deletion</p>
                        <p>3. Display Virtual Machine Details</p>
                        <p>4. Display Host Details</p>
                        <p>5. Accept/Decline client request</p>
                        <p>6. Post on user’s dashboard if any new host machine is created.</p>
                    </div>
                    <div class="tab-pane fade" id="service-three">
                        <h4>Client Functions</h4>
                        <p>1. List active virtual machines.</p>
                        <p>2. List the configuration details of the virtual machines.</p>
                        <p>3. Create a customized virtual machine.</p>
                        <p>4. Delete a virtual machine</p>
                        <p>5. Request for a host to the admin.</p>
                    </div>
                   
                </div>

            </div>
        </div>

        

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

</body>

</html>
