package pkg03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class PunchInOut extends JFrame implements ActionListener{
	
	public Database db;
	
	private JTextField idField, nameField, puchInField, puchOutField;
	private JButton goToMenuButton, addButton, addButton2;
	
	
	public PunchInOut(Database db) {
		this.db = db;
		
		// 텍스트 필드와 레이블 설정
		idField = new JTextField(10);
		nameField = new JTextField(10);
		
		JLabel idJLabel = new JLabel("사원 ID :");
		JLabel namJLabel = new JLabel("사원 이름 :");
		
		// 출근 버튼 생성
		addButton = new JButton("출근");
		addButton2 = new JButton("퇴근");
		goToMenuButton = new JButton("메뉴로 돌아가기");
		
		
		// ActionListener 부착
		addButton.addActionListener(this);
		addButton2.addActionListener(this);
		goToMenuButton.addActionListener(this);
		
		// 메인 패널 생성
		JPanel mainPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel goToPanel = new JPanel();
		
		mainPanel.setLayout(new BorderLayout());
		
		
		buttonPanel.setLayout(new GridLayout(1, 2));
		inputPanel.setLayout(new GridLayout(2,2));
		inputPanel.add(idJLabel);
		inputPanel.add(idField);
		
		inputPanel.add(namJLabel);
		inputPanel.add(nameField);
		
		buttonPanel.add(addButton);
		buttonPanel.add(addButton2);
		
		goToPanel.add(goToMenuButton);
		
		mainPanel.add(inputPanel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		mainPanel.add(goToPanel, BorderLayout.SOUTH);
			
		
		//모든 버튼의 폰트 설정
		Font f = new Font("맑은고딕", Font.PLAIN, 14); // "" 안에 기본 컴퓨터상의 기본 글씨체 이름을 넣으면 변경 가능.
		addButton.setFont(f);
		addButton2.setFont(f);
		idJLabel.setFont(f);
		namJLabel.setFont(f);
		
		
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
		if(e.getSource() == goToMenuButton) {
			dispose();
			
			MainMenu menu = new MainMenu(db);
			menu.setVisible(true);
		} else if(e.getSource() == addButton) {
			// 출근 버튼이 눌렸을 때
			for(Staff s : db.getStaffList()) {
				String id = s.getId(); // 비교할 직원의 아이디
				String name = s.getName(); // 비교할 직원의 이름
				String inputId = idField.getText(); // 입력된 아이디
				String inputName = nameField.getText();
				
				// 비교할 직원의 아이디와 이름이 입력한 값과 모두 같을 경우에만
				if(id.equals(inputId) && name.equals(inputName)) {
					// 현재 출근시간 변수에 값이 들어있다면 출근한 것으로 간주함
					if(!s.getPunchIn().isEmpty()) {
						JOptionPane.showMessageDialog(this, "직원이 이미 출근하였습니다.");
						return;
					} else {
						s.setPunchIn(getDateTime()); // 현재 시간을 직원의 '출근시간' 변수에 담음
						JOptionPane.showMessageDialog(this, "[" + name + "]님이 출근하셨습니다.");
						return;
					}
					
					
				}
			}
			System.out.println("일치하는 아이디와 이름이 존재하지 않습니다.");
			
		} else if(e.getSource() == addButton2) {
			// 퇴근 버튼이 눌렸을 때
			for(Staff s : db.getStaffList()) {
				String id = s.getId(); // 비교할 직원의 아이디
				String name = s.getName(); // 비교할 직원의 이름
				String inputId = idField.getText(); // 입력된 아이디
				String inputName = nameField.getText();
				
				// 비교할 직원의 아이디와 이름이 입력한 값과 모두 같을 경우에만
				if(id.equals(inputId) && name.equals(inputName)) {
					// 직원이 아직 출근 전이라면
					if(s.getPunchIn().isEmpty()) {
						JOptionPane.showMessageDialog(this, "[" + name + "]님은 아직 출근하지 않았습니다.");
						return;
					// 직원이 이미 출근, 퇴근을 모두 한 경우
					} else if(!s.getPunchOut().isEmpty()) {
						JOptionPane.showMessageDialog(this, "직원이 이미 퇴근하였습니다.");
						return;
					} else {
						s.setPunchOut(getDateTime()); // 현재 시간을 직원의 '퇴근시간' 변수에 담음
						JOptionPane.showMessageDialog(this, "[" + name + "]님이 퇴근하셨습니다.");
						return;
					}
					
					
				}
			}
			System.out.println("일치하는 아이디와 이름이 존재하지 않습니다.");
		}
	}
	
	// 현재 시간을 기준으로 데이터를 가져와서 출근 시간에 기입
	// 프로그램을 시연하는 시간이 실제보다 짧으므로 초까지 표현
	// getDateTime() -> 현재 시간을 기준으로 문자열을 반환함.
	public String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy년 MM월 dd일 : HH시 mm분 ss초");
		Date now = new Date();
		return dateFormat.format(now);
		
	}
	
	
	public static void main(String[] args) {
		new PunchInOut(new Database());
	}

}
