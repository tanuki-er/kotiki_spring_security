package app.repository;

import app.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Integer> {
    OwnerEntity findOwnerByName(String name);

}
