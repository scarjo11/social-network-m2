import {HttpClient} from "@angular/common/http";
import {DatePipe} from "@angular/common";
import {EventPrivate} from "../models/eventPrivate.model";
import {Subject} from "rxjs";
import {EventOpenData} from "../models/eventOpenData.model";
import {Soiree} from "../models/soiree.model";
import {Injectable} from "@angular/core";
import {map} from "rxjs/operators";

@Injectable()
export class SoireeService {

  constructor(private httpClient: HttpClient) {
  }


  soirees: Soiree[] = [];
  singleSoiree: Soiree;
  soireeSubject = new Subject<Soiree[]>();

  sessionPseudo = sessionStorage.getItem("userConnected");
  idSoiree = '';

  emitSoiree() {
    this.soireeSubject.next(this.soirees.slice());
  }

  addSoiree(soiree: Soiree) {
    this.soirees.push(soiree);
    this.emitSoiree();

  }

  createSoiree(soiree: Soiree){

    let url = "http://localhost:8095/soiree";

    this.httpClient.post<any>(url, soiree).subscribe(
      res => {
        sessionStorage.removeItem(this.idSoiree);
        sessionStorage.setItem(this.idSoiree, res);
      },
      err => {
        console.log('ERROR Soiree !');
      }
    );
  }

ajouterEventPriveASoiree(idSoiree: number, idEventPrivate: number){

  let url = "http://localhost:8095/soiree/"+idSoiree+"/eventPrivate/"+idEventPrivate;

  this.httpClient.put<any>(url, idSoiree).subscribe(
        () => {
          console.log('Evenement privé ajouté a la soirée !');
        },
        (error) => {
          console.log('Erreur dajout evenement privee ! ') + error;
        }
      );

  }

  getAllSoirees(pseudoUser: string){
    let url = "http://localhost:8095/soirees/" + pseudoUser;

    this.httpClient.get<any[]>(url).subscribe(
      res => {
        this.soirees = res;
        this.emitSoiree();
      },
      err => {
        alert('ERROR affichage soiree !');
      }
    );
  }

  getSoiree(id: number){

    let promise = new Promise((resolve, reject) => {
      let url = "http://localhost:8095/soiree/" + id;
      this.httpClient.get(url)
        .toPromise()
        .then(
          res => { // Success
            console.log("nouveau", res);
            //this.singleSoiree = res;
            resolve(res);

          },
          msg => { // Error
            reject(msg);
          }
        );
    });
    return promise;
  }

  notifSoireeToFriends(id: number){
    let url = "http://localhost:8095/soiree/"+id+"/notification/"+this.sessionPseudo;

    this.httpClient.post<any>(url, id).subscribe(
      res => {
        console.log('Notif soiree envoyée !')
      },
      err => {
        console.log('ERROR Notif soirée !');
      }
    );
  }

  getNotifSoiree(idSoiree: number){
    let url = "http://localhost:8095/soiree/notif/" + idSoiree;

    this.httpClient.get<any[]>(url).subscribe(
      res => {
        this.soirees = res;
        this.emitSoiree();
      },
      err => {
        alert('ERROR affichage soiree !');
      }
    );
  }

}
