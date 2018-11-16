package com.valik.dao;

import com.valik.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getAll() {
        return sessionFactory.getCurrentSession()
                .createNativeQuery("SELECT * FROM CATEGORIES", Category.class)
                .list();
    }
}
