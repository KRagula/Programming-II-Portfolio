import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
public class KRTankerCalc {
  private JFrame mainFrame;
  private JLabel headerLabel;
  private JLabel statusLabel;
  private JPanel controlPanel;
  private float ozLiquidPerDay;
  private float expectLifetime;
  private JLabel resultLabelLine1;
  public KRTankerCalc(){
    prepareGui();
  }
  public static void main(String[] args){
    KRTankerCalc swingTankerCalc = new KRTankerCalc();
    swingTankerCalc.showTextField();
  }
  private void prepareGui(){
    
    mainFrame = new JFrame("Tanker Truck Calculator");
    mainFrame.setSize(500,400);
    mainFrame.setLayout(new GridLayout(3,1));
    
    headerLabel = new JLabel("", JLabel.CENTER);
    statusLabel = new JLabel("", JLabel.CENTER);
    statusLabel.setSize(10,20);
    resultLabelLine1 = new JLabel("", JLabel.CENTER);
    resultLabelLine1.setSize(10,20);
    
    controlPanel = new JPanel();
    controlPanel.setLayout(new FlowLayout());
    
    mainFrame.add(headerLabel);
    mainFrame.add(controlPanel);
    mainFrame.add(statusLabel);
    mainFrame.add(resultLabelLine1);
    mainFrame.setVisible(true);
    
  }
  private void showTextField(){
    headerLabel.setText("Calculate How Many Trucks You Will Consume in Your Life:");
    
    //Instantiate the Controls
    JLabel firstName = new JLabel("First Name: ", JLabel.LEFT);
    JLabel ageLabel = new JLabel("Expected Lifetime (years): ", JLabel.RIGHT);
    JLabel ouncesLabel = new JLabel("Ounces drunk per day: ", JLabel.CENTER);
    final JTextField fName = new JTextField(7);
    final JTextField ageText = new JTextField(3);
    final JTextField ouncesText = new JTextField(3);
    
    JButton calcButton = new JButton("Calculate");
    
    //Action Listener for Button Click
    calcButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String data = "Name: " + fName.getText();
        data += ", Age: " + ageText.getText();
        data += ", Ounces: "
          + new String(ouncesText.getText());
        statusLabel.setText(data);
        ozLiquidPerDay = Float.valueOf(ouncesText.getText());
        expectLifetime = Float.valueOf(ageText.getText());
        resultLabelLine1.setText(fName.getText() + " will drink " + Float.toString(ozLiquidPerDay*365/128*expectLifetime/11000)+" 11,000 gallon trucks of liquid in his/her lifetime.");
      }
    });
    
    //Place Controls on Panels
    controlPanel.add(firstName);
    controlPanel.add(fName);
    controlPanel.add(ageLabel);
    controlPanel.add(ageText);
    controlPanel.add(ouncesLabel);
    controlPanel.add(ouncesText);
    controlPanel.add(calcButton);
    controlPanel.add(resultLabelLine1);
    mainFrame.setVisible(true);
  }
}
