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

package org.poreid.dialogs.pindialogs.modifypin;

import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import org.poreid.config.POReIDConfig;
import org.poreid.dialogs.DialogEventListener;
import org.poreid.dialogs.pindialogs.ButtonAbstractAction;
import org.poreid.dialogs.pindialogs.MyDocument;

/**
 *
 * @author POReID
 */
public class ModifyPinDialog extends javax.swing.JDialog {
    private final String pinLabel;
    private final int pinMinLength;
    private final int pinMaxLength;
    private DialogEventListener<ByteBuffer> listener;
    private final ResourceBundle bundle;
    
    
    public ModifyPinDialog(String pinLabel, int pinMinLength, int pinMaxLength, Locale locale, DialogEventListener<ByteBuffer> listener) {
        super();
        this.pinLabel = pinLabel;
        this.pinMinLength = pinMinLength;
        this.pinMaxLength = pinMaxLength;
        this.listener = listener;
        bundle = POReIDConfig.getBundle(ModifyPinDialog.class.getSimpleName(),locale);
        initComponents();
        
        this.setTitle(MessageFormat.format(bundle.getString("dialog.title"),pinLabel));
        this.getAccessibleContext().setAccessibleDescription(MessageFormat.format(bundle.getString("dialog.description"),pinLabel));
        
        addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                ModifyPinDialog.this.listener.onDiagloclosed();
            }

            @Override
            public void windowOpened(WindowEvent e) {   
                currentPin.requestFocus();
            }
        });
        
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelar");
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "aceitar");
        this.getRootPane().getActionMap().put("cancelar", new ButtonAbstractAction(cancelBtn));
        this.getRootPane().getActionMap().put("aceitar", new ButtonAbstractAction(okBtn));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        okBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        newPinLbl = new javax.swing.JLabel();
        confirmNewPin = new javax.swing.JPasswordField();
        confirmNewPin.setDocument(new MyDocument(pinMaxLength));
        confirmNewPin.setToolTipText(MessageFormat.format(bundle.getString("confirm.pin.tooltip"),pinLabel));
        confirmNewPin.getAccessibleContext().setAccessibleDescription(MessageFormat.format(bundle.getString("confirm.pin.description"), pinLabel));
        confirmPinLbl = new javax.swing.JLabel();
        newPin = new javax.swing.JPasswordField();
        newPin.setDocument(new MyDocument(pinMaxLength));
        newPin.setToolTipText(MessageFormat.format(bundle.getString("new.pin.tooltip"),pinLabel));
        newPin.getAccessibleContext().setAccessibleDescription(MessageFormat.format(bundle.getString("new.pin.description"), pinLabel));
        currentPinLbl = new javax.swing.JLabel();
        currentPin = new javax.swing.JPasswordField();
        currentPin.setDocument(new MyDocument(pinMaxLength));
        currentPin.setToolTipText(MessageFormat.format(bundle.getString("current.pin.tooltip"),pinLabel));
        currentPin.getAccessibleContext().setAccessibleDescription(MessageFormat.format(bundle.getString("current.pin.description"), pinLabel));
        jPanel2 = new javax.swing.JPanel();
        message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(POReIDConfig.IMAGE_WARNING_LOCATION)));
        icon.setMaximumSize(new java.awt.Dimension(64, 64));
        icon.setMinimumSize(new java.awt.Dimension(64, 64));
        icon.setPreferredSize(new java.awt.Dimension(64, 64));
        jPanel1.add(icon);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 0));

        okBtn.setText(bundle.getString("ok.button"));
        okBtn.getAccessibleContext().setAccessibleDescription(MessageFormat.format(bundle.getString("ok.button.description"),pinLabel));
        okBtn.setEnabled(false);
        okBtn.setMaximumSize(new java.awt.Dimension(114, 36));
        okBtn.setMinimumSize(new java.awt.Dimension(114, 36));
        okBtn.setPreferredSize(new java.awt.Dimension(114, 36));
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        jPanel3.add(okBtn);

        cancelBtn.setText(bundle.getString("cancel.button"));
        cancelBtn.getAccessibleContext().setAccessibleDescription(MessageFormat.format(bundle.getString("cancel.button.description"),pinLabel));
        cancelBtn.setMaximumSize(new java.awt.Dimension(114, 36));
        cancelBtn.setMinimumSize(new java.awt.Dimension(114, 36));
        cancelBtn.setPreferredSize(new java.awt.Dimension(114, 36));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        jPanel3.add(cancelBtn);

        newPinLbl.setText(MessageFormat.format(bundle.getString("new.pin.label"), pinLabel));
        newPinLbl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        confirmNewPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confirmNewPin.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                confirmNewPinCaretUpdate(evt);
            }
        });

        confirmPinLbl.setText(MessageFormat.format(bundle.getString("confirm.pin.label"),pinLabel));
        confirmPinLbl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        newPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newPin.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                newPinCaretUpdate(evt);
            }
        });

        currentPinLbl.setText(MessageFormat.format(bundle.getString("current.pin.label"), pinLabel));
        currentPinLbl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        currentPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        currentPin.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                currentPinCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPinLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(confirmPinLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(currentPinLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentPin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmNewPin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentPinLbl)
                    .addComponent(currentPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPinLbl)
                    .addComponent(newPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPinLbl)
                    .addComponent(confirmNewPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        message.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        message.setText(MessageFormat.format(bundle.getString("message"), pinLabel));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(message)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        listener.onCancel();
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    
    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        listener.onContinue(StandardCharsets.UTF_8.encode(CharBuffer.wrap(currentPin.getPassword())), StandardCharsets.UTF_8.encode(CharBuffer.wrap(newPin.getPassword())));
        this.dispose();
    }//GEN-LAST:event_okBtnActionPerformed

    private void currentPinCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_currentPinCaretUpdate
        if (currentPin.getPassword().length > pinMinLength - 1 && newPin.getPassword().length > pinMinLength - 1 && confirmNewPin.getPassword().length > pinMinLength - 1 && Arrays.equals(confirmNewPin.getPassword(), newPin.getPassword())){
            okBtn.setEnabled(true);
        } else {
            okBtn.setEnabled(false);
        }
    }//GEN-LAST:event_currentPinCaretUpdate

    private void newPinCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_newPinCaretUpdate
        if (currentPin.getPassword().length > pinMinLength - 1 && newPin.getPassword().length > pinMinLength - 1 && confirmNewPin.getPassword().length > pinMinLength - 1 && Arrays.equals(confirmNewPin.getPassword(), newPin.getPassword())){
            okBtn.setEnabled(true);
        } else {
            okBtn.setEnabled(false);
        }
    }//GEN-LAST:event_newPinCaretUpdate

    private void confirmNewPinCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_confirmNewPinCaretUpdate
        if (currentPin.getPassword().length > pinMinLength - 1 && newPin.getPassword().length > pinMinLength - 1 && confirmNewPin.getPassword().length > pinMinLength - 1 && Arrays.equals(confirmNewPin.getPassword(), newPin.getPassword())){
            okBtn.setEnabled(true);
        } else {
            okBtn.setEnabled(false);
        }
    }//GEN-LAST:event_confirmNewPinCaretUpdate

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPasswordField confirmNewPin;
    private javax.swing.JLabel confirmPinLbl;
    private javax.swing.JPasswordField currentPin;
    private javax.swing.JLabel currentPinLbl;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel message;
    private javax.swing.JPasswordField newPin;
    private javax.swing.JLabel newPinLbl;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables
}
