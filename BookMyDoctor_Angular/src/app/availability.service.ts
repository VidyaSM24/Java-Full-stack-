import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AvailabilityService {

  selectedAvailabilityToUpdate: Availability;
  api = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  postData(availability): Observable<any> {
    return this.http.post<any>(
      `${this.api}/add-availability`,
      availability);
  }

  getData(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-availability`);
  }
  deleteData(availability: Availability): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-availability/${availability.availabilityId}`
    );
  }
  updateData(availability): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-availability`, availability);
  }
}

