package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animals;
import model.Attractions;
import model.Presenter;

/**
 * Servlet implementation class editListServlet
 */
@WebServlet("/editListServlet")
public class editListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AttractionHelper slh = new AttractionHelper();
		AnimalHelper lih = new AnimalHelper();
		PresenterHelper sh = new PresenterHelper();

		// search for object to make changes to
		int idToEdit = Integer.parseInt(request.getParameter("id"));
		Attractions toEdit = slh.searchForListId(idToEdit);

		// update the location first
		String location = request.getParameter("location");
		System.out.println("location: " + location);
		toEdit.setLocation(location);

		// update the date
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		toEdit.setTripDate(ld);

		// update the presenter 
		String presenterName = request.getParameter("presenterName");
		Presenter presenter;
		try {
			presenter = sh.searchForPresenterName(presenterName);
		} catch (NoResultException ex) {
			presenter = new Presenter(presenterName);
		} catch (Exception ex) {
			presenter = new Presenter(presenterName);
		}

		toEdit.setPresenter(presenter);

		// update the list of animals
		List<Animals> previousListOfAnimal = toEdit.getListofAnimals();

		String[] selectedItems = request.getParameterValues("itemsToAdd");
		List<Animals> selectedAnimalOnList = new ArrayList<Animals>();

		if (selectedItems != null && selectedItems.length > 0 ) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Animals c = lih.searchForAnimalId(Integer.parseInt(selectedItems[i]));
				selectedAnimalOnList.add(c);

			}

			previousListOfAnimal.addAll(selectedAnimalOnList);
		}

		toEdit.setListofAnimals(previousListOfAnimal);

		slh.updateAttraction(toEdit);

		System.out.println("Success!");
		System.out.println(toEdit.toString());

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
