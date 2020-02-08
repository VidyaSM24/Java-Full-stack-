import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HistoryService {
  
  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

 

  getAllHistory(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-all-history`);
  }

  deleteHistory(history: Histories) {
    return this.http.delete<any>(`${this.url}/delete-history/${history.historyId}`);
  }

  
}
