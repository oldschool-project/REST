

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class GameController
 */
@WebServlet("/game")
public class GameController extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	private int score = 0;

    /**
     * Default constructor. 
     */
    public GameController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setStatus(200);		
		response.getWriter().write(new Gson().toJson(score));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.score = 0;
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int scoreToUpdate;
		
		try {
			scoreToUpdate = Integer.parseInt(request.getParameter("scoreToUpdate"));
			
			this.score = scoreToUpdate;
		} catch (Exception e) {
			response.setStatus(401);
		}
		
		
	}

}
