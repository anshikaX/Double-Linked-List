
import java.util.Scanner;
public class DoubleLinkedList
{
    static Node head = null;
    static Node tail = null;
    static Scanner sc = new Scanner(System.in);

    //creating Double Linked List
    public void createDLL()
    {
        System.out.println("Enter the number of nodes");
        int n = sc.nextInt();
        Node temp;
        for(int i=0;i<n;i++)
        {
            temp = new Node();
            System.out.println("Enter the value in a node");
            int value = sc.nextInt();
            temp.data=value;

            if(head==null)  // No node exists and we are creating one node
            {
                head = temp;
                tail = temp;
                temp.prev = null;
                temp.next = null;

            }
            else           // Some node exists and we are creating one more node
            {
                tail.next = temp;
                temp.prev = tail;
                temp.next = null;
                tail = temp;

            }
        }
    }

    //Traversing Double Linked List
    public void displayDLL()
    {
        Node currentNode = head;
        while (currentNode != null)
        {
            System.out.println(currentNode.data + " ");
            currentNode = currentNode.next;

        }
    }

    //Reverse Traversing Double Linked List
    public void reverseTraverseDLL()
    {
        if(head==null)
        {
            System.out.println("Linked list doesn't exist");
        }
        else
        {
            Node currentNode = tail;
            while(currentNode!=null)
            {
                System.out.println(currentNode.data + " ");
                currentNode = currentNode.prev;
            }
        }
    }

    //Insertion of a node in Double Linked list
    public void insertNode()
    {
        Node temp = new Node();
        System.out.println("\n1.Insert at the start. \n2.Insert at the specific position. \n3.Insert at the end");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1 :
                System.out.println("Enter the value in a node");
                int value1=sc.nextInt();
                temp.data = value1;
                if(head==null)            //There's no node and we are creating the first node.
                {
                    head= temp;
                    tail= temp;
                    temp.prev = null;
                    temp.next = null;
                }
                else                     //If there is a node already and we are creating a node at the start
                {
                    head.prev=temp;
                    temp.next=head;
                    temp.prev=null;
                    head = temp;
                }
                break;

            case 2:
                System.out.println("Enter the value in a node");
                int value2=sc.nextInt();
                temp.data=value2;
                System.out.println("Enter the position where we want to create a node");
                int position=sc.nextInt();
                int counter=1;
                if(head==null && position==1)
                {
                    head=temp;
                    tail=temp;
                    temp.prev=null;
                    temp.next=null;
                }
                else if(head!=null && position==1)
                {
                    head.prev=temp;
                    temp.next=head;
                    temp.prev=null;
                    head=temp;
                }
                else {
                    Node currentNode = head;
                    while (currentNode != null)
                    {
                        if (counter == position - 1)
                        {
                            break;
                        }
                        currentNode = currentNode.next;
                        counter++;
                    }
                    if(currentNode==tail)
                    {
                        tail.next=temp;
                        temp.prev=tail;
                        temp.next=null;
                        tail=temp;
                    }
                    else if(currentNode!=null)
                    {
                        temp.prev=currentNode;
                        temp.next=currentNode.next;
                        currentNode.next.prev=temp;
                        currentNode.next = temp;
                    }
                    else
                    {
                        System.out.println("Invalid Position");
                    }
                }
                break;

            case 3:
                System.out.println("Enter the value in a node");
                int value3=sc.nextInt();
                temp.data=value3;
                if(head==null)
                {
                    head=temp;
                    tail=temp;
                    temp.prev=null;
                    temp.next=null;
                }
                else
                {
                    tail.next=temp;
                    temp.prev=tail;
                    temp.next=null;
                    tail=temp;
                }
                break;

            default:
                System.out.println("Invalid choice!!  \n\n Please select a suitable choice ");
                insertNode();
        }
    }

    //Searching a value in a Node
    public void search()
    {
        System.out.println("Enter the value to search");
        int value = sc.nextInt();
        Node currentNode = head;
        int counter=1;
        while(currentNode!=null)
        {
            if(currentNode.data==value)
            {
                System.out.println("Value found!!");
                System.out.println("Value is: " +currentNode.data + " and it's position is: " +counter);
                break;
            }
            currentNode=currentNode.next;
            counter++;
        }
    }

    //Deleting a node from a Double linked list
    public void delete()
    {
        System.out.println("\n1.Delete the first node. \n2.Delete the specific node. \n3.Delete the last node.");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1:
                if(head==null)
                {
                    System.out.println("There is no linked list!");
                }
                else if(head==tail)
                {
                    head=null;
                    tail=null;
                }
                else
                {
                    head=head.next;
                    head.prev=null;

                }
                break;

            case 2:
                System.out.println("Enter the position where you want to delete");
                int position=sc.nextInt();
                if(head==null)
                {
                    System.out.println("Linked list doesn't exist");
                }
                else if(head==null && position==1)
                {
                    head=null;
                    tail=null;

                }
                else if(head!=null && position==1)
                {
                    head = head.next;
                    head.prev = null;

                }
                else
                {
                    Node currentNode=head;
                    int counter=1;
                    while(currentNode!=tail)
                    {
                        if(counter==position-1)
                        {
                            break;
                        }
                        currentNode=currentNode.next;
                        counter++;
                    }
                    if(currentNode.next==tail)
                    {
                        tail.prev.next=null;
                        tail=tail.prev;

                    }
                    else if(currentNode!=tail)
                    {
                        currentNode.next=currentNode.next.next;
                        currentNode.next.prev=currentNode;


                    }
                    else
                    {
                        System.out.println("Invalid Position!!");
                    }

                }
                break;

            case 3:
                if(head==null)
                {
                    System.out.println("There is no linked list.");

                }
                else if(head==tail)
                {
                    head=null;
                    tail=null;


                }
                else
                {
                    tail.prev.next=null;
                    tail=tail.prev;

                }
                break;

            default:
                System.out.println("Invalid choice!!Please select again");
                delete();
        }
    }

    //Deleting the entire Double Linked list
    public void deleteDLL()
    {
        Node currentNode = tail;
        while(currentNode!=null)
        {
            currentNode=currentNode.prev;
            tail.prev=null;
        }
        head=null;
        tail=null;

    }

}
