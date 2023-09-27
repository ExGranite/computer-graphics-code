import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;

public class Lab03 implements GLEventListener{
   
	private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      MidLine(gl, 15,10,20,10);
      MidLine(gl, 15,10,15,15);
      MidLine(gl, 15,10,15,5);
      MidLine(gl, 15,15,20,15);
      MidLine(gl, 15,5,20,5);
      MidLine(gl, 20,10,20,5);
      
      MidLine(gl, 10,10,5,10);
      MidLine(gl, 10,10,10,15);
      MidLine(gl, 10,10,10,5);
      MidLine(gl, 10,5,5,5);
      MidLine(gl, 10,15,5,15);
      MidLine(gl, 5,10,5,15);
      MidLine(gl, 5,10,5,15);
      
   }
   public static void MidLine(GL2 gl, int a1, int b1, int a2, int b2){
	   
	   int zone = Zone(a1,b1,a2,b2);
       int[] c1 = ConvertToZone0(a1,b1,zone);
       int[] c2 = ConvertToZone0(a2,b2,zone);
	   int x1 = c1[0];
	   int y1 = c1[1];
	   int x2 = c2[0];
	   int y2 = c2[1];
	   
	   gl.glPointSize(3.0f);
       gl.glBegin (GL2.GL_POINTS);
	   
       int dx = x2 - x1;
       int dy = y2 - y1;
       int dNE = 2 * dy - 2 * dx;
       int dE = 2 * dy;
       int d = 2 * dy - dx;
       
       float x = x1; float y = y1;
       float[] a3 = OriginalZone(x,y,zone);
       gl.glVertex2d(a3[0], a3[1]);
       
       while(x <= x2){
           if(d <= 0){
               d += dE;
               for(int i = 0; i < 10; i++) {
            	   x += 0.1;
            	   a3 = OriginalZone(x,y,zone);
            	   gl.glVertex2d(a3[0], a3[1]);
               }
           }else{
               d += dNE;
               for(int i = 0; i < 10; i++) {
            	   x += 0.1; y += 0.1;
            	   a3 = OriginalZone(x,y,zone);
            	   gl.glVertex2d(a3[0], a3[1]);
               }
           }
       }
       
       gl.glEnd();
       gl.glColor3d(0, 1, 0);
   }
   public static int Zone(int x1, int y1, int x2, int y2){
       int dx = x2 - x1;
       int dy = y2 - y1;
       int zone = -1;
       if(Math.abs(dx) > Math.abs(dy)){
           if(dx > 0 && dy >= 0){
               zone = 0;
           }else if(dx < 0 && dy >= 0){
               zone = 3;
           }else if(dx < 0 && dy <= 0){
               zone = 4;
           }else if(dx > 0 && dy <= 0){
               zone = 7;
           }
       }else{
           if(dx >= 0 && dy > 0){
               zone = 1;
           }else if(dx <= 0 && dy > 0){
               zone = 2;
           }else if(dx <= 0 && dy < 0){
               zone = 5;
           }else if(dx >= 0 && dy < 0){
               zone = 6;
           }
       }
       return zone;
   }
   public static int[] ConvertToZone0(int x, int y, int zone){
       int x1 = 0, y1 = 0;
       if(zone == 1){
           x1=y; y1=x;
       }else if(zone == 2){
           x1=y; y1=-x;
       }else if(zone == 3){
           x1=-x; y1=y;
       }else if(zone == 4){
           x1=-x; y1=-y;
       }else if(zone == 5){
           x1=-y; y1=-x;
       }else if(zone == 6){
           x1=-y; y1=x;
       }else if(zone == 7){
           x1=x; y1=-y;
       }else if(zone == 0){
           x1=x; y1=y;
       }
       int[] a = {x1, y1};
       return a;
   }
   public static float[] OriginalZone(float x, float y, int zone){
       float x1 = 0, y1 = 0;
       if(zone == 1){
           x1=y; y1=x;
       }else if(zone == 2){
           x1=-y; y1=x;
       }else if(zone == 3){
           x1=-x; y1=y;
       }else if(zone == 4){
           x1=-x; y1=-y;
       }else if(zone == 5){
           x1=-y; y1=-x;
       }else if(zone == 6){
           x1=y; y1=-x;
       }else if(zone == 7){
           x1=x; y1=-y;
       }else if(zone == 0){
           x1=x; y1=y;
       }
       float[] a = {x1, y1};
       return a;
   }
   @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }
   
   @Override
   public void init(GLAutoDrawable gld) {
       GL2 gl = gld.getGL().getGL2();
       glu = new GLU();

       gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
       gl.glViewport(-100, -50, 50, 100);
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
       glu.gluOrtho2D(0.0, 25.0, 0.0, 25.0);
   }

   

   @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   
   public static void main(String[] args) {
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
      // The canvas 
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      Lab03 l = new Lab03();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(400, 400);
      //creating frame
      final JFrame frame = new JFrame ("Midpoint Line Algorithm");
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
   }
}
//Copyright © Asad