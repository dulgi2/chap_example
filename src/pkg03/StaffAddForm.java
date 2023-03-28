package pkg03;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StaffAddForm extends JFrame implements ActionListener {
	
	public Database db;
	
	private JTextField idField, nameField, juminField, addressField, hiredateField;
	private JButton goToMenuButton, addButton;
	
	// 기본생성자
	public StaffAddForm() {
	}
	
	// 데이터베이스 전담 클래스 객체 전달 받아서 변수에 저장함
	public StaffAddForm(Database db) {
		this.db = db;
		
		// 텍스트 필드(입력칸)와 레이블 설정
		idField = new JTextField(10);
		nameField = new JTextField(10); 
		juminField = new JTextField(10); 
		addressField = new JTextField(10); 
		hiredateField = new JTextField(10);
		
		JLabel idJLabel = new JLabel("사원ID :");
		JLabel nameLabel = new JLabel("이름 :");
		JLabel juminLabel = new JLabel("주민등록번호 :");
		JLabel addressJLabel = new JLabel("주소 :");
		JLabel hiredateJLabel = new JLabel("입사일(yy-MM-dd) :");
		
		// 사원 추가 버튼 생성
		addButton = new JButton("등록");
		
		// 액션 리스너 부착
		addButton.addActionListener(this);
		
		// 버튼, 레이블, 텍스트 필드를 배치할 메인 매널 생성
		JPanel mainPanel = new JPanel();
		
		// 메인 패널을 BorderLayout으로 만들겠다.
		mainPanel.setLayout(new BorderLayout());
		
		// 버튼, 레이블, 텍스트 필드를 배치할 input 패널
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(5,2));
		inputPanel.add(idJLabel);
		inputPanel.add(idField);
		
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(juminLabel);
		inputPanel.add(juminField);
		inputPanel.add(addressJLabel);
		inputPanel.add(addressField);
		inputPanel.add(hiredateJLabel);
		inputPanel.add(hiredateField);
		
		//***
		JPanel goToPanel = new JPanel(); 
		goToMenuButton = new JButton("메뉴로 돌아가기");
		goToMenuButton.addActionListener(this);
		goToPanel.add(goToMenuButton);
		// 메일 패널에 input
		mainPanel.add(inputPanel, BorderLayout.NORTH);
		// 메인 매널에 "등록" 버튼 부착
		mainPanel.add(addButton, BorderLayout.CENTER);
		
		mainPanel.add(goToPanel, BorderLayout.SOUTH);
		
		// 폰트 설정
		Font f = new Font("맑은고딕", Font.PLAIN, 14);
		idJLabel.setFont(f);
		nameLabel.setFont(f);
		juminLabel.setFont(f);
		addressJLabel.setFont(f);
		hiredateJLabel.setFont(f);
		addButton.setFont(f);
		
		
		// 프레임(윈도우 창) 설정
		setTitle("사원 정보 입력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 메인 패널을 프레임의 루트 컨텐트에 저장
		setContentPane(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		/**
        * 컴포넌트(버튼, 텍스트필드, 레이블)가 프레임에 쌓이는 순서
        *  - 프레임 > 루트 컨텐트 > 메인 패널 > input패널 > 버튼,텍스트필드,레이블
        */
	}
	// 액션 리스너
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			// 화면에서 입력된 값을 임시 변수에 저장
			String id = idField.getText();
			String name = nameField.getText();
			String jumin = juminField.getText();
			String address = addressField.getText();
			String hiredate = hiredateField.getText();
			
			// isEmpty() -> 값이 비어있다면("")
			// 텍스트에 들어 있는 값중에 비어있는게 한개라도 있다면
			if(id.isEmpty() || name.isEmpty() || jumin.isEmpty() || address.isEmpty() || hiredate.isEmpty()) {
				JOptionPane.showMessageDialog(this, "모두 입력되지 않았습니다.");
				return;
			}
			
			// 화면에서 입력받은 데이터로 사원 객체 생성
			Staff staff = new Staff(id, name, jumin, address, hiredate);
			this.db.addStaff(staff);
			// 사원 객체 성공저으로 등록 완료 메세지
			JOptionPane.showMessageDialog(this, "등록 완료");
			// 사원 등록 끝나서 현재의 화면 닫기
			this.dispose();
			// 이동해갈 메인 메뉴 생성
			MainMenu mainMenu = new MainMenu(db);
			// 메인 메뉴 보이기
			mainMenu.setVisible(true);
		} else if(e.getSource() == goToMenuButton) {
			this.dispose();
			
			MainMenu mainMenu = new MainMenu(db);
			mainMenu.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new StaffAddForm(new Database());
	}

}
