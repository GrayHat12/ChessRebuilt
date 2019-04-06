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
public class ChessAI {

    String outp = "n";

    public int minimaxapai(char[][] grid, int depth, boolean isWhite, boolean isFirst) {
        System.out.println("Depth : " + depth + " White : " + isWhite);
        if (depth == 0) {
            return boardEval(grid,true,true);
        } else if (isWhite) {
            return valWhite(grid, depth, isFirst);
        } else {
            return valBlack(grid, depth);
        }

    }

    private int boardEval(char grid[][],boolean moveofw,boolean fnl) {
        int best = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                List<String> valMove;
                char pice = grid[i][j];
                if (pice == ';') {
                    continue;
                } else if (pice == 'p') {
                    best -= 10;
                } else if (pice == 'e') {
                    best -= 50;
                } else if (pice == 'h') {
                    best -= 30;
                } else if (pice == 'm') {
                    best -= 30;
                } else if (pice == 'k') {
                    best -= 999999;
                } else if (pice == 'q') {
                    best -= 90;
                } else if (pice == 'P') {
                    best += 10;
                } else if (pice == 'E') {
                    best += 50;
                } else if (pice == 'H') {
                    best += 30;
                } else if (pice == 'M') {
                    best += 30;
                } else if (pice == 'K') {
                    best += 999999;
                } else if (pice == 'Q') {
                    best += 90;
                }
                switch (pice) {
                    case 'P':
                        if(moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesAI(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'p':
                                    best += 10;
                                    break;
                                case 'e':
                                    best += 50;
                                    break;
                                case 'h':
                                    best += 30;
                                    break;
                                case 'm':
                                    best += 30;
                                    break;
                                case 'q':
                                    best += 90;
                                    break;
                                case 'k':
                                    best += 999999;
                                    break;
                                default:
                                    best += 0;
                            }
                        }
                        break;
                    case 'H':
                        if(moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesAI(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'p':
                                    best += 10;
                                    break;
                                case 'e':
                                    best += 50;
                                    break;
                                case 'h':
                                    best += 30;
                                    break;
                                case 'm':
                                    best += 30;
                                    break;
                                case 'q':
                                    best += 90;
                                    break;
                                case 'k':
                                    best += 999999;
                                    break;
                                default:
                                    best += 0;
                            }
                        }
                        break;
                    case 'M':
                        if(moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesAI(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'p':
                                    best += 10;
                                    break;
                                case 'e':
                                    best += 50;
                                    break;
                                case 'h':
                                    best += 30;
                                    break;
                                case 'm':
                                    best += 30;
                                    break;
                                case 'q':
                                    best += 90;
                                    break;
                                case 'k':
                                    best += 999999;
                                    break;
                                default:
                                    best += 0;
                            }
                        }
                        break;
                    case 'E':
                        if(moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesAI(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'p':
                                    best += 10;
                                    break;
                                case 'e':
                                    best += 50;
                                    break;
                                case 'h':
                                    best += 30;
                                    break;
                                case 'm':
                                    best += 30;
                                    break;
                                case 'q':
                                    best += 90;
                                    break;
                                case 'k':
                                    best += 999999;
                                    break;
                                default:
                                    best += 0;
                            }
                        }
                        break;
                    case 'K':
                        if(moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesAI(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'p':
                                    best += 10;
                                    break;
                                case 'e':
                                    best += 50;
                                    break;
                                case 'h':
                                    best += 30;
                                    break;
                                case 'm':
                                    best += 30;
                                    break;
                                case 'q':
                                    best += 90;
                                    break;
                                case 'k':
                                    best += 999999;
                                    break;
                                default:
                                    best += 0;
                            }
                        }
                        break;
                    case 'Q':
                        if(moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesAI(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'p':
                                    best += 10;
                                    break;
                                case 'e':
                                    best += 50;
                                    break;
                                case 'h':
                                    best += 30;
                                    break;
                                case 'm':
                                    best += 30;
                                    break;
                                case 'q':
                                    best += 90;
                                    break;
                                case 'k':
                                    best += 999999;
                                    break;
                                default:
                                    best += 0;
                            }
                        }
                        break;
                    case 'p':
                        if(!moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesUser(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'P':
                                    best -= 10;
                                    break;
                                case 'E':
                                    best -= 50;
                                    break;
                                case 'H':
                                    best -= 30;
                                    break;
                                case 'M':
                                    best -= 30;
                                    break;
                                case 'Q':
                                    best -= 90;
                                    break;
                                case 'K':
                                    best -= 999999;
                                    break;
                                default:
                                    best -= 0;
                            }
                        }
                        break;
                    case 'e':
                        if(!moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesUser(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'P':
                                    best -= 10;
                                    break;
                                case 'E':
                                    best-= 50;
                                    break;
                                case 'H':
                                    best -= 30;
                                    break;
                                case 'M':
                                    best -= 30;
                                    break;
                                case 'Q':
                                    best -= 90;
                                    break;
                                case 'K':
                                    best -= 999999;
                                    break;
                                default:
                                    best -= 0;
                            }
                        }
                        break;
                    case 'h':
                        if(!moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesUser(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'P':
                                    best -= 10;
                                    break;
                                case 'E':
                                    best -= 50;
                                    break;
                                case 'H':
                                    best -= 30;
                                    break;
                                case 'M':
                                    best -= 30;
                                    break;
                                case 'Q':
                                    best -= 90;
                                    break;
                                case 'K':
                                    best -= 999999;
                                    break;
                                default:
                                    best -= 0;
                            }
                        }
                        break;
                    case 'm':
                        if(!moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesUser(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'P':
                                    best -= 10;
                                    break;
                                case 'E':
                                    best -= 50;
                                    break;
                                case 'H':
                                    best -= 30;
                                    break;
                                case 'M':
                                    best -= 30;
                                    break;
                                case 'Q':
                                    best -= 90;
                                    break;
                                case 'K':
                                    best -= 999999;
                                    break;
                                default:
                                    best -= 0;
                            }
                        }
                        break;
                    case 'k':
                        if(!moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesUser(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'P':
                                    best -= 10;
                                    break;
                                case 'E':
                                    best -= 50;
                                    break;
                                case 'H':
                                    best -= 30;
                                    break;
                                case 'M':
                                    best -= 30;
                                    break;
                                case 'Q':
                                    best -= 90;
                                    break;
                                case 'K':
                                    best -= 999999;
                                    break;
                                default:
                                    best -= 0;
                            }
                        }
                        break;
                    case 'q':
                        if(!moveofw&&!fnl)
                            continue;
                        valMove = ValidMoves.getMovesUser(grid, i + "" + j);
                        for (String ind : valMove) {
                            char pos = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
                            switch (pos) {
                                case 'P':
                                    best -= 10;
                                    break;
                                case 'E':
                                    best -= 50;
                                    break;
                                case 'H':
                                    best -= 30;
                                    break;
                                case 'M':
                                    best -= 30;
                                    break;
                                case 'Q':
                                    best -= 90;
                                    break;
                                case 'K':
                                    best -= 999999;
                                    break;
                                default:
                                    best -= 0;
                            }
                        }
                        break;
                    default:
                        best += 0;
                }
            }
        }
        D += 1;
        System.out.println("Returned From Board Eval : " + best + " at depth : " + D);
        return best;
    }

    int D = 0;

    private int valWhite(char[][] grid, int depth, boolean isFirst) {
        int best = boardEval(grid,true,false);
        int tmp = best;
        List<String> piece = new LinkedList<>();
        List<String> moves = new LinkedList<>();
        List<Integer> count = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char pice = grid[i][j];
                if (pice == 'P' || pice == 'E' || pice == 'H' || pice == 'M' || pice == 'Q' || pice == 'K') {
                    List<String> temp = ValidMoves.getMovesAI(grid, i + "" + j);
                    if (temp == null) {
                        continue;
                    }
                    if (temp.size() <= 0) {
                        continue;
                    }
                    piece.add(i + "" + j);
                    moves.addAll(temp);
                    count.add(temp.size());
                }
            }
        }
        System.out.println("Pieces at : " + piece);
        System.out.println("Moves at : " + moves);
        System.out.println("Counts as : " + count);
        if (moves.size() <= 0) {
            return 0;
        }
        int cind = 0;
        int k = 0;
        char tgrid[][] = grid;
        char fgrid[][] = grid;
        for (String pice : piece) {
            for (int i = 0; i < count.get(cind); i++) {
                int mr = Integer.parseInt("" + (moves.get(k)).charAt(0)), mc = Integer.parseInt("" + (moves.get(k)).charAt(1));
                int ir = Integer.parseInt("" + pice.charAt(0)), ic = Integer.parseInt("" + pice.charAt(1));
                char movedOn = tgrid[mr][mc];
                System.out.println(tgrid[ir][ic] + " killing " + tgrid[mr][mc] + " at : " + mr + "," + mc);
                tgrid[mr][mc] = tgrid[ir][ic];
                tgrid[ir][ic] = ';';
                int tmp2=boardEval(tgrid,true,false);
                if (tmp2 > tmp) {
                    int t = minimaxapai(tgrid, depth - 1, false, false);
                    if (t > best) {
                        fgrid = tgrid;
                        best = t;
                        if (isFirst) {
                            outp = mr + "" + mc + "" + ir + "" + ic;
                        }
                    }
                    tmp=tmp2;
                }
                System.out.println("Best after if : " + best);
                tgrid[ir][ic] = tgrid[mr][mc];
                tgrid[mr][mc] = movedOn;
                k += 1;
            }
            cind += 1;
        }
        System.out.println("Returned From Val White : " + best + " at depth : " + depth);
        return boardEval(fgrid,false,false);
    }

    private int valBlack(char[][] grid, int depth) {
        int best = boardEval(grid,false,false);
        int tmp = best;
        List<String> piece = new LinkedList<>();
        List<String> moves = new LinkedList<>();
        List<Integer> count = new LinkedList<>();
        for (int i = 0; i < 64; i++) {
            char pice = grid[i / 8][i % 8];
            if (pice == 'p' || pice == 'e' || pice == 'h' || pice == 'm' || pice == 'q' || pice == 'k') {
                List<String> temp = ValidMoves.getMovesUser(grid, (i / 8) + "" + (i % 8));
                if (temp == null) {
                    continue;
                }
                if (temp.size() <= 0) {
                    continue;
                }
                piece.add((i / 8) + "" + (i % 8));
                moves.addAll(temp);
                count.add(temp.size());
            }
        }
        if (moves.size() <= 0) {
            return 0;
        }
        int cind = 0;
        char tgrid[][] = grid;
        char fgrid[][] = grid;
        int k = 0;
        for (String pice : piece) {
            for (int i = 0; i < count.get(cind); i++) {
                int mr = Integer.parseInt("" + (moves.get(k)).charAt(0)), mc = Integer.parseInt("" + (moves.get(k)).charAt(1));
                int ir = Integer.parseInt("" + pice.charAt(0)), ic = Integer.parseInt("" + pice.charAt(1));
                char movedOn = tgrid[mr][mc];
                System.out.println(tgrid[ir][ic] + " killing " + tgrid[mr][mc] + " at : " + mr + "," + mc);
                tgrid[mr][mc] = tgrid[ir][ic];
                tgrid[ir][ic] = ';';
                int tmp2=boardEval(tgrid,false,false);
                if (tmp2 < tmp) {
                    int t = minimaxapai(tgrid, depth - 1, true,false);
                    if (t < best) {
                        fgrid = tgrid;
                        best = t;
                    }
                    tmp=tmp2;
                }
                tgrid[ir][ic] = tgrid[mr][mc];
                tgrid[mr][mc] = movedOn;
                k += 1;
            }
            cind += 1;
        }
        System.out.println("Returned from Val Black : " + best + " at depth : " + depth);
        return boardEval(fgrid,true,false);
    }

    public String DriverAi(char[][] grid, int depth) {
        int b = minimaxapai(grid, depth, true, true);
        if (outp.equalsIgnoreCase("n")) {
            System.out.println("HAD TO USE RANDOM MOVE");
            outp = randomMove(grid, 'w');
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("Returned from AI DRIVER CODE : " + outp + " Best " + b);
        return outp;
    }

    public String randomMove(char[][] grid, char color) {
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
    }
}
