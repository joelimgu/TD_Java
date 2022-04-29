
import java.awt.*;

class Cyborg extends Robot {

    private int collisions;
    private int max_collisions = 6;

    public Cyborg (String nomImage, int init_x, int init_y, Plateau pt, Color color) {
        super(nomImage, init_x, init_y, pt, color);
    }

    public Cyborg (String nomImage, int init_x, int init_y, Plateau pt, Color color, int max_collisions) {
        super(nomImage, init_x, init_y, pt, color);
        this.max_collisions = max_collisions;
    }


    public void collision(Robot autre) {
        this.vx = this.randomV();
        this.vy = this.randomV();
        this.collisions += 1;
//        System.out.println("collision " + this.collisions);

        if ( collisions > 6 ) {
            this.explose();
        }
    }
}
