package taras_task;

import lombok.SneakyThrows;

import java.io.*;
import java.sql.Time;
import java.util.Random;

public class Part4 {

    static int MAX=0;
    static int M=0;
    static int N=0;


    class MThread extends Thread {

     int MAX;
        int[][] matrix;

        public MThread(int[][] matrix) {
            this.matrix = matrix;
        }

        @SneakyThrows
        public void run() {
            Part4.MAX = findMax();
        }


        public int findMax() throws InterruptedException, IOException {
            Support support = Support.readFile();

            int M =Part4.M;
            int N = Part4.N;
            int max = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    Thread.sleep(1);
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }

            }


            return max;
        }


        public int getMAX() {
            return MAX;
        }
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        try {
            Random rand = new Random();
            Support sup = new Support(4, 100);
            Support support = Support.readFile();
            int M = support.getM();
            int N = support.getN();

            int[][] matrix = new int[M][N];


            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = (rand.nextInt(1000));


                }
            }
                int MAX=0;
            long timestart = System.nanoTime();
            for (int i = 0; i < M; i++) {
             new Part4().new MThread(matrix).start();

            }

            long timeend = System.nanoTime();
            long TIME = (timeend - timestart);

            long timeStart1 = System.nanoTime();

            int MAX1 = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    Thread.sleep(1);
                    if (matrix[i][j] > MAX1) {
                        MAX1 = matrix[i][j];
                    }
                }

            }
            long timeEnd1 = System.nanoTime();
            long TIME1 = timeEnd1 - timeStart1;


            FileWriter fileWriter = new FileWriter("part4.txt", true);

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    fileWriter.write(matrix[i][j] + "\t");
                }
                fileWriter.write("\n");
            }




            fileWriter.flush();
            fileWriter.write("MAX "+MAX +"\n");




            fileWriter.close();
        }catch(Exception e ){
            System.out.println(e.getCause());
        }





    }


    static class Support implements Serializable {
        private int M;
        private int N;


        public static Support readFile() throws IOException {
            try (FileReader fileReader=new FileReader("part4.txt");
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                int symbol = bufferedReader.read();
                Support support=  new Support();
                support.setM(symbol);
                Part4.M=symbol;

                symbol = bufferedReader.read();
                Part4.N=symbol;
                support.setN(symbol);



                try(FileWriter fileWriter = new FileWriter("part4.txt"))
                {
                    fileWriter.write("M " + support.getM());
                    fileWriter.write("\nN "+ support.getN()+"\n");
                    fileWriter.flush();


                }catch(Exception e ){
                    System.err.println(e.getCause());

                }






            return support;

            } catch (Exception e) {
                System.err.println(e.getCause().getMessage());
                return null;
            }


        }

        Support() {
        }

        Support(int M, int N) {
            this.M = M;
            this.N = N;


            writeMN(M, N);

        }


        public void writeMN(int M, int N) {

            try (FileWriter fileWriter = new FileWriter("part4.txt")) {
                Support support = new Support();


                support.setM(M);
                support.setN(N);
                fileWriter.write(M);

                fileWriter.write(N);
                fileWriter.flush();

            } catch (Exception e) {
                System.err.println(e.getCause().getMessage());

            }

        }


        public void setM(int M) {
            this.M=M;


        }

        public void setN(int N) {
            this.N=N;
        }

        public int getM() {
            return M;
        }

        public int getN() {
            return N;
        }


    }


}
