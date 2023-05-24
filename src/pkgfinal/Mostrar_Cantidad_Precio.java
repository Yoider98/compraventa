
package pkgfinal;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//Esta seria la clase para el Administrador vea:  Articulo, precio, cantidad, cantidad ventida, etc.

public class Mostrar_Cantidad_Precio extends JFrame{
  
    public JPanel panel;
    
    public Mostrar_Cantidad_Precio() throws HeadlessException, IOException{
        super();
        
        setTitle("Listado Cant_y_Precio");
        setBounds(400, 150, 550, 350);
        
        panel = new JPanel();  panel.setBounds(0, 0, 550, 350);
        
        this.getContentPane().add(panel);
        
        Listado();
        
        this.setVisible(true);
        
    }
    
    private void Listado() throws IOException{
        String colum [] = new String[3];    String dato[][] = new String[50][3];
        colum[0] = "Articulo";
        colum[1] = "Precio";
        colum[2] = "Cantidad";
        
        try {
            
            File f = new File("List_Art_Cant_Precio.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
             
            String cadena;
            
            
            String p []= new String[100];
            
            while((cadena = br.readLine())!=null){
                p = cadena.split(";");
            }
            br.close(); int q = 0; int aux=0;
            
            
            for(int i=0; i<p.length; i++){
                for(int j=0; j<3; j++){
                    if(aux<p.length){
                        dato[i][j] = p[aux];
                        aux++;
                    }
                }
            }
            
            JTable jt = new JTable(dato,colum);             
            jt.setBounds(15, 15, 200, 280);
            JScrollPane scp = new JScrollPane(jt);      
            scp.setBounds(20, 20, 250, 285);
            panel.add(scp);
            
            } catch (IOException ex) {
                Logger.getLogger(Comprar_Art.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
