package Lab8;
import java.util.*;

public class Lab8 {
    public static class Cell  {
		// คลาสชื่อ Cell ทพำหน้าที่จำตำแหน่งของเรา 
        int x;
        int y;
        int dist;  	//distance ระยะ
        Cell prev;  //parent cell in the path จุดก่อนหน้าใจเส้นทาง
        Cell(int x, int y, int dist, Cell prev) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.prev = prev;
        }
        
        @Override
        public String toString(){
        	return "(" + x + "," + y + ")";
        }
    }
	//BFS, Time O(n^2), Space O(n^2)
	public static void shortestPath(int[][] matrix, int[] start, int[] end) {
		int sx = start[0], sy = start[1]; // ตำแหน่งจุดเริ่มต้น x , y
		int dx = end[0], dy = end[1]; // ตำแหน่งจุดจบ x , y
		
		//initialize the cells เริ่มทำงาน
	    int m = matrix.length; // ความยาวของ row
	    int n = matrix[0].length; // ความยาวของ colam
	    Cell[][] cells = new Cell[m][n]; // สร้าง 2d arr ตัวที่ที่ความกว้างและยาวเท่ากับอาเรที่รับมา
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (matrix[i][j] != 0) {
	                cells[i][j] = new Cell(i, j, Integer.MAX_VALUE, null); // ใน arr ใหม่ถ้ามันไม่ใช่ 0 ใส่เลขที่เยอะที่สุดของ int เข้าไป
	            }
	        }
	    }
	    //breadth first search
	    LinkedList<Cell> queue = new LinkedList<>(); // สร้างตัวแปล ประเภท linklist เอาไว้เก็บว่าเราเดินไปไหนมาแล้วมั่ง  
	    Cell src = cells[sx][sy]; // src = ตำแหน่งเริ่มต้นของเรา
	    src.dist = 0; // กำหนดระยะที่เราเดิน = 0
	    queue.add(src); // เพิ่มตำแหน่งแรกเข้าไปใช้ linklist
	    Cell dest = null; // ตำแหน่งที่เราเดินผ่านมา = null
	    Cell p; // สร้าง Cell อีกตัวชื่อ p
	    while ((p = queue.poll()) != null) { // ถ้า queue ยังแสดงไม่ครบ
	    	//find destination 
	        if (p.x == dx && p.y == dy) { //ถ้าถึงจุดหมายแล้ว เพิ่มตำแหน่งสุดท้ายแล้วหยุด
	            dest = p;
	            break;
	        }      
			// ลองขยับ ขึ้น ลง ซ้าย ขวา 
	        // moving up
	        visit(cells, queue, p.x - 1, p.y, p);        
	        // moving down
	        visit(cells, queue, p.x + 1, p.y, p);        
	        // moving left
	        visit(cells, queue, p.x, p.y - 1, p);        
	        //moving right
	        visit(cells, queue, p.x, p.y + 1, p);
	    }
	    
	    //compose the path if path exists
	    if (dest == null) { // ถ้าไม่มีตำแหน่งก่อนหน้า (เราอยุ่ที่เดิมไปต่อไม่ได้ ให้ตอบว่าไม่มีเส้นทาง) 
	    	// System.out.println("there is no path.");
            System.out.print("No");
	        return;
	    } else { // ถ้ามีทาง ให้ สร้าง linklist ใหม่ แล้ว เอาทางที่ราเดินใส่เข้าไป
	        LinkedList<Cell> path = new LinkedList<>();
	        p = dest;
	        do {
	            path.addFirst(p);
	        } while ((p = p.prev) != null); // ถ้า ทางที่เราเดินมายังแสดงไม่หมดให้ปริ้นทางออกมา
            // System.out.print(path.size()-1 + " "); // ปริ้นเส้นทาง เป็นตำแหน่ง x , y
            System.out.print("Yes");
	        //System.out.println(path);
	    }
	}
	
	//function to update cell visiting status, Time O(1), Space O(1)
	//ฟังชั่นลองเดิน
	private static void visit(Cell[][] cells, LinkedList<Cell> queue, int x, int y, Cell parent) { 
		//out of boundary
	    if (x < 0 || x >= cells.length || y < 0 || y >= cells[0].length || cells[x][y] == null) {
	        return; //ถ้าเดินติดหิน เดินหลุดขอบ ให้หยุด
 	    }    
		// ถ้าเดินได้
	    //update distance, and previous node
	    int dist = parent.dist + 1; // ระยะทางเพิ่มขึ้น 1
	    Cell p = cells[x][y]; // จำตำแหน่งที่เราเดินไว้
	    if (dist < p.dist) { // อัปเดตระยะทางและเพิ่มจุดที่เราผ่านมาแล้ว เพิ่มจุดใหม่ที่เราเดินเข้า queue
	        p.dist = dist;
	        p.prev = parent;
	        queue.add(p);
	    }
	}
	public static void main(String[] args) { 		
        Scanner sc = new Scanner(System.in);
		int[][] adja ={{ 0, 2, 6, 711, 711, 711, 711 },
{ 2, 0, 711, 5, 711, 711, 711 },
{ 6, 711, 0, 8, 711, 711, 711 },
{ 711, 5, 8, 0, 10, 15, 711 },
{ 711, 711, 711, 10, 0, 6, 2 },
{ 711, 711, 711, 15, 6, 0, 6 },
{ 711, 711, 711, 711, 2, 6, 0 } };

        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                matrix[i][j] = sc.nextInt(); 
            }
        }
        // for (int[] y : matrix)
        // {
        //     System.out.println(Arrays.toString(y));
        // }
	   	sc.close();
	   	//case1, there is no path
	   	int[] start = {0, 0};
	   	int[] end = {0, 0};
        for (int i = 0; i < row; i++)
           {
            for (int j = 0; j < col; j++)
               {
                    if (matrix[i][j] == -1)
                    {
                        start[0] = i;
                        start[1] = j; 
                    }
                    if (matrix[i][j] == 9)
                    {
                        end[0] = i;
                        end[1] = j; 
                    }
               }
           }
	   	// System.out.print("case 1: ");
	   	shortestPath(adja, start, end);
	   
	} 
}