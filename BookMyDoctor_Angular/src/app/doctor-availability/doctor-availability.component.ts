import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-doctor-availability',
  templateUrl: './doctor-availability.component.html',
  styleUrls: ['./doctor-availability.component.css']
})
export class DoctorAvailabilityComponent implements OnInit {

  description: string;
  patients: Patient[];


  constructor(private patientService: PatientService, private router: Router) {
    this.getPatients();

   }
   ngOnInit() {
  }

   getPatients() {
     this.patientService.getData().subscribe(response => {
       console.log(response);
       this.patients = response.patient;
     }, err => {
       console.log(err);
     });
   }
  }
