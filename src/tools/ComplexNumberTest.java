/*
 * ITESS-TICS-TI502-ASYSC
 * Agosto-Diciembre 2023
 * U1. Introudcción
 * Descripsión: Analisis complejo Test
 * by FJMP 
 * 29/09/2023
*/
package tools;

/**
 *
 * @author TICS03
 */
public class ComplexNumberTest {
    public static void main(String [] args) {
        // p1_h
        System.out.println("P1_h)");
        ComplexNumber z1 = new ComplexNumber(-1,2);
        ComplexNumber z2 = new ComplexNumber(4,0);
        ComplexNumber z3 = new ComplexNumber(1,-1);
        ComplexNumber z4 = new ComplexNumber(2,-1);
        ComplexNumber z5 = new ComplexNumber(1,1);
        
        System.out.println(z1);
        System.out.println(z2);
        
        ComplexNumber z1_2 = z1.toN(2);
        ComplexNumber div1 = z2.div(z3);
        ComplexNumber div2 = z4.div(z5);
        
        ComplexNumber add = div1.add(div2);
        ComplexNumber res = z1_2.mult(add);
        
        System.out.println(res);
        
        //  P3 forma polar a)
        System.out.println("3 forma polar a)");
        ComplexNumber p3a = new ComplexNumber(2,-2);
        System.out.println(p3a.toCIS());
    }
}
