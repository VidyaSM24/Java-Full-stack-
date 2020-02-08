import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorService } from '../doctor.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-doctor-account',
  templateUrl: './update-doctor-account.component.html',
  styleUrls: ['./update-doctor-account.component.css']
})
export class UpdateDoctorAccountComponent implements OnInit {
message:string
  error:string;
  doctorId1;
  doctorEmail1;

  constructor(private router: Router,
            private service: DoctorService) {
  
              let doctorDet =JSON.parse(localStorage.getItem('userDetails'));
    console.log(doctorDet.userId);
    this.doctorId1 = doctorDet.userId;
    // console.log(this.doctorId1);
    this.doctorEmail1=doctorDet.userEmail;
   }

  ngOnInit() {
  }

  updateDoctor(form: NgForm) {
    this.service.updateDoctor(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        form.reset();
       // this.router.navigateByUrl('/all-patients');
      }
    }, err => {
      console.log(err);
      this.error = err.error;
      setTimeout(() => {
        this.error = null;
      }, 2000);
    });
  }
}


