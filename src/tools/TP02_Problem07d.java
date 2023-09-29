/*
 * ITESS-TICS-TI502-ASYSC
 * Agosto-Diciembre 2023
 * U1. Introudcción
 * Descripsión: TP02_Funciones_P7 inciso d
 * by FJMP 
 * 29/09/2023
*/
package tools;

import java.util.ArrayList;

/**
 *
 * @author TICS03
 */
public class TP02_Problem07d {
    private int n;
    private ArrayList<ComplexNumber> z = new ArrayList<>();
    private ArrayList<ComplexNumber> w = new ArrayList<>();
    
    public TP02_Problem07d(int n) {
        this.n = n;
    }

    public ArrayList<ComplexNumber> getZ() {
        return z;
    }

    public ArrayList<ComplexNumber> getW() {
        return w;
    }
    
    
    public void initZ() {
        float delta = 1.0f/this.n;
        
        for (float a = 0.0f; a <= 1.0f; a+= delta)
            for (float b = 0.0f; b <= 1.0f; b+= delta)
                z.add(new ComplexNumber(a,b));
    }
    
    public void computeW() {
        for (ComplexNumber c:z) 
            w.add(c.toN(2));
    }
}
