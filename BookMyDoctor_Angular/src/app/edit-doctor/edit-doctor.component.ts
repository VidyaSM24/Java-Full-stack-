import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DoctorService } from '../doctor.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-doctor',
  templateUrl: './edit-doctor.component.html',
  styleUrls: ['./edit-doctor.component.css']
})
export class EditDoctorComponent implements OnInit {

error:string;

  doctorId1;
  firstName1;
  lastName1;
  doctorEmail1;
  ratings1;
  specialization1;
  clinicName1;

  constructor(private doctorService: DoctorService, private router: Router, private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      console.log(data.doctorEmail1);
      this.doctorId1 = data.doctorId;
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      // this.doctorId1 = data.doctorId;
      this.firstName1 = data.firstName;
      this.lastName1 = data.lastName;
      this.doctorEmail1 = data.doctorEmail;
      this.ratings1 = data.ratings;
      this.specialization1 = data.specialization;
      this.clinicName1 = data.clinicName;


    });
  }

  ngOnInit() {
  }
  updateDoctor(form: NgForm) {
    this.doctorService.updateDoctor(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        form.reset();
        this.router.navigateByUrl('/admin/all-doctors');
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


