package com.example.wbdvsp20huigaoserverjava.controllers;

import com.example.wbdvsp20huigaoserverjava.models.Widget;
import com.example.wbdvsp20huigaoserverjava.services.WidgetService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class WidgetController {

    WidgetService service = new WidgetService();

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets(){
        return service.findAllWidgets();
    }

    @PostMapping("/api/widgets")
    public Widget createWidget(@RequestBody Widget widget){
        return service.createWidget(widget);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public int deleteWidget(@PathVariable("widgetId") String wid){
        return service.deleteWidget(wid);
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") String wid){
        return service.findWidgetById(wid);
    }
    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetForTopic(@PathVariable("tid") String topicId){
        return service.findWidgetForTopic(topicId);
    }
    @PutMapping("/api/widgets/{widgetId}")
    public int updateWidget(@PathVariable("widgetId") String wid, @RequestBody Widget widget){
        return service.updateWidget(wid, widget);
    }
    @GetMapping("/api/widget")
    public Widget getWidget(){
        Widget w1 = new Widget("123", "Widget A");
        return w1;
    }
}
