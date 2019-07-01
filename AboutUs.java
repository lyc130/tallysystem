package tallysystem;

import java.awt.*;
import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUs extends JFrame {
    ImageIcon img11 = new ImageIcon(
            "image/java.jpg");
    JPanel contentPane;
    JLabel jLabel1 = new JLabel();
    JButton jButton1 = new JButton();
    JLabel jLabel2 = new JLabel();
    public AboutUs() {
        try {
            jbInit();
            this.setLocation(200, 200);
            this.setResizable(false);
            this.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);
        setSize(new Dimension(260, 200));
        setTitle("关于我们");
        jLabel1.setIcon(img11);
        jLabel1.setBounds(new Rectangle(47, 1, 104, 106));
        jButton1.setBounds(new Rectangle(205, 144, 49, 24));
        jButton1.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        jButton1.setForeground(Color.red);
        jButton1.setText("OK");
        jButton1.addActionListener(new AboutUs_jButton1_actionAdapter(this));
        jLabel2.setFont(new java.awt.Font("宋体", Font.PLAIN, 13));
        jLabel2.setForeground(Color.blue);
        jLabel2.setText("3班5组JAVA爱好者");
        jLabel2.setBounds(new Rectangle(60, 80, 200, 28));
        contentPane.add(jLabel1);
        contentPane.add(jLabel2);
        contentPane.add(jButton1);

    }

    public void jButton1_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}


class AboutUs_jButton1_actionAdapter implements ActionListener {
    private AboutUs adaptee;
    AboutUs_jButton1_actionAdapter(AboutUs adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}
