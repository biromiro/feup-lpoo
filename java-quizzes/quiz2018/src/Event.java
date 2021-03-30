import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Event {
    private String title;
    private String dateRange;
    private String description;
    private Set<Person> audience;

    public Event(String title) {
        this(title, "", "");
    }

    public Event(String title, String dateRange) {
        this(title, dateRange, "");
    }

    public Event(Event e) {
        this(e.getTitle(), e.getDate(), e.getDescription());
    }

    public Event(String title, String dateRange, String description) {
        this.title = title;
        this.dateRange = dateRange;
        this.description = description;
        this.audience = new HashSet<Person>();
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return dateRange;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setDate(String newDate) {
        this.dateRange = newDate;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    @Override
    public String toString() {
        return  this.title + " is a " +
                this.description + " and will be held at " +
                this.dateRange + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(dateRange, event.dateRange) &&
                Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, dateRange, description);
    }

    public void addPerson(Person newPerson) {
        audience.add(newPerson);
    }

    public int getAudienceCount() {
        return audience.size();
    }

    public Set<Person> getAudience(){
        return audience;
    }
}
