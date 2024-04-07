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
    private boolean checkTarget(int[]nums, int target){
        for(int i=0;i<nums.length;i++){
            if(target == nums[i]) return true;
        }
        return false;
    }
    public int numComponents(ListNode head, int[] nums) {
        int components = 0,lcc = 0;
        //lcc-> length of current component
        
        while(head!=null){
            if(checkTarget(nums,head.val)){
                lcc++;
                // increment components count only when new lcc starts from 0
                if(lcc==1)components++;
            }
            else {
                lcc=0;
            }
            head=head.next;
        }
        return components;
    }
}
