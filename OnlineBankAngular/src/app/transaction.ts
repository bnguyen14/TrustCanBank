export class Transaction {
    transactionId:Number;
    transactionDate:String;
    transactionType:String;
    transactionAmount:Number;
    accountId:Number;
    constructor(type:String,amount:Number,accountId:Number,date:String){
        this.transactionId=0;
        this.transactionDate = date;
        this.transactionType=type;
        this.transactionAmount=amount;
        this.accountId=accountId;
    }
}
