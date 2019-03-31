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
import { DashboardComponent } from './social-network/dashboard/dashboard.component';
import { AuthentificationComponent } from './auth/authentification/authentification.component';
import {UserService} from "./services/user.service";
import {FollowService} from "./services/follow.service";
import { SingleUserComponent } from './social-network/single-user/single-user.component';

const appRoutes: Routes = [
  {path: 'auth', component: AuthentificationComponent},
  {path: 'auth/inscription', component: InscriptionComponent},
  {path: 'auth/login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'get-notification', component: RecupererNotificationParPseudoComponent},

  {path: 'users', component: ListUsersComponent},
  {path: 'users/:pseudo', component: SingleUserComponent},

  {path: 'event-public', component: ListeEvenementPublicComponent},
  {path: 'create-event-public', component: CreateOpenDataEventComponent},
  {path: 'event-private', component: ListeEvenementPriveeComponent},
  {path: 'create-event-private', component: CreateEventPrivateComponent},

  {path: 'create-soiree', component: CreateSoireeComponent},
  {path: 'list-participant-soiree', component: ListeParticipantSoireeComponent},
  {path: 'soiree/:id', component: SingleSoireeComponent},

  {path: '', component: AuthentificationComponent},
];


@NgModule({
  declarations: [
    AppComponent,
    InscriptionComponent,
    LoginComponent,
    HeaderComponent,
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
    ListeEvenementPriveeComponent,
    DashboardComponent,
    AuthentificationComponent,
    SingleUserComponent,
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
    AuthGuardService,
    UserService,
    FollowService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
