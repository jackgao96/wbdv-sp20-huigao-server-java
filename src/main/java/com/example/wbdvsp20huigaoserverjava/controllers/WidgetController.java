package com.example.wbdvsp20huigaoserverjava.controllers;

import com.example.wbdvsp20huigaoserverjava.models.Widget;
import com.example.wbdvsp20huigaoserverjava.repositories.TopicRepository;
import com.example.wbdvsp20huigaoserverjava.services.TopicService;
import com.example.wbdvsp20huigaoserverjava.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class WidgetController {

    @Autowired
    WidgetService service;

    @Autowired
    TopicService topicService;



    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets(){
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/create")
    public Widget createWidgetTest(){
        Widget w1 = new Widget();
        w1.setType("New Widget");
        w1.setSize(4);

        return service.createWidget(1, w1); }

//    @PostMapping("/api/widgets")
//    public Widget createWidget(@RequestBody Widget widget){
//        return service.createWidget(widget); }

    @PostMapping("/api/topics/{topicId}/widgets")
    public Widget createWidget(
            @PathVariable("topicId") Integer topicId,
            @RequestBody Widget newWidget) {
        return service.createWidget(topicId, newWidget);
    }

    @GetMapping("/api/delete/widgets/{widgetId}")
    public int deleteWidgetTest(@PathVariable("widgetId") Integer wid){
        return service.deleteWidget(wid);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public int deleteWidget(@PathVariable("widgetId") Integer wid){
        return service.deleteWidget(wid);
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") Integer wid){
        return service.findWidgetById(wid);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetForTopic(@PathVariable("tid") String topicId){
        int tid;
        try{
            tid = Integer.parseInt(topicId);
            return service.findWidgetForTopic(tid);
        }catch (NumberFormatException e){
            List<Widget> result = new ArrayList<>();
            return result;
        }
    }
    @PutMapping("/api/widgets/{widgetId}")
    public int updateWidget(@PathVariable("widgetId") Integer wid, @RequestBody Widget widget){
        return service.updateWidget(wid, widget);
    }
}
