// test_kernel.cu
extern __device__ float mathop(float & x, float & y, float & z);

__global__ void kernel(float *xvals, float * yvals, float * zvals, float *res)
{

        int tid = threadIdx.x + blockIdx.x * blockDim.x;
        res[tid] = mathop(xvals[tid], yvals[tid], zvals[tid]);
}

__global__ void kernel2(float *xvals, float * yvals, float * zvals, float *res)
{

       kernel<<<1,1>>>(xvals,yvals,zvals,res);
}