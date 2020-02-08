import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  message: string;
  error: string;
  constructor(private patientServive: PatientService) { }

  ngOnInit() {
  }

  addPatient(form: NgForm) {
    this.patientServive.postData(form.value).subscribe(data => {
      console.log(data);
      this.message = data.message;
      setTimeout(() => {
        this.message = null;
      }, 2000);
      form.reset();
    }, err => {
      console.log(err);
      this.error = err.error;
      setTimeout(() => {
        this.error = null;
      }, 2000);
    });

  }

}
