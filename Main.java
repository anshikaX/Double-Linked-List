
import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {


        Scanner sc = new Scanner(System.in);
        DoubleLinkedList s=new DoubleLinkedList();
        int user=0;
        do{
            System.out.println("\n1. Create linked list \n2. Insert a value \n3. Delete a node \n4. Search for a node \n5. Traverse \n6.Reverse Traverse \n7.Delete entire list. \n\n\n Enter a Valid Choice");
            int option=sc.nextInt();
            switch(option)
            {

                case 1:s.createDLL();
                    break;

                case 2:s.insertNode();
                    break;

                case 3:s.delete();
                    break;

                case 4:s.search();
                    break;

                case 5:s.displayDLL();
                    break;

                case 6:s.reverseTraverseDLL();
                    break;

                case 7:s.deleteDLL();
                    break;

                default: System.out.println("\nInvalid choice!!!");
                    break;

            }
            int i=1;
            while(i==1){
                System.out.println("\nDo you want to continue \n\n1. YES \n2. NO\n");
                user=sc.nextInt();
                if(user==1 || user==2){
                    i=2;
                }
                else{
                    System.out.println("\nEnter a valid choice");
                    i=1;
                }

            }


        }while(user==1);

    }

}