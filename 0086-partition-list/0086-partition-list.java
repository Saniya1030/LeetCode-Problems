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
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead=new ListNode(0);
        ListNode fastHead=new ListNode(0);
        ListNode small=smallHead;
        ListNode fast=fastHead;
        while(head!=null)
        {
            if(head.val<x)
            {
             small.next=head;
             small=small.next;
             head=head.next;
            }
            else{
                fast.next=head;
                fast=fast.next;
                head=head.next;
            }
        }
        
        small.next=fastHead.next;
        fast.next=null;
        return smallHead.next;
    }
}