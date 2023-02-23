<%-- 
    Document   : error
    Created on : 23-Feb-2023, 9:43:11 AM
    Author     : dibyajyotimishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oh Snap! Something went wrong.</title>

        <link rel="apple-touch-icon" sizes="180x180" href="img/error-favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="img/error-favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="img/error-favicon/favicon-16x16.png">
        <link rel="manifest" href="img/error-favicon/site.webmanifest">


        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            .gradient-background {
                height: 100vh;
                width: 100vw;

                display: flex;
                flex: 1;
                justify-content: center;
                align-items: center;


                background: linear-gradient(270deg, #7F7FD5, #86A8E7, #91EAE4);
                background-size: 600% 600%;

                -webkit-animation: AnimationName 13s ease infinite;
                -moz-animation: AnimationName 13s ease infinite;
                animation: AnimationName 13s ease infinite;

                font-family: 'Cookie', cursive;
            }


            .content {
                display: flex;
                flex-direction: row;
                justify-content: space-evenly;
                align-items: center;
                margin-left: 15vw;
            }

            .content-row {
                text-align: center;
                margin-left: 5vw;
            }

            .image-row img {
                max-width: 120%;
                height: auto;
            }

            @-webkit-keyframes AnimationName {
                0%{
                    background-position:0% 50%
                }
                50%{
                    background-position:100% 50%
                }
                100%{
                    background-position:0% 50%
                }
            }
            @-moz-keyframes AnimationName {
                0%{
                    background-position:0% 50%
                }
                50%{
                    background-position:100% 50%
                }
                100%{
                    background-position:0% 50%
                }
            }
            @keyframes AnimationName {
                0%{
                    background-position:0% 50%
                }
                50%{
                    background-position:100% 50%
                }
                100%{
                    background-position:0% 50%
                }
            }
        </style>
    </head>
    <body class="gradient-background">
        <div class="content">
            <div class="image-row">
                <img src="img/assets/error.png" alt="error-monster"/>
            </div>
            <div class="content-row">
                <h2 style="font-size: 44px; margin-right: 15vw;">Uh Oh!</h2>
                <p style="font-size: 28px; margin-right: 13vw;">Sorry, our monster is feeling a little grumpy today and decided to lock us out of the website. We're trying to negotiate with him to let us back in. </p>
                <br>
                <%= exception %>
                <a href="/wave" class="btn btn-outline-dark" style="font-family: Arial; margin-right: 13vw;"><i class="fa fa-long-arrow-left"></i> &nbsp; Back to Home</a>
            </div>
        </div>
    </body>
</html>
