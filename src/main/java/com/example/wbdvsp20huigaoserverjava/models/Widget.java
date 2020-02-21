package com.example.wbdvsp20huigaoserverjava.models;


public class Widget {


    private String id;

    private String title;
    private String topicId;
    private String type = "HEADING";
    private int size = 2;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Widget() {
    }

    public Widget(String id, String title) {
        this.id = id;
        this.title = title;
    }
}