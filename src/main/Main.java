package main;

import org.awtgl.window.GameSettings;
import org.awtgl.window.Renderer;
import org.awtgl.window.Window;

public class Main {
    
    public static void main(String[] args) {

        GameSettings settings = new GameSettings(8, 12, 8);
        Renderer renderer = new Renderer();
        GameUpdater updater = new GameUpdater(settings, renderer);
        Window window = new Window(1280, 720, "test", true, 60, settings, updater, Window.SCALE_INNER_DISPLAY);

        window.start();

        int num1 = 1027011111;
        long verlong = 1234987348;
        float num2 = 1.8859f;
        double num3 = 0.77387349823409832409834098340983204983204981237638763283294734017263765047615;

        String str1 = "bob";

    }

}