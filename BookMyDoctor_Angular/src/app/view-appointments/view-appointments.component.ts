import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-appointments',
  templateUrl: './view-appointments.component.html',
  styleUrls: ['./view-appointments.component.css']
})
export class ViewAppointmentsComponent implements OnInit {

  description: string;
  appointments: Appointment[];


  constructor(private appointmentService: AppointmentService, private router: Router) {
    this.getAppointments();

   }

   getAppointments() {
     this.appointmentService.getData().subscribe(response => {
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
    this.router.navigate([`modify-appointment/${appointment.appointmentId}`],
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
  }
}

