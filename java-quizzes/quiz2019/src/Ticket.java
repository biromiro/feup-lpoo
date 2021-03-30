public class Ticket {

    private int num;
    private Concert concert;

    public Ticket(int num, Concert concert) throws InvalidTicket {
        if(num <= 0) throw new InvalidTicket(num);
        this.num = num;
        this.concert = concert;
    }

    public Ticket(Concert concert){
        this.num = concert.getTicketCount() + 1;
        concert.incrementTicketCount();
        this.concert = concert;
    }

    public int getNumber() {
        return this.num;
    }

    public Concert getConcert() {
        return this.concert;
    }
}
