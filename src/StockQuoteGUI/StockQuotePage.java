/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockQuoteGUI;
import StockObjects.StockObj;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author calvinlui
 */


public class StockQuotePage extends javax.swing.JFrame {

    /**
     * Creates new form StockQuotePage
     */
    public final int OFF = 0;
    public final int ON = 1;
    StockObj myStock;
    int refreshPerMin;
    int state = OFF;
    
    public StockQuotePage(String inSym, Double inHigh, Double inLow, int inRefresh) {
        initComponents();
        this.myStock = new StockObjects.StockObj(inSym);
        this.myStock.setAlertHigh(inHigh);
        this.myStock.setAlertLow(inLow);
        this.LoadDataToPage();
        this.refreshPerMin = inRefresh; 
    }
    
    public void LoadDataToPage() {
        varSymbol.setText(myStock.getName() + " - " + myStock.getSymbol());
        varTime.setText(myStock.getTime());
        Double price = myStock.getPrice();
        Double high = myStock.getAlertHigh();
        Double low = myStock.getAlertLow();
        varPrice.setText(Double.toString(price));
        if ( (price > high) && (high != 0)) {
            varPrice.setForeground(Color.red);
            Toolkit.getDefaultToolkit().beep();
        } else if ((price < low) && (low != 0)) {
            varPrice.setForeground(Color.red);
            Toolkit.getDefaultToolkit().beep();
        } else {
            varPrice.setForeground(Color.black);
        }
        varOpen.setText(Double.toString(myStock.getOpenPrice()));
        varHigh.setText(Double.toString(myStock.getDayHigh()));
        varLow.setText(Double.toString(myStock.getDayLow()));
    }
    
    public void RefreshOnce() {
        this.myStock.updateQuote();
        this.LoadDataToPage();
    }
    
    
    public void RunInBackground() {
        
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
        varSymbol = new javax.swing.JLabel();
        varTime = new javax.swing.JLabel();
        Open_label = new javax.swing.JLabel();
        varOpen = new javax.swing.JLabel();
        varPrice = new javax.swing.JLabel();
        Price_label = new javax.swing.JLabel();
        High_label = new javax.swing.JLabel();
        Low_label = new javax.swing.JLabel();
        varHigh = new javax.swing.JLabel();
        varLow = new javax.swing.JLabel();
        CloseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock Quote Details"));

        varSymbol.setText("NAME GOES HERE");

        varTime.setText("TIME GOES HERE");

        Open_label.setText("Open:");

        varOpen.setText("OPEN PRICE");

        varPrice.setText("PRICE");

        Price_label.setText("Price:");

        High_label.setText("High:");

        Low_label.setText("Low:");

        varHigh.setText("HIGH");

        varLow.setText("LOW");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(varTime)
                    .addComponent(varSymbol))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Price_label)
                    .addComponent(Open_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(varPrice)
                    .addComponent(varOpen))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(High_label)
                    .addComponent(Low_label))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(varLow)
                    .addComponent(varHigh))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(varSymbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(varTime)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varPrice)
                    .addComponent(Price_label)
                    .addComponent(High_label)
                    .addComponent(varHigh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Open_label)
                    .addComponent(varOpen)
                    .addComponent(Low_label)
                    .addComponent(varLow))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CloseButton)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CloseButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        this.myStock.setValid(false);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JLabel High_label;
    private javax.swing.JLabel Low_label;
    private javax.swing.JLabel Open_label;
    private javax.swing.JLabel Price_label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel varHigh;
    private javax.swing.JLabel varLow;
    private javax.swing.JLabel varOpen;
    private javax.swing.JLabel varPrice;
    private javax.swing.JLabel varSymbol;
    private javax.swing.JLabel varTime;
    // End of variables declaration//GEN-END:variables
}
