/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrebuilt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.BorderFactory.createBevelBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author GrayHat
 */
public class SelectRevival extends JFrame implements MouseListener {

    JLabel queen, mn, el, horse;
    JPanel board;
    char[][] grid;
    int rr,cc;
    static char element = ';';

    SelectRevival(int r,int c, char[][] gri) {
        iniComponent();
        rr=r;
        cc=c;
        grid=gri;
    }

    public void iniComponent() {
        queen = new JLabel();
        mn = new JLabel();
        el = new JLabel();
        horse = new JLabel();
        board = new JPanel();

        setTitle("SELECT PIECE TO REPLACE");
        setBackground(new java.awt.Color(51, 51, 51));
        getContentPane().setLayout(new AbsoluteLayout());
        setPreferredSize(new Dimension(200, 200));

        queen.setBackground(new Color(102, 102, 102));
        queen.setForeground(new Color(0, 0, 0));
        queen.setBorder(createBevelBorder(BevelBorder.RAISED));
        queen.setIconTextGap(-7);
        queen.setOpaque(true);
        queen.addMouseListener(this);
        queen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/blackqueen.png")));

        mn.setBackground(new Color(102, 102, 102));
        mn.setForeground(new Color(0, 0, 0));
        mn.setBorder(createBevelBorder(BevelBorder.RAISED));
        mn.setIconTextGap(-7);
        mn.setOpaque(true);
        mn.addMouseListener(this);
        mn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/blackmn.png")));

        horse.setBackground(new Color(102, 102, 102));
        horse.setForeground(new Color(0, 0, 0));
        horse.setBorder(createBevelBorder(BevelBorder.RAISED));
        horse.setIconTextGap(-7);
        horse.setOpaque(true);
        horse.addMouseListener(this);
        horse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/blackhorse.png")));

        el.setBackground(new Color(102, 102, 102));
        el.setForeground(new Color(0, 0, 0));
        el.setBorder(createBevelBorder(BevelBorder.RAISED));
        el.setIconTextGap(-7);
        el.setOpaque(true);
        el.addMouseListener(this);
        el.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/blackel.png")));

        board.add(queen, new AbsoluteConstraints(0, 0, 50, 50));
        board.add(mn, new AbsoluteConstraints(50, 0, 50, 50));
        board.add(horse, new AbsoluteConstraints(100, 0, 50, 50));
        board.add(el, new AbsoluteConstraints(150, 0, 50, 50));

        getContentPane().add(board, new AbsoluteConstraints(50, 50, 150, 150));
        pack();
    }

    public void main(char[][] gri, int r, int c) {
        this.grid=gri;
        this.rr=r;
        this.cc=c;
        //SelectRevival ob=new SelectRevival();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                //System.out.println(info.getName());
                if ("GTK+".equalsIgnoreCase(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        lab:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectRevival(r,c,gri).setVisible(true);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("CLICKED " + me.getSource());
        Object src = me.getSource();
        if (src == queen) {
            {
                System.out.println(this.rr+"\t"+this.cc);
                element = 'q';
                this.grid[this.rr][this.cc]=element;
                new Chess(false).main2(this.grid);
            }
        } else if (src == mn) {
            {
                System.out.println(this.rr+"\t"+this.cc);
                element = 'm';
                this.grid[this.rr][this.cc]=element;
                new Chess(false).main2(this.grid);
            }
        } else if (src == horse) {
            {
                System.out.println(this.rr+"\t"+this.cc);
                element = 'h';
                this.grid[this.rr][this.cc]=element;
                new Chess(false).main2(this.grid);
            }
        } else if (src == el) {
            {
                System.out.println(this.rr+"\t"+this.cc);
                element = 'e';
                this.grid[this.rr][this.cc]=element;
                new Chess(false).main2(this.grid);
            }
        } else {
            element = 'r';
        }
        System.out.println(element);
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
}
