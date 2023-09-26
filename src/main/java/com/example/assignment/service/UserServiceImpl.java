package com.example.assignment.service;

import com.example.assignment.entity.User;
import jakarta.persistence.*;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Override
    public boolean checkUser(String username, String password) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        TypedQuery<User> ty= em.createQuery("select u from User u where u.id=:username and u.password=:password",User.class);
        ty.setParameter("username",username);
        ty.setParameter("password",password);
        List<User> u=ty.getResultList();
        for (User x:
                u) {
            if(x.getId().equals(username)&&x.getPassword().equals(password)) return true;
        }
        return false;
    }

    @Override
    public User signup(User u) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            return u;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return null;

    }

    @Override
    public List<User> getall() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        TypedQuery<User> ty=em.createQuery("select u from User u",User.class);
        return ty.getResultList();
    }

    @Override
    public User getpass(String email) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        TypedQuery<User> ty=em.createQuery("select u from User u where u.email=:email",User.class);
        ty.setParameter("email",email);
        List<User> list=ty.getResultList();
        for (User x:
             list) {
            if(x.getEmail().equals(email)) return x;
        }
        return null;
    }


}
