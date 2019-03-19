package fr.orleans.miage.projet.groupeJ.microserviceuser.controller;

import fr.orleans.miage.projet.groupeJ.microserviceuser.dao.service.IUser;
import fr.orleans.miage.projet.groupeJ.microserviceuser.domain.Follow;
import fr.orleans.miage.projet.groupeJ.microserviceuser.domain.Login;
import fr.orleans.miage.projet.groupeJ.microserviceuser.model.Notification;
import fr.orleans.miage.projet.groupeJ.microserviceuser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

/**
 * Created by wilfrid on 02/03/2019.
 */
@RestController
@RequestMapping(value ="/"/*, consumes = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE,
        "application/x-www-form-urlencoded"}*/)
public class UserController {

    @Autowired
    private IUser facade;


    //inscription du user
    @PostMapping(value = "users")
    public ResponseEntity inscription(@RequestBody User u){
        facade.inscription(u);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{pseudo}")
                .buildAndExpand(u.getPseudo()).toUri();

        return ResponseEntity.created(location).build();
    }

    //retourne les pseudo des amis du user pour envoi de notification
    @PostMapping(value = "users/login")
    public  ResponseEntity connexion(@RequestBody Login login){
         facade.connexion(login);


         return ResponseEntity.ok().build();
    }


    @PostMapping(value = "users/follow")
    public ResponseEntity follow(@RequestBody Follow follow){
        facade.follow(follow);

        return  ResponseEntity.ok().build();
    }


    @PostMapping(value = "users/unfollow")
    public ResponseEntity unfollow(@RequestBody Follow follow){

        facade.unfollow(follow);

        return  ResponseEntity.ok().build();
    }

    @GetMapping(value = "users/friends/{pseudo}")
    public  Collection<String> getFriendPseudo(@PathVariable("pseudo") String  pseudo){
       Collection<String> friend = facade.userFriends(pseudo);

            return    friend;

    }

    @GetMapping(value = "users/notif/{pseudo}")
    public  Collection<Notification> getNotifUser(@PathVariable("pseudo") String  pseudo){
        Collection<Notification> notifications = facade.getUserNotif(pseudo);

        return    notifications;

    }


    @GetMapping(value = "users/{pseudo}")
    public  ResponseEntity<User> getUser(@PathVariable("pseudo") String  pseudo){
        User user= facade.getUserByPseudo(pseudo);

        return    ResponseEntity.ok(user);

    }

    @GetMapping(value = "users/pseudo")
    public  User getUserByPseudoMethod(@RequestParam("pseudo") String  pseudo){
        User user= facade.getUserByPseudo(pseudo);

        return   user;

    }

    @GetMapping(value = "users")
    public  Iterable<User> getAllUser(){
       ;

        return   facade.getAllUser();

    }


}

