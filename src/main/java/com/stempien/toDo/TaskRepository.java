package com.stempien.toDo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Tasks,Integer>{
    @Query("SELECT a FROM toDo a where a.id = id")
    List<Tasks> znajdzZadania(@Param("id") int id);

}
