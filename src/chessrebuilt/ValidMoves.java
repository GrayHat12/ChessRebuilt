/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrebuilt;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author GrayHat
 */
public class ValidMoves {

    static List<String> out = new LinkedList<>();

    public static List<String> getMovesUser(char grid[][], String ind) {
        out = new LinkedList<>();
        char el = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
        switch (el) {
            case 'e':
                blackel(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            case 'h':
                blackhorse(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            case 'm':
                blackmn(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            case 'q':
                blackqu(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            case 'k':
                blackking(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            case 'p':
                blackpawn(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            default:
                return null;
        }
        return out;
    }

    public static List<String> getMovesAI(char grid[][], String ind) {
        out = new LinkedList<>();
        char el = grid[Integer.parseInt("" + ind.charAt(0))][Integer.parseInt("" + ind.charAt(1))];
        //System.out.println("GOT REQUEST FOR '"+el+"' at '"+ind+"'");
        switch (el) {
            case 'E':
                aiel(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            case 'H':
                aihorse(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            case 'M':
                aimn(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            case 'Q':
                aiqu(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            case 'K':
                aiking(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            case 'P':
                aipawn(grid, Integer.parseInt("" + ind.charAt(0)), Integer.parseInt("" + ind.charAt(1)));
                break;
            default:
                return null;
        }
        //System.out.println("RETURNED FROM VALID MOVES : "+out);
        return out;
    }

    private static void blackel(char[][] grid, int r, int c) {
        //dir1-north
        for (int i = r-1; i < 8 && i >= 0; i--) {
            if (grid[i][c] == 'e' || grid[i][c] == 'h' || grid[i][c] == 'm' || grid[i][c] == 'q' || grid[i][c] == 'k' || grid[i][c] == 'p') {
                break;
            } else if (grid[i][c] != ';') {
                out.add(i + "" + c);
                break;
            }
            else
                out.add(i + "" + c);
        }
        //dir2-south
        for (int i = r+1; i < 8 && i >= 0; i++) {
            if (grid[i][c] == 'e' || grid[i][c] == 'h' || grid[i][c] == 'm' || grid[i][c] == 'q' || grid[i][c] == 'k' || grid[i][c] == 'p') {
                break;
            } else if (grid[i][c] != ';') {
                out.add(i + "" + c);
                break;
            }
            else
                out.add(i + "" + c);
        }
        //dir3-west
        for (int i = c-1; i < 8 && i >= 0; i--) {
            if (grid[r][i] == 'e' || grid[r][i] == 'h' || grid[r][i] == 'm' || grid[r][i] == 'q' || grid[r][i] == 'k' || grid[r][i] == 'p') {
                break;
            } else if (grid[r][i] != ';') {
                out.add(r + "" + i);
                break;
            }
            else
                out.add(r + "" + i);
        }
        //dir4-east
        for (int i = c+1; i < 8 && i >= 0; i++) {
            if (grid[r][i] == 'e' || grid[r][i] == 'h' || grid[r][i] == 'm' || grid[r][i] == 'q' || grid[r][i] == 'k' || grid[r][i] == 'p') {
                break;
            } else if (grid[r][i] != ';') {
                out.add(r + "" + i);
                break;
            }
            else
                out.add(r + "" + i);
        }
    }

    private static void blackhorse(char[][] grid, int r, int c) {
        if (r + 2 >= 0 && r + 2 < 8 && c + 1 >= 0 && c + 1 < 8) {
            if (grid[r + 2][c + 1] == 'e' || grid[r + 2][c + 1] == 'h' || grid[r + 2][c + 1] == 'm' || grid[r + 2][c + 1] == 'q' || grid[r + 2][c + 1] == 'k' || grid[r + 2][c + 1] == 'p')
                ; else {
                out.add((r + 2) + "" + (c + 1));
            }
        }
        if (r + 2 >= 0 && r + 2 < 8 && c - 1 >= 0 && c - 1 < 8) {
            if (grid[r + 2][c - 1] == 'e' || grid[r + 2][c - 1] == 'h' || grid[r + 2][c - 1] == 'm' || grid[r + 2][c - 1] == 'q' || grid[r + 2][c - 1] == 'k' || grid[r + 2][c - 1] == 'p')
                ; else {
                out.add((r + 2) + "" + (c - 1));
            }
        }
        if (r - 2 >= 0 && r - 2 < 8 && c + 1 >= 0 && c + 1 < 8) {
            if (grid[r - 2][c + 1] == 'e' || grid[r - 2][c + 1] == 'h' || grid[r - 2][c + 1] == 'm' || grid[r - 2][c + 1] == 'q' || grid[r - 2][c + 1] == 'k' || grid[r - 2][c + 1] == 'p')
                ; else {
                out.add((r - 2) + "" + (c + 1));
            }
        }
        if (r - 2 >= 0 && r - 2 < 8 && c - 1 >= 0 && c - 1 < 8) {
            if (grid[r - 2][c - 1] == 'e' || grid[r - 2][c - 1] == 'h' || grid[r - 2][c - 1] == 'm' || grid[r - 2][c - 1] == 'q' || grid[r - 2][c - 1] == 'k' || grid[r - 2][c - 1] == 'p')
                ; else {
                out.add((r - 2) + "" + (c - 1));
            }
        }
        if (r - 1 >= 0 && r - 1 < 8 && c + 2 >= 0 && c + 2 < 8) {
            if (grid[r - 1][c + 2] == 'e' || grid[r - 1][c + 2] == 'h' || grid[r - 1][c + 2] == 'm' || grid[r - 1][c + 2] == 'q' || grid[r - 1][c + 2] == 'k' || grid[r - 1][c + 2] == 'p')
                ; else {
                out.add((r - 1) + "" + (c + 2));
            }
        }
        if (r - 1 >= 0 && r - 1 < 8 && c - 2 >= 0 && c - 2 < 8) {
            if (grid[r - 1][c - 2] == 'e' || grid[r - 1][c - 2] == 'h' || grid[r - 1][c - 2] == 'm' || grid[r - 1][c - 2] == 'q' || grid[r - 1][c - 2] == 'k' || grid[r - 1][c - 2] == 'p')
                ; else {
                out.add((r - 1) + "" + (c - 2));
            }
        }
        if (r + 1 >= 0 && r + 1 < 8 && c + 2 >= 0 && c + 2 < 8) {
            if (grid[r + 1][c + 2] == 'e' || grid[r + 1][c + 2] == 'h' || grid[r + 1][c + 2] == 'm' || grid[r + 1][c + 2] == 'q' || grid[r + 1][c + 2] == 'k' || grid[r + 1][c + 2] == 'p')
                ; else {
                out.add((r + 1) + "" + (c + 2));
            }
        }
        if (r + 1 >= 0 && r + 1 < 8 && c - 2 >= 0 && c - 2 < 8) {
            if (grid[r + 1][c - 2] == 'e' || grid[r + 1][c - 2] == 'h' || grid[r + 1][c - 2] == 'm' || grid[r + 1][c - 2] == 'q' || grid[r + 1][c - 2] == 'k' || grid[r + 1][c - 2] == 'p')
                ; else {
                out.add((r + 1) + "" + (c - 2));
            }
        }
    }

    private static void blackmn(char[][] grid, int r, int c) {

        for (int i = 1; i + r < 8 && i + r >= 0 && i + c < 8 && i + c >= 0; i++) {
            if (grid[r + i][c + i] == 'e' || grid[r + i][c + i] == 'h' || grid[r + i][c + i] == 'm' || grid[r + i][c + i] == 'k' || grid[r + i][c + i] == 'q' || grid[r + i][c + i] == 'p') {
                break;
            } else if (grid[r + i][c + i] != ';') {
                out.add((r + i) + "" + (c + i));
                break;
            }
            else
                out.add((r + i) + "" + (c + i));
        }

        for (int i = 1; r - i <= 7 && r - i >= 0 && c - i <= 7 && c - i >= 0; i++) {
            if (grid[r - i][c - i] == 'e' || grid[r - i][c - i] == 'h' || grid[r - i][c - i] == 'm' || grid[r - i][c - i] == 'k' || grid[r - i][c - i] == 'q' || grid[r - i][c - i] == 'p') {
                break;
            } else if (grid[r - i][c - i] != ';') {
                out.add((r - i) + "" + (c - i));
                break;
            }
            else
                out.add((r - i) + "" + (c - i));
        }

        for (int i = 1; i + r <= 7 && i + r >= 0 && c - i <= 7 && c - i >= 0; i++) {
            if (grid[r + i][c - i] == 'e' || grid[r + i][c - i] == 'h' || grid[r + i][c - i] == 'm' || grid[r + i][c - i] == 'k' || grid[r + i][c - i] == 'q' || grid[r + i][c - i] == 'p') {
                break;
            } else if (grid[r + i][c - i] != ';') {
                out.add((r + i) + "" + (c - i));
                break;
            }
            else
                out.add((r + i) + "" + (c - i));
        }

        for (int i = 1; r - i < 8 && r - i >= 0 && c + i < 8 && c + i >= 0; i++) {
            if (grid[r - i][c + i] == 'e' || grid[r - i][c + i] == 'h' || grid[r - i][c + i] == 'm' || grid[r - i][c + i] == 'k' || grid[r - i][c + i] == 'q' || grid[r - i][c + i] == 'p') {
                break;
            } else if (grid[r - i][c + i] != ';') {
                out.add((r - i) + "" + (c + i));
                break;
            }
            else
                out.add((r - i) + "" + (c + i));
        }
    }

    private static void blackqu(char[][] grid, int r, int c) {
        blackel(grid, r, c);
        blackmn(grid, r, c);
        blackking(grid, r, c);
    }

    private static void blackking(char[][] grid, int r, int c) {
        //dir1-south
        if (r + 1 >= 0 && r + 1 <= 7) {
            //south-east
            if (c + 1 >= 0 && c + 1 <= 7) {
                if (grid[r + 1][c + 1] != 'e' && grid[r + 1][c + 1] != 'h' && grid[r + 1][c + 1] != 'm' && grid[r + 1][c + 1] != 'k' && grid[r + 1][c + 1] != 'q' && grid[r + 1][c + 1] != 'p') {
                    out.add((r + 1) + "" + (c + 1));
                }
            }
            //south-west
            if (c - 1 >= 0 && c - 1 <= 7) {
                if (grid[r + 1][c - 1] != 'e' && grid[r + 1][c - 1] != 'h' && grid[r + 1][c - 1] != 'm' && grid[r + 1][c - 1] != 'k' && grid[r + 1][c - 1] != 'q' && grid[r + 1][c - 1] != 'p') {
                    out.add((r + 1) + "" + (c - 1));
                }
            }
            //south-pole
            if (grid[r + 1][c] != 'e' && grid[r + 1][c] != 'h' && grid[r + 1][c] != 'm' && grid[r + 1][c] != 'k' && grid[r + 1][c] != 'q' && grid[r + 1][c] != 'p') {
                out.add((r + 1) + "" + c);
            }
        }
        //dir2-north
        if (r - 1 >= 0 && r - 1 <= 7) {
            //north-east
            if (c + 1 >= 0 && c + 1 <= 7) {
                if (grid[r - 1][c + 1] != 'e' && grid[r - 1][c + 1] != 'h' && grid[r - 1][c + 1] != 'm' && grid[r - 1][c + 1] != 'k' && grid[r - 1][c + 1] != 'q' && grid[r - 1][c + 1] != 'p') {
                    out.add((r - 1) + "" + (c + 1));
                }
            }
            //north-west
            if (c - 1 >= 0 && c - 1 <= 7) {
                if (grid[r - 1][c - 1] != 'e' && grid[r - 1][c - 1] != 'h' && grid[r - 1][c - 1] != 'm' && grid[r - 1][c - 1] != 'k' && grid[r - 1][c - 1] != 'q' && grid[r - 1][c - 1] != 'p') {
                    out.add((r - 1) + "" + (c - 1));
                }
            }
            //north-pole
            if (grid[r - 1][c] != 'e' && grid[r - 1][c] != 'h' && grid[r - 1][c] != 'm' && grid[r - 1][c] != 'k' && grid[r - 1][c] != 'q' && grid[r - 1][c] != 'p') {
                out.add((r - 1) + "" + c);
            }
        }
        //dir3-east
        if (c + 1 >= 0 && c + 1 <= 7) {
            if (grid[r][c + 1] != 'e' && grid[r][c + 1] != 'h' && grid[r][c + 1] != 'm' && grid[r][c + 1] != 'q' && grid[r][c + 1] != 'k' && grid[r][c + 1] != 'p') {
                out.add(r + "" + (c + 1));
            }
        }
        //dir4-west
        if (c - 1 >= 0 && c - 1 <= 7) {
            if (grid[r][c - 1] != 'e' && grid[r][c - 1] != 'h' && grid[r][c - 1] != 'm' && grid[r][c - 1] != 'q' && grid[r][c - 1] != 'k' && grid[r][c - 1] != 'p') {
                out.add(r + "" + (c - 1));
            }
        }
    }

    private static void blackpawn(char[][] grid, int r, int c) {
        if (r == 1) {
            if (grid[2][c] == ';') {
                out.add("2" + c);
            }
            if (grid[3][c] == ';'&&grid[2][c]==';') {
                out.add("3" + c);
            }
            if (c + 1 >= 0 && c + 1 < 8) {
                if (grid[2][c + 1] == 'E' || grid[2][c + 1] == 'H' || grid[2][c + 1] == 'M' || grid[2][c + 1] == 'Q' || grid[2][c + 1] == 'K' || grid[2][c + 1] == 'P') {
                    out.add("2" + (c + 1));
                }
            }
            if (c - 1 >= 0 && c - 1 < 8) {
                if (grid[2][c - 1] == 'E' || grid[2][c - 1] == 'H' || grid[2][c - 1] == 'M' || grid[2][c - 1] == 'Q' || grid[2][c - 1] == 'K' || grid[2][c - 1] == 'P') {
                    out.add("2" + (c - 1));
                }
            }
        } else {
            if (r + 1 >= 0 && r + 1 < 8) {
                if (grid[r + 1][c] == ';') {
                    out.add((r + 1) + "" + c);
                }
                if (c + 1 >= 0 && c + 1 < 8) {
                    if (grid[r + 1][c + 1] == 'E' || grid[r + 1][c + 1] == 'H' || grid[r + 1][c + 1] == 'M' || grid[r + 1][c + 1] == 'Q' || grid[r + 1][c + 1] == 'K' || grid[r + 1][c + 1] == 'P') {
                        out.add((r + 1) + "" + (c + 1));
                    }
                }
                if (c - 1 >= 0 && c - 1 < 8) {
                    if (grid[r + 1][c - 1] == 'E' || grid[r + 1][c - 1] == 'H' || grid[r + 1][c - 1] == 'M' || grid[r + 1][c - 1] == 'Q' || grid[r + 1][c - 1] == 'K' || grid[r + 1][c - 1] == 'P') {
                        out.add((r + 1) + "" + (c - 1));
                    }
                }
            }
        }
    }

    private static void aiel(char[][] grid, int r, int c) {
        //dir1-north
        for (int i = r-1; i < 8 && i >= 0; i--) {
            if (grid[i][c] == 'E' || grid[i][c] == 'H' || grid[i][c] == 'M' || grid[i][c] == 'Q' || grid[i][c] == 'K' || grid[i][c] == 'P') {
                break;
            } else if (grid[i][c] != ';') {
                out.add(i + "" + c);
                break;
            }
            else
                out.add(i + "" + c);
        }
        //dir2-south
        for (int i = r+1; i < 8 && i > 0; i++) {
            if (grid[i][c] == 'E' || grid[i][c] == 'H' || grid[i][c] == 'M' || grid[i][c] == 'Q' || grid[i][c] == 'K' || grid[i][c] == 'P') {
                break;
            } else if (grid[i][c] != ';') {
                out.add(i + "" + c);
                break;
            }
            else
                out.add(i + "" + c);
        }
        //dir3-west
        for (int i = c-1; i < 8 && i > 0; i--) {
            if (grid[r][i] == 'E' || grid[r][i] == 'H' || grid[r][i] == 'M' || grid[r][i] == 'Q' || grid[r][i] == 'K' || grid[r][i] == 'P') {
                break;
            } else if (grid[r][i] != ';') {
                out.add(r + "" + i);
                break;
            }
            else
                out.add(r + "" + i);
        }
        //dir4-east
        for (int i = c+1; i < 8 && i >= 0; i++) {
            if (grid[r][i] == 'E' || grid[r][i] == 'H' || grid[r][i] == 'M' || grid[r][i] == 'Q' || grid[r][i] == 'K' || grid[r][i] == 'P') {
                break;
            } else if (grid[r][i] != ';') {
                out.add(r + "" + i);
                break;
            }
            else
                out.add(r + "" + i);
        }
    }

    private static void aihorse(char[][] grid, int r, int c) {
        if (r + 2 >= 0 && r + 2 < 8 && c + 1 >= 0 && c + 1 < 8) {
            if (grid[r + 2][c + 1] == 'E' || grid[r + 2][c + 1] == 'H' || grid[r + 2][c + 1] == 'M' || grid[r + 2][c + 1] == 'Q' || grid[r + 2][c + 1] == 'K' || grid[r + 2][c + 1] == 'P')
                ; else {
                out.add((r + 2) + "" + (c + 1));
            }
        }
        if (r + 2 >= 0 && r + 2 < 8 && c - 1 >= 0 && c - 1 < 8) {
            if (grid[r + 2][c - 1] == 'E' || grid[r + 2][c - 1] == 'H' || grid[r + 2][c - 1] == 'M' || grid[r + 2][c - 1] == 'Q' || grid[r + 2][c - 1] == 'K' || grid[r + 2][c - 1] == 'P')
                ; else {
                out.add((r + 2) + "" + (c - 1));
            }
        }
        if (r - 2 >= 0 && r - 2 < 8 && c + 1 >= 0 && c + 1 < 8) {
            if (grid[r - 2][c + 1] == 'E' || grid[r - 2][c + 1] == 'H' || grid[r - 2][c + 1] == 'M' || grid[r - 2][c + 1] == 'Q' || grid[r - 2][c + 1] == 'K' || grid[r - 2][c + 1] == 'P')
                ; else {
                out.add((r - 2) + "" + (c + 1));
            }
        }
        if (r - 2 >= 0 && r - 2 < 8 && c - 1 >= 0 && c - 1 < 8) {
            if (grid[r - 2][c - 1] == 'E' || grid[r - 2][c - 1] == 'H' || grid[r - 2][c - 1] == 'M' || grid[r - 2][c - 1] == 'Q' || grid[r - 2][c - 1] == 'K' || grid[r - 2][c - 1] == 'P')
                ; else {
                out.add((r - 2) + "" + (c - 1));
            }
        }
        if (r - 1 >= 0 && r - 1 < 8 && c + 2 >= 0 && c + 2 < 8) {
            if (grid[r - 1][c + 2] == 'E' || grid[r - 1][c + 2] == 'H' || grid[r - 1][c + 2] == 'M' || grid[r - 1][c + 2] == 'Q' || grid[r - 1][c + 2] == 'K' || grid[r - 1][c + 2] == 'P')
                ; else {
                out.add((r - 1) + "" + (c + 2));
            }
        }
        if (r - 1 >= 0 && r - 1 < 8 && c - 2 >= 0 && c - 2 < 8) {
            if (grid[r - 1][c - 2] == 'E' || grid[r - 1][c - 2] == 'H' || grid[r - 1][c - 2] == 'M' || grid[r - 1][c - 2] == 'Q' || grid[r - 1][c - 2] == 'K' || grid[r - 1][c - 2] == 'P')
                ; else {
                out.add((r - 1) + "" + (c - 2));
            }
        }
        if (r + 1 >= 0 && r + 1 < 8 && c + 2 >= 0 && c + 2 < 8) {
            if (grid[r + 1][c + 2] == 'E' || grid[r + 1][c + 2] == 'H' || grid[r + 1][c + 2] == 'M' || grid[r + 1][c + 2] == 'Q' || grid[r + 1][c + 2] == 'K' || grid[r + 1][c + 2] == 'P')
                ; else {
                out.add((r + 1) + "" + (c + 2));
            }
        }
        if (r + 1 >= 0 && r + 1 < 8 && c - 2 >= 0 && c - 2 < 8) {
            if (grid[r + 1][c - 2] == 'E' || grid[r + 1][c - 2] == 'H' || grid[r + 1][c - 2] == 'M' || grid[r + 1][c - 2] == 'Q' || grid[r + 1][c - 2] == 'K' || grid[r + 1][c - 2] == 'P')
                ; else {
                out.add((r + 1) + "" + (c - 2));
            }
        }
    }

    private static void aimn(char[][] grid, int r, int c) {
        for (int i = 1; i + r < 8 && i + r >= 0 && i + c < 8 && i + c >= 0; i++) {
            if (grid[r + i][c + i] == 'E' || grid[r + i][c + i] == 'H' || grid[r + i][c + i] == 'M' || grid[r + i][c + i] == 'K' || grid[r + i][c + i] == 'Q' || grid[r + i][c + i] == 'P') {
                break;
            } else if (grid[r + i][c + i] != ';') {
                out.add((r + i) + "" + (c + i));
                break;
            }
            out.add((r + i) + "" + (c + i));
        }

        for (int i = 1; r - i <= 7 && r - i >= 0 && c - i <= 7 && c - i >= 0; i++) {
            if (grid[r - i][c - i] == 'E' || grid[r - i][c - i] == 'H' || grid[r - i][c - i] == 'M' || grid[r - i][c - i] == 'K' || grid[r - i][c - i] == 'Q' || grid[r - i][c - i] == 'P') {
                break;
            } else if (grid[r - i][c - i] != ';') {
                out.add((r - i) + "" + (c - i));
                break;
            }
            out.add((r - i) + "" + (c - i));
        }

        for (int i = 1; i + r < 8 && i + r >= 0 && c - i < 8 && c - i >= 0; i++) {
            if (grid[r + i][c - i] == 'E' || grid[r + i][c - i] == 'H' || grid[r + i][c - i] == 'M' || grid[r + i][c - i] == 'K' || grid[r + i][c - i] == 'Q' || grid[r + i][c - i] == 'P') {
                break;
            } else if (grid[r + i][c - i] != ';') {
                out.add((r + i) + "" + (c - i));
                break;
            }
            out.add((r + i) + "" + (c - i));
        }

        for (int i = 1; r - i < 8 && r - i >= 0 && c + i < 8 && c + i >= 0; i++) {
            if (grid[r - i][c + i] == 'E' || grid[r - i][c + i] == 'H' || grid[r - i][c + i] == 'M' || grid[r - i][c + i] == 'K' || grid[r - i][c + i] == 'Q' || grid[r - i][c + i] == 'P') {
                break;
            } else if (grid[r - i][c + i] != ';') {
                out.add((r - i) + "" + (c + i));
                break;
            }
            out.add((r - i) + "" + (c + i));
        }
    }

    private static void aiqu(char[][] grid, int r, int c) {
        //System.out.println("VALID MOVES _ INITIAL _ "+out);
        aiel(grid, r, c);
        //System.out.println("VALID MOVES _ AFTER EL _ "+out);
        aimn(grid, r, c);
        //System.out.println("VALID MOVES _ AFTER MN _ "+out);
        aiking(grid, r, c);
        //System.out.println("VALID MOVES _ AFTER KING _ "+out);
    }

    private static void aiking(char[][] grid, int r, int c) {
        //dir1-south
        int fr=r+1,fc;
        if (fr >= 0 && fr <= 7) {
            //south-east
            fc=c+1;
            if (fc >= 0 && fc <= 7) {
                if (grid[fr][fc] != 'E' && grid[fr][fc] != 'H' && grid[r + 1][c + 1] != 'M' && grid[r + 1][c + 1] != 'K' && grid[r + 1][c + 1] != 'Q' && grid[r + 1][c + 1] != 'P') {
                    out.add((fr) + "" + (fc));
                }
            }
            //south-west
            if ((c - 1) >= 0 && (c - 1) <= 7) {
                if (grid[fr][c - 1] != 'E' && grid[fr][c - 1] != 'H' && grid[fr][c - 1] != 'M' && grid[fr][c - 1] != 'K' && grid[fr][c - 1] != 'Q' && grid[fr][c - 1] != 'P') {
                    out.add((r + 1) + "" + (c - 1));
                }
            }
            //south-pole
            if (grid[fr][c] != 'E' && grid[fr][c] != 'H' && grid[fr][c] != 'M' && grid[fr][c] != 'K' && grid[fr][c] != 'Q' && grid[fr][c] != 'P') {
                out.add((fr) + "" + c);
            }
        }
        //dir2-north
        if ((r - 1) >= 0 && (r - 1) <= 7) {
            //north-east
            if (c + 1 >= 0 && c + 1 <= 7) {
                if (grid[r - 1][c + 1] != 'E' && grid[r - 1][c + 1] != 'H' && grid[r - 1][c + 1] != 'M' && grid[r - 1][c + 1] != 'K' && grid[r - 1][c + 1] != 'Q' && grid[r - 1][c + 1] != 'P') {
                    out.add((r - 1) + "" + (c + 1));
                }
            }
            //north-west
            if ((c - 1) >= 0 && (c - 1) <= 7) {
                if (grid[r - 1][c - 1] != 'E' && grid[r - 1][c - 1] != 'H' && grid[r - 1][c - 1] != 'M' && grid[r - 1][c - 1] != 'K' && grid[r - 1][c - 1] != 'Q' && grid[r - 1][c - 1] != 'P') {
                    out.add((r - 1) + "" + (c - 1));
                }
            }
            //north-pole
            if (grid[r - 1][c] != 'E' && grid[r - 1][c] != 'H' && grid[r - 1][c] != 'M' && grid[r - 1][c] != 'M' && grid[r - 1][c] != 'Q' && grid[r - 1][c] != 'P') {
                out.add((r - 1) + "" + c);
            }
        }
        //dir3-east
        if (c + 1 >= 0 && c + 1 <= 7) {
            if (grid[r][c + 1] != 'E' && grid[r][c + 1] != 'H' && grid[r][c + 1] != 'M' && grid[r][c + 1] != 'Q' && grid[r][c + 1] != 'K' && grid[r][c + 1] != 'P') {
                out.add(r + "" + (c + 1));
            }
        }
        //dir4-west
        if (c - 1 >= 0 && c - 1 <= 7) {
            if (grid[r][c - 1] != 'E' && grid[r][c - 1] != 'H' && grid[r][c - 1] != 'M' && grid[r][c - 1] != 'Q' && grid[r][c - 1] != 'K' && grid[r][c - 1] != 'P') {
                out.add(r + "" + (c - 1));
            }
        }
    }

    private static void aipawn(char[][] grid, int r, int c) {
        if (r == 6) {
            if (grid[5][c] == ';') {
                out.add("5" + c);
            }
            if (grid[4][c] == ';'&&grid[5][c]==';') {
                out.add("4" + c);
            }
            if (c + 1 >= 0 && c + 1 < 8) {
                if (grid[5][c + 1] == 'e' || grid[5][c + 1] == 'h' || grid[5][c + 1] == 'm' || grid[5][c + 1] == 'q' || grid[5][c + 1] == 'k' || grid[5][c + 1] == 'p') {
                    out.add("5" + (c + 1));
                }
            }
            if (c - 1 >= 0 && c - 1 < 8) {
                if (grid[5][c - 1] == 'e' || grid[5][c - 1] == 'h' || grid[5][c - 1] == 'm' || grid[5][c - 1] == 'q' || grid[5][c - 1] == 'k' || grid[5][c - 1] == 'p') {
                    out.add("5" + (c - 1));
                }
            }
        } else {
            if (r - 1 >= 0 && r - 1 <= 5) {
                if (grid[r - 1][c] == ';') {
                    out.add((r - 1) + "" + c);
                }
                if (c + 1 >= 0 && c + 1 <= 7) {
                    if (grid[r - 1][c + 1] == 'e' || grid[r - 1][c + 1] == 'h' || grid[r - 1][c + 1] == 'm' || grid[r - 1][c + 1] == 'q' || grid[r - 1][c + 1] == 'k' || grid[r - 1][c + 1] == 'p') {
                        out.add((r - 1) + "" + (c + 1));
                    }
                }
                if (c - 1 >= 0 && c - 1 <= 7) {
                    if (grid[r - 1][c - 1] == 'e' || grid[r - 1][c - 1] == 'h' || grid[r - 1][c - 1] == 'm' || grid[r - 1][c - 1] == 'q' || grid[r - 1][c - 1] == 'k' || grid[r - 1][c - 1] == 'p') {
                        out.add((r - 1) + "" + (c - 1));
                    }
                }
            }
        }
    }

}
