<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CMPE275 TEAM7 ABOUT</title>

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
                <a class="navbar-brand" href="index"><font color=blue>GET VIRTUAL</a></font>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active">
                        <a href="#" >About</a>
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
                    
                    <li class="active">About</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Intro Content -->
        <div class="row">
            <div class="col-md-6">
                <img class="img-responsive" src="<c:url value="/resources/img/virtual.jpg" />" alt="" />
            </div>
            <div class="col-md-6">
                <h2><font color=blue>About Get Virtual</h2></font>
                <p>A web application that can provide service to the small scale companies or users who need private cloud to deploy their virtual machines.</p>
                <p>We have developed a private cloud service provided as a web application. The private cloud acts as a server and it will provide hosts for the creation of virtual machines. The user’s request for host will be fulfilled by the administrator. The clients will use those hosts provided by the administrator to create their virtual machines. The machine creation will be done by the use of templates which is supposed to be a quicker way.The templates of different configurations will be provided by the administrator on client’s demand. Thus client will get on demand access to his own host through this web application.</p>

            </div>
        </div>
        <!-- /.row -->

        <!-- Team Members -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header"><b>CMPE 275 TEAM 7</h2></b>
            </div>
            <div class="col-md-4 text-center">
                <div class="thumbnail">
                    <img class="img-responsive" src="<c:url value="/resources/img/bharti.jpg"/>"  alt=""/>
                    <div class="caption">
                        <h3>Bharti Kodwani<br></h3>
                         <h5>   SJSU ID: 010014329<br>
                            <a href="mailto:bharti.kodwani@sjsu.edu">bharti.kodwani@sjsu.edu</a><br>
                           </h5>
                        
                       
                    </div>
                </div>
            </div>
            <div class="col-md-4 text-center">
                <div class="thumbnail">
                    <img class="img-responsive" src="<c:url value="/resources/img/apurva.jpg"/>"  alt=""/>
                    <div class="caption">
                        <h3>Apurva Dixit<br></h3>
                           <h5>SJSU ID: 009984559<br>
                            <a href="mailto:apurva.dixit@sjsu.edu">apurva.dixit@sjsu.edu</a><br> </h5> 
                    </div>
                </div>
            </div>
            
            <div class="col-md-4 text-center">
                <div class="thumbnail">
                    <img class="img-responsive" src="<c:url value="/resources/img/priyanka.jpg"/>"  alt=""/>
                    <div class="caption">
                        <h3>Priyanka Karpe<br></h3>
                            <h5>SJSU ID: 009999275<br>
                            <a href="mailto:priyanka.karpe@sjsu.edu">priyanka.karpe@sjsu.edu</a><br>
                        </h5>
                        
                        
                    </div>
                </div>
            </div>
            
            <div class="col-md-4 text-center" align="center">
                <div class="thumbnail" >
                    <img class="img-responsive" src="<c:url value="/resources/img/shubham.jpg"/>"  alt=""/>
                    <div class="caption"  >
                        <h3>Shubham Rajvanshi<br></h3>
                           <h5> SJSU ID: 009428744<br>
                        <a href="mailto:shubham.rajvanshi@sjsu.edu">shubham.rajvanshi@sjsu.edu</a><br>
                        </h5>
                    </div>
                </div>
            </div>
        <!-- /.row -->

        <hr><hr>

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
