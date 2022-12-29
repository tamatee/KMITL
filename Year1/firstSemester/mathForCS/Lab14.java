package mathForCS;
class Lab14 {

    public static void main(String[] args) {
        MyFixedPoint a = new MyFixedPoint();
        MyFloatingPoint b = new MyFloatingPoint();
        // b.adds(12);
        // System.out.println(a);
        long startTime = System.nanoTime();
        b.getReal();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("MyDloatingPoint: "+ duration + "ms");
        startTime = System.nanoTime();
        a.getReal();
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("MyFixedPoint: "+ duration + "ms");
        
    }
    
    static class MyFixedPoint {
        int data;

        MyFixedPoint() {
            this.data = 0;
        }
        MyFixedPoint(int data) {
            this.data = data;
        }
        float getReal() {
            return data/1000.0f;
        }
        void adds(int f2) {
            data = data + f2;
        }
        
        void subtracts(float f2) {
            data -= (int)(f2);
        }
        
        void multiplies(float f2) {
            data *= (int)(f2);
        }
        
        void divides(float f2) {
           data /= (int)(f2);
        }
        public String toString () {
            return String.format("%d", data);
        }
    }

    static class MyFloatingPoint {
        float data;

        float getReal() {
            return data;
        }
        
        void adds(float f2) {
            data = data + f2;
        }
        
        void subtracts(float f2) {
            data = data - f2;
        }
        
        void multiplies(float f2) {
            data = data * f2;
        }
        
        void divides(float f2) {
           data = data / f2;
        }
        public String toString () {
            return String.format("%d", data);
        }
    }
}