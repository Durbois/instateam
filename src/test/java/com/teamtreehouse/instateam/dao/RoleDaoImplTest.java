package com.teamtreehouse.instateam.dao;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

import com.teamtreehouse.instateam.InstateamApplication;
import com.teamtreehouse.instateam.model.Collaborator;
import com.teamtreehouse.instateam.model.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@PropertySource("classpath:application.properties")
public class RoleDaoImplTest {

  @Autowired
  private RoleDao dao;

  @Before
  public void setUp() throws Exception {
    Role role = new Role();
    role.setName("Role");
    dao.save(role);
  }

  @Test
  public void shouldGiveRoleList () {
    dao.findAll().stream()
        .forEach(System.out::println);

    assertThat(dao.findAll(), hasSize(1));
  }
}