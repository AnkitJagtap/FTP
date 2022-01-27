package com.hexaware.ftp71.model;
import com.hexaware.ftp71.persistence.EmployeeDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {
  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   * @throws ParseException for parse exception
   */
  @Test
  public final void testEmployee() throws ParseException {
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    Date joiningDate = simpleDate.parse("2018-10-18");

    Employee e100 = new Employee(100, "sachitapatil", "Finance", joiningDate,
                                "sachitapatil@gmail.com", "339522014", 1000, 8, 5, 6, 2);
    Employee e101 = new Employee(101, "Pranav", "Administration", joiningDate,
                                 "pranavjalan@gmail.com", "8806275456", 1000, 8, 5, 6, 2);
    assertNotEquals(e100, null);
    assertNotEquals(e100, new Integer(100));
    assertEquals(e100, new Employee(100, "sachitapatil", "Finance", joiningDate,
                           "sachitapatil@gmail.com", "339522014", 1000, 8, 5, 6, 2));
    assertNotEquals(e101, new Employee(100, "sachitapatil", "Finance", joiningDate,
                           "sachitapatil@gmail.com", "339522014", 1000, 8, 5, 6, 2));
    assertEquals(e100.getEmpId(), 100);
    assertEquals(e100.getEmployeeName(), "sachitapatil");
    assertEquals(e100.getDepartmentName(), "Finance");
    assertEquals(e100.getEmployeeDateOfJoining(), joiningDate);
    assertEquals(e100.getEmployeeEmail(), "sachitapatil@gmail.com");
    assertEquals(e100.getEmployeeContact(), "339522014");
    assertEquals(e100.getManagerId(), 1000);
    assertEquals(e100.getEarnedLeaveBalance(), 8);
    assertEquals(e100.getPaidLeaveBalance(), 5);
    assertEquals(e100.getSickLeaveBalance(), 6);
    assertEquals(e100.getOptionalLeaveBalance(), 2);
    Employee e103 = new Employee();
    e103.setEmpId(100);
    e103.setEmployeeName("sachitapatil");
    e103.setDepartmentName("Finance");
    e103.setEmployeeDateOfJoining(joiningDate);
    e103.setEmployeeEmail("sachitapatil@gmail.com");
    e103.setEmployeeContact("339522014");
    e103.setManagerId(1000);
    e103.setEarnedLeaveBalance(8);
    e103.setPaidLeaveBalance(5);
    e103.setSickLeaveBalance(6);
    e103.setOptionalLeaveBalance(2);
    assertEquals(e100, e103);
    assertEquals(e103, new Employee(100, "sachitapatil", "Finance", joiningDate,
                                    "sachitapatil@gmail.com", "339522014", 1000, 8, 5, 6, 2));
    assertEquals(e100.hashCode(), new Employee(100, "sachitapatil", "Finance", joiningDate,
                                    "sachitapatil@gmail.com", "339522014", 1000, 8, 5, 6, 2).hashCode());
    String res = "Employee [empId=100, employeeName=sachitapatil, departmentName=Finance,"
           + " employeeDateOfJoining=" + joiningDate
           + ", employeeEmail=sachitapatil@gmail.com, employeeContact=339522014,"
           + " managerId=1000, earnedLeaveBalance=8, paidLeaveBalance=5, sickLeaveBalance=6,"
           + " optionalLeaveBalance=2]";
    assertEquals(res, e100.toString());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parse exception
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    final Date joiningDate = simpleDate.parse("2018-10-18");
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1, "poojasharma", "developer", joiningDate,
                            "poojasharma@gmail.com", "9680667380", 10, 8, 5, 6, 2));
        es.add(new Employee(10, "rohitnair", "bi", joiningDate,
                            "rohitnair@gmail.com", "9415803471", 100, 8, 5, 6, 2));
        es.add(new Employee(100, "pranavjalan", "Database", joiningDate,
                            "pranavjalan@gmail.com", "800652477", 1, 8, 5, 6, 2));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1, "poojasharma", "developer", joiningDate,
                            "poojasharma@gmail.com", "9680667380", 10, 8, 5, 6, 2), es[0]);
    assertEquals(new Employee(10, "rohitnair", "bi", joiningDate,
                            "rohitnair@gmail.com", "9415803471", 100, 8, 5, 6, 2), es[1]);
    assertEquals(new Employee(100, "pranavjalan", "Database", joiningDate,
                            "pranavjalan@gmail.com", "800652477", 1, 8, 5, 6, 2), es[2]);
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parse exception
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    final Date joiningDate = simpleDate.parse("2018-10-18");
    final Employee e100 = new Employee(100, "pranavjalan", "Database", joiningDate,
                            "pranavjalan@gmail.com", "800652477", 1, 8, 5, 6, 2);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }

  /**
   * Tests that a fetch of a specific leave details works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parse exception
   */
  @Test
  public final void testGetManagerById(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    final Date joiningDate = simpleDate.parse("2018-11-05");
    final Employee e100 = new Employee(2000, "rohit", "BI", joiningDate, "rohitnair@gmail.com", "7896541230",
                                        1000, 8, 5, 6, 2);
    new Expectations() {
      {
        dao.getManagerById(1000); result = e100;
        dao.getManagerById(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    List<Employee> e = Employee.getManagerById(1000);
    assertEquals(e100, e.get(0));

    List<Employee> e2 = Employee.getManagerById(-1);
    assertNull(e2);
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testUpdateEarnedLeaveBalance(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.updateEarnedLeaveBalance(20, 100); result = 1;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    int e = Employee.updateEarnedLeaveBalance(20, 100);
    assertEquals(1, e);
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testUpdatePaidLeaveBalance(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.updatePaidLeaveBalance(20, 100); result = 1;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    int e = Employee.updatePaidLeaveBalance(20, 100);
    assertEquals(1, e);
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testUpdateSickLeaveBalance(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.updateSickLeaveBalance(20, 100); result = 1;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    int e = Employee.updateSickLeaveBalance(20, 100);
    assertEquals(1, e);
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testUpdateOptionalLeaveBalance(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.updateOptionalLeaveBalance(20, 100); result = 1;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    int e = Employee.updateOptionalLeaveBalance(20, 100);
    assertEquals(1, e);
  }
}
