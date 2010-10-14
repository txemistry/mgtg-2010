package iso3.pt.dao;

import iso3.pt.model.Evaluacion;
import iso3.pt.model.Profesor;

import java.util.Set;

public interface IptDAO 
{
	public Profesor getProfesor(int idAsignatura);
	public Set<Evaluacion> getEvaluaciones(int idAsignatura, int idAlumno);
}
