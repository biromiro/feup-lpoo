public abstract class Act {

    private String name;
    private String country;

    Act(String name, String country){
        this.name = name;
        this.country = country;
    }

    public String getName(){
        return this.name;
    }

    public String getCountry(){
        return this.country;
    }

    public abstract boolean containsArtist(Artist artist);
}
