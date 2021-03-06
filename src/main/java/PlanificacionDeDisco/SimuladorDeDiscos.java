/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanificacionDeDisco;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author irmal
 */
public class SimuladorDeDiscos extends javax.swing.JFrame {

    /**
     * Creates new form SimuladorDeDiscos
     */
    public SimuladorDeDiscos() {
        initComponents();
        //setIconImage(getIconImage());
        this.setLocationRelativeTo(null);
        

    }
    
    /*@Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("recursos/icon.png"));
        return retValue;
    }*/
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Opciones = new javax.swing.ButtonGroup();
        tituloLabel = new javax.swing.JLabel();
        EjercicioOption = new javax.swing.JRadioButton();
        PlanificacionOption = new javax.swing.JRadioButton();
        IniciarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador");
        setResizable(false);

        tituloLabel.setText("Simulador de discos");

        Opciones.add(EjercicioOption);
        EjercicioOption.setText("Calcular");
        EjercicioOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EjercicioOptionMouseClicked(evt);
            }
        });
        EjercicioOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EjercicioOptionActionPerformed(evt);
            }
        });

        Opciones.add(PlanificacionOption);
        PlanificacionOption.setText("Planificaci??n");
        PlanificacionOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlanificacionOptionMouseClicked(evt);
            }
        });

        IniciarBtn.setText("Iniciar");
        IniciarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloLabel)
                    .addComponent(PlanificacionOption)
                    .addComponent(EjercicioOption))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IniciarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tituloLabel)
                .addGap(30, 30, 30)
                .addComponent(EjercicioOption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlanificacionOption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(IniciarBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarBtnActionPerformed
        // Ingresar direcciones de pedidos
        if(EjercicioOption.isSelected()) {
           Ejercicios e= new Ejercicios();
           e.setVisible(true);
           this.setVisible(false);
        }
        else if(PlanificacionOption.isSelected()){ 
            PlanificacionesPrincipal plan= new PlanificacionesPrincipal(); 
            plan.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_IniciarBtnActionPerformed

    private void EjercicioOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EjercicioOptionActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_EjercicioOptionActionPerformed

    private void EjercicioOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EjercicioOptionMouseClicked
        // TODO add your handling code here:
       

  
       
    }//GEN-LAST:event_EjercicioOptionMouseClicked

    private void PlanificacionOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlanificacionOptionMouseClicked
      
    }//GEN-LAST:event_PlanificacionOptionMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimuladorDeDiscos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimuladorDeDiscos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimuladorDeDiscos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimuladorDeDiscos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimuladorDeDiscos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton EjercicioOption;
    private javax.swing.JButton IniciarBtn;
    private javax.swing.ButtonGroup Opciones;
    private javax.swing.JRadioButton PlanificacionOption;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}
