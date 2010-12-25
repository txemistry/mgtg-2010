package iso3.pt.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test 
{

	SessionFactory sessionFactory;
	
	public Test()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	

	
	
	public void testAsignatura()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//creo los profesores y los guardo en la BD
		Profesor prof1 = new Profesor(45821905, "1111", "Diego López de Ipiña", "944678535", "dipina@deusto.es", "DeustoTech");
		Profesor prof2 = new Profesor(76519434, "2222", "Roberto Carballedo", "944673909", "carballedo@deusto.es", "567");
		Profesor prof3 = new Profesor(36942752, "3333", "Ana Belén Lago", "944673909", "ablago@deusto.es", "decanato");

		
		session.save(prof1);
		session.save(prof2);
		session.save(prof3);

		
		
		//Creo los alumnos
		Alumno alum1 = new Alumno(78653209, "1111", "Juan", "944875631");
		Alumno alum2 = new Alumno(56712038, "2222", "Patricia", "944672006");
		Alumno alum3 = new Alumno(56712037, "3333", "Pepito", "944672065");



		//Creo las evaluaciones
		Evaluacion ev1 = new Evaluacion("Ordinaria", (float) 8.9);
		Evaluacion ev2 = new Evaluacion("Ordinaria", (float) 9.9);
		Evaluacion ev3 = new Evaluacion("Ordinaria", (float)4.3);
		Evaluacion ev4 = new Evaluacion("Extraordinaria", (float)6.5);

		
		//Creo las asignaturas
		Asignatura asig1 = new Asignatura(11, "Ingeniería del Software III", 9);
		Asignatura asig2 = new Asignatura(22, "Iinteligencia Artificial", 9);
		Asignatura asig3 = new Asignatura(33, "Evaluación y Diseño de Redes", 7);


		
		//Creo las unidades
		Unidad unidad1 = new Unidad("ISO3-T1", "Introduccion", "Introduccion");
		Unidad unidad2 = new Unidad("ISO3-T2", "Hibernate", "Persistencia");
		Unidad unidad3 = new Unidad("IA-T1", "Introduccion", "Introduccion");
		Unidad unidad4 = new Unidad("IA-T2", "Euristicas", "Euristicas de diseño");
		Unidad unidad5 = new Unidad("EDR-T1", "Redes WAN", "Diseño de redes");
		Unidad unidad6 = new Unidad("EDR-T2", "Redes LAN", "Diseño de redes");


		
		
		//Vinculo las asignaturas a los alumnos LISTO
		alum1.addAsignatura(asig1);
		alum1.addAsignatura(asig2);
		alum2.addAsignatura(asig2);
		
		//Vinculo los alumnos a las asignaturas LISTO,  
		asig1.addAlumno(alum1);
		asig2.addAlumno(alum1);
		asig2.addAlumno(alum2);
		
		//Vinculo los alumnos a las evaluaciones LISTO
		ev1.setAlumno(alum1);
		ev2.setAlumno(alum1);
		ev3.setAlumno(alum2);
		ev4.setAlumno(alum2);
		
		//Vinculo las evaluaciones a los alumno
		alum1.addEvaluacion(ev1);
		alum1.addEvaluacion(ev2);
		alum2.addEvaluacion(ev3);
		alum2.addEvaluacion(ev4);
		
		//Vinculo las asignaturas a las evaluaciones LISTO
		ev1.setAsignatura(asig1);
		ev2.setAsignatura(asig2);
		ev3.setAsignatura(asig2);
		ev4.setAsignatura(asig2);
		
		
		//Vinculo las unidades a las asignaturas LISTO
		asig1.addUnidad(unidad1);
		asig1.addUnidad(unidad2);
		asig2.addUnidad(unidad3);
		asig2.addUnidad(unidad4);
		asig3.addUnidad(unidad5);
		asig3.addUnidad(unidad6);
		
		
		//Vinculo los profesores a las asignaturas LISTO
		asig1.setProfesor(prof1);
		asig2.setProfesor(prof2);
		asig3.setProfesor(prof3);
		
		
		//Guardo las asignaturas en la BD, que a su vez guardara 
		//a las unidades ya que hay comportamiento en cascada
		session.save(asig1);
		session.save(asig2);
		session.save(asig3);
		
		//Guardo los alumnos en la BD y por cascada sus evaluaciones
		session.save(alum1);
		session.save(alum2);
		session.save(alum3);
		
		
		
		tx.commit();
		session.close();
		System.out.println("se han introducido las asignaturas");
	}
	
	public void close()
	{
        sessionFactory.close();
	}
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Test test = new Test();
		test.testAsignatura(); //se meteran las asignaturas y las unidades
		test.close();

	}

}
