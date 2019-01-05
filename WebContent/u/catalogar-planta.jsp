<jsp:include page="cabecalho.jsp"></jsp:include>
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
		<form style="margin-top:5%;" action="../add-planta" method="post">
        	<div class="row">
            	<div class="col-md-8 offset-md-2">
             		<div class="form-group">
                    	<label>Nome da planta</label>
               			<input type="text" name="nome_planta" class="form-control" placeholder="Nome" required>
                	</div>
			    </div>
            </div>
            <div class="row">
            	<div class="col-md-8 offset-md-2">
             		<div class="form-group">
                    	<label>Descrição da Planta</label>
               			<textarea name="descricao" class="form-control" rows="10" required></textarea>
                	</div>
			    </div>
            </div>
            <div class="row">
            	<div class="col-md-8 offset-md-2">
             		<div class="form-group">
                    	<label>URL da imagem</label>
               			<input type="text" name="foto" class="form-control" placeholder="URL" required>
                	</div>
			    </div>
            </div>
            
            <div class="row">
	            <div class="col-md-8 offset-md-2">
	                <button type="submit" class="btn btn-fill btn-info">Catalogar</button>
	            </div>	
	        </div>	
		</form>
<jsp:include page="rodape.jsp"></jsp:include>