<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-headerr">
                        <h4>Listado de clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>nombres</th>
                            <th>saldo</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cliente" items="${clientes}" >
                            <tr>
                                <td>${cliente.id_cliente}</td>
                                <td>${cliente.nombres}  ${cliente.apellidos}</td>
                                <td> <fmt:formatNumber value="${cliente.saldo}" type="currency"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletControladorSaldos?accion=editar&id_cliente=${cliente.id_cliente}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i>Editar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white  mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                        </h4>
                    </div>
                </div >
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Clientes</h3>
                        <h4 class="display-4">
                            <i class="fa fa-users"></i>${totalClientes}
                        </h4>
                    </div>
                </div>

            </div>
        </div>

    </div>
</section>

<jsp:include page="/WEB-INF/clientes/agregarCliente.jsp"/>



