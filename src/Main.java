import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<User> users;
    public static List<Series> serieses;

    public static void main(String[] args) {
        users = new ArrayList<>();

        Series series = new Series("Loki");
        Episode episode1 = new Episode("1", "Loki didn't know", "15.06.21");
        Episode episode2 = new Episode("2", "Loki know", "20.06.21");
        Episode episode3 = new Episode("3", "Loki was know", "25.06.21");
        series.addEpisode(episode1);
        series.addEpisode(episode2);
        series.addEpisode(episode3);


        Series series2 = new Series("Seinfeld");
        episode1 = new Episode("1", "Kramer didn't know", "15.05.92");
        episode2 = new Episode("2", "Kramer know", "20.05.92");
        episode3 = new Episode("3", "Kramer was know", "25.05.92");
        series2.addEpisode(episode1);
        series2.addEpisode(episode2);
        series2.addEpisode(episode3);

        Series series3 = new Series("House");
        episode1 = new Episode("1", "Lisa didn't know", "15.03.11");
        episode2 = new Episode("2", "Lisa know", "20.03.11");
        episode3 = new Episode("3", "Lisa was know", "25.03.11");
        series3.addEpisode(episode1);
        series3.addEpisode(episode2);
        series3.addEpisode(episode3);

        users = new ArrayList<>();
        serieses = new ArrayList<>();
        serieses.add(series);
        serieses.add(series2);
        serieses.add(series3);

        printLoginMenu();
    }
    public static void printLoginMenu() {
        int select = 0;
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("To register press -1-");
            System.out.println("To sign in  press -2-");
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
            }
            }
            while (select!= 0);
        }

        public static void registerUser(){
            Scanner scanner = new Scanner(System.in);

            String username;
            do {
                System.out.println("Please enter username:");
                username = scanner.nextLine();
            } while(usernameExists(username));
            String password;

            do {
                System.out.println("Please enter STRONG password:");
                password = scanner.nextLine();
            } while(weakPassword(password));

            User user = new User(username,password);
            users.add(user);
        }
        public static boolean usernameExists(String username){
            for(int i=0;i<users.size();i++){
                if(users.get(i).getUsername().equals(username))return true;
            }
            return false;
        }
        public static boolean weakPassword(String password){
            if(password.length() < 6)return true;
            boolean hasLetter = false;
            boolean hasDigit = false;
            for(int i=0;i<password.length();i++){
                if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')hasLetter = true;
                if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')hasLetter = true;
                if(password.charAt(i) >= '0' && password.charAt(i) <= '9')hasDigit = true;
            }
            return  !(hasDigit && hasLetter);
        }

        public static void loginUser(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username:");
            String username = scanner.nextLine();

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            for(int i=0;i<users.size();i++){
                if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)){
                    System.out.println("Logged in successfully!");
                    printUserMenu(users.get(i));
                    return;
                }
            }
            System.out.println("Invalid details.");
        }

        public static void printUserMenu(User user){
            int select = 0;
            Scanner scanner = new Scanner(System.in);
            do {

                System.out.println("To show series list -1-");
                System.out.println("To show series you started watching -2-");
                System.out.println("To show subscription info -3-");
                System.out.println("To choose a show to watch -4-");
                System.out.println("To logut -5-");
                select = scanner.nextInt();
                switch (select) {
                    case 1:
                        showSeriesList();
                        break;
                    case 2:
                        showSeriesBegun(user);
                        break;

                    case 3:
                        showSubInfo(user);
                        break;

                    case 4:
                        chooseWatch(user);
                        break;

                }
            }
            while (select!= 5);
        }

    public static void showSeriesList(){
        for(int i=0;i<serieses.size();i++){
            serieses.get(i).print();
        }
    }

    public static void showSeriesBegun(User user){
        if(user.getWatched().isEmpty()){
            System.out.println("No series watched yet.");
            return;
        }
        for(int i=0;i<user.getWatched().size();i++){
            user.getWatched().get(i).print();
        }
    }

    public static void showSubInfo(User user){
        user.print();
    }

    public static void chooseWatch(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter series name you wish to watch:");
        String name = scanner.nextLine();
        Series series = null;
        for(int i=0;i<serieses.size();i++){
            if(serieses.get(i).getName().equals(name)){
                series = serieses.get(i);
                break;
            }
        }
        if(series == null){
            System.out.println("No series found!");
            return;
        }

        SeriesWatched watched = null;
        for(int i=0;i<user.getWatched().size();i++){
            if(user.getWatched().get(i).getSeries().getName().equals(name)){
                watched = user.getWatched().get(i);
            }
        }

        for (int i=0;i<series.getEpisodes().size();i++){
            System.out.println("Episode #"+(i+1));
            series.getEpisodes().get(i).print();
        }

        if(watched != null){
            System.out.println("Last watched episode:");
            watched.getLast().print();
        }

        System.out.println("Enter number of episode you wish to watch:");
        int episodeIndex = scanner.nextInt()-1;
        if(episodeIndex < 0 || episodeIndex >= series.getEpisodes().size()){
            System.out.println("Invalid index");
            return;
        }

        if(watched == null){
            watched = new SeriesWatched(series);
            watched.addWatched(episodeIndex);
            user.addWatched(watched);
        } else{
            watched.addWatched(episodeIndex);
        }
    }

}







