<jsp:include page="cabecalho.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:forEach items="${listaPlantas}" var="planta">
		<div class="col-md-10 offset-md-1">
	    	<div class="card card-user">
	        	<div class="card-body">
	            	<p class="card-text">
	                	<div class="author">
		                    <img class="avatar" src="<c:out value="${planta.foto}"></c:out>" alt="...">
		                    <h5 class="title"><c:out value="${planta.nome}"></c:out></h5>
	                 	</div>
	                </p>
				    <div class="card-description">
	                  	<c:out value="${planta.descricao}"></c:out>
	                </div>
				</div>
	           	<div class="card-footer">
	            	<div class="button-container">
		                <a href="<%= request.getContextPath()%>/dashboard/lista-plantas?acao=deletar&planta_id=<c:out value="${planta.id}"></c:out>">
		                	<button class="btn btn-icon btn-round btn-facebook btn-danger">
		                		<i class="fas fa-trash"></i>
		                	</button>
		                </a>
	                </div>
				</div>
			</div>
		</div>
	</c:forEach>

<jsp:include page="rodape.jsp"></jsp:include>