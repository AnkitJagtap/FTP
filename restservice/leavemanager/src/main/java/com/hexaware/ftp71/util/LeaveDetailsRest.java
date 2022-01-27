package com.hexaware.ftp71.util;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.hexaware.ftp71.model.LeaveDetails;
import com.hexaware.ftp71.model.LeaveType;

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
/**
 * This class provides a REST interface for the leave details.
 */
@Path("/leaveDetails")
public class LeaveDetailsRest {

  /**
   * Returns a list of leave details of all the employees.
   * @return a list of leave details of all the employees
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveDetailsList() {
    System.out.println("Leave Details List");
    final LeaveDetails[] leaveDetails = LeaveDetails.listAll();
    return leaveDetails;
  }
  /**
   * Returns a specific employee's details.
   * @param employeeId the id of the employee
   * @param leaveId the id of the employee
   * @return the employee details
   */
  @GET
  @Path("{employeeId}/{leaveId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails leaveDetailsListById(@PathParam("employeeId") final int employeeId,
                                                    @PathParam("leaveId") final int leaveId) {
    final LeaveDetails leaveDetail = LeaveDetails.listById(employeeId, leaveId);
    if (leaveDetail == null) {
      throw new NotFoundException("No such Employee ID: " + employeeId);
    }
    return leaveDetail;
  }

  /**
   * Returns a specific employee's details.
   * @param employeeId the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/leaveHistory/{employeeId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<LeaveDetails> getLeavehistory(@PathParam("employeeId") final int employeeId) {
    final List<LeaveDetails> leaveHistory = LeaveDetails.getLeaveHistory(employeeId);
    if (leaveHistory.size() == 0) {
      throw new NotFoundException("No leave history for this employee: " + employeeId);
    }
    return leaveHistory;
  }

  /**
   * Returns a specific employee's details.
   * @param managerId the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/pendingStatus/{managerId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<LeaveDetails> pendingStatusList(@PathParam("managerId") final int managerId) {
    final List<LeaveDetails> pendingStatus = LeaveDetails.pendingStatusList(managerId);
    if (pendingStatus.size() == 0) {
      throw new NotFoundException("No leave history for this employee: " + managerId);
    }
    return pendingStatus;
  }

  /**
   * Returns a apply for leave status.
   * @param empId the id of the employee
   * @param earnedLeaveBalance for the earned leave balance
   * @param paidLeaveBalance for the paid leave balance
   * @param sickLeaveBalance for the sick leave balance
   * @param optionalLeaveBalance for the optional leave balance
   * @param ld for leaveDetails
   * @throws ParseException for parse exception
   * @return the employee details
   */
  @POST
  @Path("/applyleave/{empId}/{earnedLeaveBalance}/{paidLeaveBalance}/{sickLeaveBalance}/{optionalLeaveBalance}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Status employeeApplyLeave(@PathParam("empId") final int empId,
              @PathParam("earnedLeaveBalance") final int earnedLeaveBalance,
              @PathParam("paidLeaveBalance") final int paidLeaveBalance,
              @PathParam("sickLeaveBalance") final int sickLeaveBalance,
              @PathParam("optionalLeaveBalance") final int optionalLeaveBalance,
      final LeaveDetails ld) throws ParseException {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveType lt = LeaveType.valueOf(ld.getLeaveType());
    Status message = new Status();
    String result = LeaveDetails.applyForLeave(empId, sf.format(ld.getStartDate()), sf.format(ld.getEndDate()),
                          ld.getLeaveReason(), lt, earnedLeaveBalance, paidLeaveBalance,
                          sickLeaveBalance, optionalLeaveBalance);
    message.setMsg(result);
    return message;
  }
  /**
   * Returns updated leave status.
   * @param empId the id of the employee
   * @param response for the response of Manager
   * @param ld for leaveDetails
   * @throws ParseException for parse exception
   * @return the employee details
   */
  @POST
  @Path("/updateLeaveStatus/{empId}/{response}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Status updateLeaveStatus(@PathParam("empId") final int empId,
                                      @PathParam("response") final int response,
                                      final LeaveDetails ld) throws ParseException {
    Status message = new Status();
    LeaveType lt = LeaveType.valueOf(ld.getLeaveType());
    String result = LeaveDetails.updateLeaveStatus(ld.getLeaveId(), ld.getManagerComments(),
                                                  empId, response, lt);
    message.setMsg(result);
    return message;
  }
}
