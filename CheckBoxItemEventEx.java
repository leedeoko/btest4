import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxItemEventEx extends JFrame{
	private JCheckBox[] friuts = new JCheckBox[3];
	private String[]names = {"apple","pear","cherry"};

	private JLabel sumLabel;

	public CheckBoxItemEventEx(){
		setTitle("checkbox,event");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("apple 100won,pear 500won,cherry 2000 won"));

		MyItemListener listener = new MyItemListener();
		for(int i=0;i<friuts.length;i++){
			friuts[i] = new JCheckBox(names[i]);
			friuts[i].setBorderPainted(true);
			c.add(friuts[i]);
			friuts[i].addItemListener(listener);
		}
		sumLabel = new JLabel("now 0 won");
		c.add(sumLabel);

		setSize(250,200);
		setVisible(true);
	}

	class MyItemListener implements ItemListener{
		private int sum = 0;
		public void itemStateChanged(ItemEvent e){
			if(e.getStateChange() == ItemEvent.SELECTED){
				if(e.getItem() == friuts[0])
					sum+=100;
				else if(e.getItem() == friuts[1])
					sum+=500;
				else
					sum+=2000;
			}
				else{
					if(e.getItem() == friuts[0])
						sum-=100;
					else if(e.getItem() == friuts[1])
						sum-=500;
					else
						sum-=2000;
				}
				sumLabel.setText("now"+sum+"won");
		}
	}
	public static void main(String[] args){
		new CheckBoxItemEventEx();
	}
}


