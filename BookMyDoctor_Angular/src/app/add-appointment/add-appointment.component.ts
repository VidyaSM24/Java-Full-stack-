import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AppointmentService } from '../appointment.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-appointment',
  templateUrl: './add-appointment.component.html',
  styleUrls: ['./add-appointment.component.css']
})
export class AddAppointmentComponent implements OnInit {

  message: string;
  error: string;
  patientId1;
  doctorId1;
  today: Date;
  constructor(private appointmentServive: AppointmentService, private router: Router, private activatedRoute: ActivatedRoute) {
    this.today  = new Date();
    console.log(this.today);

    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.doctorId1 = data.doctorId;
      console.log(this.doctorId1);
    });

    let userDet = JSON.parse(localStorage.getItem('userDetails'));
    console.log(userDet.userId);

    this.patientId1 = userDet.userId;
  }

  ngOnInit() {
  }



  addAppointment(form: NgForm) {
    this.appointmentServive.postData({ ...form.value, appointmentStatus: 'pending' }).subscribe(data => {
      console.log(data);
      this.message = data.message;
      setTimeout(() => {
        this.message = null;
      }, 2000);
      form.reset();
      this.router.navigateByUrl('/patient-inner');

    }, err => {
      console.log(err);
      this.error = err.error;
      setTimeout(() => {
        this.error = null;
      }, 2000);
    });

  }

}
