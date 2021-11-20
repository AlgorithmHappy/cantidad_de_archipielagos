package gerardo.marquez;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App 
{
    public static void main( String[] args )
    {
        ReadFile fileTest = null;
        try {
            /** ------------------ Aqui se cambia la ruta "ABSOLUTA" del archivo de prueba ----------------- **/
            fileTest = new ReadFile("C:/Users/Dell/Desktop/prueba.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(6);
        }

        List<Set<Island>> rows = fileTest.getTestCases();

        for(Set<Island> it : rows){
            Set<Archipelago> distinctArchipelagos = new HashSet<>();
            List<Island> jt = new ArrayList<>(it);

            for(int i = 0; i < ( jt.size() - 2 ); i++){
                for(int j = ( i + 1 ); j < ( jt.size() - 1 ); j++){
                    for(int k = (j + 1); k < jt.size(); k++){
                        Archipelago archipelago = new Archipelago(
                            jt.get(i),
                            jt.get(j),
                            jt.get(k));

                        if(archipelago.getEqualLength())
                            distinctArchipelagos.add(archipelago);
                    }
                }
            }

            System.out.println(distinctArchipelagos.size());
        }

    }
}
