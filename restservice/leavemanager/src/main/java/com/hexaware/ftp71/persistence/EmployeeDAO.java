package com.hexaware.ftp71.persistence;

import com.hexaware.ftp71.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEES")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();
  /**
   * return all the details of the selected employee.
   * @param argEmployeeId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEES WHERE EMP_ID = :argEmployeeId")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("argEmployeeId") int argEmployeeId);

  /**
   * return all the details of the selected manager.
   * @param argManagerId the id of the manager
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEES WHERE MANAGER_ID = :argManagerId")
  @Mapper(EmployeeMapper.class)
  List<Employee> getManagerById(@Bind("argManagerId") int argManagerId);
  /**
   * return all the details of all the employees.
   * @param argBalance to get updated leave balance
   * @param argEmployeeId the id of the employee
   * @return the current balance
   */
  @SqlUpdate("UPDATE EMPLOYEES SET EARNED_LEAVE = :argBalance WHERE EMP_ID = :argEmployeeId")
  int updateEarnedLeaveBalance(@Bind("argBalance") int argBalance,
                         @Bind("argEmployeeId") int argEmployeeId);

  /**
   * return all the details of all the employees.
   * @param argBalance to get updated leave balance
   * @param argEmployeeId the id of the employee
   * @return the current balance
   */
  @SqlUpdate("UPDATE EMPLOYEES SET PAID_LEAVE = :argBalance WHERE EMP_ID = :argEmployeeId")
  int updatePaidLeaveBalance(@Bind("argBalance") int argBalance,
                         @Bind("argEmployeeId") int argEmployeeId);

  /**
   * return all the details of all the employees.
   * @param argBalance to get updated leave balance
   * @param argEmployeeId the id of the employee
   * @return the current balance
   */
  @SqlUpdate("UPDATE EMPLOYEES SET SICK_LEAVE = :argBalance WHERE EMP_ID = :argEmployeeId")
  int updateSickLeaveBalance(@Bind("argBalance") int argBalance,
                         @Bind("argEmployeeId") int argEmployeeId);

  /**
   * return all the details of all the employees.
   * @param argBalance to get updated leave balance
   * @param argEmployeeId the id of the employee
   * @return the current balance
   */
  @SqlUpdate("UPDATE EMPLOYEES SET OPTIONAL_LEAVE = :argBalance WHERE EMP_ID = :argEmployeeId")
  int updateOptionalLeaveBalance(@Bind("argBalance") int argBalance,
                @Bind("argEmployeeId") int argEmployeeId);
  /**
   * close with no args is used to close the connection.
   */
  void close();
}
