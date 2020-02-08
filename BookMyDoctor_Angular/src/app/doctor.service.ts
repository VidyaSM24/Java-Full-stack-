import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  selectedDoctorToUpdate: Doctor;
  api = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  postData(doctor): Observable<any> {
    return this.http.post<any>(
      `${this.api}/add-doctor`,
      doctor);
  }

  getData(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-doctor`);
  }
  deleteData(doctor: Doctor): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-doctor/${doctor.doctorId}`
    );
  }
  updateDoctor(doctor): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-doctor`, doctor);
  }

  getDoctorProfile(): Observable<any> {
    let userDet = JSON.parse(localStorage.getItem('userDetails'));
    console.log(userDet);
    console.log(userDet.userId);
    return this.http.get<any>(`${this.api}/search-doctor/${userDet.userId}`);
  }
}
