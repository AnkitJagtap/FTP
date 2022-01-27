import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import {EmployeeService} from '../employee.service';
import {Observable} from 'rxjs';
import { Employee} from '../Employee';
import {LeaveDetails} from '../leave-details'; 
import {MatTableDataSource, MatTableModule} from '@angular/material';
import {Router} from '@angular/router';
import {MatSortModule, MatPaginator, MatSort} from '@angular/material';


@Component({
  selector: 'app-leave-history',
  templateUrl: './leave-history.component.html',
  styleUrls: ['./leave-history.component.css']
})
export class LeaveHistoryComponent implements OnInit {

  employee : Employee;
  leaveHistory : LeaveDetails[] =[];
  employeeId : number;
  displayedColumns= ['leaveId','employee','startdate','enddate','noofleaves','leavereason','appliedon','approvedon','leavetype','leavestatus','managercomments'];
  dataSource = new MatTableDataSource();

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private es : EmployeeService, private rt : Router) { 
    this.employeeId = parseInt(localStorage.getItem("empId"))              
    //this.leaveHistory=es.getLeaveHistory(this.employeeId);

    this.es.getEmployees()
    .subscribe(response=>{
      console.log(response);
      this.employee = response.body;
    });
    this.es.getLeaveHistory(this.employeeId).subscribe(response=>{ 
     
      console.log("From Component " +response);
      this.leaveHistory = response;
      
      
      this.dataSource=new MatTableDataSource(this.leaveHistory); 
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;

      //alert(this.dataSource.data.length);
      
    });
    
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
 

  applyleave() {
    this.rt.navigate(['/applyleave'])
  }


  ngOnInit() {

    
  }

} 