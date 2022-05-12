package Sosmed;
import java.util.Scanner;
class Node {
    int data;
    String nama;
    int followers=0;
    Node next;
    public Node(int data) {
        this.data = data;
    }

    public Node(String nama)
    {this.nama=nama;}
}
class Graf {
    int size;
    int index=0;
    Node[] list;


    public Graf(int size) {
        this.size = size;
        list = new Node[size];

    }

    public void signin(String nama){
        list[index]=new Node(nama);
        index++;
    }


    public void follow(String nama1, String nama2) {
        int x=0;
        int y=0;
        while(!list[y].nama.equals(nama2)){
            y++;
        }
        list[y].followers++;

        while(!list[x].nama.equals(nama1)){
            x++;
        }
        Node pointer=list[x];

        while(pointer.next!=null){
            pointer=pointer.next;
        }
        pointer.next=new Node(nama2);
//        int z=0;
//        while(!list[z].nama.equals(nama2)){
//            z++;
//            if (list[z]==null)break;
//        }
       // pointer.next=list[z];
    }

    public String mostfollowed(){
        Node[] a=list;
        Node temp;
        for (int i = 0; i < size; i++)
        {
            for (int j = i + 1; j < size; j++)
            {
                if (a[i].followers > a[j].followers)
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[size-1].nama;
    }

    public void printlistfollowers(){
        int x=0;
        for (int i = 0; i < size; i++) {
            System.out.println(list[x].nama+" followers = "+list[x].followers);
            x++;
        }
    }




    public void addEdge(int node1, int node2) {
        if (list[node1 - 1] == null) {
            list[node1 - 1] = new Node(node2);
        }
        else {
            Node pointer = list[node1 - 1];
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new Node(node2);
        }
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            //System.out.print(i + 1 + " -> ");
            Node pointer = list[i];
            while (pointer != null) {
                System.out.print(pointer.nama);
                if (pointer.next != null) System.out.print(" -> ");
                pointer = pointer.next;
            }
            System.out.println();
        }
    }
}



public class Graph {
    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);
//        String inputkeyboard;
//
//        int jumlahpengguna=input.nextInt();
//        int jumlahconnection=input.nextInt();
//        input.nextLine();
//
//        for (int i = 0; i < jumlahpengguna; i++) {
//            inputkeyboard=input.nextLine();
//        }
//
//        for (int i = 0; i <jumlahconnection; i++) {
//            inputkeyboard=input.nextLine();
//        }

        Graf tes1=new Graf(7);
        tes1.signin("elviana");
        tes1.signin("jeni");
        tes1.signin("aurelia");
        tes1.signin("miselia");
        tes1.signin("retno");
        tes1.signin("leon");
        tes1.signin("chandra");

        tes1.follow("elviana","jeni");
        tes1.follow("elviana","miselia");
        tes1.follow("elviana","leon");
        tes1.follow("jeni","chandra");
        tes1.follow("jeni","aurelia");

        tes1.follow("jeni","miselia");
        tes1.follow("aurelia","retno");
        tes1.follow("aurelia","miselia");
        tes1.follow("aurelia","elviana");
        tes1.follow("miselia","leon");
        tes1.follow("miselia","elviana");
        tes1.follow("miselia","chandra");
        tes1.follow("leon","aurelia");
        tes1.follow("leon","elviana");
        tes1.follow("leon","miselia");
        tes1.follow("leon","chandra");
        tes1.follow("retno","miselia");
        tes1.follow("retno","leon");
        tes1.follow("retno","chandra");
        tes1.follow("chandra","retno");
        tes1.follow("chandra","miselia");

        tes1.printList();
        System.out.println();
        System.out.println("list follower ");
        tes1.printlistfollowers();
        System.out.println("most followed human on twitty = "+tes1.mostfollowed());
    //    tes1.printlistfollowers();
      //  tes1.printList();

//        Graf tes=new Graf(11);
//        tes.addEdge(1,2);
//        tes.addEdge(1,3);
//        tes.addEdge(1,4);
//        tes.addEdge(3,4);
//        tes.addEdge(3,6);
//        tes.addEdge(3,8);
//        tes.addEdge(5,6);
//        tes.addEdge(7,8);
//        tes.addEdge(7,2);
//        tes.addEdge(9,10);
//        tes.printList();

    }
}