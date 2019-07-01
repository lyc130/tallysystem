package tallysystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class InsertTally extends JFrame {
    JPanel contentPane;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JTextField jTextField1 = new JTextField();
    JTextField jTextField2 = new JTextField();
    JTextField jTextField4 = new JTextField();
    JTextField jTextField5 = new JTextField();
    JTextField jTextField6 = new JTextField();
    JRadioButton jRadioButton1 = new JRadioButton();
    JRadioButton jRadioButton2 = new JRadioButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    public InsertTally() {
        try {
            this.setSize(400,400);
            this.setLocation(300,300);
            this.setResizable(false);
            this.setVisible(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);
        setSize(new Dimension(500, 350));
        setTitle("账务信息管理");
        jLabel1.setFont(new java.awt.Font("新宋体", Font.BOLD, 14));
        jLabel1.setText("插入账务信息");
        jLabel1.setBounds(new Rectangle(160, 4, 99, 33));
        jLabel2.setFont(new java.awt.Font("新宋体", Font.BOLD, 13));
        jLabel2.setText("ID");
        jLabel2.setBounds(new Rectangle(100, 40, 45, 32));
        jLabel3.setFont(new java.awt.Font("新宋体", Font.BOLD, 12));
        jLabel3.setText("名称");
        jLabel3.setBounds(new Rectangle(100, 75, 45, 32));
        jLabel4.setFont(new java.awt.Font("新宋体", Font.BOLD, 12));
        jLabel4.setText("必要");
        jLabel4.setBounds(new Rectangle(100, 111, 45, 26));
        jLabel5.setFont(new java.awt.Font("新宋体", Font.BOLD, 12));
        jLabel5.setText("金额");
        jLabel5.setBounds(new Rectangle(100, 150, 45, 29));
        jLabel6.setFont(new java.awt.Font("新宋体", Font.BOLD, 12));
        jLabel6.setText("时间");
        jLabel6.setBounds(new Rectangle(100, 188, 45, 31));
        jLabel7.setFont(new java.awt.Font("新宋体", Font.BOLD, 12));
        jLabel7.setText("描述");
        jLabel7.setBounds(new Rectangle(100, 222, 45, 28));
        jButton1.setBounds(new Rectangle(115, 271, 63, 27));
        jButton1.setFont(new java.awt.Font("楷体_GB2312", Font.BOLD, 13));
        jButton1.setText("添加");
        jButton1.addActionListener(new TallyManageFrame_jButton1_actionAdapter(this));
        jButton2.setBounds(new Rectangle(240, 271, 65, 27));
        jButton2.setFont(new java.awt.Font("楷体_GB2312", Font.BOLD, 13));
        jButton2.setText("重置");
        jButton2.addActionListener(new StuManageFrame_jButton2_actionAdapter(this));
        jTextField1.setBounds(new Rectangle(157, 43, 94, 25));
        jTextField2.setBounds(new Rectangle(157, 76, 94, 25));
        jTextField4.setBounds(new Rectangle(157, 145, 94, 27));
        jTextField5.setBounds(new Rectangle(157, 187, 94, 24));
        jTextField6.setBounds(new Rectangle(157, 223, 272, 27));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Y");
        jRadioButton1.setBounds(new Rectangle(157, 115, 45, 24));
        jRadioButton2.setText("N");
        jRadioButton2.setBounds(new Rectangle(209, 115, 39, 24));
        contentPane.add(jLabel1);
        contentPane.add(jTextField6);
        contentPane.add(jLabel7);
        contentPane.add(jTextField5);
        contentPane.add(jTextField4);
        contentPane.add(jTextField2);
        contentPane.add(jTextField1);
        contentPane.add(jLabel6);
        contentPane.add(jLabel5);
        contentPane.add(jLabel4);
        contentPane.add(jLabel3);
        contentPane.add(jLabel2);
        contentPane.add(jButton2);
        contentPane.add(jButton1);
        contentPane.add(jRadioButton1);
        contentPane.add(jRadioButton2);
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
    }

    public void jButton1_actionPerformed(ActionEvent e) {
        String ID = jTextField1.getText().trim();
        String name = jTextField2.getText().trim();
        String necessity = "";
        if (jRadioButton1.isSelected()) {
            necessity = "Y";
        }
        if (jRadioButton2.isSelected()) {
            necessity = "N";
        }
        String smoney = jTextField4.getText().trim();
        String sc = jTextField5.getText().trim();
        String describe = jTextField6.getText().trim();
       if (ID.length() == 0 || name.length() == 0 || smoney.length() == 0 ||
           sc.length() == 0 || describe.length() == 0) {
           JOptionPane.showMessageDialog(this, "信息填写不完整", "alert",
                                         JOptionPane.INFORMATION_MESSAGE);
           return;
       }
        int id = 0;
        try {
            id = Integer.parseInt(ID);
        } catch (NumberFormatException f) {
            JOptionPane.showMessageDialog(this, "id必须输入整数", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int money = 0;
        try {
            money = Integer.parseInt(smoney);
        } catch (NumberFormatException x) {
            JOptionPane.showMessageDialog(this, "金额必须输入整数", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (money < 0) {
            JOptionPane.showMessageDialog(this, "时间是大于0的整数", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int time = 0;
        try {
            time = Integer.parseInt(sc);
        } catch (NumberFormatException fo) {
            JOptionPane.showMessageDialog(this, "金额输入错误，必须输入整数", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        TallyDAO dao = new TallyDAO();
        TallyBean bean = new TallyBean();
        bean.setId(id);
        bean.setName(name);
        bean.setMoney(money);
        bean.setNecessity(necessity);
        bean.setTime(time);
        bean.setDescribe(describe);
        ArrayList list=dao.searchById(bean);
        if(list.size()>0){
            JOptionPane.showMessageDialog(this,"该ID已经存在","alert",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        dao.insert(bean);
        JOptionPane.showMessageDialog(this,"添加账务信息成功","alert",JOptionPane.INFORMATION_MESSAGE);

    }

    public void jButton2_actionPerformed(ActionEvent e) {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
    }

}


class StuManageFrame_jButton2_actionAdapter implements ActionListener {
    private InsertTally adaptee;
    StuManageFrame_jButton2_actionAdapter(InsertTally adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton2_actionPerformed(e);
    }
}


class TallyManageFrame_jButton1_actionAdapter implements ActionListener {
    private InsertTally adaptee;
    TallyManageFrame_jButton1_actionAdapter(InsertTally adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}
