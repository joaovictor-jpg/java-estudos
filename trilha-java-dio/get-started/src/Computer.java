public class Computer implements VideoPlayer, MusicPlayer {
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

    @Override
    public void playVideo() {
        System.out.println("Inicíar vídeo");
    }

    @Override
    public void pauseVideo() {
        System.out.println("Pausar vídeo");
    }

    @Override
    public void stopVideo() {
        System.out.println("Desligando vídeo");
    }
}
