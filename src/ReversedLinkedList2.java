public class ReversedLinkedList2 {
	private static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode fake_head = new ListNode(-1);
		fake_head.next = head;
		
        ListNode p = fake_head;
        ListNode q = null;
        ListNode r = null;
        ListNode pre = null;
        ListNode first = null;
        int i = 0;
        for (i = 1; i < m; i ++) {
        	p = p.next;
        	if (p == null) {
        		return head;
        	}
        }
        pre = p;
        p = p.next;
        first = p;
//        System.out.println(pre.val + " " + first.val);
        if (p == null) {
        	return head;
        }
        q = p.next;
        for (i = m+1; i <= n; i++) {
        	if (q == null) {
        		if (pre == fake_head) {
        			head = p;
        		} else {
        			pre.next = p;
        		}
        		first.next = q;
        		return head;
        	}
        	r = q.next;
//        	System.out.println(p.val + " " + q.val + " " + r.val);

        	q.next = p;
        	p = q;
        	q = r;
        }
//        System.out.println(q.val);
        if (pre == fake_head) {
        	head = p;
        } else {
        	pre.next = p;
        }
        first.next = q;
        return head;
    }
	
	private static ListNode buildList(int n) {
		if (n == 0) {
			return null;
		}
		int i = 0;
		ListNode head = new ListNode(1);
		ListNode p = head;
		for (i = 2; i <= n; i++) {
			p.next = new ListNode(i);
			p = p.next;
		}
		p.next = null;
		return head;
	}
	
	private static void printList (ListNode head) {
		ListNode p = head;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode head = buildList(5);
		printList(head);
		head = reverseBetween(head, 5, 6);
		printList(head);
		
	}
}

class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
       val = x;
       next = null;
   }
}
