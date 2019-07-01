package tallysystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.BorderFactory;


public class TallySystemFrame extends JFrame {
    ImageIcon img1;
    ImageIcon img2 = new ImageIcon(
            "image/add.jpg");
    ImageIcon img8 = new ImageIcon(
            "image/openFile.gif");
    ImageIcon img3 = new ImageIcon(
            "image/xiugai.gif");
    ImageIcon img4 = new ImageIcon(
            "image/chazhao.gif");
    ImageIcon img5 = new ImageIcon(
            "image/shanchu.jpg");
    ImageIcon img6 = new ImageIcon(
            "image/closeFile.gif");
    ImageIcon img7 = new ImageIcon(
            "image/help.gif");
    ImageIcon img9 = new ImageIcon(
            "image/caidan.gif");
    ImageIcon img10 = new ImageIcon(
            "image/about.gif");
    JPanel contentPane;
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenu1 = new JMenu();
    JMenuItem jMenuItem1 = new JMenuItem();
    JMenuItem jMenuItem3 = new JMenuItem();
    JMenuItem jMenuItem4 = new JMenuItem();
    JMenuItem jMenuItem5 = new JMenuItem();
    JMenuItem jMenuItem6 = new JMenuItem();
    JMenu jMenu2 = new JMenu();
    JMenuItem jMenuItem7 = new JMenuItem();
    JPanel jPanel1 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JPanel jPanel2;
    JMenuItem jMenuItem2 = new JMenuItem();
    public TallySystemFrame() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setResizable(false);
            jbInit();
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
        img1 = new ImageIcon(
                "image/pingbo.jpg");
        //此时实例化对象，并重写父类的方法
        jPanel2 = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(img1.getImage(), 0, 0, null);
                super.paintComponent(g);
            }
        };

        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);
        this.setJMenuBar(jMenuBar1);
        setSize(new Dimension(300, 400));
        setTitle("小小记账本");
        jMenu1.setFont(new java.awt.Font("新宋体", Font.PLAIN, 13));
        jMenu1.setForeground(Color.blue);
        jMenu1.setIcon(img9);
        jMenu1.setText("菜单");
        jMenuItem1.setFont(new java.awt.Font("新宋体", Font.PLAIN, 13));
        jMenuItem1.setForeground(Color.blue);
        jMenuItem1.setIcon(img2);
        jMenuItem1.setText("添加账务信息");
        jMenuItem1.addActionListener(new
        		TallySystemFrame_jMenuItem1_actionAdapter(this));
        jMenuItem3.setFont(new java.awt.Font("新宋体", Font.PLAIN, 13));
        jMenuItem3.setForeground(Color.blue);
        jMenuItem3.setIcon(img3);
        jMenuItem3.setText("修改账务信息");
        jMenuItem3.addActionListener(new
        		TallySystemFrame_jMenuItem3_actionAdapter(this));

        jMenuItem4.setFont(new java.awt.Font("新宋体", Font.PLAIN, 13));
        jMenuItem4.setForeground(Color.blue);
        jMenuItem4.setIcon(img5);
        jMenuItem4.setText("删除账务信息");
        jMenuItem4.addActionListener(new
        		TallySystemFrame_jMenuItem4_actionAdapter(this));

        jMenuItem5.setFont(new java.awt.Font("新宋体", Font.PLAIN, 13));
        jMenuItem5.setForeground(Color.blue);
        jMenuItem5.setIcon(img8);
        jMenuItem5.setText("浏览所有账务信息");
        jMenuItem5.addActionListener(new
        		TallySystemFrame_jMenuItem5_actionAdapter(this));
        jMenuItem6.setFont(new java.awt.Font("新宋体", Font.PLAIN, 13));
        jMenuItem6.setForeground(Color.blue);
        jMenuItem6.setIcon(img6);
        jMenuItem6.setText("退出");
        //jMenuItem6.addActionListener(new
        		//TallySystemFrame_jMenuItem6_actionAdapter(this));
        jMenu2.setFont(new java.awt.Font("新宋体", Font.PLAIN, 13));
        jMenu2.setForeground(Color.blue);
        jMenu2.setIcon(img7);
        jMenu2.setText("帮助");
        jMenuItem7.setFont(new java.awt.Font("新宋体", Font.PLAIN, 13));
        jMenuItem7.setForeground(Color.blue);
        jMenuItem7.setIcon(img10);
        jMenuItem7.setText("关于我们");
        jMenuItem7.addActionListener(new
        		TallySystemFrame_jMenuItem7_actionAdapter(this));
        jPanel1.setBounds(new Rectangle(1, 1, 10, 10));
        jLabel1.setFont(new java.awt.Font("新宋体", Font.BOLD, 16));
        jLabel1.setForeground(Color.red);
        jLabel1.setText("小小记账本");
        jLabel1.setBounds(new Rectangle(100, 100, 100, 100));
        jLabel2.setFont(new java.awt.Font("新宋体", Font.BOLD, 15));
        jPanel2.setBorder(BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false); //设置图片透明
        jPanel2.setBounds(new Rectangle( -6, 0, 407, 319));
        jPanel2.setLayout(null);
        jMenuItem2.setFont(new java.awt.Font("宋体", Font.PLAIN, 12));
        jMenuItem2.setForeground(Color.blue);
        jMenuItem2.setIcon(img4);
        jMenuItem2.setText("查询账务信息");
        jMenuItem2.addActionListener(new
        		TallySystemFrame_jMenuItem2_actionAdapter(this));
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenu1.addSeparator();
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem3);
        jMenu1.add(jMenuItem4);
        jMenu1.add(jMenuItem5);
        jMenu1.add(jMenuItem6);
        jMenu2.addSeparator();
        jMenu2.add(jMenuItem7);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel1);
        contentPane.add(jPanel2);
    }

    public void jMenuItem1_actionPerformed(ActionEvent e) {
        InsertTally insert = new InsertTally();
    }

    public void jMenuItem5_actionPerformed(ActionEvent e) {
        DisplayAllTally display = new DisplayAllTally();
    }

    public void jMenuItem3_actionPerformed(ActionEvent e) {
        UpdateTally update = new UpdateTally();
    }

    public void jMenuItem7_actionPerformed(ActionEvent e) {
        new AboutUs();
    }


    public void jMenuItem2_actionPerformed(ActionEvent e) {
        SearchTally search = new SearchTally();
        search.setSize(400, 300);
        search.setLocation(300, 300);
        search.setVisible(true);
        search.setResizable(false);

    }

    public void jMenuItem6_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void jMenuItem4_actionPerformed(ActionEvent e) {
        DeleteTally delete = new DeleteTally();
        delete.setSize(400, 300);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        delete.setLocation((width - 400) / 2, (height - 300) / 2);
        delete.setVisible(true);
        delete.setResizable(false);
    }
}


class TallySystemFrame_jMenuItem4_actionAdapter implements ActionListener {
    private TallySystemFrame adaptee;
    TallySystemFrame_jMenuItem4_actionAdapter(TallySystemFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem4_actionPerformed(e);
    }
}


class TallyStuSystemFrame_jMenuItem6_actionAdapter implements ActionListener {
    private TallySystemFrame adaptee;
   // TallySystemFrame_jMenuItem6_actionAdapter(TallySystemFrame adaptee) {
        //this.adaptee = adaptee;
    //}

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem6_actionPerformed(e);
    }
}


class TallySystemFrame_jMenuItem2_actionAdapter implements ActionListener {
    private TallySystemFrame adaptee;
    TallySystemFrame_jMenuItem2_actionAdapter(TallySystemFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem2_actionPerformed(e);
    }
}


class TallySystemFrame_jMenuItem7_actionAdapter implements ActionListener {
    private TallySystemFrame adaptee;
    TallySystemFrame_jMenuItem7_actionAdapter(TallySystemFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem7_actionPerformed(e);
    }
}


class TallySystemFrame_jMenuItem3_actionAdapter implements ActionListener {
    private TallySystemFrame adaptee;
    TallySystemFrame_jMenuItem3_actionAdapter(TallySystemFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {

        adaptee.jMenuItem3_actionPerformed(e);
    }
}


class TallySystemFrame_jMenuItem5_actionAdapter implements ActionListener {
    private TallySystemFrame adaptee;
    TallySystemFrame_jMenuItem5_actionAdapter(TallySystemFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem5_actionPerformed(e);
    }
}


class TallySystemFrame_jMenuItem1_actionAdapter implements ActionListener {
    private TallySystemFrame adaptee;
    TallySystemFrame_jMenuItem1_actionAdapter(TallySystemFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem1_actionPerformed(e);
    }
}
