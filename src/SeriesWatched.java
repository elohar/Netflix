import java.util.ArrayList;
import java.util.List;

public class SeriesWatched {
    public Series series;
    public List<Integer> watched;

    public SeriesWatched(Series series, List<Integer> watched) {
        this.series = series;
        this.watched = watched;
    }
    public SeriesWatched(Series series) {
        this.series = series;
        this.watched = new ArrayList<>();
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public List<Integer> getWatched() {
        return watched;
    }

    public void setWatched(List<Integer> watched) {
        this.watched = watched;
    }
    public void addWatched(int index){
        for(int i=0;i<watched.size();i++){
            if(watched.get(i) == index)return;
        }
        watched.add(index);
    }

    Episode getLast(){
        int max = watched.get(0);
        for(int i=0;i<watched.size();i++){
            if(watched.get(i) > max)max = watched.get(i);
        }
        return series.getEpisodes().get(max);
    }
    int getCount(){
        return watched.size();
    }
    boolean isDone(){
        return watched.size() == series.episodes.size();
    }

    void print(){
        System.out.println("Series:");
        series.print();
        System.out.println("Last Episode:");
        getLast().print();
    }
}
