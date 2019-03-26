import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { InscriptionComponent } from './auth/inscription/inscription.component';
import { LoginComponent } from './auth/login/login.component';
import { HeaderComponent } from './header/header.component';
import {AuthService} from "./services/auth.service";
import {AuthGuardService} from "./services/auth-guard.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import { EventListComponent } from './event-list/event-list.component';
import { ListUsersComponent } from './social-network/list-users/list-users.component';
import { ListFriendsComponent } from './social-network/list-friends/list-friends.component';
import { CreateOpenDataEventComponent } from './evenements/create-open-data-event/create-open-data-event.component';
import { CreateEventPrivateComponent } from './evenements/create-event-private/create-event-private.component';
import { CreateSoireeComponent } from './soiree/create-soiree/create-soiree.component';
import { ListeParticipantSoireeComponent } from './soiree/liste-participant-soiree/liste-participant-soiree.component';
import { AjouterParticipantSoireeComponent } from './soiree/ajouter-participant-soiree/ajouter-participant-soiree.component';
import { SingleSoireeComponent } from './soiree/single-soiree/single-soiree.component';
import { AjouterEventPriveSoireeComponent } from './soiree/ajouter-event-prive-soiree/ajouter-event-prive-soiree.component';
import { AjouterEventOpendataSoireeComponent } from './soiree/ajouter-event-opendata-soiree/ajouter-event-opendata-soiree.component';
import { EnvoyerNotificationComponent } from './notification/envoyer-notification/envoyer-notification.component';
import { RecupererNotificationParPseudoComponent } from './notification/recuperer-notification-par-pseudo/recuperer-notification-par-pseudo.component';
import { ListeEvenementPublicComponent } from './evenements/liste-evenement-public/liste-evenement-public.component';
import { ListeEvenementPriveeComponent } from './evenements/liste-evenement-privee/liste-evenement-privee.component';

const appRoutes: Routes = [
  {path: 'auth/inscription', component: InscriptionComponent},
  {path: 'auth/login', component: LoginComponent},
  {path: 'event', component: EventListComponent},
];


@NgModule({
  declarations: [
    AppComponent,
    InscriptionComponent,
    LoginComponent,
    HeaderComponent,
    EventListComponent,
    ListUsersComponent,
    ListFriendsComponent,
    CreateOpenDataEventComponent,
    CreateEventPrivateComponent,
    CreateSoireeComponent,
    ListeParticipantSoireeComponent,
    AjouterParticipantSoireeComponent,
    SingleSoireeComponent,
    AjouterEventPriveSoireeComponent,
    AjouterEventOpendataSoireeComponent,
    EnvoyerNotificationComponent,
    RecupererNotificationParPseudoComponent,
    ListeEvenementPublicComponent,
    ListeEvenementPriveeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)

  ],
  providers: [
    AuthService,
    AuthGuardService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
