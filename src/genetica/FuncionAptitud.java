package genetica;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author USRBET
 */
public class FuncionAptitud extends FitnessFunction {

    private double score;

    public FuncionAptitud() {
        score = 0;
    }

    @Override
    protected double evaluate(IChromosome ic) {
        //h.
        Integer c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
        c1 = (Integer) ic.getGene(0).getAllele();
        c2 = (Integer) ic.getGene(1).getAllele();
        c3 = (Integer) ic.getGene(2).getAllele();
        c4 = (Integer) ic.getGene(3).getAllele();
        c5 = (Integer) ic.getGene(4).getAllele();
        c6 = (Integer) ic.getGene(5).getAllele();
        c7 = (Integer) ic.getGene(6).getAllele();
        c8 = (Integer) ic.getGene(7).getAllele();
        c9 = (Integer) ic.getGene(8).getAllele();
        c10 = (Integer) ic.getGene(9).getAllele();
        String valorX = c2.toString() + c3.toString() + c4.toString() + c5.toString();
        String valorY = c7.toString() + c8.toString() + c9.toString() + c10.toString();
        int valorXint = Integer.parseInt(valorX, 2);
        int valorYint = Integer.parseInt(valorY, 2);
        if (c1 == 0) {
            valorXint = -valorXint;
        }
        if (c6 == 0) {
            valorYint = -valorYint;
        }
        //depende del problema
        score = 450 - ((valorXint * valorXint) + (valorYint * valorYint));
        return score;
    }

}
