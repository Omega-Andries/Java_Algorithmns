import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;





public class themusic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File musicFile = new File("./data/07 Claptone feat. Zola Blood - Birdsong (Super Flu Remix).mp3");
		if(musicFile.exists()) {
			playMusic(musicFile);
		}else {
			System.out.println("Cannot find your file brah");
		}
	}
	
	private static void playMusic(File musicFile) {
		try {
			FileInputStream fis = new FileInputStream(musicFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			Player p = new Player(bis);
			System.out.println("Playing: " + musicFile.getName());
			p.play();
			System.out.println("The jam is playing sir");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
