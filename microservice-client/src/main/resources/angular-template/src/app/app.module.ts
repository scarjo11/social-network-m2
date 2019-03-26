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
    ListFriendsComponent
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
