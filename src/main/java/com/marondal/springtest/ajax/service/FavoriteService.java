package com.marondal.springtest.ajax.service;

import com.marondal.springtest.ajax.domain.Favorite;
import com.marondal.springtest.ajax.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    // IoC : 제어의 역전
    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Favorite> getFavoriteList() {
        List<Favorite> favoriteList = favoriteRepository.selectFavoriteList();

        return favoriteList;
    }

    public int createFavorite(String name, String url) {
        int count = favoriteRepository.insertFavorite(name, url);

        return count;
    }

    public boolean isDuplicateUrl(String url) {

        int count = favoriteRepository.countFavoriteByUrl(url);

        return count != 0;
//        if(count == 0) {
//            return false;
//        } else {
//            return true;
//        }

    }

    public int deleteFavorite(int id) {

        int count = favoriteRepository.deleteFavorite(id);

        return count;
    }
}
