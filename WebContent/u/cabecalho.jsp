<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="PT-br">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="<%= request.getContextPath()%>/assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="<%= request.getContextPath()%>/assets/img/favicon.png">
  <title>
    iPlants
  </title>
  <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800" rel="stylesheet" />
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
  <link href="<%= request.getContextPath()%>/assets/css/nucleo-icons.css" rel="stylesheet" />
  <link href="<%= request.getContextPath()%>/assets/css/black-dashboard.css?v=1.0.0" rel="stylesheet" />
  <link href="<%= request.getContextPath()%>/assets/demo/demo.css" rel="stylesheet" />
</head>

<body>
	<div class="wrapper">
		<!-- MENU LATERAL -->
		<div class="sidebar">
			<div class="sidebar-wrapper" style="background: #6dc569">
				<div class="logo">
			      	<a href="javascript:void(0)" class="simple-text logo-mini">
			        	Olá
			      	</a>
			      	<a href="javascript:void(0)" class="simple-text logo-normal">
			        	${ sessionScope.usuario.nome}
			      	</a>
			   	</div>
			   	<ul class="nav">
			    	<li>
			        	<a href="<%= request.getContextPath()%>/dashboard/catalogar-planta">
			          		<i class="tim-icons icon-simple-add"></i>
			          		<p>Catalogar Plantas</p>
			        	</a>
			    	</li>
			      	<li>
			        	<a href="<%= request.getContextPath()%>/dashboard/lista-plantas">
			          		<i class="tim-icons icon-paper"></i>
			          		<p>Listar Plantas</p>
			        	</a>
			      	</li>
			   	</ul>
			</div>
		</div>
		<!-- END MENU LATERAL -->
		
	  	<div class="main-panel">
	      	<!-- Navbar -->
	      	<nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
	        	<div class="container-fluid">
	          		<div class="navbar-wrapper">
	            		<div class="navbar-toggle d-inline">
				              <button type="button" class="navbar-toggler">
					                <span class="navbar-toggler-bar bar1"></span>
					                <span class="navbar-toggler-bar bar2"></span>
					                <span class="navbar-toggler-bar bar3"></span>
				              </button>
	            		</div>
	            		<a class="navbar-brand" href="<%= request.getContextPath()%>/dashboard">I <i class="fab fa-pagelines "></i> Plants</a>
	          		</div>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-bar navbar-kebab"></span>
						<span class="navbar-toggler-bar navbar-kebab"></span>
						<span class="navbar-toggler-bar navbar-kebab"></span>
					</button>
	          		<div class="collapse navbar-collapse" id="navigation">
	            		<ul class="navbar-nav ml-auto">
			                <% if ((Boolean)request.getSession().getAttribute("admin") == true){ %>
			                <li class="dropdown nav-item">
								<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
							    	<i class="tim-icons icon-sound-wave"></i>
								</a>
	                			<ul class="dropdown-menu dropdown-menu-right dropdown-navbar">
									<li class="nav-link">
										<a href="<%= request.getContextPath()%>/dashboard/relatorio-usuarios" class="nav-item dropdown-item">Gerar relatório de usuários</a>
									</li>
									<li class="nav-link">
										<a href="<%= request.getContextPath()%>/dashboard/relatorio-plantas" class="nav-item dropdown-item">Gerar relatório de plantas catalogadas</a>
									</li>
								</ul>
	              			</li>
	              			<% } %>
							<li class="dropdown nav-item">
								<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
									<div class="photo">
								    	<img src="<%= request.getContextPath()%>/assets/img/anime3.png" alt="Profile Photo">
									</div>
									<b class="caret d-none d-lg-block d-xl-block"></b>
								</a>
								<ul class="dropdown-menu dropdown-navbar">
								    <li class="nav-link">
								    	<a href="<%= request.getContextPath()+"/"%>" class="nav-item dropdown-item">Sair</a>
								    </li>
								</ul>
							</li>
	              			<li class="separator d-lg-none"></li>
	            		</ul>
	          		</div>
	        	</div>
	      </nav>
	      <div class="content">
        		<div class="row">
          			<div class="col-12">