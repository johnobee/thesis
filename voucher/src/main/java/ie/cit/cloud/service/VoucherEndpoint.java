package ie.cit.cloud.service;

import ie.cit.cloud.pointofsale.LoyaltyResponse;
import ie.cit.cloud.pointofsale.VoucherResponse;
import ie.cit.cloud.pointofsale.SalesTransactionRequest;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class VoucherEndpoint {

	private static final String NAMESPACE_URI = "http://cloud.cit.ie/pointofsale";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "SalesTransactionRequest")
	@ResponsePayload
	public VoucherResponse voucherReward(@RequestPayload SalesTransactionRequest request) {
		System.out.println(request);
		//return new VoucherResponse();
		VoucherResponse test = new VoucherResponse();
		test.setConfirmationNumber("123");
		return test;
	}
}