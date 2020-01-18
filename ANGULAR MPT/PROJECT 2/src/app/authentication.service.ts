import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

    url = `https://localhost:8080`;
  
    constructor(public http: HttpClient) { }
  
    addPost(postDetails): Observable<any> {
      return this.http.post<any>(`${this.url}/addpost`, postDetails);
    }
    displayPost(postDetails): Observable<any> {
      return this.http.get<any>(`${this.url}/displaypost`, postDetails);
    }
    deletePost(postDetails):Observable<any>{
      return this.http.delete<any>(`${this.url}/deletepost`,postDetails)
    }
}
