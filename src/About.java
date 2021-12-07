import javax.swing.*;
import java.awt.*;

public class About extends JFrame

{
    About()
    {
        JFrame jFrame =new JFrame("About NotePad");
        setTitle("About Notepad");
         setVisible(true);
         setSize(600,600);
        setLayout(null);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         /*ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("Resource/windows10logo.0.0.jpg"));
         Image i2 =image1.getImage().getScaledInstance(400,80,Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
         JLabel l1=new JLabel(i3);
         l1.setBounds(0,40,400,30);
         add(l1);
        // jFrame.add();
        /*ImageIcon icon =new ImageIcon("windows10logo.0.0.jpg");
        jFrame.setIconImage(icon.getImage());
        JLabel ja=new JLabel(new ImageIcon(getClass().getResource("windows10logo.0.0.jpg")));
        ja.setBounds(0,0,200,50);
        jFrame.add(ja);*/
        JLabel Lable=new JLabel();
        Lable.setIcon(new ImageIcon("Resource/download.png"));
        Lable.setBounds(250,40,400,200);
        Lable.setVisible(true);
        add(Lable);
        JLabel Lable2=new JLabel();
        Lable2.setIcon(new ImageIcon("Resource/notepad-2642816-2192663.png"));
        Lable2.setBounds(10,15,400,300);

        Lable.setVisible(true);

        add(Lable2);
        JLabel Jable3 =new JLabel("<html>Notepad is a word processing program, which allows changing of text in a computer file<br> Notepad was created by the Microsoft corporation.<br> It is a text editor, a very simple word processor.<br> It has been a part of Microsoft Windows since 1985.<br> The program has options such as changing the font, the font size, and the font style.<br> The most common use for Notepad is to view or change (edit) text (.txt) files, though .<br>dat and .ini files can be changed in Notepad as well. Many users find Notepad a simple program for creating webpages<html>");
         Jable3.setBounds(150,300,300,300);
         add(Jable3);
        ImageIcon img=new ImageIcon("Resource/notepad-2642816-2192663.png");
        setIconImage(img.getImage());


            }
    public static void main(String[] args)
    {

        About a=new About();

    }
}
