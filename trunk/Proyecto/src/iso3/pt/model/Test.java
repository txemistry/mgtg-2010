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
	

	
	/*public void testProfesor()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Profesor prof1 = new Profesor(1111, 11111111, "1111", "prof1", "11111111", "1111@iso3.com", "D1111");
		Profesor prof2 = new Profesor(2222, 22222222, "2222", "prof2", "22222222", "2222@iso3.com", "D2222");
		
		session.save(prof1);
		session.save(prof2);
		tx.commit();
		session.close();
		System.out.println("Se han metido los profs");
	}*/
	
	/*public void testUnidad()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Unidad unidad1 = new Unidad(11, "T1", "Introduccion", "Introduccion");
		
		session.save(unidad1);
		tx.commit();
		session.close();
		System.out.println("se han introducido las unidades");
	}*/
	
	public void testAsignatura()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Profesor prof1 = new Profesor(11111111, "1111", "prof1", "11111111", "1111@iso3.com", "D1111");
		Profesor prof2 = new Profesor(22222222, "2222", "prof2", "22222222", "2222@iso3.com", "D2222");
		
		session.save(prof1);
		session.save(prof2);
	
		Asignatura asig1 = new Asignatura(11, "iso3", 9);
		Asignatura asig2 = new Asignatura(22, "edr", 6);
		
		Unidad unidad1 = new Unidad("T1", "Introduccion", "Introduccion");
		Unidad unidad2 = new Unidad("T2", "Tema2", "Tecnologias web");
		Unidad unidad3 = new Unidad("T3", "Tema3", "Switches");
		Unidad unidad4 = new Unidad("T4", "Tema4", "Routers");
		
		asig1.addUnidad(unidad1);
		asig1.addUnidad(unidad2);
		asig2.addUnidad(unidad3);
		asig2.addUnidad(unidad4);
		
		
		asig1.setProfesor(prof1);
		asig2.setProfesor(prof2);
		
		session.save(asig1);
		session.save(asig2);
		
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
		test.close();

	}

}
