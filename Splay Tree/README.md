# Splay Tree
A splay tree is a form of a balanced BST, with the additional property that recently accessed elements are quick to access again.

![Splay tree](./images/SPLAY.png)

The time complexity of certain functions for a BST:

* Find(item)- finds the item in the BST and returns true or false if present or not- amortized O(log(N))
* Insert(item)- Inserts the item into the tree- amortized O(log(N))
* Delete(item)- Deletes item if present in the Tree- amortized O(log(N))
* Splay(item)- puts the item at the root- amortized O(log(N))
