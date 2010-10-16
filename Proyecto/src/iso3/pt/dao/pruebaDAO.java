package iso3.pt.dao;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Profesor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class pruebaDAO {


	@SuppressWarnings("rawtypes")
	public static void main(String[] args) 
	{
		ptDAO dao = ptDAO.getInstancia();
		
		Map<Integer, Asignatura> mapa = dao.getCache();
		
		//Prueba de la cache
		System.out.println("Prueba de la Cache");
		Iterator it = mapa.entrySet().iterator();
		while(it.hasNext()) 
		{
			Map.Entry ent = (Map.Entry)it.next();
			Asignatura asig = (Asignatura)ent.getValue();
			//System.out.println(asig.toString());
			System.out.println(asig.getProfesor().toString());
			//Set<Alumno> alumnos = asig.getAlumnos();
			//for(Alumno al:alumnos)
				//System.out.println(al.toString());
		}
		System.out.println();
		System.out.println();
		
		
		//Prueba de getProfesor
		System.out.println("Prueba de getProfesor");
		Profesor profesor = dao.getProfesor(1);
		System.out.println(profesor.toString());
		System.out.println();
		System.out.println();
		
		//Prueba de getEvaluaciones
		System.out.println("Prueba de getEvaluaciones");
		Set<Evaluacion> evaluaciones = dao.getEvaluaciones(2, 33333333);
		for(Evaluacion e:evaluaciones)
			System.out.println(e.toString());
		System.out.println();
		System.out.println();
		
		//Prueba de getAlumnos
		System.out.println("Prueba de getAlumnos");
		Set<Alumno> alumnos = dao.getAlumnos(1);
		for(Alumno al:alumnos)
			System.out.println(al.getNombre());
	}

}
