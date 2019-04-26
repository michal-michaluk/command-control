package io.dddbyexamples.comandcontrol.commands;

import io.dddbyexamples.comandcontrol.leadership.takeover.HandoverAccepted;
import io.dddbyexamples.comandcontrol.leadership.takeover.HandoverStarted;

public interface SentCommands {

    CommandState getStatsOf(String commandID);

    void add(HandoverStarted event);

    void add(HandoverAccepted handoverAccepted);
}
