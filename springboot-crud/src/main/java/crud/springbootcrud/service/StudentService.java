package crud.springbootcrud.service;

import java.util.List;
import java.util.Optional;

import crud.springbootcrud.entity.Student;
//import crud.springbootcrud.entity.User;

public interface StudentService {
	public Student CreateStudent(Student student);
	public Optional<Student> getStudentById(int id);
	public Student UpdateStudent(Student student);
	public void DeleteStudent(int id);
	public List<Student> getAllStudents();
	
}
