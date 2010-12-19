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
	

	
	public void testProfesor()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Profesor prof1 = new Profesor(11111111, "1111", "prof1", "11111111", "1111@iso3.com", "D1111");
		Profesor prof2 = new Profesor(22222222, "2222", "prof2", "22222222", "2222@iso3.com", "D2222");
		
		session.save(prof1);
		session.save(prof2);
		tx.commit();
		session.close();
		System.out.println("Se han metido los profs");
	}
	
	public void testUnidad()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Unidad unidad1 = new Unidad("T1", "Introduccion", "Introduccion");
		
		session.save(unidad1);
		tx.commit();
		session.close();
		System.out.println("se han introducido las unidades");
	}
	
	public void testEvaluacion()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Evaluacion ev1 = new Evaluacion("evaluacion 1", (float) 8.9);
		Evaluacion ev2 = new Evaluacion("evaluacion 2", (float) 9.2);
		
		session.save(ev1);
		session.save(ev2);
		
		tx.commit();
		session.close();
		System.out.println("se han introducido las evaluaciones");
	}
	
	
	public void testAlumno()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Alumno alum1 = new Alumno(33333333, "3333", "Juan", "987654321");
		Alumno alum2 = new Alumno(44444444, "2222", "Pedro", "123456789");
		Alumno alum3 = new Alumno(55555555, "4444", "Ana", "135798642");
		Alumno alum4 = new Alumno(66666666, "5555", "Lucia", "246897531");
		
		session.save(alum1);
		session.save(alum2);
		session.save(alum3);
		session.save(alum4);
		
		tx.commit();
		session.close();
		System.out.println("se han introducido las asignaturas");
	}
	
	
	public void testAsignatura()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//creo los profesores y los guardo en la BD
		Profesor prof1 = new Profesor(45821905, "1111", "Diego López de Ipiña", "944678535", "dipina@deusto.es", "DeustoTech");
		Profesor prof2 = new Profesor(76519434, "2222", "Roberto Carballedo", "944673909", "carballedo@deusto.es", "567");
		
		
		session.save(prof1);
		session.save(prof2);

		
		
		//Creo los alumnos
		Alumno alum1 = new Alumno(78653209, "1111", "Juan", "944875631");
		Alumno alum2 = new Alumno(56712038, "2222", "Patricia", "944672006");


		//Creo las evaluaciones
		Evaluacion ev1 = new Evaluacion("Ordinaria", (float) 8.9);
		Evaluacion ev2 = new Evaluacion("Ordinaria", (float) 9.9);
		Evaluacion ev3 = new Evaluacion("Ordinaria", (float)4.3);
		Evaluacion ev4 = new Evaluacion("Extraordinaria", (float)6.5);

		
		//Creo las asignaturas
		Asignatura asig1 = new Asignatura(11, "iso3", 9);
		Asignatura asig2 = new Asignatura(22, "IA", 9);

		
		//Creo las unidades
		Unidad unidad1 = new Unidad("ISO3-T1", "Introduccion", "Introduccion");
		Unidad unidad2 = new Unidad("ISO3-T2", "Hibernate", "Persistencia");
		Unidad unidad3 = new Unidad("IA-T1", "Introduccion", "Introduccion");
		Unidad unidad4 = new Unidad("IA-T2", "Euristicas", "Euristicas de diseño");

		
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
		
		
		//Vinculo los profesores a las asignaturas LISTO
		asig1.setProfesor(prof1);
		asig2.setProfesor(prof2);
		
		
		//Guardo las asignaturas en la BD, que a su vez guardara 
		//a las unidades ya que hay comportamiento en cascada
		session.save(asig1);
		session.save(asig2);
		
		//Guardo los alumnos en la BD y por cascada sus evaluaciones
		session.save(alum1);
		session.save(alum2);
		
		
		
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
		//test.testProfesor();
		//test.testUnidad();
		test.testAsignatura(); //se meteran las asignaturas y las unidades
		//test.testAlumno();
		//test.testEvaluacion();
		test.close();

	}

}
