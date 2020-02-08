import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-search-doctor',
  templateUrl: './search-doctor.component.html',
  styleUrls: ['./search-doctor.component.css']
})
export class SearchDoctorComponent implements OnInit {

  users: User[];
  doctors: Doctor[];
  
  userDet = JSON.parse(localStorage.getItem('userDetails'));

  constructor(private doctorService: DoctorService, private router: Router) { 
  
    this.getDoctorProfile();

  }

  getDoctorProfile() {
   this.doctorService.getDoctorProfile().subscribe(response => {
      console.log(response);
      this.doctors = response.doctor;
      console.log(this.doctors);  
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {

  }

}
