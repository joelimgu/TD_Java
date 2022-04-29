/**
 *   Ouvre une fenetre pour y afficher les sprites
 *   ou y tracer des points, lignes, etc.
 */

import javax.swing.* ;
import java.awt.* ;
import java.awt.image.* ;

public class Plateau {

    // ImagePanel : contient le cadre et les sprites des robots.
    private ImagePanel panel ;

    private JFrame frame ;
    private BufferedImage img ;
    private Graphics2D gr ;

    private int larg ;
    private int haut ;

    /**
     *  Crée et affiche une nouvelle fenêtre
     */
    public Plateau (int largeur, int hauteur) {
        this.frame = new JFrame ("Le Monde des Robots");
	this.frame.setResizable(false) ;
	this.larg = largeur ;
	this.haut = hauteur ;
	this.img   = new BufferedImage (largeur, hauteur, BufferedImage.TYPE_3BYTE_BGR) ;
	this.gr    = this.img.createGraphics() ;
	this.panel = new ImagePanel () ;

	this.panel.setImage(this.img) ;
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(largeur, hauteur);

	this.frame.setContentPane(this.panel) ;
        this.frame.setVisible(true);

	this.setColor (new Color(180, 180, 200)) ;
	gr.fillRect(0,0,largeur,hauteur) ;

	this.setColor (Color.black) ;
	this.repaint() ;
    }

    /** Renvoie la largeur de la fenetre */
    public int getLarg () { return this.larg ;}

    /** Renvoie la hauteur de la fenetre */
    public int getHaut () { return this.haut ;}

    /**
     *  Force le reaffichage de la fenetre
     */
    public void repaint() {
	panel.repaint() ;
    }

    /**
     *  Fixe la couleur du crayon pour les dessins futurs.
     */
    public void setColor (Color col) {
	this.gr.setColor (col) ;
    }

    /**
     *  Dessine un cercle
     */
    public void drawCircle (int x, int y, int rayon) {
        this.gr.fillOval(x - rayon, y - rayon, 2*rayon, 2*rayon) ;
        panel.repaint (0, x - rayon, y - rayon, 2*rayon, 2*rayon) ;
    }

    /**
     *  Cree un nouveau sprite a partir du fichier image indique'
     */
    public Sprite addSprite(String imgName, int x, int y) {
	return panel.addSprite(imgName, x, y) ;
    }

}
