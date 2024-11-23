// #189 轮转数组
/*
轮转需要考虑：取模运算
*/
void rotate(int* nums, int numsSize, int k) {
    k = k % numsSize;
    int* b=(int*)malloc(k*sizeof(int));
    for(int i=0;i<k;i++){
        b[i]=nums[numsSize-k+i];
    }
    for(int j=numsSize-1;j>=k;j--){
        nums[j]=nums[j-k];
    }
    for(int l=0;l<k;l++){
        nums[l]=b[l];
    }
    free(b);
}
