import {Component, OnDestroy, OnInit} from '@angular/core';
import {User} from "../../models/user.model";
import {Subscription} from "rxjs";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.scss']
})
export class ListUsersComponent implements OnInit, OnDestroy {

  users: User[];
  userSubscription: Subscription;
  sessionPseudo = sessionStorage.getItem("userConnected");

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getAllUsers();

    this.userSubscription = this.userService.userSubject.subscribe(
      (users: User[]) => {
        this.users = users;
      }
    );
    this.userService.emitUsers();
  }

  ngOnDestroy() {
    this.userSubscription.unsubscribe();
  }

}
