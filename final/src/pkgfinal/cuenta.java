
package pkgfinal;

public class cuenta {
    public String nombre;
    public String cargo;
    public String usuario;
    public String contraseña;

    
    public cuenta(String nombre, String cargo, String usuario, String contraseña) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    
    @Override
    public String toString() {
        return nombre + "\n"+cargo +"\n"+ usuario +"\n"+contraseña+"\n";
    }
    
    
}
