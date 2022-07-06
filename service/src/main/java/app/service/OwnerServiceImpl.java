package app.service;

import app.entity.OwnerEntity;
import app.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private  OwnerRepository ownerRepository;

    public OwnerServiceImpl() {
    }

    public void saveOwner(OwnerEntity owner) {
        try {
            ownerRepository.save(owner);
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }

    public List<OwnerEntity> getAllOwners() {
        try {
            return ownerRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }

    public void deleteOwner(String name) {
        try {
            ownerRepository.delete(findByName(name));
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }

    public OwnerEntity findByName(String name) {
        try {
            return ownerRepository.findOwnerByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }
}