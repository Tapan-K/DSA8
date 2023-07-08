package in.ineuron.assignment8;

public class CostructBinaryTreeQ4 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static TreeNode str2tree(String s) {
		if (s.isEmpty()) {
			return null;
		}

		int firstParen = s.indexOf('(');
		int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
		TreeNode root = new TreeNode(val);

		if (firstParen == -1) {
			return root;
		}

		int start = firstParen, count = 0;
		for (int i = start; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')') {
				count--;
			}

			if (count == 0 && start == firstParen) {
				root.left = str2tree(s.substring(start + 1, i));
				start = i + 1;
			} else if (count == 0) {
				root.right = str2tree(s.substring(start + 1, i));
			}
		}

		return root;
	}

	public static void inOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrderTraversal(root.left);
		System.out.print(root.val + " ");
		inOrderTraversal(root.right);
	}

	public static void main(String[] args) {
		// Q.4

		String s = "4(2(3)(1))(6(5))";

		TreeNode root = str2tree(s);
		inOrderTraversal(root);

	}

}
