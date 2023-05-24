
package pkgfinal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class login extends JFrame implements ActionListener{
    JButton b1 = new JButton();//afuera para modificarlo en las clases hijas
    JButton b2 = new JButton("INGRESAR");
    JTextField usuario = new JTextField();
    JPasswordField contraseña = new JPasswordField();
    JTextField nombre = new JTextField();
    ButtonGroup b3 = new ButtonGroup();
    JRadioButton r1 = new JRadioButton("ADMINISTRADOR");
    JRadioButton r2 = new JRadioButton("ATENCION AL CLIENTE");
    JLabel j5 = new JLabel("NOMBRE");
    JLabel j6 = new JLabel("CARGO");
    JLabel j3 = new JLabel("USUARIO");
    JLabel j4 = new JLabel("CONTRASEÑA");
    
    public ArrayList<cuenta> admins = new ArrayList<>();
    public ArrayList<cuenta> users = new ArrayList<>();
    
     public login(String string) throws HeadlessException {
         
         
         
        super(string);//constructor
        setBounds(0, 0, 1080, 720);//tamaño de la ventana
        this.setLayout(null);
        setResizable(false);//no se cambia el tamaño
        setLocationRelativeTo(null);//se abre en el centro
        

        
        //////////////////////////////Labels////////////////////////////////////
        JLabel jl = new JLabel();
        jl.setBounds(0,0, 1080, 720);
        
        JLabel j2 = new JLabel();
        j2.setBounds(280,0, 500, 720);
        j2.setAlignmentX(CENTER_ALIGNMENT);
        
        
        j3.setBounds(300,299, 210,30);
        j3.setFont(new Font("Arial",3,25));
        j3.setForeground(Color.yellow);
        
        
        j4.setBounds(300,399, 210,30);
        j4.setFont(new Font("Arial",3,25));
        j4.setForeground(Color.yellow);
        
        ////////////////////////////////Botones/////////////////////////////////
        
        b1.setFont(new Font("Arial",1,25));
        b1.setEnabled(false);
        
        
        b2.setFont(new Font("Arial",0,20));
        b2.setBounds(465,500,150, 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.yellow);
        Border line = new LineBorder(Color.BLACK);
        b2.setBorder(line);
        
        JButton b3 = new JButton("VOLVER");
        b3.setBounds(15, 20, 100, 30);
        b3.addActionListener(this);
        
        
        
        ////////////////////////////////Imagenes////////////////////////////////
        
        ImageIcon im1 = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
        ImageIcon fondo = new ImageIcon(im1.getImage().getScaledInstance(jl.getWidth(),jl.getHeight(),Image.SCALE_DEFAULT));
        jl.setIcon(fondo);
        
        ImageIcon im2 = new ImageIcon(getClass().getResource("/imagenes/barra.png"));
        ImageIcon barra = new ImageIcon(im2.getImage().getScaledInstance(j2.getWidth(),j2.getHeight(),Image.SCALE_DEFAULT));
        j2.setIcon(barra);
        
        ///////////////////////////Cuadros de texto/////////////////////////////
        
        
        usuario.setBounds(500, 300, 200, 30);
   
        
        contraseña.setBounds(500, 400, 200, 30);
        
        ///////////////////////////////Adiciones////////////////////////////////
        
        add(nombre);
        add(r1);
        add(r2);
        add(j5);
        add(j6);
        
        add(b3);
        add(b2);
        add(b1);
        add(contraseña);
        add(j3);
        add(j4);
        add(usuario);
        add(j2);
        add(jl);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("VOLVER")){
            ventana v1 = new ventana("COMPRA VENTA MAGDALENA");
            v1.setVisible(true);
            this.setVisible(false);
        }
        
    }
}
