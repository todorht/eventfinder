package mk.eventfinder.location.domain.model.exception;


public class LocationNotFoundException extends RuntimeException{
    LocationNotFoundException(){
        System.out.println("Location does not exists");
    }
}
