import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {

    private String location;
    private String country;
    private String date;
    private List<Act> acts;
    private int ticketNum = 0;

    public Concert(String location, String country, String date) {
        this.location = location;
        this.country = country;
        this.date = date;
        this.acts = new ArrayList<Act>();
    }

    public void addAct(Act act) {
        this.acts.add(act);
    }

    public List<Act> getActs() {
        return this.acts;
    }

    public String getCity() {
        return this.location;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(location, concert.location) &&
                Objects.equals(country, concert.country) &&
                Objects.equals(date, concert.date) &&
                Objects.equals(acts, concert.acts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, country, date, acts);
    }

    public boolean isValid(Ticket ticket) {
        return this.equals(ticket.getConcert());
    }

    public boolean participates(Artist artist) {
        for(Act act: acts){
            if(act.containsArtist(artist)) return true;
        }
        return false;
    }

    public int getTicketCount(){
        return ticketNum;
    }

    public void incrementTicketCount(){
        ticketNum++;
    }
}
