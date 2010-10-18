package iso3.pt.dao;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Profesor;
import iso3.pt.model.Unidad;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class pruebaDAO 
{
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		ptDAO dao = ptDAO.getInstancia();
		
		Map<Integer, Asignatura> cache = dao.getCache();
		
		//Prueba de la cache
		System.out.println("Prueba de la Cache");
		Iterator it = cache.entrySet().iterator();
		while(it.hasNext()) 
		{
			Map.Entry ent = (Map.Entry)it.next();
			Asignatura asig = (Asignatura)ent.getValue();
			System.out.println("Datos basicos de la Asignatura");
			System.out.println("        " + asig.toString());
			Profesor prof = asig.getProfesor();
			System.out.println("        Datos del profesor       " + prof.toString() );
			Set<Alumno> alumnos = asig.getAlumnos();
			System.out.println("        Datos de los alumnos");
			for(Alumno al:alumnos)
			{
				System.out.println("               " + al.toString());
			}
			Set<Unidad> unidades = asig.getUnidades();
			System.out.println("        Datos de las unidades");
			for(Unidad uni:unidades)
			{
				System.out.println("               " + uni.toString());
			}
		}
		System.out.println();
		System.out.println();
		
		dao.close();
		
		
		/*//Prueba de getProfesor
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
			System.out.println(al.getNombre());*/
		
		
		
	}

}
