package app.service;

import app.entity.*;
import app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
// check it

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private  FriendsRepository friendsRepository;
    @Autowired
    private  RoleRepository roleRepository;
    @Autowired
    private  CatRepository catRepository;
    @Autowired
    private  OwnerRepository ownerRepository;

    public UserService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username);
    }

    public UserEntity findUserById(Integer id) throws ChangeSetPersister.NotFoundException {
        Optional<UserEntity> userFromDatabase = userRepository.findById(id);
        return userFromDatabase.orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<UserEntity> allUsers() {
        return userRepository.findAll();
    }

    public Integer register(UserEntity userDTO) {
        boolean userExists = userRepository.existsByUserName(userDTO.getUsername());
        if(!userExists) {
            String userPassword = userDTO.getPassword();
            userDTO.setPassword(passwordEncoder.encode(userPassword));
            userDTO.addRole(roleRepository.findById(1).get());
        }
        userRepository.save(userDTO);
        return userDTO.getId();
    }

    public void giveRole(Integer id, Integer roleId) {
        Optional<RoleEntity> role = roleRepository.findById(roleId);
        Optional<UserEntity> user = userRepository.findById(id);
        if(role.isPresent() & user.isPresent()) {
            user.get().addRole(role.get());
        }
        userRepository.save(user.get());
    }

    public void setOwnerToUser(UserEntity user, Integer ownerId) {
        user.setOwnerId(ownerId);
        System.out.println(user);
        userRepository.save(user);
    }

    public void deleteOwnerOfUser(UserEntity user) {
        user.setOwnerId(null);
        userRepository.save(user);
        Integer ownerId = user.getOwnerId();
        ownerRepository.deleteById(ownerId);
    }

    public OwnerEntity getOwnerOfUser(UserEntity user) /*throws NotFoundByIdException, NotCreatedOwnerException */{
        /*if(user.getOwner() == null) {
            throw new NotCreatedOwnerException("У данного пользователя нет владельца");
        }*/
        Optional<OwnerEntity> owner = ownerRepository.findById(user.getOwnerId());
        /*if(owner.isEmpty()) {
            throw new NotFoundByIdException("Такого владельца нет");
        }*/
        return owner.get();
    }

/*
    public List<CatEntity> getAllCatsOfUser(UserEntity user) throws NotFoundByIdException {
        Optional<OwnerEntity> owner = ownerRepository.findById(user.getOwnerId());
        if(owner.isEmpty()) {
        //    throw new NotFoundByIdException("Owner пользователя не найден");
        }
        List<CatEntity> cats = owner.get().getCats();
        return cats;
    }
*/
    public CatEntity getCatById(UserEntity user, Integer id) /*throws NotFoundByIdException, AccessToStrangersEntityException */{
        Optional<OwnerEntity> owner = null;
        if(user.getOwnerId() != null) {
            owner = ownerRepository.findById(user.getOwnerId());
        }
        /*if(owner.isEmpty()) {
            throw new NotFoundByIdException("Not found");
        }*/
        Optional<CatEntity> cat = catRepository.findById(id);
        /*if(cat.isEmpty()) {
            throw new NotFoundByIdException("Not found");
        }*/
        if(cat.get().getOwnerId() == owner.get().getId()) {
            return cat.get();
        }
        return cat.get();//?
        /*else {
            throw new AccessToStrangersEntityException("Not your cat");
        }*/
    }

    public void deleteCatOfUser(UserEntity user, Integer id) /*throws AccessToStrangersEntityException, NotFoundByIdException*/ {
        Optional<OwnerEntity> owner = null;
        if(user.getOwnerId() != null) {
            owner = ownerRepository.findById(user.getOwnerId());
        }
        if(owner.isEmpty()) {
            //throw new NotFoundByIdException("Not found");
        }
        Optional<CatEntity> cat = catRepository.findById(id);
        if(cat.isPresent()) {
            if(cat.get().getOwnerId() == owner.get().getId()) {

                catRepository.deleteById(cat.get().getId());
                //owner.get().getCats().remove(cat);
                //ownerRepository.save(owner.get());
                catRepository.save(cat.get());
            } else {
                //throw new AccessToStrangersEntityException("Not your cat");
            }
        }
    }
/*
    public void addFriendToCat(UserEntity user, Integer id, Integer friendId) throws NotFoundByIdException, AccessToStrangersEntityException  {
        Optional<CatEntity> cat = null;
        Optional<FriendsEntity> friend = null;
        Optional<OwnerEntity> owner = null;
        if (user.getOwnerId() != null) {
            owner = ownerRepository.findById(user.getOwnerId());
        }
        if (owner.isEmpty()) {
            //throw new NotFoundByIdException("Not found");
        }
        //cat = catRepository.findById(id);
        friend = friendsRepository.findById(friendId);
        if (friend.isPresent()) {
            if (friend.get().getId1() == cat.get().getId() || friend.get().getId2() == cat.get().getId()) {

                friend.get().makeFriends(friend.get());
                friendsRepository.save(friend.get());
            } else {
                //  throw new AccessToStrangersEntityException("Not your cat");
            }
        }
    }*/
}
