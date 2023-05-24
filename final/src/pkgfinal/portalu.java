
package pkgfinal;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class portalu extends portala implements ActionListener{

    public portalu(String string) throws HeadlessException {
        super(string);
        area1.setBounds(290,160, 480, 60);
        area1.setFont(new Font("Arial",1,25));
        area1.setText(" ¡¡Bienvenido al portal virtual de\n"+" usuarios de atencion al cliente!!\n");
        area1.setEnabled(false);
        
        b1.setText("PORTAL DE USUARIOS DE ATENCION AL CLIENTE");
        b1.setBounds(140,50,800, 50);    
        b1.setFont(new Font("Arial",1,25));
        b1.setEnabled(false);
        
        b2.setBounds(20,280,150,30);                    b2.addActionListener(this);
        b2.setText("Comprar Articulo");                 add(b2);
        b3.setBounds(20,320,150,30);                    b3.addActionListener(this);
        b3.setText("Empeñar Articulo");                 add(b3);
        b4.setBounds(20,370,150,30);                    b4.addActionListener(this);
        b4.setText("Vender Articulo");                  add(b4);
        b5.setText("Cerrar Sesion");                    add(b5);
        b5.setBounds(20, 420, 150, 30);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Cerrar Sesion")){
            JOptionPane.showMessageDialog(this, "Su Sesion a sido Cerrada :)");
            ventana v1 = new ventana("COMPRA VENTA MAGDALENA");
            v1.setVisible(true);
            this.setVisible(false);
        }
        if(ae.getActionCommand().equals("Vender Articulo")){
            Venta_Cliente cl = new Venta_Cliente();
        }
        if(ae.getActionCommand().equals("Comprar Articulo")){
            try {
                Comprar_Art at = new Comprar_Art();
            } catch (IOException ex) {
                Logger.getLogger(portalu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
