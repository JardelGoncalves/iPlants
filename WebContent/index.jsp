<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="assets/img/favicon.png">
  <title>
    iPlants
  </title>
  <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800" rel="stylesheet" />
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
  <link href="assets/css/nucleo-icons.css" rel="stylesheet" />
  <link href="assets/css/black-dashboard.css?v=1.0.0" rel="stylesheet" />
  <link href="assets/demo/demo.css" rel="stylesheet" />
  <style>
  .navbar-cell {
  	margin-top:10%;
  }
  @media screen and (max-width: 700px) {
	.navbar-cell {
		margin-top: 25%;
	}
  }
  </style>
</head>

<body style="background: #6dc569">
	<!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
    	<div class="container-fluid">
        	<div class="navbar-wrapper" style="margin-top: 2%">
            	<a class="navbar-brand" href="">I <i class="fab fa-pagelines "></i> Plants</a>
          	</div>
        </div>
    </nav>
    <!-- End Navbar -->
	<div class="wrapper">
	  	<div class="container">
      		<div class="row">
        		<div class="col-12 navbar-cell">
        			<!-- Card Error -->
        			<% if( request.getAttribute("error") != null){ %>
        			<div class="card col-md-8 offset-md-2" style="background: yellow;">
						<div class="card-body">
							<p style="color: black;"> <%= request.getAttribute("error") %> </p>
						</div>
					</div>
					<% request.setAttribute("error", null); 
					  } %>
					<!-- End Card Error -->
					
					<% if( request.getAttribute("success") != null){ %>
					<!-- Card Error -->
        			<div class="card col-md-8 offset-md-2 bg-info">
						<div class="card-body">
							<p> <%= request.getAttribute("success") %> </p>
						</div>
					</div>
					<% request.setAttribute("sucess", null); 
					  } %>
					<!-- End Card Error -->
					
        			<!-- Card -->
          			<div class="card col-md-8 offset-md-2 bg-transparent">
            			<div class="card-header ">
                			<div class="text-center">
                  				<h2 class="card-title">Login</h2>
               				</div>
            			</div>
            			<div class="card-body">
            			<!-- Form -->
            			<%
            				request.getSession().invalidate();
            			%>
            				<form style="margin-top:5%;" action="auth" method="post">
                  				<div class="row">
                    				<div class="col-md-8 offset-md-2">
                      					<div class="form-group">
					                        <label>Email</label>
					                        <input type="text" name="email" class="form-control" placeholder="Email">
			                      		</div>
			                    	</div>
			                  	</div>
			                  	<div class="row">
                    				<div class="col-md-8 offset-md-2">
                      					<div class="form-group">
					                        <label>Senha</label>
					                        <input type="password" name="senha" class="form-control" placeholder="Senha">
			                      		</div>
			                    	</div>
			                  	</div>
			                  	<div class="card-footer col-md-8 offset-md-2">
                					<button type="submit" class="btn btn-fill btn-info">Acessar</button>
              					</div>
              					
			               </form>
            			<!-- End Form -->
            			</div>
          			</div>
          			<!-- End Card -->
          			
          			<div class="col-md-8 offset-md-2 text-center">
          				<p>Você ainda não possui uma conta? <a class="text-muted" href="cadastro.jsp"><strong>Clique aqui</strong></a> para se cadastrar!</p>
          			</div>
        		</div>
      		</div>
	  	</div>
	</div>
  
	  <script src="assets/js/core/jquery.min.js"></script>
	  <script src="assets/js/core/popper.min.js"></script>
	  <script src="assets/js/core/bootstrap.min.js"></script>
	  <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	  <!--  Notifications Plugin    -->
	  <script src="assets/js/plugins/bootstrap-notify.js"></script>
	  <!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
	  <script src="assets/js/black-dashboard.min.js?v=1.0.0"></script>
	  <!-- Black Dashboard DEMO methods, don't include it in your project! -->
	  <script src="assets/demo/demo.js"></script>
</body>

</html>