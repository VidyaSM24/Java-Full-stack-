import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-patient-account',
  templateUrl: './update-patient-account.component.html',
  styleUrls: ['./update-patient-account.component.css']
})
export class UpdatePatientAccountComponent implements OnInit {
message:string;
  error:string;

  patientId1;
  patientEmail1;

  constructor(private router: Router,
            private service: PatientService) {
  
              let patientDet =JSON.parse(localStorage.getItem('userDetails'));
    console.log(patientDet.userId);
    this.patientId1 = patientDet.userId;
    // console.log(this.doctorId1);
    this.patientEmail1=patientDet.userEmail;
   }

  ngOnInit() {
  }
  updatePatient(form: NgForm) {
    this.service.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        form.reset();
       // this.router.navigateByUrl('/all-patients');
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
