package com.hexaware.ftp71.model;

import com.hexaware.ftp71.persistence.LeaveDetailsDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {
  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the leave details class.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testLeaveDetails() throws ParseException {
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    Date startDate = simpleDate.parse("2018-10-15");
    Date endDate = simpleDate.parse("2018-10-20");
    Date appliedOn = simpleDate.parse("2018-09-20");
    Date approvedOn = simpleDate.parse("2018-10-05");

    LeaveDetails leaveDetail1 = new LeaveDetails(1, 100, startDate, endDate, 6, "sick",
                                        appliedOn, approvedOn, "EL", "pending", null);
    LeaveDetails leaveDetail2 = new LeaveDetails(2, 101, startDate, endDate, 6, "sick",
                                        appliedOn, approvedOn, "EL", "pending", null);
    assertNotEquals(leaveDetail1, null);
    assertNotEquals(leaveDetail1, new Integer(100));
    assertEquals(leaveDetail1, new LeaveDetails(1, 100, startDate, endDate, 6, "sick",
                                   appliedOn, approvedOn, "EL", "pending", null));
    assertNotEquals(leaveDetail2, new LeaveDetails(1, 100, startDate, endDate, 6, "sick",
                                   appliedOn, approvedOn, "EL", "pending", null));
    assertEquals(leaveDetail1.getLeaveId(), 1);
    assertEquals(leaveDetail1.getEmployeeId(), 100);
    assertEquals(leaveDetail1.getStartDate(), startDate);
    assertEquals(leaveDetail1.getEndDate(), endDate);
    assertEquals(leaveDetail1.getNoOfLeaves(), 6);
    assertEquals(leaveDetail1.getLeaveReason(), "sick");
    assertEquals(leaveDetail1.getAppliedOn(), appliedOn);
    assertEquals(leaveDetail1.getApprovedOn(), approvedOn);
    assertEquals(leaveDetail1.getLeaveType(), "EL");
    assertEquals(leaveDetail1.getLeaveStatus(), "pending");
    assertEquals(leaveDetail1.getManagerComments(), null);

    LeaveDetails leaveDetail3 = new LeaveDetails();
    leaveDetail3.setLeaveId(1);
    leaveDetail3.setEmployeeId(100);
    leaveDetail3.setStartDate(startDate);
    leaveDetail3.setEndDate(endDate);
    leaveDetail3.setNoOfLeaves(6);
    leaveDetail3.setLeaveReason("sick");
    leaveDetail3.setAppliedOn(appliedOn);
    leaveDetail3.setApprovedOn(approvedOn);
    leaveDetail3.setLeaveType("EL");
    leaveDetail3.setLeaveStatus("pending");
    leaveDetail3.setManagerComments(null);
    assertEquals(leaveDetail1, leaveDetail3);
    assertEquals(leaveDetail1.hashCode(), new LeaveDetails(1, 100, startDate, endDate, 6, "sick", appliedOn,
                                                  approvedOn, "EL", "pending", null).hashCode());
    String res = "LeaveDetails [leaveId=1, employeeId=100,"
           + " startDate=" + startDate
           + ", endDate=" + endDate
           + ", noOfLeaves=6"
           + ", leaveReason=sick"
           + ", appliedOn=" + appliedOn
           + ", approvedOn=" + approvedOn
           + ", leaveType=EL"
           + ", leaveStatus=pending"
           + ", managerComments=null]";
    assertEquals(res, leaveDetail1.toString());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<LeaveDetails>();
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ld = LeaveDetails.listAll();
    assertEquals(0, ld.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parse exception
   */
  @Test
  public final void testListAllSome(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    final Date startDate = simpleDate.parse("2018-10-15");
    final Date endDate = simpleDate.parse("2018-10-20");
    final Date appliedOn = simpleDate.parse("2018-09-20");
    final Date approvedOn = simpleDate.parse("2018-10-05");
    new Expectations() {
      {
        ArrayList<LeaveDetails> ld = new ArrayList<LeaveDetails>();
        ld.add(new LeaveDetails(1, 100, startDate, endDate, 6, "sick",
                                appliedOn, approvedOn, "EL", "approved", null));
        ld.add(new LeaveDetails(2, 200, startDate, endDate, 6, "tour",
                                appliedOn, approvedOn, "EL", "approved", null));
        ld.add(new LeaveDetails(3, 300, startDate, endDate, 6, "sick",
                            appliedOn, approvedOn, "EL", "approved", null));
        dao.list(); result = ld;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ld = LeaveDetails.listAll();
    assertEquals(3, ld.length);
    assertEquals(new LeaveDetails(1, 100, startDate, endDate, 6, "sick",
                                  appliedOn, approvedOn, "EL", "approved", null), ld[0]);
    assertEquals(new LeaveDetails(2, 200, startDate, endDate, 6, "tour",
                                  appliedOn, approvedOn, "EL", "approved", null), ld[1]);
    assertEquals(new LeaveDetails(3, 300, startDate, endDate, 6, "sick",
                                  appliedOn, approvedOn, "EL", "approved", null), ld[2]);
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parse exception
   */
  @Test
  public final void testListById(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    final Date startDate = simpleDate.parse("2018-10-15");
    final Date endDate = simpleDate.parse("2018-10-20");
    final Date appliedOn = simpleDate.parse("2018-09-20");
    final Date approvedOn = simpleDate.parse("2018-10-05");
    final LeaveDetails leaveDetail1 = new LeaveDetails(3, 300, startDate, endDate, 6, "sick",
                                              appliedOn, approvedOn, "EL", "pending", null);
    new Expectations() {
      {
        dao.find(300, 3); result = leaveDetail1;
        dao.find(300, -1); result = null;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails ld = LeaveDetails.listById(300, 3);
    assertEquals(leaveDetail1, ld);

    ld = LeaveDetails.listById(300, -1);
    assertNull(ld);
  }
  /**
   * Tests start date should not be before current date of the leave details class.
   * @param dao mocking the dao class
   */

  @Test
  public final void testApplyLeave(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        try {
          String startDate1 = "2019-09-15";
          String endDate1 = "2019-09-20";
          int empId1 = 105;
          int duration1 = 5;
          String empReason1 = "Vacation";
          Date currenDate = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String currentDate = sdf.format(currenDate);
          dao.applyForLeave(105, startDate1, endDate1, empReason1, LeaveType.EL, duration1, currentDate);
        } catch (Exception e) {
          System.out.println(e);
        }
      }
    };
    new Expectations() {
      {
        dao.recordCount(1, "2018-09-27", "2018-09-28"); result = 1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String str1 = LeaveDetails.applyForLeave(105, "2019-09-15", "2019-09-20", "Vacation",
                                 LeaveType.EL, 24, 24, 12, 2);
      assertEquals("Leave Successfully Applied", str1);
      String str2 = LeaveDetails.applyForLeave(106, "2018-07-15", "2018-07-20", "Vacation",
                                LeaveType.EL, 24, 24, 12, 2);
      assertEquals("Start Date Cannot be Before Current Date", str2);
      String str3 = LeaveDetails.applyForLeave(107, "2018-09-22", "2018-07-20", "Vacation",
                               LeaveType.EL, 24, 24, 12, 2);
      assertEquals("End Date Cannot be Before Start Date", str3);
      String str4 = LeaveDetails.applyForLeave(106, "2018-09-25", "2018-10-31", "Vacation",
                                LeaveType.SL, 24, 24, 12, 2);
      assertEquals("Sorry You Can't Apply New Leave Application", str4);
      String str5 = LeaveDetails.applyForLeave(1, "2018-09-27", "2018-09-28", "Vacation",
                                LeaveType.EL, 24, 24, 12, 2);
      assertEquals("Leave is already applied for this period", str5);
      /*String str6 = LeaveDetails.applyForLeave(1, "2019-10-18", "2019-10-18", "Vacation",
                                 LeaveType.OL, 24, 24, 12, 2);
      assertEquals("You Can't apply more than two Optional Leave", str6);*/
    } catch (ParseException e) {
      System.out.println(e);
    }
  }
   /**
   * Tests that a fetch of a specific Leave history works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parse exception
   */
  @Test
  public final void testLeaveHistory(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    final Date startDate = simpleDate.parse("2018-10-18");
    final Date endDate = simpleDate.parse("2018-10-19");
    final Date appliedOn = simpleDate.parse("2018-10-15");
    final Date approvedOn = simpleDate.parse("2018-10-16");

    final Date startDate1 = simpleDate.parse("2018-11-11");
    final Date endDate1 = simpleDate.parse("2018-11-15");
    final Date appliedOn1 = simpleDate.parse("2018-11-01");
    final Date approvedOn1 = simpleDate.parse("2018-11-05");

    final Date startDate2 = simpleDate.parse("2018-12-20");
    final Date endDate2 = simpleDate.parse("2018-12-25");
    final Date appliedOn2 = simpleDate.parse("2018-12-15");
    final Date approvedOn2 = simpleDate.parse("2018-12-16");

    new Expectations() {
      {
        ArrayList<LeaveDetails> leave = new ArrayList<LeaveDetails>();
        leave.add(new LeaveDetails(1, 100, startDate, endDate, 2, "Sick", appliedOn, approvedOn,
                                    "EL", "pending", ""));
        dao.getLeaveHistory(100); result = leave;
        ArrayList<LeaveDetails> leave1 = new ArrayList<LeaveDetails>();
        leave1.add(new LeaveDetails(2, 101, startDate1, endDate1, 6, "Family Function", appliedOn1, approvedOn1,
                                    "EL", "approved", ""));
        leave1.add(new LeaveDetails(3, 101, startDate2, endDate2, 6, "Christmas", appliedOn2, approvedOn2,
                                    "EL", "pending", ""));
        dao.getLeaveHistory(101); result = leave1;
        dao.getLeaveHistory(-100); result = null;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    List<LeaveDetails> ld = LeaveDetails.getLeaveHistory(100);
    ArrayList<LeaveDetails> leave2 = new ArrayList<LeaveDetails>();
    leave2.add(new LeaveDetails(1, 100, startDate, endDate, 2, "Sick", appliedOn, approvedOn,
                                         "EL", "pending", ""));
    assertEquals(ld, leave2);
    List<LeaveDetails> ld1 = LeaveDetails.getLeaveHistory(101);
    ArrayList<LeaveDetails> leave3 = new ArrayList<LeaveDetails>();
    leave3.add(new LeaveDetails(2, 101, startDate1, endDate1, 5, "Sick", appliedOn1, approvedOn1,
                                         "EL", "approved", ""));
    leave3.add(new LeaveDetails(3, 101, startDate2, endDate2, 4, "Christmas", appliedOn2, approvedOn2,
                                         "EL", "pending", ""));
    assertNotEquals(ld1, leave3);
    List<LeaveDetails> ld2 = LeaveDetails.getLeaveHistory(-100);
    assertNull(ld2);
  }
  /**
   * Tests that a fetch of a specific leave details works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parse exception
   */
  @Test
  public final void testPendingStatusList(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    final Date startDate = simpleDate.parse("2018-11-05");
    final Date endDate = simpleDate.parse("2018-11-10");
    final Date startDate1 = simpleDate.parse("2018-10-05");
    final Date endDate1 = simpleDate.parse("2018-10-10");
    final Date appliedOn = simpleDate.parse("2018-11-01");
    final Date approvedOn = simpleDate.parse("2018-11-02");
    final List<LeaveDetails> ld1 = new ArrayList<LeaveDetails>();
    ld1.add(new LeaveDetails(1, 2000, startDate, endDate, 5, "Sick", appliedOn,
                                       null, "EL", "pending", "good"));
    ld1.add(new LeaveDetails(2, 2000, startDate1, endDate1, 5, "Sick", appliedOn,
                                       null, "EL", "approved", "good"));
    new Expectations() {
      {
        dao.pendingStatusList(2000); result = ld1.get(0);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    List<LeaveDetails> ld = new ArrayList<LeaveDetails>();
    ld.add(new LeaveDetails(1, 2000, startDate, endDate, 5, "Sick", appliedOn,
                                       null, "EL", "pending", "good"));
    ld.add(new LeaveDetails(2, 2000, startDate1, endDate1, 5, "Sick", appliedOn,
                                       null, "EL", "approved", "good"));
    List<LeaveDetails> l = LeaveDetails.pendingStatusList(2000);
    assertEquals(ld.get(0), l.get(0));
    assertNotEquals(ld, l);
  }

  /**
   * Tests the status is approved or denied.
   * @param dao mocking with the dao class
   */
  @Test
  public final void testUpdateLeaveStatus(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
        {
          dao.updateLeaveStatus(20, "enjoy holiday", LeaveStatus.approved, 300); result = 1;
          dao.updateLeaveStatus(21, "no holiday", LeaveStatus.denied, 200); result = 2;
          //dao.updateLeaveStatus(22, "no holiday", LeaveStatus.denied, 100); result = 2;
          //dao.updateLeaveStatus(23, "no holiday", LeaveStatus.denied, 300); result = 2;
          //dao.updateLeaveStatus(24, "no holiday", LeaveStatus.denied, 400); result = 2;
        }
    };
    new Expectations() {
        {
          dao.updateOptionalLeaveBalance(200, 21); result = 1;
          //dao.updateEarnedLeaveBalance(100, 22);
          //dao.updatePaidLeaveBalance(300, 23);
          //dao.updateSickLeaveBalance(400, 24);
        }
    };
    new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
            return dao;
          }
    };
    String resultApproved = LeaveDetails.updateLeaveStatus(20, "enjoy holiday", 300, 1, LeaveType.EL);
    String resultDenied = LeaveDetails.updateLeaveStatus(21, "no holiday", 200, 2, LeaveType.OL);
    //String resultDenied2 = LeaveDetails.updateLeaveStatus(22, "no holiday", 100, 2, LeaveType.EL);
    //String resultDenied3 = LeaveDetails.updateLeaveStatus(23, "no holiday", 300, 2, LeaveType.PL);
    //String resultDenied4 = LeaveDetails.updateLeaveStatus(24, "no holiday", 400, 2, LeaveType.SL);
    assertEquals("Leave Id 20 Leave Status Updated As approved", resultApproved);
    assertEquals("Leave Id 21 Leave Status Updated As denied", resultDenied);
    //assertEquals("Leave Id 22 Leave Status Updated As denied", resultDenied2);
    //assertEquals("Leave Id 23 Leave Status Updated As denied", resultDenied3);
    //assertEquals("Leave Id 24 Leave Status Updated As denied", resultDenied4);
  }
  /**
   * Tests the status is approved or denied.
   * @param dao mocking with the dao class
   * @throws ParseException for parse exception
   */
  @Test
  public final void testSetStatus(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    new Expectations() {
        {
          Date currenDate = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String currentDate = sdf.format(currenDate);
          final Date startDate = sdf.parse("2018-10-15");
          final Date endDate = sdf.parse("2018-10-20");
          final Date appliedOn = sdf.parse("2018-10-15");
          dao.applyForLeave(1000, "2018-10-15", "2018-10-20", "Marriage", LeaveType.EL, 5, currentDate);
          ArrayList<LeaveDetails> leave = new ArrayList<LeaveDetails>();
          leave.add(new LeaveDetails(1, 100, startDate, endDate, 2, "Sick", appliedOn, null,
                                    "EL", "pending", ""));
          dao.getLeaveHistory(1000); result = leave;
          dao.setStatus(LeaveStatus.approved, currentDate, 1);
        }
    };
    new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
            return dao;
          }
    };
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String str = LeaveDetails.applyForLeave(1000, "2018-10-15", "2018-10-20", "Marriage",
                         LeaveType.EL, 24, 24, 12, 2);
      assertEquals("Leave Successfully Applied", str);
    } catch (ParseException e) {
      System.out.println(e);
    }
  }
}
