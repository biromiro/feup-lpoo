public class Artist extends Act {
    public Artist(String name, String country) {
        super(name,country);
    }

    public boolean containsArtist(Artist artist){
        return this.equals(artist);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return artist.getName().equals(this.getName()) &&
                artist.getCountry().equals(this.getCountry());

    }
}
