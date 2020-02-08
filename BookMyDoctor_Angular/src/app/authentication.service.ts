import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  registerUser(userDetails): Observable<any> {
     return this.http.post<any>(`${this.url}/add-user`, userDetails);
   }

   loginUser(userCredentials): Observable<any> {
    return this.http.post<any>(`${this.url}/login-user`,userCredentials);
  }
  updateUser(userCredentials): Observable<any> {
    return this.http.put<any>(`${this.url}/modify-user`,userCredentials);
  }
  getData(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-all-user`);
  }
  deleteUser(user: User): Observable<any>{
    return this.http.delete<any>(`${this.url}/delete-user/${user.userEmail}`);
  }

  
}
