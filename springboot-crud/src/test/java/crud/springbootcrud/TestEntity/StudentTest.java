package crud.springbootcrud.TestEntity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import crud.springbootcrud.entity.Student;

//import crud.springbootcrud.entity.User;

class StudentTest {

	 private Student user;

	    @BeforeEach
	    public void setUp() {
	        user = new Student(1, "John Doe", 25);
	    }

	    @Test
	    public void testGetId() {
	        assertEquals(1, user.getId());
	    }

	    @Test
	    public void testSetId() {
	        user.setId(2);
	        assertEquals(2, user.getId());
	    }

	    @Test
	    public void testGetName() {
	        assertEquals("John Doe", user.getName());
	    }

	    @Test
	    public void testSetName() {
	        user.setName("Jane Doe");
	        assertEquals("Jane Doe", user.getName());
	    }

	    @Test
	    public void testGetAge() {
	        assertEquals(25, user.getAge());
	    }

	    @Test
	    public void testSetAge() {
	        user.setAge(30);
	        assertEquals(30, user.getAge());
	    }

	    @Test
	    public void testParameterizedConstructor() {
	    	Student newUser = new Student(3, "Alice", 28);
	        assertEquals(3, newUser.getId());
	        assertEquals("Alice", newUser.getName());
	        assertEquals(28, newUser.getAge());
	    }

	    @Test
	    public void testDefaultConstructor() {
	    	Student newUser = new Student();
	        assertNull(newUser.getName());
	        assertEquals(0, newUser.getId());
	        assertEquals(0, newUser.getAge());
	    }

		/*
		 * @Test public void testEquals() { User newUser1 = new User(1, "John Doe", 25);
		 * User newUser2 = new User(2, "Ron Doe", 25);
		 * assertTrue(newUser1.equals(newUser2) && newUser2.equals(newUser1));
		 * assertTrue(newUser1.hashCode() == newUser2.hashCode()); }
		 */
	    
	    @Test
	    public void testNotEquals() {
	    	Student newUser = new Student(2, "Jane Doe", 30);
	        assertFalse(user.equals(newUser) || newUser.equals(user));
	    }
}
