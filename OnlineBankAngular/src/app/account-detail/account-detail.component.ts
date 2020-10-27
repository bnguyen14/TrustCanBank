import { Component, OnInit, ViewChild } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { Transaction } from '../transaction';
import { MatAccordion } from '@angular/material/expansion';
import { FormControl, FormGroup } from '@angular/forms';
import { DatePipe } from '@angular/common';
import {formatDate} from '@angular/common';
@Component({
  selector: 'app-account-detail',
  templateUrl: './account-detail.component.html',
  styleUrls: ['./account-detail.component.css']
})
export class AccountDetailComponent implements OnInit {
  transactions:Transaction[];
  displayedColumns = ['transactionDate','transactionType','transactionAmount'];
  @ViewChild(MatAccordion) accordion: MatAccordion;
  transactionForm : FormGroup;
  amount : FormControl;
  type : FormControl;
  constructor(public UserService:UserService, private Router: Router, ) { }

  ngOnInit(): void {
    this.amount = new FormControl('');
    this.type = new FormControl('');
    this.transactionForm = new FormGroup({
      amount : this.amount,
      type : this.type
    });
    this.UserService.getTransactions(history.state.id).subscribe(
      (response)=>{
        this.transactions=response.body;
      }
    )
  }

  goBack(){
    this.Router.navigate(['/Home']);
  }

  addTransaction(){
    var realAmount;
    if(this.transactionForm.value.type=="Withdraw"){
      realAmount = 0-this.transactionForm.value.amount;
    }else{
      realAmount = this.transactionForm.value.amount;
    }
    const tmpTransaction = new Transaction(
      this.transactionForm.value.type,
      realAmount,
      history.state.id,
      formatDate(new Date(),'yyyy/MM/dd','en')
    );
    console.log(tmpTransaction);
    this.UserService.addTransaction(tmpTransaction).subscribe(
      (response) => {
        this.UserService.changeBalance(tmpTransaction).subscribe(
          (response) => {
            this.UserService.getTransactions(history.state.id).subscribe(
              (response)=>{
                this.transactions=response.body;
              }
            )
          }
        )
      }
    )
  }
}
