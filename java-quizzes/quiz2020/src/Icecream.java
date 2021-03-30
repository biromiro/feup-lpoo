import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Icecream {

    private List<Flavor> scoops;

    public Icecream(){
        this.scoops = new ArrayList<Flavor>();
    }

    public void addScoop(Flavor scoop) {
        scoops.add(scoop);
    }

    public int getScoopCount() {
        return scoops.size();
    }

    public boolean contains(String flavor) {
        for(Flavor scoop: scoops){
            if(flavor.equals(scoop.getName())) return true;
        }
        return false;
    }

    public int getFlavorCount() {
        HashSet<Flavor> set = new HashSet<Flavor>(scoops);
        return set.size();
    }

    public void removeScoop(Flavor flavor) {
        scoops.remove(flavor);
    }
}
