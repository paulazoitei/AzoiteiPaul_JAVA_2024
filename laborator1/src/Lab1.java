
public class Lab1 {
    public static void main(String[] args) {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        lab1.homework(args);
        lab1.bonus();
    }

    void compulsory() {
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n *= 3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n *= 6;
        while (n > 9) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }


        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);


    }

    void homework(String[] args) {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        int n=0;
        StringBuilder kRedNumbers=new StringBuilder();
        if (args.length != 3) {
            throw new IllegalArgumentException("Numar incorect de parametri");
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        if (a < 0 || b < 0 || k < 0) {
            throw new IllegalArgumentException("Parametrii trebuie să fie întregi pozitivi");
        }
        for (int i = a; i <= b; i++) {
            n=i;
            while (n > 9) {
                sum=0;
                while (n > 0) {
                    sum += (n%10) * (n%10);
                    n /= 10;
                }
                n = sum;
            }
            if(n==k)
            {
                kRedNumbers.append(i);
                kRedNumbers.append(" ");
            }
        }
        System.out.println(kRedNumbers);
        System.out.println();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Timpul de rulare al aplicației: " + totalTime + " milisecunde.");

    }
    void bonus() {
        int n = 5;
        int[][] matriceDeAdiacenta = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matriceDeAdiacenta[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i + 1 || j == i - 1 || (j == n - 1 && j != i) || (i == 0 && j == n - 2)) {
                    matriceDeAdiacenta[i][j] = 1;
                    matriceDeAdiacenta[j][i] = 1;
                }


            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriceDeAdiacenta[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println();

        int nr=4;
        int cnt=1;
        for( int i=1;i<nr-1;i++)
        {
                for (int j = i + 1; j < nr; j++) {

                    cnt = cnt + 2;

                    System.out.print(i);
                    System.out.print(" ");
                    System.out.print(0);
                    System.out.print(" ");
                    System.out.print(j);
                    System.out.print(" ");
                    for(int k=j-1;k>=i+1;k--) {

                        System.out.print(k);
                        System.out.print(" ");
                    }

                    System.out.println();

                    System.out.print(i);
                    System.out.print(" ");
                    System.out.print(0);
                    System.out.print(" ");
                    System.out.print(j);
                    System.out.print(" ");


                    for(int v=(j+1)%nr;v!=i;v=(v+1)%nr) {
                        if(v!=0) {
                            System.out.print(v);
                            System.out.print(" ");

                        }
                    }
                    System.out.println();


                }
        }

        for(int m=1;m<nr;m++)
        {
            System.out.print(m+" ");
        }
        System.out.println();
        if(cnt==(nr*nr)-(3*nr)+3)
        {
            System.out.println("The number of the cicle verify the property!");
        }
        else
        {
            System.out.println("The number of the cicle doesn't verify the property!");
        }
        System.out.println("Exista " + cnt + " circuite.");





    }


}




