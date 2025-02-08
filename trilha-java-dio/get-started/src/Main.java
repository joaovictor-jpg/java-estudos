import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws Exception {
        List<User> users = List.of(new User("João", 24), new User("Maria", 21), new User("Eduardo", 40),
                new User("Ana", 19));

        // var consumer = new Consumer<User>() {
        // @Override
        // public void accept(final User user) {
        // System.out.println(user);
        // }
        // };

        // users.forEach(System.out::println);
        
        printStringValue(User::getNome, users);
    }

    private static void printStringValue(Function<User, String> callback, List<User> users) {
        users.forEach(u -> System.out.println(callback.apply(u)));
    }

    public static void runMusic(MusicBox musicBox) {
        musicBox.playMusic();
        musicBox.pauseMusic();
        musicBox.stopMusic();
    }

    public static void runSmartphone(Smartphone smartphone) {
        smartphone.playMusic();
        smartphone.playVideo();
        smartphone.pauseMusic();
        smartphone.pauseMusic();
        smartphone.stopMusic();
        smartphone.stopVideo();
    }

    public static void runComputer(Computer computer) {
        computer.playMusic();
        computer.playVideo();
        computer.pauseMusic();
        computer.pauseMusic();
        computer.stopMusic();
        computer.stopVideo();
    }
}
