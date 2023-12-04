package tuan11;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public void addBNode(E e) {
		int compare = e.compareTo(data);// e-data
		BNode<E> b1 = new BNode<>(e);
		if (compare > 0) {
			if (right == null) {
				right = b1;
			} else {
				right.addBNode(e);
			}
		} else {
			if (left == null) {
				left = b1;
			} else {
				left.addBNode(e);
			}
		}
	}

	public int depthE(E e) {
		int depth = 0;
		int compare = e.compareTo(data);// e-data
		if (data == e) {
			return depth;
		} else {
			if (compare > 0)
				if (right != null)
					depth = right.depthE(e) + 1;
				else {
					if (left != null) {
						depth = left.depthE(e) + 1;// +1 +1 +1 +...+1 left.depth trả về depth.
					}
				}

		}
		return depth;
	}

	public int heightB() {
		int leftHeight = 0;
		int rightHeight = 0;
		if (left != null) {
			leftHeight = left.heightB();
		}
		if (right != null) {
			rightHeight = right.heightB();
		}

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public int sizeB() {
		int size = 0;
		if (left != null) {
			size += left.sizeB();// nếu như có node left thì size+1
		}
		if (right != null) {
			size += right.sizeB();
		}

		return size + 1;

	}

	public boolean containsB(E e) {
		int compare = e.compareTo(data);// e-data
		if (data == e) {
			return true;
		} else {
			if (compare > 0) {
				if (right != null) {
					return right.containsB(e);
				}
			}
			if (left != null) {
				return left.containsB(e);
			}

		}
		return false;
	}

	public E findMinB() {
		if (left == null) {
			return data;
		}
		return left.findMinB();
	}

	public E findMaxB() {
		if (right == null) {
			return data;
		}
		return right.findMaxB();
	}

	public boolean removeB(E e) {
	    if (e.compareTo(data) < 0) {
	        if (left == null) {
	            return false; // Phần tử không tồn tại trong cây
	        }
	        if (left.data.equals(e)) {
	            left = removeNode(left);
	            return true;
	        }
	        return left.removeB(e);
	    } else if (e.compareTo(data) > 0) {
	        if (right == null) {
	            return false; // Phần tử không tồn tại trong cây
	        }
	        if (right.data.equals(e)) {
	            right = removeNode(right);
	            return true;
	        }
	        return right.removeB(e);
	    } else {
	        // Phần tử cần xóa là nút hiện tại
	        BNode<E> newNode = removeNode(this);
	        this.data = newNode.data;
	        this.left = newNode.left;
	        this.right = newNode.right;
	        return true;
	    }
	}

	private BNode<E> removeNode(BNode<E> node) {
	    if (node.left == null && node.right == null) {
	        // Nút không có con
	        return null;
	    } else if (node.left == null) {
	        // Nút chỉ có con phải
	        return node.right;
	    } else if (node.right == null) {
	        // Nút chỉ có con trái
	        return node.left;
	    } else {
	        // Nút có cả hai con
	        E minData = node.right.findMinB();
	        node.right = node.right.removeNode(node.right);
	        node.data = minData;
	        return node;
	    }
	}

	// get the descendants of a node
	public List<E> descendantsB(E e) {
	    List<E> list = new ArrayList<>();
	    if(findB(e)!=null) {
	    	addD(findB(e), list,e);
	    }
	    return list;
	}
	public BNode<E>findB(E e){
		int compare=e.compareTo(data);
		if(compare==0) {
			return this;
		}
		if(compare>0&&right!=null) {
			return right.findB(e);
		}
		if(compare<0&&left!=null) {
			return left.findB(e);
		}
		return null;
	}
	public void addD(BNode<E>b,List<E>list,E e) {// thêm e để ko in ra cha
		if(b.getLeft()!=null) {
			addD(b.getLeft(), list,e);
		}
		if(b.getRight()!=null) {
			addD(b.getRight(), list,e);
		}
		if(b.getData()!=e) {
			list.add(b.getData());
		}
		
	}
	

	public List<E> ancestors(E e) {
	    List<E> list = new ArrayList<>();
	    if(left!=null&&left.containsB(e)) {
	    	list.addAll(left.ancestors(e));
	    	list.add(data);
	    }
	    if(right!=null&&right.containsB(e)) {
	    	list.addAll(right.ancestors(e));
	    	list.add(data);
	    }
	    
	    return list;
	}
	// display BST using inorder approach
		public void inorder() { //left node right
			if(left!=null) {
				left.inorder();
			}
			System.out.print(data+" ");
			if(right!=null) {
				right.inorder();
			}
		}
		// display BST using preorder approach
		
		public void preorder() {// node left right
			System.out.print(data+" ");
			if(left!=null) {
				left.preorder();
			}
			
			if(right!=null) {
				right.preorder();
			}
		}
		// display BST using postorder approach
		public void postorder() { //left right node
			
			if(left!=null) {
				left.postorder();
			}
			if(right!=null) {
				right.postorder();
			}
			System.out.print(data+" ");
		}

	public BNode<E> getLeft() {
		return left;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

}
