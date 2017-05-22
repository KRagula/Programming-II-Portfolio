import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * This program displays the growth of a roach population.
 */
public class RoachPopulationViewer {
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 200;

	public static void main(String[] args) {
		
		//Instantiate the JFrame
		JFrame frame = new JFrame();
		
		//Timer to time between reproduction
		final int TIMERTIME = 10000;
		
		//Buttons for the JPanel
		final JButton doubleButton = new JButton("Double roach population!");
		final JButton halfButton = new JButton("Halve Roach Population!");
		final JButton incrementButton = new JButton("Increase Roach Population by 1");
		final JButton decrementButton = new JButton("Decrease Roach Population by 1");
		final JButton killAll = new JButton("KILL THEM ALL!");
		
		//Start the list
		final RoachPopulation roachPopulation = new RoachPopulation(2);

		// The label for displaying the results
		final JLabel label = new JLabel("population: " + roachPopulation.getPopulation());
		final JLabel welcome = new JLabel(
				"Welcome to Roach Simulator, the Exterminator comes every 10 seconds and kills 10% of the population");

		// The panel that holds the user interface components
		JPanel panel = new JPanel();
		panel.add(welcome);
		panel.add(doubleButton);
		panel.add(halfButton);
		panel.add(incrementButton);
		panel.add(decrementButton);
		panel.add(killAll);
		panel.add(label);
		frame.add(panel);
		
		//Action Listener for listening for button presses
		class PopulationDoublerListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				JButton button = (JButton) event.getSource();

				if (button == doubleButton) {
					roachPopulation.doublePopulation();
				} else if (button == halfButton) {
					roachPopulation.halfPopulation();
				} else if (button == incrementButton) {
					roachPopulation.incrementPopulation();
				} else if (button == decrementButton) {
					roachPopulation.decrementPopulation();
				} else if (button == killAll) {
					roachPopulation.killAll();
				}
				label.setText("population: " + roachPopulation.getPopulation());
			}
		}

		class TimerListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				roachPopulation.exterminator();
				label.setText("population: " + roachPopulation.getPopulation());

			}

		}

		ActionListener listener = new PopulationDoublerListener();
		TimerListener t = new TimerListener();
		
		//Add Listener to buttons
		Timer time = new Timer(TIMERTIME, t);
		time.start();
		doubleButton.addActionListener(listener);
		halfButton.addActionListener(listener);
		incrementButton.addActionListener(listener);
		decrementButton.addActionListener(listener);
		killAll.addActionListener(listener);
		
		//Final touches to Frame
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
