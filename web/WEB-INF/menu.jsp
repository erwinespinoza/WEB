<%
    String opcion =  request.getParameter("opcion");
%>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("usuarios") ?  "active" : "") %>" href="PermisosControlador">Productos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("permisos") ?  "active" : "") %>" href="PermisosControlador">Clientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("roles") ?  "active" : "") %>" href="rolesControlador">Ventas</a>
                </li>
            </ul>