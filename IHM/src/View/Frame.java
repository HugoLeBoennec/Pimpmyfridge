/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Controller;

/**
 *
 * @author rubisetcie
 */
public class Frame extends java.awt.Frame
{
    /** Réference vers le contrôleur. */
    private final Controller controller;
    
    /**
     * Creates new form Frame
     * @param controller le contrôleur
     */
    public Frame(final Controller controller)
    {
        this.controller = controller;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        panel_top = new java.awt.Panel();
        panel_topleft = new java.awt.Panel();
        label_t = new java.awt.Label();
        label_h = new java.awt.Label();
        label_r = new java.awt.Label();
        label_c = new java.awt.Label();
        panel_center = new java.awt.Panel();
        num_t = new java.awt.Label();
        num_h = new java.awt.Label();
        num_r = new java.awt.Label();
        num_c = new java.awt.Label();
        panel_topright = new java.awt.Panel();
        panel_spinner = new java.awt.Panel();
        button_minus = new java.awt.Button();
        panel_condition = new java.awt.Panel();
        num_condition = new java.awt.Label();
        button_plus = new java.awt.Button();
        button_request = new java.awt.Button();
        graph = new view.Graph(this.controller);

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(258, 216));
        setPreferredSize(new java.awt.Dimension(720, 480));
        setSize(new java.awt.Dimension(720, 480));
        setTitle("Pimp My Fridge - IHM");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                exitForm(evt);
            }
        });

        panel_top.setBackground(new java.awt.Color(214, 233, 231));
        panel_top.setLayout(new javax.swing.BoxLayout(panel_top, javax.swing.BoxLayout.X_AXIS));

        panel_topleft.setBackground(new java.awt.Color(214, 233, 231));
        panel_topleft.setLayout(new javax.swing.BoxLayout(panel_topleft, javax.swing.BoxLayout.Y_AXIS));

        label_t.setAlignment(java.awt.Label.RIGHT);
        label_t.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_t.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        label_t.setText("Température :");
        panel_topleft.add(label_t);
        label_t.getAccessibleContext().setAccessibleName("label_t");
        label_t.getAccessibleContext().setAccessibleDescription("");

        label_h.setAlignment(java.awt.Label.RIGHT);
        label_h.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_h.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        label_h.setText("Taux d'humidité :");
        panel_topleft.add(label_h);

        label_r.setAlignment(java.awt.Label.RIGHT);
        label_r.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_r.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        label_r.setText("Point de rosée :");
        panel_topleft.add(label_r);

        label_c.setAlignment(java.awt.Label.RIGHT);
        label_c.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_c.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        label_c.setText("Condensation :");
        panel_topleft.add(label_c);

        panel_top.add(panel_topleft);

        panel_center.setBackground(new java.awt.Color(214, 233, 231));
        panel_center.setLayout(new javax.swing.BoxLayout(panel_center, javax.swing.BoxLayout.Y_AXIS));

        num_t.setAlignment(java.awt.Label.CENTER);
        num_t.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        num_t.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        num_t.setForeground(new java.awt.Color(255, 0, 0));
        num_t.setText("0");
        panel_center.add(num_t);

        num_h.setAlignment(java.awt.Label.CENTER);
        num_h.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        num_h.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        num_h.setForeground(new java.awt.Color(0, 0, 255));
        num_h.setText("0");
        panel_center.add(num_h);

        num_r.setAlignment(java.awt.Label.CENTER);
        num_r.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        num_r.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        num_r.setName(""); // NOI18N
        num_r.setText("0");
        panel_center.add(num_r);

        num_c.setAlignment(java.awt.Label.CENTER);
        num_c.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        num_c.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        num_c.setText("0");
        panel_center.add(num_c);

        panel_top.add(panel_center);

        panel_topright.setBackground(new java.awt.Color(255, 255, 255));
        panel_topright.setLayout(new javax.swing.BoxLayout(panel_topright, javax.swing.BoxLayout.Y_AXIS));

        panel_spinner.setLayout(new javax.swing.BoxLayout(panel_spinner, javax.swing.BoxLayout.X_AXIS));

        button_minus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        button_minus.setLabel("-");
        button_minus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_minusActionPerformed(evt);
            }
        });
        panel_spinner.add(button_minus);

        panel_condition.setLayout(new javax.swing.BoxLayout(panel_condition, javax.swing.BoxLayout.LINE_AXIS));

        num_condition.setAlignment(java.awt.Label.CENTER);
        num_condition.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        num_condition.setText("15 °C");
        panel_condition.add(num_condition);

        button_plus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        button_plus.setLabel("+");
        button_plus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_plusActionPerformed(evt);
            }
        });
        panel_condition.add(button_plus);

        panel_spinner.add(panel_condition);

        panel_topright.add(panel_spinner);

        button_request.setLabel("Confirmer");
        button_request.setMinimumSize(new java.awt.Dimension(160, 24));
        button_request.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_requestActionPerformed(evt);
            }
        });
        panel_topright.add(button_request);

        panel_top.add(panel_topright);

        add(panel_top, java.awt.BorderLayout.NORTH);
        add(graph, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void button_requestActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_button_requestActionPerformed
    {//GEN-HEADEREND:event_button_requestActionPerformed
        this.controller.sendConsigne();
    }//GEN-LAST:event_button_requestActionPerformed

    private void button_plusActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_button_plusActionPerformed
    {//GEN-HEADEREND:event_button_plusActionPerformed
        this.controller.increaseConsigne();
        this.num_condition.setText(this.controller.getConsigne() + " °C");
    }//GEN-LAST:event_button_plusActionPerformed

    private void button_minusActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_button_minusActionPerformed
    {//GEN-HEADEREND:event_button_minusActionPerformed
        this.controller.decreaseConsigne();
        this.num_condition.setText(this.controller.getConsigne() + " °C");
    }//GEN-LAST:event_button_minusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button_minus;
    private java.awt.Button button_plus;
    private java.awt.Button button_request;
    public java.awt.Canvas graph;
    private java.awt.Label label_c;
    private java.awt.Label label_h;
    private java.awt.Label label_r;
    private java.awt.Label label_t;
    public java.awt.Label num_c;
    private java.awt.Label num_condition;
    public java.awt.Label num_h;
    public java.awt.Label num_r;
    public java.awt.Label num_t;
    private java.awt.Panel panel_center;
    private java.awt.Panel panel_condition;
    private java.awt.Panel panel_spinner;
    private java.awt.Panel panel_top;
    private java.awt.Panel panel_topleft;
    private java.awt.Panel panel_topright;
    // End of variables declaration//GEN-END:variables
}
