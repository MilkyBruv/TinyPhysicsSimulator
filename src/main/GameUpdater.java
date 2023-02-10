package main;

import java.util.ArrayList;
import java.util.List;

import org.awtgl.vector.Vector2i;
import org.awtgl.window.GamePanel;
import org.awtgl.window.GameSettings;
import org.awtgl.window.Image;
import org.awtgl.window.MouseButtons;
import org.awtgl.window.MouseHandler;
import org.awtgl.window.Renderer;
import org.awtgl.window.Updater;

public class GameUpdater extends Updater {

    public GamePanel gamePanel;
    public List<Sand> sands;
    public List<Vector2i> sandPositions;
    public List<Vector2i> blockPositions;

    public GameUpdater(GameSettings settings, Renderer renderer) {

        super(settings, renderer);

        this.sands = new ArrayList<>();
        this.sandPositions = new ArrayList<>();
        this.blockPositions = new ArrayList<>();

    }
    


    @Override
    public void update() {

        Vector2i mousePos = this.cursor.getPos();

        if (MouseHandler.isButtonPressed(MouseButtons.LEFT)) {

            this.sands.add(new Sand(mousePos, this));

        }

        this.sandPositions.clear();

        for (Sand sand : this.sands) {
            
            this.sandPositions.add(sand.pos);

        }

        for (Sand sand : this.sands) {
            
            sand.update();

        }

    }



    @Override
    public void draw(Image display) {

        for (Vector2i pos : this.sandPositions) {
            
            Renderer.drawPoint(pos, 0x12387f, display);

        }

        for (Vector2i pos : this.blockPositions) {
            
            Renderer.drawPoint(pos, 0xff236e, display);

        }

    }

}