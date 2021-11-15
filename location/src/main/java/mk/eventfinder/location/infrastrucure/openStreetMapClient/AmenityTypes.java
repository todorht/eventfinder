package mk.eventfinder.location.infrastrucure.openStreetMapClient;

public enum AmenityTypes {
    ARTS_CENTRE("arts_centre"),
    BAR("bar"),
    CAFE("cafe"),
    CINEMA("cinema"),
    COMMUNITY_CENTRE("community_centre"),
    CONFERENCE_CENTRE("conference_centre"),
    EVENTS_VENUE("events_venue"),
    NIGHT_CLUB("night_club"),
    RESTAURANT("restaurant"),
    SOCIAL_CENTRE("social_centre"),
    THEATRE("theatre");

    public String value;

    AmenityTypes (String value) {
        this.value = value;
    }

    public boolean equals(String value) {
        return this.value.equals(value);
    }
}