//这个类用来将所有学生信息显示在一个文本域

package tallysystem;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class DisplayAllTally extends JFrame {
    public DisplayAllTally()
    {
        super("显示所有账务信息");
        TallyDAO dao=new TallyDAO();
        StringBuffer sb=dao.search();
        JTextArea textArea = new JTextArea(sb.toString());
        Container container = getContentPane();
        container.add(new JScrollPane(textArea));
        setSize(500,300);
        int width=Toolkit.getDefaultToolkit().getScreenSize().width;
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width-500)/2-100,(height-300)/2-100);
        setResizable(false);
        setVisible(true);
    }
}
