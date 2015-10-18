#Parallel reduction problem reproduction:
Compile commands:
nvcc -arch=sm_50 -rdc=true -ptx test_function.cu
nvcc -arch=sm_50 -rdc=true -ptx test_kernel.cu
