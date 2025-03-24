// 2024
// Checks if the structure is rectangular, i.e., all rows have the same number of columns.
private boolean isRectangular() {
    if (firstRow == null) {
        return true; // An empty structure is considered rectangular
    }

    int targetColumns = numColumns(firstRow);
    RowHeader<E> temp = firstRow.nextRow;

    // Check if all rows have the same number of columns
    while (temp != null) {
        int columns = numColumns(temp);
        if (columns != targetColumns) {
            return false; // Found a row with a different number of columns
        }
        temp = temp.nextRow;
    }

    return true; // All rows have the same number of columns
}

// Counts the number of columns (nodes) in a row.
private int numColumns(RowHeader<E> header) {
    int count = 0;
    DataNode<E> temp = header.first;

    // Count the number of nodes (columns) in the current row
    while (temp != null) {
        count++;
        temp = temp.next;
    }

    return count; // Return the number of columns in the row
}

// 2023 Fall
// Finds the longest consecutive run of the target element in the list.
public int longestRun(E tgt) {
    // Single loop approach
    int maxRun = 0;
    int currentRun = 0;
    Node<E> temp = first;

    while (temp != null) {
        if (temp.data.equals(tgt)) {
            // Run still going!
            currentRun++;
            if (currentRun > maxRun) {
                maxRun = currentRun;
            }
        } else {
            currentRun = 0; // Reset current run if target is not found
        }
        temp = temp.next;
    }

    return maxRun;
}

// 2023 Spring
// Finds the last index of the target element in the list.
public int lastIndexOf(E tgt) {
    int index = 0;
    int result = -1;
    Node<E> temp = first;

    while (temp != null) {
        if (temp.data.equals(tgt)) {
            result = index; // Update result when the target is found
        }
        index++;
        temp = temp.next;
    }

    // Return -1 if no element equal to tgt was found
    return result;
}

// 2022 Spring
// Removes the last occurrence of the target element from the list.
public boolean removeLast(E tgt) {
    if (first == null) {
        return false; // List is empty
    }

    // Special case when there is only one element and it is the target
    if (first.next == null) {
        if (first.data.equals(tgt)) {
            first = null; // Set first to null if the only element is tgt
            return true;
        } else {
            return false; // Target not found
        }
    }

    // General case: Traverse to the second to last node
    Node<E> temp = first;

    // Traverse to the second-to-last node
    while (temp.next.next != null) {
        temp = temp.next;
    }

    // Check if the last node matches the target and remove it
    if (temp.next.data.equals(tgt)) {
        temp.next = null; // Remove last node
        return true;
    } else {
        return false; // Target not found in last node
    }
}

// 2021 Fall
// Interleaves two linked lists into a new linked list, alternating nodes.
public LinkedList314<E> interleave(LinkedList314<E> other) {
    LinkedList314<E> result = new LinkedList314<>();

    // Add the first two elements. Precondition: neither list is empty.
    result.first = new Node<>(first.data);
    result.first.next = new Node<>(other.first.data);

    Node<E> thisTemp = first.next;
    Node<E> otherTemp = other.first.next;
    Node<E> resultTemp = result.first.next;

    // Now add elements until both lists are exhausted.
    while (thisTemp != null || otherTemp != null) {
        if (thisTemp != null) {
            resultTemp.next = new Node<>(thisTemp.data);
            resultTemp = resultTemp.next;
            thisTemp = thisTemp.next;
        }

        if (otherTemp != null) {
            resultTemp.next = new Node<>(otherTemp.data);
            resultTemp = resultTemp.next;
            otherTemp = otherTemp.next;
        }
    }

    return result;
}

// 2021
// Interleaves two linked lists into a new linked list, alternating nodes (duplicate method).
public LinkedList314<E> interleave(LinkedList314<E> other) {
    LinkedList314<E> result = new LinkedList314<>();

    // Add the first two elements. Precondition: neither list is empty.
    result.first = new Node<>(first.data);
    result.first.next = new Node<>(other.first.data);

    Node<E> thisTemp = first.next;
    Node<E> otherTemp = other.first.next;
    Node<E> resultTemp = result.first.next;

    // Now add until both lists are exhausted.
    while (thisTemp != null || otherTemp != null) {
        if (thisTemp != null) {
            resultTemp.next = new Node<>(thisTemp.data);
            resultTemp = resultTemp.next;
            thisTemp = thisTemp.next;
        }

        if (otherTemp != null) {
            resultTemp.next = new Node<>(otherTemp.data);
            resultTemp = resultTemp.next;
            otherTemp = otherTemp.next;
        }
    }

    return result;
}

// 2019 Fall
// Checks if two linked lists converge at some point (i.e., they share a node).
public boolean listsConverge(LinkedList314<E> other) {
    if (thisSize == 0 || otherSize == 0) {
        return false; // empty lists can't converge
    }

    int diff = this.size - other.size; // Assume this is the bigger list
    Node<E> tempBig = this.first;
    Node<E> tempSmall = other.first;

    if (diff < 0) { // other list is bigger
        diff = -diff;
        tempBig = other.first;
        tempSmall = this.first;
    }

    // Move the temp in the bigger list forward by the difference in sizes
    while (diff > 0) {
        tempBig = tempBig.next;
        diff--;
    }

    // Traverse both lists until convergence or end
    while (tempBig != null) {
        if (tempBig == tempSmall) {
            return true; // Same node! Lists converge.
        }
        tempBig = tempBig.next;
        tempSmall = tempSmall.next;
    }

    return false; // No convergence found
}
