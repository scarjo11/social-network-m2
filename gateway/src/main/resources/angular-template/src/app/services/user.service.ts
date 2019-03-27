import { Injectable } from '@angular/core';
import {User} from "../models/user.model";
import { Subject } from 'rxjs/Subject';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class UserService {

  constructor(private httpClient: HttpClient) {}


  private users: User[] = [];
  userSubject = new Subject<User[]>();

  emitUsers() {
    this.userSubject.next(this.users.slice());
  }

  addUser(user: User) {
    this.users.push(user);
    this.emitUsers();
  }

  getAllUsers(){
    let url = "http://localhost:8095/users";

    this.httpClient.get<any[]>(url).subscribe(
      res => {
        this.users = res;
        this.emitUsers();
        console.log(this.users);
      },
      err => {
        alert('ERROR !');
      }
    );
  }
}
