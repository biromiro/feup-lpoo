import java.util.ArrayList;
import java.util.List;

public class BoxOffice {
    public static List<Ticket> buy(Concert concertLondon, int i) {
        List<Ticket> tickets = new ArrayList<Ticket>();
        for(int j = 0; j < i; j++){
            tickets.add(new Ticket(concertLondon));
        }
        return tickets;
    }
}
