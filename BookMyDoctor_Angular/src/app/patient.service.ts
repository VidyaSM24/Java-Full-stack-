import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  selectedPatientToUpdate: Patient;
  api = 'http://localhost:8080';
  

  constructor(private http: HttpClient) { }

  postData(patient): Observable<any> {
    return this.http.post<any>(
      `${this.api}/add-patient`,
      patient);
  }

  getData(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-patient`);
  }

  getPatientProfile(): Observable<any> {
    let userDet = JSON.parse(localStorage.getItem('userDetails'));
    
    console.log(userDet);
    console.log(userDet.userId);
    return this.http.get<any>(`${this.api}/search-patient/${userDet.userId}`);
  }

  deleteData(patient: Patient): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-patient/${patient.patientId}`
    );
  }
  updateData(patient): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-patient`, patient);
  }
}
