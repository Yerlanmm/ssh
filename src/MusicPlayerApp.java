// MusicPlayerApp.java

// 1. AudioPlayer Interface
interface AudioPlayer {
    void play(String audioType, String fileName);
}

// 2. MP3Player Class: Plays only MP3 files
class MP3Player implements AudioPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            System.out.println("Invalid format. MP3Player supports only MP3 files.");
        }
    }
}

// 3. Interfaces for WAVPlayer and AACPlayer
interface WAVPlayer {
    void playWAV(String fileName);
}

interface AACPlayer {
    void playAAC(String fileName);
}

// 4. AdvancedAudioPlayer Class: Supports both WAV and AAC formats
class AdvancedAudioPlayer implements WAVPlayer, AACPlayer {
    @Override
    public void playWAV(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }

    @Override
    public void playAAC(String fileName) {
        System.out.println("Playing AAC file: " + fileName);
    }
}

// 5. AudioAdapter Class: Adapts AdvancedAudioPlayer to AudioPlayer
class AudioAdapter implements AudioPlayer {
    private AdvancedAudioPlayer advancedAudioPlayer;

    public AudioAdapter(String audioType) {
        advancedAudioPlayer = new AdvancedAudioPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("wav")) {
            advancedAudioPlayer.playWAV(fileName);
        } else if (audioType.equalsIgnoreCase("aac")) {
            advancedAudioPlayer.playAAC(fileName);
        } else {
            System.out.println("Unsupported audio format: " + audioType);
        }
    }
}

// 6. MusicPlayerApp Class: Demonstrates the Adapter Pattern
public class MusicPlayerApp {
    public static void main(String[] args) {
        // Existing MP3 player
        AudioPlayer mp3Player = new MP3Player();
        mp3Player.play("mp3", "song1.mp3"); // Plays an MP3 file

        // Use AudioAdapter for WAV and AAC files
        AudioPlayer wavAdapter = new AudioAdapter("wav");
        wavAdapter.play("wav", "song2.wav"); // Plays a WAV file

        AudioPlayer aacAdapter = new AudioAdapter("aac");
        aacAdapter.play("aac", "song3.aac"); // Plays an AAC file

        // Attempt to play an unsupported format
        mp3Player.play("aac", "unsupported.aac"); // Should display error
    }
}

