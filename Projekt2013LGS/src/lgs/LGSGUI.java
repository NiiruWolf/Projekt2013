package lgs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class LGSGUI {

	private JFrame frame;
	private JPanel background;
	private JPanel oben;
	private JPanel unten;
	private JPanel mitte;
	JPanel gitter;
	private JLabel zeilenLabel;
	private JLabel spaltenLabel;
	
	private BorderLayout bordLay;
	private FlowLayout flowLay;
	
	JButton go = new JButton("Okay, GO!");
	
	ArrayList<JPanel> panelList;
	
	
	
	public void guiErstellen(){
		frame = new JFrame("LGS Solver - by Neil Onasch & Eric Sowka");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bordLay = new BorderLayout();
		flowLay = new FlowLayout();
		background = new JPanel(bordLay);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		unten = new JPanel(flowLay);
		oben = new JPanel(flowLay);
		mitte = new JPanel(flowLay);
		gitter = new JPanel(flowLay);
		zeilenLabel = new JLabel("Zeilen");
		spaltenLabel = new JLabel("Spalten");
		
		oben.add(zeilenLabel);
		oben.add(spaltenLabel);
		
		//mitte.setLayout(new BoxLayout(mitte, BoxLayout.Y_AXIS));
		
		//Debug
		unten.add(new JLabel("Test1"));
		unten.add(new JLabel("Test2"));
		unten.add(new JLabel("Test3"));
		unten.add(new JLabel("Test4"));
		mitte.add(new JLabel("Test1"));
		mitte.add(new JLabel("Test2"));
		mitte.add(new JLabel("Test3"));
		mitte.add(new JLabel("Test4"));
		unten.add(go);
		go.addActionListener(new GoButtonListener());
		
		
		background.add(BorderLayout.NORTH, oben);
		background.add(BorderLayout.SOUTH, unten);
		background.add(BorderLayout.CENTER, mitte);
		
		frame.add(background);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		panelList = new ArrayList<JPanel>();
	}
	
	public void matrixUpdate(int spaltenAnzahl, int zeilenAnzahl){
		
		panelList.removeAll(panelList);
		mitte.removeAll();
		gitter.removeAll();
		for (int i = 0; i<spaltenAnzahl; i++){
			JPanel spalte = new JPanel();
			spalte.setLayout(new BoxLayout(spalte, BoxLayout.Y_AXIS));
			for(int j=0; j<zeilenAnzahl; j++){
				spalte.add(new JTextField(3));
			}
			gitter.add(spalte);
			panelList.add(spalte);
		}
		
		//JTextField a = new J
		mitte.add(gitter);
		mitte.updateUI();
		
		
	}
	
	public class GoButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Random rand = new Random();
			matrixUpdate(rand.nextInt(6), rand.nextInt(6));
			
		}
		
	}

}

