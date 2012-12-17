package ie.cit.cloud.mvc.service.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import ie.cit.cloud.mvc.model.LogEntry;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

	 
	/**
	 * Service for processing LogEntries. 
	 * <p>
	 
	 
	 * For a complete reference to Spring JDBC and JdbcTemplate
	 * see http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/jdbc.html
	 * <p>
	 
	 
	 * For transactions, see http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/transaction.html
	 */
	@Service("logEntryService")
	@Transactional	
	public class LogEntryService {
	 
	 protected static Logger logger = Logger.getLogger("service");
	  
	 private SimpleJdbcTemplate jdbcTemplate;
	  
	 @Resource(name="dataSource")
	 public void setDataSource(DataSource dataSource) {
	     this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	 }
	 
	 /**
	  * Retrieves all log entries
	  * 
	  * @return a list of log entries
	  */
	 public List<LogEntry> getAll() {
	  logger.debug("Retrieving all log entries");
	   
	  // Prepare our SQL statement
	  String sql = "select lo_message_start_time, lo_message_end_time, lo_message_channel,lo_message_service, lo_message_timestamp from lot_lu_loadtest_logger";
	   
	  /*
	   CREATE TABLE lot_lu_loadtest_logger
(
  id serial NOT NULL,
  lo_message_start_time character varying(250),
  lo_message_end_time character varying(250),
  lo_message_channel character varying(250),
  lo_message_service character varying(250),
  lo_message_timestamp timestamp without time zone,
  CONSTRAINT lot_lu_loadtest_logger_pkey PRIMARY KEY (id)
)p;
		*/  
	  // Maps a SQL result to a Java object
	  RowMapper<LogEntry> mapper = new RowMapper<LogEntry>() {  
	         public LogEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
	          LogEntry logentry = new LogEntry();
	          logentry.setLo_message_start_time(rs.getString("lo_message_start_time"));
	          logentry.setLo_message_end_time(rs.getString("lo_message_end_time"));
	          logentry.setLo_message_channel(rs.getString("lo_message_channel"));
	          logentry.setLo_message_service(rs.getString("lo_message_service"));
	          logentry.setLo_message_timestamp(rs.getString("lo_message_timestamp"));
	          return logentry;
	         }
	     };
	   
	  // Retrieve all
	  return jdbcTemplate.query(sql, mapper);
	 }
	  


	}