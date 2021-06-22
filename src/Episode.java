public class Episode {
    public String name;
    public String summary;
    public String releaseDate;

    public Episode(String name, String summary, String releaseDate) {
        this.name = name;
        this.summary = summary;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void print(){
        System.out.println("Name="+this.name);
        System.out.println("Summary="+this.summary);
        System.out.println("Release Date="+this.releaseDate);
    }
}
