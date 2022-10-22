<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://kit.fontawesome.com/5a459fdd41.js" crossorigin="anonymous"></script>
  <title>Editar cliente</title>
</head>
<body>
<!--cabecera-->
<jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"></jsp:include>
<!--fin cabecera-->

<form action="${pageContext.request.contextPath}/ServletControladorSaldos?accion=modificar&id_cliente=${cliente.id_cliente}"
      method="post" class="was-validated">

  <!--botones de navegacion-->
  <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"></jsp:include>
    <!--fin botones de navegacion-->

  <section id="details">
    <div class="container">
      <div class="row">
        <div class="col">
          <div class="card">
            <div class="card-header">
              <h4>Editar cliente</h4>
            </div>
            <div class="card-body">
              <div class="form-group">
                <%--@declare id="nombres"--%><label for="nombres">nombres</label>
                <input type="text" class="form-control" name="nombres" required value="${cliente.nombres}">
              </div>
              <div class="form-group>
                  <label for="apellidos">apellidos</label>
              <input type="text" class="form-control" name="apellidos" required value="${cliente.apellidos}">
            </div>
            <div class="form-group">
              <label for="email">email</label>
              <input type="email" class="form-control" name="email" required value="${cliente.email}">
            </div>
            <div class="form-group">
              <label for="telefono">telefono</label>
              <input type="tel" class="form-control" name="telefono" required value="${cliente.telefono}">
            </div>
            <div class="form-group">
              <label for="saldo">saldo</label>
              <input type="number" class="form-control" name="saldo" required value="${cliente.saldo} step="any">
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>
  </section>
</form>
<!-- pie de pagina -->
<jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"></jsp:include>
<!-- fin pie de pagina -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>