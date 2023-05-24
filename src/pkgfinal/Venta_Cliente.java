
package pkgfinal;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Venta_Cliente extends JFrame implements ActionListener{

    public JLabel etiq1;
    public JLabel etiq2;
    public JTextField nom_art;
    public JTextField nom_cliente;
    public JLabel nomb_cl;
    public JTextField precio;
    public JButton b1;
    public JLabel cantidad;
    public JTextField cant;
    public JPanel panel;
    
    public Venta_Cliente() throws HeadlessException{
        super();
        setBounds(400, 150, 300, 350);
        setTitle("Venta");
        panel = new JPanel(); panel.setBounds(0, 0, 305, 380);     panel.setLayout(null);      this.getContentPane().add(panel);
        
        vender();
        
        setVisible(true);
    }
    
    private void vender(){
        ///////////////////////////////////////AGREGANDO LOS COMPONENTES/////////////////////////////////////
        etiq1 = new JLabel("Nombre del Producto");                  etiq1.setBounds(90, 15, 120, 30);                       panel.add(etiq1);
        nomb_cl = new JLabel("Nombre del Vendedor");                nomb_cl.setBounds(90, 150, 130, 30);                    panel.add(nomb_cl);
        nom_cliente = new JTextField();                             nom_cliente.setBounds(90, 180, 120, 30);                panel.add(nom_cliente);
        etiq2 = new JLabel("Precio (Sin comas):");                  etiq2.setBounds(90, 80, 120, 30);                       panel.add(etiq2);
        nom_art = new JTextField();                                 nom_art.setBounds(90, 45, 120, 30);                     panel.add(nom_art);
        precio = new JTextField();                                  precio.setBounds(90, 110, 120, 30);                      panel.add(precio);
        cantidad = new JLabel("Cantidad");                          cantidad.setBounds(90, 205, 120, 30);                   panel.add(cantidad);
        cant = new JTextField();                                    cant.setBounds(90, 235, 120, 30);                       panel.add(cant);
        
        b1 = new JButton("¡Vender!");      b1.addActionListener(this);       b1.setBounds(100, 270, 90, 30);      panel.add(b1);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("¡Vender!")){
            File f = new File("Art_Venta.txt");
                
            File f3 = new File("List_Art_Cant_Precio.txt");
            Date fecha = new Date();
            try {
                FileWriter fr = new FileWriter(f,true);
                
                //Guardo los datos en mi archivo Principal para la Cuenta Administrador
                FileWriter fr3 = new FileWriter(f3,true);
                fr.append(nom_art.getText()+";"+precio.getText()+";"+cant.getText()+";"+fecha.toString()+";"+nom_cliente.getText()+";");
                
                //Guardo los datos en mi Archivo para despues mostrarlos en mi clase Comprar_Art
                fr3.append(nom_art.getText()+";"+precio.getText()+";"+cant.getText()+";");
                
                fr.close();
                
                fr3.close();
                JOptionPane.showMessageDialog(this, "Se a agregado a la lista :) , por favor cierra la ventana para continuar");
                
            } catch (IOException ex) {
                
            }
            
        }
    }
    
}
