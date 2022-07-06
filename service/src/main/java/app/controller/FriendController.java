package app.controller;

import app.entity.FriendsEntity;
import app.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {
    @Autowired
    private FriendsService catService;

    public FriendController() {

    }

    @GetMapping("/getfriends")
    public FriendsEntity getFriendsCat(@RequestBody FriendsEntity friends) {
        return catService.getFriendsCat(friends);
    }
    //

    @PostMapping("/addpairfriend")
    public FriendsEntity addPairFriend(@RequestBody FriendsEntity friends) {
        catService.addPairFriend(friends);
        return friends;
    }

    @GetMapping("/allfriends")
    public List<FriendsEntity> getAllFriends() {
        return catService.getAllFriends();
    }
}
