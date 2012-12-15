package ie.cit.cloud.service;
import ie.cit.cloud.pointofsale.SalesTransactionRequest;
import ie.cit.cloud.pointofsale.PromotionResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class PromotionEndpoint {

	private static final String NAMESPACE_URI = "http://cloud.cit.ie/pointofsale";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "salesTransactionRequest")
	@ResponsePayload
	public PromotionResponse promotionAvailableReward(@RequestPayload SalesTransactionRequest request) {
		System.out.println(request);
		return new PromotionResponse();
	}
}