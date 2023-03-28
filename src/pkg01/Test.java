package pkg01;

public class Test {

	public static void main(String[] args) {
		
		String[] names = {"최태원", "이경선", "배준섭", "홍원표", "김성현", "우상현", "심미안"};
		int[] scores = new int[] {87, 95, 100, 65, 70, 84, 69};

		String maxName = "";
		int max = 0;
		for (int i = 0; i < scores.length; i++) {
			if(max < scores[i]) {
				max = scores[i];
				maxName = names[i];
			}
		}
		System.out.println("최고점을 받은 학생은 "+maxName+"이고 최고 점수는 "+max+"점 입니다.");
	}
}