import {Component, OnDestroy, OnInit} from '@angular/core';
import {EventPrivate} from "../../models/eventPrivate.model";
import {Subscription} from "rxjs";
import {EventService} from "../../services/event.service";
import {Router} from "@angular/router";
import {Soiree} from "../../models/soiree.model";
import {SoireeService} from "../../services/soiree.service";

@Component({
  selector: 'app-liste-soiree',
  templateUrl: './liste-soiree.component.html',
  styleUrls: ['./liste-soiree.component.scss']
})
export class ListeSoireeComponent implements OnInit, OnDestroy {

  soirees: Soiree[];
  soireeSubscription: Subscription;

  sessionPseudo = sessionStorage.getItem("userConnected");

  constructor(private soireeService: SoireeService,
              private router: Router) { }

  ngOnInit() {
    this.soireeService.getAllSoirees(this.sessionPseudo)

    this.soireeSubscription = this.soireeService.soireeSubject.subscribe(
      (soirees: Soiree[]) => {
        this.soirees = soirees;
      }
    );
    this.soireeService.emitSoiree();

  }

  ngOnDestroy() {
    this.soireeSubscription.unsubscribe();
  }

}
