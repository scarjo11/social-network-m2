import { Component, OnInit } from '@angular/core';
import {EventOpenData} from "../../models/eventOpenData.model";
import {Soiree} from "../../models/soiree.model";
import {SoireeService} from "../../services/soiree.service";
import {EventService} from "../../services/event.service";
import {ActivatedRoute, Router} from "@angular/router";
import {EventPrivate} from "../../models/eventPrivate.model";

@Component({
  selector: 'app-detail-notif-soiree',
  templateUrl: './detail-notif-soiree.component.html',
  styleUrls: ['./detail-notif-soiree.component.scss']
})
export class DetailNotifSoireeComponent implements OnInit {

  eventsOpenData: EventOpenData[];
  enventsPrivate: Event[];
  participants: String[];

  eventOpenDataID: number[];
  eventPrivateID: number[];

  tabPrivate = [];
  tabOpenData = [];

  singleSoiree: Soiree;

  constructor(private soireeService: SoireeService,
              private eventService : EventService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.singleSoiree = new Soiree('','');

    const id = this.route.snapshot.params['id'];
    this.soireeService.getSoiree(id).then(
      (soiree: Soiree) => {
        this.singleSoiree = soiree;
        // @ts-ignore: Unreachable code error
        this.eventPrivateID = soiree.evenementsPrivee;
        // @ts-ignore: Unreachable code error
        this.eventOpenDataID = soiree.evenementsExterne;


        for(var i = 0; i < this.eventPrivateID.length ; i++){
          this.eventService.getEventPrivate(this.eventPrivateID[i]).then(
            (eventPrivate: EventPrivate) => {
              this.tabPrivate.push(eventPrivate);
              console.log("tableau Private",  this.tabPrivate);
            }
          );
        }

        for(var i = 0; i < this.eventOpenDataID.length ; i++){
          this.eventService.getEventOpenData(this.eventOpenDataID[i]).then(
            (eventOpenData: EventOpenData) => {
              this.tabOpenData.push(eventOpenData);
              console.log("tableau OpenData",  this.tabOpenData);
            }
          );
        }

      }
    );

  }

  accepterInvitation(idSoiree:number){
    this.soireeService.participeToSoiree(idSoiree);
    this.router.navigate(['/dashboard']);

  }

}
