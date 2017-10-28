
package LiveGame;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JPanel;  
import javax.swing.Timer;  
  
public class LiveMap  extends JPanel {  
  
    private final int width = 30;  //每个小方格的长度 
    private final int height = 30;    //每个小方格的高度
  
    //----------->创建随机矩阵
	// int[][] live = new int[20][20];
	 private final int[][] live={
			 {1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0 },
			 {1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0 },
			 {0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1 },
			 {0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
			 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1 },
			 {1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0 },
			 {0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
			 {1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
			 {1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1 },
			 {0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0 },
			 {0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0 },
			 {1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1 },
			 {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0 },
			 {1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0 },
			 {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1 },
			 {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0 },
			 {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1 },
			 {0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1 },
			 {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1 },
			 {1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1 },
			 {0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0},
	 };
	 int n;    //进行生命游戏的次数
	 int t;   //统计
	 int live_MAP_NONE = 0;  
	 int live_MAP_ALIVE = 1;
	 int i,j = 0;
	
	  
     // 当前细胞下一状态       
    public int[][] live1={
			 {1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0 },
			 {1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0 },
			 {0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1 },
			 {0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
			 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1 },
			 {1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0 },
			 {0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
			 {1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
			 {1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1 },
			 {0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0 },
			 {0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0 },
			 {1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1 },
			 {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0 },
			 {1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0 },
			 {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1 },
			 {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0 },
			 {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1 },
			 {0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1 },
			 {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1 },
			 {1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1 },
			 {0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0},
	 };
    private Timer timer;  
    // 动画帧之间的延时 
    private final int DELAY_TIME = 2400;  
    
    
    public LiveMap()
    {  
        this.startAnimation();  
    }  
  
    //绘制GUI图形界面 
    protected void paintComponent(Graphics g) 
    {  
        super.paintComponent(g);  
        for (int i = 0; i < live1.length; i++)
        {  
            for (int j = 0; j < live1[i].length; j++) 
            {  
                if (live1[i][j] == live_MAP_ALIVE) 
                {  
                    g.fillRect( j * width, i * height, width, height);  
                   
                }
                else
                {  
                	 g.drawRect( j * width, i * height, width, height); 
                }  
            }  
        }  
    }  
  
    //进行生命更新 
    private void changeCellStatus() {   
        
      int i=20;
      int j=20;
		 //分三类情况
		 //------------->四个角落相邻仅3个点
		 //------------->边界相邻有5个点
		 //------------->其它相邻考虑8个点
		
			//情况一分情况考虑
				//-------------------------------->左上角live[0][0]
			 t=live1[0][1]+live1[1][0]+live1[1][1];
			 if (t==3)
				 live1[0][0]=1;   //生
			 if (t==2)
				 live1[0][0]=live1[0][0];
			 else 
				 live1[0][0]=0;   //死
			  //---------------------------------->左下角live1[i-1][0]
			 t=live1[i-2][0]+live1[i-1][1]+live1[i-2][1];
			 if (t==3)
				 live1[i-1][0]=1;   //生
			 if (t==2)
				 live1[i-1][0]=live1[i-1][0];
			 else 
				 live1[i-1][0]=0;   //死
			 //---------------------------------->右上角live1[0][i-1]
			 t=live1[0][i-2]+live1[1][i-1]+live1[1][i-2];
			 if (t==3)
				 live1[0][i-1]=1;   //生
			 if (t==2)
				 live1[0][i-1]=live1[0][i-1];
			 else 
				 live1[0][i-1]=0;   //死
			//---------------------------------->右下角live1[i-1][i-1]
			 t=live1[i-1][i-2]+live1[i-2][i-1]+live1[i-2][i-2];
			 if (t==3)
				 live1[i-1][i-1]=1;   //生
			 if (t==2)
				 live1[i-1][i-1]=live1[i-1][i-1];
			 else 
				 live1[i-1][i-1]=0;   //死
			 
			 //下面开始对四条边界进行考虑
			 //---------------------------------->上边界
			 for (int a=1;a<19;a++) 
			 {
				 t=live1[0][a-1]+live1[0][a+1]+live1[1][a-1]+live1[1][a]+live1[1][a+1];
				 if (t==3)
					 live1[0][a]=1;   //生
				 if (t==2)
					 live1[0][a]=live1[0][a];
				 else 
					 live1[0][a]=0;   //死
			 }
			 
			//---------------------------------->下边界
			 for (int a=1;a<19;a++) 
			 {
				 t=live1[19][a-1]+live1[19][a+1]+live1[18][a-1]+live1[18][a]+live1[18][a+1];
				 if (t==3)
					 live1[19][a]=1;   //生
				 if (t==2)
					 live1[19][a]=live1[0][a];
				 else 
					 live1[19][a]=0;   //死
			 }
			 
			//---------------------------------->左边界
			 for (int a=1;a<19;a++) 
			 {
				 t=live1[a-1][0]+live1[a+1][0]+live1[a][1]+live1[a-1][1]+live1[a+1][1];
				 if (t==3)
					 live1[a][0]=1;   //生
				 if (t==2)
					 live1[a][0]=live1[a][0];
				 else 
					 live1[a][0]=0;   //死
			 }
			//---------------------------------->右边界
			 for (int a=1;a<19;a++) 
			 {
				 t=live1[a-1][19]+live1[a+1][19]+live1[a][18]+live1[a-1][18]+live1[a+1][18];
				 if (t==3)
					 live1[a][19]=1;   //生
				 if (t==2)
					 live1[a][19]=live1[a][19];
				 else 
					 live1[a][19]=0;   //死
			 }	 
			 
			 //---------------------------------->中间部分
			  for (int a=1;a<19;a++) 
				  for (int b=1;b<19;b++)
				  {
					  t=live1[a-1][b-1]+live1[a-1][b]+live1[a-1][b+1]+live1[a][b-1]+live1[a][b]+live1[a][b+1]+live1[a+1][b-1]+live1[a+1][b]+live1[a+1][b+1];
					  if (t==3)
							 live1[a][b]=1;   //生
						 if (t==2)
							 live1[a][b]=live1[a][b];
						 else 
							 live1[a][b]=0;   //死
				  }
		
		 for (i=0;i<20;i++) 
		 {
			 for(j=0;j<20;j++)
			 {
				 System.out.print(live1[i][j]); 
				 System.out.print(" ");
			 }
			 System.out.print("\n"); 
		 }
        copyliveMap();    
  
}
  
   //GUI展示 
    private void startAnimation() 
    {  
        for (int row = 0; row < live1.length; row++)
        {  
            for (int col = 0; col < live1[0].length; col++) 
            {  
                live1[row][col] = live1[row][col];  
                live1[row][col] = live1[row][col];  
            }  
        }  
        // 创建计时器  
        timer = new Timer(DELAY_TIME, new ActionListener()
        {  
  
            @Override  
            public void actionPerformed(ActionEvent e) 
            {  
                changeCellStatus();  
                repaint();  
            }  
        });  
        // 开启计时器  
        timer.start();  
    }  
  
    //保存新地图   
    private void copyliveMap() 
    {  
        for (int row = 0; row < live1.length; row++)
        {  
            for (int col = 0; col < live1[row].length; col++)
            {  
                live1[row][col] = live1[row][col];  
            }  
        }  
    }  
}  