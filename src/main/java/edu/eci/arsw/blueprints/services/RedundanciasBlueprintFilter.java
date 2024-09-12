package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.impl.Tuple;
import org.springframework.stereotype.Service;



@Service

public class RedundanciasBlueprintFilter implements BlueprintFilter{

    @Override
    public Blueprint getFilteredBlueprint(Blueprint bp)   {

        Point currentPoint = null;
        Point nextPoint = null;
        int xCurrent = 0;
        int yCurrent = 0;
        int xNext = 0;
        int yNext = 0;
        for (int i = 0; i < bp.getPoints().size() - 1; i++) {
            currentPoint = bp.getPoints().get(i);
            xCurrent = currentPoint.getX();
            yCurrent = currentPoint.getY();
            nextPoint = bp.getPoints().get(i+1);
            xNext = nextPoint.getX();
            yNext = nextPoint.getY();

            if (xCurrent == xNext && yCurrent == yNext) {
                bp.removePoint(i+1);
                i--;
            }
        }

        return bp;
    }
}
