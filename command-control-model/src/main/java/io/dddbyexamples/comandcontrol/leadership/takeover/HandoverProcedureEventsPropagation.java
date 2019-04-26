package io.dddbyexamples.comandcontrol.leadership.takeover;

import io.dddbyexamples.comandcontrol.commands.SentCommands;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class HandoverProcedureEventsPropagation implements HandoverProcedure.HandoverProcedureEvents {

    private final SentCommands sentCommands;
    private final CommunicationChannel communication;

    @Override
    public void emit(HandoverStarted event) {
        sentCommands.add(event);
        communication.send(event);
    }

    @Override
    public void emit(HandoverAccepted event) {
        sentCommands.add(event);
        communication.send(event);
    }
}
