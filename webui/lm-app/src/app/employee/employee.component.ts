import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../employee.service';
import { Observable, throwError } from 'rxjs';
import {Employee} from '../Employee';
import {Router} from '@angular/router';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {


  details:Employee;
  constructor(private us : EmployeeService,
              private rt : Router) {
                this.us.getEmployees()
                .subscribe(response=>{
                  console.log(response);
                  this.details = response.body;
                });
   }

   login(empId,mgrid,elb,plb,slb,olb) {
     localStorage.setItem("empId",empId);
     localStorage.setItem("mgrId",mgrid);
     localStorage.setItem("elb",elb);
     localStorage.setItem("plb",plb);
     localStorage.setItem("slb",slb);
     localStorage.setItem("olb",olb);
     this.rt.navigate(['/login']);
   }

  ngOnInit() {
  }

}
