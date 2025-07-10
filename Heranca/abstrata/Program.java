import java.lang.reflect.Method;
import java.lang.reflect.Modifier; 

public class Program {
    public static void main(String[] args) {
        try {
            Method metodoArea = FormaGeometrica.class.getDeclaredMethod("area");
            if (Modifier.isAbstract(metodoArea.getModifiers())) {
                System.out.println("area() eh uma funcao abstrata");
            } else {
                System.out.println("area() nao eh uma funcao abstrata");
            }
        } catch (NoSuchMethodException e) { 
            System.out.println("area() nao eh uma funcao");
        } catch (Exception e) { 
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }

        if (Modifier.isAbstract(FormaGeometrica.class.getModifiers())) {
            System.out.println("FormaGeometrica eh uma classe abstrata");
        } else {
            System.out.println("FormaGeometrica nao eh uma classe abstrata");
        }
    }
}