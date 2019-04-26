package io.dddbyexamples.comandcontrol.leadership.takeover;

import io.dddbyexamples.comandcontrol.ObjectID;

import java.time.Clock;

public class HandoverProcedureFactory {

    // dependency of Factory
    private CommandHierarchy commandHierarchy;

    // dependencies of Domain Objects
    private HandoverProcedure.HandoverProcedureEvents events;
    private Clock clock;

    public HandoverProcedure create(InitialiseTakeover command) {
        ObjectID currentSuperior = commandHierarchy.superiorOf(command.getSubordinate());

        return new HandoverProcedure(
                // dependencies of Domain Objects
                events,
                clock,
                // initial state
                currentSuperior,
                null,
                null
        );
    }
}
