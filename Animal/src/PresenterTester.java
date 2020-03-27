import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.AnimalHelper;
import controller.AttractionHelper;
import controller.PresenterHelper;
import model.Animals;
import model.Attractions;

import model.Presenter;

public class PresenterTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Presenter bill = new Presenter("Bill");
		PresenterHelper sh = new PresenterHelper();
		sh.insertPresenter(bill);
		
		AttractionHelper ah = new AttractionHelper();
		Attractions billList = new Attractions("Bill's List",LocalDate.now(), bill);
		Animals tiger = new Animals("Tiger", "forest");
		Animals seals = new Animals("Seals", "Pool2");
		ah.insertAttraction(billList);
		
	
	
		List<Presenter> allPresenters = sh.showAllPresenters();
		for (Presenter p : allPresenters) {
			System.out.println(p.toString());
		}	
			*/
			Presenter susan = new Presenter("Barbara");
			AttractionHelper sa = new AttractionHelper();
			
			
			Animals seal = new Animals("Hippos","Lake");
			
			List<Animals>susansAnimals = new ArrayList<Animals>();
			
			susansAnimals.add(seal);
			
			Attractions susansList = new Attractions("Barbara's List",LocalDate.now(), susan);
			susansList.setListofAnimals(susansAnimals);
			sa.insertAttraction(susansList);
			
			List<Attractions> allAttractions = sa.getLists();
			for (Attractions p : allAttractions) {
				System.out.println(p.toString());
			}
			
	}

}
