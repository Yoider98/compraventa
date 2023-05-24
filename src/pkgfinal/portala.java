
package pkgfinal;


import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class portala extends JFrame implements ActionListener{
        
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton("Cantidad y Precio");
    JLabel j2 = new JLabel();
    JButton j3 = new JButton("INVENTARIO");
    JButton b5 = new JButton("Cerrar Sesion");
    JTextArea area1 = new JTextArea();    
    
    
    
    public portala(String string) throws HeadlessException {
        super(string);
        
        setBounds(0, 0, 1080, 720);
        this.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        b1.setText("PORTAL DE ADMINISTRADORES");
        b1.setBounds(315,50,450, 50);    
        b1.setFont(new Font("Arial",1,25));
        b1.setEnabled(false);
        
        JLabel jl = new JLabel();
        jl.setBounds(0,0, 1080, 720);
        j2.setBounds(280,0, 500, 720);
        j2.setAlignmentX(CENTER_ALIGNMENT);
        
        
        area1.setBounds(290,160, 480, 110);
        area1.setFont(new Font("Arial",1,25));
        area1.setText("\n ¡¡Bienvenido al portal virtual de\n"+" administradores!!\n");
        area1.setEnabled(false);
        
        ImageIcon im1 = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
        ImageIcon fondo = new ImageIcon(im1.getImage().getScaledInstance(jl.getWidth(),jl.getHeight(),Image.SCALE_DEFAULT));
        jl.setIcon(fondo);
        ImageIcon im2 = new ImageIcon(getClass().getResource("/imagenes/barra.png"));
        ImageIcon barra = new ImageIcon(im2.getImage().getScaledInstance(j2.getWidth(),j2.getHeight(),Image.SCALE_DEFAULT));
        j2.setIcon(barra);
        
        
        ///////////////////////////////BOTONES//////////////////////////////////
        
        b5.setBounds(40, 450, 120, 30);         b5.addActionListener(this);             add(b5);
        b4.setBounds(55,270,150,30);            b4.addActionListener(this);             add(b4);
        
        ////////////////////////////////////////////////////////////////////////
        
        j3.setBounds(45, 180, 190, 50);     j3.setFont(new Font("Arial",1,15)); j3.setAlignmentX(CENTER_ALIGNMENT);  add(j3);  j3.setEnabled(false);
       /////////////////////////////////////////////////////////////////////////
        
       
        add(b4);
        add(b3);
        add(b2);
        add(area1);
        add(b1);
        add(j2);
        add(jl);
       
        
        setVisible(true);//se hace visible la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Se termina al cerrar
        
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Cerrar Sesion")){
            JOptionPane.showMessageDialog(this, "Su Sesion a sido cerrada :)");
            ventana v1 = new ventana("COMPRA VENTA MAGDALENA");
            v1.setVisible(true);
            this.setVisible(false);
        }
        if(ae.getActionCommand().equals("Cantidad y Precio")){
            try {
                Mostrar_Cantidad_Precio mc = new Mostrar_Cantidad_Precio();
            } catch (HeadlessException ex) {
                Logger.getLogger(portala.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(portala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}