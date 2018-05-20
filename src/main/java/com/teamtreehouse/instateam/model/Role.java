package com.teamtreehouse.instateam.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Collaborator> mCollaborators = new ArrayList<>();

  @ManyToMany(mappedBy = "rolesNeeded")
  private List<Project> projects = new ArrayList<>();

  public List<Project> getProjects() {
    return projects;
  }

  public List<Collaborator> getCollaborators() {
    return mCollaborators;
  }

  public void addColaborator (Collaborator collaborator) {
    mCollaborators.add(collaborator);
    collaborator.setRole(this);
  }

  public void removeCollaborator (Collaborator collaborator) {
    mCollaborators.remove(collaborator);
    collaborator.setRole(null);
  }

  public Role() {

  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Role{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
