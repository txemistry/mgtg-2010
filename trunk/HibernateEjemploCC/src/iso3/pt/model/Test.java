package iso3.hib.ejemploCC;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class Test { 
	
		SessionFactory sessionFactory;
		
		public Test(){
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
	
		public void inserciones1(){
	    	
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        Departamento dep1 = new Departamento("Ingenieria del Software");
	        Departamento dep2 = new Departamento("Servicios - ESIDE");
	        
	        Empleado emp1 = new Empleado(111, "Asier Perallos", "profesor", "perallos@eside.deusto.es");
	        Empleado emp2 = new Empleado(222, "Diego Lopez de Ipina", "profesor", "dipina@eside.deusto.es");
	        Empleado emp3 = new Empleado(333, "Maite Sanchez", "secretaria", "msanchez@eside.deusto.es");
	        Empleado emp4 = new Empleado(444, "Ana Carrera", "secretaria", "acarrera@eside.deusto.es");
	        
	        dep1.addEmpleado(emp1);
	        dep1.addEmpleado(emp2);
	        emp1.setDepartamento(dep1);
	        emp2.setDepartamento(dep1);
	        
	        session.save(dep1); // Se salvan los dos empleados del "dep1" en cascada
	        session.save(dep2);
	        
	        dep2.addEmpleado(emp3);
	        dep2.addEmpleado(emp4);
	        emp3.setDepartamento(dep2);
	        emp4.setDepartamento(dep2);
	        
	        session.save(emp3); // Innecesarias, se insertarían los dos empleados al actualizar el "dep2"
	        session.save(emp4);
	        
	        tx.commit();
	        session.close();
	        System.out.println("Done inserciones1!");
		}
		
		public void busquedaPK(){

	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        Empleado emp1 = (Empleado) session.get(Empleado.class, 111);
	        System.out.println(emp1);
	        emp1.setNombre("Asier Perallos Ruiz");
	        session.flush();
	        
	        Departamento dep = emp1.getDepartamento();
	        System.out.println(dep);
	        
	        Set<Empleado> empleados = dep.getEmpleados();
	        for (Iterator<Empleado> iter = empleados.iterator(); iter.hasNext();) {
	        	Empleado emp2 = iter.next();
	        	System.out.println(emp2);	
	        }
	        
	        tx.commit();
	        session.close();
	        System.out.println("Done busquedaPK!");
		}
		
		public void inserciones2(){
	    	
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        Direccion dir1 = new Direccion("Calle1 - Bilbao", 48007);
	        Direccion dir2 = new Direccion("Calle2 - Portugalete", 48920);
	        
	        session.save(dir1);
	        session.save(dir2);
	        
	        Empleado emp1 = (Empleado) session.get(Empleado.class, 111);
	        Empleado emp2 = (Empleado) session.get(Empleado.class, 222);
	        
	        dir1.addEmpleado(emp1);
	        dir1.addEmpleado(emp2);
	        
	        emp1.addDireccion(dir1);
	        emp2.addDireccion(dir1);
	        
	        dir2.addEmpleado(emp1);
	        emp1.addDireccion(dir2);
	        
	        tx.commit();
	        session.close();
	        System.out.println("Done inserciones2!");
	        
		}
		
		public void busquedaCompleja(){
	    	
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        List<Empleado> empleados = session.createQuery("from Empleado as emp where emp.departamento.nombre = 'Servicios - ESIDE' and emp.puesto = 'secretaria'").list();
	        
	        for (Iterator<Empleado> iter = empleados.iterator(); iter.hasNext();) {
	            Empleado emp1 = iter.next();
	            System.out.println(emp1);
	        }
	        
	        tx.commit();
	        session.close();
	        System.out.println("Done busquedaCompleja!");
	        
	        
		}
		
		public void borrado(){
	    	
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        Empleado emp1 = (Empleado) session.get(Empleado.class, 222);
	        
	        Set<Direccion> direcciones = emp1.getDirecciones();
	        
	        for (Iterator<Direccion> iter = direcciones.iterator(); iter.hasNext();) {
	            Direccion dir = iter.next();
	            emp1.removeDireccion(dir);
	        }
	        emp1.getDirecciones().clear();
	        emp1.getDepartamento().removeEmpleado(emp1);
	        
	        session.delete(emp1);
	        
	        tx.commit();
	        session.close();
	        System.out.println("Done borrado!");
		}
		
		public void inserciones3(){
	    	
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        Departamento dep3 = new Departamento("Comercial");
	        
	        Externo ext1 = new Externo(555, "Externo1", "profesor", "ext1@unicomer.es", "Iberdrola", "ext1@iberdrola.es", "bla, bla,...");
	        
	        ext1.setDepartamento(dep3);
	        dep3.addEmpleado(ext1);
	        
	        session.save(dep3);
	        session.save(ext1);
	        
	        Externo ext = (Externo) session.get(Externo.class, 555);
	        System.out.println(ext);
	        
	        tx.commit();
	        session.close();
	        System.out.println("Done inserciones3!");
		}
		
		public void close(){
	        sessionFactory.close();
		}

	    public static void main(String[] args) {
	    	Test t1 = new Test();
	    	t1.inserciones1();
	    	t1.busquedaPK();
	    	t1.inserciones2();
	    	t1.busquedaCompleja();
	    	t1.borrado();
	    	t1.inserciones3();
	    	t1.close();
	    }
	}
