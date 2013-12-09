/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */
package ee402;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class JProgressBarExample extends JFrame
{	
	JProgressBar progressBar;
	JLabel	progressLabel;

	public JProgressBarExample() {
		super("JProgressBar Example");

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setBorder(new TitledBorder("Current Progress:"));

		progressBar = new JProgressBar(JProgressBar.HORIZONTAL,0,100);
		progressLabel = new JLabel(" 0%");
		p.add(progressBar);
		p.add(progressLabel);
		
		this.getContentPane().add(p);

		this.pack();	 
		this.setVisible(true);

		this.updateProgress(50);
	}

	private boolean updateProgress(int updateAmount)
	{
		int current = progressBar.getValue();
		int updateTo = current + updateAmount;
		if (updateTo < 100 && updateTo > 0) {
			progressBar.setValue(updateTo);
			progressLabel.setText(" " + updateTo + "%");
		}
		else return false;
		return true;
	}
	
	public static void main(String[] args) {
		new JProgressBarExample();
	}
}
