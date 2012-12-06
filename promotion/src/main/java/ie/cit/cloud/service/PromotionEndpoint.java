package ie.cit.cloud.service;
import ie.cit.cloud.promotion.PromotionRequest;
import ie.cit.cloud.promotion.PromotionResponse;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PromotionEndpoint {

	private static final String NAMESPACE_URI = "http://cloud.cit.ie/promotion";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "promotionRequest")
	@ResponsePayload
	public PromotionResponse promotionAvailableReward(@RequestPayload PromotionRequest request) {
		System.out.println(request);
		return new PromotionResponse();
	}
}