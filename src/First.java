package nineteenthlesson;
import java.util.Scanner;
import java.util.Random;
public class First {
        public static int [] winnie (int days, int volume, int handful) {
            if (days == 0 || volume == 0 || handful ==  0)
                throw new IllegalArgumentException("arguments of winnie () are 0");
            if (days < 0 || volume < 0 || handful <  0)
                throw new IllegalArgumentException("arguments of winnie () are negative");
            int i;
            int summ;
            int Summ;
            int hand;
            int [] res = new  int[3];
            Summ = 0;
            summ = volume;
            hand = handful;
            for (i=1; i<= days; i++) {
                if (summ>0) {
                    if (i == 1) {
                        summ = volume;
                        System.out.println("шаг " + i + " summ = " +summ + " handful =" + handful);
                    } else {
                        summ = volume - hand;
                        hand = hand + handful;
                        System.out.println("шаг " + i + " summ = " +summ+ " handful =" + handful);
                    }
                    if (summ > 0) {
                        Summ = summ + Summ;
                        //ЛОГИРОВАНИЕ
                        System.out.print("День " + i + ": " + summ + " горстей донес.");
                        System.out.println("В бочке " + Summ + " горстей.");
                        System.out.println("шаг " + i + " summ = " +summ+ " handful =" + handful);
                    }
                }
                if (summ <=0  && i >1) {
                    System.out.println("шаг " + i + " summ = " +summ+ " handful =" + handful);
                    break;
                }
            }
            res [0] = i;
            res [1] = Summ;
            res [2] = summ;
            return res;
        }
        private static void test1 () {
            System.out.println("test1:");
            Random rand = new Random();
            for (int i=0; i<100000; i++)
                try {
                    winnie (rand.nextInt(50)+1, rand.nextInt(50)+1, rand.nextInt(50)+1);
                    System.out.println("TEST1 PASS");
                } catch (Throwable exc) {
                    System.out.println("TEST1 FAIL");
                }
        }
        private static void test2 () {
            System.out.println("test2: ");
            int [] a  = winnie(2147483647, 2147483647, 2147483647);
            System.out.println(a[0]);
            System.out.println(a[1]);
            System.out.println(a[2]);
            if (a[0]==2 && a[1] ==2147483647 && a[2] ==0)
                System.out.println("TEST2 passed");
            else
                System.out.println("TEST2 failed");
        }
        private static void test3 () {
            System.out.println("test3: ");
            try {
                winnie(0, 0, 0);
                System.out.println("TEST3 PASS");
            } catch (IllegalArgumentException e) {
                System.out.println("TEST3 FAIL");
            }
        }
        private static void test4 () {
            System.out.println("test4: ");
            int [] t4 = winnie(4, 8, 3);
            System.out.println("t4[0] equals " + t4[0]);
            System.out.println("t4[1] equals " + t4[1]);
            System.out.println("t4[2] equals " + t4[2]);
            if (t4[0]==4 && t4[1] ==15 && t4[2] == -1)
                System.out.println("TEST4 passed");
            else
                System.out.println("TEST4 failed");
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner (System.in);
            System.out.println("Введите число дней, объем горшочка, количество выедаемых горстей.");
            int N;
            int X;
            int Y;
            N = scanner.nextInt();
            X = scanner.nextInt();
            Y = scanner.nextInt();
            int [] a  = winnie(N, X, Y);
            if (a [2]<=0) {
                System.out.println(" ");
                System.out.print("В бочке " + a[1] + " горстей меда.");
                System.out.println("Горшочек пустой с " + a[0] + " дня.");
            } else
                System.out.println("В горшочке еще остался мед");
            test1();
            test2();
            test3();
            test4();
        }
    }


