package app.repository;

import app.entity.CatEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<CatEntity, Integer> {
    CatEntity findCatByName(String name);

}
