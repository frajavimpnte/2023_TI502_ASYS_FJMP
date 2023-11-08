/* ITESS-TICS
 * Semestre Agosto-Diciembre 2023 
 * ANSYSC
 * Tema 2 Series de Fourier
 * By FJMP
 * 28/09/2023
 */
package fourier.series;

import tools.*;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author TICS03
 */
public class GraphicsXY extends javax.swing.JFrame {
   
    public GraphicsXY() {
        initComponents();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDraw = new javax.swing.JPanel();
        btnDraw = new javax.swing.JButton();
        lbNaprox = new javax.swing.JLabel();
        tfNAproximation = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDrawMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDrawLayout = new javax.swing.GroupLayout(pnlDraw);
        pnlDraw.setLayout(pnlDrawLayout);
        pnlDrawLayout.setHorizontalGroup(
            pnlDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        pnlDrawLayout.setVerticalGroup(
            pnlDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(pnlDraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 300, 300));

        btnDraw.setText("Draw");
        btnDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrawActionPerformed(evt);
            }
        });
        getContentPane().add(btnDraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        lbNaprox.setText("N aproximation");
        getContentPane().add(lbNaprox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        tfNAproximation.setText("1");
        tfNAproximation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNAproximationActionPerformed(evt);
            }
        });
        getContentPane().add(tfNAproximation, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 50, -1));

        setBounds(0, 0, 656, 488);
    }// </editor-fold>//GEN-END:initComponents

    private void drawAxis() {
        Graphics2D g = (Graphics2D) pnlDraw.getGraphics();
      
        g.setColor(new Color(50, 90, 20));
        g.fillRect(0,0, 300, 300);
        
        g.setColor(Color.white);
        
        // draw x axis, from  (0,0) to  (20, 0)  
        g.drawLine(
                Coordinate.toScreenX(Coordinate.XMIN),
                Coordinate.toScreenY(0.0f),
                Coordinate.toScreenX(Coordinate.XMAX),
                Coordinate.toScreenY(0.0f)
        );
        
        for (float dx = Coordinate.XMIN; dx < Coordinate.XMAX; dx += 1.0) {
            g.drawLine(
                Coordinate.toScreenX(dx),
                Coordinate.toScreenY(0),
                Coordinate.toScreenX(dx),
                Coordinate.toScreenY(0.5f)
            );
        }
        
        // draw y axis, from  (0,0) to  (0, 20)  
        g.drawLine(
                Coordinate.toScreenX(0.0f),
                Coordinate.toScreenY(Coordinate.YMIN),
                Coordinate.toScreenX(0.00f),
                Coordinate.toScreenY(Coordinate.YMAX)
        );
        
        for (float dy = Coordinate.YMIN; dy < Coordinate.YMAX; dy += 1.0) {
            g.drawLine(
                Coordinate.toScreenX(0),
                Coordinate.toScreenY(dy),
                Coordinate.toScreenX(0.5f),
                Coordinate.toScreenY(dy)
            );
        } 
    }
    
    private void drawFunction(int N) {
        //SquaredFunction sf = new SquaredFunction(1.0f, 100);
                
        //sf.computeTime();
        //sf.computeSerie(N);
        
        TP02_15_triangular sf = new TP02_15_triangular((float)(2*Math.PI), 100);
                
        sf.computeTime();
        sf.computeSerie(N);
        
        float x[] = sf.getTime();
        float y[] = sf.getSerie();
      

        // Draw function points
         Graphics2D g = (Graphics2D) pnlDraw.getGraphics();
         g.setColor(Color.white);         
         for (int i = 0; i < x.length - 1; i++) {
             g.drawLine(
                Coordinate.toScreenX(x[i]),
                Coordinate.toScreenY(y[i]),
                Coordinate.toScreenX(x[i+1]),
                Coordinate.toScreenY(y[i+1])
            );
         }
    }
    
    private void pnlDrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDrawMouseClicked
        // TODO add your handling code here:
        int Naprox =  Integer.parseInt( 
                tfNAproximation.getText()
            );
        drawAxis();
        drawFunction(Naprox);
    }//GEN-LAST:event_pnlDrawMouseClicked

    private void btnDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrawActionPerformed
        // TODO add your handling code here:
        int Naprox =  Integer.parseInt( 
                tfNAproximation.getText()
            );
        drawAxis();
        drawFunction(Naprox);
    }//GEN-LAST:event_btnDrawActionPerformed

    private void tfNAproximationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNAproximationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNAproximationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphicsXY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphicsXY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphicsXY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphicsXY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphicsXY().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDraw;
    private javax.swing.JLabel lbNaprox;
    private javax.swing.JPanel pnlDraw;
    private javax.swing.JTextField tfNAproximation;
    // End of variables declaration//GEN-END:variables
}
