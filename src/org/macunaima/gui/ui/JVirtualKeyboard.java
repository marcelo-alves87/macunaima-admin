package org.macunaima.gui.ui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class JVirtualKeyboard extends JPanel implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Robot robot;
	private JPanel leftPanel;
	private JToggleButton scrlk;
	private JToggleButton togglebuttons[];
	private JButton leftBtn[];
	private String toggleBtnNames[] = { "                  ", "                       ", "                    ",
			"        ", "        ", "        ", "        ", "   " };

	private String leftNames[] = { "              ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ",
			"   ", "    ", "      ", "    ", " 1", " 2", " 3", " 4", " 5", "6", "7", "8", "9", "0", "", "", " < ",
			"              ", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "   ", "   ", "     ", "    ", "a", "s",
			"d", "f", "g", "h", "j", "k", "l", "  ", "    ", "               ", "z", "x", "c", "v", "b", "n", "m",
			"   ", "   ", "   ", "     ", "       ", "                                           ", "     ", "     ",
			"     " };
	private JTextField jTextField;

	public JVirtualKeyboard(JTextField jTextField) {

		super();
		this.jTextField = jTextField;
		setSize(550, 225);

		setLayout(new BorderLayout());

		setBackground(new Color(247, 213, 103));

		add(bigPanel(), BorderLayout.CENTER);

		convertToUpperCase();

		setVisible(true);

	}

	// adding left buttons in JPanel
	private JPanel bigPanel() {
		leftPanel = new JPanel();
		leftPanel.setBackground(new Color(247, 213, 103));
		togglebuttons = new JToggleButton[toggleBtnNames.length];
		for (int i = 0; i < toggleBtnNames.length; i++) {
			togglebuttons[i] = new JToggleButton(toggleBtnNames[i]);
			togglebuttons[i].setFont(new Font("Dialog", Font.BOLD, 16));
			togglebuttons[i].setBackground(new Color(0, 0, 0, 0));
			togglebuttons[i].setForeground(Color.WHITE);
			togglebuttons[i].setEnabled(false);
			togglebuttons[i].setOpaque(false);
			togglebuttons[i].setBorderPainted(false);

			togglebuttons[i].addItemListener(this);
		}

		leftBtn = new JButton[leftNames.length];
		for (int i = 0; i < leftNames.length; i++) {
			String name = leftNames[i];
			leftBtn[i] = new JButton(leftNames[i]);
			leftBtn[i].setFont(new Font("Dialog", Font.BOLD, 16));
			leftBtn[i].setForeground(Color.BLACK);
			if (name != null && name.trim().equals("")) {
				leftBtn[i].setBackground(new Color(0, 0, 0, 0));
				leftBtn[i].setEnabled(false);
				leftBtn[i].setOpaque(false);
				leftBtn[i].setBorderPainted(false);
			} else {
				leftBtn[i].setBackground(Color.WHITE);
				leftBtn[i].addActionListener(this);
			}
			leftPanel.add(leftBtn[i]);

			switch (i) {
			case 41:
				leftPanel.add(togglebuttons[0]);
				break;

			case 53:
				leftPanel.add(togglebuttons[1]);
				break;

			case 64:
				leftPanel.add(togglebuttons[2]);
				leftPanel.add(togglebuttons[3]);
				break;

			case 65:
				leftPanel.add(togglebuttons[4]);
				break;

			case 66:
				leftPanel.add(togglebuttons[5]);
				leftPanel.add(togglebuttons[6]);
				break;

			case 69:
				leftPanel.add(togglebuttons[7]);
				break;
			}
			leftPanel.setBounds(0, 0, 764, 117);
		}
		return leftPanel;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			robot = new Robot();

			if (e.getSource() == leftBtn[1])
				updateTextField(KeyEvent.VK_F1);

			if (e.getSource() == leftBtn[2])
				updateTextField(KeyEvent.VK_F2);

			if (e.getSource() == leftBtn[3])
				updateTextField(KeyEvent.VK_F3);

			if (e.getSource() == leftBtn[4])
				updateTextField(KeyEvent.VK_F4);

			if (e.getSource() == leftBtn[5])
				updateTextField(KeyEvent.VK_F5);

			if (e.getSource() == leftBtn[6])
				updateTextField(KeyEvent.VK_F6);

			if (e.getSource() == leftBtn[7])
				updateTextField(KeyEvent.VK_F7);

			if (e.getSource() == leftBtn[8])
				updateTextField(KeyEvent.VK_F8);

			if (e.getSource() == leftBtn[9])
				updateTextField(KeyEvent.VK_F9);

			if (e.getSource() == leftBtn[10])
				updateTextField(KeyEvent.VK_F10);

			if (e.getSource() == leftBtn[11])
				updateTextField(KeyEvent.VK_F11);

			if (e.getSource() == leftBtn[12])
				updateTextField(KeyEvent.VK_F12);

			if (e.getSource() == leftBtn[13])
				updateTextField(KeyEvent.VK_BACK_QUOTE);

			if (e.getSource() == leftBtn[14])
				updateTextField(KeyEvent.VK_1);

			if (e.getSource() == leftBtn[15])
				updateTextField(KeyEvent.VK_2);

			if (e.getSource() == leftBtn[16])
				updateTextField(KeyEvent.VK_3);

			if (e.getSource() == leftBtn[17])
				updateTextField(KeyEvent.VK_4);

			if (e.getSource() == leftBtn[18])
				updateTextField(KeyEvent.VK_5);

			if (e.getSource() == leftBtn[19])
				updateTextField(KeyEvent.VK_6);

			if (e.getSource() == leftBtn[20])
				updateTextField(KeyEvent.VK_7);

			if (e.getSource() == leftBtn[21])
				updateTextField(KeyEvent.VK_8);

			if (e.getSource() == leftBtn[22])
				updateTextField(KeyEvent.VK_9);

			if (e.getSource() == leftBtn[23])
				updateTextField(KeyEvent.VK_0);

			if (e.getSource() == leftBtn[24])
				updateTextField(KeyEvent.VK_MINUS);

			if (e.getSource() == leftBtn[25])
				updateTextField(KeyEvent.VK_EQUALS);

			if (e.getSource() == leftBtn[26])
				updateTextFieldBackSpace();

			if (e.getSource() == leftBtn[27])
				updateTextField(KeyEvent.VK_TAB);

			if (e.getSource() == leftBtn[28])
				updateTextField(KeyEvent.VK_Q);

			if (e.getSource() == leftBtn[29])
				updateTextField(KeyEvent.VK_W);

			if (e.getSource() == leftBtn[30])
				updateTextField(KeyEvent.VK_E);

			if (e.getSource() == leftBtn[31])
				updateTextField(KeyEvent.VK_R);

			if (e.getSource() == leftBtn[32])
				updateTextField(KeyEvent.VK_T);

			if (e.getSource() == leftBtn[33])
				updateTextField(KeyEvent.VK_Y);

			if (e.getSource() == leftBtn[34])
				updateTextField(KeyEvent.VK_U);

			if (e.getSource() == leftBtn[35])
				updateTextField(KeyEvent.VK_I);

			if (e.getSource() == leftBtn[36])
				updateTextField(KeyEvent.VK_O);

			if (e.getSource() == leftBtn[37])
				updateTextField(KeyEvent.VK_P);

			if (e.getSource() == leftBtn[38])
				updateTextField(KeyEvent.VK_OPEN_BRACKET);

			if (e.getSource() == leftBtn[39])
				updateTextField(KeyEvent.VK_CLOSE_BRACKET);

			if (e.getSource() == leftBtn[40])
				updateTextField(KeyEvent.VK_BACK_SLASH);

			if (e.getSource() == leftBtn[41])
				updateTextField(KeyEvent.VK_DELETE);

			if (e.getSource() == leftBtn[42])
				updateTextField(KeyEvent.VK_A);

			if (e.getSource() == leftBtn[43])
				updateTextField(KeyEvent.VK_S);

			if (e.getSource() == leftBtn[44])
				updateTextField(KeyEvent.VK_D);

			if (e.getSource() == leftBtn[45])
				updateTextField(KeyEvent.VK_F);

			if (e.getSource() == leftBtn[46])
				updateTextField(KeyEvent.VK_G);

			if (e.getSource() == leftBtn[47])
				updateTextField(KeyEvent.VK_H);

			if (e.getSource() == leftBtn[48])
				updateTextField(KeyEvent.VK_J);

			if (e.getSource() == leftBtn[49])
				updateTextField(KeyEvent.VK_K);

			if (e.getSource() == leftBtn[50])
				updateTextField(KeyEvent.VK_L);

			if (e.getSource() == leftBtn[51])
				updateTextField(KeyEvent.VK_SEMICOLON);

			if (e.getSource() == leftBtn[52])
				updateTextField(KeyEvent.VK_QUOTE);

			if (e.getSource() == leftBtn[53])
				updateTextField(KeyEvent.VK_ENTER);

			if (e.getSource() == leftBtn[54])
				updateTextField(KeyEvent.VK_Z);

			if (e.getSource() == leftBtn[55])
				updateTextField(KeyEvent.VK_X);

			if (e.getSource() == leftBtn[56])
				updateTextField(KeyEvent.VK_C);

			if (e.getSource() == leftBtn[57])
				updateTextField(KeyEvent.VK_V);

			if (e.getSource() == leftBtn[58])
				updateTextField(KeyEvent.VK_B);

			if (e.getSource() == leftBtn[59])
				updateTextField(KeyEvent.VK_N);

			if (e.getSource() == leftBtn[60])
				updateTextField(KeyEvent.VK_M);

			if (e.getSource() == leftBtn[61])
				updateTextField(KeyEvent.VK_COMMA);

			if (e.getSource() == leftBtn[62])
				updateTextField(KeyEvent.VK_PERIOD);

			if (e.getSource() == leftBtn[63])
				updateTextField(KeyEvent.VK_SLASH);

			if (e.getSource() == leftBtn[64])
				updateTextField(KeyEvent.VK_UP);

			if (e.getSource() == leftBtn[65]) {
				updateTextField(KeyEvent.VK_WINDOWS);
				robot.keyRelease(KeyEvent.VK_WINDOWS);
			}

			if (e.getSource() == leftBtn[66])
				updateTextField(KeyEvent.VK_SPACE);

			if (e.getSource() == leftBtn[67])
				updateTextField(KeyEvent.VK_LEFT);

			if (e.getSource() == leftBtn[68])
				updateTextField(KeyEvent.VK_DOWN);

			if (e.getSource() == leftBtn[69])
				updateTextField(KeyEvent.VK_RIGHT);

		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	}

	private void updateTextFieldBackSpace() {
		if (jTextField.getText().length() > 0) {
			jTextField.setText(jTextField.getText().substring(0, jTextField.getText().length() - 1));
		}

	}

	private void updateTextField(int vkEscape) {
		jTextField.setText(jTextField.getText() + ((char) vkEscape));
	}

	public void itemStateChanged(ItemEvent ev) {
		try {
			robot = new Robot();

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == togglebuttons[0]) {
				convertToUpperCase();
				togglebuttons[0].setForeground(Color.BLACK);
				Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
			} else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == togglebuttons[0]) {
				convertToLowerCase();
				togglebuttons[0].setForeground(Color.WHITE);
				Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
			}
			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == togglebuttons[1]) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				togglebuttons[1].setForeground(Color.BLACK);
			} else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == togglebuttons[1]) {
				robot.keyRelease(KeyEvent.VK_SHIFT);
				togglebuttons[1].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == togglebuttons[2]) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				togglebuttons[2].setForeground(Color.BLACK);
			}

			else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == togglebuttons[2]) {
				robot.keyRelease(KeyEvent.VK_SHIFT);
				togglebuttons[2].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == togglebuttons[3]) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				togglebuttons[3].setForeground(Color.BLACK);
			}

			else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == togglebuttons[3]) {
				robot.keyRelease(KeyEvent.VK_CONTROL);
				togglebuttons[3].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == togglebuttons[4]) {
				robot.keyPress(KeyEvent.VK_ALT);
				togglebuttons[4].setForeground(Color.BLACK);
			} else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == togglebuttons[4]) {
				robot.keyRelease(KeyEvent.VK_ALT);
				togglebuttons[4].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == togglebuttons[5]) {
				robot.keyPress(KeyEvent.VK_ALT);
				togglebuttons[5].setForeground(Color.BLACK);
			} else if ((ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == togglebuttons[5])) {
				robot.keyRelease(KeyEvent.VK_ALT);
				togglebuttons[5].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == togglebuttons[6]) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				togglebuttons[6].setForeground(Color.BLACK);
			}

			else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == togglebuttons[6]) {
				robot.keyRelease(KeyEvent.VK_CONTROL);
				togglebuttons[6].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == scrlk) {
				Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_SCROLL_LOCK, true);
				scrlk.setForeground(Color.BLACK);
			} else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == scrlk) {
				Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_SCROLL_LOCK, false);
				scrlk.setForeground(Color.WHITE);
			}

		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	}

	// Convert lower case to upper case method
	public void convertToUpperCase() {
		for (int i = 28; i < leftNames.length - 32; i++) {
			leftBtn[i].setText(leftNames[i].toUpperCase());
			leftBtn[27].setText("         ");
		}

		for (int i = 42; i < leftNames.length - 19; i++) {
			leftBtn[i].setText(leftNames[i].toUpperCase());
			togglebuttons[0].setText("             ");
		}

		for (int i = 54; i < leftNames.length - 9; i++) {
			leftBtn[i].setText(leftNames[i].toUpperCase());
			togglebuttons[1].setText("                     ");
		}
	}

	// Convert upper case to lower case method
	public void convertToLowerCase() {
		for (int i = 28; i < leftNames.length - 32; i++) {
			leftBtn[i].setText(leftNames[i].toLowerCase());
			leftBtn[27].setText("Tab           ");
		}

		for (int i = 42; i < leftNames.length - 19; i++) {
			leftBtn[i].setText(leftNames[i].toLowerCase());
			togglebuttons[0].setText("Caps              ");
		}

		for (int i = 54; i < leftNames.length - 9; i++) {
			leftBtn[i].setText(leftNames[i].toLowerCase());
			togglebuttons[1].setText("Shift                  ");
		}
	}

}