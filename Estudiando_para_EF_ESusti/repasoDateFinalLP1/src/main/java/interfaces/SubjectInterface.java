package interfaces;

import java.util.List;

import entidades.Subject;

public interface SubjectInterface {
	public List<Subject> listSubjects();
	public List<Subject> listSubjects(String start,String end);
}
