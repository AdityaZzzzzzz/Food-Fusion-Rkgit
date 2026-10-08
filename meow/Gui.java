/* import java.awt.*;
class Gui
{
    Frame f1; 
    Button b1; // components
    TextField t1; //component

    public Gui()
    {
        f1 = new Frame();
        b1 = new Button("Click");
        t1 = new TextField();

        t1.setBounds(50,50,100,50);
        b1.setBounds(50,120,100,50);

        f1.add(t1);
        f1.add(b1);

        f1.setSize(400,500);
        f1.setLayout(null);
        f1.setVisible(true);
    }

    public static void main(String arg[])
   * {
        new Gui();
    }
} 

import java.awt.*;
import javax.swing.*;
class Gui
{
    JFrame f1; 
    JButton b1; // components
    JTextField t1; //component

    public Gui()
    {
        f1 = new JFrame();
        b1 = new JButton("Click");
        t1 = new JTextField();

        t1.setBounds(50,50,100,50);
        b1.setBounds(50,120,100,50);

        f1.add(t1);
        f1.add(b1);

        f1.setSize(400,500);
        f1.setLayout(null);
        f1.setVisible(true);
    }

    public static void main(String arg[])
    {
        new Gui();
    }
}

import java.awt.*;
import javax.swing.*;

class Gui
{
    JFrame f1;
    JButton b1,b2,bp,be;
    JTextField t1;

    public Gui()
    {
        f1=new JFrame("Calculator");

        b1=new JButton("1");
        b2=new JButton("2");
        bp=new JButton("+");
        be=new JButton("=");

        t1=new JTextField();

        t1.setBounds(50,50,150,40);

        b1.setBounds(50,120,50,50);
        b2.setBounds(120,120,50,50);
        bp.setBounds(190,120,50,50);
        be.setBounds(260,120,50,50);

        f1.add(t1);
        f1.add(b1);
        f1.add(b2);
        f1.add(bp);
        f1.add(be);

        f1.setSize(400,300);
        f1.setLayout(null);
        f1.setVisible(true);
    }

    public static void main(String args[])
    {
        new Gui();
    }
}*/
import javax.swing.*;
import java.awt.event.*;

class Guiims implements ActionListener
{
    JFrame f1;
    JButton b1,b2,bp,be;
    JTextField t1;

    int n1,n2;
    char op;

    public Guiims()
    {
        f1=new JFrame();

        b1=new JButton("1");
        b2=new JButton("2");
        bp=new JButton("+");
        be=new JButton("=");

        t1=new JTextField();

        t1.setBounds(50,50,150,40);

        b1.setBounds(50,120,50,40);
        b2.setBounds(110,120,50,40);
        bp.setBounds(170,120,50,40);
        be.setBounds(230,120,50,40);

        f1.add(t1);
        f1.add(b1);
        f1.add(b2);
        f1.add(bp);
        f1.add(be);

        b1.addActionListener(this);
        b2.addActionListener(this);
        bp.addActionListener(this);
        be.addActionListener(this);

        f1.setSize(400,300);
        f1.setLayout(null);
        f1.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            t1.setText("1");
        }

        if(e.getSource()==b2)
        {
            t1.setText("2");
        }

        if(e.getSource()==bp)
        {
            n1=Integer.parseInt(t1.getText());
            op='+';
            t1.setText("");
        }

        if(e.getSource()==be)
        {
            n2=Integer.parseInt(t1.getText());

            if(op=='+')
            {
                t1.setText(String.valueOf(n1+n2));
            }
        }
    }

    public static void main(String args[])
    {
        new Guiims();
    }
}
