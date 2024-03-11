package data.peripheral;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import data.sys.TextBloc;

public class Keyboard extends Peripheral {
    private int keyCode;

    public Keyboard(int id, String name) {
    	this.id = id;
    	this.name = name;
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        GlobalScreen.addNativeKeyListener(new MyKeyListener());
    }

    public String read() {
        return Integer.toString(keyCode);
    }

	/*
	 * C'est cette classe qui recupere les input du clavier, a voir si on ne peut 
	 * pas la bouger ailleur pour un code plus propre. (On peut, faut juste voir ou)
	 */
    private class MyKeyListener implements NativeKeyListener {
    	
        @Override
        public void nativeKeyPressed(NativeKeyEvent e) {
            keyCode = e.getKeyCode();
            System.out.println("input : " + keyCode);  // a modifier pour que ca utilise la maniere plus pro.
        }
    }
}
