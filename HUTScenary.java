import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.gl2.GLUT;

public class HUTScenary implements GLEventListener{
	 public static void curve(GLAutoDrawable gl1, float angle1, double radius1, float x1, float y1, float R, float G, float B, float increment)
	   {
		   GL2 gl = gl1.getGL().getGL2();
		   float x2,y2;
			 float angle;
			 double radius= radius1;
			 
			gl. glColor3f(R, G, B);

			 gl.glBegin(GL2.GL_TRIANGLE_FAN);
			 gl.glVertex2f(x1,y1);

			 for (angle=1.0f;angle<angle1;angle+=increment)
			 {
			     x2 = (float) (x1+(float)Math.cos(angle)*radius);
			     y2 = (float) (y1+Math.sin(angle)*radius);
			     gl.glVertex2f(x2,y2);
			 }

			 gl.glEnd();
		   
	   }
	public static void main(String[] args) {
		GLProfile gp  = GLProfile.get(GLProfile.GL2);
		GLCapabilities cap = new GLCapabilities(gp);
		 GLCanvas gc = new GLCanvas(cap);
		HUTScenary l = new HUTScenary();
		
		gc.addGLEventListener(l);
		gc.setSize(900, 900);
		
		JFrame f = new JFrame("Scenary of a Hut");
		f.add(gc);
		f.setSize(1000, 800);
		f.setVisible(true);

	}

public void display(GLAutoDrawable arg0) {
		
		GL2 gl = arg0.getGL().getGL2();
		
		gl.glClearColor(0.3f, 0.5f, 0.7f, 0.0f);
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		gl.glColor3f(0.0f, 0.1f, 0.0f);
		gl.glBegin(GL2.GL_QUADS);  
	      
	     gl.glVertex3f(-1.0f,-0.199f,0);  
	     gl.glVertex3f(1.0f,-0.199f,0);
	     gl.glVertex3f(1.0f,-1.0f,0);  
	     gl.glVertex3f(-1.0f,-1.0f,0);
	      
	    gl.glEnd(); 
		
		gl.glColor3f(0.5f, 1.0f, 1.0f);
		
		gl.glBegin(GL2.GL_QUADS);  
	      
	    gl.glVertex3f( 0.35f,0.199f,0);  
	    gl.glVertex3f(0.75f,0.199f,0);
	     gl.glVertex3f(0.75f,-0.199f,0);  
	     gl.glVertex3f(0.35f,-0.199f,0);
	      
	    gl.glEnd(); 
	    
	   gl.glColor3f(1.0f, 0.0f, 0.0f);
	    
	    gl.glBegin(GL2.GL_TRIANGLES);  
	    gl.glVertex3f(0.55f, 0.40f, 0.0f);
	    gl.glVertex3f( 0.35f,0.199f,0);  
	    gl.glVertex3f(0.75f,0.199f,0); 
	    gl.glEnd();
	    
	    gl.glColor3f(0.6f, 0.3f, 0.0f);
	    
	    gl.glBegin(GL2.GL_QUADS);  
	      
	    gl.glVertex3f(0.55f, 0.40f, 0.0f);
	    gl.glVertex3f(0.75f,0.40f,0); 
	    gl.glVertex3f( 0.95f,0.199f,0); 
	    gl.glVertex3f(0.75f,0.199f,0); 
	      
	    gl.glEnd(); 
	    
	    gl.glColor3f(1.0f, 1.0f, 0.0f);
	    
	    gl.glBegin(GL2.GL_QUADS);  
	      
	     gl.glVertex3f( 0.95f,0.199f,0); 
	     gl.glVertex3f( 0.95f,-0.199f,0); 
	     gl.glVertex3f(0.75f,-0.199f,0);  
	     gl.glVertex3f(0.75f,0.199f,0);
	    gl.glEnd(); 
	    
	    gl.glColor3f(0.3f, 0.3f, 0.1f);

	    gl.glBegin(GL2.GL_QUADS);  
	      
	     gl.glVertex3f( 0.45f,-0.199f,0); 
	     gl.glVertex3f( 0.45f, 0.0f,0); 
	     gl.glVertex3f(0.65f,0.0f,0);  
	     gl.glVertex3f(0.65f,-0.199f,0);
	    gl.glEnd(); 
	    
	   curve(arg0, 360, 0.05f, 0.54f, 0.27f, 1.0f,1.0f,1.0f, 0.1f);
	   
	   gl.glColor3f(0.5f, 0.3f, 0.3f);
	   gl.glBegin(GL2.GL_QUADS);  
	      
	     gl.glVertex3f( 0.75f,-0.15f,0); 
	     gl.glVertex3f( 0.83f, -0.15f,0); 
	     gl.glVertex3f(0.83f,0.13f,0);  
	     gl.glVertex3f(0.75f,0.13f,0);
	    gl.glEnd(); 
	    
	    gl.glColor3f(0.8f, 0.9f, 0.2f);
	    
	    gl.glBegin(GL2.GL_LINES);
	    
	      gl.glVertex3f( 0.75f,-0.10f,0); 
	     gl.glVertex3f( 0.83f, -0.10f,0);
	     
	     gl.glVertex3f( 0.75f,-0.05f,0); 
	     gl.glVertex3f( 0.83f, -0.05f,0);
	     
	     gl.glVertex3f( 0.75f,-0.0f,0); 
	     gl.glVertex3f( 0.83f, -0.0f,0);
	     
	     gl.glVertex3f( 0.75f,0.06f,0); 
	     gl.glVertex3f( 0.83f, 0.06f,0);
	     
	     gl.glVertex3f( 0.75f,0.12f,0); 
	     gl.glVertex3f( 0.83f, 0.12f,0); 
	     
	     gl.glVertex3f( 0.77f,-0.15f,0); 
	     gl.glVertex3f(0.77f,0.13f,0);  
	     
	     gl.glVertex3f( 0.79f,-0.15f,0); 
	     gl.glVertex3f(0.79f,0.13f,0);
	     
	     gl.glVertex3f( 0.81f,-0.15f,0); 
	     gl.glVertex3f(0.81f,0.13f,0);  
	     
	    gl.glEnd();
	
	    curve(arg0, 360, 0.08f, 0.55f, 0.7f, 1.0f,1.0f,1.0f ,0.1f);
	    curve(arg0, 360, 0.085f, 0.59f, 0.6f, 1.0f,1.0f,1.0f ,0.1f);
	    curve(arg0, 360, 0.08f, 0.6f, 0.8f, 1.0f,1.0f,1.0f ,0.1f);
	    curve(arg0, 360, 0.08f, 0.65f, 0.73f, 1.0f,1.0f,1.0f ,0.1f);
	    curve(arg0, 360, 0.08f, 0.67f, 0.63f, 1.0f,1.0f,1.0f ,0.1f);
	    
	   
	    curve(arg0, 360, 0.07f, 0.83f, 0.63f, 1.0f,1.0f,1.0f ,0.1f);
	    curve(arg0, 360, 0.07f, 0.86f, 0.69f, 1.0f,1.0f,1.0f ,0.1f);
	    curve(arg0, 360, 0.07f, 0.90f, 0.61f, 1.0f,1.0f,1.0f ,0.1f);
	   
		
	    gl.glColor3f(0.6f, 0.3f, 0.0f);
	    gl.glBegin(GL2.GL_QUADS);  
	      
	     gl.glVertex3f( 0.25f,-0.199f,0); 
	     gl.glVertex3f(0.20f,-0.199f,0);  
	     gl.glVertex3f(0.20f,0.0f,0);
	     gl.glVertex3f(0.25f,0.0f,0);  
	    gl.glEnd(); 
	    
	    curve(arg0, 360, 0.07f, 0.26f, 0.065f,0.0f,1.0f,0.0f ,0.1f);
	    curve(arg0, 360, 0.07f, 0.18f, 0.065f,0.0f,1.0f,0.0f ,0.1f);
	    curve(arg0, 360, 0.05f, 0.26f, 0.16f, 0.0f,1.0f,0.0f ,0.1f);
	    curve(arg0, 360, 0.05f, 0.18f, 0.16f, 0.0f,1.0f,0.0f ,0.1f);
	    curve(arg0, 360, 0.05f, 0.228f, 0.23f, 0.0f,1.0f,0.0f ,0.1f);
	    

	    gl.glColor3f(0.6f, 0.3f, 0.0f);
	    gl.glBegin(GL2.GL_QUADS);  
	      
	     gl.glVertex3f( 0.02f,-0.199f,0); 
	     gl.glVertex3f(-0.03f,-0.199f,0);  
	     gl.glVertex3f(-0.03f,0.0f,0);
	     gl.glVertex3f(0.02f,0.0f,0);  
	    gl.glEnd(); 
	    
	    curve(arg0, 360, 0.07f, 0.025f, 0.065f, 0.0f,1.0f,0.0f ,0.1f);
	    curve(arg0, 360, 0.07f, -0.035f, 0.065f, 0.0f,1.0f,0.0f,0.1f);
	    curve(arg0, 360, 0.05f, 0.0156f, 0.16f, 0.0f,1.0f,0.0f,0.1f);
	    curve(arg0, 360, 0.05f, -0.0256f, 0.16f, 0.0f,1.0f,0.0f,0.1f);
	    curve(arg0, 360, 0.05f, 0.0f, 0.23f, 0.0f,1.0f,0.0f,0.1f);
	    
	   
	    curve(arg0, 360, 0.12f, -0.6f, 0.8f, 0.9f,0.0f,0.0f,0.1f);
	    
	       gl. glColor3f( 1.0f, 0.0f,0.0f  );
	       gl.glRasterPos2f(0.3f,-0.8f);
	       GLUT glut = new GLUT();
	       glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, "Harsh Shukla- 500068287");
	    
	       birds(arg0, -0.6f, 0.6f,10.0f, 70.0f);
	       birds(arg0, -0.4f, 0.6f,120.0f, 170.0f);
	       
	       birds(arg0, -0.45f, 0.6f,10.0f, 70.0f);
	       birds(arg0, -0.25f, 0.6f,120.0f, 170.0f);
	       
	       birds(arg0, -0.55f, 0.75f,10.0f, 70.0f);
	       birds(arg0, -0.35f, 0.75f,120.0f, 170.0f);

	       gl.glBegin(GL2.GL_QUADS);
	       gl. glColor3f( 0.6f, 0.3f,0.0f  );
	       gl.glVertex3f( 0.45f,-0.199f,0); 
	       gl.glVertex3f(- 0.80f,-0.99f,0); 
	       gl.glVertex3f(-0.35f,-0.99f,0);
	      
	       gl.glVertex3f(0.65f,-0.199f,0);
	       
	       gl.glEnd();
	       
	   
	}
	
	static void birds(GLAutoDrawable arg0, float x, float y, float iAngle, float fAngle)
	{
		GL2 gl = arg0.getGL().getGL2();
		 float x1,y1,x2,y2;
		 float angle;
		 double radius=0.1;

		 x1 = x;
		 y1= y;
		 gl.glColor3f(0.1f, 0.1f, 0.1f);

		 for (angle=iAngle;angle<fAngle;angle += 0.1)
		 {
			 gl.glBegin(GL2.GL_POINTS);
			double angle1 = Math.toRadians(angle); 
		     y2 = (float) (y1+Math.sin(angle1)*radius);
		     x2 = (float) (x1+Math.cos(angle1)*radius);
		     gl.glVertex2f(x2,y2);
		     gl.glEnd();
		 }
	}
	
	public void dispose(GLAutoDrawable arg0) {
		
	}
	
	public void init(GLAutoDrawable arg0) {

	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		
	}
}