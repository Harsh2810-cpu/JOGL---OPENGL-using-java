// Give the input by mouse clicks 
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

 
public class Bresenham implements GLEventListener, MouseListener {

	private static GLWindow window = null;
	
	static FPSAnimator animator = null;
	
	static int[] pts = new int[4]; //x1, y1, x2, y2;Point coordinates
	
	static int i = 0, j =0;
	float r=0, g  = 0, b = 0;
	
	int b1 = 5, b2 = 560;//for boxes
	public static void main(String[] args) {
		GLProfile.initSingleton();
		GLProfile gp =  GLProfile.get(GLProfile.GL2);
		GLCapabilities cap = new GLCapabilities(gp);
		
		window = GLWindow.create(cap);
		window.setTitle("EXPERIMENT 4: Bresenham");
		window.setSize(880, 560);
		
		window.setResizable(false);
		
		Bresenham d = new Bresenham();
		 
		window.addGLEventListener(d);
		window.addMouseListener(d);
		
		window.setVisible(true);
		animator = new FPSAnimator(window, 60 );
	    window.setFullscreen(false);
	     
		animator.start();
		 
		 
	}
	 
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		GL2 gl = arg0.getGL().getGL2();
		 
		GLUT glut = new GLUT();
	     if(j != 0 && j %2 == 0 )
	     {
	    	 int x1 = pts[0];
	 		int y1 = pts[1];
	 		
	 		int x2 = pts[2];
	 		int y2 = pts[3];
	 		
	 		int dy = Math.abs(y2 - y1);
	 		int dx = Math.abs(x2 - x1);
	 		
	 		if(x1 > x2)
	 		{
	 			int temp = x1;
	 			x1 = x2;
	 			x2 = temp;
	 			
	 			temp = y1;
	 			y1 = y2;
	 			y2 = temp;
	 		}
	 		
	 		float m = (y2 - y1)/(float)(x2 - x1);
	 		
	 		gl.glColor3f(r, g,b);
	 		
	 		if(m <= 1 && m >= 0)
	 		{
	 			int idp = (2*dy) - dx;// initial decision parameter
	 			
	 			gl.glBegin(GL2.GL_POINTS);   
   	            gl.glVertex2f(x1, y1);
   	            gl.glEnd();
	 			while(x1 < x2)
	 			{
	 				x1 += 1;
	 				if(idp > 0)
	 				{
	 					y1 = y1+1;
	 					idp = idp + ((2*dy) - (2*dx));
	 				}
	 				else
	 				{
	 					y1 = y1;
	 					idp = idp + (2*dy);
	 				}
	 				gl.glBegin(GL2.GL_POINTS);   
	   	            gl.glVertex2f(x1, y1);
	   	            gl.glEnd();
	 				
	 			}	
	 		}
	 		
	 		if(m > 1)
	 		{
	 			int idp = (2*dx) - dy;// initial decision parameter
	 			
	 			
	 			gl.glBegin(GL2.GL_POINTS);   
   	            gl.glVertex2f(x1, y1);
   	            gl.glEnd();
	 			while(y1 < y2)
	 			{
	 				y1 += 1;
	 				if(idp > 0)
	 				{
	 					x1 = x1+1;
	 					idp = idp + ((2*dx) - (2*dy));
	 				}
	 				else
	 				{
	 					x1 = x1;
	 					idp = idp + (2*dx);
	 				}
	 				
	 				gl.glBegin(GL2.GL_POINTS);   
	   	            gl.glVertex2f(x1, y1);
	   	            gl.glEnd();
	 			}	
	 		}
	 		
	 		if(m > -1 && m < 0)
	 		{
	 			int idp = (2*dy) - dx;// initial decision parameter
	 			
	 			
	 			gl.glBegin(GL2.GL_POINTS);   
   	            gl.glVertex2f(x1, y1);
   	            gl.glEnd();
	 			
	 			while(x1 < x2)
	 			{
	 				x1 += 1;
	 				if(idp > 0)
	 				{
	 					y1 = y1-1;
	 					idp = idp + ((2*dy) - (2*dx));
	 				}
	 				else
	 				{
	 					y1 = y1;
	 					idp = idp + (2*dy);
	 				}
	 				
	 				gl.glBegin(GL2.GL_POINTS);   
	   	            gl.glVertex2f(x1, y1);
	   	            gl.glEnd();
	 			}	
	 		}
	 		
	 		if(y1 > y2)
	 		{
	 			int temp = x1;
	 			x1 = x2;
	 			x2 = temp;
	 			
	 			temp = y1;
	 			y1 = y2;
	 			y2 = temp;
	 		}
	 		
	 		if(m < -1)
	 		{
	 			int idp = (2*dx) - dy;// initial decision parameter
	 			
	 			
	 			gl.glBegin(GL2.GL_POINTS);   
   	            gl.glVertex2f(x1, y1);
   	            gl.glEnd();
	 			
	 			while(y1 < y2)
	 			{
	 				y1 += 1;
	 				if(idp > 0)
	 				{
	 					x1 = x1-1;
	 					idp = idp + ((2*dx) - (2*dy));
	 				}
	 				else
	 				{
	 					x1 = x1;
	 					idp = idp + (2*dx);
	 				}
	 				
	 				
	 				gl.glBegin(GL2.GL_POINTS);   
	   	            gl.glVertex2f(x1, y1);
	   	            gl.glEnd();
	 			}
	 			
	 		}
	 		gl.glBegin(GL2.GL_LINE_LOOP);
		       
		       gl.glVertex2f(b1, b2);
		       gl.glVertex2f(b1+125, b2);
		       gl.glVertex2f(b1+125, b2-30);
		       gl.glVertex2f(b1, b2-30); 
		       
		       gl.glEnd();
		       
		       gl.glRasterPos2i(b1+3, b2 -15);
		       
		       glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, ""+m);
		     
		       
	    	    }
	    	     
	    
	     gl.glColor3f( 1.0f, 0.0f,0.0f );
	     gl.glRasterPos2i(5, 530);
	       
	       glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "SLOPES");
	     
	       gl.glRasterPos2i(570, 50);
	       
	       glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Harsh Shukla- 500068287");
	      
	 	}
	 
	public void dispose(GLAutoDrawable arg0) {
		}
	 
	public void init(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();
		
		gl.glClearColor(  0.0f,   0.0f,  0.0f, 1);
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT );
		arg0.swapBuffers();
		  
		System.out.println("INIT");
		
		}
	 
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		
		GL2 gl = arg0.getGL().getGL2();
		
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		gl.glOrtho(0, 880, 0, 560, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		System.out.println("RESHAPE");
	}
	int[] temp = new int[4];
	public void mouseClicked(MouseEvent e) {
		 if(i<3)
		 {
			 temp[i++] = e.getX();
			 temp[i++] = 560 - e.getY();
			 System.out.println("EXE"+ temp[0]+ " "+temp[1]);
			 if(i >= 4)
			 {
				
				 pts[0] = temp[0];
				 pts[1] = temp[1];
				 pts[2] = temp[2];
				 pts[3] = temp[3];
				 r = (float)Math.random() +0.1f;
				 g = (float)Math.random();
				 b = (float)Math.random() ;
				 j += 2;
				  b2 = b2 -35;
				 i = 0;
			 }
		 }
		
	}
	 
	public void mouseDragged(MouseEvent arg0) {
	 
	}
	 
	public void mouseEntered(MouseEvent arg0) {
		 
	}
	 
	public void mouseExited(MouseEvent arg0) {
		 
	}
	 
	public void mouseMoved(MouseEvent arg0) {
		 
	}
	 
	public void mousePressed(MouseEvent arg0) {
		 
	}
	 
	public void mouseReleased(MouseEvent arg0) {
		 
	}
	 
	public void mouseWheelMoved(MouseEvent arg0) {
		 
	}

}
