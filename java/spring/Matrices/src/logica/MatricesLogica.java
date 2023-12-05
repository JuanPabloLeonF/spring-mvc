package logica;

import java.util.Scanner;
import modelos.Estudiante;
import modelos.Materias;

public class MatricesLogica {
    
    public Estudiante[][] guardarEstuantes(Estudiante[][] matrizEstuantes) {
        
        Scanner scannerNombre = new Scanner(System.in);
        Scanner scannerNombreMateria = new Scanner(System.in);
        Scanner scannerNota = new Scanner(System.in);
       
        for (int i = 0; i < matrizEstuantes.length; i++) {
            for (int j = 0; j < matrizEstuantes[i].length; j++) {
                
                System.out.print("Digite el nombre del estudante: ");
                String nombre = scannerNombre.nextLine();
                
                System.out.print("Digite el nombre de la materia: ");
                String nombreMateria = scannerNombreMateria.nextLine();
                
                System.out.print("Digite la nota de la materia: ");
                Double nota = scannerNota.nextDouble();
                
                Materias materias = new Materias(nombreMateria, nota);
                
                Estudiante estudiante = new Estudiante(nombre, materias);
                
                matrizEstuantes[i][j] = estudiante;
            }
        }
        
        return matrizEstuantes;
    } 
    
    public void mostrarMatriz(Estudiante[][] estudiantes) {
        for (int i = 0; i < estudiantes.length; i++) {
            for (int j = 0; j < estudiantes.length; j++) {
                System.out.println("Posicion: " + (i + i) + "Estiante: " + estudiantes[i][j]);
            }
        }
    }
}
