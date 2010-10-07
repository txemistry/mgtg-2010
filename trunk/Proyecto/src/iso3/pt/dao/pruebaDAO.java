package iso3.pt.dao;

import iso3.pt.model.Asignatura;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class pruebaDAO {


	public static void main(String[] args) 
	{
		ptDAO dao = ptDAO.getInstancia();
		
		Map<Integer, Asignatura> mapa = dao.getCache();
		System.out.println(mapa.get(1).getNombre());

	}

}
