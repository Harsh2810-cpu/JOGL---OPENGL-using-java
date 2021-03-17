import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

public class Ellipse implements GLEventListener , MouseListener  {

     private static GLWindow window = null;
	
	 static FPSAnimator animator = null;
	
	 int[] pt = new int[6];// centre and a, b
	 int i = 0;
	 int j =0;// for display
	 float r1=0, g  = 0, b = 0;
	public static void main(String[] args) {
		GLProfile.initSingleton();
		GLProfile gp =  GLProfile.get(GLProfile.GL2);
		GLCapabilities cap = new GLCapabilities(gp);
		
		window = GLWindow.create(cap);
		window.setTitle("LAB 5- CIRCLE AND ELLIPSE");
		window.setSize(1280, 860);
	
		window.setResizable(false);
		
		 
		Ellipse d = new Ellipse();
		 
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
		
		 gl.glColor3f( 0.0f, 0.0f,0.0f );
		// Subwindow 
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex2f(640, 0);
		gl.glVertex2f(640, 860);
		gl.glEnd();
		
		if(pt[0] <= 640 )
		{
			gl.glPointSize(3);
			gl.glLineWidth(3);
			float r =(float)Math.sqrt((pt[2] - pt[0])*(pt[2] - pt[0]) + (pt[3] - pt[1])*(pt[3] - pt[1]));
			gl.glColor3f(r1, g,b);
			
			gl.glBegin(GL2.GL_LINES); 
			gl.glVertex2f(pt[0], pt[1]);
			if(r+pt[0] <= 640)
	            gl.glVertex2f(r+pt[0], pt[1]);
				else
					 gl.glVertex2f(pt[0] - r, pt[1]);	
           
            gl.glEnd();
            
            gl.glRasterPos2i(pt[0], pt[1]+10);
 	       
 	       glut.glutBitmapString(GLUT.BITMAP_HELVETICA_12, "r ="+r);  
		 for (float angle=1.0f;angle<=360;angle+=0.1)
		 {
			 
			 
		     float x2 = (float) (pt[0]+(float)Math.cos(angle)*r);
		   float  y2 = (float) (pt[1]+Math.sin(angle)*r);
		   if(x2 <= 640)
		   {
		   gl.glBegin(GL2.GL_POINTS);
		     gl.glVertex2f(x2,y2);
		     gl.glEnd();
		   }
		 }

		}
		else
		{
		if(j > 0)
		{
			 
			 
			gl.glColor3f(r1, g, b); 
			gl.glPointSize(3);
			gl.glLineWidth(3);
			
			int a =  pt[2] - pt[0];
			int b1 = pt[5] - pt[1];
			
			float p0 = (b1*b1) +((a*a)/4) - ((a*a)*b1);
			
			// Axis along X
			 gl.glBegin(GL2.GL_LINES);
	 	       
	 	       gl.glVertex2f(pt[0], pt[1]);
	 	      gl.glVertex2f(pt[0]+a, pt[1]);
	 	       gl.glEnd();
	 	       
	 	       if(pt[0]-a < 640)
	 	       {
	 	    	  gl.glBegin(GL2.GL_LINES);
		 	       
		 	       gl.glVertex2f(pt[0], pt[1]);
		 	      gl.glVertex2f(640, pt[1]);
		 	       gl.glEnd();
	 	       }
	 	       else
	 	       {
	 	    	  gl.glBegin(GL2.GL_LINES);
	 	    	  gl.glVertex2f(pt[0], pt[1]);
		 	      gl.glVertex2f(pt[0]-a, pt[1]);
		 	       gl.glEnd();  
	 	       }
	 	       
	 	      gl.glRasterPos2i(pt[0]+10, pt[1]+5);
	 	       
	 	       glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "a ="+a);  
	 	    
	 	       // Axis along Y  
	 	      gl.glBegin(GL2.GL_LINES);
		       
		       gl.glVertex2f(pt[0], pt[1]);
		      gl.glVertex2f(pt[0], pt[1]+b1);
		       gl.glEnd();
		       
              gl.glBegin(GL2.GL_LINES);
		       
		       gl.glVertex2f(pt[0], pt[1]);
		      gl.glVertex2f(pt[0], pt[1]-b1);
		       gl.glEnd();
		       
              gl.glRasterPos2i(pt[0], pt[1]+45);
	 	       
	 	       glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, " b ="+b1); 
			///////////////////////////////////
		       
			int x = 0;
			int y = b1;
			
			while((b1*b1)*x < (a*a)*y)
			{
				if(p0 <= 0)
				{
					x += 1;
					p0 += (2*(b1*b1)*x) +( 3*(b1*b1));
				}
				else
				{
					y -= 1;
					x += 1;
					p0 += (2*(b1*b1)*x) +( 3*(b1*b1)) - (2*(a*a)*y) + (2 * a*a);
				}
				
              gl.glBegin(GL2.GL_POINTS); 
				
               if(x+pt[0] > 640)
	            gl.glVertex2f(x+pt[0], y+pt[1]);//1st quad 
          
				if(-1*x+pt[0] > 640)
	            gl.glVertex2f(-1*x+pt[0], y+pt[1]);//2nd quad 
				
				
				if(-1*x+pt[0] > 640)
		            gl.glVertex2f(-1*x+pt[0], -1*y+pt[1]);//3rd quad 
				
				if(x+pt[0] > 640)
		            gl.glVertex2f(x+pt[0], -1*y+pt[1]);//4th quad 
				
				gl.glEnd();
			}
			
			p0 = (b1*b1)*(x+1/2)*(x+1/2) + (a*a)*(y - 1)*(y - 1) - (a*a*b1*b1);
			
			while(((a*a)*y >= 0))
			{
				if(p0 <= 0)
				{
					y -= 1;
					x += 1;
					
					p0 += (2*(b1*b1)*x)  - (2*(a*a)*y)+ (3*(a*a)) + (2 * b1*b1);
				}
				else
				{
					y -= 1;
					
					p0 += ( 3*(a*a)) - (2*(a*a)*y);
					
					
				}
				
              gl.glBegin(GL2.GL_POINTS); 
				
               if(x+pt[0] > 640)
	            gl.glVertex2f(x+pt[0], y+pt[1]);//1st quad 
          
				if(-1*x+pt[0] > 640)
	            gl.glVertex2f(-1*x+pt[0], y+pt[1]);//2nd quad 
				
				
				if(-1*x+pt[0] > 640)
		            gl.glVertex2f(-1*x+pt[0], -1*y+pt[1]);//3rd quad 
				
				if(x+pt[0] > 640)
		            gl.glVertex2f(x+pt[0], -1*y+pt[1]);//4th quad 
				
				gl.glEnd();
			}
 	      
 	       
			
		}
		}
		
		gl.glColor3f( 1.0f, 0.0f,0.0f );
	       gl.glRasterPos2i(900, 60);
	       
	       glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, "Harsh Shukla- 500068287");
	       
	       gl.glColor3f( 0.0f, 0.0f,1.0f );
           gl.glRasterPos2i(110, 820);
	       
	       glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, "CIRCLE");  
	       
           gl.glRasterPos2i(710, 820);
	       
	       glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, "ELLIPSE ");  
	       
	       gl.glColor3f( 0.0f, 1.0f,0.0f );

           gl.glRasterPos2i(710, 795);
	       
	       glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "I/P(CENTRE, MAJOR AXIS, MINOR AXIS)");  
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
         GL2 gl = arg0.getGL().getGL2();
		
		gl.glClearColor(  1.0f,   1.0f,  1.0f, 1);
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT );
		arg0.swapBuffers();
		
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
        GL2 gl = arg0.getGL().getGL2();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		gl.glOrtho(0, 1280, 0, 860, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}

	int[] temp = new int[6];
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(i < 6)
		{
			temp[i++] = arg0.getX();
			temp[i++] = 860 - arg0.getY();
		}
		if(i == 6)
		{
			 pt[0] = temp[0];
			 pt[1] = temp[1];
			 pt[2] = temp[2];
			 pt[3] = temp[3];
			 pt[4] = temp[4];
			 pt[5] = temp[5];
			 
			 r1 = (float)Math.random() +0.1f;
			 g = (float)Math.random();
			 b = (float)Math.random() ;
			j++;
			i = 0;
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
