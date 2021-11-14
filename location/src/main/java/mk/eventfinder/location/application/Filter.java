package mk.eventfinder.location.application;

import mk.eventfinder.location.application.vto.ValueObject;

public abstract class Filter<I extends ValueObject, O extends ValueObject> {
    I input;
    O output;

    public Filter(I input, O output) {
        this.input = input;
        this.output = output;
    }

    public abstract O transform();
}
