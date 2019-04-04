import {Component, OnDestroy, OnInit} from '@angular/core';
import {EventPrivate} from "../../models/eventPrivate.model";
import {Subscription} from "rxjs";
import {EventService} from "../../services/event.service";
import {Router} from "@angular/router";
import {EventOpenData} from "../../models/eventOpenData.model";
import {NgForm} from '@angular/forms';
import {SoireeService} from "../../services/soiree.service";

@Component({
  selector: 'app-liste-evenement-public',
  templateUrl: './liste-evenement-public.component.html',
  styleUrls: ['./liste-evenement-public.component.scss']
})
export class ListeEvenementPublicComponent implements OnInit, OnDestroy {

  eventsOpenData: EventOpenData[];
  eventOpenDataSubscription: Subscription;

  eventsPrivate: EventPrivate[];
  eventPrivateSubscription: Subscription;

  sessionPseudo = sessionStorage.getItem("userConnected");
  sessionIdSoiree = sessionStorage.getItem("idsoiree");
  idEventOpenData: void;


  constructor(private eventService: EventService,
              private soireeService: SoireeService,
              private router: Router) { }

  ngOnInit() {
    this.eventService.getAllEventOpenData();
    this.eventService.getAllEventPrivate(this.sessionPseudo);

    this.eventOpenDataSubscription = this.eventService.eventOpenDataSubject.subscribe(
      (eventsOpenData: EventOpenData[]) => {
        this.eventsOpenData = eventsOpenData;
      }
    );
    this.eventService.emitEventOpenData()



    this.eventPrivateSubscription = this.eventService.eventPrivateSubject.subscribe(
      (eventsPrivate: EventPrivate[]) => {
        this.eventsPrivate = eventsPrivate;
      }
    );
    this.eventService.emitEventPrivate();
  }

  onSubmit(form: NgForm) {
    const eventprivee = form.value['eventprivee'];

    console.log(eventprivee);
    this.soireeService.ajouterEventPriveASoiree(+(this.sessionIdSoiree), eventprivee);
  }

  onAjouterEventToSoiree(title: string, placename: string, link: string){
    console.log("str",this.sessionIdSoiree)
    const newEventPublic = new EventOpenData(title, placename, link);
    console.log("event ici", newEventPublic);
    this.eventService.addEvenementPriveess(newEventPublic);
    console.log("num",+this.sessionIdSoiree)
    this.eventService.ajouterEventOpenDataASoiree(+this.sessionIdSoiree);
  }

  ngOnDestroy() {
    this.eventOpenDataSubscription.unsubscribe();
    this.eventPrivateSubscription.unsubscribe();
  }

}
