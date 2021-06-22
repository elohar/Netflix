import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class User {
    public String username;
    public String password;
    public String registerDate;
    public String subscriptionDate;
    public List<SeriesWatched> watched;

    public User(String username, String password, String registerDate, String subscriptionDate, List<SeriesWatched> watched) {
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
        this.subscriptionDate = subscriptionDate;
        this.watched = watched;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);

        Date oneMonth = cal.getTime();

        this.registerDate = dateFormat.format(date);
        this.subscriptionDate = dateFormat.format(oneMonth);
        this.watched = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(String subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public List<SeriesWatched> getWatched() {
        return watched;
    }

    public void setWatched(List<SeriesWatched> watched) {
        this.watched = watched;
    }

    public void addWatched(SeriesWatched watched){this.watched.add(watched);}

    public void print(){
        System.out.println("Register date:"+registerDate);
        System.out.println("Subscription until:"+subscriptionDate);
        System.out.println("Series started watching:"+watched.size());

        int totalFinished = 0;
        int totalEpisodes = 0;
        for (int i=0;i<watched.size();i++){
            totalEpisodes += watched.get(i).getCount();
            if(watched.get(i).isDone())totalFinished++;
        }
        System.out.println("Total finished sereies:"+totalFinished);
        System.out.println("Total episodes watched:"+totalEpisodes);
    }
}
