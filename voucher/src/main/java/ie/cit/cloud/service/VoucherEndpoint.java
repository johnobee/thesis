package ie.cit.cloud.service;
import ie.cit.cloud.voucher.VoucherRequest;
import ie.cit.cloud.voucher.VoucherResponse;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class VoucherEndpoint {

	private static final String NAMESPACE_URI = "http://cloud.cit.ie/voucher";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "voucherRequest")
	@ResponsePayload
	public VoucherResponse voucherReward(@RequestPayload VoucherRequest request) {
		System.out.println(request);
		return new VoucherResponse();
	}
}