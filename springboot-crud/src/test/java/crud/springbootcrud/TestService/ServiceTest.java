package crud.springbootcrud.TestService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import crud.springbootcrud.entity.Student;
import crud.springbootcrud.repository.StudentRepository;
import crud.springbootcrud.service.StudentServiceImpl;

//import crud.springbootcrud.entity.User;
//import crud.springbootcrud.repository.UserRepository;
//import crud.springbootcrud.service.UserServiceImpl;

public class ServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateStudent() {
    	Student studentToCreate = new Student(1, "John Doe", 25);
        when(studentRepository.save(studentToCreate)).thenReturn(studentToCreate);

        Student createdStudent = studentService.CreateStudent(studentToCreate);

        assertEquals(studentToCreate, createdStudent);
        verify(studentRepository, times(1)).save(studentToCreate);
    }

    @Test
    public void testGetStudentById() {
        Student existingStudent = new Student(1, "John Doe", 25);
        when(studentRepository.findById(1)).thenReturn(Optional.of(existingStudent));

        Optional<Student> retrievedStudent = studentService.getStudentById(1);

        assertTrue(retrievedStudent.isPresent());
        assertEquals(existingStudent, retrievedStudent.get());
        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    public void testGetAllStudents() {
    	Student student1 = new Student(1, "John Doe", 25);
    	Student student2 = new Student(2, "Jane Doe", 30);

        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));

        List<Student> retrievedStudents = studentService.getAllStudents();

        assertEquals(2, retrievedStudents.size());
        assertEquals(student1, retrievedStudents.get(0));
        assertEquals(student2, retrievedStudents.get(1));
        verify(studentRepository, times(1)).findAll();
    }

	
	  @Test public void testUpdateStudent() { 
		  Student existingStudent = new Student(1,"John Doe", 25); 
		  Student updatedStudent = new Student(1, "Updated John Doe", 30);
	  
	  when(studentRepository.findById(1)).thenReturn(Optional.of(existingStudent));
	  when(studentRepository.save(updatedStudent)).thenReturn(updatedStudent);
	  
	  Student resultStudent = studentService.UpdateStudent(updatedStudent);
	  
	  assertEquals(updatedStudent, resultStudent); 
	  verify(studentRepository,times(1)).findById(1); 
	  verify(studentRepository, times(1)).save(updatedStudent); }
	 
    @Test
    public void testDeleteStudent() {
    	Student existingStudent = new Student(1, "John Doe", 25);
        when(studentRepository.findById(1)).thenReturn(Optional.of(existingStudent));

        studentService.DeleteStudent(1);

        verify(studentRepository, times(1)).findById(1);
        verify(studentRepository, times(1)).deleteById(1);
    }
}


