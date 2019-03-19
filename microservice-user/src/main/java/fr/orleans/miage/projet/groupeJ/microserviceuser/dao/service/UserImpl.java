package fr.orleans.miage.projet.groupeJ.microserviceuser.dao.service;

import fr.orleans.miage.projet.groupeJ.microserviceuser.dao.repository.UserRepository;
import fr.orleans.miage.projet.groupeJ.microserviceuser.domain.Follow;
import fr.orleans.miage.projet.groupeJ.microserviceuser.domain.Login;
import fr.orleans.miage.projet.groupeJ.microserviceuser.exceptions.FriendAlreadyException;
import fr.orleans.miage.projet.groupeJ.microserviceuser.exceptions.UserAlreadyConnectedException;
import fr.orleans.miage.projet.groupeJ.microserviceuser.exceptions.UserNotFoundException;
import fr.orleans.miage.projet.groupeJ.microserviceuser.model.Notification;
import fr.orleans.miage.projet.groupeJ.microserviceuser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by wilfrid on 14/03/2019.
 */
@Service
public class UserImpl implements IUser {

    @Autowired
    UserRepository userRepository;

    @Override
    public void connexion(Login login) throws UserNotFoundException, UserAlreadyConnectedException {

        User user = userRepository.getUserByPseudoAndPassword(login.getPseudo(), login.getPassword());
        if (user != null) {
            if (user.isConnected()) {
                throw new UserAlreadyConnectedException("L'utilisateur avec le pseudo " +
                        user.getPseudo() + " est deja connecté");

            }
            user.setConnected(true);
            userRepository.save(user);

        }else
        throw new UserNotFoundException("L'utilisateur avec le pseudo " +
                user.getPseudo() + " n'existe pas");
    }
    @Override
    public void inscription(User u) throws UserNotFoundException  {
        User user = userRepository.getUserByPseudo(u.getPseudo());
        if (user != null ){

            throw new UserNotFoundException("L'utilisateur avec le pseudo " + u.getPseudo() + " existe deja");

        }
        userRepository.save(u);
    }

    @Override
    public void deconnexion(String pseudo) {

    }


    @Override
    public void follow(Follow follow) {

        //liste des pseudo qui recevront la notif ici un seul en fonction du type de notif
        Collection<String> pseudos = new ArrayList<>();
        pseudos.add(follow.getAmis());
        User user1 = userRepository.getUserByPseudo(follow.getPseudo());
        User friend = userRepository.getUserByPseudo(follow.getAmis());

        //get amis du pseudo et add amis
        Collection<User> users = user1.getFriends();

        for (User u: users) {
            if(u.getPseudo().equals(follow.getAmis()))
                throw new FriendAlreadyException("vous avez deja follow ce user avec le pseudo"
                + follow.getAmis());
        }

        users.add(friend);
        user1.setFriends(users);
        friend.getNotifications().add(new Notification("le pseudo " +
                follow.getPseudo()+" vient de vous follow","follow" ));
        userRepository.save(friend);
        userRepository.save(user1);


    }

    /*le pseudo  veut unfollow le amis, je remove le amis   de la liste du pseudo
     * du follower */
    @Override
    public void unfollow(Follow follow) {

        User user1 = userRepository.getUserByPseudo(follow.getPseudo());
        User friend = userRepository.getUserByPseudo(follow.getAmis());

        //get amis du follower et enlever le friend de la liste des amis
        Collection<User> users = user1.getFriends();

        users.remove(friend);

        user1.setFriends(users);
        user1.getNotifications().add(new Notification("tu viens  de unfollow " +
                follow.getAmis()+" .","unfollow" ));
        userRepository.save(user1);

    }

    @Override
    public Collection<String> userFriends(String pseudo) {
        User user = userRepository.getUserByPseudo(pseudo);
        Collection<String> friendPseudo = new ArrayList<>();
        Collection<User> friend = user.getFriends();
        for (User u: friend) {
            friendPseudo.add(u.getPseudo());
        }
        return friendPseudo;
    }

    @Override
    public User getUserByPseudo(String pseudo) {
        return userRepository.getUserByPseudo(pseudo);
    }

    @Override
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Collection<Notification> getUserNotif(String pseudo) {
        User user = userRepository.getUserByPseudo(pseudo);

        return user.getNotifications();
    }


}
