
package com.hexaware.ftp71.persistence;

import com.hexaware.ftp71.model.LeaveDetails;
import com.hexaware.ftp71.model.LeaveStatus;
import com.hexaware.ftp71.model.LeaveType;
import org.skife.jdbi.v2.sqlobject.Bind;
//import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
//import java.util.Date;

/**
 * The DAO class for leave Details.
 */
public interface LeaveDetailsDAO  {
  /**
   * return all the details of all the employee's leave.
   * @return the leave details array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list();
  /**
   * return all the leave details of the selected employee.
   * @param argEmployeeId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :argEmployeeId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> getLeaveHistory(@Bind("argEmployeeId") int argEmployeeId);
  /**
   * return the number of days of leaves.
   * @param argEmployeeId to get the employee Id
   * @param argStartDate to get the start date
   * @param argEndDate to get the endDate
   * @param argLeaveReason to get the reason for leave
   * @param argLeaveType to get type of leave
   * @param argNoOfLeaves to get the number of leaves
   * @param argAppliedOn to get the date of application
   * @return the number of leaves
   */
  @SqlUpdate("INSERT INTO LEAVE_DETAILS "
              + " (EMP_ID, START_DATE, END_DATE, LEAVE_REASON, LEAVE_TYPE, NO_OF_LEAVES, APPLIED_ON) "
              + " VALUES (:argEmployeeId,"
              + " :argStartDate,"
              + " :argEndDate,"
              + " :argLeaveReason,"
              + " :argLeaveType,"
              + " :argNoOfLeaves,"
              + " :argAppliedOn)")
  int applyForLeave(@Bind("argEmployeeId") int argEmployeeId,
                    @Bind("argStartDate") String argStartDate,
                    @Bind("argEndDate") String argEndDate,
                    @Bind("argLeaveReason") String argLeaveReason,
                    @Bind("argLeaveType") LeaveType argLeaveType,
                    @Bind("argNoOfLeaves") int argNoOfLeaves,
                    @Bind("argAppliedOn") String argAppliedOn);
/**
 * @return the Updated status.
 * @param argStatus to set Leave Status
 * @param argCurrentDate to set approved on
 * @param argLeaveId the id of the leaves of employee
 */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS = :argStatus"
            + " , APPROVED_ON = :argCurrentDate"
            + " WHERE EMP_ID = 1000"
            + " AND LEAVE_ID = :argLeaveId")
  int setStatus(@Bind("argStatus") LeaveStatus argStatus,
                @Bind("argCurrentDate") String argCurrentDate,
                @Bind("argLeaveId") int argLeaveId);
  /**
   * return all the leave details of the selected employee.
   * @param argManagerId the id of the manager
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID IN "
            + " (SELECT EMP_ID FROM EMPLOYEES WHERE MANAGER_ID = :managerId)"
            + " && LEAVE_STATUS = 'pending'")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> pendingStatusList(@Bind("managerId") int argManagerId);
  /**
   * return the number of days of leaves.
   * @param argEmployeeId to get the employee Id
   * @param argStartDate to get the start date
   * @param argEndDate to get the endDate
   * @return the number of leaves
   */
  @SqlQuery("SELECT COUNT(*) FROM LEAVE_DETAILS WHERE EMP_ID = :argEmployeeId AND "
              + "((START_DATE BETWEEN :argStartDate AND :argEndDate)"
              + " OR (END_DATE BETWEEN :argEndDate AND :argStartDate))")
  int recordCount(@Bind("argEmployeeId") int argEmployeeId,
        @Bind("argStartDate") String argStartDate,
        @Bind("argEndDate") String argEndDate);

  /**
   * return the number of days of leaves.
   * @param argEmployeeId to get the employee Id
   * @param argLeaveType to get the leave type
   * @return the number of leaves
   */
  @SqlQuery("SELECT COUNT(*) FROM LEAVE_DETAILS WHERE EMP_ID = :argEmployeeId AND "
              + "LEAVE_TYPE = :argLeaveType")
  int countOptionalLeave(@Bind("argEmployeeId") int argEmployeeId,
            @Bind("argLeaveType") LeaveType argLeaveType);
  /**
   * return all the leave details of the selected employee.
   * @param argEmployeeId the id of the employee
   * @param argLeaveId the id of the leaves of employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :argEmployeeId "
            + " AND LEAVE_ID = :argLeaveId"
            + " AND LEAVE_STATUS = denied")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails find(@Bind("argEmployeeId") int argEmployeeId,
                      @Bind("argLeaveId") int argLeaveId);

  /**
   * return all the leave details of the selected employee.
   * @param argLeaveId the id of the leave's taken by employee
   * @param argManagerComments to get manager comments
   * @param argStatus to update status of the leave taken
   * @param argEmployeeId to get employee id
   * @return the leaveDetails object
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET MANAGER_COMMENTS = :argManagerComments"
            + " , LEAVE_STATUS = :argStatus WHERE LEAVE_ID = :argLeaveId"
            + " AND EMP_ID = :argEmployeeId")
  int updateLeaveStatus(@Bind("argLeaveId") int argLeaveId,
                         @Bind("argManagerComments") String argManagerComments,
                         @Bind("argStatus") LeaveStatus argStatus,
                         @Bind("argEmployeeId") int argEmployeeId);
  /**
   * update Date of Approval.
   * @param argCurrentDate to set currentDate
   * @param argEmployeeId to get employeeId
   * @param argLeaveId to get leaveId
   * @return the approved date
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET APPROVED_ON = :argCurrentDate WHERE EMP_ID = :argEmployeeId"
             + " AND LEAVE_ID = :argLeaveId")
  int setApprovedOn(@Bind("argCurrentDate") java.time.LocalDate argCurrentDate,
                    @Bind("argEmployeeId") int argEmployeeId,
                    @Bind("argLeaveId") int argLeaveId);
  /**
   * return leave Balance of the employees whose leave status is denied.
   * @param argEmployeeId to get id of the employee
   * @param argLeaveId the leave id of the employee
   * @return the current balance
   */
  @SqlUpdate("UPDATE EMPLOYEES SET EARNED_LEAVE = EARNED_LEAVE +"
            + " (SELECT NO_OF_LEAVES FROM LEAVE_DETAILS WHERE EMP_ID = :argEmployeeId AND LEAVE_ID = :argLeaveId)"
            + " WHERE EMP_ID = :argEmployeeId")
  int updateEarnedLeaveBalance(@Bind("argEmployeeId") int argEmployeeId,
                         @Bind("argLeaveId") int argLeaveId);

  /**
   * return leave Balance of the employees whose leave status is denied.
   * @param argEmployeeId to get id of the employee
   * @param argLeaveId the leave id of the employee
   * @return the current balance
   */
  @SqlUpdate("UPDATE EMPLOYEES SET PAID_LEAVE = PAID_LEAVE +"
            + " (SELECT NO_OF_LEAVES FROM LEAVE_DETAILS WHERE EMP_ID = :argEmployeeId AND LEAVE_ID = :argLeaveId)"
            + " WHERE EMP_ID = :argEmployeeId")
  int updatePaidLeaveBalance(@Bind("argEmployeeId") int argEmployeeId,
                         @Bind("argLeaveId") int argLeaveId);

  /**
   * return leave Balance of the employees whose leave status is denied.
   * @param argEmployeeId to get id of the employee
   * @param argLeaveId the leave id of the employee
   * @return the current balance
   */
  @SqlUpdate("UPDATE EMPLOYEES SET SICK_LEAVE = SICK_LEAVE +"
            + " (SELECT NO_OF_LEAVES FROM LEAVE_DETAILS WHERE EMP_ID = :argEmployeeId AND LEAVE_ID = :argLeaveId"
            + " AND LEAVE_STATUS = 'denied')"
            + " WHERE EMP_ID = :argEmployeeId")
  int updateSickLeaveBalance(@Bind("argEmployeeId") int argEmployeeId,
                         @Bind("argLeaveId") int argLeaveId);

  /**
   * return leave Balance of the employees whose leave status is denied.
   * @param argEmployeeId to get id of the employee
   * @param argLeaveId the leave id of the employee
   * @return the current balance
   */
  @SqlUpdate("UPDATE EMPLOYEES SET OPTIONAL_LEAVE = OPTIONAL_LEAVE +"
            + " (SELECT NO_OF_LEAVES FROM LEAVE_DETAILS WHERE EMP_ID = :argEmployeeId AND LEAVE_ID = :argLeaveId)"
            + " WHERE EMP_ID = :argEmployeeId")
  int updateOptionalLeaveBalance(@Bind("argEmployeeId") int argEmployeeId,
                         @Bind("argLeaveId") int argLeaveId);
 /**
  * close with no args is used to close the connection.
  */
  void close();
}
