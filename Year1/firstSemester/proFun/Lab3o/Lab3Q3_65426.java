package Lab3o;
class Lab3Q3_65426{
    public static void main(String[] args){
         int c = 0;
         int n = 0;
         int sum5 = 0;
         int sum3 = 0;
         int sumn = 0;
         while (c < 1000) {
            n = c;
            if(c%5 == 0 && c%3 == 0){
                 sumn = c+sumn;
            }
            if(c%5 == 0){
                sum5 = c+sum5;
            }         
            if(c%3 == 0){
                sum3 = c+sum3;
            }
            c++;
         }
         int sumt = sum5+sum3-sumn;
         System.out.println(sumt);
    }
}
