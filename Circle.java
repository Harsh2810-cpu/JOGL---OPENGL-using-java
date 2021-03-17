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

public class Circle implements GLEventListener , MouseListener  {

     private static GLWindow window = null;
	
	 static FPSAnimator animator = null;
	
	 int[] pt = new int[4];// centre and radius
	 int i = 0;
	 int j =0;// for display
	 float r1=0, g  = 0, b = 0;
	public static void main(String[] args) {
		GLProfile.initSingleton();
		GLProfile gp =  GLProfile.get(GLProfile.GL2);
		GLCapabilities cap = new GLCapabilities(gp);
		
		window = GLWindow.create(cap);
		window.setTitle("First VIVA");
		window.setSize(1280, 860);
	
		window.setResizable(false);
		
		 
		Circle d = new Circle();
		 
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
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex2f(640, 0);
		gl.glVertex2f(640, 960);
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
		/*if(j > 0)
		{*/
			   
			float r =(float)Math.sqrt((pt[2] - pt[0])*(pt[2] - pt[0]) + (pt[3] - pt[1])*(pt[3] - pt[1]));
			float c =pt[0];
			float idp;
			float d = pt[1];
			if(Math.abs((double)r) == r)
			 idp = 1 - r;
			else
				idp = 1.25f -r;
			
			gl.glColor3f(r1, g,b); 
			gl.glPointSize(3);
			gl.glLineWidth(3);
			
			gl.glBegin(GL2.GL_LINES); 
			gl.glVertex2f(pt[0], pt[1]);
			
            gl.glVertex2f(r+pt[0], pt[1]);
			
            gl.glEnd();
            
            gl.glRasterPos2i(pt[0], pt[1]+10);
 	       
 	       glut.glutBitmapString(GLUT.BITMAP_HELVETICA_12, "r ="+r);  
 	       
			gl.glBegin(GL2.GL_POINTS);
			    if(pt[0] > 640)
	            gl.glVertex2f(pt[0], r+pt[1]);
	            gl.glEnd();
	       
	            float x = 0, y = r;
	            
	        	  
			while(x <=y )
			{
				if(idp < 0)
			    {
					idp = idp + (2*x) + 3;
					
				}
				else
				{
					idp = idp + (2*(x - y)) +5;
					y = y - 1;
				}
				x  += 1;
				gl.glBegin(GL2.GL_POINTS); 
				
				if(x+pt[0] > 640)
	            gl.glVertex2f(x+pt[0], y+pt[1]);//1st octant 
				
				if(y+pt[0] > 640)
	            gl.glVertex2f(y+pt[0], x+pt[1]);// 2nd octant 
				
				if(y+pt[0] > 640)
	            gl.glVertex2f(y +pt[0], -1*x+pt[1]);// 3rd octant
				
				if(x+pt[0] > 640)
	            gl.glVertex2f(x +pt[0], -1*y+pt[1]);// 4th octant
				
				
				if(-1*x +pt[0] > 640)
	            gl.glVertex2f(-1*x +pt[0], -1*y+pt[1]);// 5th octant
	            
	            if(-1*y +pt[0] > 640)
	            gl.glVertex2f(-1*y +pt[0], -1*x+pt[1]);// 6th octant
	            
	            if(-1*x +pt[0] > 640)
	            gl.glVertex2f( -1*x + pt[0], y+pt[1]);// 7th octant
	            
	            if(-1*y +pt[0] > 640)
	            gl.glVertex2f(-1*y+pt[0], x +pt[1]);// 8th octant
	            gl.glEnd();
				//System.out.println(x+ " "+y);
	            
	            
			}
			
		//}
		}
		
		gl.glColor3f( 1.0f, 0.0f,0.0f );
	       gl.glRasterPos2i(900, 60);
	       
	       glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, "Harsh Shukla- 500068287");
	       
           gl.glRasterPos2i(110, 820);
	       
	       glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, "Polar Implementation");  
	       
           gl.glRasterPos2i(750, 820);
	       
	       glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, "Mid Point Implementation");  
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

	int[] temp = new int[4];
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(i < 3)
		{
			temp[i++] = arg0.getX();
			temp[i++] = 860 - arg0.getY();
		}
		if(i == 4)
		{
			 pt[0] = temp[0];
			 pt[1] = temp[1];
			 pt[2] = temp[2];
			 pt[3] = temp[3];
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
