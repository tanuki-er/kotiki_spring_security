package app.service;

import app.entity.CatEntity;
import app.entity.FriendsEntity;
import app.view.CatView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface CatService {
    List<CatEntity> getAllCats();

    boolean saveCat(CatEntity cat);

    CatEntity findByName(String passport);

    void deleteCat(String name);

}
