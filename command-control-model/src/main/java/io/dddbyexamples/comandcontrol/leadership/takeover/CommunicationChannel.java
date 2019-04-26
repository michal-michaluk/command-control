package io.dddbyexamples.comandcontrol.leadership.takeover;

public interface CommunicationChannel {
    void send(HandoverStarted event);

    void send(HandoverAccepted handoverAccepted);
}
