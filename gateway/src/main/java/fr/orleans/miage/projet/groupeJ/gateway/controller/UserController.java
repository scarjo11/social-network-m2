package fr.orleans.miage.projet.groupeJ.gateway.controller;

import fr.orleans.miage.projet.groupeJ.gateway.beans.NotificationBean;
import fr.orleans.miage.projet.groupeJ.gateway.beans.UserBean;
import fr.orleans.miage.projet.groupeJ.gateway.domain.Follow;
import fr.orleans.miage.projet.groupeJ.gateway.domain.Login;
import fr.orleans.miage.projet.groupeJ.gateway.proxies.MicroserviceUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wilfrid on 12/03/2019.
 */
@Controller
@SessionAttributes("pseudo")
public class UserController {

    @Autowired
    private MicroserviceUserProxy microserviceUserProxy;



    @GetMapping(value = "/")
    public String accueil(Model model, @SessionAttribute(value="pseudo", required = false) String pseudo){

        if(pseudo!=null)
            return "redirect:/dashboard";

        return "acceuil";
    }

  /*  @GetMapping("/users")
    public String allUsers(Model model){

        ResponseEntity<Iterable<UserBean>> users =  microserviceUserProxy.getAllUser();

        model.addAttribute("users", users);

        return "allUsers";
    }
*/
  @GetMapping("/users")
  public  ResponseEntity<Iterable<UserBean>> allUsers(Model model){

      Iterable<UserBean> users =  microserviceUserProxy.getAllUser();

      model.addAttribute("users", users);

      return ResponseEntity.ok(users);
  }
    @GetMapping("/dashboard")
    public String dashboard(Model model, @SessionAttribute(value="pseudo", required = false) String pseudo){

        Iterable<UserBean> users =  microserviceUserProxy.getAllUser();

        model.addAttribute("users", users);
        UserBean user = microserviceUserProxy.getUserByPseudoMethod(pseudo);
        Collection<NotificationBean> notif =  microserviceUserProxy.getAllNotifUser(pseudo);

        model.addAttribute("user", user);
        model.addAttribute("nbreNotif", notif.size());
        model.addAttribute("pseudo", user.getPseudo());
        model.addAttribute("friends", microserviceUserProxy.getFriendPseudo(user.getPseudo()));

        return "dashboard";
    }

    @GetMapping("/detail-user/{pseudoUser}")
    public String userDetail(@SessionAttribute(value="pseudo", required = false) String pseudo
            ,@PathVariable("pseudoUser") String pseudoUser, Model model){

        UserBean user = microserviceUserProxy.getUserByPseudoMethod(pseudoUser);

        model.addAttribute("user", user);
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("follow", new Follow());

        return "detail-user";
    }

    @GetMapping("/notification/{pseudoUser}")
    public String notification(@SessionAttribute(value="pseudo", required = false) String pseudo
            ,@PathVariable("pseudoUser") String pseudoUser, Model model){

      //  UserBean user = microserviceUserProxy.getUserByPseudoMethod(pseudoUser);
        Collection<NotificationBean> notif =  microserviceUserProxy.getAllNotifUser(pseudoUser);

     //   model.addAttribute("user", user);
        model.addAttribute("notification", notif);
        model.addAttribute("nbreNotif", notif.size());
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("follow", new Follow());

        return "notification";
    }

    @GetMapping("/detail-amis/{pseudoUser}")
    public String amisDetail(@SessionAttribute(value="pseudo", required = false) String pseudo
            ,@PathVariable("pseudoUser") String pseudoUser, Model model){

        UserBean user = microserviceUserProxy.getUserByPseudoMethod(pseudoUser);

        model.addAttribute("user", user);
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("follow", new Follow());

        return "detail-amis";
    }

/*
    @GetMapping("/notif/{pseudoUser}")
    public String notif(@SessionAttribute(value="pseudo", required = false) String pseudo
            ,@PathVariable("pseudoUser") String pseudoUser, Model model){

        UserBean user = microserviceUserProxy.getUserByPseudoMethod(pseudoUser);

        model.addAttribute("user", user);
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("notification",  user.getNotifications());

        return "notif";
    }
*/


    @PostMapping(value = "/login")
    public String login(@ModelAttribute Login login, Model model){

        microserviceUserProxy.connexion(login);

        UserBean user = microserviceUserProxy.getUserByPseudoMethod(login.getPseudo());
        model.addAttribute("user", user);
        model.addAttribute("pseudo", user.getPseudo());
        model.addAttribute("friends", microserviceUserProxy.getFriendPseudo(user.getPseudo()));

        return "redirect:/dashboard";
    }

    @PostMapping(value = "/follow")
    public String follow(@ModelAttribute Follow follow,
                         @SessionAttribute(value="pseudo", required = false) String pseudo, Model model){

        microserviceUserProxy.follow(follow);

        UserBean user = microserviceUserProxy.getUserByPseudoMethod(pseudo);
        model.addAttribute("user", user);
        model.addAttribute("pseudo", user.getPseudo());
        model.addAttribute("msgFollow", "vous avez bien follow" + follow.getAmis());
        model.addAttribute("friends", microserviceUserProxy.getFriendPseudo(pseudo));


        return "redirect:/dashboard";
    }



    @PostMapping(value = "/unfollow")
    public String unfollow(@ModelAttribute Follow follow,
                         @SessionAttribute(value="pseudo", required = false) String pseudo, Model model){

        microserviceUserProxy.unfollow(follow);

        UserBean user = microserviceUserProxy.getUserByPseudoMethod(pseudo);
        model.addAttribute("user", user);
        model.addAttribute("pseudo", user.getPseudo());
        model.addAttribute("msgUnfollow", "vous avez bien unfollow " + follow.getAmis());
        model.addAttribute("friends", microserviceUserProxy.getFriendPseudo(pseudo));


        return "redirect:/dashboard";
    }

    @GetMapping(value = "/login" )
    public String loginTemplate(Model model){

        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping(value = "/inscription")
    public String inscription(@ModelAttribute UserBean u, Model model){

         microserviceUserProxy.inscription(u);
        UserBean userBean = microserviceUserProxy.getUserByPseudoMethod(u.getPseudo());
        String pseudos = userBean.getPseudo();
        model.addAttribute("pseudo", pseudos);
    //   return "login";
       return        "redirect:/login";

    }


    @GetMapping("/inscription")
    public String inscriptionTemplate(Model model){

        model.addAttribute("user", new UserBean());

        return "inscription";
    }
}
