/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */
package ee402;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class JSliderExample extends JFrame
{	
	JLabel l1 = new JLabel("This is a Test Swing Application");
	JButton b1, b2;
	
	@SuppressWarnings("unchecked")
	public JSliderExample()	{
		super("JSlider Example");

		JPanel hp = new JPanel();
		hp.setLayout(new BoxLayout(hp, BoxLayout.Y_AXIS));
		this.getContentPane().add(hp);

		// Slider 1
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(new TitledBorder("Plain"));
		JSlider s = new JSlider(-10, 100, 20);
		s.getAccessibleContext().setAccessibleName("Plain");
		s.getAccessibleContext().setAccessibleDescription("A plain slider");
		//s.addChangeListener(listener);
		p.add(s);
		hp.add(p);

		// Slider 2
		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(new TitledBorder("Major Ticks"));
		s = new JSlider(100, 1000, 400);
		s.setPaintTicks(true);
		s.setMajorTickSpacing(100);
		s.getAccessibleContext().setAccessibleName("Major Ticks");
		s.getAccessibleContext().setAccessibleDescription("A slider showing major tick marks");
		//s.addChangeListener(this);
		p.add(s);
		hp.add(p);

		// Slider 3
		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(new TitledBorder("Minor Ticks, Snap-to-ticks and Labels"));
		s = new JSlider(0, 11, 6);
		s.putClientProperty( "JSlider.isFilled", Boolean.TRUE );
		s.setPaintTicks(true);
		s.setMajorTickSpacing(5);
		s.setMinorTickSpacing(1);
		s.setPaintLabels(true);
		s.setSnapToTicks(true);
		s.getLabelTable().put( new Integer( 11 ), new JLabel( "11", JLabel.CENTER ) );
		s.setLabelTable( s.getLabelTable() );
		s.getAccessibleContext().setAccessibleName("Minor Ticks");
		s.getAccessibleContext().setAccessibleDescription("A slider showing major and minor tick marks, with slider action snapping to tick marks, with some ticks visibly labeled");
		p.add(s);
		hp.add(p);
	
		this.pack();	// set the size automatically
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JSliderExample();
	}
}
