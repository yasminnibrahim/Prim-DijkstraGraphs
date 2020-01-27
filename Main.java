/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalds;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        Dijkstra_algo dijkstra = new Dijkstra_algo();
        Prim prim = new Prim();
        while (true) {
            System.out.println("\n*************Enter Your Adjacency matrix graph**************\n");
           Scanner input = new Scanner(System.in);
            System.out.println("Enter number of nodes : ");
            int nodes = input.nextInt();
            int rows = nodes;
            int columns = nodes;
            int adjacency_matrix[][] = new int[rows][columns];
            for (int i = 0; i < adjacency_matrix.length; i++) {
                System.out.printf("Enter %d integers for row %d/%d (delimeted by spaces): \n",
                        columns, i + 1, rows);
                for (int j = 0; j < adjacency_matrix[i].length; j++)
                    adjacency_matrix[i][j] = input.nextInt();
            }
            System.out.println("Enter Your choice : \n(1)MST prim's algorithm\n(2)Shortest path Dijkstra algorithm\n(3)Termninate program");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                        prim.prim_algo(adjacency_matrix);
                        break;
                case 2:
                        System.out.println("You choose dijkstra shortest path algorithm\nEnter Your start node : ");
                        int start = input.nextInt();
                        dijkstra.dijkstra_algo(adjacency_matrix,start);
                        break;
                case 3:
                        exit(0);
            }
        }
    }
}

