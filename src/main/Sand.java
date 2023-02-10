package main;

import java.util.Random;

import org.awtgl.vector.Vector2i;

public class Sand {
    
    public Vector2i pos;
    public GameUpdater main;

    public Sand(Vector2i pos, GameUpdater main) {

        this.pos = pos;
        this.main = main;

    }



    public void update() {

        boolean[] canMoveDown = {false, false};
        boolean[] canMoveDownLeft = {false, false};
        boolean[] canMoveDownRight = {false, false};

        for (Vector2i pos2 : this.main.sandPositions) {
            
            if (this.pos.x != pos2.x && this.pos.y + 1 != pos2.y && !canMoveDown[0]) {

                canMoveDown[0] = true;

            }

            if (this.pos.x - 1 != pos2.x && this.pos.y == pos2.y - 1 && !canMoveDownLeft[0]) {

                canMoveDownLeft[0] = true;

            }

            if (this.pos.x + 1 != pos2.x && this.pos.y == pos2.y - 1 && !canMoveDownRight[0]) {

                canMoveDownRight[0] = true;

            }

        }

        for (Vector2i pos2 : this.main.blockPositions) {
            
            if (this.pos.x != pos2.x && this.pos.y + 1 != pos2.y && !canMoveDown[1]) {

                canMoveDown[1] = true;

            }

            if (this.pos.x - 1 != pos2.x && this.pos.y == pos2.y - 1 && !canMoveDownLeft[1]) {

                canMoveDownLeft[1] = true;

            }

            if (this.pos.x + 1 != pos2.x && this.pos.y == pos2.y - 1 && !canMoveDownRight[1]) {

                canMoveDownRight[1] = true;

            }

        }

        if (canMoveDown[0] && canMoveDown[1]) {

            this.pos.y++;

        } else if (canMoveDownLeft[0] && canMoveDownRight[0] && canMoveDownLeft[1] && canMoveDownRight[1]) {

            this.pos.y++;

            Random random = new Random();

            int num = random.nextInt(2);

            if (num == 0) {

                this.pos.x++;

            } 
            
            if (num == 1) {

                this.pos.x--;

            }

        } else if (canMoveDownLeft[0] && !canMoveDownRight[0] && canMoveDownLeft[1] && !canMoveDownRight[1]) {

            this.pos.y++;
            this.pos.x--;

        } else if (!canMoveDownLeft[0] && canMoveDownRight[0] && !canMoveDownLeft[1] && canMoveDownRight[1]) {

            this.pos.y++;
            this.pos.x++;

        }

    }

}
