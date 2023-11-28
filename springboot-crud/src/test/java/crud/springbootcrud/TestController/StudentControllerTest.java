package crud.springbootcrud.TestController;

import crud.springbootcrud.controller.StudentController;
import crud.springbootcrud.entity.Student;
//import crud.springbootcrud.entity.User;
import crud.springbootcrud.service.StudentService;
import crud.springbootcrud.service.StudentServiceImpl;
//import crud.springbootcrud.service.UserService;
//import crud.springbootcrud.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentControllerTest {

	private StudentController studentController;
	private StudentService studentService;

	@BeforeEach
	public void setUp() {
		studentService = new StudentServiceImpl(); // Assuming you have a UserService implementation
		studentController = new StudentController();
	}

	@Test
	public void testCreateStudent() {
		Student studentToCreate = new Student(1, "John Doe", 25);
		Student createdStudent = studentController.createStudent(studentToCreate);

		assertEquals(1, createdStudent.getId());
		assertEquals("John Doe", createdStudent.getName());
		assertEquals(25, createdStudent.getAge());
	}

	@Test
	public void testGetStudentById() {
		Student existingStudent = new Student(1, "John Doe", 25);
		studentService.CreateStudent(existingStudent);

		Optional<Student> retrievedStudent = studentController.getStudentById(1);

		assertEquals(existingStudent, retrievedStudent.orElse(null));
	}

	@Test
	public void testGetAllStudent() {
		Student student1 = new Student(1, "John Doe", 25);
		Student student2 = new Student(2, "Jane Doe", 30);

		studentService.CreateStudent(student1);
		studentService.CreateStudent(student2);

		List<Student> retrievedStudents = studentController.getAllStudents();

		assertEquals(2, retrievedStudents.size());
		assertEquals(student1, retrievedStudents.get(0));
		assertEquals(student1, retrievedStudents.get(1));
	}

	@Test
	public void testUpdateStudent() {
		Student existingStudent = new Student(1, "John Doe", 25);
		studentService.CreateStudent(existingStudent);

		Student updatedStudent = new Student(1, "Updated John Doe", 30);
		Student result = studentController.updateStudent(1, updatedStudent);

		assertEquals(updatedStudent, result);
		assertEquals(updatedStudent.getName(), studentService.getStudentById(1).orElse(null).getName());
	}

	@Test
	public void testDeleteStudent() {
		Student existingStudent = new Student(1, "John Doe", 25);
		studentService.CreateStudent(existingStudent);

		studentController.deleteStudent(1);

		assertEquals(0, studentService.getAllStudents().size());
	}

	@Test
	public void testDeleteNonExistentUser() {
		assertThrows(IllegalArgumentException.class, () -> studentController.deleteStudent(100));
	}
}
