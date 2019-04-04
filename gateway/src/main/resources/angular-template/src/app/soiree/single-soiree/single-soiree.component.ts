import { Component, OnInit } from '@angular/core';
import {EventPrivate} from "../../models/eventPrivate.model";
import {EventService} from "../../services/event.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Soiree} from "../../models/soiree.model";
import {SoireeService} from "../../services/soiree.service";
import {EventOpenData} from "../../models/eventOpenData.model";
import {ignore} from "selenium-webdriver/testing";

@Component({
  selector: 'app-single-soiree',
  templateUrl: './single-soiree.component.html',
  styleUrls: ['./single-soiree.component.scss']
})
export class SingleSoireeComponent implements OnInit {

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

  envoyerNotifsAuxAmis(idSoiree:number){
    console.log(idSoiree)
    this.soireeService.notifSoireeToFriends(idSoiree);
    this.router.navigate(['/dashboard']);

  }
}
