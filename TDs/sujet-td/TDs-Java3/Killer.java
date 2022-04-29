import java.awt.*;


class Killer extends Robot {

    private int robots_rencontres[];
    private int nb_rencontres;

    public Killer(String nomImage, int init_x, int init_y, Plateau pt, Color color, int nb_robots, int nb_rencontres) {
        super(nomImage, init_x, init_y, pt, color);
        this.robots_rencontres = new int[nb_robots];
        this.nb_rencontres = nb_rencontres;
    }

    public void collision(Robot autre) {
        System.out.println("collision robot " + autre);
        this.robots_rencontres[autre.getId()] += 1;
        if ( this.robots_rencontres[autre.getId()] >= this.nb_rencontres ) {
            autre.explose();
        }
    }
}
