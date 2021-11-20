package gerardo.marquez;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadFile {
    private List<Set<Island>> testCases;
    private String pathFile;

    public ReadFile(String pathFile) throws IOException {
        this.pathFile = pathFile;
        testCases = new ArrayList<>();
        int sizeTestCases = 0;

        File doc = new File(pathFile);

        BufferedReader obj = new BufferedReader(new FileReader(doc));

        String strng;
        
        int position = 0;
        HashSet<Island> islands = new HashSet<>();

        while ((strng = obj.readLine()) != null){
            position++;

            if(position == 2){
                int N = Integer.parseInt(strng);

                if(N < 1 && N > 2000){
                    System.out.println("La cantidad de islas del caso de prueba no es correcta");
                    System.exit(4);
                }
                continue;
            }

            if(position == 1){
                int T = Integer.parseInt(strng);
                sizeTestCases = T;
                if(T < 1 && T > 50){
                    System.out.println("La cantidad de casos de prueba no es correcta");
                    System.exit(1);
                }
                continue;
            }

            if(strng.contains(" ")){
                String[] strIsland = strng.split(" ");

                int X = Integer.parseInt(strIsland[0]);
                int Y = Integer.parseInt(strIsland[1]);

                if(X < -10000 && X > 10000){
                    System.out.println("El valor en X esta fuera del limite");
                    System.exit(2);
                }

                if(Y < -10000 && Y > 10000){
                    System.out.println("El valor en Y esta fuera del limite");
                    System.exit(3);
                }


                islands.add( new Island( X, Y) );
            }else{
                int N = Integer.parseInt(strng);

                if(N < 1 && N > 2000){
                    System.out.println("La cantidad de islas del caso de prueba no es correcta");
                    System.exit(4);
                }

                Set<Island> islandsClone = (HashSet)islands.clone();
                this.testCases.add( islandsClone );
                islands.clear();
            }
            
        }

        this.testCases.add(islands);

        if(sizeTestCases != this.testCases.size()){
            System.out.println("La cantidad de casos de prueba son diferentes a la cantidad que hay");
            System.exit(5);
        }
    }

    public List<Set<Island>> getTestCases() {
        return this.testCases;
    }

    public void setTestCases(List<Set<Island>> testCases) {
        this.testCases = testCases;
    }

    public String getPathFile() {
        return this.pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

}
