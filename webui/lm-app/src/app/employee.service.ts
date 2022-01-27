import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import {Employee} from './Employee'
import { Observable, throwError } from 'rxjs';

import {LeaveDetails} from './leave-details'




@Injectable()
export class EmployeeService {

  constructor(private http: HttpClient ) {

   }

   getEmployee(empId):Observable<HttpResponse<Employee>> {
    console.log('getEmployees called on employee.service');
    return this.http.get<Employee>('http://localhost:8080/ftp71-0.0.1-SNAPSHOT/api/employees/'+empId,{observe:'response'});
  }

   getEmployees():Observable<HttpResponse<Employee>> {
    console.log('getEmployees called on employee.service');
    return this.http.get<Employee>('http://localhost:8080/ftp71-0.0.1-SNAPSHOT/api/employees',{observe:'response'});
  }

  getLeaveDetailsById(empId,leaveId):Observable<HttpResponse<LeaveDetails>> {
    console.log('getEmployees called on employee.service');
    return this.http.get<LeaveDetails>('http://localhost:8080/ftp71-0.0.1-SNAPSHOT/api/leaveDetails/'+empId+"/"+leaveId,{observe:'response'});
  }

  getPendingStatus(empId):Observable<LeaveDetails[]>{
    
    console.log('getLeaveDetails called on LeaveDetails.service');
    
    return this.http.get<LeaveDetails[]>('http://localhost:8080/ftp71-0.0.1-SNAPSHOT/api/leaveDetails/pendingStatus/'+empId);
    
    }
  getLeaveHistory(empId):Observable<LeaveDetails[]>{
    
    console.log('getLeaveDetails called on LeaveDetails.service');
    
    return this.http.get<LeaveDetails[]>('http://localhost:8080/ftp71-0.0.1-SNAPSHOT/api/leaveDetails/leaveHistory/'+empId);
    
    }

  update(empid,elb,plb,slb,olb,value):Observable<any>{
      console.log('Inside the service method ....');
      console.log(value);
      let msg : any;
      msg= this.http.post<LeaveDetails>("http://localhost:8080/ftp71-0.0.1-SNAPSHOT/api/leaveDetails/applyleave/"+empid+"/"+elb+"/"+plb+"/"+slb+"/"+olb,value)
      return msg;
    }

  updateStatus(empid,response,value):Observable<any>{
    console.log('Inside the service method ....');
    console.log(value);
    let msg : any;
    msg= this.http.post<LeaveDetails>("http://localhost:8080/ftp71-0.0.1-SNAPSHOT/api/leaveDetails/updateLeaveStatus/"+empid+"/"+response,value)
    return msg;
  } 



private handleError(error:HttpErrorResponse){
  if(error.error instanceof ErrorEvent){
    console.log("Error occurred communicating with the server", error.error.message);
  } else {
    console.log(`backend returned error  ${error.status}`+
      `body was: ${error.message}. `);
  }
  return throwError('something went seriously wrong');
}
  
}

