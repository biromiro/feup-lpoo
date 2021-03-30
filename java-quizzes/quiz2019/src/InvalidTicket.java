public class InvalidTicket extends Exception {

    private int invalidNum;

    public InvalidTicket(int num) {
        invalidNum = num;
    }

    public int getInvalidNum() {
        return invalidNum;
    }
}
