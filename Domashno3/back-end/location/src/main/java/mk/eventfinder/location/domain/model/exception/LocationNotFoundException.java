package mk.eventfinder.location.domain.model.exception;


public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(){
        System.out.println("Location does not exists");
    }
}
