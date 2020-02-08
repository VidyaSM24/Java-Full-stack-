import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-doctors-patient',
  templateUrl: './doctors-patient.component.html',
  styleUrls: ['./doctors-patient.component.css']
})
export class DoctorsPatientComponent implements OnInit {

  doctors: Doctor[];
  // search: string;

  constructor(private doctorService: DoctorService, private router: Router) {
    this.getDoctors();
   }

   getDoctors() {
     this.doctorService.getData().subscribe(response => {
      //  console.log(response);
       this.doctors = response.doctor;
       console.log(this.doctors);
     }, err => {
       console.log(err);
     });
   }

   searchData(search) {
     console.log(search);
   }

  ngOnInit() {
  }

  addRatings(doctor) {
    this.router.navigate([`add-rating`],
    { queryParams: {
      doctorId: doctor.doctorId
    }});
  }

  bookAppointment(doctor){
    this.router.navigate([`add-appointment`],
    { queryParams: {
      doctorId: doctor.doctorId
    }});
  }

}
