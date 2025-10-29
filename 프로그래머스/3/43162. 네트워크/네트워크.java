import java.util.stream.IntStream;

class Solution {

	private static class Dsu {

		private final int[] parent;

		public Dsu(int size) {
			this.parent = new int[size];
			for (int i = 0; i < size; i++) {
				parent[i] = i;
			}
		}

		public int find(int x) {
			if (parent[x] == x) {
				return x;
			}

			parent[x] = find(parent[x]);
			return parent[x];
		}

		public boolean union(int x, int y) {
			int parentX = find(x);
			int parentY = find(y);

			if (parentX == parentY) {
				return false;
			}

			parent[parentY] = parentX;
			return true;
		}
	}

	public int solution(int n, int[][] computers) {
		Dsu d = new Dsu(n);

		for (int row = 0; row < computers.length; row++) {
			for (int col = 0; col < n; col++) {
				if (computers[row][col] == 1) {
					d.union(row, col);
				}
			}
		}

		return (int)IntStream.range(0, n).filter(v -> d.find(v) == v).count();
	}
}