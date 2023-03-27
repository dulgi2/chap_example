package pkg02;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class TimeSheetForm extends JFrame implements ActionListener{
	
	public Database db;

	
	//  출퇴근 시트가 보여질 테이블
	private JTable table;
	
	// 테이블의 다양한 기능을 사용
	private DefaultTableModel tableModel;
	
	public TimeSheetForm() {
	}
	
	public TimeSheetForm(Database db) {
		this.db = db;
		
		// 테이블 셋팅
		String[] columnNames = {"사원ID", "사원 이름", "출근시간", "퇴근시간"};
		List<Staff> timesList = db.getStaffList();
		Object[][] date = new Object[timesList.size()][4];
		
		for(int i = 0; i < timesList.size(); i++) {
			Staff staff = timesList.get(i);
			date[i][0] = staff.getId();
			date[i][1] = staff.getName();
			date[i][2] = staff.getPunchIn();
			date[i][3] = staff.getPunchOut();
		}
			
			tableModel = new DefaultTableModel(date,columnNames);
			table = new JTable(tableModel);
			
			JButton closeButton = new JButton("닫기");
			
			// 액션 리스너 부착
			closeButton.addActionListener(this);	// 액션 리스너
			
			// 메인 패널 생성
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new BorderLayout());
			mainPanel.add(new JScrollPane(table),BorderLayout.CENTER);
			
			// 입력 필드들이 놓일 input 패널
			JPanel inputPanel = new JPanel();
			inputPanel.setLayout(new GridLayout(4,2));
			
			// input 패널을 메인 패넣에 다시 부착
			mainPanel.add(inputPanel, BorderLayout.SOUTH);
			// 닫기 버튼 부착
			mainPanel.add(closeButton, BorderLayout.SOUTH);
			
			// 프레임 설정
			setTitle("근태 등록 현황");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setContentPane(mainPanel);
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
			
		}

	// 액션 리스너
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();

		MainMenu mainMenu = new MainMenu(db);
		mainMenu.setVisible(true);

	}

	public static void main(String[] args) {
		new TimeSheetForm(new Database());
	}

	
}
