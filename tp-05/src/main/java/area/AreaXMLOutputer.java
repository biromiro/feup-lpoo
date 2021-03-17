package area;

public class AreaXMLOutputer {

    SumProvider provider;

    public AreaXMLOutputer(SumProvider provider){
        this.provider = provider;
    }
    public String output() {
        return "<area>" + provider.sum() + "</area>";
    }
}
