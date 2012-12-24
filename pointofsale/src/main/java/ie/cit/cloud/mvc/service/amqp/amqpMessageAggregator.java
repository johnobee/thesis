package ie.cit.cloud.mvc.service.amqp;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.CorrelationStrategy;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ReleaseStrategy;
import ie.cit.cloud.pointofsale.SalesTransactionRequest;
import java.util.Collections;
import java.util.List;
import org.springframework.integration.annotation.Header;
 

  /**
   * Aggregates {@link LoanQuote}s based on the value of the 'RESPONSE_TYPE' message header.
   * When only the <i>best</i> quote is desired, the 'RESPONSE_TYPE' header should have a value
   * of 'BEST'. In this example, that value is set by the 'gateway' when the
   * {@link LoanBrokerGateway#getBestLoanQuote(org.springframework.integration.samples.loanbroker.domain.LoanRequest)}
   * method is invoked by the client.
   * 
   * @author Oleg Zhurakousky
   */

@MessageEndpoint

  public class amqpMessageAggregator {

  	/**
  	 * Aggregates LoanQuote Messages to return a single reply Message.
  	 * 
  	 * @param quotes list of loan quotes received from upstream lenders
  	 * @param responseType header that indicates the response type
  	 * @return the best {@link LoanQuote} if the 'RESPONSE_TYPE' header value is 'BEST' else all quotes
  	 */
	  @Aggregator  
  	public Object aggregateBaskets(List<SalesTransactionRequest> baskets, @Header(value="RESPONSE_TYPE", required=false) String responseType) {
  		//Collections..sort(baskets);
  		return responseType.length();
  		}

  }