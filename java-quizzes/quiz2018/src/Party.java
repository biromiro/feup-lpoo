import com.sun.deploy.net.MessageHeader;

import java.util.HashSet;
import java.util.Set;

public class Party extends Event{

    private Set<Event> partyEvents;

    public Party(String title, String date, String description) {
        super(title, date, description);
        this.partyEvents = new HashSet<Event>();
    }

    public void addEvent(Event e) {
        partyEvents.add(e);
        for(Person person: e.getAudience()){
            super.addPerson(person);
        }
    }
}
