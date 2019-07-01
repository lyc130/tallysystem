package tallysystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Rectangle;

public class SearchTally extends JDialog {
    JPanel panel1 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JLabel jLabel2 = new JLabel();
    JTextField jTextField2 = new JTextField();
    JLabel jLabel3 = new JLabel();
    JTextField jTextField3 = new JTextField();
    JTextField jTextField4 = new JTextField();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JTextField jTextField5 = new JTextField();
    JLabel jLabel6 = new JLabel();
    JTextField jTextField6 = new JTextField();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    public SearchTally(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setResizable(false);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public SearchTally() {
        this(new Frame(), "查看账务信息", false);
    }

    private void jbInit() throws Exception {
        panel1.setLayout(null);
        jLabel1.setFont(new java.awt.Font("宋体", Font.PLAIN, 14));
        jLabel1.setText("ID");
        jLabel1.setBounds(new Rectangle(57, 12, 41, 26));
        jTextField1.setBounds(new Rectangle(110, 13, 139, 25));
        jLabel2.setText("名称");
        jLabel2.setBounds(new Rectangle(57, 50, 39, 18));
        jTextField2.setBounds(new Rectangle(110, 46, 138, 25));
        jLabel3.setText("必要");
        jLabel3.setBounds(new Rectangle(57, 86, 40, 22));
        jTextField3.setEditable(false);
        jTextField3.setBounds(new Rectangle(110, 84, 138, 24));
        jTextField4.setEditable(false);
        jTextField4.setBounds(new Rectangle(110, 116, 137, 24));
        jLabel4.setText("金额");
        jLabel4.setBounds(new Rectangle(57, 116, 45, 24));
        jLabel5.setText("时间");
        jLabel5.setBounds(new Rectangle(57, 152, 39, 22));
        jTextField5.setEditable(false);
        jTextField5.setBounds(new Rectangle(110, 150, 136, 25));
        jLabel6.setText("描述");
        jLabel6.setBounds(new Rectangle(57, 187, 42, 25));
        jTextField6.setEditable(false);
        jTextField6.setBounds(new Rectangle(110, 184, 137, 27));
        jButton1.setBounds(new Rectangle(66, 240, 80, 24));
        jButton1.setForeground(Color.red);
        jButton1.setText("按ID查");
        jButton1.addActionListener(new SearchTally_jButton1_actionAdapter(this));
        jButton2.setBounds(new Rectangle(174, 240, 81, 23));
        jButton2.setForeground(Color.red);
        jButton2.setText("按名称查");
        jButton2.addActionListener(new SearchTally_jButton2_actionAdapter(this));
        jButton3.setBounds(new Rectangle(282, 240, 70, 23));
        jButton3.setForeground(Color.red);
        jButton3.setText("重置");
        jButton3.addActionListener(new SearchTally_jButton3_actionAdapter(this));
        getContentPane().add(panel1);
        panel1.add(jTextField1);
        panel1.add(jLabel1);
        panel1.add(jLabel2);
        panel1.add(jTextField2);
        panel1.add(jLabel3);
        panel1.add(jTextField3);
        panel1.add(jTextField4);
        panel1.add(jLabel4);
        panel1.add(jLabel5);
        panel1.add(jTextField5);
        panel1.add(jTextField6);
        panel1.add(jLabel6);
        panel1.add(jButton1);
        panel1.add(jButton2);
        panel1.add(jButton3);
    }

    public void jButton1_actionPerformed(ActionEvent e) {
        String sid = jTextField1.getText().trim();
        int id = 0;
        try {
            id = Integer.parseInt(sid);
        } catch (NumberFormatException en) {
            JOptionPane.showMessageDialog(this, "ID格式输入有误", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        TallyDAO dao = new TallyDAO();
        TallyBean bean = new TallyBean();
        bean.setId(id);
        ArrayList list = dao.searchById(bean);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "没有此ID的账务", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        jTextField2.setText(list.get(1).toString().trim());
        jTextField3.setText(list.get(2).toString().trim());
        jTextField4.setText(list.get(3).toString().trim());
        jTextField5.setText(list.get(4).toString().trim());
        jTextField6.setText(list.get(5).toString().trim());
    }

    public void jButton2_actionPerformed(ActionEvent e) {
        String name = jTextField2.getText().trim();
        TallyDAO dao = new TallyDAO();
        TallyBean bean = new TallyBean();
        bean.setName(name);
        ArrayList list = dao.searchByName(bean);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "找不到此名称的账务", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        jTextField1.setText(list.get(0).toString().trim());
        jTextField3.setText(list.get(2).toString().trim());
        jTextField4.setText(list.get(3).toString().trim());
        jTextField5.setText(list.get(4).toString().trim());
        jTextField6.setText(list.get(5).toString().trim());

    }

    public void jButton3_actionPerformed(ActionEvent e) {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
    }
}


class SearchTally_jButton3_actionAdapter implements ActionListener {
    private SearchTally adaptee;
    SearchTally_jButton3_actionAdapter(SearchTally adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton3_actionPerformed(e);
    }
}


class SearchTally_jButton2_actionAdapter implements ActionListener {
    private SearchTally adaptee;
    SearchTally_jButton2_actionAdapter(SearchTally adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton2_actionPerformed(e);
    }
}


class SearchTally_jButton1_actionAdapter implements ActionListener {
    private SearchTally adaptee;
    SearchTally_jButton1_actionAdapter(SearchTally adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}
