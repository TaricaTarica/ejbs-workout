package practico1.pco1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListarLotesVacuna
 */
@WebServlet("/ListarLotesVacuna")
public class ListarLotesVacuna extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	practico1.pco1.negocio.NegocioRemote negocio;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ListarLotesVacuna() {
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
        
		List<String> nombres = negocio.listarNombres();
		if(nombres.isEmpty()) {
			out.println("<p>Aún no se han agregado Lotes<p>");
		}else{
			out.println("<ul>");
			for(String n: nombres) {
				out.println("<li>");
				out.println(n);
				out.println("</li>");
			}
			out.println("</ul>");
		}
		out.println("<a href='/pco1-web/index.jsp'>Volver</a>");
	}

}
