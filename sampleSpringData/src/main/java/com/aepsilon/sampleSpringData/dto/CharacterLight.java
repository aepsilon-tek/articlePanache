package com.aepsilon.sampleSpringData.dto;

public class CharacterLight {

    private Long id;
    private String firstname;
    private String lastname;


    public CharacterLight(Long id,String firstname, String lastname){
        this.id=id;
        this.lastname=lastname;
        this.firstname=firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
