package io.dddbyexamples.comandcontrol.leadership.takeover;

import io.dddbyexamples.comandcontrol.ObjectID;
import lombok.Value;

import java.time.Instant;

@Value
public class HandoverStarted {
    InitialiseTakeover command;
    ObjectID currentSuperior;
    Instant now;
}
