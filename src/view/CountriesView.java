/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CountriesController;
import dao.CountriesDAO;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class CountriesView extends javax.swing.JFrame {

    private String header[] = {"No", "Country Id", "Country Name", "Region"};
    private String headerTable[] = {"country_id", "country_name", "regionId"};
    public CountriesController cc;

    /**
     * Creates new form Countries_view
     */
    public CountriesView() {
        initComponents();
        cc = new CountriesController();
        cc.bindingAll(tblCountries, header);
        cc.loadRegion(cmbRegion);
        reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCountries = new javax.swing.JTable();
        pnlCountries = new javax.swing.JPanel();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCountryId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCountryName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbRegion = new javax.swing.JComboBox<>();
        cmbKategori = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCountries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCountries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCountriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCountries);

        pnlCountries.setBorder(javax.swing.BorderFactory.createTitledBorder("Countries"));
        pnlCountries.setToolTipText("");
        pnlCountries.setName("Countries"); // NOI18N

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        jLabel1.setText("Country Id");

        txtCountryId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCountryIdKeyPressed(evt);
            }
        });

        jLabel2.setText("Country Name");

        jLabel3.setText("Region Id");

        cmbRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRegionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCountriesLayout = new javax.swing.GroupLayout(pnlCountries);
        pnlCountries.setLayout(pnlCountriesLayout);
        pnlCountriesLayout.setHorizontalGroup(
            pnlCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCountriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(pnlCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCountryName, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(cmbRegion, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(pnlCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        pnlCountriesLayout.setVerticalGroup(
            pnlCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCountriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCountriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnhapus)
                    .addComponent(cmbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Country Id", "Country Name", "Region Id" }));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCountries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCari)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCountries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
//        boolean hasil = false;
//        if (!txtCountryId.isEnabled()) {
//
//            hasil = cc.update(txtCountryId.getText(),
//                    txtCountryName.getText(),
//                    Long.parseLong(txtRegionId.getText()));
//            cc.bindingAll(tblCountries, header);
//        } else {
//
//            hasil = cc.insert(txtCountryId.getText(),
//                    txtCountryName.getText(),
//                    Long.parseLong(txtRegionId.getText()));
//            cc.bindingAll(tblCountries, header);
//
//        }
//
//        String pesan = "Gagal Menyimpan Data";
//        if (hasil) {
//            pesan = "Berhasil Menyimpan Data";
//        }
//        JOptionPane.showMessageDialog(this, pesan);
//        reset();
        boolean hasil = false;
        hasil = cc.save(txtCountryId.getText(), txtCountryName.getText(),
                cmbRegion.getSelectedItem().toString(),
                txtCountryId.isEnabled());

        String pesan = "Gagal menyimpan data";
        if (hasil) {
            pesan = "Berhasil menyimpan data";
        }
        JOptionPane.showMessageDialog(this, pesan);
        cc.bindingAll(tblCountries, header);
        reset();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan menghapus data ini?");
//        System.out.println(i);
        if (i == 0) {
            String pesan = "Gagal Hapus";
            boolean hasil = cc.delete(txtCountryId.getText());
            if (hasil) {
                pesan = "Berhasil Hapus";
            }
            JOptionPane.showMessageDialog(this, pesan);
            cc.bindingAll(tblCountries, header);

        }
        reset();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void txtCountryIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryIdKeyPressed
        // TODO add your handling code here:
        btnsimpan.setEnabled(true);
        btnhapus.setEnabled(true);
    }//GEN-LAST:event_txtCountryIdKeyPressed

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
//        String kolom = "";
//        switch (cmbKategori.getSelectedIndex()) {
//            case 0:
//                kolom = "country_id";
//                break;
//            case 1:
//                kolom = "country_name";
//                break;
//            case 2:
//                kolom = "region_id";
//                break;
//            default:
//                throw new AssertionError();
//        }
//        cc.bindingSearch(tblCountries, header, kolom, txtSearch.getText());
        cc.bindingSearch(tblCountries, header,
                headerTable[cmbKategori.getSelectedIndex()],
                txtSearch.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void tblCountriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCountriesMouseClicked
        txtCountryId.setText(tblCountries.getValueAt(tblCountries.getSelectedRow(), 1) + "");
        txtCountryName.setText(tblCountries.getValueAt(tblCountries.getSelectedRow(), 2) + "");
//        txtRegionId.setText(tblCountries.getValueAt(tblCountries.getSelectedRow(), 2) + "");
        txtCountryId.setEnabled(false);
        btnsimpan.setEnabled(true);
        btnhapus.setEnabled(true);
    }//GEN-LAST:event_tblCountriesMouseClicked

    private void cmbRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRegionActionPerformed

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
            java.util.logging.Logger.getLogger(CountriesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CountriesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CountriesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CountriesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CountriesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JComboBox<String> cmbRegion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCountries;
    private javax.swing.JTable tblCountries;
    private javax.swing.JTextField txtCountryId;
    private javax.swing.JTextField txtCountryName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public void reset() {
        txtCountryId.setText("");
        txtCountryName.setText("");
        cmbRegion.setSelectedIndex(0);
        cmbKategori.setSelectedIndex(0);
        txtSearch.setText("");
        txtCountryId.setEnabled(true);
        btnsimpan.setEnabled(false);
        btnhapus.setEnabled(false);
    }
}
