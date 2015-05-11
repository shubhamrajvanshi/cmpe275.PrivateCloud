<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CMPE275 TEAM7 VMDETAILS</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/modern-business.css" />" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    
    <!-- jQuery -->
    <script src="<c:url value="resources/js/jquery.js" />" ></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>

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
                <h1 class="page-header">DETAILS OF VIRTUAL MACHINE:</h1>
                <ol class="breadcrumb">
                    <li><a href="index">Home</a>
                    </li>
                </ol>
            </div>
        </div>


        <!-- /.row -->

        <div class="row">
            <!-- Blog Entries Column -->
            <div class="col-md-12">

            <h4>Virtual machines:</h4>
            
                <table style="width:100%">
                    <tr>
                    <td><b>MACHINE NAME</b></td>
                    <td><b>OS</b></td>
                    <td><b>MEMORY</b></td>
                    <td><b>CPU</b></td>
                    <td><b>START/STOP</b></td>
                    <td><b>DELETE</b></td>
                    </tr>
                    <tr>
                    <td>${vms.vmname}</a></td>
                    <td><b>Windows</b></td>
                    <td><b>512 MB</b></td>
                    <td><b>1</b></td>
                    <td>
                    <c:if test = "${vms.vmstate==1}">
                    <b><a href="vm/${vms.vmname}/${vms.vmstate}">Stop</a></b>
                    </c:if>
                    <c:if test = "${vms.vmstate==0}">
                    <b><a href="vm/${vms.vmname}/${vms.vmstate}">Start</a></b>
                    </c:if>
                    </td>
                    <td><b><a href="vm/${vms.vmname}/${vms.vmstate}">Delete</a></b></td>
                
                    </tr>                
                </table>
                
            </div>

        </div>
                
                <hr>
                <!--row-->
                
                    
                        <div class="col-md-12" align ="center">
                          		<form action="vmdetails">
                        <font color="blue"><a href="createvm">CREATE A VIRTUAL MACHINE</a></font>
                        </form>
                        </div>
                    <div class="row">
                   
                </div>     
                

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12" align = "center">
                    <p>TEAM 7 - CMPE275</p>
                </div>
            </div>
        </footer>
    </div>
 
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
