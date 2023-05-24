
package pkgfinal;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.*;

public class loginad extends login implements ActionListener{

    public loginad(String string) throws HeadlessException{
        super(string);
        b1.setText("ADIMISTRADORES");
        b1.setBounds(390,50,300, 50);    
        b2.addActionListener(this);
        
        ////////////////////////////////////////////////////////////////////////

        String n ="";
        String c="";
        String u="";
        String co="";
        
        try{
            FileReader fr = new FileReader("administradores.txt");
            BufferedReader br = new BufferedReader(fr);
            int i = 1;
            String aux="";
            while(true){
                aux = br.readLine();
                if(aux != null){
                    
                    if(i == 1){
                        //System.out.println("nombre "+aux);
                        n = aux;
                        i = 2;
                    }else{
                        if(i == 2){
                            //System.out.println("cargo "+aux);
                            c = aux;
                            i = 3;
                        }else{
                            if(i == 3){
                                //System.out.println("usuario "+aux);
                                u = aux;
                                i = 4;
                            }else{
                                if(i == 4){
                                    //System.out.println("contraseña "+aux);
                                    co = aux;
                                    cuenta c1 = new cuenta(n, c,u, co);
                                    admins.add(c1);
                                    i = 1;
                                }
                            }
                        }
                    }
                    
                }else{
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        /*for(int i = 0; i < admins.size();i++){
            System.out.println(admins.get(i).nombre);
            System.out.println(admins.get(i).cargo);
            System.out.println(admins.get(i).usuario);
            System.out.println(admins.get(i).contraseña);
        }*/
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e); 
        if(e.getActionCommand().equals("INGRESAR")){
            if(!usuario.getText().equals("")&& !contraseña.getText().equals("")){
                for(int j = 0; j < admins.size();j++){
                    if(usuario.getText().equals(admins.get(j).usuario)&&contraseña.getText().equals(admins.get(j).contraseña)){
                        JOptionPane.showMessageDialog(this,"HOLA! "+admins.get(j).nombre);
                        portala p1 = new portala("Login Administrador");
                        this.setVisible(false);
                       
                        
                    }
                }
                
            }else{
                JOptionPane.showMessageDialog(this,"Faltan parametros");
            }
        }
        if(e.getActionCommand().equals("VOLVER")){
            admins.removeAll(admins);     
        }
    }

       
}
