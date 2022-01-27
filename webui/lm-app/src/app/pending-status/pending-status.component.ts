import { Component, OnInit, ViewChild} from '@angular/core';
import {EmployeeService} from '../employee.service';
//import {Observable} from 'rxjs';
import { Employee} from '../Employee';
import {LeaveDetails} from '../leave-details';
import {Router} from '@angular/router';
import {MatTableDataSource, MatTableModule} from '@angular/material';
import {MatSortModule, MatPaginator, MatSort} from '@angular/material';

@Component({
  selector: 'app-pending-status',
  templateUrl: './pending-status.component.html',
  styleUrls: ['./pending-status.component.css']
})
export class PendingStatusComponent implements OnInit {

  employee : Employee;
  selectedRowIndex: number = -1;
  Pending : LeaveDetails[]=[];
  //leaveStatus : Observable<Employee[]>;
  employeeId : number;
  displayedColumns= ['leaveid','employeeid','startdate','enddate','noofleaves','leavereason','appliedon','leavetype'];
  dataSource = new MatTableDataSource();

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  button: boolean=false;
  //flagp : number;
  model=new LeaveDetails();
  constructor(private us : EmployeeService, private rt : Router) { 
    this.employeeId = parseInt(localStorage.getItem("empId"))   
    //this.flagp = parseInt(localStorage.getItem("empId"));
    //alert(this.flagp);           
  //  this.leaveStatus=es.getPendingStatus(this.employeeId);
  this.us.getEmployees()
  .subscribe(response=>{
    console.log(response);
    this.employee = response.body;
  });
  this.us.getPendingStatus(this.employeeId).subscribe(response=>{
    console.log(response);
    this.Pending = response;

    this.dataSource=new MatTableDataSource(this.Pending); 
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  });

 
  }

  setClickRowDup(id,e) {
    localStorage.setItem("leaveId",id);
    alert(id);
    //this.leavedetails=new LeaveDetails();
    this.model.leaveId=parseInt(localStorage.getItem("leaveId"));
    //alert( this.model.leaveId);
    localStorage.setItem("lEmpId",e);
    alert(e);
    this.button = true;
  }

  highlight(row){
    this.selectedRowIndex = row.id;
}

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  updateStatus() {
    this.rt.navigate(['/updateStatus'])
  }
  ngOnInit() {
  }

}