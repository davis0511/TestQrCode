import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import com.swetake.util.Qrcode;


public class CreateQrcode {
  
	 public static void createImage(String content)throws Exception{  
         try{  
                   Qrcode testQrcode =new Qrcode();  
                   testQrcode.setQrcodeErrorCorrect('M');  
                   testQrcode.setQrcodeEncodeMode('B');  
                   testQrcode.setQrcodeVersion(7);  
                   byte[] d = content.getBytes("gbk");  
                   BufferedImage bi = new BufferedImage(90, 90, BufferedImage.TYPE_BYTE_BINARY);  
                   Graphics2D g = bi.createGraphics();  
                   g.setBackground(Color.WHITE);  
                   g.clearRect(0, 0, 90, 90);  
                   g.setColor(Color.BLACK);  
                     
                   // 限制最大字节数为119  
                   if (d.length>0 && d.length <120){  
                       boolean[][] s = testQrcode.calQrcode(d);  
                       for (int i=0;i<s.length;i++){  
                           for (int j=0;j<s.length;j++){  
                               if (s[j][i]) {  
                                   g.fillRect(j*2,i*2,2,2);  
                               }  
                           }  
                       }  
                   }  
                   g.dispose();  
                   bi.flush();  
                   File f = new File("D:\\csd.jpg");  
                   if(!f.exists()) f.createNewFile();  
                   ImageIO.write(bi, "jpg", f);  
               }  
               catch (Exception e) {  
                   e.printStackTrace();  
               }   
        }  
          
        public static void main(String[] args) throws Exception {  
               String content = "http://114.215.180.200";  
               CreateQrcode.createImage(content);  
           }   
       }  