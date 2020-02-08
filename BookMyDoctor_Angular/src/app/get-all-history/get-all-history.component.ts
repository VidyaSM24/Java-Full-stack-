import { Component, OnInit } from '@angular/core';
import { HistoryService } from '../history.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-history',
  templateUrl: './get-all-history.component.html',
  styleUrls: ['./get-all-history.component.css']
})
export class GetAllHistoryComponent implements OnInit {

  success: string;
  failure: string;
  historyDetail: Histories[];

  constructor(private historyDetails: HistoryService,
              private router: Router) {
              this.getAllHistory();
  }


  ngOnInit() {
  }

  getAllHistory() {
    this.historyDetails.getAllHistory().subscribe(response =>{
      console.log(response);
      if(response.statusCode === 201) {
        this.historyDetail = response.history;
        this.success = response.description;
        localStorage.setItem('History Details', JSON.stringify(response));
        setTimeout(() => {
          this.success = null;
        }, 2000);
      } else {
        this.failure = response.description;
        localStorage.setItem('history Details', JSON.stringify(response));
        setTimeout(() => {
          this.failure = null;
        }, 3000);
      }
    })
  }

  deleteHistory(histories: Histories) {
    this.historyDetails.deleteHistory(histories).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.historyDetail.splice(this.historyDetail.indexOf(histories), 1);
        this.success = data.message;
        setTimeout(() => {
          this.success = null;
        }, 2000);
      }
    })
  }

}
