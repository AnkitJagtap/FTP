package com.hexaware.ftp71.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class LeaveDetailsRestTest {

@Test
  public void testStartDate() throws AssertionError, URISyntaxException {
    Status obj = new Status();
    obj = given().accept(ContentType.JSON).contentType("application/json").body("{\"startDate\":\"2018-03-30\",\"endDate\":\"2018-03-30\",\"leaveReason\":\"party\",\"leaveType\":\"EL\"}").
    when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/2000/24")).getBody().as(Status.class);
    System.out.println(obj.getMsg());
    assertEquals("Start Date Cannot be Before Current Date", obj.getMsg());
  }
@Test
  public void testEndDate() throws AssertionError, URISyntaxException {
    Status obj = new Status();
    obj = given().accept(ContentType.JSON).contentType("application/json").body("{\"startDate\":\"2018-10-30\",\"endDate\":\"2018-09-31\",\"leaveReason\":\"party\",\"leaveType\":\"EL\"}").
    when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/2000/24")).getBody().as(Status.class);
    System.out.println(obj.getMsg());
    assertEquals("End Date Cannot be Before Start Date", obj.getMsg());
  }
@Test
  public void testBalance() throws AssertionError, URISyntaxException {
    Status obj = new Status();
    obj = given().accept(ContentType.JSON).contentType("application/json").body("{\"startDate\":\"2019-10-01\",\"endDate\":\"2019-10-30\",\"leaveReason\":\"party\",\"leaveType\":\"EL\"}").
    when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/2000/24")).getBody().as(Status.class);
    System.out.println(obj.getMsg());
    assertEquals("No Sufficient Leave Available", obj.getMsg());
  }
@Test
  public void testApplyLeave() throws AssertionError, URISyntaxException {
    Status obj = new Status();
    obj = given().accept(ContentType.JSON).contentType("application/json").body("{\"startDate\":\"2031-12-01\",\"endDate\":\"2031-12-02\",\"leaveReason\":\"party\",\"leaveType\":\"EL\"}").
    when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/3000/20")).getBody().as(Status.class);
    System.out.println(obj.getMsg());
    assertEquals("Leave Successfully Applied", obj.getMsg());
  }
@Test
  public void testLeaveAlreadyApplied() throws AssertionError, URISyntaxException {
    Status obj = new Status();
    obj = given().accept(ContentType.JSON).contentType("application/json").body("{\"startDate\":\"2018-10-15\",\"endDate\":\"2018-10-18\",\"leaveReason\":\"Personal\",\"leaveType\":\"EL\"}").
    when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/3000/20")).getBody().as(Status.class);
    System.out.println(obj.getMsg());
    assertEquals("Leave is already applied for this period", obj.getMsg());

}

@Test
  public void testLeaveStatusApprove() throws AssertionError, URISyntaxException {
    Status obj = new Status();
    obj = given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveId\":\"5\",\"managerComments\":\"go\"}").
    when().post(CommonUtil.getURI("/api/leaveDetails/updateLeaveStatus/3001/1")).getBody().as(Status.class);
    System.out.println(obj.getMsg());
    assertEquals("Leave Id 5 Leave Status Updated As approved", obj.getMsg());
  }

@Test
  public void testLeaveStatusDeny() throws AssertionError, URISyntaxException {
    Status obj = new Status();
    obj = given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveId\":\"3\",\"managerComments\":\"no\"}").
    when().post(CommonUtil.getURI("/api/leaveDetails/updateLeaveStatus/2001/2")).getBody().as(Status.class);
    System.out.println(obj.getMsg());
    assertEquals("Leave Id 3 Leave Status Updated As denied", obj.getMsg());
  }

@Test
	public void testLeaveDetailsList() throws AssertionError, URISyntaxException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails")).getBody().as(LeaveDetails[].class);
		for (LeaveDetails ld: res) {
			switch (ld.getEmployeeId()) {
				case 1000:
					assertEquals(1000, ld.getEmployeeId());
					break;
				case 2000:
					assertEquals(2000, ld.getEmployeeId());
					break;				
				case 2001:
					assertEquals(2001, ld.getEmployeeId());
					break;				
				case 3000:
					assertEquals(3000, ld.getEmployeeId());
					break;				
				case 3001:
					assertEquals(3001, ld.getEmployeeId());
					break;			
				default:
					fail("Unknown employee with id:" + ld);	
			}
		}
	}

    @Test
	public void testLeaveDetailsById() throws AssertionError, URISyntaxException, ParseException {
		LeaveDetails res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/2000/1")).getBody().as(LeaveDetails.class);
		assertEquals(1, res.getLeaveId());
        assertEquals(2000, res.getEmployeeId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("2018-09-07", sdf.format(res.getStartDate()));
        
        assertEquals("2018-09-09", sdf.format(res.getEndDate()));
        assertEquals(3, res.getNoOfLeaves());
        assertEquals("sick", res.getLeaveReason());
       
        assertEquals("2018-09-06", sdf.format(res.getAppliedOn()));
       
        assertEquals(null, res.getApprovedOn());

        assertEquals("EL", res.getLeaveType());
        assertEquals("pending", res.getLeaveStatus());
        assertEquals(null , res.getManagerComments());
  }
  
  @Test
	public void testLeaveDetailseById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/9999")).then().assertThat().statusCode(404);
	}

    @Test
	public void testLeaveDetailsHistory() throws AssertionError, URISyntaxException, ParseException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/leaveHistory/1000")).getBody().as(LeaveDetails[].class);
        LeaveDetails ld1 = res[0];
        assertEquals(2, ld1.getLeaveId());
        assertEquals(1000, ld1.getEmployeeId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("2018-09-10", sdf.format(ld1.getStartDate()));
        
        assertEquals("2018-09-15", sdf.format(ld1.getEndDate()));
        assertEquals(6, ld1.getNoOfLeaves());
        assertEquals("asdf", ld1.getLeaveReason());
       
        assertEquals("2018-09-06", sdf.format(ld1.getAppliedOn()));
       
        assertEquals(null, ld1.getApprovedOn());

        assertEquals("EL", ld1.getLeaveType());
        assertEquals("approved", ld1.getLeaveStatus());
        assertEquals(null , ld1.getManagerComments());
    }

    @Test
	public void testPendingStatus() throws AssertionError, URISyntaxException, ParseException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/pendingStatus/2000")).getBody().as(LeaveDetails[].class);
        LeaveDetails ld1 = res[0];
        assertEquals(4, ld1.getLeaveId());
        assertEquals(3000, ld1.getEmployeeId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("2018-10-15", sdf.format(ld1.getStartDate()));
        
        assertEquals("2018-10-18", sdf.format(ld1.getEndDate()));
        assertEquals(4, ld1.getNoOfLeaves());
        assertEquals("Personal", ld1.getLeaveReason());
       
        assertEquals("2018-09-11", sdf.format(ld1.getAppliedOn()));
       
        assertEquals(null, ld1.getApprovedOn());

        assertEquals("EL", ld1.getLeaveType());
        assertEquals("pending", ld1.getLeaveStatus());
        assertEquals(null , ld1.getManagerComments());
    }
}

