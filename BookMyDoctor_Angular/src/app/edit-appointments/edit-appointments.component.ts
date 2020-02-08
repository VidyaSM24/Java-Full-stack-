import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-appointments',
  templateUrl: './edit-appointments.component.html',
  styleUrls: ['./edit-appointments.component.css']
})
export class EditAppointmentsComponent implements OnInit {
error:string;

  appointmentId1;
  patientId1;
  doctorId1;
  appointmentDate1;
  appointmentTime1;
  appointmentStatus1;
  constructor(private appointmentService: AppointmentService, private router: Router, private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      console.log(data.appointmentId1);
      this.appointmentId1 = data.appointmentId;
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
     // this.appointmentId1 = data.appointmentId;
      this.patientId1 = data.patientId;
      this.doctorId1 = data.doctorId;
      this.appointmentDate1 = data.appointmentDate;
      this.appointmentTime1 = data.appointmentTime;
      this.appointmentStatus1 = data.appointmentStatus;
    });
  }


  ngOnInit() {
  }
  updateAppointment(form: NgForm) {
    this.appointmentService.updateAppointment(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        form.reset();
        this.router.navigateByUrl('/doctor/all-appointments');
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
