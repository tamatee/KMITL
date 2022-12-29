package proFun.Lab12o;

public class Coin_650426 {
    public static void main(String[] args) {
     Coin c4 = new Coin();
     System.out.println(c4.getColor());
    }
}
// Code From Me
// class Coin {
//     String color;
//     String colorHead = "Red";
//     String mem = colorHead;
//     String colorTail = "Red";
//     Coin()
//     {
//         this.color = null;
//     }
//     Coin(String color) {
//         this.color = color;
//     }
//     String getColor(String color)
//     {
//         this.color = color;
//         return color;
//     }
//     void setColor(String color)
//     {
//         this.color = color;
//     }
//     void flip()
//     {
//         colorHead = colorTail;
//         colorTail = mem;
//     }
// }
//coin From Po
class Coin{
    String colorHead = "red";
    String colorTail = "red";
    /*---------- */
    Boolean isHead = true;
    /*---------- */
    Coin(){
        setColor(colorHead);
    }
    Coin(String color){
        setColor(color);
    }
    String getColor(){
        if(isHead) return colorHead;
        else return colorTail;
    }
    void setColor(String color){
        if(isHead) colorHead = color;
        else colorTail = color;
    }
    void flip(){
        isHead = !isHead;
    }
    public String toString(){
        String seeingColor = "";
        if(isHead==true)  seeingColor = colorHead;
        else seeingColor = colorTail;

        return "This is coin object, the color you are seeing is " + seeingColor + ".";
    }
}
