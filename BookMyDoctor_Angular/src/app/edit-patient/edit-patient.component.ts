import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html',
  styleUrls: ['./edit-patient.component.css']
})
export class EditPatientComponent implements OnInit {

error:string;

  patientId1;
  patientFirstName1;
  patientLastName1;
  patientEmail1;
  phoneNo1;
  gender1;
  address1;
  healthIssue1;
  constructor(private patientService: PatientService, private router: Router, private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      console.log(data.patientId);
      this.patientId1 = data.patientId;
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
     // this.patientId1 = data.patientId1;
      this.patientFirstName1 = data.patientFirstName;
      this.patientLastName1 = data.patientLastName;
      this.patientEmail1 = data.patientEmail;
      this.phoneNo1 = data.phoneNo;
      this.gender1 = data.gender;
      this.address1 = data.address;
      this.healthIssue1 = data.healthIssue;


    });
  }
  ngOnInit() {
  }
  updatePatient(form: NgForm) {
    this.patientService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        form.reset();
        this.router.navigateByUrl('/all-patients');
      }
    },  err => {
      console.log(err);
      this.error = err.error;
      setTimeout(() => {
        this.error = null;
      }, 2000);
    });
  }
}

