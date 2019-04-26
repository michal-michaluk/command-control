package io.dddbyexamples.comandcontrol.leadership.takeover;

import io.dddbyexamples.comandcontrol.ObjectID;

public interface CommandHierarchy {
    ObjectID superiorOf(ObjectID objectID);
}
