package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animals;
import model.Attractions;
import model.Presenter;


;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AnimalHelper lih = new AnimalHelper();
		String location = request.getParameter("location");
		System.out.println("Location: "+ location);
		
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String presenterName = request.getParameter("presenterName");
		LocalDate ld;
		try {
		ld = LocalDate.of(Integer.parseInt(year),
		Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
		ld = LocalDate.now();
		}
		
		String[] selectedItems =request.getParameterValues("allItemsToAdd");
		List<Animals> selectedAnimalsOnList = new ArrayList<Animals>();
		//make sure something was selected � otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0)
		{
		for(int i = 0; i<selectedItems.length; i++) {
		System.out.println(selectedItems[i]);
		Animals c =lih.searchForAnimalId(Integer.parseInt(selectedItems[i]));
		selectedAnimalsOnList.add(c);
		}
		}
		
		Presenter presenter = new Presenter(presenterName);
		Attractions sld = new Attractions(location, ld,presenter);
		sld.setListofAnimals(selectedAnimalsOnList);
		AttractionHelper slh = new AttractionHelper();
		slh.insertAttraction(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllAttractionServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
