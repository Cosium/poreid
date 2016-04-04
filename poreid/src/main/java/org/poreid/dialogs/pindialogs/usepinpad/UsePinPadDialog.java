/*
 * The MIT License
 *
 * Copyright 2014, 2015, 2016 Rui Martinho (rmartinho@gmail.com), António Braz (antoniocbraz@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.poreid.dialogs.pindialogs.usepinpad;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.poreid.config.POReIDConfig;

/**
 *
 * @author POReID
 */
public class UsePinPadDialog extends javax.swing.JDialog {
    private String infoMessage;
    private final String pinLabel;
    private Image image;
    private final ResourceBundle bundle;
    private final PinOperation pinOp;
    
    /**
     * Creates new form UsePinPadDialog
     * @param pinOp operação a realizar no pin (verificação / modificação)
     * @param pinLabel Descrição textual do pin
     * @param pinIcon Icone associado ao pin
     * @param locale Linguagem utilizada
     */
    public UsePinPadDialog(PinOperation pinOp, String pinLabel, byte[] pinIcon, Locale locale) {
        super();
        this.pinLabel = pinLabel;
        try {
            image = ImageIO.read(new ByteArrayInputStream(pinIcon));
        } catch (IOException ex) {
            /* não acontece nada! */
        }
        this.pinOp = pinOp;
        bundle = POReIDConfig.getBundle(UsePinPadDialog.class.getSimpleName(),locale);
        initComponents();
        
        this.setTitle(MessageFormat.format(bundle.getString("dialog."+pinOp.getOperacao()+".title"), pinLabel));
        this.getAccessibleContext().setAccessibleDescription(MessageFormat.format(bundle.getString("dialog."+pinOp.getOperacao()+".description"),pinLabel));
    }
    
    public UsePinPadDialog(PinOperation pinOp, String pinLabel, byte[] pinIcon, Locale locale, String infoMessage) {
        super();
        this.pinLabel = pinLabel;
        try {
            image = ImageIO.read(new ByteArrayInputStream(pinIcon));
        } catch (IOException ex) {
            /* não acontece nada! */
        }
        this.pinOp = pinOp;
        this.infoMessage = infoMessage;
        bundle = POReIDConfig.getBundle(UsePinPadDialog.class.getSimpleName(),locale);
        initComponents();
        
        this.setTitle(MessageFormat.format(bundle.getString("dialog."+pinOp.getOperacao()+".title"), pinLabel));
        this.getAccessibleContext().setAccessibleDescription(MessageFormat.format(bundle.getString("dialog."+pinOp.getOperacao()+".description"),pinLabel));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form
     * Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        jPanel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                //super.paintComponent(g);
                if (null!=infoMessage && !infoMessage.isEmpty()){
                    Dimension arcs = new Dimension(20,20); //Border corners arcs {width,height}, change this to whatever you want
                    int width = getWidth();
                    int height = getHeight();
                    Graphics2D graphics = (Graphics2D) g;
                    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    graphics.setColor(getBackground());
                    graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                }
            }
        };
        lblInfoMessage = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelPin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        background.setPreferredSize(new java.awt.Dimension(410, 262));

        jPanel2.setBackground(new java.awt.Color(84, 199, 252, 170));
        jPanel2.setOpaque(null!=infoMessage && !infoMessage.isEmpty());

        if (null != infoMessage && !infoMessage.isEmpty()){
            lblInfoMessage.setBackground(new java.awt.Color(255, 255, 255));
            lblInfoMessage.setText("<html><body style='width: 280px'>"+infoMessage);
            lblInfoMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            lblInfoMessage.setOpaque(false);
        } else {
            lblInfoMessage.setVisible(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblInfoMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblInfoMessage)
                .addGap(10, 10, 10))
        );

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(172, 69));

        labelPin.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelPin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPin.setText(MessageFormat.format(bundle.getString("dialog."+pinOp.getOperacao()+".message"),pinLabel));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPin, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(labelPin)
                .addGap(0, 84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelPin;
    private javax.swing.JLabel lblInfoMessage;
    // End of variables declaration//GEN-END:variables
}
