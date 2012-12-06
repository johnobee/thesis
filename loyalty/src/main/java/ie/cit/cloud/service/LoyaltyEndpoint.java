package ie.cit.cloud.service;
import ie.cit.cloud.loyalty.LoyaltyRequest;
import ie.cit.cloud.loyalty.LoyaltyResponse;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoyaltyEndpoint {

	private static final String NAMESPACE_URI = "http://cloud.cit.ie/loyalty";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "promotionRequest")
	@ResponsePayload
	public LoyaltyResponse loyaltyAvailableResponse(@RequestPayload LoyaltyRequest request) {
		System.out.println(request);
		return new LoyaltyResponse();
	}
}