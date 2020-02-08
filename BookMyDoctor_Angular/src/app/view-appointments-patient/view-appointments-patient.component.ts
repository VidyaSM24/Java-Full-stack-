import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-appointments-patient',
  templateUrl: './view-appointments-patient.component.html',
  styleUrls: ['./view-appointments-patient.component.css']
})
export class ViewAppointmentsPatientComponent implements OnInit {

  description: string;
  appointments: Appointment[];


  constructor(private appointmentService: AppointmentService, private router: Router) {
    this.getAppointmentsPatient();

   }

   getAppointmentsPatient() {
     this.appointmentService.getAppointmentsPatient().subscribe(response => {
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

  
  ngOnInit() {
  }

}
