/* ITESS-TICS
 * Semestre Agosto-Diciembre 2023 
 * ANSYSC
 * Tema 2 Series de Fourier
 * By FJMP
 * 28/09/2023
 */
package fourier.series;

public class TP02_penultimo {
    private float T;
    private float f;
    private float[] s;
    private float a0;
    private float[] an;
    private float[] bn;
    
    private float[] t;
    private int nPoints;

    public TP02_penultimo(float T, int nPoints) {
        this.T = T;
        this.f = 1/T;
        this.nPoints = nPoints; 
    }
    
    public void computeTime(){
        float dt = T/nPoints;
        
        t = new float[nPoints];
        for (int i=0;i<nPoints; i++){
            t[i] = i*dt;
        }          
    }
    
    public void computeSerie(int N){
       float a0 = 1;
 
       s = new float[nPoints];
       for (int i=0; i<nPoints; i++){
           s[i]= 0.1f;
           for(int n=1; n<=N; n++){
              
               s[i]+= (float)(( 
                       0.2*Math.sin(n*2*Math.PI*n*t[i])/(n*Math.PI*t[i])))*(
                             Math.cos(2*Math.PI*f*n*t[i]));
           }
       } 
    }
    
    float[] getTime() {
        return t;
    }
    float[] getSerie() {
        return s;
    }
}