package Appsaldos.web;
import Appsaldos.datos.clienteDaoJDBc;
import Appsaldos.dominio.cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletControladorSaldos", urlPatterns = {"/ServletControladorSaldos"})
public class ServletControladorSaldos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SerlvetController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SerlvetController at xxxx " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            String url;
            url = "jdbc:mariadb://localhost:3307/db_saldos?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

            try ( //Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection conexion = DriverManager.getConnection(url, "root", "arkan22")) {

                Statement instruccion = conexion.createStatement();
                String sql = "SELECT id_cliente, nombres, apellidos, email, telefono,saldo FROM cliente";
                ResultSet resultado = instruccion.executeQuery(sql);
                out.println("conectandose a la base datos<br>");
                while (resultado.next()) {
                    out.println("Id Persona: " + resultado.getInt("id_cliente"));
                    out.println(" Nombre: " + resultado.getString("nombres"));
                    out.println(" Apellido: " + resultado.getString("apellidos"));
                    out.println(" Email: " + resultado.getString("email"));
                    out.println(" Telefono: " + resultado.getString("telefono"));
                    out.println(" Saldo: " + resultado.getDouble("saldo"));
                    out.println("<br><br>");
                }
                resultado.close();
                instruccion.close();
            }

            out.println("Test de conexión a la base de datosxxxxx");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarcliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }

        /*this.accionDefault(request, response);
        List<cliente>clientes = new clienteDaoJDBc().getAll();
        request.setAttribute("clientes" , clientes);
        request.setAttribute("totalClientes", clientes.size());
        request.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        request.getRequestDispatcher("cliente.jsp").forward(request, response);*/
    }


    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<cliente>clientes = new clienteDaoJDBc().getAll();
        //HttpSession sesion = request.getSession();
        System.out.println("clientes = " + clientes);
       /* sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        response.sendRedirect("cliente.jsp");*/

        request.setAttribute("clientes" , clientes);
        request.setAttribute("totalClientes", clientes.size());
        request.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
    }

        private double calcularSaldoTotal(List<cliente>clientes){
            double saldoTotal = 0;
            for (cliente cliente : clientes) {
                saldoTotal +=cliente.getSaldo();
                
            }
            return saldoTotal;
        }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarcliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }

    }

    //metodo insertar cliente
    private void insertarcliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        cliente cliente = new cliente(nombres, apellidos, email, telefono, saldo);
        int registrosModificados = new clienteDaoJDBc().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
        this.accionDefault(request, response);
    }

    //metodo editar cliente
    private void editarcliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        cliente cliente = new clienteDaoJDBc().encontrar(new cliente(id_cliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/clientes/editarcliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
