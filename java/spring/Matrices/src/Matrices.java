
import logica.MatricesLogica;
import modelos.Estudiante;

public class Matrices {

    public static void main(String[] args) {
        
        MatricesLogica matricesLogica = new MatricesLogica();
        
        Estudiante[][] matrizEstuantes = new Estudiante[3][3];
        
        matricesLogica.guardarEstuantes(matrizEstuantes);
        matricesLogica.mostrarMatriz(matrizEstuantes);
        
    }
}
