package homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
    
    private static void println(String out) {
        System.out.println(out);
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
}