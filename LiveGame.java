package LiveGame;
import javax.swing.JFrame;  
//Ŀ�ģ���������Ϸ
//��ά������ϸ������ȡ������Χ���߻�����ȥϸ���ĸ���:
//       ���һ����Χ���ŵ�ϸ�����࣬�����м�ϸ����Դ�ѷ�������
//       ���������Χ���ŵ�ϸ�����٣������м�ϸ���µ�������

//��Ŀ��ϸҪ��
//       1��ÿ��ϸ��״̬<------��Χ8��ϸ����һ��״̬��
//       2����<--------��Χ3��ϸ��Ϊ��
//       3������״̬���ֲ���<--------���һ��ϸ����Χ������ϸ��Ϊ��
//       4����<------------����״̬��

//��������
//--------------->����ʽ����0/1����ֱ�Ӵ���ϸ��������״̬��
//--------------->����ʼ�����������0��1״̬��
//--------------->��ʼ��������������
//--------------->���յó������

//ͼ�λ���ʾ��
//--------------->��ͼƬ��0/1�����滻��

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


