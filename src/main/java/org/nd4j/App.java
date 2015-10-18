package org.nd4j;
import static jcuda.driver.JCudaDriver.*;
import jcuda.*;
import jcuda.driver.*;

public class App
{
    public static void main(String args[])
    {
        JCudaDriver.setExceptionsEnabled(true);

        cuInit(0);
        CUdevice device = new CUdevice();
        cuDeviceGet(device, 0);
        CUcontext context = new CUcontext();
        cuCtxCreate(context, 0, device);

        CUlinkState linkState = new CUlinkState();
        JITOptions jitOptions = new JITOptions();
        cuLinkCreate(jitOptions, linkState);

        String ptxFileName2 = "test_function.ptx";
        String ptxFileName1 = "test_kernel.ptx";

        cuLinkAddFile(linkState, CUjitInputType.CU_JIT_INPUT_PTX, ptxFileName2, jitOptions);
        cuLinkAddFile(linkState, CUjitInputType.CU_JIT_INPUT_PTX, ptxFileName1, jitOptions);

        long sz[] = new long[1];
        Pointer image = new Pointer();
        cuLinkComplete(linkState, image, sz);
        System.out.println("Pointer: " + image);
        System.out.println("CUBIN size: " + sz[0]);

        CUmodule module = new CUmodule();
        cuModuleLoadDataEx(module, image, 0, new int[0], Pointer.to(new int[0]));
        cuLinkDestroy(linkState);

        CUfunction functionKernel = new CUfunction();
        String kernelname = "_Z6kernelPfS_S_S_";
        cuModuleGetFunction(functionKernel, module, kernelname);
        System.out.println("Function: " + functionKernel);
    }
}