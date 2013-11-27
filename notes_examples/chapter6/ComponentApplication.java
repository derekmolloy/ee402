package ee402;

import java.awt.*;

@SuppressWarnings("serial")
public class ComponentApplication extends Frame {

	public ComponentApplication() {
		super("EE402 Component Application");
		this.setLayout(new FlowLayout());
		
		Button b = new Button("Test Button");
		this.add(b);
		 
		Checkbox cb = new Checkbox("Test Checkbox");
		this.add(cb);
		 
		CheckboxGroup cbg = new CheckboxGroup();
		this.add(new Checkbox("CB Item 1", cbg, false));
		this.add(new Checkbox("CB Item 2", cbg, false));
		this.add(new Checkbox("CB Item 3", cbg, true));
		 	
		Choice choice = new Choice();
		choice.addItem("Choice Item 1");
		choice.addItem("Choice Item 2");
		choice.addItem("Choice Item 3");
		this.add(choice);
		
		Label l = new Label("Test Label");
		this.add(l);
		
		TextField t = new TextField("Test TextField",30);
		this.add(t);
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ComponentApplication();
	}
}
