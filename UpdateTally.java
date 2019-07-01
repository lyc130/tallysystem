package tallysystem;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Rectangle;

public class UpdateTally extends JDialog {
    public UpdateTally(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        try {
            this.setSize(400, 300);
            this.setLocation(300, 300);
            this.setVisible(true);
            this.setResizable(false);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            //      pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public UpdateTally() {
        this(new Frame(), "修改账务信息", false);
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        jLabel1.setText("ID");
        jLabel1.setBounds(new Rectangle(30, 13, 41, 22));
        jLabel2.setText("名称");
        jLabel2.setBounds(new Rectangle(30, 52, 38, 22));
        jTextField2.setBounds(new Rectangle(85, 48, 186, 26));
        jLabel3.setText("必要");
        jLabel3.setBounds(new Rectangle(29, 94, 41, 21));
        jTextField3.setBounds(new Rectangle(85, 90, 185, 27));
        jLabel4.setText("金额");
        jLabel4.setBounds(new Rectangle(29, 133, 45, 21));
        jTextField4.setBounds(new Rectangle(85, 129, 184, 26));
        jLabel5.setText("时间");
        jLabel5.setBounds(new Rectangle(29, 166, 44, 20));
        jTextField5.setBounds(new Rectangle(85, 164, 184, 25));
        jLabel6.setText("描述");
        jLabel6.setBounds(new Rectangle(29, 196, 44, 26));
        jTextField6.setBounds(new Rectangle(85, 197, 183, 26));
        jButton1.setBounds(new Rectangle(130, 239, 77, 24));
        jButton1.setForeground(Color.red);
        jButton1.setText("修改");
        jButton1.addActionListener(new UpdateTally_jButton1_actionAdapter(this));
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jTextField1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jTextField2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jTextField3);
        this.getContentPane().add(jLabel4);
        this.getContentPane().add(jTextField4);
        this.getContentPane().add(jLabel5);
        this.getContentPane().add(jTextField5);
        this.getContentPane().add(jLabel6);
        this.getContentPane().add(jTextField6);
        this.getContentPane().add(jButton1);
        jTextField1.setText("请输入要修改账务的ID");
        jTextField1.setBounds(new Rectangle(85, 10, 187, 28));
        //jTextField1.addMouseListener(new UpdateTally_jTextField1_mouseAdapter(this));
    }

    JLabel jLabel1 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JLabel jLabel2 = new JLabel();
    JTextField jTextField2 = new JTextField();
    JLabel jLabel3 = new JLabel();
    JTextField jTextField3 = new JTextField();
    JLabel jLabel4 = new JLabel();
    JTextField jTextField4 = new JTextField();
    JLabel jLabel5 = new JLabel();
    JTextField jTextField5 = new JTextField();
    JLabel jLabel6 = new JLabel();
    JTextField jTextField6 = new JTextField();
    JButton jButton1 = new JButton();
    public void jTextField1_mouseClicked(MouseEvent e) {
        jTextField1.setText("");
    }

    public void jButton1_actionPerformed(ActionEvent e) {
        String sid = jTextField1.getText().trim();
        String name = jTextField2.getText().trim();
        String necessity = jTextField3.getText().trim();
        String smoney = jTextField4.getText().trim();
        String stime = jTextField5.getText().trim();
        String describe = jTextField6.getText().trim();

        if (sid.length() == 0 || name.length() == 0 || necessity.length() == 0 ||
            jTextField4.getText().trim().length() == 0 ||
            jTextField5.getText().trim().length() == 0 || describe.length() == 0) {
            JOptionPane.showMessageDialog(this, "信息填写不完整", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int id = 0;
        int money=0;
        int time=0;
        try {
            id = Integer.parseInt(sid);
            money = Integer.parseInt(smoney);
            time = Integer.parseInt(stime);
        } catch (NumberFormatException o) {
            JOptionPane.showMessageDialog(this, "格式输入错误", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!(necessity.equals("必要")|| necessity.equals("不必要"))) {
            JOptionPane.showMessageDialog(this, "必要性填写错误", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        TallyBean bean = new TallyBean();
        bean.setId(id);
        bean.setName(name);
        bean.setNecessity(necessity);
        bean.setMoney(money);
        bean.setTime(time);
        bean.setDescribe(describe);
        TallyDAO dao = new TallyDAO();
        ArrayList a = dao.searchById(bean);
        if (a.size() == 0) {
            JOptionPane.showMessageDialog(this, "该ID不存在", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        dao.update(bean, id);
        JOptionPane.showMessageDialog(this, "修改成功", "alert",
                                      JOptionPane.INFORMATION_MESSAGE);
    }
}


class UpdateTally_jButton1_actionAdapter implements ActionListener {
    private UpdateTally adaptee;
    UpdateTally_jButton1_actionAdapter(UpdateTally adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}


class UpdateStu_jTextField1_mouseAdapter extends MouseAdapter {
    private UpdateTally adaptee;
    //UpdateTally_jTextField1_mouseAdapter(UpdateTally adaptee) {
        //this.adaptee = adaptee;
    //}

    public void mouseClicked(MouseEvent e) {
        adaptee.jTextField1_mouseClicked(e);
    }
}
