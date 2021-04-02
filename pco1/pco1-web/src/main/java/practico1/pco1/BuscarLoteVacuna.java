package practico1.pco1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practico1.pco1.datatypes.DtLoteVacuna;


/**
 * Servlet implementation class BuscarLoteVacuna
 */
@WebServlet("/BuscarLoteVacuna")
public class BuscarLoteVacuna extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	practico1.pco1.negocio.NegocioRemote negocio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarLoteVacuna() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
		String nombre =request.getParameter("nombre");
		if(nombre.isEmpty()){
			out.println("<p>Los campos no pueden estar vacíos</p>"); 
		}else{
			DtLoteVacuna dtlv = negocio.buscarLoteVacuna(nombre);
			if(dtlv != null) {
				out.println("<h1>Información del Lote</h1>");
				out.println("<ul>");
				out.println("<li>Nombre: "+ dtlv.getNombre() +"</li>");
				out.println("<li>Cantidad de Vacunas: "+ dtlv.getCantidad() +"</li>");
				out.println("<li>Fecha Creación: "+ dtlv.getFechaCreado().toString() +"</li>");
				out.println("</ul>");
			}else {
				out.println("<p>No existe un lote de nombre: "+ nombre +"</p>");
			}
		}
		out.println("<a href='/pco1-web/index.jsp'>Volver</a>");
	}

}
