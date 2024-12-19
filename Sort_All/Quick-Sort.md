
> [!NOTE] Source Code of Quick-sort  
> This's Quick-Sort Algorithm Write By C++ Language 

```
#include <stdio.h>
void swap_array(int data[],int swap1,int swap2){

    int temp = data[swap1];

    data[swap1] = data[swap2];

    data[swap2] = temp;
}
int* quick_sort(int data[],int start,int end){
    int f = start;
    int r = end;
    if(end > start){
        int pivot = data[start];
        while(r > f){
            while(data[f] <= pivot && f<= end && r>f){
                f++;
            }
            while(data[r] > pivot && r >= start && r>=f){
                r--;
            }
            if(r>f){
                swap_array(data,f,r);
            }
        }
        swap_array(data,start,r);
        quick_sort(data,start,r-1);
        quick_sort(data,r+1,end);
    }
    return data;
}

int main(){
    int number[] = { 34, 10, 39, 49, 24, 42, 9, 0, 99};
    int* data = quick_sort(number,0,9-1);
    for(int i=0;i<9;i++){
        printf("%d\n",data[i]);
    }
}
```

## #Info Algorithm

- swap-array #method 
- quick-sort #method


#### Example Data Array
> This's Data Array length 9 digits for "Test" Quick Sort Algorithm.

```
int number[] = { 34, 10, 39, 49, 24, 42, 9, 0, 99};
```

#### Swap-array Method 
> This's Method for swap value from index to other index.

```
void swap_array(int data[],int swap1,int swap2){
    int temp = data[swap1];
    data[swap1] = data[swap2];
    data[swap2] = temp;
}
```

### Description
> This's Description "swap-array()" 
##### Parameter of Method => swap-array(data,swap1,swap2)
	-> data เป็น Array ที่ต้องสลับตำแหน่ง
	-> swap1 เป็น index ที่ต้องการสลับตัวแรก
	-> swap2 เป็น index ที่ต้องการสลับตัวที่สอง
	
#### Examples of Usage Method

```
int data[] = { 34, 10, 39, 49, 24, 42, 9, 0, 99};
swap1 = 0
swap2 = 8

int temp = data[swap1] ; # value = 34
# temp = 34
data[swap1] = data[swap2]; # data[swap1] = 99
data[swap2] = temp; # data[swap2] = 34
```


### Quick - Sort Method
> This's Method of Sort and can Sort fastest in The World.

```
int* quick_sort(int data[],int start,int end){
    int f = start;
    int r = end;
    if(end > start){
        int pivot = data[start];
        while(r > f){
            while(data[f] <= pivot && f<= end && r>f){
                f++;
            }
            while(data[r] > pivot && r >= start && r>=f){
                r--;
            }
            if(r>f){
                swap_array(data,f,r);
            }
        }
        swap_array(data,start,r);
        quick_sort(data,start,r-1);
        quick_sort(data,r+1,end);
    }
    return data;
}
```

### Description
> This's Description "quick-sort()" 
##### Parameter of Method => Quick-Sort(data,start,end)
	-> data เป็น Array ที่ต้อง Sort
	-> start เป็น index ตัวแรกที่ต้องการ sort
	-> end เป็น index ตัวสุดท้ายที่ต้องการ sort


#### Examples of Usage Method

```
int* quick_sort(int data[],int start,int end){
	{ 34, 10, 39, 49, 24, 42, 9, 0, 99};
	
    int f = start; f = 0
    int r = end; r = 8
    if(end > start){ 8 > 0 = true
        int pivot = data[start]; pivot = 34
        while(r > f){ 
	    
	        8 > 0 = true รอบ 1  
	       
	        7 > 2 = true รอบ 2

			6 > 3 = true รอบ 3
	       
            while(data[f] <= pivot && f<= end && r>f){
	            8 > 0 = true
	            { 34, 10, 39, 49, 24, 42, 9, 0, 99}; 
	            data[f] <= pivot && f<= end && r>f
				รอบ 1 f=0 34 <= 34 && 0 <= 8 && 8 > 0 = true f++;
				รอบ 2 f=1 10 <= 34 && 1 <= 8 && 8 > 1 = true f++;
				รอบ 3 f=2 39 <= 34 && 2 <= 8 && 8 > 2 = false 
	
				7 > 2 = true 
				{ 34, 10, 0, 49, 24, 42, 9, 39, 99};
				data[f] <= pivot && f<= end && r>f
				รอบ 1 f=2 0 <= 34 && 2 <= 7 && 7 > 2 = true f++;
				รอบ 2 f=3 49 <= 34 && 3 <= 7 && 7 > 3 = false 

				6 > 3 = true
				{ 34, 10, 0, 9, 24, 42, 49, 39, 99};
				data[f] <= pivot && f<= end && r>f
				รอบ 1 f=3 9 <= 34 && 3 <= 6 && 6 > 3 = true f++;
				รอบ 2 f=4 24 <= 34 && 4 <= 6 && 6 > 4 = true f++;
				รอบ 3 f=5 42 <= 34 && 5 <= 6 && 6 > 5 = false
			
                f++;
            }
            while(data[r] > pivot && r >= start && r>=f){
		        8 > 0 = true 
		        { 34, 10, 39, 49, 24, 42, 9, 0, 99};
				data[r] > pivot && r >= start && r>=f
				รอบ 1 r=8 99 > 34 && 8 >= 0 && 8>=2 true r--;
				รอบ 2 r=7 0 > 34 && 7 >= 0 && 7>=2 false 


				7 > 2 = true 
		        { 34, 10, 0, 49, 24, 42, 9, 39, 99};
				data[r] > pivot && r >= start && r>=f
				รอบ 1 r=7 39 > 34 && 7 >= 0 && 7 >= 3 true r--;
				รอบ 2 r=6 9 > 34 && 6 >= 0 && 6>=2 false 


				6 > 3 = true
				{ 34, 10, 0, 9, 24, 42, 49, 39, 99};
				data[r] > pivot && r >= start && r>=f
				รอบ 1 r=6 49 > 34 && 6 >= 0 && 6 >= 5 true r--;
				รอบ 2 r=5 42 > 34 && 5 >= 0 && 5 >= 5 true r--;
				รอบ 3 r=4 24 > 34 && 4 >= 0 && 4 >= 5 false 
                r--;
            }
            
            สรุป สองรอบ F & R 2 & 7
           { 34, 10, F[39], 49, 24, 42, 9, R[0], 99};
           
			สรุป สองรอบ F & R 3 & 6
			{ 34, 10, 0, F[49], 24, 42, R[9], 39, 99};

			สรุป สองรอบ F & R 5 & 4
			{ 34, 10, 0, 9, [24], [42], 49, 39, 99};

            if(r>f){ 
	            7 > 2 true
	            6 > 3 true
	            4 > 5 false
                swap_array(data,f,r);
            }
            
            สรุป เมื่อสลับค่า
            8 > 0 = true
           { 34, 10, [0], 49, 24, 42, 9, [39], 99};
           7 > 2 = true 
           { 34, 10, 0, [9], 24, 42, [49], 39, 99};
           6 > 3 = true 
           none swap
        }
        f=5
        r=4
        swap_array(data,start,r); segment 
		{ 34, 10, 0, 9, 24, 42, 49, 39, 99};
		{ [24], 10, 0, 9, [34], 42, 49, 39, 99};
		
        quick_sort(data,start,r-1);
		{ [24, 10, 0, 9], [34], 42, 49, 39, 99};
        quick_sort(data,r+1,end);
        { 24, 10, 0, 9, [34], [42, 49, 39, 99]};
     
    }
    return data;
}
int main(){
    int number[] = { 34, 10, 39, 49, 24, 42, 9, 0, 99};
    int* data = quick_sort(number,0,9-1);
}


```

```
quick_sort(data,start,r-1);
{ [24, 10, 0, 9], [34], 42, 49, 39, 99};

int* quick_sort(int data[],int start,int end){
    int f = start; f = 0
    int r = end; r = 3
    if(end > start){ 3 > 0 = true
        int pivot = data[start];  = 24
        while(r > f){ 
		     รอบ 1 r > 0 = true
		     
            while(data[f] <= pivot && f<= end && r>f){
	            data[f] <= pivot && f<= end && r>f
	            
                f++;
            }
            while(data[r] > pivot && r >= start && r>=f){
                r--;
            }
            if(r>f){
                swap_array(data,f,r);
            }
        }
        swap_array(data,start,r);
        quick_sort(data,start,r-1);
        quick_sort(data,r+1,end);
    }
    return data;
}
```

