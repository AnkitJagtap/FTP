package com.hexaware.ftp71.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp71.model.LeaveDetails;
/**
 * Mapper class to map from result set to leave details object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    /**
     * @return LeaveDetail
     */
    return new LeaveDetails(rs.getInt("LEAVE_ID"),
                            rs.getInt("EMP_ID"),
                            rs.getDate("START_DATE"),
                            rs.getDate("END_DATE"),
                            rs.getInt("NO_OF_LEAVES"),
                            rs.getString("LEAVE_REASON"),
                            rs.getDate("APPLIED_ON"),
                            rs.getDate("APPROVED_ON"),
                            rs.getString("LEAVE_TYPE"),
                            rs.getString("LEAVE_STATUS"),
                            rs.getString("MANAGER_COMMENTS"));
  }
}
