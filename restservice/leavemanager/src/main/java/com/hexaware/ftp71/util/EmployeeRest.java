package com.hexaware.ftp71.util;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.ftp71.model.Employee;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/employees")
public class EmployeeRest {

  /**
   * Returns a list of all the employees.
   * @return a list of all the employees
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee[] employeesList() {
    System.out.println("Employees List");
    final Employee[] employees = Employee.listAll();
    return employees;
  }

  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee employeeListById(@PathParam("id") final int id) {
    final Employee empl = Employee.listById(id);
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    }
    return empl;
  }

  /**
   * Returns a specific employee's details.
   * @param managerId the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/manager/{managerId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Employee> getManagerById(@PathParam("managerId") final int managerId) {
    final List<Employee> empl = Employee.getManagerById(managerId);
    if (empl == null) {
      throw new NotFoundException("No such Manager ID: " + managerId);
    }
    return empl;
  }

}
