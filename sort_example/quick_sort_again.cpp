#include <stdio.h>


void swap_data(int data[],int swap1,int swap2){
    int temp = data[swap1];
    data[swap1]= data[swap2];
    data[swap2] = temp;
}


int* quick_sort(int data[] ,int start,int end){
    int firts = start;
    int last = end;
    if(end > start)
    {
        while (last>firts)
        {
            int pivot = data[start];
            // For F
            while (data[firts] <= pivot && firts <= end && last>=firts)
            {
                firts++;
            }
            // For R
            while(data[last] > pivot && last >= start && last>=firts){
                last--;
            }
            // For swap data in array
            if(firts<last){
                swap_data(data,firts,last);
            }
        }
        swap_data(data,start,last);
        quick_sort(data,start,last-1);
        quick_sort(data,last+1,end);
        
    }
    return data;
    

}



int main(){
    int number[] = {34, 10, 39, 49, 24, 42, 9,0,99};
    int* data = quick_sort(number,0,9-1);
    for(int i=0;i<9;i++){
        printf("%d\n",data[i]);
    }
}