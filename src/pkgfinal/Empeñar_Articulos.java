
package pkgfinal;


import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class Empeñar_Articulos extends JFrame implements ActionListener{

    public Empeñar_Articulos() throws HeadlessException{
        super();
        setTitle("Seccion de Empeño");
        setBounds(400, 150, 550, 350);
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
