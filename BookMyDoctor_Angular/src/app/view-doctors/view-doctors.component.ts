import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-view-doctors',
  templateUrl: './view-doctors.component.html',
  styleUrls: ['./view-doctors.component.css']
})
export class ViewDoctorsComponent implements OnInit {
  description: string;
  doctors: Doctor[];


  constructor(private doctorService: DoctorService, private router: Router) {
    this.getDoctors();

   }

   getDoctors() {
     this.doctorService.getData().subscribe(response => {
       console.log(response);
       this.doctors = response.doctor;
     }, err => {
       console.log(err);
     });
   }

deleteDoctor(doctor: Doctor) {
    this.doctorService.deleteData(doctor).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.doctors.splice(this.doctors.indexOf(doctor), 1);
        this.description = response.description;
      }
    });
  }
  deleteMessage() {
    this.description = null;
  }

  selectDoctor(doctor) {
    console.log(doctor);
    this.router.navigate([`modify-doctor/${doctor.doctorId}`],
      {
        queryParams: {
          doctorId: doctor.doctorId,
          firstName: doctor.firstName,
          lastName: doctor.lastName,
          doctorEmail: doctor.doctorEmail,
          ratings: doctor.ratings,
          specialization: doctor.specialization,
          clinicName: doctor.clinicName
        }
      }
    );
  }

  ngOnInit() {
  }
}

