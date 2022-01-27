package com.hexaware.ftp71.model;

import com.hexaware.ftp71.persistence.DbConnection;
import com.hexaware.ftp71.persistence.LeaveDetailsDAO;
//import com.hexaware.ftp71.model.LeaveStatus;
//import com.hexaware.ftp71.model.LeaveType;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.text.ParseException;
//import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Calendar;
/**
 * LeaveDetails class to store employee's leave details.
 * @author FTP71-Hexaware
 */
public class LeaveDetails {

  /**
   * leaveId to store employee leave id.
   */
  private int leaveId;

  /**
   * employeeId to store employee id.
   */
  private int employeeId;

  /**
   * startDate to store starting date of leave.
   */
  private Date startDate;

  /**
   * endDate to store employee ending date of leave.
   */
  private Date endDate;

  /**
   * noOfLeaves to store number of leaves taken.
   */
  private int noOfLeaves;

  /**
   * leaveReason to store reason of leave.
   */
  private String leaveReason;

  /**
   * appliedOn to store date of applied leave.
   */
  private Date appliedOn;

  /**
   * approvedOn to store date of approval of leave.
   */
  private Date approvedOn;

  /**
   * leaveType to store type of leave taken.
   */
  private LeaveType leaveType;

  /**
   * leaveStatus to store status of leave.
   */
  private LeaveStatus leaveStatus;


  /**
   * managerComments to store comments of manager.
   */
  private String managerComments;

  @Override
  public final boolean equals(final Object object) {
    if (object == null) {
      return false;
    }
    if (getClass() != object.getClass()) {
      return false;
    }
    LeaveDetails leaveDetails = (LeaveDetails) object;
    if (java.util.Objects.equals(leaveId, leaveDetails.leaveId)
        && java.util.Objects.equals(employeeId, leaveDetails.employeeId)
        && java.util.Objects.equals(startDate, leaveDetails.startDate)
        && java.util.Objects.equals(endDate, leaveDetails.endDate)
        && java.util.Objects.equals(noOfLeaves, leaveDetails.noOfLeaves)
        && java.util.Objects.equals(leaveReason, leaveDetails.leaveReason)
        && java.util.Objects.equals(appliedOn, leaveDetails.appliedOn)
        && java.util.Objects.equals(approvedOn, leaveDetails.approvedOn)
        && java.util.Objects.equals(leaveType, leaveDetails.leaveType)
        && java.util.Objects.equals(leaveStatus, leaveDetails.leaveStatus)
        && java.util.Objects.equals(managerComments, leaveDetails.managerComments)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return java.util.Objects.hash(leaveId)
            + java.util.Objects.hash(employeeId)
            + java.util.Objects.hash(startDate)
            + java.util.Objects.hash(endDate)
            + java.util.Objects.hash(noOfLeaves)
            + java.util.Objects.hash(leaveReason)
            + java.util.Objects.hash(appliedOn)
            + java.util.Objects.hash(approvedOn)
            + java.util.Objects.hash(leaveType)
            + java.util.Objects.hash(leaveStatus)
            + java.util.Objects.hash(managerComments);
  }

  /**
   * @param argLeaveId to initialize leave id.
   * @param argEmployeeId to initialize employee id.
   * @param argStartDate to initialize start date.
   * @param argEndDate to initialize end date.
   * @param argNoOfLeaves to initialize number of leaves.
   * @param argLeaveReason to initialize leave reason.
   * @param argAppliedOn to initialize date of leave applied.
   * @param argApprovedOn to initialize date of leave approved.
   * @param argLeaveType to initialize type of leave.
   * @param argLeaveStatus to initialize status of leave.
   * @param argManagerComments to initialize comments of manager.
   */
  public LeaveDetails(final int argLeaveId,
            final int argEmployeeId,
            final Date argStartDate,
            final Date argEndDate,
            final int argNoOfLeaves,
            final String argLeaveReason,
            final Date argAppliedOn,
            final Date argApprovedOn,
            final String argLeaveType,
            final String argLeaveStatus,
            final String argManagerComments) {
    this.leaveId               = argLeaveId;
    this.employeeId            = argEmployeeId;
    this.startDate             = argStartDate;
    this.endDate               = argEndDate;
    this.noOfLeaves            = argNoOfLeaves;
    this.leaveReason           = argLeaveReason;
    this.appliedOn             = argAppliedOn;
    this.approvedOn            = argApprovedOn;
    this.leaveType             = LeaveType.valueOf(argLeaveType);
    this.leaveStatus           = LeaveStatus.valueOf(argLeaveStatus);
    this.managerComments       = argManagerComments;
  }

  /**
  * Default Constructor.
  */
  public LeaveDetails() {

  }

  /**
   * Gets the Leave Id.
   * @return leaveId
   */
  public final int getLeaveId() {
    return leaveId;
  }

  /**
   * Initializes the Leave Id.
   * @param argLeaveId to set leave id.
   */

  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }

  /**
   * Gets the Employee's Id.
   * @return employeeId
   */
  public final int getEmployeeId() {
    return employeeId;
  }

  /**
   * Initializes the Employee's Id.
   * @param argEmployeeId to set employee id.
   */
  public final void setEmployeeId(final int argEmployeeId) {
    this.employeeId = argEmployeeId;
  }

  /**
   * Gets the Start Date.
   * @return startDate
   */
  public final Date getStartDate() {
    return startDate;
  }

  /**
   * Initializes the Start Date.
   * @param argStartDate to set start date.
   */
  public final void setStartDate(final Date argStartDate) {
    this.startDate = argStartDate;
  }

/**
   * Gets the End Date.
   * @return endDate
   */
  public final Date getEndDate() {
    return endDate;
  }

  /**
   * Initializes the End Date.
   * @param argEndDate to set end date.
   */
  public final void setEndDate(final Date argEndDate) {
    this.endDate = argEndDate;
  }

  /**
   * Gets the Number Of Leaves.
   * @return noOfLeaves
   */
  public final int getNoOfLeaves() {
    return noOfLeaves;
  }

  /**
   * Initializes the Number Of Leaves.
   * @param argNoOfLeaves to set number of leaves.
   */
  public final void setNoOfLeaves(final int argNoOfLeaves) {
    this.noOfLeaves = argNoOfLeaves;
  }

 /**
   * Gets the Reason Of Leave.
   * @return leaveReason
   */
  public final String getLeaveReason() {
    return leaveReason;
  }

  /**
   * Initializes the Reason Of Leave.
   * @param argLeaveReason to set reason of leave.
   */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }

  /**
   * Gets the Date Of Applied Leave.
   * @return appliedOn
   */
  public final Date getAppliedOn() {
    return appliedOn;
  }

  /**
   * Initializes the Date Of Applied Leave.
   * @param argAppliedOn to set date of applied leave.
   */
  public final void setAppliedOn(final Date argAppliedOn) {
    this.appliedOn = argAppliedOn;
  }

  /**
   * Gets the Date Of Approved Leave.
   * @return approvedOn
   */
  public final Date getApprovedOn() {
    return approvedOn;
  }

  /**
   * Initializes the Date Of Approved On.
   * @param argApprovedOn to set date of approved leave.
   */
  public final void setApprovedOn(final Date argApprovedOn) {
    this.approvedOn = argApprovedOn;
  }

  /**
   * Gets the Type Of Leave.
   * @return leaveType
   */
  public final String getLeaveType() {
    return leaveType.name();
  }

  /**
   * Initializes the Type Of Leave.
   * @param argLeaveType to set type of leave.
   */
  public final void setLeaveType(final String argLeaveType) {
    this.leaveType = LeaveType.valueOf(argLeaveType);
  }

  /**
   * Gets the Status Of Leave.
   * @return leaveStatus
   */
  public final String getLeaveStatus() {
    return leaveStatus.name();
  }

  /**
   * Initializes the Status Of Leave.
   * @param argLeaveStatus to set status of leave.
   */
  public final void setLeaveStatus(final String argLeaveStatus) {
    this.leaveStatus = LeaveStatus.valueOf(argLeaveStatus);
  }

  /**
   * Gets the Comments Of Manager.
   * @return managerComments
   */
  public final String getManagerComments() {
    return managerComments;
  }

  /**
   * Initializes the Comments Of Manager.
   * @param argManagerComments to set comments of manager.
   */
  public final void setManagerComments(final String argManagerComments) {
    this.managerComments = argManagerComments;
  }

  /**
   * The dao for leave details.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }

  /**
   * list all leave details.
   * @return all employee's leave details
   */
  public static LeaveDetails[] listAll() {
    List<LeaveDetails> lds = dao().list();
    return lds.toArray(new LeaveDetails[lds.size()]);
  }
  /**
   * @throws ParseException
   * get the number of days of leave.
   * @param startDate to get total number of leaves
   * @param endDate to get total number of leaves
   * @param argEmployeeId to get employeeId
   * @param argLeaveReason for reason of leave
   * @param argLeaveType for type of leave
   * @param argEarnedLeaveBalance to get Earned Leave Balance
   * @param argPaidLeaveBalance to get Paid Leave Balance
   * @param argSickLeaveBalance to get Sick Leave Balance
   * @param argOptionalLeaveBalance to get Optional Leave Balance
   * @return number of days of leave
   */
  public static String applyForLeave(final int argEmployeeId, final String startDate,
                          final String endDate,
                          final String argLeaveReason,
                          final LeaveType argLeaveType,
                          final int argEarnedLeaveBalance,
                          final int argPaidLeaveBalance,
                          final int argSickLeaveBalance,
                          final int argOptionalLeaveBalance)
                          throws ParseException {
    String message = "";
    Date currentDate = new Date();
    System.out.println(currentDate);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date starDate = sdf.parse(startDate);
    Date enDate = sdf.parse(endDate);
    String currenDate = sdf.format(currentDate);
    int numberOfDays = LeaveDetails.numberOfDays(starDate, enDate);
    System.out.println("Total number of days: " + numberOfDays);
    int leaveNoOfDay = numberOfDays;
    Calendar start = Calendar.getInstance();
    start.setTime(starDate);
    Calendar end = Calendar.getInstance();
    end.setTime(enDate);
    Calendar h = Calendar.getInstance();
    while (start.before(end) || start.equals(end)) {
      int day = start.get(Calendar.DAY_OF_WEEK);
      if (day == 7 || day == 1) {
        leaveNoOfDay--;
        System.out.println(leaveNoOfDay);
      }
      List<Date> lt = holidays();
      Iterator<Date> it = lt.iterator();
      System.out.println(it);
      while (it.hasNext()) {
        h.setTime((Date) it.next());
        System.out.println(h.get(Calendar.DAY_OF_WEEK));
        System.out.println("ho1 1 cal date " + h);
        if (start.get(Calendar.MONTH) == h.get(Calendar.MONTH)
            && start.get(Calendar.DAY_OF_MONTH) == h.get(Calendar.DAY_OF_MONTH)) {
          System.out.println("matched");
          leaveNoOfDay--;
          System.out.println(leaveNoOfDay);
          if (day == 7 || day == 1) {
            leaveNoOfDay++;
            System.out.println(leaveNoOfDay);
          }
        }
      }
      start.add(Calendar.DATE, 1);
    }
    if (starDate.compareTo(currentDate) < 0) {
      message = "Start Date Cannot be Before Current Date";
    } else if (starDate.compareTo(enDate) > 0) {
      message = "End Date Cannot be Before Start Date";
    } else {
      int count = recordCount(argEmployeeId, startDate, endDate);
      if (count == 0) {
        System.out.println(argLeaveType);
        if (argLeaveType == LeaveType.EL && argEarnedLeaveBalance >= leaveNoOfDay && leaveNoOfDay > 0) {
          message = LeaveDetails.applyLeave(argEmployeeId, startDate, endDate, argLeaveReason,
                                                argLeaveType, leaveNoOfDay, currenDate);
          int argBalance = argEarnedLeaveBalance - leaveNoOfDay;
          Employee.updateEarnedLeaveBalance(argBalance, argEmployeeId);
        } else if (argLeaveType == LeaveType.PL && argPaidLeaveBalance >= leaveNoOfDay && leaveNoOfDay > 0) {
          message = LeaveDetails.applyLeave(argEmployeeId, startDate, endDate, argLeaveReason,
                                                argLeaveType, leaveNoOfDay, currenDate);
          int argBalance = argPaidLeaveBalance - leaveNoOfDay;
          Employee.updatePaidLeaveBalance(argBalance, argEmployeeId);
        } else if (argLeaveType == LeaveType.SL && argSickLeaveBalance >= leaveNoOfDay && leaveNoOfDay > 0) {
          message = LeaveDetails.applyLeave(argEmployeeId, startDate, endDate, argLeaveReason,
                                                argLeaveType, leaveNoOfDay, currenDate);
          int argBalance = argSickLeaveBalance - leaveNoOfDay;
          Employee.updateSickLeaveBalance(argBalance, argEmployeeId);
        } else if (argLeaveType == LeaveType.OL && argOptionalLeaveBalance >= leaveNoOfDay && leaveNoOfDay > 0) {
          int numberOfOptExist = countOptionalLeave(argEmployeeId, argLeaveType);
          System.out.println(numberOfOptExist);
          if (numberOfOptExist >= 2) {
            message = "You Can't apply more than two Optional Leave";
          } else {
            message = LeaveDetails.applyLeave(argEmployeeId, startDate, endDate, argLeaveReason,
                                                argLeaveType, leaveNoOfDay, currenDate);
            int argBalance = argOptionalLeaveBalance - leaveNoOfDay;
            Employee.updateOptionalLeaveBalance(argBalance, argEmployeeId);
          }
        } else {
          message = "Sorry You Can't Apply New Leave Application";
        }
      } else {
        message = "Leave is already applied for this period";
      }
    }
    return message;
  }

  /**
   * @throws ParseException
   * get the number of days of leave.
   * @param argEmployeeId to get employeeId
   * @param startDate to get total number of leaves
   * @param endDate to get total number of leaves
   * @param argLeaveReason for reason of leave
   * @param argLeaveType for type of leave
   * @param leaveNoOfDay for total number of leave
   * @param currenDate for applied on
   * @return number of days of leave
   */
  public static String applyLeave(final int argEmployeeId,
                                  final String startDate,
                                  final String endDate,
                                  final String argLeaveReason,
                                  final LeaveType argLeaveType,
                                  final int leaveNoOfDay,
                                  final String currenDate) throws ParseException {

    dao().applyForLeave(argEmployeeId, startDate, endDate, argLeaveReason,
                              argLeaveType, leaveNoOfDay, currenDate);
    String message = "Leave Successfully Applied";
    if (argEmployeeId == 1000) {
      LeaveStatus status = LeaveStatus.approved;
      List<LeaveDetails> leaveHistory = LeaveDetails.getLeaveHistory(argEmployeeId);
      int size = leaveHistory.size();
      LeaveDetails ld1 = leaveHistory.get(size - 1);
      int argLeaveId = ld1.getLeaveId();
      System.out.println(argLeaveId);
      dao().setStatus(status, currenDate, argLeaveId);
    }
    return message;
  }
  /**
   * give the number of days.
   * @param argEmployeeId to get the Id of the employee
   * @param argLeaveType to get the type of leave
   * @return the number of days
   */
  public static int countOptionalLeave(final int argEmployeeId, final LeaveType argLeaveType) {
    return dao().countOptionalLeave(argEmployeeId, argLeaveType);
  }

  /**
   * give the number of days.
   * @param argEmployeeId to get the Id of the employee
   * @param argStartDate to get the start date of leave
   * @param argEndDate to get the end date of leave
   * @return the number of days
   */
  public static int recordCount(final int argEmployeeId, final String argStartDate,
                                final String argEndDate) {
    return dao().recordCount(argEmployeeId, argStartDate, argEndDate);
  }

  /**
   * give the number of days.
   * @param argStartDate to get the start date of leave
   * @param argEndDate to get the end date of leave
   * @return the number of days
   */
  public static int numberOfDays(final Date argStartDate, final Date argEndDate) {
    int numberOfDays = 0;
    long duration = argEndDate.getTime() - argStartDate.getTime();
    numberOfDays = (int) (duration / (1000 * 60 * 60 * 24)) + 1;
    return numberOfDays;
  }
  /**
   * list all leave history.
   * @return all empolyee's leave history
   * @param argEmployeeId to view employee's leave history
   */
  public static List<LeaveDetails> getLeaveHistory(final int argEmployeeId) {
    return dao().getLeaveHistory(argEmployeeId);
  }

  /**
   * list all pending leave details.
   * @param argManagerId is manager id
   * @return all employee's pending leave details
   */
  public static List<LeaveDetails> pendingStatusList(final int argManagerId) {
    return dao().pendingStatusList(argManagerId);
  }

  /**
   * list leave details by id.
   * @param argEmployeeId id to get employee details.
   * @param argLeaveId id to get leave details.
   * @return Leave Id
   */
  public static LeaveDetails listById(final int argEmployeeId,
                                      final int argLeaveId) {
    return dao().find(argEmployeeId, argLeaveId);
  }

  /**
   * to update leave status by leave id.
   * @param argLeaveId to get update leave status
   * @param argManagerComments to store manager comments
   * @param argEmployeeId for employee id
   * @param argResponse for selected option
   * @param argleaveType for selected option
   * @return Updated Leave Details
   */
  public static String updateLeaveStatus(final int argLeaveId,
                                      final String argManagerComments,
                                      final int argEmployeeId,
                                      final int argResponse,
                                      final LeaveType argleaveType) {
    LeaveStatus status = null;
    System.out.println(argleaveType);
    if (argResponse == 1) {
      status = LeaveStatus.approved;
      java.time.LocalDate currentDate = java.time.LocalDate.now();
      dao().setApprovedOn(currentDate, argEmployeeId, argLeaveId);
    } else if (argResponse == 2) {
      status = LeaveStatus.denied;
      if (argleaveType == LeaveType.EL) {
        dao().updateEarnedLeaveBalance(argEmployeeId, argLeaveId);
      }
      if (argleaveType == LeaveType.PL) {
        dao().updatePaidLeaveBalance(argEmployeeId, argLeaveId);
      }
      if (argleaveType == LeaveType.SL) {
        dao().updateSickLeaveBalance(argEmployeeId, argLeaveId);
      }
      if (argleaveType == LeaveType.OL) {
        dao().updateOptionalLeaveBalance(argEmployeeId, argLeaveId);
      }
    } else {
      Runtime.getRuntime().halt(0);
    }
    dao().updateLeaveStatus(argLeaveId, argManagerComments, status, argEmployeeId);
    return "Leave Id " + argLeaveId + " Leave Status Updated As " + status;
  }


  /**
   * holidays.
   * @return list.
   * @throws ParseException sdf.
   */
  public static List<Date> holidays() throws ParseException {
    String s1 = "2019-08-15";
    String s2 = "2019-01-26";
    String s3 = "2018-10-02";
    String s4 = "2018-11-07";
    final Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(s1);
    final Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(s2);
    final Date d3 = new SimpleDateFormat("yyyy-MM-dd").parse(s3);
    final Date d4 = new SimpleDateFormat("yyyy-MM-dd").parse(s4);
    List list = new ArrayList<Date>();
    list.add(d1);
    list.add(d2);
    list.add(d3);
    list.add(d4);
    return list;
  }

  @Override
  public final String toString() {
    return "LeaveDetails [leaveId=" + leaveId
                        + ", employeeId=" + employeeId
                        + ", startDate=" + startDate
                        + ", endDate=" + endDate
                        + ", noOfLeaves=" + noOfLeaves
                        + ", leaveReason=" + leaveReason
                        + ", appliedOn=" + appliedOn
                        + ", approvedOn=" + approvedOn
                        + ", leaveType=" + getLeaveType()
                        + ", leaveStatus=" + getLeaveStatus()
                        + ", managerComments=" + managerComments
                        + "]";
  }
}
