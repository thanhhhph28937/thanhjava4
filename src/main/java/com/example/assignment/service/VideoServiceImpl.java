//package com.example.assignment.service;
//
//import com.example.assignment.entity.Favorite;
//import com.example.assignment.entity.Video;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import jakarta.persistence.TypedQuery;
//
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
//public class VideoServiceImpl implements VideoService{
//    EntityManagerFactory factory =
//            Persistence.createEntityManagerFactory("PolyOE");
//    EntityManager em = factory.createEntityManager();
//    List<Video> videos=new ArrayList<>();
//
//    public Video findById(String id) {
//        for(Video v:videos){
//            if(v.getId().equals(id)) return v;
//        }
//        return null;
//
//    }
//
//    public Video add(Video m) {
//        for (Video x:
//             videos) {
//            if(!x.getId().equals(m.getId())) videos.add(m);
//        }
//
//        return null;
//    }
//
//
//    public Video update(Video m) {
//        for(int i = 0; i < videos.size(); i++){
//            if(videos.get(i).getId().equals(m.getId())){
//                videos.set(i, m);
//            }
//        }
//        return null;
//    }

//    @Override
//    public void deleteById(String id) {
//                int index = -1;
//        for(int i = 0; i < videos.size(); i++) {
//            if (videos.get(i).getId().equals(id)) {
//                index = i;
//                break;
//            }
//        }
//        if(index >= 0) videos.remove(index);
//
//    }
//
//    @Override
//    public Video thich(String id) {
//
//        for(Video v:videos){
//            if(v.getId().equals(id)) return v;
//        }
//        return null;
//    }
//
//    @Override
//    public List<Video> favo(String userid) {
//        return null;
//    }
//
//
//    public List<Video> findAll() {
//       return videos;
//    }
//
//
//    public List<Video> search(String keyword) {
//        for (Video x:
//             videos) {
//            if(x.getId().equals(keyword)) return videos;
//        }
//        return null;
//
//    }
//
//
//    public List<Video> searchFavorite(String userId, String keyword) {
//        for (Video x:
//                videos) {
//            if(x.getId().equals(keyword)) return videos;
//        }
//        return null;
//
//    }
//}
