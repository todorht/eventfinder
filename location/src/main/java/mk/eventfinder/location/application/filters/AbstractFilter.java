package mk.eventfinder.location.application.filters;

import mk.eventfinder.location.application.vto.ValueObject;

public abstract class AbstractFilter<I extends ValueObject, O extends ValueObject> {

    public abstract boolean transform(I input);

}
