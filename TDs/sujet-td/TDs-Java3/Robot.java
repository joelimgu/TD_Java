import java.awt.Color ;

public class Robot {

    /*
     *  Les attributs de chaque Robot.
     */
	public static int nb_robots = 0;
	public static final int max_explosions = 3;
	private static int nb_explosions = 0;

    /** Position du robot */
    protected int x, y ;

    /** Vitesse du robot */
    protected int vx, vy ;

    /** Etat du robot */
    private boolean vivant ;

    /** Sprite (==image) representant le robot */
    private Sprite image ;

    /** Plateau sur lequel le robot evolue */
    private Plateau plat ;

    /** Ce robot est-il arrete' ? */
    private boolean arrete ;

	private Color color;

	private int id = 0;




    /*
     *  Constructeur de Robot.
     */

    /** Cree un nouveau robot avec l'image indiquee, a la position indiquee sur le plateau
     *  La vitesse de depart est aleatoire
     */
    public Robot (String nomImage, int init_x, int init_y, Plateau pt, Color color) {
	this.x = init_x ;
	this.y = init_y ;
	this.vivant = true ;
	this.vx = this.randomV() ;
	this.vy = this.randomV() ;
	this.plat = pt ;
	this.color = color;
	this.image = pt.addSprite (nomImage, this.x, this.y) ;
	this.arrete = false ;
	this.id = Robot.nb_robots;
	Robot.nb_robots += 1;
	System.out.println("Set id " + this.id);
    }

	public int getId() {
		return this.id;
	}

    /*
     *  Méthodes
     */


    /** Renvoie une valeur de vitesse aleatoire */
    public int randomV() { return (int)(Math.random() * 6) - 3 ; }

    /** Recupere la largeur de l'image du robot */
    public int getLarg() { return this.image.getLarg() ; }

    /** Recupere la hauteur de l'image du robot */
    public int getHaut() { return this.image.getHaut() ; }


    /** Effectue un deplacement elementaire du robot */
    public void bouge() {

	if (this.vivant) {

	    this.x += this.vx ;
	    this.y += this.vy ;

	    // Si le robot rejoint un bord de la fenetre, il rebondit et change de direction
	    int futurX = this.x + this.vx ;
	    int futurY = this.y + this.vy ;

	    // Collision avec le bord gauche
	    if (futurX < 0) {
		this.vx = Math.abs(this.vx) ;
		this.vy = this.randomV() ;
	    }

	    // Collision avec le bord droit
	    if (futurX + this.getLarg() > this.plat.getLarg()) {
		this.vx = -Math.abs(this.vx) ;
		this.vy = this.randomV() ;
	    }

	    // Collision avec le bord haut
	    if (futurY < 0) {
		this.vy = Math.abs(this.vy) ;
		this.vx = this.randomV() ;
	    }

	    // Collision avec le bord bas
	    if (futurY + this.getHaut() > this.plat.getHaut()) {
		this.vy = -Math.abs(this.vy) ;
		this.vx = this.randomV() ;
	    }
	}

	// Redessine le robot au nouvel endroit
	// Force a redessiner, meme si le robot n'a pas bouge.
	this.image.moveTo(this.x, this.y) ;
	this.plat.drawCircle(this.x, this.y, 5);
	this.plat.setColor(this.color);
    }


    /** Teste si ce robot est en collision avec le robot 'autre' */
    public void testeCollision(Robot autre) {

	// Pour etre en collision, il faut une intersection sur les X ET sur les Y
	boolean enCollision = ((this.x + this.getLarg() >= autre.x) && (this.x < autre.x + autre.getLarg()) &&
			       (this.y + this.getHaut() >= autre.y) && (this.y < autre.y + autre.getHaut())) ;

	// Si on est en collision avec un robot different de soi-meme, on reagit et l'autre aussi.
	if (this.vivant && autre.vivant && (autre != this) && enCollision) {

	    // Si les deux robots sont deja arretes, on ne fait rien.
	    if (this.arrete && autre.arrete) {}
	    else {
		this.collision(autre) ;
		autre.collision(this) ;
	    }
	}
    }

    /** Arrêter ce robot. */
    public void arreterRobot() {
	this.vx = 0 ;
	this.vy = 0 ;
	this.arrete = true ;
    }

    /** Fait exploser ce robot */
    public void explose() {
		if ( Robot.nb_explosions <= Robot.max_explosions ) {
			this.image.playSequence(Images.explosion, false) ;
			this.vivant = false ;
		}
    }

    /** Reaction a une collision : on s'arrete */
    public void collision(Robot autre) {
		this.arreterRobot() ;
    }

	public String toString() {
		return Integer.toString(this.id);
	}
}
