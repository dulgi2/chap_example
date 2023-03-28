package pkg03;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 초기화면 - 메인 메뉴
 * - 프로그램 구동후 보여지는 화면
 */

public class MainMenu extends JFrame implements ActionListener {

	public Database db;
	
	// 화면에서 사용할 입력 필드, 버튼, 레이블 변수 선언
	private JLabel titleLable;
	private JButton punchInOutButton;
	private JButton timesheetButton;
	private JButton staffButton;
	private JButton staffListButton;
	private JButton exitButton;
	
	
	
	public MainMenu(Database db) {
		// 데이터베이스 전담 클래스의 객체를 전달 받아서 내가 선언한 변수에 저장
		this.db = db;
		
		// 프레임 설정
		setTitle("Staff TimeSheet");
		setLayout(new GridLayout(6, 1));
		setSize(300, 400);
		
		// 프레임 타이틀 설정
		titleLable = new JLabel("출퇴근 등록 시스템");
		titleLable.setHorizontalAlignment(JLabel.CENTER);
		add(titleLable);
		
		// 각 화면을 버튼으로 만들어서 프레임부착
		// 출퇴근 등록 버튼
		punchInOutButton = new JButton(" 출퇴근 등록 ");
		punchInOutButton.addActionListener(this);
		add(punchInOutButton);
		
		// 출퇴근 확인 버튼 
		timesheetButton = new JButton(" 근태 확인 ");
		timesheetButton.addActionListener(this);
		add(timesheetButton);
		
		// 사원 등록 버튼
		staffButton = new JButton(" 사원 등록 ");
		staffButton.addActionListener(this);
		add(staffButton);
		
		// 사원 리스트 버튼
		staffListButton = new JButton(" 사원 리스트 ");
		staffListButton.addActionListener(this);
		add(staffListButton);
		
		exitButton = new JButton(" 종료 ");
		exitButton.addActionListener(this);
		add(exitButton);
		
		//모든 버튼의 폰트 설정
		Font f = new Font("맑은고딕", Font.BOLD, 12); // "" 안에 기본 컴퓨터상의 기본 글씨체 이름을 넣으면 변경 가능.
		Font f1 = new Font("맑은고딕", Font.BOLD, 16); // "" 안에 기본 컴퓨터상의 기본 글씨체 이름을 넣으면 변경 가능.
		titleLable.setFont(f1);
		punchInOutButton.setFont(f);
		timesheetButton.setFont(f);
		staffButton.setFont(f);
		staffListButton.setFont(f);
		exitButton.setFont(f);
		
		
		
		//
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		
	}
	// 각 메뉴 버튼 클릭 시 할 일 정의
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == staffButton) {
			System.out.println("사원 등록");
			
			// 현재의 메인 메뉴 화면 닫기
			this.dispose();
			
			StaffAddForm staffAddForm = new StaffAddForm(db);
			
			// 이동 할 화면 보이기
			staffAddForm.setVisible(true);
		} else if(e.getSource() == punchInOutButton) {
			System.out.println(" 출퇴근 등록 ");
			dispose();
			
			PunchInOut punchInOut = new PunchInOut(db);
			punchInOut.setVisible(true);
			
		} else if (e.getSource() == timesheetButton) {
			System.out.println(" 근태 확인 ");
			// 현재 화면 닫기
			this.dispose();
			// 이동 할 화면 보이기
			TimeSheetForm timeSheetForm = new TimeSheetForm(db);
			timeSheetForm.setVisible(true);
			
		} else if(e.getSource() == staffButton) {
			System.out.println(" 사원 등록 ");
			StaffAddForm staffAddForm = new StaffAddForm();
			staffAddForm.setVisible(true);
		} else if(e.getSource() == staffListButton) {
			System.out.println(" 사원 리스트 ");
			
			// 현재 화면 닫기
			this.dispose();
			// 이동 할 화면 보이기
			StaffList staffList = new StaffList(db);
			staffList.setVisible(true);
		} else if (e.getSource() == exitButton) {
			System.exit(0);
			
		}
	}

	public static void main(String[] args) {
		Database db = new Database();
		new MainMenu(db);
	}

	
}
