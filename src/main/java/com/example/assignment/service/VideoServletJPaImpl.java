package com.example.assignment.service;

import com.example.assignment.entity.Favorite;
import com.example.assignment.entity.Video;
import jakarta.persistence.*;

import java.util.List;

public class VideoServletJPaImpl implements VideoService{

    @Override
    public Video findById(String id) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
       return em.find(Video.class,id);

    }

    @Override
    public Video add(Video m) {
        EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        return m;
    }

    @Override
    public Video update(Video m) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(m);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        return m;
    }

    @Override
    public void deleteById(String id) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        try{
            Query q=em.createNativeQuery("delete from Favorites where videoid=:id",Favorite.class);
            q.setParameter("id",id);


            em.getTransaction().begin();

            em.remove(em.find(Video.class, id));
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Video thich(String id) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        TypedQuery<Video> ty=em.createQuery("select distinct f.video from Favorite f join f.video where f.video.id=:id",Video.class);
        ty.setParameter("id",id);
        List<Video> list=ty.getResultList();
        for (Video x:
             list) {
            System.out.println(x.getPoster());
            if(x.getId().equals(id)) return x;
        }
        return null;
    }

    @Override
    public List<Video> favo(String userid) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        TypedQuery<Video> ty=em.createQuery("select f.video from Favorite f where f.user.id=:userid",Video.class);
        ty.setParameter("userid",userid);
        List<Video> list=ty.getResultList();
        return list;

    }


    @Override
    public List<Video> findAll() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        TypedQuery<Video> ty= em.createQuery("select v from Video v",Video.class);
        return ty.getResultList();

    }

    @Override
    public List<Video> search(String keyword) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        TypedQuery<Video> v=em.createQuery("select v from Video v where lower(v.title)  like lower(:keyword) ",Video
                .class);
        v.setParameter("keyword","%"+keyword+"%");
        System.out.println(v.getResultList());
        List<Video> list=v.getResultList();
//        for (Video x:
//             list) {
//            if(x.getTitle().equals(keyword)) return list;
//        }
        return list;
    }

    @Override
    public List<Video> searchFavorite(String userId, String keyword) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PolyOE");
        EntityManager em = factory.createEntityManager();
        TypedQuery<Video> ty=em.createQuery("select  f.video from Favorite f join f.video join f.user where f.user.id=:userId  and lower(f.video.title)  like lower(:keyword)  ",Video.class);
        ty.setParameter("userId",userId);

        ty.setParameter("keyword","%"+keyword+"%");
        List<Video> v=ty.getResultList();
//        for (int i = 0; i < v.size(); i++) {
//            System.out.println(v.size());
//            if (v.get(i).getId().equals(keyword)) {
//                System.out.println(v);
//                return v;
//            }
//        }
        return v;
    }

//    @Override
//    public boolean click(String vidid) {
//        EntityManagerFactory factory =
//                Persistence.createEntityManagerFactory("PolyOE");
//        EntityManager em = factory.createEntityManager();
//        Query q=em.createNativeQuery("update videos set views=views + 1 where id=:id",Video.class);
//        q.setParameter("id",vidid);
//        return true;
//    }
}
