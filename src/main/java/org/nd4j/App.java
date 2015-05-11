package org.nd4j;

import jcublas.JCublas2;
import jcublas.cublasHandle;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        JCublas2.setExceptionsEnabled(true);
        INDArray ret = Nd4j.create(5);
       //This will break if you run it with jcublas2.
       // ret.mmul(ret.transpose());

        cublasHandle handle = new cublasHandle();
        JCublas2.cublasCreate(handle);
        JCublas2.cublasDestroy(handle);
    }
}
