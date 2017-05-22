import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D.*;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.BasicStroke;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.util.Random;

/**Class that visualizes the growth of a roach population over a timeframe of 10 generations
 * 
 * @author Kanishka Ragula
 *
 */
public class RoachSimulation {
	
	/**Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//Instantiate the Roach Population, JFrame, and number of roaches as well as set up
			//JFrame
			RoachPopulation roaches = new RoachPopulation(10);
			JFrame frame = new JFrame();
			int numRoaches = 0;
			frame.setSize(500, 400);
			frame.setTitle("Roaches");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			myComponent comp = new myComponent();
			
			/*	Iterate the generations
			 * Each generation involves a breeding period and a dying period where an exterminator
			 * kills a portion of the population
			 * 
			 */
			for (int i = 0; i < 10; i++) {
				//Repaint the frame based on what happened in the previous generation
				frame.repaint();
				
				//Breed
				roaches.breed();
				numRoaches = roaches.getRoaches();
				comp.setRoaches(numRoaches);
				frame.add(comp);
				frame.setVisible(true);
				//Set the frame to update the breeding period and then sleep
				Thread.sleep(500);
				
				//Kill 'em
				roaches.spray(10);
				numRoaches = roaches.getRoaches();
				comp.setRoaches(numRoaches);
				frame.add(comp);
				frame.repaint();
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			//Catch an exception if the Thread.sleep() line causes an error
			System.out.println("got interrupted!");
		}
	}
	
	/** Class to hold the component displayed
	 * 
	 * @author 9634090
	 *
	 */
	public static class myComponent extends JComponent {
		
		//Count of the roaches
		private int countRoaches;
		
		/**Set the roaches to a certain value
		 * 
		 * @param numberToPrint Value to set roaches to
		 */
		public void setRoaches(int numberToPrint) {
			countRoaches = numberToPrint;
			System.out.println(countRoaches);
		}
		
		/**Paint the values to random locations on the JFrame
		 * 
		 */
		public void paintComponent(Graphics g) {
			
			//Creates an array of points to store the roaches as well as instantiates the component
			//and color of roaches
			Point[] roachesArray = new Point[countRoaches];
			Graphics2D g2 = (Graphics2D) g;
			Random rand = new Random();
			Color roachBrown = new Color(156, 93, 82);
			g2.setStroke(new BasicStroke(5));
			g2.setColor(roachBrown);
			
			//Displays each of the roaches in the array randomly
			for (int i = 0; i < countRoaches; i++) {
				int w = 500;
				int h = 400;

				int x = Math.abs(rand.nextInt()) % w;
				int y = Math.abs(rand.nextInt()) % h;
				g2.drawLine(x, y, x, y);
			}
		}
	}
}