package genetica;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author USRBET
 */
public class AlgoritmoGenetico {

    public void configuracionAG() {
        try {
            //configurar AG y fijar la FA
            Configuration configuracion = new DefaultConfiguration();
            configuracion.setFitnessFunction(new FuncionAptitud());
            //genes//[]
            Gene[] genEjemplo = new Gene[10];
            genEjemplo[0] = new IntegerGene(configuracion, 0, 1);
            genEjemplo[1] = new IntegerGene(configuracion, 0, 1);
            genEjemplo[2] = new IntegerGene(configuracion, 0, 1);
            genEjemplo[3] = new IntegerGene(configuracion, 0, 1);
            genEjemplo[4] = new IntegerGene(configuracion, 0, 1);
            genEjemplo[5] = new IntegerGene(configuracion, 0, 1);
            genEjemplo[6] = new IntegerGene(configuracion, 0, 1);
            genEjemplo[7] = new IntegerGene(configuracion, 0, 1);
            genEjemplo[8] = new IntegerGene(configuracion, 0, 1);
            genEjemplo[9] = new IntegerGene(configuracion, 0, 1);

            Chromosome chromosome = new Chromosome(configuracion, genEjemplo);
            //fijar el chromosome a la configuracion
            configuracion.setSampleChromosome(chromosome);
            //poblacion inicial
            configuracion.setPopulationSize(100);
            Genotype population = Genotype.randomInitialGenotype(configuracion);
            for (int i = 0; i < 10; i++) {//Generaciones
                System.out.println("*********Generación: " + i + " *********");
                imprimirTodos(population.getChromosomes());
                population.evolve();//evolucionar
                System.out.println("El mejor es: ");
                imprimirIndividuo(population.getFittestChromosome());//el mejor
                System.out.println("****************************");
            }
            System.out.println("El mejor Individuo es: ");
            imprimirIndividuo(population.getFittestChromosome());//el mejor
            System.out.println("****************************");

        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(AlgoritmoGenetico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void imprimirTodos(IChromosome[] iChromosome) {

        for (IChromosome iChromosome1 : iChromosome) {
            imprimirIndividuo(iChromosome1);
        }

    }

    public void imprimirIndividuo(IChromosome iChromosome1) {
        Integer c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
        c1 = (Integer) iChromosome1.getGene(0).getAllele();
        c2 = (Integer) iChromosome1.getGene(1).getAllele();
        c3 = (Integer) iChromosome1.getGene(2).getAllele();
        c4 = (Integer) iChromosome1.getGene(3).getAllele();
        c5 = (Integer) iChromosome1.getGene(4).getAllele();
        c6 = (Integer) iChromosome1.getGene(5).getAllele();
        c7 = (Integer) iChromosome1.getGene(6).getAllele();
        c8 = (Integer) iChromosome1.getGene(7).getAllele();
        c9 = (Integer) iChromosome1.getGene(8).getAllele();
        c10 = (Integer) iChromosome1.getGene(9).getAllele();
        String signoX = "+", signoY = "+";
        if (c1 == 0) {
            signoX = "-";
        }
        if (c6 == 0) {
            signoY = "-";
        }
        String valorX = c2.toString() + c3.toString() + c4.toString() + c5.toString();
        String valorY = c7.toString() + c8.toString() + c9.toString() + c10.toString();
        int valorXint = Integer.parseInt(valorX, 2);
        int valorYint = Integer.parseInt(valorY, 2);
        System.out.println(signoX + "" + valorXint + ";" + signoY + "" + valorYint);
    }

}
