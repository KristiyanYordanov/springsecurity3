package com.kris.ss;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class PlayerModel {
	
	//"name","stars","pos","location","height","weight","fortyDash","rating","gradYear"

//	private static CellProcessor[] getProcessors() {
//
//		final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+"; // just an
//																// example, not
//																// very robust!
//		StrRegEx.registerMessage(emailRegex, "must be a valid email address");
//
//		final CellProcessor[] processors = new CellProcessor[] {
//				new Optional(), // name
//				new Optional(), // stars
//				new Optional(), // pos
//				new Optional(), // location
//				new Optional(), // height
//				new Optional(), // weight
//				new Optional(), // fortyDa sh
//				new Optional(), // rating
//				new Optional() // gradYear
//		};
//
//		return processors;
//	}
	private String[] headers;
	
	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	public List<Player> readWithCsvBeanReader() throws Exception {
		List<Player> res = new ArrayList<Player>();
		ICsvBeanReader beanReader = null;
		try {
			beanReader = new CsvBeanReader(new FileReader(
					"H:\\rivals\\rivals_college 2012.csv"),
					CsvPreference.STANDARD_PREFERENCE);

			// the header elements are used to map the values to the bean (names
			// must match)
			final String[] header = beanReader.getHeader(true);
			setHeaders(header);
			//TODO change header with custom header form view
			
//			final CellProcessor[] processors = getProcessors();
			
			PlayerString playerString;
			while ((playerString = beanReader.read(PlayerString.class, header)) != null) {
				Player player = loadPlayer(playerString);
//				System.out.println(player);
				res.add(player);
			}

		} finally {
			if (beanReader != null) {
				beanReader.close();
			}
		}
		return res;
	}
	@Autowired
    PlayerRepository playerRepository;

	public static void main(String[] argc) throws Exception
	{
//		PlayerModel m= new PlayerModel();
//		m.readWithCsvBeanReader();
		
	}
	
	public static Player load(Object obj, Object stringObj)
	{System.out.println("////////////////////////////////////////////////////");
		Player player = new Player();
		
		Class playerStringClass = stringObj.getClass();
		Method[] stringMethods= playerStringClass.getMethods();
		
		Class playerClass = obj.getClass();
		Method[] methods= playerClass.getMethods();
		
		
		for(Method methodString : stringMethods){
			for(Method method : methods){
				String methodNameString = methodString.getName();
				String methodName = method.getName();
				if (methodName.equals(methodNameString)) {
					System.out.println("method name = " + methodName);
					
					
				}
				Class[] params = method.getParameterTypes();
				if (params.length > 0 ) {
					//System.out.println(params[0]);
				}
			}
			
		}
		System.out.println("///////////////////////////////////////////////");
		return player;
	}
	
	public static Player loadPlayer(PlayerString s){
		Player res = new Player();
		try{res.setFortyDash(Double.parseDouble(s.getFortyDash()));}catch(NumberFormatException e){		}
		try{res.setGradYear(Integer.parseInt(s.getGradYear()));}catch(NumberFormatException e){		}
		try{res.setRating(Double.parseDouble(s.getRating()));}catch(NumberFormatException e){		}
		try{res.setStars(Integer.parseInt(s.getStars()));}catch(NumberFormatException e){		}
		try{res.setWeight(Integer.parseInt(s.getWeight()));}catch(NumberFormatException e){		}
		res.setHeight(s.getHeight());
		res.setLocation(s.getLocation());
		res.setName(s.getName());
		res.setPos(s.getPos());
		return res;
	}
	

}
