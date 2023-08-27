<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register JSP</title>

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
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body>

        <!--Navbar-->
        <%@include file="navbar.jsp" %>

        <main class="d-flex align-items-center banner-bg" style="height: 70vh;">
            <div class="container mb-3">
                <div class="row">
                    <div class="col-md-4 offset-md-4">
                        <div class="card">
                            <div class="card-header text-center">
                                Sign up to Continue
                            </div>
                            <form id="registerForm" class="card-body" action="register" method="POST">
                                <div class="row mb-3">
                                    <div class="col">
                                        <input type="text" class="form-control" placeholder="First name" aria-label="First name" name="firstName">
                                    </div>
                                    <div class="col">
                                        <input type="text" class="form-control" placeholder="Last name" aria-label="Last name" name="lastName">
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
                                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else or spam you.</div>
                                </div>
                                <div class="mb-3">
                                    <label for="exampleInputPassword1" class="form-label">Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
                                </div>
                                <div class="container text-center" id="loader" style="display: none;">
                                    <p><span class="fa fa-refresh fa-spin fa-1x"></span> Please wait... </p>   
                                </div>

                                <div class="d-grid gap-2 mb-3">
                                    <button type="submit" id="submit-button" class="btn btn-outline-dark">Sign Up <span class="fa fa-paper-plane-o"></span></button>
                                </div>
                                <div>Already registered ? Continue to <a href="login.jsp">Log in</a>.</div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>


        <!--All JS scripts-->
        <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#registerForm').on('submit', function (event) {
                    event.preventDefault();
                    $("#submit-button").hide();
                    $("#loader").show();
                    let formData = new FormData(this);
                    // send to register servlet
                    $.ajax({
                        url: "register",
                        type: "POST",
                        data: formData,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            if(data.trim() == "ok") {
                                console.log("Hi");
                            }
                            $("#submit-button").show();
                            $("#loader").hide();

                            $('#registerForm').get(0).reset();

                            if (data.trim() == "Error") {
                                swal("Oh Snap!", "Something went Wrong", "error", {
                                    button: "Try Again!"
                                });
                            }
                            } else {
                             swal("Welcome to Wave!", "Login to continue...", "success", {
                                    button: null
                                }).then(_ => window.location = "login.jsp");   
                        },
                        processData: false,
                        contentType: false
                    });
                });
            });
        </script>
    </body>
</html>