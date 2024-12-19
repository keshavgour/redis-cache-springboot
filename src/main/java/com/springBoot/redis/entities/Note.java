package com.springBoot.redis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "stream_note")
public class Note implements Serializable {

    @Id
    private String id;

    private String title;

    private String content;

    private Date addedDate;

    private boolean live=false;

    public Note(String id, String title, String content, Date addedDate, boolean live) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.addedDate = addedDate;
        this.live = live;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Note() {
    }

}
