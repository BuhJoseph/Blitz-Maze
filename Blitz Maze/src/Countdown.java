

import java.awt.FlowLayout;
import java.util.Timer;
import java.util.TimerTask;

public class Countdown extends javax.swing.JFrame {

    private int count = 2;

    public Countdown() {
        initComponents();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
            	if(count >= 0)
            		jLabel1.setText("" + count--);
            	System.out.println("100");
            }
        }, 0, 1000);

    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48));
        jLabel1.setText("jLabel1");

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(jLabel1);
        pack();
        setSize(500, 120);
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Countdown().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel jLabel1;
}