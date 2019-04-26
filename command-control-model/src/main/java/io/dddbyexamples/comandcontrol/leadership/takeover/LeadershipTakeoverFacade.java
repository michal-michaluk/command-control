package io.dddbyexamples.comandcontrol.leadership.takeover;

import java.util.Optional;

public class LeadershipTakeoverFacade {

    private HandoverProcedureFactory factory;
    private HandoverProcedureRepository repository;

    public void initialiseHandover(InitialiseTakeover command) {
        HandoverProcedure procedure = factory.create(command);
        repository.save(procedure);
        procedure.start(command);
    }

    public void commandAccepted(OrderAccepted orderAccepted) {
        Optional<HandoverProcedure> procedureIfPresent = repository.get(orderAccepted);
        if (procedureIfPresent.isPresent()) {
            procedureIfPresent.get().commandAccepted(orderAccepted);
        } else {
            // TODO missing scenario if not present, ask about software reaction
            //throw new IllegalStateException();
        }
    }
}
