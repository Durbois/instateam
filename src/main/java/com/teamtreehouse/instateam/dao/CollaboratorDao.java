package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.model.Collaborator;

import java.util.List;
import java.util.Locale;

public interface CollaboratorDao {
  List<Collaborator> findAll();
  Collaborator findById(Long id);
  void save ( Collaborator collaborator );
  void delete ( Collaborator collaborator );
}
