import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MailService {

  selectedMailToUpdate: Mail;
  api = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  addMail(mails): Observable<any> {
    return this.http.post<any>(`${this.api}/add-mail`,mails);
  }

  getData(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-mails`);
  }
  deleteData(mail: Mail): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-mail/${mail.emailId}`
    );
  }
}
