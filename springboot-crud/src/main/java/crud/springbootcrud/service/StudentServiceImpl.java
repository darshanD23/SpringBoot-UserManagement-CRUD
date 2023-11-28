package crud.springbootcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.springbootcrud.entity.Student;
import crud.springbootcrud.repository.StudentRepository;
//import crud.springbootcrud.entity.User;
//import crud.springbootcrud.repository.UserRepository;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentrepository;
	
	public Student CreateStudent(Student Student) {
		return studentrepository.save(Student);
		
	}
	public Optional<Student> getStudentById(int id) {
		return studentrepository.findById(id);
		
	}
	public Student UpdateStudent(Student student) {
		Student existingStudent = studentrepository.findById(student.getId()).get();
	        existingStudent.setName(student.getName());
	        existingStudent.setId(student.getId());
	        existingStudent.setAge(student.getAge());
	        Student updatedStudent = studentrepository.save(existingStudent);
	        return updatedStudent;
		
	}
	public void DeleteStudent(int id){
		studentrepository.deleteById(id);
		
	}
	public List<Student> getAllStudents() {
		return studentrepository.findAll();
	}
	
	
	
	
	
}
