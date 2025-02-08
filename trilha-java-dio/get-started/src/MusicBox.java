public class MusicBox implements MusicPlayer {

    @Override
    public void playMusic() {
        System.out.println("Toca música");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Pausar música");
    }

    @Override
    public void stopMusic() {
        System.out.println("Desligar música...");
    }

    
}
