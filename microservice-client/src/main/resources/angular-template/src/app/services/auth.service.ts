import { Injectable } from '@angular/core';
import {Subject} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user.model";
import {Login} from "../models/login.model";

@Injectable()
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  private users: User[] = [];
  private usersConnected: Login[] = [];

  userSubject = new Subject<User[]>();
  loginSubject = new Subject<Login[]>();

  emitUsers() {
    this.userSubject.next(this.users.slice());
  }

  emitLogin() {
    this.loginSubject.next(this.usersConnected.slice());
  }

  addUser(user: User) {
    this.users.push(user);
    this.emitUsers();

    let url = "http://localhost:8085/inscription";

    let formData = new FormData();
    formData.append('pseudo', user.pseudo);
    formData.append('firstName', user.firstName);
    formData.append('lastName', user.lastName);
    formData.append('email', user.email);
    formData.append('password', user.password);

    console.log(formData)


    this.httpClient.post<any>(url, formData).subscribe(
      res => {
        formData = res;
        console.log(formData)
      },
      err => {

      }
    );
  }

  connectUser(login: Login) {
    this.usersConnected.push(login)
    this.emitUsers();

    let url = "http://localhost:8085/login";

    let formData = new FormData();
    formData.append('pseudo', login.pseudo);
    formData.append('password', login.password);

    console.log(formData)


    this.httpClient.post<any>(url, formData).subscribe(
      res => {
        formData = res;
        console.log(formData)
      },
      err => {

      }
    );
  }
}
