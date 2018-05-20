package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Role> findAll() {

    Session session = sessionFactory.openSession();

    List<Role> roles = session.createQuery("FROM Role").list();

    session.close();

    return roles;
  }

  @Override
  public Role findById(Long id) {
    return null;
  }

  @Override
  public void save(Role role) {
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    session.saveOrUpdate(role);

    session.getTransaction().commit();

    session.close();
  }

  @Override
  public void delete(Role role) {

  }
}
