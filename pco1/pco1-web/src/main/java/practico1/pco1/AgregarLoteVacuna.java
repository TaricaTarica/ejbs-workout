package practico1.pco1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarLoteVacuna
 */
@WebServlet("/AgregarLoteVacuna")
public class AgregarLoteVacuna extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	practico1.pco1.negocio.NegocioRemote negocio;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarLoteVacuna() {
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
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		String cantidadVacunas = request.getParameter("cantidadVacunas");
		boolean esNumero = true;
		int cv = 0;
		LocalDate fechaCreado = LocalDate.now();
		
		if(nombre.isEmpty() || cantidadVacunas.isEmpty()) {
			out.println("<p>Los campos no pueden estar vacíos</p>");
		}
		else {
			if(!negocio.existeLoteVacuna(nombre)) {
				try {
					cv = Integer.parseInt(cantidadVacunas);
		        } catch (NumberFormatException e) {
		            esNumero = false;
		        }
				if(esNumero) {
					negocio.crearLoteVacuna(nombre, fechaCreado, cv);
					out.println("<p>Se agrego correctamente el lote: "+ nombre +" </p>");
				}
				else {
					out.println("<p>La cantidad de vacunas debe ser un número</p>");
				}
			}
			else {
				out.println("<p>Ya existe un lote llamado: "+ nombre +"</p>");
			}
		}
		out.println("<a href='/pco1-web/index.jsp'>Volver</a>");
	}

}
