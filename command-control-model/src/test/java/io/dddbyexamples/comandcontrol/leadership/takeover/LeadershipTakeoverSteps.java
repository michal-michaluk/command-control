package io.dddbyexamples.comandcontrol.leadership.takeover;

import cucumber.api.PendingException;
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
