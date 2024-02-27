
public class Lab1 {
    public static void main(String[] args) {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        lab1.homework(args);
        lab1.bonus(args);
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
    void bonus(String [] args)
    {
       int n=5;
        int[][] matriceDeAdiacenta = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                matriceDeAdiacenta[i][j]=0;
            }
        }
        for( int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==i+1 || j==i-1 || (j==n-1 && j!=i) || (i==0 && j==n-2))
                {
                    matriceDeAdiacenta[i][j]=1;
                    matriceDeAdiacenta[j][i]=1;
                }


            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matriceDeAdiacenta[i][j]+" ");

            }
            System.out.println();
        }

    }
}


