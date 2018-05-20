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

@Entity
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String description;

  @Column
  private String status;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<Role> rolesNeeded = new ArrayList<>();

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<Collaborator> collaborators = new ArrayList<>();

  public void addCollaborator ( Collaborator collaborator ) {
    collaborators.add(collaborator);
    collaborator.getProjects().add(this);
  }

  public void removeCollaborator ( Collaborator collaborator ) {
    collaborators.remove(collaborator);
    collaborator.getProjects().remove(this);
  }

  public void addRole (Role role) {
    rolesNeeded.add(role);
    role.getProjects().add(this);
  }

  public void removeRole (Role role) {
    rolesNeeded.remove(role);
    role.getProjects().remove(this);
  }
}
