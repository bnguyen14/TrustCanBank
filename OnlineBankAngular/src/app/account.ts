export class Account {
    accountId:Number;
    accountType:String;
    accountBalance:Number;
    userId:Number;
    constructor(accountType:String,userId:Number){
        this.accountId=0;
        this.accountType=accountType;
        this.userId=userId;
        this.accountBalance=0;
    }
}
