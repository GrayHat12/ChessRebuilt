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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static javax.swing.BorderFactory.createBevelBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author GrayHat
 */
public class Chess extends JFrame implements MouseListener {

    JPanel board;
    JLabel block[][] = new JLabel[8][8], msg, dead;
    JButton save, load, replay, undo;
    char grid[][] = new char[8][8];

    public Chess(boolean first) {
        if (first) {
            initGrid();
        }
        initBlock();
        updateBlock();
        initComponents();
    }

    private void initComponents() {
        board = new JPanel();
        load = new JButton();
        save = new JButton();
        replay = new JButton();
        msg = new JLabel();
        dead = new JLabel();
        undo = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ghess");
        setBackground(new java.awt.Color(51, 51, 51));
        getContentPane().setLayout(new AbsoluteLayout());

        board.setBackground(new java.awt.Color(255, 255, 255));
        board.setForeground(new java.awt.Color(0, 0, 0));
        board.setOpaque(false);
        board.setPreferredSize(new Dimension(400, 400));
        board.setLayout(new AbsoluteLayout());

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                block[i][j].addMouseListener(this);
                board.add(block[i][j], new AbsoluteConstraints(j * 50, i * 50, 50, 50));
            }
        }

        getContentPane().add(board, new AbsoluteConstraints(20, 20, -1, -1));

        undo.setText("UNDO");
        undo.addMouseListener(this);
        getContentPane().add(undo, new AbsoluteConstraints(523, 249, 75, -1));
        
        load.setText("LOAD");
        load.addMouseListener(this);
        getContentPane().add(load, new AbsoluteConstraints(523, 74, 75, -1));

        save.setText("SAVE");
        save.addMouseListener(this);
        getContentPane().add(save, new AbsoluteConstraints(523, 131, 75, -1));

        replay.setText("REPLAY");
        replay.addMouseListener(this);
        getContentPane().add(replay, new AbsoluteConstraints(523, 192, -1, -1));

        msg.setHorizontalAlignment(SwingConstants.CENTER);
        msg.setText("--WELCOME--");
        getContentPane().add(msg, new AbsoluteConstraints(454, 305, 210, 30));

        dead.setHorizontalAlignment(SwingConstants.CENTER);
        dead.setText("-");
        getContentPane().add(dead, new AbsoluteConstraints(20, 450, 400, 30));

        pack();
    }

    public static void main(String[] args) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chess(true).setVisible(true);
            }
        });
    }

    public void main2(char gri[][]) {
        grid=gri;
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Chess ob=new Chess(false);
                ob.updateGrid(gri);
                ob.updateBlock();
                ob.setVisible(true);
            }
        });
    }

    public void initGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = ';';
            }
        }

        grid[0][0] = 'e';
        grid[0][1] = 'h';
        grid[0][2] = 'm';
        grid[0][3] = 'q';
        grid[0][4] = 'k';
        grid[0][5] = 'm';
        grid[0][6] = 'h';
        grid[0][7] = 'e';
        for (int i = 0; i < 8; i++) {
            grid[1][i] = 'p';
        }

        grid[7][0] = 'E';
        grid[7][1] = 'H';
        grid[7][2] = 'M';
        grid[7][3] = 'Q';
        grid[7][4] = 'K';
        grid[7][5] = 'M';
        grid[7][6] = 'H';
        grid[7][7] = 'E';
        for (int i = 0; i < 8; i++) {
            grid[6][i] = 'P';
        }
    }

    public void initBlock() {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                block[i][j] = new JLabel();
                if (count % 2 == 0) {
                    block[i][j].setBackground(new Color(255, 255, 255));
                    block[i][j].setForeground(new Color(0, 0, 0));
                } else {
                    block[i][j].setBackground(new Color(102, 102, 102));
                }
                block[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                block[i][j].setText(i + "" + j);
                block[i][j].setBorder(createBevelBorder(BevelBorder.RAISED));
                block[i][j].setIconTextGap(-7);
                block[i][j].setOpaque(true);
                count += 1;
            }
            count -= 1;
        }
    }

    public void updateGrid(char grid[][]) {
        grid = grid;
    }

    public void updateBlock() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                block[i][j].setText(i + "" + j);
                block[i][j].setIcon(null);
                switch (grid[i][j]) {
                    case 'e':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/blackel.png")));
                        block[i][j].setText("");
                        break;
                    case 'h':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/blackhorse.png")));
                        block[i][j].setText("");
                        break;
                    case 'm':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/blackmn.png")));
                        block[i][j].setText("");
                        break;
                    case 'q':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/blackqueen.png")));
                        block[i][j].setText("");
                        break;
                    case 'k':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/blackking.png")));
                        block[i][j].setText("");
                        break;
                    case 'p':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/blackpawn.png")));
                        block[i][j].setText("");
                        break;
                    case 'E':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/whiteel.png")));
                        block[i][j].setText("");
                        break;
                    case 'H':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/whitehorse.png")));
                        block[i][j].setText("");
                        break;
                    case 'M':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/whitemn.png")));
                        block[i][j].setText("");
                        break;
                    case 'Q':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/whitequeen.png")));
                        block[i][j].setText("");
                        break;
                    case 'K':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/whiteking.png")));
                        block[i][j].setText("");
                        break;
                    case 'P':
                        block[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/whitepawn.png")));
                        block[i][j].setText("");
                        break;
                    default:
                        break;
                }
            }
        }
    }

    int pi = -1, pj = -1;
    
    private boolean checkWin() {
        boolean kp=false;
        boolean Kp=false;
        for(int i=0;i<64;i++)
        {
            if(grid[i/8][i%8]=='k')
                kp=true;
            else if(grid[i/8][i%8]=='K')
                Kp=true;
        }
        if(!kp)
            msg.setText("COMPUTER WINS");
        if(!Kp)
            msg.setText("YOU WIN");
        return(kp&&Kp);
    }

    private void endGame() {
        for(int i=0;i<64;i++)
        {
            block[i/8][i%8].setEnabled(false);
        }
    }
    
    public boolean pawnEnd()
    {
        System.out.println("CHECKING PAWN END");
        boolean out=false;
        for(int i=0;i<8;i++)
        {
            if(this.grid[7][i]=='p')
                out=true;
        }
        System.out.println("PAWN END = "+out);
        for(int i=0;i<8;i++)
        {
            if(this.grid[0][i]=='P')
            {
                this.grid[0][i]='Q';
                updateBlock();
            }
        }
        return out;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        boolean cond=true;
        System.out.println("Mouse Clicked");
        Object src = me.getSource();
        ValidMoves ob=new ValidMoves();
        for (int i = 0; i < 64 && cond; i++) {
                System.out.println("LOOP : "+(i/8)+""+(i%8));
                if (src == block[i/8][i%8]) {
                    System.out.println("\nSource : "+(i/8)+""+(i%8));
                    if (pi == -1 && pj == -1) {
                        System.out.println("Previous -1");
                        if (grid[i/8][i%8] == 'e' || grid[i/8][i%8] == 'h' || grid[i/8][i%8] == 'm' || grid[i/8][i%8] == 'q' || grid[i/8][i%8] == 'k' || grid[i/8][i%8] == 'p') {
                            pi = i/8;
                            pj = i%8;
                            System.out.println("Previous -1 > Clicked black piece");
                            //print();
                            return;
                        }
                        else
                            return;
                    }
                    if ((pi!=-1&&pj!=-1)&&(grid[i/8][i%8] == 'e' || grid[i/8][i%8] == 'h' || grid[i/8][i%8] == 'm' || grid[i/8][i%8] == 'q' || grid[i/8][i%8] == 'k' || grid[i/8][i%8] == 'p')) {
                        pi = i/8;
                        pj = i%8;
                        System.out.println("Previous ! -1 && Clicked Black piece");
                        //print();
                        return;
                    }
                    List<String> moves = ob.getMovesUser(grid, pi + "" + pj);
                    boolean posmove = false;
                    for (String vmove : moves) {
                        if (vmove.equals((i/8) + "" + (i%8))) {
                            posmove = true;
                            break;
                        }
                    }
                    if (posmove) {
                        tmpSave();
                        grid[i/8][i%8] = grid[pi][pj];
                        grid[pi][pj] = ';';
                        updateBlock();
                        msg.setText("Moved");
                        ChessAI om=new ChessAI();
                        //String mv=om.improve2cut(this.grid,'w');
                        //String mv=om.minmaxApplied(this.grid, true, 2);
                        String mv=om.DriverAi(grid,20);
                        System.out.println("After Move MV = "+mv);
                        grid[Integer.parseInt(""+mv.charAt(0))][Integer.parseInt(""+mv.charAt(1))]=grid[Integer.parseInt(""+mv.charAt(2))][Integer.parseInt(""+mv.charAt(3))];
                        grid[Integer.parseInt(""+mv.charAt(2))][Integer.parseInt(""+mv.charAt(3))]=';';
                        updateBlock();
                        msg.setText("AI - Moved");
                    }
                    else
                        msg.setText("Invalid Move");
                    pi=-1;
                    pj=-1;
                    //print();
                    cond=false;
            }
        }
        if(pawnEnd())
        {
            System.out.println("PAWN END");
            this.dispose();
            int c=0;
            for(int i=0;i<8;i++)
                if(grid[7][i]=='p')
                    c=i;
            new SelectRevival(7,c,grid).main(grid,7,c);
        }
        if(!checkWin())
            endGame();
        if(src==save)
        {
            doSave();
        }
        else if(src==load)
        {
            doLoad();
        }
        else if(src==replay)
        {
            replay();
        }
        else if(src==undo)
        {
            tmpLoad();
        }
    }
    

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
    
    JFileChooser fileDialog;

    private void doSave() {
        if (fileDialog == null) {
            fileDialog = new JFileChooser();
        }
        File selectedFile;  // Initially selected file name in the dialog.
        selectedFile = new File("save00chess-ai.ghh");
        fileDialog.setSelectedFile(selectedFile);
        fileDialog.setDialogTitle("Select File for Saving the Game");
        int option = fileDialog.showSaveDialog(this);
        if (option != JFileChooser.APPROVE_OPTION) {
            return;  // User canceled or clicked the dialog's close box.
        }
        selectedFile = fileDialog.getSelectedFile();
        if (selectedFile.exists()) {  // Ask the user whether to replace the file.
            int response = JOptionPane.showConfirmDialog(this,
                    "The file \"" + selectedFile.getName()
                    + "\" already exists.\nDo you want to replace it?",
                    "Confirm Save",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (response != JOptionPane.YES_OPTION) {
                return;  // User does not want to replace the file.
            }
        }
        if(Save.Save(grid, selectedFile))
            msg.setText("Successfully Saved");
        else
            msg.setText("Error while Saving");
    }
    
    private void tmpSave() {
        File selectedFile;  // Initially selected file name in the dialog.
        selectedFile = new File("save00chess-tmp.ghh");
        if(Save.Save(grid, selectedFile))
            msg.setText("Successfully Saved");
        else
            msg.setText("Error while Saving");
    }

    private void doLoad() {
        if (fileDialog == null) {
            fileDialog = new JFileChooser();
        }
        fileDialog.setDialogTitle("Select Chess Game File");
        fileDialog.setSelectedFile(null);  // No file is initially selected.
        int option = fileDialog.showOpenDialog(this);
        if (option != JFileChooser.APPROVE_OPTION) {
            return;  // User canceled or clicked the dialog's close box.
        }
        File selectedFile = fileDialog.getSelectedFile();
        try {
            String data = "";
            data = new String(Files.readAllBytes(Paths.get(selectedFile.getPath())));
            //this.dispose();
            int index = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (data.charAt(index)) {
                        case 'p':
                            grid[i][j]='p';
                            break;
                        case 'e':
                            grid[i][j]='e';
                            break;
                        case 'h':
                            grid[i][j]='h';
                            break;
                        case 'm':
                            grid[i][j]='m';
                            break;
                        case 'q':
                            grid[i][j]='q';
                            break;
                        case 'k':
                            grid[i][j]='k';
                            break;
                        case 'P':
                            grid[i][j]='P';
                            break;
                        case 'E':
                            grid[i][j]='E';
                            break;
                        case 'H':
                            grid[i][j]='H';
                            break;
                        case 'M':
                            grid[i][j]='M';
                            break;
                        case 'Q':
                            grid[i][j]='Q';
                            break;
                        case 'K':
                            grid[i][j]='K';
                            break;
                        case ';':
                            grid[i][j]=';';
                            break;
                        default:
                            msg.setText("INVALID SAVEGAME FILE");
                            endGame();
                            return;
                    }
                    index+=1;
                }
            }
            updateBlock();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sorry, but an error occurred while trying to read the data:\n" + e);
            return;
        }
        msg.setText("LOAD SUCCESSFUL");
    }
    
    private void tmpLoad() {
        File selectedFile = new File("save00chess-tmp.ghh");
        try {
            String data = "";
            data = new String(Files.readAllBytes(Paths.get(selectedFile.getPath())));
            //this.dispose();
            int index = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (data.charAt(index)) {
                        case 'p':
                            grid[i][j]='p';
                            break;
                        case 'e':
                            grid[i][j]='e';
                            break;
                        case 'h':
                            grid[i][j]='h';
                            break;
                        case 'm':
                            grid[i][j]='m';
                            break;
                        case 'q':
                            grid[i][j]='q';
                            break;
                        case 'k':
                            grid[i][j]='k';
                            break;
                        case 'P':
                            grid[i][j]='P';
                            break;
                        case 'E':
                            grid[i][j]='E';
                            break;
                        case 'H':
                            grid[i][j]='H';
                            break;
                        case 'M':
                            grid[i][j]='M';
                            break;
                        case 'Q':
                            grid[i][j]='Q';
                            break;
                        case 'K':
                            grid[i][j]='K';
                            break;
                        case ';':
                            grid[i][j]=';';
                            break;
                        default:
                            msg.setText("INVALID SAVEGAME FILE");
                            endGame();
                            return;
                    }
                    index+=1;
                }
            }
            System.out.println("BEFORE UPDATION");
            updateBlock();
            System.out.println("AFTER UPDATION");
        } catch (Exception e) {
            msg.setText("Sorry, but an error occurred while trying to read the data:\n" + e);
            return;
        }
        msg.setText("UNDO SUCCESSFUL");
    }

    private void replay() {
        this.dispose();
        main(new String[1]);
    }

}
