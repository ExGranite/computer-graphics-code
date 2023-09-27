//	MashequrKhan_19101229_Assignment02
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class ok implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   ok l = new ok();
	      //creating frame
	   glcanvas.addGLEventListener(l);
	   glcanvas.setSize(800, 600);
	   
	   final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	   frame.getContentPane().add(glcanvas);
	   frame.setSize(frame.getContentPane().getPreferredSize());
	   frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
//      gl.glPointSize(10);
      gl.glBegin (GL2.GL_POINTS);//static field
      DDA(gl,-0.7,-0.7,2.5,2.5);
//          gl.glVertex2d(0.5f,0.5f);
//          gl.glVertex2d(0.5f,-0.5f);
//          gl.glVertex2d(-0.5f,0.5f);
//          gl.glVertex2d(-0.5f,-0.5f);
      gl.glEnd();
          
      
   }
   public void DDA(GL2 gl,double x1,double y1,double x2,double y2) {
	   double m = (y2-y1)/(x2-x1);
	   double x,y;
	   x = x1;
	   y = y1;
//	   gl.glVertex2d(x,y);
//	   while(x<x2) {
//		   if(m>-1 && m<1) {
//			   x+=0.0001;
//			   y+=m*0.0001;
//		   }else {
//			   y+=0.0001;
//			   x+=(1/m)*0.0001;
//		   }
//		   gl.glVertex2d(x,y);
//	   }
	   for(double fi = -0.7;fi<=0.1;fi=fi+0.01) {
		   gl.glVertex2d(fi*000.1, -0.7*000.1);
		   gl.glVertex2d(fi*000.1, 0.4*000.1);
		   gl.glVertex2d(fi*000.1, 1.5*000.1);
		   
	   }
	   for(double fi = -0.7;fi<=0.4;fi=fi+0.01) {
		   gl.glVertex2d(-0.7*000.1,fi*000.1 );
		   gl.glVertex2d(0.1*000.1, (0.7+fi+0.4)*000.1);
//		   gl.glVertex2d(fi*000.1, 1.5*000.1);
		   
	   }
	   
	   
	   for(double fi = 0.5;fi<=1.3;fi=fi+0.01) {
		   gl.glVertex2d(fi*000.1, -0.7*000.1);
		   gl.glVertex2d(fi*000.1, 0.4*000.1);
		   gl.glVertex2d(fi*000.1, 1.5*000.1);
		   
	   }
	   for(double fi = -0.7;fi<=0.4;fi=fi+0.01) {
		   gl.glVertex2d(1.3*000.1,fi*000.1 );
		   gl.glVertex2d(1.3*000.1, (0.7+fi+0.4)*000.1);
		   gl.glVertex2d(0.5*000.1, (0.7+fi+0.4)*000.1);
		   
	   }
	   
//	   gl.glVertex2d(x2,y2);
   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;