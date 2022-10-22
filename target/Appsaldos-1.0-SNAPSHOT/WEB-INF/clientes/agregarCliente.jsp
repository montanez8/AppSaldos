<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="agregarclienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal" >
                    <span>&times </span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControladorSaldos?accion=insertar" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombres">Nombre</label>
                        <input type="text" class="form-control" name="nombres">
                    </div>
                    <div class="form-gruop">
                        <label for="apellidos">Apellidos</label>
                        <input type="text" class="form-control" name="apellidos">
                    </div>
                    <div class="form-gruop">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" name="email">
                    </div>
                    <div class="form-gruop">
                        <label for="telefono">Telefono</label>
                        <input type="text" class="form-control" name="telefono">
                    </div>
                    <div class="form-gruop">
                        <label for="saldo">Saldo</label>
                        <input type="text" class="form-control" name="saldo">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary " type="submit">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>

