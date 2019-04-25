package io.dddbyexamples.comandcontrol.leadership.takeover;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.dddbyexamples.comandcontrol.commands.GivenCommands;

public class LeadershipTakeoverSteps {

    private LeadershipTakeoverFacade facade;
    private GivenCommands commands;

    @When("^\"([^\"]*)\" requests handover of \"([^\"]*)\"$")
    public void requestsHandoverOf(String newSuperior, String subordinate) throws Throwable {
        InitialiseHandover command = null;
        facade.initialiseHandover(command);
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

    @Then("^status of \"([^\"]*)\" on \"([^\"]*)\"s Given Commands changes to \"([^\"]*)\"$")
    public void statusOfOnSGivenCommandsChangesTo(String commandID, String originObject, String status) throws Throwable {
        commands.getStatsOf(commandID);

        throw new PendingException();
    }
}
