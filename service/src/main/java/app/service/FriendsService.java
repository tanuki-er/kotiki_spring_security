package app.service;

import app.entity.FriendsEntity;


import java.util.List;

public interface FriendsService {

    void deletePairFriends(FriendsEntity friends);

    boolean addPairFriend(FriendsEntity friends);

    List<FriendsEntity> getAllFriends();

    FriendsEntity getFriendsCat(FriendsEntity friendsEntity);

}
