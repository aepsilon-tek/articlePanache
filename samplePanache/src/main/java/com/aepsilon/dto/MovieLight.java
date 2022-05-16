package com.aepsilon.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class MovieLight {
    private Long id;
    private String title;
    private String description;


   public MovieLight(Long id, String title, String description){
       this.id=id;
       this.title=title;
       this.description=description;
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


}
