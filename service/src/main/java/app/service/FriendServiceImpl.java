package app.service;


import app.entity.FriendsEntity;
import app.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendsService {
    @Autowired
    private FriendsRepository friendsRepository;

    public FriendServiceImpl() {
    }

    public void deletePairFriends(FriendsEntity friends) {
        try {

            friendsRepository.delete(friends);
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }

    public boolean addPairFriend(FriendsEntity friends) {
        try {
            var all = getAllFriends();

            friendsRepository.save(friends);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }

    public List<FriendsEntity> getAllFriends() {
        try {
            return friendsRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }

    public FriendsEntity getFriendsCat(FriendsEntity friends) {
        try {
            return friendsRepository.findAll().get(friends.getId());
        } catch (Exception e) {
            throw new RuntimeException("Exception " + e.getMessage());
        }
    }

}
