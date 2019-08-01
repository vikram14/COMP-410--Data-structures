# Binary Search Tree (BST)
BSTs are a subset of Binary Trees. Every BST must satisfy the condition the following condition:
* The Left child of very parent node must be less than or equal to its value
* The Right child of every parent node must be greater than or equal to its value

![BST](./images/BST.png)

The time complexity of certain functions for a BST:
* Find(item)- finds the item in the BST and returns true or false if present or not- O(log(N)),best case; O(N), worst case
* Insert(item)- Inserts the item into the tree- O(log(N)),best case; O(N), worst case
* Delete(item)- Deletes item if present in the Tree- O(log(N)),best case; O(N), worst case
* BSTSort()- obtains data in sorted order using an Inorder traversal after building the tree - O(N log(N)),best case; O(N^2), worst case
