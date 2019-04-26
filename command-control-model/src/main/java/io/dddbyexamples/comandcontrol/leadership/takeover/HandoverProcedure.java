package io.dddbyexamples.comandcontrol.leadership.takeover;

import io.dddbyexamples.comandcontrol.ObjectID;
import io.dddbyexamples.comandcontrol.commands.SentCommands;
import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.Instant;

// Rectangle Yellow Card
@AllArgsConstructor
public class HandoverProcedure {

    // ports
    private final HandoverProcedureEvents events;
    private final Clock clock;

    // state of process
    private ObjectID currentSuperior;
    private HandoverStarted handoverStarted;
    private HandoverAccepted handoverAccepted;

    // emited events: Orange Cards
    interface HandoverProcedureEvents {
        void emit(HandoverStarted event);

        void emit(HandoverAccepted handoverAccepted);
    }

    // Blue Card
    public void start(InitialiseTakeover command) {
        // Rules, Invariants

        // Enrichment
        Instant instant = Instant.now(clock);


        // Orange Card
        handoverStarted = new HandoverStarted(command, currentSuperior, instant);

        // Event consequences
        events.emit(handoverStarted);
    }

    // Pink Card
    public void commandAccepted(OrderAccepted accepted) {
        // Rules, Invariants
        if (accepted.getOriginator().equals(handoverStarted.getCurrentSuperior())) {
            // Enrichment
            Instant instant = Instant.now(clock);

            // Orange Card
            handoverAccepted = new HandoverAccepted(handoverStarted.getCurrentSuperior(), instant);
            // Event consequences
            events.emit(handoverAccepted);
        }
    }
}
