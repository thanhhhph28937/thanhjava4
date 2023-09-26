package com.example.assignment.service;

import com.example.assignment.entity.Favorite;
import com.example.assignment.entity.Video;

import java.util.List;

public interface VideoService {
    Video findById(String id);
    Video add(Video m);
    Video update(Video m);
    void deleteById(String id);
    Video thich(String id);
    List<Video> favo(String userid);

    List<Video> findAll();
    List<Video> search(String keyword);
    List<Video> searchFavorite(String userId, String keyword);
//    boolean click(String vidid);

}
