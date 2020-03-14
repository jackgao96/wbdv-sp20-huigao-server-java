package com.example.wbdvsp20huigaoserverjava.services;

import com.example.wbdvsp20huigaoserverjava.models.Topic;
import com.example.wbdvsp20huigaoserverjava.models.Widget;
import com.example.wbdvsp20huigaoserverjava.repositories.TopicRepository;
import com.example.wbdvsp20huigaoserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    WidgetRepository widgetRepository;

    public List<Topic> findTopicsForLesson(String lid){
        return topicRepository.findTopicsForLesson(lid);
    }

    public int deleteTopic(Integer tid){
        if(!topicRepository.findById(tid).isPresent()){
            return 0;
        }
        topicRepository.deleteById(tid);
        return 1;
    }
    public int updateTopic(int tid, Topic newTopic) {
        String lessonId = topicRepository.findById(tid).get().getLessonId();
        topicRepository.findById(tid).get().setLessonId(null);
        newTopic.setLessonId(lessonId);
        topicRepository.save(newTopic);
        return 1;
    }

    public Topic createTopic(Topic newTopic) {
        return topicRepository.save(newTopic);
    }
    public Topic findTopicById(Integer tid){
        return topicRepository.findById(tid).get();
    }
    public List<Topic> findAllTopics(){
        return (List<Topic>) topicRepository.findAll();
    }
}
