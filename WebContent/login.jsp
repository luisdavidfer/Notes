<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Luis David Fernández Marín">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Font -->
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

    <title>Notas</title>
    <style>
        *{
            font-family: 'Roboto', sans-serif;
            outline: 0;
        }
        
        .login-page {
            width: 360px;
            padding: 8% 0 0;
            margin: auto;
        }
        .form {
            left: 50%;
            top: 50%;
            transform: translate(-50%,-50%);
            position: absolute;
            z-index: 1;
            background: #FFFFFF;
            max-width: 360px;
            padding: 30px;
            text-align: center;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
            border-radius: .25rem;
        }
        .form input {
            width: 100%;
            border: 0;
            border-bottom: 1px solid #b3b3b3;
            margin: 0 0 15px;
            padding: 15px 15px 5px 10px;
            box-sizing: border-box;
            font-size: 14px;
        }
        .form input:focus {
            border-bottom: 1px solid #28a745;
        }
        .form button {
            text-transform: uppercase;
            background: #4CAF50;
            width: 100%;
            border: 0;
            padding: 15px;
            color: #FFFFFF;
            font-size: 14px;
            -webkit-transition: all 0.3 ease;
            transition: all 0.3 ease;
            cursor: pointer;
            margin-top: 20px;
        }
        .form button:hover,.form button:active,.form button:focus {
            background: #28a745;
        }
        .form .message {
            margin: 20px 0 0;
            color: #b3b3b3;
            font-size: 12px;
        }
        .form .message a {
            color: #28a745;
            text-decoration: none;
        }
        .form .register-form {
            display: none;
        }
        .container {
            position: relative;
            z-index: 1;
            max-width: 300px;
            margin: 0 auto;
        }
        body {
            background: #28a745; /* fallback for old browsers */
         }
        .icon{
            fill: #28a745;
            width: 30px;
            height: 30px;
            position: relative;
            margin-bottom: 30px;
            
        }
        .icon-animation{
            animation-name: spin;
            animation-duration: 500ms;
            animation-play-state: running;
        }
        @keyframes spin {
            from {
                transform:rotate(0deg);
            }
            to {
                transform:rotate(360deg);
            }
        }
        #error{
        	color:red;
        	font-size:small;
        	font-style:italic;
        }
    </style>
  </head>
  <body>
    <div class="login-page">
        <div class="form">
            <svg class="icon" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M7.127 22.562l-7.127 1.438 1.438-7.128 5.689 5.69zm1.414-1.414l11.228-11.225-5.69-5.692-11.227 11.227 5.689 5.69zm9.768-21.148l-2.816 2.817 5.691 5.691 2.816-2.819-5.691-5.689z"/></svg>
  			<p id="error">${message}</p>
            <form class="register-form" action="session" method="post">
                <input name="username" type="text" placeholder="Nombre"/>
                <input name="password" type="password" placeholder="Contraseña"/>
                <input name="email" type="email" placeholder="Correo electrónico"/>
                <input type="hidden" name="action" value="register">
                <button>Registrarse</button>
                <p class="message">¿Ya tienes una cuenta? <a href="#">Inicia sesión</a></p>
            </form>
            <form class="login-form" action="session" method="post">
                <input name="email" type="email" placeholder="Correo electrónico"/>
                <input name="password" type="password" placeholder="Contraseña"/>
                <input type="hidden" name="action" value="login">
                <button>Iniciar Sesión</button>
            	<p class="message">¿No tienes una cuenta? <a href="#">Regístrate aquí</a></p>
            </form>
        </div>
      </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script>
        $(function(){
            $('.message a').click(function(){
                $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
                $(".icon").css("animation", "spin 500ms 1");
                $(".icon").on("animationend", function(){
                    $(".icon").css("animation", "none");
                });
            });
        });
    </script>
  </body>
</html>