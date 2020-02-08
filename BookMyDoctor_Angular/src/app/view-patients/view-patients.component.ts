import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-patients',
  templateUrl: './view-patients.component.html',
  styleUrls: ['./view-patients.component.css']
})
export class ViewPatientsComponent implements OnInit {

  description: string;
  patients: Patient[];


  constructor(private patientService: PatientService, private router: Router) {
    this.getPatients();

   }

   getPatients() {
     this.patientService.getData().subscribe(response => {
       console.log(response);
       this.patients = response.patient;
     }, err => {
       console.log(err);
     });
   }
deletePatient(patient: Patient) {
    this.patientService.deleteData(patient).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.patients.splice(this.patients.indexOf(patient), 1);
        this.description = response.description;
      }
    });
  }
  deleteMessage() {
    this.description = null;
  }

  selectPatient(patient) {
    console.log(patient);
    this.router.navigate([`modify-patient/${patient.patientId}`],
      {
        queryParams: {
          patientId: patient.patientId,
          patientFirstName: patient.patientFirstName,
          patientLastName: patient.patientLastName,
          patientEmail: patient.patientEmail,
          phoneNo:patient.phoneNo,
          gender: patient.gender,
          address: patient.address,
          healthIssue: patient.healthIssue
        }
      }
    );
  }
  ngOnInit() {
  }
}

