import java.awt.*;
/** Boucle principale de la simulation */

public class Anim {

    /** Effectue une pause de la duree indiquee en millisecondes */
    public static void pause(int duree) {
	try {
	    Thread.currentThread().sleep(duree) ;
	} catch (InterruptedException e) {
	}
    }

    /** Boucle principale */
    public void go() {

	Plateau plat ;
	Robot[] robots ;

	plat = new Plateau(800, 600) ;
	robots = new Robot[5] ;

	robots[0] = new Cyborg("Images/mini1.png", 80, 100, plat, new Color(180, 0, 180)) ;
	robots[1] = new Cyborg("Images/mini2.png", 480, 250, plat, new Color(180, 255, 180)) ;
	robots[2] = new Indestructible("Images/mini3.png", 280, 400, plat, new Color(180, 180, 0)) ;
	robots[3] = new Killer("Images/mini3.png", 280, 400, plat, new Color(180, 180, 0), 5, 6) ;
	robots[4] = new Cyborg("Images/mini3.png", 100, 400, plat, new Color(0, 0, 0), 60) ;


	// On repete la boucle d'animation sans arret
	while (true) {

	    // On fait evoluer chaque robot
	    for (int i = 0 ; i < robots.length ; i++) {
		robots[i].bouge () ;
	    }

	    // Puis on teste les collisions deux a deux
	    for (int i = 0 ; i < robots.length ; i++) {
		for (int j = i+1 ; j < robots.length ; j++) {
		    robots[i].testeCollision(robots[j]) ;
		}
	    }

	    // Petite pause
	    java.awt.Toolkit.getDefaultToolkit().sync(); // Sinon l'animation est saccadée - probablement à cause du Window Manager.
	    this.pause(12) ;
	}

    }


    public static void main(String[] args) {
	Anim an = new Anim() ;
	Images.init () ;
	an.go () ;
    }

}
