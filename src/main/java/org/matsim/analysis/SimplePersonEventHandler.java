package org.matsim.analysis;

import jogamp.graph.font.typecast.ot.table.ID;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.api.core.v01.population.Person;

import java.util.HashMap;
import java.util.Map;

public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {

    private final Map<Id<Person>, Double> personToDepartureTime = new HashMap();

    @Override
    public void handleEvent(PersonDepartureEvent personDepartureEvent) {
        var departureTime = personDepartureEvent.getTime();
        var personId = personDepartureEvent.getPersonId();
                personToDepartureTime.put(personId, departureTime);
        //System.out.println("Departure " + personDepartureEvent.getTime() + personDepartureEvent.getPersonId());
    }

    @Override
    public void handleEvent(PersonArrivalEvent personArrivalEvent) {
        var arrivalTime = personArrivalEvent.getTime();
        var departureTime = personToDepartureTime.get(personArrivalEvent.getPersonId());
        var travelTime = arrivalTime - departureTime;

        System.out.println("Person: " + personArrivalEvent.getPersonId() + "travelled: " + travelTime + "s. ");

        //System.out.println("Arrival: " personArrivalEvent.getTime() + ": " + personArrivalEvent.getPersonId());
    }

}
