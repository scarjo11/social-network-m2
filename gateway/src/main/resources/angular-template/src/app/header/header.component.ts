import { Component, OnInit } from '@angular/core';
import {NotificationEvent} from "../models/notificationEvent.model";
import {NotifService} from "../services/notif.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  notifs: NotificationEvent[];
  notifSubscription: Subscription;
  sessionPseudo = sessionStorage.getItem("userConnected");

  constructor(private notifService: NotifService) { }

  ngOnInit() {
    this.notifService.getNotifications(this.sessionPseudo);

    this.notifSubscription = this.notifService.notifSubject.subscribe(
      (notif: NotificationEvent[]) => {
        this.notifs = notif;
        console.log('taille', this.notifs.length);
      }
    );
    this.notifService.emitNotif();
  }

  ngOnDestroy() {
    this.notifSubscription.unsubscribe();
  }

}
