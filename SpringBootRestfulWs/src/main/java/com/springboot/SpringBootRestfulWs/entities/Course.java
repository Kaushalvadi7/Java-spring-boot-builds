package com.springboot.SpringBootRestfulWs.entities;

public class Course {

    private Long id;
    private String title;
    private String description;

    public Course(long id, String title, String description) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
    }
}
