package com.vailsys.persephony.webhooks;

import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.api.call.Direction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class PersyRequestTest {
	private PersyRequest pr;

	@Given("^Given Some JSON create a PersyRequest$")
	public void createPersyRequest() throws Throwable {
		this.pr = PersyRequest.fromJson("{ \"accountId\": \"ACae05391ecca1352e9108d545482a1e6f384e7a49\", \"callId\": \"CAbde0362aef3d228b3a39baafa9e4f0204e724966\", \"callStatus\": \"ringing\", \"conferenceId\": null, \"direction\": \"inbound\", \"from\": \"+17083168669\", \"queueId\": null, \"requestId\": \"RQ0c74d2e880709c85e8a4e3093b85b910eee4110b\", \"requestType\": \"inboundCall\", \"to\": \"+12248806211\" }");
	}	

	@Then("^verify the PersyRequest contents$")
	public void verifyContents() {
		assertThat(this.pr.getAccountId(), is("ACae05391ecca1352e9108d545482a1e6f384e7a49"));
		assertThat(this.pr.getCallId(), is("CAbde0362aef3d228b3a39baafa9e4f0204e724966"));
		assertThat(this.pr.getCallStatus(), is(CallStatus.RINGING));
		assertThat(this.pr.getConferenceId(), is(nullValue()));
		assertThat(this.pr.getDirection(), is(Direction.INBOUND));
		assertThat(this.pr.getFrom(), is("+17083168669"));
		assertThat(this.pr.getQueueId(), is(nullValue()));
		assertThat(this.pr.getRequestId(), is("RQ0c74d2e880709c85e8a4e3093b85b910eee4110b"));
		assertThat(this.pr.getRequestType(), is("inboundCall"));
		assertThat(this.pr.getTo(), is("+12248806211"));
	}
}
