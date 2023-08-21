<%-- 
   Document   : profile
   Created on : 23-Feb-2023, 11:48:42 AM
   Author     : dibyajyotimishra
--%>

<%@page import="com.wave.entities.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.wave.entities.User"%>
<%@page errorPage="error.jsp" %>
<%
    User user = (User) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome | Wave</title>

        <!--Favicon Scripts-->
        <link rel="apple-touch-icon" sizes="180x180" href="img/favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="img/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="img/favicon/favicon-16x16.png">
        <link rel="manifest" href="img/favicon/site.webmanifest">
        <!--Favicon Scripts-->

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <style>
            .banner-bg {
                clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 100%, 70% 95%, 30% 98%, 0 92%, 0 0);
                background: rgba(1, 43, 76, 0.95) !important;

            }
        </style>
    </head>
    <body>

        <!--navbar-->

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background: #012B4C !important">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp"><span class="fa fa-compass"></span>  Wave</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Genres
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Front-end</a></li>
                                <li><a class="dropdown-item" href="#">Back end</a></li>
                                <li><a class="dropdown-item" href="#">Databases</a></li>
                                <li><a class="dropdown-item" href="#">Tools</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="navbar-nav mr-right">
                        <li class="nav-item">
                            <a href="#!" data-bs-toggle="modal" data-bs-target="#profileModal" class="nav-link"><span class="fa fa-user"></span> <%= user.getFirstName() + " " + user.getLastName()%></a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-light" href="logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!--navbar-->

        <%
            Message message = (Message) session.getAttribute("message");
            if (message != null) {
        %>

        <div class="alert <%= message.getCssClass()%> alert-dismissible fade show" role="alert">
            <strong> <%= message.getMessageReaction()%> </strong> <%= message.getMessageContent()%>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>


        <%
                session.removeAttribute("message");
            }
        %>



        <!--Profile Modal-->

        <!-- Modal -->
        <div class="modal fade" id="profileModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">User Details</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="container text-left">
                            <img class="image-fluid ml-3" style="width: 100px;" src="./images/<%= user.getProfilePicture()%>" alt="alt"/>
                            <div id="profile-details">
                                <p>Name: <%= user.getFirstName() + " " + user.getLastName()%></p>
                                <p>Email: <%= user.getEmail()%></p>
                                <p style="font-style: italic;"><%= user.getRegisteredMonth()%></p>  
                            </div>
                            <div id="profile-edit" style="display: none;">
                                <h3>Edit Your Profile</h3>
                                <form action="edit" method="POST" enctype="multipart/form-data">
                                    <div class="row mb-3">
                                        <div class="col">
                                            <input type="text" class="form-control" aria-label="First name" name="firstName" value="<%= user.getFirstName()%>">
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control" aria-label="Last name" name="lastName" value="<%= user.getLastName()%>">
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleInputPassword1" class="form-label">Password</label>
                                        <input type="text" class="form-control" id="exampleInputPassword1" name="password">
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleInputFile" class="form-label">Upload Profile Picture</label>
                                        <input type="file" accept="image" class="form-control" id="exampleInputFile" name="profilePicture">
                                    </div>
                                    <button type="submit" id="save-btn" class="btn btn-outline-primary" style="display: none">Save</button>
                                </form>

                            </div>
                        </div>
                        <div class="modal-footer">
                            <button id="edit-btn" class="btn btn-outline-primary">Edit</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--Profile Modal-->


        <!--All JS scripts-->
        <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
        <script src="js/index.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                let editStatus = false;
                $('#edit-btn').click(function () {
                    editStatus = !(editStatus == true);
                    if (editStatus) {
                        $('#profile-details').hide();
                        $('#profile-edit').show();
                        $('#save-btn').show();
                        $(this).text("Exit").removeClass("btn-outline-primary").addClass("btn-outline-danger")
                    } else {
                        $('#profile-details').show();
                        $('#profile-edit').hide();
                        $('#save-btn').hide();
                        $(this).text("Edit").removeClass("btn-outline-danger").addClass("btn-outline-primary");
                    }

                });
            });
        </script>
    </body>
</html>
