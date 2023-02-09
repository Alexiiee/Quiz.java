import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

		OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  Name the country which has no capital?");	
			radioButton[0].setText("Nepal");
			radioButton[1].setText("Nauru");
			radioButton[2].setText("Belarus");
			radioButton[3].setText("Croatia");
		}
		if (current == 1) {
			label.setText("Que2:  Compared to their body weight, what animal is the strongest?");		//Dung Bettle
			radioButton[0].setText("Ant");
			radioButton[1].setText("Cow");
			radioButton[2].setText("Elephant");
			radioButton[3].setText("Dung Beetle");
		}
		if (current == 2) {
			label.setText("Que3: What is acrophobia a fear of __?");	 
			radioButton[0].setText("Flying");
			radioButton[1].setText("Diving");
			radioButton[2].setText("Heights");
			radioButton[3].setText("None of the above");
		}
		if (current == 3) {
			label.setText("Que4: In what country was Elon Musk born?");		
			radioButton[0].setText("USA");
			radioButton[1].setText("Mexico");
			radioButton[2].setText("South Africa");
			radioButton[3].setText("India");
		}
		if (current == 4) {
			label.setText("Que5:  Where is Gir National Forest located?");		
			radioButton[0].setText("Gujrat");
			radioButton[1].setText("Mmbai");
			radioButton[2].setText("Kerala");
			radioButton[3].setText("None of the Above");
		}
		if (current == 5) {
			label.setText(" Name the Father of the Indian Constitution?");
			radioButton[0].setText("Mahatma Ghandhi");
			radioButton[1].setText("Dr. B. R. Ambedkar");
			radioButton[2].setText("Maulana Azad");
			radioButton[3].setText("All of the above");
		}
		if (current == 6) {
			label.setText("Que7:  which is the top grossing bollywood song of all time?");
			radioButton[0].setText("Dil To Pagal Hai");
			radioButton[1].setText("Raja Hindustani");
			radioButton[2].setText("Hum Aapke Hain Kaun");
			radioButton[3].setText("Dilwale Dulhania Le Jayenge");
		}
		if (current == 7) {
			label.setText("Que8:  What is the Motto for FCRIT?");
			radioButton[0].setText("No Motto");
			radioButton[1].setText("Love Your Neighbour as Yourself");
			radioButton[2].setText("We are here, because of you.");
			radioButton[3].setText("Let Jesus guide you the right way.");
		}
		if (current == 8) {
			label.setText("Que9: Till what time is our college library open?");
			radioButton[0].setText("10 PM");
			radioButton[1].setText("11 PM");
			radioButton[2].setText("12 AM");
			radioButton[3].setText("don't know");
		}
		if (current == 9) {
			label.setText("Young one of a cow is known as ");
			radioButton[0].setText("Pony");
			radioButton[1].setText("Calf");
			radioButton[2].setText("Puppy");
			radioButton[3].setText("Kittens");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[1].isSelected());
		if (current == 6)
			return (radioButton[3].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[1].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}

}