import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  selectedAppointmentToUpdate: Appointment;
  api = 'http://localhost:8080';
  userId;

  constructor(private http: HttpClient) {
    let doctorDet =JSON.parse(localStorage.getItem('userDetails'));
    console.log(doctorDet.userId);
    this.userId = doctorDet.userId;
    console.log(this.userId)
   }

  postData(appointment): Observable<any> {
    return this.http.post<any>(
      `${this.api}/add-appointment`,
      appointment);
  }

  getAppointmentsAdmin(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-appointment`);
  }

  getAppointmentsPatient(): Observable<any> {
    console.log(this.userId);
    return this.http.get<any>(`${this.api}/get-all-appointment-patient/${this.userId}`);
  }

  getData(): Observable<any> {
    
    return this.http.get<any>(`${this.api}/get-all-appointment-doctor/${this.userId}`);
  }
  deleteData(appointment: Appointment): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-appointment/${appointment.appointmentId}`
    );
  }
  updateAppointment(appointment): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-appointment`, appointment);
  }

  
}
