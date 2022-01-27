import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../employee.service';
import {Observable} from 'rxjs';
import {Employee} from '../Employee';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  private manager:Employee;
  mgrid : number;
  constructor(private ma : EmployeeService) { 
  this.mgrid = parseInt(localStorage.getItem("mgrId"))              
 // this.mgr=ma.getEmployeeSearch(this.mgrid);
 if(this.mgrid!=0) {
  this.ma.getEmployee(this.mgrid)
  .subscribe(response=>{
    console.log(response);
    this.manager = response.body;
    });
  } else {
    this.manager =null;
  }
}

  ngOnInit() {
  }

}
