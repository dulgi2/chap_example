package pkg03;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;




public class TimeSheetForm extends JFrame implements ActionListener{
	
	public Database db;

	
	//  출퇴근 시트가 보여질 테이블
	private JTable table;
	
	// 테이블의 다양한 기능을 사용
	private DefaultTableModel tableModel;
	
	
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
			
			DefaultTableCellRenderer cellRendererCenter = new DefaultTableCellRenderer();
			cellRendererCenter.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tableColumn = table.getColumnModel();
			for(int i=0; i<tableColumn.getColumnCount(); i++) {
				tableColumn.getColumn(i).setCellRenderer(cellRendererCenter);
			}
			
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
			
			// 폰트 설정
			Font f = new Font("맑은고딕", Font.PLAIN, 14);
			closeButton.setFont(f);
			table.setFont(f);
			
			
			// 프레임 설정
			setTitle("근태 등록 현황");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setContentPane(mainPanel);
//			pack(); // 초기에 원하는 화면으로 보여주지 못함. (패널의 크기만큼 자동으로 압축시켜줌)
			setSize(900, 500);
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
