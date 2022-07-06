package app.service;

import app.entity.CatEntity;
import app.repository.CatRepository;
import app.repository.OwnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRepository catRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    public List<CatEntity> getAllCats() {
        try {
            return catRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }

    public boolean saveCat(CatEntity cat) {
        try {
            catRepository.save(cat);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }

    public CatEntity findByName(String name) {
        try {
            return catRepository.findCatByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }

    public void deleteCat(String name) {
        try {
            catRepository.delete(findByName(name));
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }
}