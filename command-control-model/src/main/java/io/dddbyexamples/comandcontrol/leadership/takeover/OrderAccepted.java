package io.dddbyexamples.comandcontrol.leadership.takeover;

import io.dddbyexamples.comandcontrol.ObjectID;
import lombok.Value;

@Value
public class OrderAccepted {
    ObjectID originator;
}
