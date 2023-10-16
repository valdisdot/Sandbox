package com.valdisdot.sandbox.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "details")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "project_name", unique = true)
    private String projectName;

    @Column(name = "head_contact")
    private String headContact;

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getHeadContact() {
        return headContact;
    }

    public void setHeadContact(String headContact) {
        this.headContact = headContact;
    }
}
