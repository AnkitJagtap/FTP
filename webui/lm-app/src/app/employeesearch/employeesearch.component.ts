import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../employee.service';
import {Observable} from 'rxjs';
import {Employee} from '../Employee';

@Component({
  selector: 'app-employeesearch',
  templateUrl: './employeesearch.component.html',
  styleUrls: ['./employeesearch.component.css']
})
export class EmployeesearchComponent implements OnInit {

  employee:Employee;
  eno : number;
  constructor(private em : EmployeeService) { 
  this.eno = parseInt(localStorage.getItem("empId"))           
  //this.eno=1000;
 // this.Employee=em.getEmployeeSearch(this.eno);
 this.em.getEmployee(this.eno)
 .subscribe(response=>{
   console.log(response);
   this.employee = response.body;
 });
  }


  ngOnInit() {
  }

}
