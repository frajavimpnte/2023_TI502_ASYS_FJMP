/* ITESS-TICS
 * Semestre Agosto-Diciembre 2023 
 * ANSYSC
 * Tema 2 Series de Fourier
 * By FJMP
 * 28/09/2023
 */
package fourier.series;

public class TP02_15_triangular {
    private float T;
    private float f;
    private float[] s;
    private float a0;
    private float[] an;
    private float[] bn;
    
    private float[] t;
    private int nPoints;

    public TP02_15_triangular(float T, int nPoints) {
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
       float a0 =  0.0f;
       float An[] = {
            -1.7132e-08f,
            2.6911e-08f,
            5.7106e-09f,
            -2.6911e-08f,
            -3.4264e-09f,
            2.6911e-08f,
            2.4474e-09f,
            -2.6911e-08f,
            -1.9035e-09f,
            2.6911e-08f
           };
       
       float Bn[] = {
            1.2732f,
            7.2419e-16f,
           -0.1415f,
           -1.4484e-15f,
            0.050930f,
            2.1726e-15f,
           -0.025985f,
           -2.8968e-15f,
            0.015719f,
            3.6209e-15f
       };
 
       if (N >= 10) N = 10;
       s = new float[nPoints];
       for (int i=0; i<nPoints; i++){
           s[i]= a0/2;
           for(int n=1; n<=N; n++){
               float an = An[n-1];
               float bn = Bn[n-1];
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