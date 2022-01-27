package com.hexaware.ftp71.model;

import com.hexaware.ftp71.persistence.DbConnection;
import com.hexaware.ftp71.persistence.EmployeeDAO;
import java.util.List;

/**
 * Employee class to store employee personal details.
 * @author FTP71-Hexware
 */
public class Employee {

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

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {
    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param argEmployeeId id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int argEmployeeId) {
    return dao().find(argEmployeeId);
  }
  /**
   * list employee details by id.
   * @param argEmployeeId id to get employee details.
   * @param argBalance to set current leave balance.
   * @return Employee
   */
  public static int updateEarnedLeaveBalance(final int argBalance, final int argEmployeeId) {
    return dao().updateEarnedLeaveBalance(argBalance, argEmployeeId);
  }

  /**
   * list employee details by id.
   * @param argEmployeeId id to get employee details.
   * @param argBalance to set current leave balance.
   * @return Employee
   */
  public static int updatePaidLeaveBalance(final int argBalance, final int argEmployeeId) {
    return dao().updatePaidLeaveBalance(argBalance, argEmployeeId);
  }

  /**
   * list employee details by id.
   * @param argEmployeeId id to get employee details.
   * @param argBalance to set current leave balance.
   * @return Employee
   */
  public static int updateSickLeaveBalance(final int argBalance, final int argEmployeeId) {
    return dao().updateSickLeaveBalance(argBalance, argEmployeeId);
  }

  /**
   * list employee details by id.
   * @param argEmployeeId id to get employee details.
   * @param argBalance to set current leave balance.
   * @return Employee
   */
  public static int updateOptionalLeaveBalance(final int argBalance, final int argEmployeeId) {
    return dao().updateOptionalLeaveBalance(argBalance, argEmployeeId);
  }

  /**
   * list manager details by id.
   * @param argManagerId id of the manager.
   * @return Employee
   */
  public static final List<Employee> getManagerById(final int argManagerId) {
    return dao().getManagerById(argManagerId);
  }

  /**
   * Override toString method.
   * Displays all the values of the Employee Class.
   * @return all employees' details
   */
  @Override
  public final String toString() {
    return "Employee [empId=" + empId
                      + ", employeeName=" + employeeName
                      + ", departmentName=" + departmentName
                      + ", employeeDateOfJoining=" + employeeDateOfJoining
                      + ", employeeEmail=" + employeeEmail
                      + ", employeeContact=" + employeeContact
                      + ", managerId=" + managerId
                      + ", earnedLeaveBalance=" + earnedLeaveBalance
                      + ", paidLeaveBalance=" + paidLeaveBalance
                      + ", sickLeaveBalance=" + sickLeaveBalance
                      + ", optionalLeaveBalance="
                      +  optionalLeaveBalance
                      + "]";
  }
}
