package comSci;

import java.util.*;
public class Alpha {
    int [][] aj;
    HashMap<Character, Integer> hm;
    Alpha() {
    int [][] arr = {{1, 1, 1, 0, 0, 0},
                    {0, 1, 0, 1, 0, 1}, 
                    {0, 0, 1, 0, 1, 0}, 
                    {0, 0, 0, 1, 1, 1}, 
                    {0, 0, 0, 0, 0, 0}, 
                    {0, 0, 0, 0, 1, 1}};
            aj = arr;
            hm = new HashMap<>();
            hm.put('a',0);
            hm.put('b',1);
            hm.put('c',2);
            hm.put('d',3);
            hm.put('e',4);
            hm.put('f',5);
        }
        public static void main(String [] args) {
          Alpha alph = new Alpha();
          /* Q2 */
          System.out.println(alph.isTran('d','e','f'));
          System.out.println(alph.isTran('d','f','e'));
          System.out.println(alph.isTran('c','d','e'));
          System.out.println(alph.isTran('e','d','c'));
          System.out.println(alph.isTran('a','c','e'));
          System.out.println(alph.isTran('b','d','f'));
          System.out.println(alph.isTran('a','b','c'));
        }
        boolean isTran(char c1, char c2, char c3) {
            if (aj[hm.get(c1)][hm.get(c2)] == 1 && aj[hm.get(c2)][hm.get(c3)] == 1) {
                return true;
            }
          return false;
    } }