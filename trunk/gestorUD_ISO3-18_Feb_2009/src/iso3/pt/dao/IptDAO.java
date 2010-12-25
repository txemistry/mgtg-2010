package iso3.pt.dao;

import iso3.pt.dao.excepciones.IncorrectPasswordException;
import iso3.pt.dao.excepciones.UserFoundException;
import iso3.pt.dao.excepciones.UserNotFoundException;
import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Profesor;
import iso3.pt.model.Unidad;

import java.util.List;
import java.util.Set;

public interface IptDAO 
{
	public Profesor getProfesor(int idAsignatura);
	public Set <Alumno> getAlumnos (int idAsignatura);
	public List<Evaluacion> getEvaluacionesOrderedByAsignatura(int idAlumno);
	public Set<Evaluacion> getEvaluaciones(int idAsignatura, int idAlumno);
	public void addEvaluacion (String concepto, float nota, int idAsignatura, int idAlumno);
	public Set<Unidad> getUnidades(int idAsignatura);
	public Set<Asignatura> getAsignaturas();
	public Alumno getAlumno (int id);
	public Asignatura getAsignatura(int id);
	public Alumno loginAlumno(int dni, String pass) throws UserNotFoundException, IncorrectPasswordException;
	public Set<Asignatura> getAsignaturas(int idAlumno);
	public void matricular (int idAlumno, int idAsignatura);
	public void desmatricular (int idAlumno, int idAsignatura);
	public Profesor loginProfesor (int dni, String pass) throws UserNotFoundException, IncorrectPasswordException;
	public Set<Asignatura> getAsignaturasProfesor (int idProfesor);
	public Profesor getProfesorByDni (int dni) throws UserNotFoundException;
	public List<Evaluacion> getEvaluacionesAsignatura(int idAsignatura);
	public Set<Profesor> getProfesoresOrderByNombre(int dniAlumno);
	public void addAlumno(int dni, String password, String nombre, String telefono) throws UserFoundException;
	
	
	
	
	
}