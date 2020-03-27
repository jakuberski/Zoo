package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animals;




/**
 * Servlet implementation class EditAnimalServlet
 */
@WebServlet("/editAnimalServlet")
public class EditAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   public EditAnimalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalHelper dao = new AnimalHelper();
		
		String type = request.getParameter("type");
		String area = request.getParameter("area");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		
		Animals itemToUpdate = dao.searchForAnimalId(tempId);
		itemToUpdate.setType(type);
		itemToUpdate.setArea(area);
		
		dao.updateAnimal(itemToUpdate);
	
		
		getServletContext().getRequestDispatcher("/viewAllAnimalServlet").forward(request, response);
		
	



		
		
		
		
		
	}

}
