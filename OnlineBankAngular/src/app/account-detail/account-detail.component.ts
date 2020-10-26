import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { Transaction } from '../transaction';

@Component({
  selector: 'app-account-detail',
  templateUrl: './account-detail.component.html',
  styleUrls: ['./account-detail.component.css']
})
export class AccountDetailComponent implements OnInit {
  transactions:Transaction[];
  displayedColumns = ['transactionType','transactionDate','transactionAmount'];
  constructor(public UserService:UserService, private Router: Router) { }

  ngOnInit(): void {
    this.UserService.getTransactions(history.state.id).subscribe(
      (response)=>{
        this.transactions=response.body
      }
    )
  }

}
