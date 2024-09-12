package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String a[]) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);

        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp=new Blueprint("name1", "punto1",pts);

        Point[] pts2=new Point[]{new Point(12, 34),new Point(10, 10)};
        Blueprint bp2=new Blueprint("name2", "punto2",pts2);

        Point[] pts3=new Point[]{new Point(56, 78),new Point(10, 10)};
        Blueprint bp3=new Blueprint("name3", "punto3",pts3);

        //REGISTRAR PLANOS
        try {
            bps.addNewBlueprint(bp);
            bps.addNewBlueprint(bp2);
            bps.addNewBlueprint(bp3);

        } catch (BlueprintPersistenceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("OBTERNER TODOS LOS PLANOS");
        System.out.println(bps.getAllBlueprints());

        System.out.println("OBTENER PLANO POR AUTOR Y NOMBRE");
        try {
            System.out.println(bps.getBlueprint("name2","punto2"));
        } catch (BlueprintNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("OBTENER TODOS LOS PLANOS DE UN AUTOR");
        try {
            System.out.println(bps.getBlueprintsByAuthor("name3"));
        } catch (BlueprintNotFoundException e) {
            System.out.println(e.getMessage());
        }

       //Creando nuevo plano para ser filtrado

        Point pt = new Point(0, 0);
        Point pt1 = new Point(10, 10);
        Point pt2 = new Point(12, 12);
        Point pt3 = new Point(14, 14);
        Point pt4 = new Point(21, 32);
        Point pt5 = new Point(213, 213);
        Point pt6 = new Point(21, 12);

        Blueprint bp6=new Blueprint("name2", "point2");
        bp6.addPoint(pt4);
        bp6.addPoint(pt5);
        bp6.addPoint(pt6);
        bp6.addPoint(pt6);

        try {
            bps.addNewBlueprint(bp6);
        } catch (BlueprintPersistenceException e) {
            throw new RuntimeException(e);
        }


        System.out.println("FILTRAR PLANOS DE UN AUTOR");
        bps.getBlueprintFiltered(bp6);

        try {
            System.out.println(bps.getBlueprintsByAuthor("name2"));
        } catch (BlueprintNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
