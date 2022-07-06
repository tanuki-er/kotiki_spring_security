package app.service;

import app.entity.OwnerEntity;

import java.util.List;

public interface OwnerService {

    void saveOwner(OwnerEntity owner);

    List<OwnerEntity> getAllOwners();

    void deleteOwner(String name);

    OwnerEntity findByName(String name);

}