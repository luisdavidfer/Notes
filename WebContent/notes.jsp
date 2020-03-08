<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Font -->
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

    <title>Hello, world!</title>
    <style>
        *{
            font-family: 'Roboto', sans-serif;
        }
        header{
            box-shadow: 0px 1px 5px #00000050;
            color: white;
            fill: white;
        }
        .card{
            cursor: default;
            max-height: 300px;
            overflow: hidden;
        }
        .card:hover{
            border: 1px solid rgba(0,0,0,.250);
        }
        .btn-close{
            position: relative;
            width: 20px;
            height: 20px;
            float: right;
            top: -15px;
            left: 15px;
            fill: #212529;
            display: none;
        }
        .btn-modal-close{
            position: relative;
            width: 20px;
            height: 20px;
            float: right;
        }
        .btn-close:hover{
            opacity: 0.75;
        }
        .btn-create{
            width: 50px;
            height: 50px;
            position: fixed;
            bottom: 30px;
            right: 50px;
            box-shadow: 0px 2px 15px #00000070;
            border-radius: 100%;
        }
        .btn-create svg{
            width: 50px;
            height: 50px;;
            fill: #28a745;
        }

        .btn-create svg:hover{
            animation-name: spin;
            animation-duration: 500ms;
        }

        @keyframes spin {
            from {
                transform:rotate(0deg);
            }
            to {
                transform:rotate(90deg);
            }
        }

        @media (min-width: 576px){
            .modal-sm {
                max-width: 500px!important;
            }    
        }

        input, textarea{
            border: none;
        }
        textarea{
            min-height: 100px;
        }
        
        *:focus {
            outline: none;
        }

        @media (max-width: 300px){
            .btn-create{
                margin: 15px auto;
                position: static;
                box-shadow: 0px 2px 10px #00000070;
            }
        }
        .icon{
            margin-right: 5px;
            margin-bottom: 5px;
        }
        #username{
        	max-width: 500px;
        	overflow: hidden;
        	text-overflow: ellipsis;
        }
    </style>
  </head>
  <body>
    <header>
        <nav class="navbar navbar-dark bg-success align-center">
            <div class="navbar-brand">
                <svg class="icon" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M7.127 22.562l-7.127 1.438 1.438-7.128 5.689 5.69zm1.414-1.414l11.228-11.225-5.69-5.692-11.227 11.227 5.689 5.69zm9.768-21.148l-2.816 2.817 5.691 5.691 2.816-2.819-5.691-5.689z"/></svg>
                <span class="navbar-brand">Notas</span>
            </div>
            <span id="username" class="navbar-brand" href="#">luisdavid</span>
            <a class="navbar-brand" href="#">Cerrar sesión</a>
        </nav>
    </header>
    <div class="container-fluid">

        <div class="row">
        	<c:forEach items="${notes}" var="note" varStatus="status">
	            <div class="col-lg-3 col-md-4 col-sm-6 col-12 my-3 mx-0">
	                <div class="card" style="width: 18rem;">
	                    <div class="card-body">
	                        <svg class="btn-close close" height="512px" id="Layer_1" style="enable-background:new 0 0 512 512;" version="1.1" viewBox="0 0 512 512" width="512px" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" ><path d="M443.6,387.1L312.4,255.4l131.5-130c5.4-5.4,5.4-14.2,0-19.6l-37.4-37.6c-2.6-2.6-6.1-4-9.8-4c-3.7,0-7.2,1.5-9.8,4  L256,197.8L124.9,68.3c-2.6-2.6-6.1-4-9.8-4c-3.7,0-7.2,1.5-9.8,4L68,105.9c-5.4,5.4-5.4,14.2,0,19.6l131.5,130L68.4,387.1  c-2.6,2.6-4.1,6.1-4.1,9.8c0,3.7,1.4,7.2,4.1,9.8l37.4,37.6c2.7,2.7,6.2,4.1,9.8,4.1c3.5,0,7.1-1.3,9.8-4.1L256,313.1l130.7,131.1  c2.7,2.7,6.2,4.1,9.8,4.1c3.5,0,7.1-1.3,9.8-4.1l37.4-37.6c2.6-2.6,4.1-6.1,4.1-9.8C447.7,393.2,446.2,389.7,443.6,387.1z"/></svg>
	                        <h5 class="card-title">${note.title}</h5>
	                        <p class="card-text">${note.text}</p>
	                        <span name="id" hidden>${note.id}</span>
	                        <span name="userId" hidden>${note.userId}</span>
	                    </div>
	                </div>
	            </div>
			</c:forEach>
        </div>
    </div>
    <div class="btn-create">
        <?xml version="1.0" encoding="iso-8859-1"?><!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"><svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="416.979px" height="416.979px" viewBox="0 0 416.979 416.979" style="enable-background:new 0 0 416.979 416.979;" xml:space="preserve"><g><path d="M208.489,0C93.343,0,0,93.343,0,208.489c0,115.146,93.343,208.489,208.489,208.489s208.49-93.344,208.49-208.489 C416.979,93.343,323.635,0,208.489,0z M329.006,235.1c0,6.299-5.105,11.404-11.404,11.404h-71.099v71.1 c0,6.298-5.106,11.404-11.404,11.404h-53.22c-6.298,0-11.404-5.106-11.404-11.404v-71.1h-71.1c-6.298,0-11.404-5.106-11.404-11.404 v-53.22c0-6.298,5.106-11.404,11.404-11.404h71.1v-71.1c0-6.298,5.105-11.404,11.404-11.404h53.22 c6.298,0,11.404,5.106,11.404,11.404v71.1h71.099c6.299,0,11.404,5.106,11.404,11.404V235.1L329.006,235.1z"/></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
    </div>

    <div id="modal" class="modal fade bd-example-modal-sm">
        <div class="modal-dialog modal-sm align-middle">
            <div class="modal-content card-body">
                <div>
                    <svg class="btn-modal-close close" height="512px" id="Layer_1" style="enable-background:new 0 0 512 512;" version="1.1" viewBox="0 0 512 512" width="512px" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="M443.6,387.1L312.4,255.4l131.5-130c5.4-5.4,5.4-14.2,0-19.6l-37.4-37.6c-2.6-2.6-6.1-4-9.8-4c-3.7,0-7.2,1.5-9.8,4  L256,197.8L124.9,68.3c-2.6-2.6-6.1-4-9.8-4c-3.7,0-7.2,1.5-9.8,4L68,105.9c-5.4,5.4-5.4,14.2,0,19.6l131.5,130L68.4,387.1  c-2.6,2.6-4.1,6.1-4.1,9.8c0,3.7,1.4,7.2,4.1,9.8l37.4,37.6c2.7,2.7,6.2,4.1,9.8,4.1c3.5,0,7.1-1.3,9.8-4.1L256,313.1l130.7,131.1  c2.7,2.7,6.2,4.1,9.8,4.1c3.5,0,7.1-1.3,9.8-4.1l37.4-37.6c2.6-2.6,4.1-6.1,4.1-9.8C447.7,393.2,446.2,389.7,443.6,387.1z"/></svg>
                </div>
                <form action="" action="post">
	                <input placeholder="Título" name="title" type="text" class="card-title"></h5>
	                <textarea placeholder="Añade una nota..." rows="15" name="text" class="card-text"></textarea>
	                <input type="hidden" name="userId" value="">
	                <input type="hidden" name="id" value="">
                </form>
            </div>
        </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script>
        $(function(){
            $(".card").hover(function(){
                $(".btn-close").show(1000);
            }, function(){
                $(".btn-close").hide(1000);
            });
            $(".btn-create").click(function(){
                $("#modal").modal("show");
                $("#modal [name='title']").val("");
                $("#modal [name='text']").val("");
                $("#modal [name='userId']").val("");
                $("#modal [name='id']").val("0");
            });
            $(".card").click(function(){
                $("#modal").modal("show");
            });
            if(window.orientation !== undefined){
            	$("#username").hide();
            }
        });
    </script>
  </body>
</html>