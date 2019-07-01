package tallysystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class DeleteTally extends JDialog {
    JPanel panel1 = new JPanel();
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
    JButton jButton2 = new JButton();
    public DeleteTally(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public DeleteTally() {
        this(new Frame(), "删除账务信息", false);
    }

    private void jbInit() throws Exception {
        panel1.setLayout(null);
        jLabel1.setText("ID");
        jLabel1.setBounds(new Rectangle(33, 23, 42, 23));
        jTextField1.setBounds(new Rectangle(88, 23, 143, 24));
        jLabel2.setText("名称");
        jLabel2.setBounds(new Rectangle(32, 64, 44, 24));
        jTextField2.setEditable(false);
        jTextField2.setBounds(new Rectangle(89, 65, 141, 24));
        jLabel3.setText("必要");
        jLabel3.setBounds(new Rectangle(31, 99, 44, 22));
        jTextField3.setEditable(false);
        jTextField3.setBounds(new Rectangle(88, 100, 142, 24));
        jLabel4.setText("金额");
        jLabel4.setBounds(new Rectangle(28, 133, 44, 23));
        jTextField4.setEditable(false);
        jTextField4.setBounds(new Rectangle(89, 135, 140, 25));
        jLabel5.setText("时间");
        jLabel5.setBounds(new Rectangle(28, 172, 39, 23));
        jTextField5.setEditable(false);
        jTextField5.setBounds(new Rectangle(89, 169, 140, 25));
        jLabel6.setText("描述");
        jLabel6.setBounds(new Rectangle(27, 202, 44, 27));
        jTextField6.setEditable(false);
        jTextField6.setBounds(new Rectangle(89, 204, 139, 23));
        jButton1.setBounds(new Rectangle(69, 245, 64, 22));
        jButton1.setText("显示");
        jButton1.addActionListener(new DeleteStu_jButton1_actionAdapter(this));
        jButton2.setBounds(new Rectangle(165, 245, 60, 22));
        jButton2.setText("删除");
        jButton2.addActionListener(new DeleteStu_jButton2_actionAdapter(this));
        getContentPane().add(panel1);
        panel1.add(jTextField1);
        panel1.add(jLabel1);
        panel1.add(jLabel2);
        panel1.add(jTextField2);
        panel1.add(jLabel3);
        panel1.add(jTextField3);
        panel1.add(jLabel4);
        panel1.add(jTextField4);
        panel1.add(jLabel5);
        panel1.add(jTextField5);
        panel1.add(jLabel6);
        panel1.add(jTextField6);
        panel1.add(jButton1);
        panel1.add(jButton2);
    }

    public void jButton2_actionPerformed(ActionEvent e) {
        String sid = jTextField1.getText().trim();
        if (sid.length() == 0) {
            JOptionPane.showMessageDialog(this, "ID必须输入", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int id = 0;
        try {
            id = Integer.parseInt(sid);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ID输入错误", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        TallyDAO dao = new TallyDAO();
        TallyBean bean = new TallyBean();
        bean.setId(id);
        ArrayList list = dao.searchById(bean);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "该ID不存在", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       int res= JOptionPane.showConfirmDialog(this,"确定要删除吗？","提示",JOptionPane.OK_CANCEL_OPTION);
       if(res==2){
          return;
       }
       else{
           dao.delete(bean);
           JOptionPane.showMessageDialog(this,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
       }

    }

    public void jButton1_actionPerformed(ActionEvent e) {
        String sid = jTextField1.getText().trim();
        if (sid.length() == 0) {
            JOptionPane.showMessageDialog(this, "ID必须输入", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int id = 0;
        try {
            id = Integer.parseInt(sid);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ID输入错误", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        TallyDAO dao = new TallyDAO();
        TallyBean bean = new TallyBean();
        bean.setId(id);
        ArrayList list = dao.searchById(bean);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "该ID不存在", "alert",
                                          JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        jTextField2.setText(list.get(1).toString().trim());
        jTextField3.setText(list.get(2).toString().trim());
        jTextField4.setText(list.get(3).toString().trim());
        jTextField5.setText(list.get(4).toString().trim());
        jTextField6.setText(list.get(5).toString().trim());
    }
}


class DeleteStu_jButton1_actionAdapter implements ActionListener {
    private DeleteTally adaptee;
    DeleteStu_jButton1_actionAdapter(DeleteTally adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}


class DeleteStu_jButton2_actionAdapter implements ActionListener {
    private DeleteTally adaptee;
    DeleteStu_jButton2_actionAdapter(DeleteTally adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton2_actionPerformed(e);
    }
}
