import java.awt.*;

class Indestructible extends Robot {

        private int robots_rencontres[];
        private int nb_rencontres;

        public Indestructible(String nomImage, int init_x, int init_y, Plateau pt, Color color) {
            super(nomImage, init_x, init_y, pt, color);
        }

        public void explose() { }

}
