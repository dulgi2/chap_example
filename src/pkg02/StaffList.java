package pkg02;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StaffList extends JFrame implements ActionListener{
	
	public Database db;
	
	private JTable table;
	private DefaultTableModel tableModel;
	
	public StaffList() {
}
	
	public StaffList(Database db) {
		this.db = db;
		
		String[] columnNames = {"사원ID", "사원 이름", "주민등록번호", "주소","입사일"};
		List<Staff> staffList = db.getStaffList();
		Object[][] staffdate = new Object[staffList.size()][5];
		
		for(int i = 0; i < staffList.size(); i++) {
			Staff staff = staffList.get(i);
			staffdate[i][0] = staff.getId();
			staffdate[i][1] = staff.getName();
			staffdate[i][2] = staff.getJumin();
			staffdate[i][3] = staff.getAddress();
			staffdate[i][4] = staff.getHiredate();
		}
		
		tableModel = new DefaultTableModel(staffdate, columnNames);
		table = new JTable(tableModel);
		
		JButton closeButton = new JButton("닫기");
		// 액션 리스너 부착
		closeButton.addActionListener(this);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(5,2));
		
		// input 패널을 메인 패널 부착
		mainPanel.add(inputPanel, BorderLayout.SOUTH);
		// 닫기 버튼도 메인 패널 부착
		mainPanel.add(closeButton, BorderLayout.SOUTH);
		
		// 프레임 설정
		setTitle("사원 정보 리스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// 
		this.dispose();
	
		MainMenu mainMenu = new MainMenu(db);
		mainMenu.setVisible(true);
		
	}
	public static void main(String[] args) {
		new StaffList(new Database());
	}
	
	
}
