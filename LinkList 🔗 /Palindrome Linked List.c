struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode* newList = NULL;
    struct ListNode* curr = head;

  // here simply approch is that take head of original list and add it in newList as head 
  
    while (curr != NULL) {
        struct ListNode* nextTmp = curr->next;
        curr->next = newList;
        newList = curr;
        curr = nextTmp;
    }
    
    return prev;
}

bool isPalindrome(struct ListNode* head) {
    if (head == NULL || head->next == NULL)
        return true;
    
    struct ListNode* slow = head;
    struct ListNode* fast = head;

  // to find middle of th list
  //fast take 2 steps and slow take 1 step only 
  
    while (fast->next != NULL && fast->next->next != NULL) {
        fast = fast->next->next;
        slow = slow->next;
    }// so at the end fast reach end of the list and at that time slow reach the middle of list
    
    struct ListNode* reversed = reverseList(slow->next);

  //Simply check new Reverse list is equals to first part of original list
  
    while (reversed != NULL) {
        if (head->val != reversed->val)
            return false;
        head = head->next;
        reversed = reversed->next;
    }
    
    return true;
}

