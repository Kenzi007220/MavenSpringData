package example.repository;


import example.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface PersonJpaRepository extends JpaRepository<Person, Long> {


    @Query(value = "SELECT * FROM person WHERE actor_id = ?1", nativeQuery = true)
    ArrayList<Person> findById(Long i);

    @Query(value= "SELECT * FROM person WHERE first_name like %?1", nativeQuery = true)
    ArrayList<Person> findByName(String name);



}
