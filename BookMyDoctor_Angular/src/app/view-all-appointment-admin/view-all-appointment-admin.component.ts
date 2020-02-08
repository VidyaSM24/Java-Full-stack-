import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-all-appointment-admin',
  templateUrl: './view-all-appointment-admin.component.html',
  styleUrls: ['./view-all-appointment-admin.component.css']
})
export class ViewAllAppointmentAdminComponent implements OnInit {

  description: string;
  appointments: Appointment[];


  constructor(private appointmentService: AppointmentService, private router: Router) {
    this.getAppointmentsAdmin();

   }

   getAppointmentsAdmin() {
     this.appointmentService.getAppointmentsAdmin().subscribe(response => {
       console.log(response);
       this.appointments = response.appointment;
     }, err => {
       console.log(err);
     });
   }
deleteAppointment(appointment: Appointment) {
    this.appointmentService.deleteData(appointment).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.appointments.splice(this.appointments.indexOf(appointment), 1);
        this.description = response.description;
      }
    });
  }
  deleteMessage() {
    this.description = null;
  }

  selectAppointment(appointment) {
    console.log(appointment);
    this.router.navigate([`update-appointment-admin/${appointment.appointmentId}`],
      {
        queryParams: {
          appointmentId: appointment.appointmentId,
          patientId: appointment.patientId,
          doctorId: appointment.doctorId,
          appointmentDate: appointment.appointmentDate,
          appointmentTime: appointment.appointmentTime,
          appointmentStatus: appointment.appointmentStatus
        }
      }
    );
  }
  ngOnInit() {
  }}
