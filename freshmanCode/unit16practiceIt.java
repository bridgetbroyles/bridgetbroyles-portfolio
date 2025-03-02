// 16.6 hasTwoConsecutive
public boolean hasTwoConsecutive() {
    if (front == null) {
        return false;
    }
    ListNode prev = front;
    ListNode current = prev.next;
    
    while (current != null) {
        if (prev.data + 1 == current.data) {
            return true;
        }
        prev = current;
        current = current.next;
    }
    return false;
}

// 16.7 deleteBack
public int deleteBack() {
    if (front == null) {
        throw new NoSuchElementException();
    }
    
    int value;
    if (front.next == null) {
        value = front.data;
        front = null;
        return value;
    }
    
    ListNode current = front;
    while (current.next.next != null) {
        current = current.next;
    }
    
    value = current.next.data;
    current.next = null;
    return value;
}

// 16.8 switchPairs
public void switchPairs() {
    ListNode current = front;
    while (current != null && current.next != null) {
        int temp = current.data;
        current.data = current.next.data;
        current.next.data = temp;
        current = current.next.next;
    }
}

// 16.9 stutter
public void stutter() {
    ListNode current = front;
    while (current != null) {
        current.next = new ListNode(current.data, current.next);
        current = current.next.next;
    }
}

// 16.10 stretch
public void stretch(int n) {
    if (n <= 0) {
        front = null;
        return;
    }
    
    ListNode current = front;
    while (current != null) {
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(current.data, current.next);
            current = current.next;
        }
        current = current.next;
    }
}

// 16.11 compress
public void compress(int n) {
    ListNode current = front;
    while (current != null) {
        for (int i = 1; i < n && current.next != null; i++) {
            current.data += current.next.data;
            current.next = current.next.next;
        }
        current = current.next;
    }
}
// 16.12 split
public void split() {
    ListNode current = front;
    while (current != null && current.next != null) {
        if (current.next.data < 0) {
            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = front;
            front = temp;
        } else {
            current = current.next;
        }
    }
}

// 16.13 transferFrom
public void transferFrom(LinkedIntList list2) {
    if (this.front == null) {
        this.front = list2.front;
    } else {
        ListNode list1 = this.front;
        while (list1.next != null) {
            list1 = list1.next;
        }
        list1.next = list2.front;
    }
    list2.front = null;
}

// 16.14 removeAll
public void removeAll(int n) {
    while (this.front != null && this.front.data == n) {
        this.front = this.front.next;
    }
    
    ListNode current = this.front;
    
    while (current != null && current.next != null) {
        if (current.next.data == n) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
}

// 16.15 equals2
public boolean equals2(LinkedIntList list) {
    ListNode list1 = this.front;
    ListNode list2 = list.front;
    
    while (list1 != null || list2 != null) {
        if (list1 == null || list2 == null) return false;
        if (list1.data != list2.data) return false;
        
        list1 = list1.next;
        list2 = list2.next;
    }
    
    return true;
}

// 16.16 removeEvens
public LinkedIntList removeEvens() {
    LinkedIntList list2 = new LinkedIntList();
    
    if (this.front != null) {
        list2.front = this.front;
        this.front = front.next;
        list2.front.next = null;
    }
    
    ListNode list1C = this.front;
    ListNode list2C = list2.front;

    while (list1C != null && list1C.next != null) {
        list2C.next = list1C.next;
        list2C = list2C.next;
        list1C.next = list1C.next.next;

        if (list2C != null) list2C.next = null;
    }
    
    return list2;
}
