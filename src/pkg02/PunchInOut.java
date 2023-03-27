package pkg02;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PunchInOut extends JFrame implements ActionListener{
	
	public Database db;
	
	private JTextField idField, nameField, puchInField, puchOutField;
	
	
	public PunchInOut(Database db) {
		this.db = db;
		
		// 텍스트 필드와 레이블 설정
		idField = new JTextField(10);
		nameField = new JTextField(10);
		
		JLabel idJLabel = new JLabel("사원 ID :");
		JLabel namJLabel = new JLabel("사원 이름 :");
		
		// 출근 버튼 생성
		JButton addButton = new JButton("출근");
		JButton addButton2 = new JButton("퇴근");
		
		addButton.addActionListener(this);
		addButton2.addActionListener(this);
		
		// 메인 패널 생성
		JPanel mainPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		mainPanel.setLayout(new BorderLayout());
		
		
		buttonPanel.setLayout(new GridLayout(1, 2));
		inputPanel.setLayout(new GridLayout(2,2));
		inputPanel.add(idJLabel);
		inputPanel.add(idField);
		
		inputPanel.add(namJLabel);
		inputPanel.add(nameField);
		
		buttonPanel.add(addButton);
		buttonPanel.add(addButton2);
		
		mainPanel.add(inputPanel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		// 프레임 설정
		setTitle("출퇴근 등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	public static void main(String[] args) {
		new PunchInOut(new Database());
	}

}
