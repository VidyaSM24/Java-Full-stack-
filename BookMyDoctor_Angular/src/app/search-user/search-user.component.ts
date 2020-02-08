import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-search-user',
  templateUrl: './search-user.component.html',
  styleUrls: ['./search-user.component.css']
})
export class SearchUserComponent implements OnInit {

  users: User[];
  patientId1; 
  patients: Patient[];
  
  userDet = JSON.parse(localStorage.getItem('userDetails'));

  constructor(private patientService: PatientService, private router: Router) { 
  
    this.getPatientProfile();

  }

  getPatientProfile() {
   this.patientService.getPatientProfile().subscribe(response => {
      console.log(response);
      this.patients = response.patient;
      console.log(this.patients);  
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {

  }

  
  }

