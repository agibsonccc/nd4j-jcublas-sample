// test_function.cu
#include <math.h>
__device__ float mathop(float &x, float &y, float &z)
{
        float res = sin(x) + cos(y) + sqrt(z);
        return res;
}