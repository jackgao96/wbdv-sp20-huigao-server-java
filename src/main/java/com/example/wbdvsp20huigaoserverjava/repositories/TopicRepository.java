package com.example.wbdvsp20huigaoserverjava.repositories;

import com.example.wbdvsp20huigaoserverjava.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    @Query(value = "SELECT topic FROM Topic topic where topic.lessonId=:lid", nativeQuery = true)
    public List<Topic> findTopicsForLesson(@Param("lid") Integer lessonId);

}
