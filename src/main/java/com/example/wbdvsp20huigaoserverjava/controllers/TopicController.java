package com.example.wbdvsp20huigaoserverjava.controllers;


import com.example.wbdvsp20huigaoserverjava.models.Topic;
import com.example.wbdvsp20huigaoserverjava.models.Widget;
import com.example.wbdvsp20huigaoserverjava.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    TopicService topicService;



    @GetMapping("/api/topics/{topicId}")
    public Topic findWidgetById(@PathVariable("topicId") Integer tid) {
        return topicService.findTopicById(tid);
    }

    @PutMapping("/api/topics/{topicId}")
    public int updateTopic(@PathVariable("topicId") Integer tid, @RequestBody Topic topic){
        return topicService.updateTopic(tid, topic);
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics(){
        return topicService.findAllTopics();
    }

//    @PostMapping("/api/topics/{tid}/widgets")
//    public Widget createWidgetForTopic(
//            @PathVariable("tid") Integer tid,
//            @RequestBody Widget newWidget) {
//        return topicService.createWidgetForTopic(tid, newWidget);
//    }

    @DeleteMapping("/api/topics/{topicId}")
    public int deleteTopic(@PathVariable("topicId") Integer tid){
        return topicService.deleteTopic(tid);
    }

    @PostMapping("/api/lessons/{lid}/topics")
    public Topic createTopicForLesson(
            @PathVariable("lid") String lessonId,
            @RequestBody Topic newTopic
    ) {
        newTopic.setLessonId(lessonId);
        return topicService.createTopic(newTopic);
    }

    @GetMapping("/api/lessons/{lessonId}/topics")
    public List<Topic> findTopicsForLesson(
            @PathVariable("lessonId") Integer lessonId
    ){
        return topicService.findTopicsForLesson(lessonId);
    }
}
