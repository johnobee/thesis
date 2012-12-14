package ie.cit.cloud.service;

import ie.cit.cloud.creditcard.CreditcardRequest;
import ie.cit.cloud.creditcard.CreditcardResponse;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CreditcardEndpoint {

	private static final String NAMESPACE_URI = "http://cloud.cit.ie/pointofsale";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "creditcardRequest")
	@ResponsePayload
	public CreditcardResponse creditcardAuth(@RequestPayload CreditcardRequest request) {
		System.out.println(request);
		return new CreditcardResponse();
	}
}