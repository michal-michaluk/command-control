package io.dddbyexamples.comandcontrol.leadership.takeover;

import java.util.Optional;

public interface HandoverProcedureRepository {
    void save(HandoverProcedure procedure);

    Optional<HandoverProcedure> get(OrderAccepted orderAccepted);
}
