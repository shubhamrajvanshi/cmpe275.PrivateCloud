<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CMPE275 TEAM7 HOMEPAGE</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    
</head>

<body>

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
                <a class="navbar-brand" href="index.jsp"><font color=blue>GET VIRTUAL</font></a>
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

    <!-- Header Carousel -->
    <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('');"></div>
                <div class="carousel-caption">
                    <h4>CREATE/DELETE A VIRTUAL MACHINE</h4>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('');"></div>
                <div class="carousel-caption">
                    <h4>USE CLOUD TECHNOLOGY</h4>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('');"></div>
                <div class="carousel-caption">
                    <h4>ADD A HOST</h4>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>

    <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                   <B><font color=blue>Welcome to 'GET VIRTUAL'</font></B> 
                </h1>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><b><i class="fa fa-fw fa-check"></i>SIGN UP</b></h4>
                    </div>
                    <div class="panel-body">
                        <p><B>START WITH GET VIRTUAL</B></p>
                        <a href="signup.jsp" class="btn btn-default"><b><font color=blue>SIGN UP</font></b></a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><b><i class="fa fa-fw fa-check"></i>SIGN IN</b></h4>
                    </div>
                    <div class="panel-body">
                        <p><b>ALREADY AN USER? </b></p>
                        <a href="signin" class="btn btn-default"><b><font color=blue>SIGN IN</font></b></a>
                    </div>
                </div>
            </div>
        </div>
       

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>TEAM7-CMPE275</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>
