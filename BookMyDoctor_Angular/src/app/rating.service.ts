import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  selectedRatingToUpdate: Rating;
  api = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  postData(rating): Observable<any> {
    return this.http.post<any>(
      `${this.api}/add-ratings`,
      rating);
  }

  getData(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-ratings`);
  }
  deleteData(rating: Rating): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-ratings/${rating.ratingId}`
    );
  }
  updateData(rating): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-ratings`, rating);
  }
}
