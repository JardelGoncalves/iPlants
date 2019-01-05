<jsp:include page="cabecalho.jsp"></jsp:include>
	<div class="card card-chart col-md-8 offset-md-2">
		<div class="card-header ">
			<div class="row">
		    	<div class="text-left">
		        	<h2 class="card-title text-success">Quantidade de Plantas catalogadas</h2>
		    	</div>
		  	</div>
		</div>
		<div class="card-body">
		    <p class="text-center text-success" style="font-size: 120px">
		    	<i class="fab fa-pagelines "></i> <%= request.getAttribute("qtdCatalogado")%>
		    </p>
		</div>
    </div>

<jsp:include page="rodape.jsp"></jsp:include>