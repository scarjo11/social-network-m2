import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {SoireeService} from "../../services/soiree.service";
import {Router} from "@angular/router";
import {EventPrivate} from "../../models/eventPrivate.model";
import {Soiree} from "../../models/soiree.model";

@Component({
  selector: 'app-create-soiree',
  templateUrl: './create-soiree.component.html',
  styleUrls: ['./create-soiree.component.scss']
})
export class CreateSoireeComponent implements OnInit {

  soireeForm: FormGroup;
  sessionPseudo = sessionStorage.getItem("userConnected");

  constructor(private formBuilder: FormBuilder,
              private soireeService: SoireeService,
              private router: Router) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.soireeForm = this.formBuilder.group( {
      nom: ['', Validators.required],
      pseudo: [this.sessionPseudo, Validators.required]
    });
  }

  onSubmitForm() {
    const formValue = this.soireeForm.value;
    const newSoiree = new Soiree(
      formValue['nom'],
      formValue['pseudo'],
      /*formValue[''],
      formValue['']*/
    );
    this.soireeService.createSoiree(newSoiree);
    console.log(newSoiree);
    this.soireeService.addSoiree(newSoiree);
    this.router.navigate(['/event-public']);
  }

}
