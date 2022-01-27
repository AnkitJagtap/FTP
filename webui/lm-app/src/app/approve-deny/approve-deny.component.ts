import { Component, OnInit } from '@angular/core';
import { NgForm } from "@angular/forms";
import { EmployeeService } from '../employee.service';
import {LeaveDetails} from '../leave-details';
import { Employee } from '../employee';
import {Router} from '@angular/router';
import { leave } from '@angular/core/src/profile/wtf_impl';

@Component({
  selector: 'app-approve-deny',
  templateUrl: './approve-deny.component.html',
  styleUrls: ['./approve-deny.component.css']
})
export class ApproveDenyComponent implements OnInit {
  status : {
    msg: String;
  };
  empId : number;
  employee : Employee;
  //leaveDetail : LeaveDetails; 
  res : number; 
  leaveId : number;
  leavedetails:LeaveDetails;
  model=new LeaveDetails();
  isValidFormSubmitted = false;
  constructor(public updateLeaveService:EmployeeService, private rt : Router) {
    this.model.leaveId=parseInt(localStorage.getItem("leaveId"));
    this.leavedetails=new LeaveDetails();
    this.empId=parseInt(localStorage.getItem("lEmpId"));
    //alert(this.empId);
    //this.model.leaveId=parseInt(localStorage.getItem("leaveId"));
    //this.empNo=parseInt(localStorage.getItem("empId"));
    this.updateLeaveService.getEmployee(this.empId)
    .subscribe(response=>{
      console.log(response);
      this.employee = response.body;
    });
    //this.leaveDetail=updateLeaveService.getLeaveDetailsById(this.empId,this.model.leaveId);
    this.updateLeaveService.getLeaveDetailsById(this.empId,this.model.leaveId).subscribe(response=>{
      console.log(response);
      this.leavedetails = response.body;
    });
    //alert(this.model.leaveId);
  }

   updateLeave(form: NgForm)
   {
       this.isValidFormSubmitted=false;
       if(form.invalid){
        return; 
     }
  }
  
  approve() {
    this.res=1;
    alert(this.res);
    this.model.leaveId=parseInt(localStorage.getItem("leaveId"));
    alert( this.model.leaveId);
    this.empId=parseInt(localStorage.getItem("lEmpId"));
    alert( this.empId);
    this.updateLeaveService.updateStatus(this.empId,this.res,this.model).subscribe(
      dd => {
          this.status=dd;
          console.log(this.status.msg + "  " + dd );
          alert(this.status.msg);
      },
      errorMsg => { 
          this.status.msg=errorMsg;
          console.log("Error " +this.status.msg);
          alert("Error " +this.status.msg);
      })
 
   this.isValidFormSubmitted = true;
   }
   deny() {
     this.res=2;
     alert(this.res);
     this.model.leaveId=parseInt(localStorage.getItem("leaveId"));
     alert( this.model.leaveId);
     this.empId=parseInt(localStorage.getItem("lEmpId"));
     alert( this.empId);
     this.updateLeaveService.updateStatus(this.empId,this.res,this.model).subscribe(
      dd => {
        this.status=dd;
        console.log(this.status.msg + "  " + dd );
        alert(this.status.msg);
      },
      errorMsg => { 
        this.status.msg=errorMsg;
          console.log("Error " +this.status.msg);
          alert("Error " +this.status.msg);
      }
  )
 
  this.isValidFormSubmitted = true;
  }
  
  cancel() {
    this.rt.navigate(['/dashboard'])
   }

  ngOnInit() {
}

}