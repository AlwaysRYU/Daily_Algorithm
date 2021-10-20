import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class 절댓값힙{

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine().trim());
		PriorityQueue<PNumber> pq = new PriorityQueue<PNumber>();
		for (int i = 0; i < N; i++) {

			int number = Integer.parseInt(br.readLine().trim());
			if (number == 0) {
				if (pq.isEmpty()) {
					bw.write(String.valueOf(0));
					bw.newLine();
				} else {
					bw.write(String.valueOf(pq.poll().ori));
					bw.newLine();
				}
			} else {
				pq.offer(new PNumber(number, Math.abs(number)));
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

class PNumber implements Comparable<PNumber>{
	int ori, abs;

	public PNumber(int ori, int abs) {
		super();
		this.ori = ori;
		this.abs = abs;
	}

	@Override
	public int compareTo(PNumber o) {

		if(this.abs < o.abs) {
			return -1;
		} else if (this.abs > o.abs) {
			return 1;
		} else {
			if(this.ori < o.ori) {
				return -1;
			} else if (this.ori > o.ori){
				return 1;
			} else {
				return 0;
			}
		}
	}
}