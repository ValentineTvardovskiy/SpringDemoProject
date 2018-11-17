package com.valik.dao;

import com.valik.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;
/*
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO USERS (EMAIL, TOKEN, PASSWORD, FIRST_NAME, LAST_NAME) VALUES (?, ?, ?, ?, ?)",
                user.getEmail(),
                user.getToken(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName());
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT ID, EMAIL, TOKEN, PASSWORD, FIRST_NAME, LAST_NAME " +
                "FROM USERS WHERE EMAIL = ?", new Object[] {email}, new BeanPropertyRowMapper<>(User.class)));
    }
*/


    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        User user = (User) sessionFactory.getCurrentSession()
                .createQuery("from User u join fetch u.roles where email =:email")
                .setParameter("email", email)
                .uniqueResult();
        return Optional.ofNullable(user);
    }
}
