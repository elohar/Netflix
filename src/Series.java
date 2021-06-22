import java.util.ArrayList;
import java.util.List;

public class Series {
    public String name;
    public List<Episode> episodes;

    public Series(String name, List<Episode> episodes) {
        this.name = name;
        this.episodes = episodes;
    }
    public Series(String name) {
        this.name = name;
        this.episodes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
    public void addEpisode(Episode episode) {
        this.episodes.add(episode);
    }

    public void print(){
        System.out.println("Series name:" + getName());
    }
}

