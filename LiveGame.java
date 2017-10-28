package LiveGame;
import javax.swing.JFrame;  
//目的：做生命游戏
//二维数组中细胞生死取决于周围或者或者死去细胞的个数:
//       情况一：周围活着的细胞过多，导致中间细胞资源匮乏而死；
//       情况二：周围活着的细胞过少，导致中间细胞孤单而死；

//题目详细要求：
//       1、每个细胞状态<------周围8个细胞上一次状态；
//       2、生<--------周围3个细胞为生
//       3、生死状态保持不变<--------如果一个细胞周围有两个细胞为生
//       4、死<------------其他状态下

//处理方法：
//--------------->处理方式：用0/1矩阵直接代表细胞的生死状态。
//--------------->给初始矩阵随机分配0、1状态。
//--------------->初始化最大迭代代数。
//--------------->最终得出结果。

//图形化显示：
//--------------->用图片对0/1进行替换。

public class LiveGame extends JFrame{  
  
        
  
    LiveGame(){  
        this.setSize(700,700);  
        this.setTitle("LiveGame");  
        this.add(new LiveMap( ));  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);  
        this.setResizable(false);  
    }  
      
    public static void main(String[] args){      	
        LiveGame game = new LiveGame();  
        game.setVisible(true);  
    }  
  
}


