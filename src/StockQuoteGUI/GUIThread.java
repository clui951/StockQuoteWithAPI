/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockQuoteGUI;

/**
 *
 * @author calvinlui
 */
public class GUIThread extends Thread {
    
    String threadSym;
    Double threadHigh;
    Double threadLow;
    int threadRefresh;
    boolean notFin;
    
    public void run() {
        notFin = true;
        StockQuotePage myStockPage = new StockQuotePage(threadSym, threadHigh, threadLow, threadRefresh);
        myStockPage.setVisible(true);
        if (threadRefresh != 0) {
            while (notFin) {
                try {
                    Thread.sleep(1000 * threadRefresh);
                    notFin = myStockPage.myStock.isValid();
                } catch (Exception e) {}
                myStockPage.RefreshOnce();
            }
        }
    }
    
    public void getArgs(String inSym, Double inHigh, Double inLow, int inRefresh) {
        this.threadSym = inSym;
        this.threadHigh = inHigh;
        this.threadLow = inLow;
        this.threadRefresh = inRefresh;
    }
    
}
