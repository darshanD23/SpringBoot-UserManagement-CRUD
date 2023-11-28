package crud.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.springbootcrud.entity.Student;
//import crud.springbootcrud.entity.User;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
