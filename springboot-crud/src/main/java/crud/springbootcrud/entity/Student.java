package crud.springbootcrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
@Entity
@Table(name="students")
public class Student {
	@Id
   private int id;
   private String name;
   private int age;
   
   public int getId() {
	   return id;
   }
   
   public void setId(int id) {
	   this.id=id;
   }
   public String getName() {
	   return name;
   }
   public void setName(String name) {
	   this.name=name;
   }
   public int getAge() {
	   return age;
   }
   public void setAge(int age) {
	   this.age=age;
   }
   public Student(int id,String name,int age) {
	   this.id=id;
	   this.name=name;
	   this.age=age;
   }
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
   
   }
