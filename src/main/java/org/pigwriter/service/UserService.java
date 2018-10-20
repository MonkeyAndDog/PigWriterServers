package org.pigwriter.service;

import org.pigwriter.model.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService {
    private HibernateTemplate hibernateTemplate;

    public boolean verifyPassword(User user) {
        List<User> users = (List<User>) hibernateTemplate.find("from User user where user.username = ?", user.getUsername());
        if (users.size() == 1) {
            return users.get(0).getPassword().equals(user.getPassword());
        }
        return false;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
