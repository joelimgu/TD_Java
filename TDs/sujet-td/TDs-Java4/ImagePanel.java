/**
 *  Cette classe gère une image de fond + des sprites qui peuvent se déplacer
 *  (Bas-niveau)
 */

import javax.swing.* ;
import java.awt.* ;
import java.util.* ;

public class ImagePanel extends JPanel {

    // L'image de fond qui est dessinée dans le cadre à chaque refresh.
    private Image image ;

    // La liste des sprites à dessiner.
    private ArrayList<Sprite> sprites = new ArrayList<Sprite> () ;

    public void setImage(Image image) {
	this.image = image;
    }

    // Crée un nouveau sprite, aux coordonnées indiquées.
    public synchronized Sprite addSprite(String imgName, int x, int y) {
	Sprite s = new Sprite(imgName, x, y, this) ;
	sprites.add(s) ;
	return s ;
    }

    // Refresh image & dessine les sprites
    public synchronized void paintComponent(Graphics g) {
	if(image != null) {
	    g.drawImage(image, 0, 0, this);
	    
	    for (Sprite s : sprites) {
		s.dessine (g, this) ;
	    }
	}
    }
    
    public Dimension getPreferredSize() {
	int w, h;
	if(image == null) {
	    return new Dimension(0, 0);
	}
	w = image.getWidth(null);
	h = image.getHeight(null);
	return new Dimension(w > 0 ? w : 0, h > 0 ? h : 0);
    }
}
