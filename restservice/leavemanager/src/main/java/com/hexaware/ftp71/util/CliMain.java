package com.hexaware.ftp71.util;
//import java.time.LocalDateTime;
import java.util.Scanner;
//import java.text.ParseException;
//import java.util.Date;
import com.hexaware.ftp71.model.Employee;
import com.hexaware.ftp71.model.LeaveDetails;

import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.List;
import com.hexaware.ftp71.model.LeaveType;
/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
  //private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply for Leave");
    System.out.println("4. Display Leave History");
    System.out.println("5. Display Pending Leaves");
    System.out.println("6. Approve or Deny Leave Requests");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    try {
      int menuOption = option.nextInt();
      mainMenuDetails(menuOption);
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("Enter digits only!!");
    }
  }

  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyForLeave();
        break;
      case 4:
        getLeaveHistory();
        break;
      case 5:
        pendingStatusList();
        break;
      case 6:
        reponseLeaveRequest();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Select the correct option...!");
    }
    mainMenu();
  }

  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int employeeId = option.nextInt();
    Employee employee = Employee.listById(employeeId);

    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(employee);
    }
  }

  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e);
    }
  }

  private void applyForLeave() {
    System.out.println("Enter an Employee Id");
    int employeeId = option.nextInt();
    option.nextLine();
    Employee employee = Employee.listById(employeeId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(employee);
      int earnedLeaveBalance = employee.getEarnedLeaveBalance();
      int paidLeaveBalance = employee.getPaidLeaveBalance();
      int sickLeaveBalance = employee.getSickLeaveBalance();
      int optionalLeaveBalance = employee.getOptionalLeaveBalance();
      System.out.println("Enter the start date(yyyy-MM-dd): ");
      String strStartDate = option.nextLine();
      System.out.println("Enter the end date(yyyy-MM-dd):");
      String strEndDate = option.nextLine();
      System.out.println("Enter the reason for the leave:");
      String leaveReason = option.nextLine();
      System.out.println("Enter the type of leave(EL, SL, PL, OL)");
      String strLeaveType = option.next();
      strLeaveType = strLeaveType.toUpperCase();
      LeaveType leaveType = LeaveType.valueOf(strLeaveType);

      try {
        String applicationResponse = LeaveDetails.applyForLeave(employeeId, strStartDate, strEndDate,
                                                          leaveReason, leaveType, earnedLeaveBalance,
                                                          paidLeaveBalance, sickLeaveBalance, optionalLeaveBalance);
        System.out.println(applicationResponse);
      } catch (ParseException ex) {
        System.out.println(ex);
      }
    }
  }

  private void getLeaveHistory() {
    System.out.println("Enter an Employee Id");
    int employeeId = option.nextInt();
    Employee employee = Employee.listById(employeeId);
    if (employee == null) {
      System.out.println("Incorrect Employee Id");
    } else {
      List<LeaveDetails> leaveHistory = LeaveDetails.getLeaveHistory(employeeId);
      if (leaveHistory.size() != 0) {
        System.out.println(leaveHistory);
      } else {
        System.out.println("No Previous Leave History!!");
      }
    }
  }

  private int pendingStatusList() {
    int listStatus = 0;
    System.out.println("Enter your Employee Id");
    int managerId = option.nextInt();
    List<Employee> employees = Employee.getManagerById(managerId);
    if (employees.size() > 0) {
      System.out.println(managerId);
      List<LeaveDetails> leaveDetails = LeaveDetails.pendingStatusList(managerId);
      if (leaveDetails.size() == 0) {
        System.out.println("No pending leaves!!");
      } else {
        System.out.println("Available pending leaves for " + managerId + " is " + leaveDetails.size());
        for (LeaveDetails ld : leaveDetails) {
          System.out.println(ld);
          listStatus = 1;
        }
      }
    } else {
      System.out.println("No such manager!!");
      listStatus = 0;
    }
    return listStatus;
  }

  private void reponseLeaveRequest() {
    int pendingList = pendingStatusList();
    if (pendingList == 1) {
      System.out.println("Enter the Employee Id of the employee you want to respond");
      int empId = option.nextInt();
      Employee employee = Employee.listById(empId);
      if (employee == null) {
        System.out.println("Sorry, No such Employee");
      } else {
        System.out.println("Enter Leave Id");
        int argLeaveId = option.nextInt();
        LeaveDetails leaveId = LeaveDetails.listById(empId, argLeaveId);
        if (leaveId == null) {
          System.out.println("No such Leave Id!!");
        } else {
          System.out.println("Give Response \n 1. TO APPROVE \n 2. TO DENY \n 3. TO EXIT");
          int response = option.nextInt();
          option.nextLine();
          String strLeaveType = leaveId.getLeaveType();
          LeaveType leaveType = LeaveType.valueOf(strLeaveType);
          String managerComments = null;
          if (response == 1 || response == 2) {
            System.out.println("Enter manager Comments : ");
            managerComments = option.nextLine();
            String strStatus = LeaveDetails.updateLeaveStatus(argLeaveId, managerComments, empId, response, leaveType);
            System.out.println(strStatus);
          }
        }
      }
    } else {
      System.out.println("Exit..");
      Runtime.getRuntime().halt(0);
    }
  }

  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
