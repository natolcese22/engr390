//Session.java
//BreathLeaf

import java.util.*;
import java.io.*;


public class Session{

	Node first;
    int size;
    int sessionDuration;

    public Session(){

    }

    public Session(Session that){
      this.first = new Node(that.first);
      this.size = that.size;
      this.sessionDuration = that.sessionDuration;
    }

    public String toString () {
      return "Size: " + this.size + ", Session duration: " + this.sessionDuration;
    }

    public String deepToString(){
      Node current = this.first;
      String string = " ";
      while(current !=null){
        string = string + (current.j +"-" + current.dx + "-" + current.duration + "\n");
        current = current.next;
      }
      string = string + ("\n Size: " + this.size);
      return string;
    }

    public boolean isEmpty(){
      return size == 0;
  	}

  	public void addBreath(String newBreath){
  		String[] parts = newBreath.split(" ");
  		int j = Integer.parseInt(parts[0]);
  		double x = Double.parseDouble(parts[1]);
  		int duration = Integer.parseInt(parts[2]);

  		this.push(j, dx, duration);
  	}

  	public void push(int j, double dx, int duration){
    Node newNode = new Node(j, dx, duration);
    newNode.next = this.first;
    this.first = newNode;
    size++;
	}


	  public class Node{
      int j;
      double dx;
      int duration;
      Node next;

      public Node(int j, double dx, int duration){
        this.j = j;
        this.dx = dx;
        this.duration = duration;
        this.next = null;
      }

      public Node(Node node){
        this.j = node.j;
        this.dx = dx;
        this.duration = duration;
        this.next = node.next == null ? null : new Node(node.next);
      }

      public boolean compareTo(Node node){
        return (this.i == node.i && this.j == node.j);
      }

    }

}
