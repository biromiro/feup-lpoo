package area;

public class AreaStringOutputter {

    SumProvider provider;

    public AreaStringOutputter(SumProvider provider){
        this.provider = provider;
    }

    public String output() {
        return "Sum of areas: " + provider.sum();
    }

}
