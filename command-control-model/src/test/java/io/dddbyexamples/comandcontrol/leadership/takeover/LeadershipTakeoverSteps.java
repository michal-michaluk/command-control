package io.dddbyexamples.comandcontrol.leadership.takeover;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class LeadershipTakeoverSteps {

    @When("^\"([^\"]*)\" requests handover of \"([^\"]*)\"$")
    public void requestsHandoverOf(String newSuperior, String subordinate) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^\"([^\"]*)\" message from \"([^\"]*)\" is received by \"([^\"]*)\"$")
    public void messageFromIsReceivedBy(String messageType, String from, String to) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Status message from \"([^\"]*)\" confirming \"([^\"]*)\" as CU is received by \"([^\"]*)\"$")
    public void statusMessageFromConfirmingAsCUIsReceivedBy(String from, String superior, String to) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^handover procedure is confirmed on \"([^\"]*)\" and addresses \"([^\"]*)\" and \"([^\"]*)\"$")
    public void handoverProcedureIsConfirmedOnAndAddressesAnd(String newSuperior, String currentSuperior, String subordinate) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
