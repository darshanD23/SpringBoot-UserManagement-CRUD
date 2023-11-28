package crud.springbootcrud.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.springbootcrud.entity.Student;
//import crud.springbootcrud.entity.User;
import crud.springbootcrud.service.StudentServiceImpl;
//import crud.springbootcrud.service.UserService;
//import crud.springbootcrud.service.UserServiceImpl;

@RestController
@RequestMapping("api/students")
public class StudentController {
	private static final org.slf4j.Logger LOGGER =LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentServiceImpl studentservice;
	
	
	@PostMapping
    public Student createStudent(@RequestBody Student student){
		Student savedStudent = studentservice.CreateStudent(student);
		LOGGER.info("Data inserted successfully");
		return savedStudent;
    }

    
    // http://localhost:8080/api/students/1
    @GetMapping("{id}")
    public Optional<Student> getStudentById(@PathVariable int id){
        Optional<Student> student = studentservice.getStudentById(id);
        return student;
    }

    // Build Get All Students REST API
    // http://localhost:8080/api/students
    @GetMapping
    public List<Student> getAllStudents(){
        List<Student> students = studentservice.getAllStudents();
        return students;
    }

     //Build Update Students REST API
    @PutMapping("{id}")
//     http://localhost:8080/api/students/1
    public Student updateStudent(@PathVariable int id,
                                           @RequestBody Student student){
        student.setId(id);
        Student updatedStudent = studentservice.UpdateStudent(student);
        return updatedStudent;
    }

    // Build Delete Student REST API
   @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable int id){
        studentservice.DeleteStudent(id);
        return "Student successfully deleted!";
    }
}



