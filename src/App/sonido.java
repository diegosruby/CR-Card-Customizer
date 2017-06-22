package App;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.sound.sampled.Clip;

/**
 * @author Borja Blanco & Diego Sanchez
 */
public class sonido {

    AudioClip sonidoFondo;

    public void sound() {
        sonidoFondo = Applet.newAudioClip(getClass().getResource("/sound/Menu.wav"));
        sonidoFondo.loop();

    }

    public void sound2() {
        sonidoFondo = Applet.newAudioClip(getClass().getResource("/sound/Win.wav"));
        sonidoFondo.play();

    }

    public void sound3() {
        sonidoFondo = Applet.newAudioClip(getClass().getResource("/sound/SonidoCarga.wav"));
        sonidoFondo.play();

    }

    public void apagar() {
        sonidoFondo.stop();
    }
}
