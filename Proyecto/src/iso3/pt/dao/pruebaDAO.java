package iso3.pt.dao;

import iso3.pt.model.Asignatura;

import java.util.Iterator;
import java.util.Map;

public class pruebaDAO {


	@SuppressWarnings("rawtypes")
	public static void main(String[] args) 
	{
		ptDAO dao = ptDAO.getInstancia();
		
		Map<Integer, Asignatura> mapa = dao.getCache();
		
		System.out.println("a imprimir");
		
		Iterator it = mapa.entrySet().iterator();
		
		while(it.hasNext()) 
		{
			Map.Entry ent = (Map.Entry)it.next();
			Asignatura asig = (Asignatura)ent.getValue();
			System.out.println(asig.toString());
		
		}
	}

}
