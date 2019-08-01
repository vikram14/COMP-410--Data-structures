# Minimum Binary Heap

A minimum binary heap always stores the minimum value at the root. For a data structure to qualify as a MBH, it needs to follow 2 conditions:
* the value of each node is greater than or equal to the value of its parent
* The heap must always be a complete binary tree

![Min Bin Heap](./images/MBH.png)

The time complexity of certain functions for a Minimum Binary Heap:

Insert(item)- Inserts the item into the heap- O(log(N)) guaranteed
Delete()- Deletes the min item and restructures the heap- O(log(N)) guaranteed
Sort()- builds the heap with inserts and then  keeps retrieving the min- O(Nlog(N))
MBHSort(list_of_values[])- using effiecient build (builds a heap with the given list of values in O(N))obtains data in sorted order after using N deletes- O(N log(N))guaranteed 
