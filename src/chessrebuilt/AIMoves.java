/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrebuilt;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author GrayHat
 */
public class AIMoves {

    public String randomMove(char grid[][], char color) {
        if (color == 'w') {
            List<String> ind = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (grid[i][j] == 'E' || grid[i][j] == 'H' || grid[i][j] == 'M' || grid[i][j] == 'K' || grid[i][j] == 'Q' || grid[i][j] == 'P') {
                        ind.add(i + "" + j);
                    }
                }
            }
            System.out.println(ind);
            List<String> mov = new LinkedList<>();
            int Mp = -1;
            int flag = 0;
            while (flag == 0) {
                Random rnd = new Random();
                ValidMoves ob = new ValidMoves();
                Mp = rnd.nextInt(ind.size());
                mov = ob.getMovesAI(grid, ind.get(Mp));
                if (mov.size() > 0) {
                    flag += 1;
                } else {
                    flag = 0;
                }
            }
            System.out.println(Mp);
            System.out.println(mov);

            Random rnd = new Random();
            int mp = rnd.nextInt(mov.size());
            System.out.println(mp);
            System.out.println(mov.get(mp) + ind.get(Mp));
            return mov.get(mp) + ind.get(Mp);
        } else {
            List<String> ind = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (grid[i][j] == 'e' || grid[i][j] == 'h' || grid[i][j] == 'm' || grid[i][j] == 'k' || grid[i][j] == 'q' || grid[i][j] == 'p') {
                        ind.add(i + "" + j);
                    }
                }
            }
            List<String> mov;
            int Mp = -1;
            while (true) {
                Random rnd = new Random();
                ValidMoves ob = new ValidMoves();
                Mp = rnd.nextInt(ind.size());
                mov = ob.getMovesUser(grid, ind.get(Mp));
                if (mov != null) {
                    break;
                }
            }
            Random rnd = new Random();
            int mp = rnd.nextInt(mov.size());
            return mov.get(mp) + "" + Mp;
        }
    }

    public String improve2cut(char grid[][], char color) {
        if (color == 'w') {
            List<String> ind = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (grid[i][j] == 'E' || grid[i][j] == 'H' || grid[i][j] == 'M' || grid[i][j] == 'K' || grid[i][j] == 'Q' || grid[i][j] == 'P') {
                        ind.add(i + "" + j);
                    }
                }
            }
            System.out.println(ind);
            List<String> cut = new LinkedList<>();
            int flag = 0;
            char piece;
            int min = 0;
            int pi = 0;
            String ci = "";
            while (flag < ind.size()) {
                ValidMoves ob = new ValidMoves();
                cut = ob.getMovesAI(grid, ind.get(flag));
                System.out.println(cut);
                if (cut.size() > 0) {
                    int count = 0;
                    for (String index : cut) {
                        System.out.println(index);
                        int r = Integer.parseInt("" + index.charAt(0));
                        int c = Integer.parseInt("" + index.charAt(1));
                        if (r < 0 || r > 7 || c > 7 || c < 0) {
                            count += 1;
                            continue;
                        }
                        if (grid[r][c] == 'e' || grid[r][c] == 'p' || grid[r][c] == 'h' || grid[r][c] == 'm' || grid[r][c] == 'q' || grid[r][c] == 'k') {
                            System.out.println("INDEX IS BLACK PIECE");
                            piece = grid[r][c];
                            int cv = 0;
                            switch (piece) {
                                case 'p':
                                    cv = PieceValue.BLACK_PAWN;
                                    break;
                                case 'e':
                                    cv = PieceValue.BLACK_ROOK;
                                    break;
                                case 'h':
                                    cv = PieceValue.BLACK_HORSE;
                                    break;
                                case 'm':
                                    cv = PieceValue.BLACK_BISHOP;
                                    break;
                                case 'q':
                                    cv = PieceValue.BLACK_QUEEN;
                                    break;
                                case 'k':
                                    cv = PieceValue.BLACK_KING;
                                    break;
                                default:
                                    break;
                            }
                            if (cv < min) {
                                System.out.println("INDEX IS MINIMUM");
                                pi = flag;
                                ci = cut.get(count);
                                min = cv;
                            }
                        }
                        count += 1;
                    }
                }
                flag += 1;
            }
            if (min < 0) {
                System.out.println(ci + "" + ind.get(pi));
                return (ci + "" + ind.get(pi));
            } else {
                return randomMove(grid, 'w');
            }
        } else {
            List<String> ind = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (grid[i][j] == 'e' || grid[i][j] == 'h' || grid[i][j] == 'm' || grid[i][j] == 'k' || grid[i][j] == 'q' || grid[i][j] == 'p') {
                        ind.add(i + "" + j);
                    }
                }
            }
            System.out.println(ind);
            List<String> cut = new LinkedList<>();
            int flag = 0;
            char piece;
            int max = 0;
            int pi = 0, ci = 0;
            while (flag < ind.size()) {
                ValidMoves ob = new ValidMoves();
                cut = ob.getMovesUser(grid, ind.get(flag));
                if (cut.size() > 0) {
                    int count = 0;
                    for (String index : cut) {
                        int r = Integer.parseInt("" + index.charAt(0));
                        int c = Integer.parseInt("" + index.charAt(1));
                        if (grid[r][c] == 'E' || grid[r][c] == 'P' || grid[r][c] == 'H' || grid[r][c] == 'M' || grid[r][c] == 'Q' || grid[r][c] == 'K') {
                            piece = grid[r][c];
                            int cv = 0;
                            switch (piece) {
                                case 'P':
                                    cv = PieceValue.WHITE_PAWN;
                                    break;
                                case 'E':
                                    cv = PieceValue.WHITE_ROOK;
                                    break;
                                case 'H':
                                    cv = PieceValue.WHITE_HORSE;
                                    break;
                                case 'M':
                                    cv = PieceValue.WHITE_BISHOP;
                                    break;
                                case 'Q':
                                    cv = PieceValue.WHITE_QUEEN;
                                    break;
                                case 'K':
                                    cv = PieceValue.WHITE_KING;
                                    break;
                                default:
                                    break;
                            }
                            if (cv > max) {
                                pi = flag;
                                ci = count;
                                max = cv;
                            }
                        }
                        count += 1;
                    }
                }
                flag += 1;
            }
            if (max > 0) {
                return (ind.get(ci) + "" + ind.get(pi));
            } else {
                return randomMove(grid, 'b');
            }
        }
    }

    String outp = "";

    public int improve3minmax(final char grid[][], boolean isWhite, int depth, int best,boolean isFirst, int prevCase) {
        System.out.println("isWhite : " + isWhite + " \t Depth : " + depth);
        if (depth == 0) {
            return best;
        }
        char tgrid[][];
        tgrid = grid;
        List<String> gamePiece = new LinkedList<>();
        List<String> gameMoves = new LinkedList<>();
        if (isWhite) {
            for (int i = 0; i < 64; i++) {
                if (grid[i / 8][i % 8] == 'P' || grid[i / 8][i % 8] == 'E' || grid[i / 8][i % 8] == 'H' || grid[i / 8][i % 8] == 'M' || grid[i / 8][i % 8] == 'Q' || grid[i / 8][i % 8] == 'K') {
                    gamePiece.add((i / 8) + "" + (i % 8));
                    List<String> tem = ValidMoves.getMovesAI(grid, (i / 8) + "" + (i % 8));
                    if (tem.size() > 0) {
                        gameMoves.addAll(tem);
                    }
                    gameMoves.add("END");
                }
            }
            System.out.println(gamePiece);
            System.out.println("Moves : " + gameMoves);
            int j = 0;
            for (int i = 0; i < gamePiece.size(); i++) {
                if (Integer.parseInt("" + gamePiece.get(i).charAt(0)) > 7 || Integer.parseInt("" + gamePiece.get(i).charAt(0)) < 0 || Integer.parseInt("" + gamePiece.get(i).charAt(1)) > 7 || Integer.parseInt("" + gamePiece.get(i).charAt(1)) < 0) {
                    continue;
                }
                System.out.println("\nCurrent : " + gamePiece.get(i));
                for (; j < gameMoves.size(); j++) {
                    System.out.println("CurrentMove : " + gameMoves.get(j));
                    if (gameMoves.get(j).equalsIgnoreCase("END")) {
                        j += 1;
                        break;
                    }
                    if (Integer.parseInt("" + gameMoves.get(j).charAt(0)) > 7 || Integer.parseInt("" + gameMoves.get(j).charAt(0)) < 0 || Integer.parseInt("" + gameMoves.get(j).charAt(1)) > 7 || Integer.parseInt("" + gameMoves.get(j).charAt(1)) < 0) {
                        j += 1;
                        continue;
                    }
                    //if (isFirst) {
                        //print(grid);
                    //}
                    //tgrid=grid.clone();
                    //if (isFirst) {
                        //print(tgrid);
                    //}
                    char el = tgrid[Integer.parseInt("" + (gameMoves.get(j).charAt(0)))][Integer.parseInt("" + (gameMoves.get(j).charAt(1)))];
                    char pl = tgrid[Integer.parseInt("" + (gamePiece.get(i).charAt(0)))][Integer.parseInt("" + (gamePiece.get(i).charAt(1)))];
                    tgrid[Integer.parseInt("" + (gameMoves.get(j).charAt(0)))][Integer.parseInt("" + (gameMoves.get(j).charAt(1)))] = tgrid[Integer.parseInt("" + (gamePiece.get(i).charAt(0)))][Integer.parseInt("" + (gamePiece.get(i).charAt(1)))];
                    tgrid[Integer.parseInt("" + (gamePiece.get(i).charAt(0)))][Integer.parseInt("" + (gamePiece.get(i).charAt(1)))] = ';';
                    System.out.println("After if(!END)");
                    System.out.println("Tgrid UPDATE : ");
                    //print(tgrid);
                    System.out.println("SELECTED ELEMENT" + el);
                    switch (el) {
                        case 'p':
                            best = PieceValue.BLACK_PAWN;
                            break;
                        case 'e':
                            best = PieceValue.BLACK_ROOK;
                            break;
                        case 'h':
                            best = PieceValue.BLACK_HORSE;
                            break;
                        case 'm':
                            best = PieceValue.BLACK_BISHOP;
                            break;
                        case 'q':
                            best = PieceValue.BLACK_QUEEN;
                            break;
                        case 'k':
                            best = PieceValue.BLACK_KING;
                            break;
                        default:break;
                    }
                    if (best < prevCase) {
                        int temp1=improve3minmax(tgrid, !isWhite, depth - 1, 0, false,best);
                        if(best+temp1<best)
                        {
                            if(isFirst)
                                outp = gameMoves.get(j) + "" + gamePiece.get(i);
                            best=best+temp1;
                            prevCase = best;
                        }
                    }
                    //else
                    //tgrid=grid;
                    if (isFirst) {
                        System.out.println("Output: " + outp);
                    }
                    tgrid[Integer.parseInt("" + (gameMoves.get(j).charAt(0)))][Integer.parseInt("" + (gameMoves.get(j).charAt(1)))] = el;
                    tgrid[Integer.parseInt("" + (gamePiece.get(i).charAt(0)))][Integer.parseInt("" + (gamePiece.get(i).charAt(1)))] = pl;
                }
            }
            //System.out.println("Final GRID : ");
            //print(fgrid);
            if (outp.equalsIgnoreCase("")) {
                outp = randomMove(grid, 'w');
            }
            return prevCase;
        } else {
            prevCase=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (grid[i][j] == 'p' || grid[i][j] == 'e' || grid[i][j] == 'h' || grid[i][j] == 'm' || grid[i][j] == 'q' || grid[i][j] == 'k') {
                        gamePiece.add(i + "" + j);
                        gameMoves.addAll(ValidMoves.getMovesUser(grid, i + "" + j));
                        gameMoves.add("END");
                    }
                }
            }
            System.out.println(gamePiece);
            System.out.println("Moves : " + gameMoves);
            int j = 0;
            for (int i = 0; i < gamePiece.size(); i++) {
                System.out.println("\nCurrent : " + gamePiece.get(i));
                for (; j < gameMoves.size(); j++) {
                    System.out.println("CurrentMove : " + gameMoves.get(j));
                    if (gameMoves.get(j).equalsIgnoreCase("END")) {
                        j += 1;
                        break;
                    }
                    if (Integer.parseInt("" + gameMoves.get(j).charAt(0)) > 7 || Integer.parseInt("" + gameMoves.get(j).charAt(0)) < 0 || Integer.parseInt("" + gameMoves.get(j).charAt(1)) > 7 || Integer.parseInt("" + gameMoves.get(j).charAt(1)) < 0) {
                        j += 1;
                        continue;
                    }
                    if (isFirst) {
                        //print(grid);
                    }
                    //tgrid=grid;
                    //tgrid = grid.clone();
                    char el = tgrid[Integer.parseInt("" + (gameMoves.get(j).charAt(0)))][Integer.parseInt("" + (gameMoves.get(j).charAt(1)))];
                    char pl = tgrid[Integer.parseInt("" + (gamePiece.get(i).charAt(0)))][Integer.parseInt("" + (gamePiece.get(i).charAt(1)))];
                    tgrid[Integer.parseInt("" + (gameMoves.get(j).charAt(0)))][Integer.parseInt("" + (gameMoves.get(j).charAt(1)))] = tgrid[Integer.parseInt("" + (gamePiece.get(i).charAt(0)))][Integer.parseInt("" + (gamePiece.get(i).charAt(1)))];
                    tgrid[Integer.parseInt("" + (gamePiece.get(i).charAt(0)))][Integer.parseInt("" + (gamePiece.get(i).charAt(1)))] = ';';
                    System.out.println("After if(!END)");
                    System.out.println("SELECTED ELEMENT : " + el);
                    switch (el) {
                        case 'P':
                            best = PieceValue.WHITE_PAWN;
                            break;
                        case 'E':
                            best = PieceValue.WHITE_ROOK;
                            break;
                        case 'H':
                            best = PieceValue.WHITE_HORSE;
                            break;
                        case 'M':
                            best = PieceValue.WHITE_BISHOP;
                            break;
                        case 'Q':
                            best = PieceValue.WHITE_QUEEN;
                            break;
                        case 'K':
                            best = PieceValue.WHITE_KING;
                            break;
                        default:break;
                    }
                    if (best > prevCase) {
                        System.out.println("CurrentBest (entering loop){: " + best);
                        int temp1=improve3minmax(tgrid, !isWhite, depth - 1, 0, false,best);
                        if(best+temp1>best)
                        {
                            //if(isFirst)
                                //outp = gameMoves.get(j) + "" + gamePiece.get(i);
                            best=best+temp1;
                            prevCase=best;
                        }
                        //best = Math.max(best,Math.abs(improve3minmax(tgrid, !isWhite, depth - 1, 0, false, -best)));
                        System.out.println("ENDBest (exiting loop)}: " + best);
                        //if (best > temp) {
                            //outp = gameMoves.get(j) + "" + gamePiece.get(i);
                            //prevCase=best;
                        //}
                        //prevCase = best;
                    }
                    //if(best>=temp)
                    //  ;
                    //else
                    //ftgrid=grid;
                    //outp=gameMoves.get(j)+""+gamePiece.get(i);
                    //System.out.println("Output: "+outp);
                    tgrid[Integer.parseInt("" + (gameMoves.get(j).charAt(0)))][Integer.parseInt("" + (gameMoves.get(j).charAt(1)))] = el;
                    tgrid[Integer.parseInt("" + (gamePiece.get(i).charAt(0)))][Integer.parseInt("" + (gamePiece.get(i).charAt(1)))] = pl;
                }
            }
            //if(best==0&&isFirst)
            //outp=improve2cut(grid,'b');
            return prevCase;
        }
    }

    public String minmaxApplied(char grid[][], boolean isWhite, int depth) {
        int m = improve3minmax(grid, isWhite, depth,0,true,Integer.MAX_VALUE);
        System.out.println("AI BEST CASE :" + m);
        if(outp.equalsIgnoreCase(""))
            outp=randomMove(grid,'w');
        return outp;
    }

    private void print(char grid[][]) {
        for (int i = 0; i < 64; i++) {
            System.out.print(grid[i / 8][i % 8] + "\t");
            if ((i + 1) % 8 == 0) {
                System.out.println();
            }
        }
    }
    
    public int improve4minmaxabpruning(char grid[][],boolean isWhite, int depth,int prevCase)
    {
        if(isWhite)
        {
            int best=0;
            if(depth==0)
                return best;
            List<String> piece=new LinkedList<>();
            List<String> move=new LinkedList<>();
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                {
                    if(grid[i][j]=='P'||grid[i][j]=='E'||grid[i][j]=='H'||grid[i][j]=='Q'||grid[i][j]=='K'||grid[i][j]=='M')
                        piece.add(i+""+j);
                }
            }
            List<Integer> countMoves=new LinkedList<>();
            int count=0;
            int ind=0;
            for(String p:piece)
            {
                List<String> temp=ValidMoves.getMovesAI(grid,p.charAt(0)+""+p.charAt(1));
                if(temp==null)
                {
                    piece.remove(ind);
                    continue;
                }
                move.addAll(temp);
                count=move.size()-count;
                countMoves.add(count);
                ind+=1;
            }
            count=0;
            for(String p:piece)
            {
                for(int i=0;i<countMoves.get(count);i++)
                {
                    int temp=best;
                    String m=move.get(i+count);
                    char[][] tgrid=grid;
                    char el=grid[Integer.parseInt(""+m.charAt(0))][Integer.parseInt(""+m.charAt(1))];
                    tgrid[Integer.parseInt(""+m.charAt(0))][Integer.parseInt(""+m.charAt(1))]=tgrid[Integer.parseInt(""+p.charAt(0))][Integer.parseInt(""+p.charAt(1))];
                    tgrid[Integer.parseInt(""+p.charAt(0))][Integer.parseInt(""+p.charAt(1))]=';';
                    switch (el) {
                        case 'p':
                            best -= PieceValue.BLACK_PAWN;
                            break;
                        case 'e':
                            best -= PieceValue.BLACK_ROOK;
                            break;
                        case 'h':
                            best -= PieceValue.BLACK_HORSE;
                            break;
                        case 'm':
                            best -= PieceValue.BLACK_BISHOP;
                            break;
                        case 'q':
                            best -= PieceValue.BLACK_QUEEN;
                            break;
                        case 'k':
                            best-= PieceValue.BLACK_KING;
                            break;
                        default:
                            break;
                    }
                    if(best<prevCase)
                    {
                        int t2=improve4minmaxabpruning(tgrid,!isWhite,depth-1,best);
                        if(best+t2<best)
                        {
                            outp=m.charAt(0)+""+m.charAt(1)+""+p.charAt(0)+""+p.charAt(1);
                            best=temp-t2;
                        }
                    }
                    tgrid[Integer.parseInt(""+p.charAt(0))][Integer.parseInt(""+p.charAt(1))]=tgrid[Integer.parseInt(""+m.charAt(0))][Integer.parseInt(""+m.charAt(1))];
                    tgrid[Integer.parseInt(""+m.charAt(0))][Integer.parseInt(""+m.charAt(1))]=el;
                }
                count+=1;
            }
            if(outp.equalsIgnoreCase(""))
                outp=randomMove(grid,'w');
            return best;
        }
        else
        {
            int best=0;
            if(depth==0)
                return best;
            List<String> piece=new LinkedList<>();
            List<String> move=new LinkedList<>();
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                {
                    if(grid[i][j]=='p'||grid[i][j]=='e'||grid[i][j]=='h'||grid[i][j]=='q'||grid[i][j]=='k'||grid[i][j]=='m')
                        piece.add(i+""+j);
                }
            }
            List<Integer> countMoves=new LinkedList<>();
            int count=0;
            int ind=0;
            for(String p:piece)
            {
                List<String> temp=ValidMoves.getMovesUser(grid,p.charAt(0)+""+p.charAt(1));
                if(temp==null)
                {
                    piece.remove(ind);
                    continue;
                }
                move.addAll(temp);
                count=move.size()-count;
                countMoves.add(count);
                ind+=1;
            }
            count=0;
            for(String p:piece)
            {
                for(int i=0;i<countMoves.get(count);i++)
                {
                    int temp=best;
                    String m=move.get(i);
                    char[][] tgrid=grid;
                    char el=grid[Integer.parseInt(""+m.charAt(0))][Integer.parseInt(""+m.charAt(1))];
                    tgrid[Integer.parseInt(""+m.charAt(0))][Integer.parseInt(""+m.charAt(1))]=tgrid[Integer.parseInt(""+p.charAt(0))][Integer.parseInt(""+p.charAt(1))];
                    tgrid[Integer.parseInt(""+p.charAt(0))][Integer.parseInt(""+p.charAt(1))]=';';
                    switch (el) {
                        case 'P':
                            best += PieceValue.WHITE_PAWN;
                            break;
                        case 'E':
                            best += PieceValue.WHITE_ROOK;
                            break;
                        case 'H':
                            best += PieceValue.WHITE_HORSE;
                            break;
                        case 'M':
                            best += PieceValue.WHITE_BISHOP;
                            break;
                        case 'Q':
                            best += PieceValue.WHITE_QUEEN;
                            break;
                        case 'K':
                            best += PieceValue.WHITE_KING;
                            break;
                        default:
                            break;
                    }
                    if(best>prevCase)
                    {
                        int t2=improve4minmaxabpruning(tgrid,!isWhite,depth-1,best);
                        if(best-t2>best)
                            best=temp-t2;
                    }
                    tgrid[Integer.parseInt(""+p.charAt(0))][Integer.parseInt(""+p.charAt(1))]=tgrid[Integer.parseInt(""+m.charAt(0))][Integer.parseInt(""+m.charAt(1))];
                    tgrid[Integer.parseInt(""+m.charAt(0))][Integer.parseInt(""+m.charAt(1))]=el;
                }
                count+=1;
            }
            return best;
        }
    }

}
