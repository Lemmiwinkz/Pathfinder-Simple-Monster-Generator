package gen;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.TextArea;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class hauptanwendung extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private TextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hauptanwendung frame = new hauptanwendung();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public hauptanwendung() {
		setTitle("PF1.0 Simple Monster Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 831);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 461, 776);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPaneAaG = new JScrollPane();
		tabbedPane.addTab("Array and Graft", null, scrollPaneAaG, "In this Tab you can set the basic arrays and grafts for your Monster, as well as it's Type and CR");
		tabbedPane.setEnabledAt(0, true);
		
		JScrollPane scrollPaneMO = new JScrollPane();
		tabbedPane.addTab("Monster Options", null, scrollPaneMO, "Depending on your choices in Array and Grafts your monster will have different Monster Options avaiable");
		tabbedPane.setEnabledAt(1, false);
		
		JScrollPane scrollPaneSpl = new JScrollPane();
		tabbedPane.addTab("Spells", null, scrollPaneSpl, "If your monster can cast Spells or Spell-like-Abilities then this is the Tab for you !");
		tabbedPane.setEnabledAt(2, false);
		
		JScrollPane scrollPaneHO = new JScrollPane();
		tabbedPane.addTab("Homebrew Options", null, scrollPaneHO, "Creating a Monster is not easy, if you wish for further tweaking options not covered by the Simple Monster Creation Rules then you will find em here.");
		tabbedPane.setEnabledAt(3, false);
		
		JScrollPane scrollPaneMonster = new JScrollPane();
		scrollPaneMonster.setBounds(476, 5, 416, 776);
		scrollPaneMonster.setToolTipText("Contains the finished Monster");
		contentPane.add(scrollPaneMonster);
		
		JButton btnGenerateBtn = new JButton("Generate");
		btnGenerateBtn.setAction(action);
		scrollPaneMonster.setColumnHeaderView(btnGenerateBtn);
		btnGenerateBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGenerateBtn.setToolTipText("Clicking this will generate the Monster on the RIGHT side according to your specifics entered on the LEFT side");
		
		textArea = new TextArea();
		textArea.setText("Your Monster will spawn here.");
		textArea.setEditable(false);
		scrollPaneMonster.setViewportView(textArea);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public String getTextAreaText() {
		return textArea.getText();
	}
	public void setTextAreaText(String text) {
		textArea.setText(text);
	}
}
