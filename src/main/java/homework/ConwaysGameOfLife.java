package homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

public class ConwaysGameOfLife {
	
    public static void main(String[] args) {
    	ConwaysGameOfLife game = new ConwaysGameOfLife();
    	
    	if(args.length == 2) {
	        game.readProps(args[0]);
	        game.setGame(args[1]);
        }
        
        if(args.length == 1) {
	        game.readProps(args[0]);
	        game.setGame(null);
        }
        
        if(args.length == 0) {
	        game.readProps(null);
	        game.setGame(null);
        }
    }
    
    boolean flgRandomCell = false;
	private Properties props = new Properties();
	int[] boardSize = {40,80};
	private Cell cell = null;
    
    private static void println(String out) {
        System.out.println(out);
    }
    
    private static void print(String out) {
        System.out.print(out);
    }
    
    /**
     * 설정 파일 읽기
     * @param propFileName
     */
    private void readProps(String propFileName) {
    	if(propFileName != null) {
	    	println("Working Directory : " + System.getProperty("user.dir"));
	        String propsPath = System.getProperty("user.dir");
	
	        try {
				this.props.load(new FileInputStream(propsPath + "\\" + propFileName));
			} catch (IOException e) {
				println("Initialize Random Cells");
				this.flgRandomCell = true;
			}
    	} else {
    		this.flgRandomCell = true;
    	}
    }
    
    /**
     * 게임 정보 초기화
     * @param strGeneration
     */
    private void setGame(String strGeneration) {
    	
    }
    
    /**
     * 살아있는 셀 설정
     */
    private void inputSizeofSquare() {
    	String _boardSize = this.props.getProperty("init.boardSize");
    	
    	if(_boardSize != null) {
	        StringTokenizer tokenizer = new StringTokenizer(_boardSize, ",");
	        int pList = 0;
	        
			while (tokenizer.hasMoreElements()) {
				this.boardSize[pList] = Integer.parseInt(tokenizer.nextToken());
				pList++;
			}
    	}
		
		 println("Size of square : " + this.boardSize[0] + "*" +this. boardSize[1]);
        
        setCellSize(this.boardSize[0], this.boardSize[1]);
    }
    
    private void setCellSize(int rows, int cols) {
        cell = new Cell(rows, cols);
    }
    
    /**
     * Cell 클래스
     * 
     * @author yep
     *
     */
    class Cell {
        private final int cellSize[];
        private final boolean[][] cell;

        Cell(int x, int y) {
        	cellSize = new int[2];
            cell = new boolean[x][y];
            
            cellSize[0] = x; cellSize[1] = y;
        }

        boolean isAlive(int x, int y) {
            return cell[x][y];
        }

        void setAlive(int x, int y) {
            cell[x][y] = true;
        }

        private int countAdjacentCellsAlive(int x, int y) {
            int count = 0;
            for (int i = x - 1; i <= x + 1; i++) {
                if (i < 0 || i >= cellSize[0]) {
                    continue;
                }
                for (int j = y - 1; j <= y + 1; j++) {
                    if (j < 0 || j >= cellSize[1]) {
                        continue;
                    }
                    if (i == x && j == y) {
                        continue;
                    }
                    if (cell[i][j]) {
                        count++;
                    }
                }
            }

            return count;
        }

        private void step() {
            for (int i = 0; i < cellSize[0]; i++) {
                for (int j = 0; j < cellSize[1]; j++) {
                    int count = countAdjacentCellsAlive(i, j);
                    if (count == 3) {
                        cell[i][j] = true;
                    } else if (count != 2) {
                        cell[i][j] = false;
                    }
                }
            }
        }

        private void draw() {
            for (int i = 0; i < cellSize[0]; i++) {
                println("");
                for (int j = 0; j < cellSize[1]; j++) {
                    if (cell[i][j]) {
                        print(" O");
                    } else {
                        print(" X");
                    }
                }
                // println("");
            }
        }
        
    }
}