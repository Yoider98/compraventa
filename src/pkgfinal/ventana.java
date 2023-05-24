package pkgfinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ventana extends JFrame implements ActionListener{
    
    
    
    public ventana(String title) {
        setTitle(title);//titulo
        setBounds(0, 0, 1080, 720);
        this.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        JLabel jl = new JLabel();
        jl.setBounds(0,0, 1080, 720);
        
        JLabel j2 = new JLabel("ADMINISTRADOR");
        j2.setBounds(260,470, 100, 70);
        j2.setForeground(Color.yellow);
        JLabel j3 = new JLabel("ATENCION AL CLIENTE");
        j3.setBounds(680,465, 200, 70);
        j3.setForeground(Color.yellow);
        
        JLabel j4 = new JLabel();
        j4.setBounds(0,0, 1080, 200);
        
        
        
        
        JButton b1= new JButton("ADMINISTRADOR");
        b1.setBounds(200,250, 220, 220);
        b1.addActionListener(this);
        JButton b2= new JButton("ATENCION AL CLIENTE");
        b2.setBounds(630,250, 220, 220);
        b2.addActionListener(this);
        
        JButton b4 = new JButton("Crear cuenta");
        b4.setBounds(15, 650, 130, 20);
        b4.addActionListener(this);
        
        
        ImageIcon im1 = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
        ImageIcon fondo = new ImageIcon(im1.getImage().getScaledInstance(jl.getWidth(),jl.getHeight(),Image.SCALE_DEFAULT));
        jl.setIcon(fondo);
        
        ImageIcon im2 = new ImageIcon(getClass().getResource("/imagenes/iAdmin.png"));
        ImageIcon admin = new ImageIcon(im2.getImage().getScaledInstance(b1.getWidth(),b1.getHeight(),Image.SCALE_DEFAULT));
        b1.setIcon(admin);
        
        ImageIcon im3 = new ImageIcon(getClass().getResource("/imagenes/iAtUsers.png"));
        ImageIcon atencion = new ImageIcon(im3.getImage().getScaledInstance(b2.getWidth(),b2.getHeight()-20,Image.SCALE_DEFAULT));
        b2.setIcon(atencion);
        
        ImageIcon im4 = new ImageIcon(getClass().getResource("/imagenes/titulo.png"));
        ImageIcon titulo = new ImageIcon(im4.getImage().getScaledInstance(j4.getWidth(),j4.getHeight()-20,Image.SCALE_DEFAULT));
        j4.setIcon(titulo);
        
        
        this.add(b4);
        this.add(j4);
        this.add(j2);
        this.add(j3);
        this.add(b1);
        this.add(b2);
        this.add(jl);
        
        
        setVisible(true);//se hace visible la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Se termina al cerrar
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ADMINISTRADOR")){
            loginad v2 = new loginad("INICIO DE SESION PARA ADMINISTRADORES");
            v2.setVisible(true);
            this.setVisible(false);
            
        }
        if(e.getActionCommand().equals("ATENCION AL CLIENTE")){
            loginus v3 = new loginus("INICIO DE SESION PARA USUARIOS DE ATENCION AL CLIENTE");
            v3.setVisible(true);
            this.setVisible(false);
        }
        if(e.getActionCommand().equals("Crear cuenta")){
            registro v2 = null;
            try {
                v2 = new registro("new");
            } catch (HeadlessException ex) {
                
            } catch (FileNotFoundException ex) {
                
            }
            v2.setVisible(true);
            this.setVisible(false);
        }
    }

    
    

   
    
    
}
