package basededatosalumnos;

import java.util.Scanner;

public class BaseDeDatosAlumnos {

    public static void main(String[] args) {
        //creando arreglo de estudintes 
        Estudiante datos[] = new Estudiante[10];
        //menu para gaurdar estudiantes
        int op = 0;
        Scanner teclado = new Scanner(System.in);
        Scanner letras = new Scanner(System.in);
        while (op != 5) {
            System.out.println("1. Nuevo alumno");
            System.out.println("2. ver alumnos ");
            System.out.println("3. buscar alumno");
            System.out.println("4. Modificar alumno");
            System.out.println("5. Salir");
            System.out.println("Ingrese el numero de opcion ");

            op = teclado.nextInt();
            //opcion uno de nuevo alumno
            if (op == 1) {
                System.out.println("-------------------------------");
                System.out.println("Ingrese la clave");
                int clave = teclado.nextInt();
                System.out.println("-------------------------------");
                System.out.println("Ingrese el nombre ");
                String nombre = letras.nextLine();
                System.out.println("-------------------------------");
                System.out.println("Ingrese el Grado");
                String grado = letras.nextLine();
                System.out.println("-------------------------------");
                System.out.println(nuevoAlumno(clave, nombre, grado, datos));
                System.out.println("-------------------------------");
                //opcion dos ver todos los alumnos registrados 
            } else if (op == 2) {
                System.out.println(imprimirtodo(datos));
            } else if (op == 3) {
                System.out.println("Ingrese la clave ");
                int clave = teclado.nextInt();
                System.out.println(buscaralumno(clave, datos));
            } else if (op == 4) {
                System.out.println("Ingrese la clave ");
                int clave = teclado.nextInt();
                if (buscaralumnoBoleano(clave, datos)) {
                    System.out.println("Ingrese el nuevo nombre ");
                    String nombre = letras.nextLine();
                    System.out.println("-------------------------------");
                    System.out.println("Ingrese el nuevo Grado");
                    String grado = letras.nextLine();

                } else {
                    System.out.println("la clave no existe ");
                }

            }
        }

    }

    //guardar alumnos y ver que las claves no se repitan 
    public static String nuevoAlumno(int clave, String nombre, String grado, Estudiante arreglo[]) {
        boolean lleno = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new Estudiante(clave, nombre, grado);
                lleno = false;
                break;
            } else if (arreglo[i].getClave() == clave) {
                return "ya existe la clave";
            }
        }
        if (!lleno) {
            return "se guardo con exito";
        } else {
            return "ERROR!! Ya no hay espacio";
        }

    }

    public static String imprimirtodo(Estudiante arreglo[]) {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena + arreglo[i].getClave() + "|" + arreglo[i].getNombre() + "|" + arreglo[i].getGrado() + "\n";
            }
        }
        return cadena;
    }

    public static String buscaralumno(int clave, Estudiante arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                return "los datos son \n nombre: " + arreglo[i].getNombre() + "el grado: " + arreglo[i].getGrado();
            }
        }
        return "la cleve no existe";
    }

    public static boolean buscaralumnoBoleano(int clave, Estudiante arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                return true;
            }
        }
        return false;
    }
    
    public static String modificardatos(int clave, String nombre, String grado,Estudiante arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                arreglo[i].setNombre(nombre);
                arreglo[i].setGrado(grado);
                return "se actualizo con exito" ;
            }
        }
        return "";
    }
}
