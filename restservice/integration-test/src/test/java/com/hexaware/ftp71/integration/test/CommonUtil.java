package com.hexaware.ftp71.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Date;
import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "ftp71-0.0.1-SNAPSHOT");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee {

  /**
   * empId to store employee id.
   */
  private int empId;

  /**
   * employeeName to store employee name.
   */
  private String employeeName;

  /**
   * departmentName to store department Name.
   */
  private String departmentName;

  /**
   * employeeDateOfJoining to store employee Date Of Joining.
   */
  private java.util.Date employeeDateOfJoining;

  /**
   * employeeEmail to store employee Email.
   */
  private String employeeEmail;

  /**
   * employeeContact to store employee Contact.
   */
  private String employeeContact;

  /**
   * managerId to store manager Id.
   */
  private int managerId;

  /**
   * earnedLeaveBalance to store Earned Leave Balance.
   */
  private int earnedLeaveBalance;
  /**
   * paidLeaveBalance to store paid Leave Balance.
   */
  private int paidLeaveBalance;
  /**
   * sickLeaveBalance to store sick Leave Balance.
   */
  private int sickLeaveBalance;
  /**
   * optionalLeaveBalance to store optional Leave Balance.
   */
  private int optionalLeaveBalance;

  @Override
  public final boolean equals(final Object object) {
    if (object == null) {
      return false;
    }
    if (getClass() != object.getClass()) {
      return false;
    }
    Employee employee = (Employee) object;
    if (java.util.Objects.equals(empId, employee.empId)
        && java.util.Objects.equals(employeeName, employee.employeeName)
        && java.util.Objects.equals(departmentName, employee.departmentName)
        && java.util.Objects.equals(employeeDateOfJoining, employee.employeeDateOfJoining)
        && java.util.Objects.equals(employeeEmail, employee.employeeEmail)
        && java.util.Objects.equals(employeeContact, employee.employeeContact)
        && java.util.Objects.equals(managerId, employee.managerId)
        && java.util.Objects.equals(earnedLeaveBalance, employee.earnedLeaveBalance)
        && java.util.Objects.equals(paidLeaveBalance, employee.paidLeaveBalance)
        && java.util.Objects.equals(sickLeaveBalance, employee.sickLeaveBalance)
        && java.util.Objects.equals(optionalLeaveBalance, employee.optionalLeaveBalance)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return java.util.Objects.hash(empId)
         + java.util.Objects.hash(employeeName)
         + java.util.Objects.hash(departmentName)
         + java.util.Objects.hash(employeeDateOfJoining)
         + java.util.Objects.hash(employeeEmail)
         + java.util.Objects.hash(employeeContact)
         + java.util.Objects.hash(managerId)
         + java.util.Objects.hash(earnedLeaveBalance)
         + java.util.Objects.hash(paidLeaveBalance)
         + java.util.Objects.hash(sickLeaveBalance)
         + java.util.Objects.hash(optionalLeaveBalance);
  }

  /**
   * @param argEmpId to initialize employee id.
   * @param argEmployeeName to initialize employee name.
   * @param argDepartmentName to initialize department name.
   * @param argEmployeeDateOfJoining to initialize employee's date of joining.
   * @param argEmployeeEmail to initialize employee email.
   * @param argEmployeeContact to initialize employee contact.
   * @param argManagerId to initialize manager id.
   * @param argEarnedLeaveBalance to initialize employee earned Leave balance.
   * @param argPaidLeaveBalance to initialize employee paid Leave balance.
   * @param argSickLeaveBalance to initialize employee sick Leave balance.
   * @param argOptionalLeaveBalance to initialize employee optional Leave balance.
   */
  public Employee(final int argEmpId,
           final String argEmployeeName,
           final String argDepartmentName,
           final java.util.Date argEmployeeDateOfJoining,
           final String argEmployeeEmail,
           final String argEmployeeContact,
           final int argManagerId,
           final int argEarnedLeaveBalance,
           final int argPaidLeaveBalance,
           final int argSickLeaveBalance,
           final int argOptionalLeaveBalance) {
    this.empId                 = argEmpId;
    this.employeeName          = argEmployeeName;
    this.departmentName        = argDepartmentName;
    this.employeeDateOfJoining = argEmployeeDateOfJoining;
    this.employeeEmail         = argEmployeeEmail;
    this.employeeContact       = argEmployeeContact;
    this.managerId             = argManagerId;
    this.earnedLeaveBalance    = argEarnedLeaveBalance;
    this.paidLeaveBalance      = argPaidLeaveBalance;
    this.sickLeaveBalance      = argSickLeaveBalance;
    this.optionalLeaveBalance  = argOptionalLeaveBalance;
  }

  /**
  * Default Constructor.
  */
  public Employee() {
  }

  /**
   * Gets the empId.
   * @return this Employee's Id.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * Initializes the Employee's Id.
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * Gets the Employee's Name.
   * @return employeeName
   */
  public final String getEmployeeName() {
    return employeeName;
  }

  /**
   * Initializes the Employee's Name.
   * @param argEmployeeName to set employee name.
   */
  public final void setEmployeeName(final String argEmployeeName) {
    this.employeeName = argEmployeeName;
  }

  /**
   * Gets the Department's Name.
   * @return departmentName
   */
  public final String getDepartmentName() {
    return departmentName;
  }

  /**
   * Initializes the Department's Name.
   * @param argDepartmentName to set department name.
   */
  public final void setDepartmentName(final String argDepartmentName) {
    this.departmentName = argDepartmentName;
  }

 /**
   * Gets the Employee's Date Of Joining.
   * @return employeeDateOfJoining
   */
  public final java.util.Date getEmployeeDateOfJoining() {
    return employeeDateOfJoining;
  }

  /**
   * Initializes the Employee's Date Of Joining.
   * @param argEmployeeDateOfJoining to set date of joining.
   */
  public final void setEmployeeDateOfJoining(final java.util.Date argEmployeeDateOfJoining) {
    this.employeeDateOfJoining = argEmployeeDateOfJoining;
  }

  /**
   * Gets the Employee's Email.
   * @return employeeEmail
   */
  public final String getEmployeeEmail() {
    return employeeEmail;
  }

  /**
   * Initializes the Employee's Email.
   * @param argEmployeeEmail to set email of employee.
   */
  public final void setEmployeeEmail(final String argEmployeeEmail) {
    this.employeeEmail = argEmployeeEmail;
  }

  /**
   * Gets the Employee's Contact.
   * @return employeeContact
   */
  public final String getEmployeeContact() {
    return employeeContact;
  }

  /**
   * Initializes the Employee's Contact.
   * @param argEmployeeContact to set employee contact.
   */
  public final void setEmployeeContact(final String argEmployeeContact) {
    this.employeeContact = argEmployeeContact;
  }

  /**
   * Gets the Manager's Id.
   * @return managerId
   */
  public final int getManagerId() {
    return managerId;
  }

  /**
   * Initializes the Employee's Manager Id.
   * @param argManagerId to set manager id.
   */
  public final void setManagerId(final int argManagerId) {
    this.managerId = argManagerId;
  }

  /**
   * Gets the Earned Leave Balance.
   * @return earnedLeaveBalance
   */
  public final int getEarnedLeaveBalance() {
    return earnedLeaveBalance;
  }

  /**
   * Initializes the Employee's Earned Leave Balance.
   * @param argEarnedLeaveBalance to set earned leave balance.
   */
  public final void setEarnedLeaveBalance(final int argEarnedLeaveBalance) {
    this.earnedLeaveBalance = argEarnedLeaveBalance;
  }

  /**
   * Gets the Paid Leave Balance.
   * @return paidLeaveBalance
   */
  public final int getPaidLeaveBalance() {
    return paidLeaveBalance;
  }

  /**
   * Initializes the Employee's Paid Leave Balance.
   * @param argPaidLeaveBalance to set paid leave balance.
   */
  public final void setPaidLeaveBalance(final int argPaidLeaveBalance) {
    this.paidLeaveBalance = argPaidLeaveBalance;
  }

  /**
   * Gets the Sick Leave Balance.
   * @return sickLeaveBalance
   */
  public final int getSickLeaveBalance() {
    return sickLeaveBalance;
  }

  /**
   * Initializes the Employee's Sick Leave Balance.
   * @param argSickLeaveBalance to set sick leave balance.
   */
  public final void setSickLeaveBalance(final int argSickLeaveBalance) {
    this.sickLeaveBalance = argSickLeaveBalance;
  }

  /**
   * Gets the Optional Leave Balance.
   * @return optionalLeaveBalance
   */
  public final int getOptionalLeaveBalance() {
    return optionalLeaveBalance;
  }

  /**
   * Initializes the Employee's Optional Leave Balance.
   * @param argOptionalLeaveBalance to set optional leave balance.
   */
  public final void setOptionalLeaveBalance(final int argOptionalLeaveBalance) {
    this.optionalLeaveBalance = argOptionalLeaveBalance;
  }


public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }

}

/**
 * This class provides a msg for user interface.
 */
class Status {
  /**
   * msg to store result.
   */
  private String msg;

  /**
   * default constructor.
   */
  Status() { }
  /**
   * @param argMsg the message
   */
  public void setMsg(final String argMsg) {
    this.msg = argMsg;
  }
  /**
   * Returns a string.
   * @return a string
   */
  public String getMsg() {
    return this.msg;
  }
}

class LeaveDetails {

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



    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}

enum LeaveStatus {
    /**
     * approved.
     */
    approved,
    /**
     * pending.
     */
    pending,
    /**
     * denied.
     */
    denied;
}

enum LeaveType {
    /**
     * El.
     */
    EL,
    /**
     * Sl.
     */
    SL,
    /**
     * Pl.
     */
    PL,
    /**
     * Ol.
     */
    OL;
}
