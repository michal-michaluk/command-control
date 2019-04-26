package io.dddbyexamples.comandcontrol.leadership.takeover;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.dddbyexamples.comandcontrol.Aliases;
import io.dddbyexamples.comandcontrol.ObjectID;
import io.dddbyexamples.comandcontrol.commands.SentCommands;
import lombok.Value;

import java.util.List;

public class LeadershipTakeoverSteps {

    private LeadershipTakeoverFacade facade;
    private SentCommands commands;

    private Aliases<ObjectID> objectIds = new Aliases<>();

    @Given("^objects:$")
    public void objects(List<ObjectDef> objects) {
        objects.forEach(object -> objectIds.put(
                object.getAlias(),
                object.getObjectID()
        ));
    }

    @When("^\"([^\"]*)\" requests handover of \"([^\"]*)\"$")
    public void requestsHandoverOf(String newSuperior, String subordinate) throws Throwable {
        InitialiseTakeover command = new InitialiseTakeover(
                objectIds.of(newSuperior),
                objectIds.of(subordinate)
        );
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

    @Given("^\"([^\"]*)\" is controlling unit of \"([^\"]*)\"$")
    public void isControllingUnitOf(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^handover procedure started on \"([^\"]*)\" and addresses \"([^\"]*)\" and \"([^\"]*)\"$")
    public void handoverProcedureStartedOnAndAddressesAnd(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Given Commands of \"([^\"]*)\" contains \"([^\"]*)\"$")
    public void givenCommandsOfContains(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^\"([^\"]*)\" message is send to \"([^\"]*)\"$")
    public void messageIsSendTo(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^handover procedure already started on \"([^\"]*)\" and addresses \"([^\"]*)\" and \"([^\"]*)\"$")
    public void handoverProcedureAlreadyStartedOnAndAddressesAnd(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^no message is send from \"([^\"]*)\"$")
    public void noMessageIsSendFrom(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^not message from \"([^\"]*)\" was received by \"([^\"]*)\"$")
    public void notMessageFromWasReceivedBy(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^handover procedure on \"([^\"]*)\" is in control unit change stage, addressing \"([^\"]*)\" and \"([^\"]*)\"$")
    public void handoverProcedureOnIsInControlUnitChangeStageAddressingAnd(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^\"([^\"]*)\" gives \"([^\"]*)\" Control Unit Change order over radio$")
    public void givesControlUnitChangeOrderOverRadio(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^\"([^\"]*)\" gives \"([^\"]*)\" Handover Request over radio$")
    public void givesHandoverRequestOverRadio(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Value
    public static class ObjectDef {
        String alias;
        long internalID;
        String link16ID;
        String description;

        public ObjectDef(String alias, long internalID, String link16ID, String description) {
            this.alias = alias;
            this.internalID = internalID;
            this.link16ID = link16ID;
            this.description = description;
        }

        public ObjectID getObjectID() {
            return new ObjectID(internalID, link16ID);
        }
    }
}
