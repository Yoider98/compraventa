
package pkgfinal;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Comprar_Art extends JFrame implements ActionListener{
    public JPanel panel;
    public JTable jt;
    public JLabel comp = new JLabel("Buscar Articulo");
    public JTextField cuadro = new JTextField();
    public JButton b1 = new JButton("¡Comprar!");
    public JLabel can = new JLabel("Cantidad");
    public JTextField cant = new JTextField();
    
    public Comprar_Art() throws HeadlessException, IOException{
        
        super();
        setBounds(400, 150, 600, 400);
        setTitle("Compra");
        
        panel = new JPanel();            panel.setLayout(null);      this.getContentPane().add(panel);
        
        Listado_Venta();
        
        setVisible(true);
    }
    
    
    private void Listado_Venta() throws FileNotFoundException{
        String colum [] = new String[3];    String dato[][] = new String[50][3];
        colum[0] = "         Articulo   ";
        colum[1] = "Precio  ";
        colum[2] = "Cantidad ";
        
        comp.setBounds(425, 25, 110, 30); panel.add(comp);
        cuadro.setBounds(400, 60, 150, 30); panel.add(cuadro);
        can.setBounds(400, 100, 90, 30);   panel.add(can);
        cant.setBounds(460, 100, 60, 30);  panel.add(cant);
        b1.setBounds(425, 150, 90, 30);    b1.addActionListener(this);  panel.add(b1);
        
        try {
            
            File f = new File("List_Art_Cant_Precio.txt"); //Cargo el archivo
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
             
            String cadena;
            
            
            String p []= new String[100];  //Creo un vector donde guardar los datos de mi archivo, y no, no sirve con ArrayList
            
            while((cadena = br.readLine())!=null){
                p = cadena.split(";");  //Por cada ";" Guardo el contenido a mi vector
            }
            br.close(); int q = 0; int aux=0;
            
            
            for(int i=0; i<p.length; i++){
                for(int j=0; j<3; j++){
                    if(aux<p.length){
                        dato[i][j] = p[aux];  //Guardo los datos de mi vector en mi tabla
                        aux++;
                    }
                }
            }
            
            jt = new JTable(dato,colum);            jt.enable(false);
            jt.setBounds(15, 15, 325, 280);         
            JScrollPane scp = new JScrollPane(jt);       //panel.add(jt);
            scp.setBounds(20, 20, 335, 285);    
            panel.add(scp);
            
            
            } catch (IOException ex) {
                Logger.getLogger(Comprar_Art.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    private void Guardar_Compra(String p[]) throws IOException{
        File f = new File("List_Art_Cant_Precio.txt");
        f.delete(); //Borro el archivo
        try{
            f.createNewFile(); //Creo otro archivo PORQUE NO SABIA COMO RAYOS REESCRIBIRLO!!!
            f = new File("List_Art_Cant_Precio.txt");
            FileWriter fw = new FileWriter(f);
            
            //Escribo la informacion que contiene el vector P a mi archivo
            for(int i=0;i<p.length ;i++){
                fw.append(p[i]+";");
            }
            
            fw.close();
        }catch(IOException e){
            
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("¡Comprar!")){
            try{
                File f = new File("List_Art_Cant_Precio.txt");
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
             
                String cadena;
            
            
                String p []= new String[100];
            // Guardo el contenido de mi archivo en un vector
                while((cadena = br.readLine())!=null){
                    p = cadena.split(";");  //Por cada ";" que encuentre guarde lo obtenido en mi vector
                }   
                br.close(); boolean prueba=false;  int m = Integer.parseInt(cant.getText()); //creo variables auxiliares
                
                //Pregunto antes si el cuadro de texto de "cantidad" no este vacio
                if(!cant.getText().equals("")){
                    for(int i=0; i<p.length; i++){
                        if(cuadro.getText().equalsIgnoreCase(p[i])){  //comparo si lo digitado en el cuadro de texto coincide con el nombre del articulo a comprar
                            int n = Integer.parseInt(p[i+2]);
                            if(m<=n){ //Pregunto si la cantidad es menor o igual a la disponible
                                String resul = String.valueOf(n-m);
                                p[i+2]=resul; prueba=true;
                                JOptionPane.showMessageDialog(this, "Su compra a sido añadida al carrito :) , Por favor cierre la ventana para continuar con la compra");
                            }
                            else{
                                JOptionPane.showMessageDialog(this, "La cantidad que desea comprar supera la disponible del producto");
                            }
                            break;
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "La cantidad esta vacio,  favor completar la especificacion");
                }
                
                
                if(prueba==false){
                    System.out.println("NO EXISTE EL ARTICULO");
                }
            
                /*  EJEMPLO DEL CONTENIDO DE MI VECTOR
                for(int i=0; i<p.length; i++){
                    System.out.println(p[i]);
                }
                */
                Guardar_Compra(p);  //Al final llamo mi funcion para guardar los nuevos datos en  mi archivo
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(this, "El Archivo no existe");
                //Ya me dio flojera escribir :v
            }
        }
    }
    
}
