import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import {LeaveDetails} from '../leave-details';
import { NgForm } from "@angular/forms";
import {Router} from '@angular/router';

@Component({
  selector: 'app-applyleave',
  templateUrl: './applyleave.component.html',
  styleUrls: ['./applyleave.component.css']
})
export class ApplyLeaveComponent implements OnInit {

  status : {
      msg: String;
  };

  empId : number; 
  elb : number;
  plb : number;
  slb : number;
  olb : number; 
  employees: Employee;
  message:string;
  
  leavedetails:LeaveDetails;
  model=new LeaveDetails();
  isValidFormSubmitted = false;
  constructor(public applyLeaveService:EmployeeService, private rt : Router) {
    this.leavedetails=new LeaveDetails();
    this.empId=parseInt(localStorage.getItem("empId"));
    this.elb=parseInt(localStorage.getItem("elb"));
    this.plb=parseInt(localStorage.getItem("plb"));
    this.slb=parseInt(localStorage.getItem("slb"));
    this.olb=parseInt(localStorage.getItem("olb"));
   }

   applyLeave(form: NgForm)
   {
       this.isValidFormSubmitted=false;
       if(form.invalid){
      //     alert("Invalid");
        return; 
     }  
       console.log ('end date component' + this.model.endDate); 

       this.applyLeaveService.update(this.empId,this.elb,this.plb,this.slb,this.olb,this.model).subscribe(
           dd => {
               this.status=dd;
               console.log(this.status.msg + " " + dd );
               alert(this.status.msg);
           },
           errorMsg => { 
               this.status.msg=errorMsg;
               alert("Error " +this.status.msg);
               console.log("Error " +this.status.msg);
           })
      
       this.isValidFormSubmitted = true;
   }
   cancel() {
    this.rt.navigate(['/dashboard'])
   }

  ngOnInit() {
  }
}