package proFunLabTest;

import java.util.*;
import java.util.stream.*;

class ProFun14Employee {
    String name;
    String dept;
    int salary;
    int yearStart;

    ProFun14Employee(String n, String d, int sal, int yr) {
        name = n;
        dept = d;
        salary = sal;
        yearStart = yr;
    }
    String getName() {
        return name;
    }
    int getYearStart() {
        return yearStart;
    }
    String getDepartment() {
        return dept;
    }
    int getSalary() {
        return salary;
    }
    public String toString() {
        return String.format("%s %s(%d) %d", dept, name, yearStart, salary);
    }
}

class ProFun14StreamDemo {
    String sec;
    ArrayList<ProFun14Employee> eList;
    Scanner sc = new Scanner(System.in);
    ProFun14StreamDemo() {
        int n = sc.nextInt();
        eList = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String all = sc.nextLine();
            String[] sp = all.split(" ");
            String name = sp[0];
            String dept = sp[1];
            int year = Integer.parseInt(sp[2]);
            int sal = Integer.parseInt(sp[3]);
            eList.add(new ProFun14Employee(name, dept, year, sal));
        }
        sec = sc.next();
    }

    void oldWay1() {
        //each query for each submission
        //eList is always the sane for all query
       ArrayList<String> stringList = new ArrayList<>();
       for (ProFun14Employee  e : eList) {
            stringList.add(e.getName());
       }
       System.out.println(stringList);
    }

    void oldWay2() {
        //each query for each submission
        //eList is always the sane for all query
       ArrayList<String> list = new ArrayList<>();
       
        for (ProFun14Employee e : eList) {
            if (e.getYearStart() < 2015)
                list.add(e.toString());
        }
        System.out.println(list);
    }

    void oldWay3() {
        //each query for each submission
        //eList is always the sane for all query
        //ArrayList<String> list = new ArrayList<>();
       int a;
       int sum = 0;
        for (ProFun14Employee e : eList) {
            a = e.getSalary();
            sum += a;
        }
        System.out.println(sum);
    }

    void oldWay4() {
        //each query for each submission
        //eList is always the sane for all query
       ArrayList<String> list = new ArrayList<>();
       ArrayList<Integer> lowest = new ArrayList<>();
        for (ProFun14Employee e : eList) {
            lowest.add(e.getSalary());
        }
        lowest.sort(null);
        for (ProFun14Employee f : eList) {
           if (f.getSalary() == lowest.get(0)) {
                list.add(f.toString());
           } 
        }
        System.out.println(list.get(0));
    }

    void oldWay5() {
        //each query for each submission
        //eList is always the sane for all query
       ArrayList<String> list = new ArrayList<>();
        for (ProFun14Employee e : eList) {
           if (e.getDepartment().equals(sec)) {
            list.add(e.toString());
           } 
        }
        System.out.println(list);
    }
        void streamWay() {
        String Query = "Q1 list contain all employee's names";
            System.out.print(Query + " ");
        eList.stream()
                .map(ProFun14Employee::getName).forEach(i -> System.out.print(i + " "));
        System.out.println();

            Query = "Q2 list employee who has started work before 2015";
        int yearThreshold = 2015;
        List<ProFun14Employee> empBefore2015;
        empBefore2015 = eList.stream()
                .filter(e -> e.getYearStart() < yearThreshold)
                .collect(Collectors.toList());
        System.out.print(Query + " ");
        System.out.println(empBefore2015);
        // [IT B(2011) 5000, IT C(2014) 6000]

        Query = "Q3 Compute sum of salaries of employee";
        int x = eList.stream().mapToInt(ProFun14Employee::getSalary).sum();
        System.out.print(Query + " ");
        System.out.printf("%,d%n", x); // 27,000

        Query = "Q4 Employee with lowest salary : ";
        Optional<ProFun14Employee> emp;
        
        emp = Optional.of(eList.stream()
                        .min(Comparator.comparing(ProFun14Employee::getSalary)))
                .get();
        System.out.print(Query + " ");
        System.out.println(emp); // IT B(2011) 5000
        Query = "Q5 List employee who work in given dept-name (same order on eList)";
        List<ProFun14Employee> result = eList.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .collect(Collectors.toList());
        System.out.print(Query + " ");
        System.out.println(result);
    }
}
class Complete {
    public static void main(String[] args) {
        ProFun14StreamDemo demo = new ProFun14StreamDemo();
        System.out.print("Q1: ");
        demo.oldWay1();
        System.out.print("Q2: ");
        demo.oldWay2();
        System.out.print("Q3: ");
        demo.oldWay3();
        System.out.print("Q4: ");
        demo.oldWay4();
        System.out.print("Q5: ");
        demo.oldWay5();
        demo.streamWay();
    }
}