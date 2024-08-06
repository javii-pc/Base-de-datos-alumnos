package basededatosalumnos;

public class Estudiante {
    private int Clave;
    private String Nombre,Grado;
    
    public Estudiante(int clave, String nombre, String grado){
        this.Clave = clave;
        this.Nombre = nombre;
        this.Grado = grado;
        
    }

    public String getNombre() {
        return this.Nombre;
    }

    public String getGrado() {
        return this.Grado;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    public int getClave() {
        return Clave;
    }
    
    
}
