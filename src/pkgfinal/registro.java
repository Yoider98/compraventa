
package pkgfinal;

import java.awt.Button;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registro extends login implements ActionListener{

    
    public registro(String string) throws HeadlessException, FileNotFoundException{
        super(string);   
        setBounds(0, 0, 1080, 720);//tamaño de la ventana
        this.setLayout(null);
        setResizable(false);//no se cambia el tamaño
        setLocationRelativeTo(null);//se abre en el centro
        
        //////////////////////////////Labels////////////////////////////////////
        
        
        
        j3.setBounds(300,400, 210,30);
        j3.setFont(new Font("Arial",3,25));
        j3.setForeground(Color.yellow);
        
        
        j4.setBounds(300,500, 210,30);
        j4.setFont(new Font("Arial",3,25));
        j4.setForeground(Color.yellow);
        
        
        j5.setBounds(300,200, 210,30);
        j5.setFont(new Font("Arial",3,25));
        j5.setForeground(Color.yellow);
        
        
        j6.setBounds(300,300, 210,30);
        j6.setFont(new Font("Arial",3,25));
        j6.setForeground(Color.yellow);
        
        ////////////////////////////////Botones/////////////////////////////////
        
        b1.setText("REGISTRO");
        b1.setBounds(390,50,300, 50);
        b1.setFont(new Font("Arial",1,25));
        b1.setEnabled(false);
        
        b2.setText("CREAR");
        b2.setFont(new Font("Arial",0,20));
        b2.setBounds(465,600,150, 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.yellow);
        Border line = new LineBorder(Color.BLACK);
        b2.setBorder(line);
        b2.addActionListener(this);
        
        r1.setBounds(500,300, 200, 20);
        
        r2.setBounds(500,320, 200, 20);
        
        b3.add(r1);
        b3.add(r2);

        ///////////////////////////Cuadros de texto/////////////////////////////
        
        usuario.setBounds(500, 400, 200, 30);
        
        nombre.setBounds(500, 200, 200, 30);
        
        contraseña.setBounds(500, 500, 200, 30);
        
        ///////////////////////////////Adiciones////////////////////////////////
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("CREAR")){
            if(!nombre.getText().equals("")&&!b3.isSelected(null)&& !usuario.getText().equals("")&& !contraseña.getText().equals("")){
                ventana v1 = new ventana("COMPRA VENTA MAGDALENA");
                    v1.setVisible(true);
                if(r1.isSelected()){
                    
                    ////////////////////////////////////////////////////////////
                    cuenta nc = new cuenta(nombre.getText(),r1.getText(),usuario.getText(),contraseña.getText());
                    admins.add(nc);
                    try {
                        File f = new File("administradores.txt");
                        FileWriter fw = new FileWriter(f,true);
                        PrintWriter pw = new PrintWriter(fw);
                        for(int j = 0; j< admins.size();j++){
                            pw.println(admins.get(j).nombre);
                            pw.println(admins.get(j).cargo);
                            pw.println(admins.get(j).usuario);
                            pw.println(admins.get(j).contraseña);
                        }
                        
                        pw.close();
                    }catch (FileNotFoundException ex) {
                        System.out.println(ex.getClass());
                    } catch (IOException ex) {
                        System.out.println(ex.getClass());
                    }
                    
                }
                if(r2.isSelected()){
                    
                    ////////////////////////////////////////////////////////////
                    cuenta nc = new cuenta(nombre.getText(),r2.getText(),usuario.getText(),contraseña.getText());
                    users.add(nc);
                    try {
                        File f = new File("usuarios.txt");
                        FileWriter fw = new FileWriter(f,true);
                        PrintWriter pw = new PrintWriter(fw);
                        for(int j = 0; j< users.size();j++){
                            pw.println(users.get(j).nombre);
                            pw.println(users.get(j).cargo);
                            pw.println(users.get(j).usuario);
                            pw.println(users.get(j).contraseña);
                        }
                        
                        pw.close();
                    }catch (FileNotFoundException ex) {
                        System.out.println(ex.getClass());
                    } catch (IOException ex) {
                        System.out.println(ex.getClass());
                    }
                }
                JOptionPane.showMessageDialog(this,"Su cuenta ha sido creada correctamente");
                this.setVisible(false);
                
            }else{
                JOptionPane.showMessageDialog(this,"Faltan Requisitos");
            }
            
        }
        if(e.getActionCommand().equals("VOLVER")){
            ventana v1 = new ventana("COMPRA VENTA MAGDALENA");
            v1.setVisible(true);
            this.setVisible(false);
        }
    }
    
}
