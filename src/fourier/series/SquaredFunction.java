/* ITESS-TICS
 * Semestre Agosto-Diciembre 2023 
 * ANSYSC
 * Tema 2 Series de Fourier
 * By FJMP
 * 28/09/2023
 */
package fourier.series;

public class SquaredFunction {
    private float T;
    private float f;
    private float[] s;
    private float a0;
    private float[] an;
    private float[] bn;
    
    private float[] t;
    private int nPoints;

    public SquaredFunction(float T, int nPoints) {
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
           s[i]= a0/2;
           for(int n=1; n<=N; n++){
              float an = 0; 
              float bn = 0;
              if (n%2==1){
                 bn = (float)(2/(Math.PI*n));  
              }
               s[i]+= (float)(an*Math.cos(2*Math.PI*f*n*t[i])+
                             bn*Math.sin(2*Math.PI*f*n*t[i]));
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