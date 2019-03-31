import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {ActivatedRoute} from "@angular/router";
import {User} from "../../models/user.model";
@Component({
  selector: 'app-single-user',
  templateUrl: './single-user.component.html',
  styleUrls: ['./single-user.component.scss']
})
export class SingleUserComponent implements OnInit {

  constructor(public userService : UserService,
              private route: ActivatedRoute) { }

  singleUser: User;

  ngOnInit() {
    this.singleUser = new User('','','','','')

    const pseudo = this.route.snapshot.params['pseudo'];
    this.userService.getUser(pseudo).then(
      (user: User) => {
        this.singleUser = user;
      }
    );
    /*alert(this.pseudo);
    this.firstName = this.userService.getUser(pseudo).firstName;
    this.lastName = this.userService.getUser(pseudo).lastName;
    this.email = this.userService.getUser(pseudo).email;*/
  }

}
