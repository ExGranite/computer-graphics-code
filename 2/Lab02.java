import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;

public class Lab02 implements GLEventListener{
   
	private GLU glu;
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      DDA(gl, 15,10,20,10);
      DDA(gl, 15,10,15,15);
      DDA(gl, 15,10,15,5);
      DDA(gl, 15,15,20,15);
      DDA(gl, 15,5,20,5);
      DDA(gl, 20,10,20,5);
      
      DDA(gl, 10,10,5,10);
      DDA(gl, 10,10,10,15);
      DDA(gl, 10,10,10,5);
      DDA(gl, 10,5,5,5);
      DDA(gl, 10,15,5,15);
      DDA(gl, 5,10,5,15);
      
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
   
   
   public void DDA(GL2 gl, float x1, float y1, float x2, float y2) {
       
       gl.glPointSize(3.0f);
       gl.glBegin (GL2.GL_POINTS);//static field
       float dx = x2 - x1;
       float dy = y2 - y1;
       int step;
       if(Math.abs(dx) > Math.abs(dy)) {
    	   step = (int) (Math.abs(dx) * 10);
       } else {
    	   step = (int) (Math.abs(dy) * 10);
       }
       
       float xInc = dx / step;
       float yInc = dy / step;
       
       for(int i = 0; i <= step; i++) {
    	   gl.glVertex2d(x1,y1);
    	   x1 += xInc;
    	   y1 += yInc;
       }
       gl.glEnd();
       gl.glColor3d(0, 1, 0);
   }
   public static void main(String[] args) {
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
      // The canvas 
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      Lab02 l = new Lab02();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(400, 400);
      //creating frame
      final JFrame frame = new JFrame ("DDA Algorithm");
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
   }
}
//Copyright © Asad