import { of } from 'rxjs';
import { Employee } from './employee';
import {LeaveDetails} from './leave-details';

export class EmployeeServiceStub {
    getEmployees(){
        const empArr = {"body": [
            {
              'empId': 2001,
              'employeeName': 'Sachita',
              'departmentName': 'Finance',
              'employeeDateOfJoining': '06-12-2016',
              'employeeEmail': 'sachita@hexaware.com',
              'employeeContact': 9404018529,
              'managerId': 3,
              'earnedLeaveBalance': 5,
              'paidLeaveBalance': 5,
              'sickLeaveBalance': 5,
              'optionalLeaveBalance': 5
            },
            {
                'empId': 3000,
                'employeeName': 'Pooja',
                'departmentName': 'Innovation',
                'employeeDateOfJoining': '18-10-2016',
                'employeeEmail': 'Pooja@hexaware.com',
                'employeeContact': 987654321,
                'managerId': 4,
                'earnedLeaveBalance': 5,
                'paidLeaveBalance': 5,
                'sickLeaveBalance': 5,
                'optionalLeaveBalance': 5
            }
        ]};
        return of(empArr);
    }

    getEmployee( empId : number ) {
        
        const emp : Employee = 
            {
                'empId': 2001,
                'employeeName': 'Sachita',
                'departmentName': 'Finance',
                'employeeDateOfJoining': '06-12-2016',
                'employeeEmail': 'sachita@hexaware.com',
                'employeeContact': 9404018529,
                'managerId': 3,
                'earnedLeaveBalance': 5,
                'paidLeaveBalance': 5,
                'sickLeaveBalance': 5,
                'optionalLeaveBalance': 5
            };
        
        return  of (emp);
    }
    

    getLeaveDetailsById(employeeId : number , leaveId : number){
        const leaveArr = {"body": [ 
            {
                'leaveId' : 2,
                'employeeId' : 3001,
                'startDate' : '2018-09-15',
                'endDate' : '2018-09-16',
                'noOfLeaves' : 5,
                'leaveReason' : 'Sick',
                'appliedOn' : '2018-09-10',
                'approvedOn' : '2018-09-12',
                'leaveType' : 'EL',
                'leaveStatus' : 'approved',
                'managerComments' : null,
            
            },
            {
                'leaveId' : 3,
                'employeeId' : 3002,
                'startDate' : '2018-09-21',
                'endDate' : '2018-09-22',
                'noOfLeaves' : 2,
                'leaveReason' : 'Personal',
                'appliedOn' : '2018-09-11',
                'approvedOn' : null,
                'leaveType' : 'PL',
                'leaveStatus' : 'pending',
                'managerComments' : null,
            } 
        ]};
        return of(leaveArr);
    }

    getLeaveHistory(employeeId : number ){
        const leaveArr ={"body":  [
            {
                'leaveId' : 2,
                'employeeId' : 3001,
                'startDate' : '2018-09-15',
                'endDate' : '2018-09-16',
                'noOfLeaves' : 5,
                'leaveReason' : 'Sick',
                'appliedOn' : '2018-09-10',
                'approvedOn' : '2018-09-12',
                'leaveType' : 'EL',
                'leaveStatus' : 'approved',
                'managerComments' : null,
            
            },
            {
                'leaveId' : 3,
                'employeeId' : 3002,
                'startDate' : '2018-09-21',
                'endDate' : '2018-09-22',
                'noOfLeaves' : 2,
                'leaveReason' : 'Personal',
                'appliedOn' : '2018-09-11',
                'approvedOn' : null,
                'leaveType' : 'PL',
                'leaveStatus' : 'pending',
                'managerComments' : null,
            }
        ]};
        return of(leaveArr);
    }

    getPendingStatus(employeeId : number){ 

        const leaveArr ={"body": [
            {
                'leaveId' : 2,
                'employeeId' : 3001,
                'startDate' : '2018-09-15',
                'endDate' : '2018-09-16',
                'noOfLeaves' : 5,
                'leaveReason' : 'Sick',
                'appliedOn' : '2018-09-10',
                'approvedOn' : null,
                'leaveType' : 'EL',
                'leaveStatus' : 'pending',
                'managerComments' : null,
            
            },
            {
                'leaveId' : 3,
                'employeeId' : 3002,
                'startDate' : '2018-09-21',
                'endDate' : '2018-09-22',
                'noOfLeaves' : 2,
                'leaveReason' : 'Personal',
                'appliedOn' : '2018-09-11',
                'approvedOn' : null,
                'leaveType' : 'PL',
                'leaveStatus' : 'pending',
                'managerComments' : null,
            }
        ]};
        return of(leaveArr);
    }

}
