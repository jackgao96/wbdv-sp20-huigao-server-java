package com.example.wbdvsp20huigaoserverjava.services;

import com.example.wbdvsp20huigaoserverjava.models.Widget;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetService {
    List<Widget> widgetList = new ArrayList<>();
    {

    }
    public Widget findWidgetById(String wid){

        for(Widget widget: widgetList){
            if(widget.getId().equals(wid)){
                return widget;
            }
        }

        return null;
    }

    public int deleteWidget(String wid){
        widgetList = widgetList
                .stream()
                .filter(w -> !w.getId().equals(wid))
                .collect(Collectors.toList());
        return 1;
    }

    public Widget createWidget(Widget widget){
        widgetList.add(widget);
        return widget;
    }
    public int updateWidget(String wid, Widget widget){
        for(int i = 0; i < widgetList.size(); i ++){
            if(widgetList.get(i).getId().equals(wid)){
                widgetList.set(i, widget);
                return 1;
            }
        }
        return 0;
    }
    public List<Widget> findWidgetForTopic(String topicId){
        List<Widget> result = new ArrayList<>();
        for(Widget w: widgetList){
            if(w.getTopicId().equals(topicId)){
                result.add(w);
            }
        }
        return  result;
    }
    public List<Widget> findAllWidgets(){
        return widgetList;
    }
}
