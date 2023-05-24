
package pkgfinal;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;


public class loginus extends login implements ActionListener{
   
    public loginus(String string) throws HeadlessException {
        super(string);
        b1.setText("ATENCION AL CLIENTE");
        b1.setBounds(340,50,400, 50);
        b2.addActionListener(this);
        ////////////////////////////////////////////////////////////////////////

        String n ="";
        String c="";
        String u="";
        String co="";
        
        try{
            FileReader fr = new FileReader("usuarios.txt");
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
                                    users.add(c1);
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
            System.out.println(users.get(i).nombre);
            System.out.println(users.get(i).cargo);
            System.out.println(users.get(i).usuario);
            System.out.println(users.get(i).contraseña);
        }*/
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if(e.getActionCommand().equals("INGRESAR")){
            if(!usuario.getText().equals("")&& !contraseña.getText().equals("")){
                for(int j = 0; j < users.size();j++){
                    if(usuario.getText().equals(users.get(j).usuario)&&contraseña.getText().equals(users.get(j).contraseña)){
                        JOptionPane.showMessageDialog(this,"HOLA! "+users.get(j).nombre);
                        portalu p1 = new portalu("Login Cliente");
                        this.setVisible(false);
                    }
                    
                    
                }
            }else{
                JOptionPane.showMessageDialog(this,"Faltan parametros");
            }
        }
        if(e.getActionCommand().equals("VOLVER")){
            users.removeAll(users);     
        }
    }
    
}

