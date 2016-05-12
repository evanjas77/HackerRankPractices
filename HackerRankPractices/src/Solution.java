import java.io.IOException;

public class Solution {

	public static class LinkedListNode {
		String val;
		LinkedListNode next;

		LinkedListNode(String node_value) {
			val = node_value;
			next = null;
		}
	};

	public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val) {
		if (head == null) {
			head = new LinkedListNode(val);
		} else {
			LinkedListNode end = head;
			while (end.next != null) {
				end = end.next;
			}
			LinkedListNode node = new LinkedListNode(val);
			end.next = node;
		}
		return head;
	}

	static int find(String listStr1, String subListStr1) {

//		StringBuffer listStrBuf = new StringBuffer();
//		while(list.next != null){
//			listStrBuf.append("[" + list.val+"],"); 
//		}
//		
//		StringBuffer subListStrBuf = new StringBuffer();
//		while(sublist.next != null){
//			subListStrBuf.append("[" + sublist.val+"],");
//		}
		
//		String listStr = listStrBuf.toString();
//		String subListStr = subListStrBuf.toString();
//		
//		int presence =  listStr.indexOf(subListStr);
//		if(presence > -1){
//			String noSplit = listStr.substring(0, presence);
//			return noSplit.split(",").length;
//		} else 
			return -1;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(convert(0));
	}
	
	public static String convert(long num){
		
//		String[] base10 = {"0", "1", "2", "3", "4", "5", "6"};
		String[] base7 = {"0", "a", "t", "l", "s", "i", "n"};
		String base7str = Long.toString(Long.parseLong(Long.toString(num), 10), 7);
		String[] b7arr = base7str.split("");
		String b7finalStr="";
		for(int i=0; i<b7arr.length; i++){
			b7finalStr += base7[Integer.parseInt(b7arr[i])];
		}
		
		return b7finalStr;
	}
}