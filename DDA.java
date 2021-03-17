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

 
public class DDA implements GLEventListener, MouseListener {

	private static GLWindow window = null;
	
	static FPSAnimator animator = null;
	
	static int[] pts = new int[4]; //x1, y1, x2, y2;Point coordinates
	
	static int i = 0, j =0;
	float r=0, g  = 0, b = 0;
	public static void main(String[] args) {
		GLProfile.initSingleton();
		GLProfile gp =  GLProfile.get(GLProfile.GL2);
		GLCapabilities cap = new GLCapabilities(gp);
		
		window = GLWindow.create(cap);
		window.setTitle("EXPERIMENT 3: DDA");
		window.setSize(880, 560);
		
		window.setResizable(false);
		
		 DDA d = new DDA();
		 
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
	    	 //gl.glPointSize(5);
	    	 float X1, Y1, X2, Y2 ;
	    	     
	    	 if(pts[0] < pts[2])
	    	 {
	    		X1 = pts[0];
	    		X2 = pts[2];
	    		
	    		Y1 = pts[1];
	    		Y2 = pts[3];
	    		 
	    	 }
	    	 else
	    	 {
	    		 X1 = pts[2];
	    		X2 = pts[0];
	    		
	    		Y1 = pts[3];
	    		Y2 = pts[1];
	    	 }
	    	    
	    	    gl.glColor3f(r, g,b);
	    	   
	    	    float dy = pts[3] -pts[1];
	    	    float dx = pts[2] - pts[0];
	    	    
	    	    float m;
	    	    if(dx != 0)
	    	     m = dy / dx;
	    	    else
	    	    {
	    	      m= (float)Double.POSITIVE_INFINITY;
	    	    	
	    	    }
	    	   
	    	    if((m) <= 1 && m>=0)
	    	    {
	    	    	 
	    	    	while(X1 <= X2)
	    	    	{
	    	    		gl.glBegin(GL2.GL_POINTS);   
		    	         gl.glVertex2f(X1, Y1);
		    	        gl.glEnd();
		    	        
		    		      
		    	        X1++;
		    	        Y1 += m;
		    	        
	    	    	}
	    	    	 
	    	    }
	    	    if((m) > 1 )
	    	    {
	    	    	while(Y1 <=Y2)
	    	    	{
	    	    		gl.glBegin(GL2.GL_POINTS); 
		    	         gl.glVertex2f(X1, Y1);
		    	        gl.glEnd();
		    	        X1 += (1/m);
		    	        Y1++;
	    	    	}
	    	    }
	    	    
	    	    
	    	    if(m >= -1 && m <0)
	    	    {
	    	    	 
	    	    	while(X1 <= X2)
	    	    	{
	    	    		gl.glBegin(GL2.GL_POINTS);  
		    	         gl.glVertex2f(X1, Y1);
		    	        gl.glEnd();
		    	        
		    	        X1++;
		    	        Y1 += m;
	    	    	}
	    	    }
	    	    if(pts[3] < pts[1])
	    	    {
	    	    	Y1 = pts[3];
	    	    	X1 = pts[2];
	    	    	
	    	    	Y2= pts[1];
	    	    }
	    	    else
	    	    {
	    	    	Y1 = pts[1];
	    	    	X1 = pts[0];
	    	    	Y2= pts[3];
	    	    }
	    	    if(m < -1 )
	    	    {
	    	    	while(Y1 <= Y2)
	    	    	{
	    	    		gl.glBegin(GL2.GL_POINTS);  
		    	         gl.glVertex2f(X1, Y1);
		    	        gl.glEnd();
		    	        X1 += (1/ m);
		    	        Y1++;
	    	    	}
	    	    }
	    	     
	   	     gl.glRasterPos2f(X1, Y1);
	   	       glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "m :"+Float.toString(m));
	   	    gl.glBegin(GL2.GL_QUADS);
		       
		       gl.glVertex2f(50, 50);
		       gl.glVertex2f(50, 100);
		       gl.glVertex2f(100, 100);
		       gl.glVertex2f(100, 50);
		       
		       gl.glEnd();
	    	  
	    	     // for again taking the input
	     }
	    
	     gl. glColor3f( 1.0f, 0.0f,0.0f  );
	     
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
		 {/*
			 pts[i++] = e.getX();
			 pts[i++] = 560 - e.getY();*/
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
