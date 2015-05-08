<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CMPE275 TEAM7 ADMIN PAGE </title>

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
                    <span class="sr-only">Toggle navigation</span>
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
                    <li>
                        <a href="logout">Logout</a>
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
                <h1 class="page-header">WELCOME ${user.firstname}
                    <small>${user.email}</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index">Home</a>
                    </li>
                </ol>
            </div>
        </div>


        <!-- /.row -->

        <div class="row">
            <!-- Blog Entries Column -->
            <div class="col-md-9">

            <h4>LIST OF ALL VIRTUAL MACHINES:</h4>
                <table style="width:100%">
                
                    <tr>
                     <td><a href="vmdetails">${u.vmname}</a></td>
                 </tr>
                       <tr>
                     <td><a href="vmdetails">vm2</a></td>
                 </tr>
                
                </table>
            </div>

            <!-- Blog Sidebar Widgets Column -->
            <div class="col-md-3">

                <!-- Blog Search Well -->
                <div class="well">
                    <h4>Search Virtual Machine </h4>
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                    <!-- /.input-group -->
                </div>
                 <!-- /.row -->
                </div>
        </div>
                <!-- create vm -->
                <!--create row-->
                <div class="row">
                    <div class="col-md-6">
                    <!-- column 1-->
                    <form action="addhost">
                    <font color="blue"><input id="addhost" type="submit" name="addhost" value="ADD A HOST"></font></input>
                    </form>
                    </div>
                    <!-- column   2-->
                    <div class="col-md-6">
                   
                    </div>
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


</body>

</html>
