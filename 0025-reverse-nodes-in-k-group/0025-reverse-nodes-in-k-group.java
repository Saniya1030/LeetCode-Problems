/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
          ListNode temp=head;
          ListNode prevNode=null;
          while(temp!=null)
          {
            ListNode kth=findKth(temp,k);
              if(kth==null)
            {
                if(prevNode!=null)
                {
                prevNode.next=temp;
                }
                break;
            }
            ListNode nextNode=kth.next;
            kth.next=null;

            reverse(temp);
          

            if(temp==head)
            {
                head=kth;
            }
            else{
                prevNode.next=kth;
            }
            prevNode=temp;
            temp=nextNode;
          }
          return head;
    }
    private ListNode findKth(ListNode temp,int k)
    {
        k--;
        while(temp!=null && k>0)
        {
            temp=temp.next;
            k--;
        }
        return temp;
    }
    private ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }
        return prev;
    }
}