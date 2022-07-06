package app.repository;

import app.entity.FriendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends JpaRepository<FriendsEntity, Integer> {
}
