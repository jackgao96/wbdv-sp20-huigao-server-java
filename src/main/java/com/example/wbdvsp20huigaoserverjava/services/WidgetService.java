package com.example.wbdvsp20huigaoserverjava.services;

import com.example.wbdvsp20huigaoserverjava.models.Topic;
import com.example.wbdvsp20huigaoserverjava.models.Widget;
import com.example.wbdvsp20huigaoserverjava.repositories.TopicRepository;
import com.example.wbdvsp20huigaoserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {
    //List<Widget> widgetList = new ArrayList<Widget>();
    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    TopicRepository topicRepository;

    public Widget findWidgetById(Integer wid){
        if(wid != null){
            return widgetRepository.findById(wid).get();
        }
        return null;
    }

    public int deleteWidget(Integer wid){
        widgetRepository.deleteById(wid);
        return 1;
    }

    public Widget createWidget(Integer topicId, Widget widget){
        Topic topic = topicRepository.findById(topicId).get();
        //if(topic == null) return null;
        widget.setTopic(topic);
        return widgetRepository.save(widget);
    }
    public int updateWidget(Integer wid, Widget updatedWidget){
        Topic topic = widgetRepository.findById(wid).get().getTopic();
        widgetRepository.findById(wid).get().setTopic(null);
        updatedWidget.setTopic(topic);
        widgetRepository.save(updatedWidget);

        return 1;
    }
    public List<Widget> findWidgetForTopic(Integer topicId){
        Topic topic = topicRepository.findById(topicId).get();
        return topic.getWidgets();
//        return widgetRepository.findWidgetForTopic(topicId);

    }
    public List<Widget> findAllWidgets(){
        return (List<Widget>) widgetRepository.findAll();
    }
}
