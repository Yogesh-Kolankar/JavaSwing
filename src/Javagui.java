import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class Javagui implements ActionListener {
    JTextArea area;
    JMenuItem copy,cut,paste,select;
    JScrollPane scroll;
    JFileChooser fileChooser;
    private String text;

    Javagui() {
        JFrame j = new JFrame("TEXT EDITOR");
        // j.setTitle("My First Application");
        j.setLayout(null);
        j.setSize(800, 800);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img=new ImageIcon("Resource/notepad-2642816-2192663.png");
        j.setIconImage(img.getImage());



        //b.setBackground(Color.blue);
        JMenuBar m = new JMenuBar();


        JMenu file = new JMenu("File");
        JMenuItem newdoc = new JMenuItem("New");
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newdoc.addActionListener(this);

        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        exit.addActionListener(this);
        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(exit);

        JMenu edit = new JMenu("Edit");
        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(this);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        JMenuItem cut = new JMenuItem("Cut");
        cut.addActionListener(this);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        JMenuItem paste = new JMenuItem("Paste");
        paste.addActionListener(this);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        JMenuItem select =new JMenuItem("Select All");
        select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        select.addActionListener(this);
        edit.add(select);
        edit.add(copy);
        edit.add(cut);
        edit.add(paste);

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(this);
        help.add(about);
        m.add(file);
        m.add(edit);
        m.add(help);
        j.setJMenuBar(m);
        /*JScrollBar vertical =new JScrollBar();
        vertical.setVisible(true);
        vertical.setBounds(80,80,1520,1520);
        j.add(vertical);*/
        area = new JTextArea();
        area.setBounds(0, 0, 1950, 1050);
        area.setVisible(true);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        scroll = new JScrollPane(area);
        j.add(scroll, BorderLayout.CENTER);
        area.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        j.add(area);
        //area.add();

    }


    public static void main(String[] args) {
        new Javagui();

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("New")) {
            area.setText(null);
        } else if (e.getActionCommand().equals("Save")) {
            JFileChooser fileChooser = new JFileChooser();

            FileNameExtensionFilter restrict = new FileNameExtensionFilter("only.txt files", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(restrict);
            int action = fileChooser.showSaveDialog(null);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;

            } else {
                String filename = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if (filename.contains(".txt"))
                    filename = filename + ".txt";
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                    area.write(writer);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } else if (e.getActionCommand().equals("Open")) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("only.txt files", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(restrict);
            int Action = fileChooser.showOpenDialog(null);
            if (Action != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                try {
                    BufferedReader rea = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                    area.read(rea, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        } else if (e.getActionCommand().equalsIgnoreCase("exit")) {

            System.exit(0);
        } else if (e.getActionCommand().equals("Copy"))
        {           // area.copy();
             text = area.getSelectedText();
        }else if(e.getActionCommand().equals("Cut"))
        {
            //area.cut();
            text=area.getSelectedText();
            area.replaceRange("",area.getSelectionStart(),area.getSelectionEnd());
        }else if(e.getActionCommand().equals("Paste"))
        {   //area.paste();
            area.insert(text,area.getCaretPosition());
        }else if(e.getActionCommand().equals("Select All"))
        {
            area.selectAll();
        }else if(e.getActionCommand().equals("About")){
            new About();

        }
    }
}




