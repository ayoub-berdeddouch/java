package fsdm.wisd.ai.rn;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

public class RN_XOR {
	public static void main(String[] args){
	double XOR_INPUT[][] = {{0.0,0.0},{1.0,0.0},{0.0,1.0},{1.0,1.0}};
	double XOR_IDEAL[][] = {{0.0},{1.0},{1.0},{1.0}};
	double ent[]={1.0,0.0};
	double sor[]={0.0};
	
	BasicNetwork network = new BasicNetwork();
	network.addLayer(new BasicLayer(null,true,2));
	network.addLayer(new BasicLayer(new ActivationSigmoid(),false,3));
	network.addLayer(new BasicLayer(new ActivationSigmoid(),false,1));
	network.getStructure().finalizeStructure();
	network.reset();
	BasicMLDataSet trainingSet = new BasicMLDataSet(XOR_INPUT,XOR_IDEAL);
	ResilientPropagation train = new ResilientPropagation(network, trainingSet);
	int e = 1;

	do {
		train.iteration();
		System.out.println("Itération #" + e + " Error:" + train.getError());
		e++;
	} while(train.getError() > 0.01); // epsilon = 0.01;
	

	// test the neural network
	System.out.println("Neural Network Results:");
	network.compute(ent,sor);
	System.out.println("sortie="+sor[0]);
	
	
	
	
	}
}
