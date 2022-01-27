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

public class EmployeeRestTest {

	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException {
		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
		for (Employee e: res) {
			switch (e.getEmpId()) {
				case 1000:
					assertEquals(1000, e.getEmpId());
					break;
				case 2000:
					assertEquals(2000, e.getEmpId());
					break;				
				case 2001:
					assertEquals(2001, e.getEmpId());
					break;				
				case 3000:
					assertEquals(3000, e.getEmpId());
					break;				
				case 3001:
					assertEquals(3001, e.getEmpId());
					break;			
				default:
					fail("Unknown employee with id:" + e);	
			}
		}
	}

	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException, ParseException {
		Employee res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/1000")).getBody().as(Employee.class);
		assertEquals(1000, res.getEmpId());
		assertEquals("Rohit", res.getEmployeeName());
		assertEquals("CEO", res.getDepartmentName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals("2015-02-24", sdf.format(res.getEmployeeDateOfJoining()));
		assertEquals("rohitnair703@gmail.com", res.getEmployeeEmail());
		assertEquals("8806272014", res.getEmployeeContact());
		assertEquals(0, res.getManagerId());
		assertEquals(8, res.getEarnedLeaveBalance());
		assertEquals(5, res.getPaidLeaveBalance());
		assertEquals(6, res.getSickLeaveBalance());
		assertEquals(2, res.getOptionalLeaveBalance());
  }
  
  @Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);
	}


	@Test
	public void testManagerById() throws AssertionError, URISyntaxException, ParseException {
		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/manager/2000")).getBody().as(Employee[].class);
		Employee el = res[0];
		assertEquals(3000, el.getEmpId());
		assertEquals("Pooja", el.getEmployeeName());
		assertEquals("Development", el.getDepartmentName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals("2017-02-08", sdf.format(el.getEmployeeDateOfJoining()));
		assertEquals("poojasharma@gmail.com", el.getEmployeeEmail());
		assertEquals("3321512214", el.getEmployeeContact());
		assertEquals(2000, el.getManagerId());
		assertEquals(8, el.getEarnedLeaveBalance());
		assertEquals(5, el.getPaidLeaveBalance());
		assertEquals(6, el.getSickLeaveBalance());
		assertEquals(2, el.getOptionalLeaveBalance());
  }

}
