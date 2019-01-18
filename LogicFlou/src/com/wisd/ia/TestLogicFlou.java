package com.wisd.ia;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.*; 

public class TestLogicFlou {
	public static void main(String[] args)
			throws Exception {
		String fileName = "c:/credit.fcl";
	      FIS fis = FIS.load(fileName,true);
	if( fis == null ) {
	          System.err.println("Can't load file: "+ fileName + " ");
	          return;
	      }
	fis.chart(); // Visualiser les partitions floues de fizzification
	//Test:  // Set inputs
	fis.setVariable("age", 40);
	fis.setVariable("salaire", 14000);
	// Evaluate calcul de la décision pour la valeurs de test
	fis.evaluate();
	// affichage de la décision:
	System.out.println(fis.getVariable("Montant_credit").defuzzify());
	fis.getVariable("Montant_credit").chartDefuzzifier(true);

	}
}
