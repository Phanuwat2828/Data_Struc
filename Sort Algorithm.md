
# Bubble Sort

**หลักการทำงานของ Bubble Sort**  เป็นอัลกอริทึมที่ง่ายที่สุดสำหรับการเรียงลำดับ โดยทำงานดังนี้:

- เปรียบเทียบค่าที่อยู่ติดกันในอาร์เรย์
- ถ้าค่าข้างหน้ามากกว่าค่าข้างหลัง ให้สลับตำแหน่ง
- ทำซ้ำขั้นตอนนี้จนกว่าจะไม่มีการสลับตำแหน่งในรอบนั้น (แปลว่าอาร์เรย์เรียงลำดับแล้ว)
### **ตัวอย่าง**

สมมติว่าเรามีอาร์เรย์:  
`[64, 34, 25, 12, 22, 11, 90]`

1. **รอบที่ 1**:
    - เปรียบเทียบ 64 กับ 34: สลับ (34, 64, ...)
    - เปรียบเทียบ 64 กับ 25: สลับ (34, 25, 64, ...)
    - ทำซ้ำจนค่าที่มากที่สุด (90) "ลอยขึ้น" ไปอยู่ตำแหน่งท้ายสุด
    - อาร์เรย์หลังรอบนี้: `[34, 25, 12, 22, 11, 64, 90]`
2. **รอบที่ 2**:
    - เปรียบเทียบและสลับค่าที่เหลือ (ยกเว้น 90 เพราะเรียงลำดับแล้ว)
    - อาร์เรย์หลังรอบนี้: `[25, 12, 22, 11, 34, 64, 90]`
3. ทำซ้ำจนไม่มีการสลับตำแหน่งในรอบใดเลย



```c
void bubbleSort(int array[], int size) {  
     for (int step = 0; step < size - 1; ++step) {  
         int swapped = 0;  
        for (int i = 0; i < size - step - 1; ++i) {  
            if (array[i] > array[i + 1]) {  
                int temp = array[i];  
                array[i] = array[i + 1];  
                array[i + 1] = temp;  
                swapped = 1;  
             }  
         }  
  
        if (swapped == 0) {  
             break;  
         }  
     }  
}
```

# Print data

```c
void printArray(int array[], int size) {  
    for (int i = 0; i < size; ++i) {  
        printf("%d ", array[i]);  
    }  
    printf("\n");  
}
```

# main

```c
#include <stdio.h>

int main() {  
    int arr[] = {64, 34, 25, 12, 22, 11, 90};  
    int n = sizeof(arr) / sizeof(arr[0]);  
  
    printf("Original array: ");  
    printArray(arr, n);  
  
    bubbleSort(arr, n);  
  
    printf("bubbleSort Sorted array: ");  
    printArray(arr, n);  
  
    return 0;  
}
```

# Selection Sort

**หลักการทำงาน**  แต่ละรอบของอัลกอริทึม:

- ค้นหาค่าที่เล็กที่สุดในส่วนที่ยังไม่ได้เรียงลำดับ
- นำค่านั้นไปสลับกับค่าที่ตำแหน่งเริ่มต้นของส่วนที่ยังไม่ได้เรียงลำดับ

**ตัวอย่าง**  
สมมติว่าเรามีอาร์เรย์:  
`[64, 25, 12, 22, 11]`

1. รอบที่ 1: หาค่าที่เล็กที่สุด (`11`) แล้วสลับกับค่าตำแหน่งแรก:  
    `=> [11, 25, 12, 22, 64]`
2. รอบที่ 2: หาค่าที่เล็กที่สุด (`12`) แล้วสลับกับค่าตำแหน่งที่สอง:  
    `=> [11, 12, 25, 22, 64]`
3. รอบที่ 3: หาค่าที่เล็กที่สุด (`22`) แล้วสลับกับค่าตำแหน่งที่สาม:  
    `=> [11, 12, 22, 25, 64]`
4. รอบที่ 4: หาค่าที่เล็กที่สุด (`25`) แล้วสลับกับค่าตำแหน่งที่สี่:  
    `=> [11, 12, 22, 25, 64]`



```c
void selectionSort(int arr[], int n) {  
    for (int i = 0; i < n - 1; i++) {  
        int minIndex = i;  
        for (int j = i + 1; j < n; j++) {  
            if (arr[j] < arr[minIndex]) {  
                minIndex = j;  
            }  
        }  
        int temp = arr[minIndex];  
        arr[minIndex] = arr[i];  
        arr[i] = temp;  
    }  
}
```

# Print data

```c
void printArray(int array[], int size) {  
    for (int i = 0; i < size; ++i) {  
        printf("%d ", array[i]);  
    }  
    printf("\n");  
}
```

# main

```c
#include <stdio.h>

int main() {  
    int arr[] = {64, 34, 25, 12, 22, 11, 90};  
    int n = sizeof(arr) / sizeof(arr[0]);  
  
    printf("Original array: ");  
    printArray(arr, n);  
  
    selectionSort(arr, n);  
  
    printf("selectionSort Sorted array: ");  
    printArray(arr, n);  
  
    return 0;  
}
```

# Insertion Sort

### **Insertion Sort**

**หลักการทำงาน**  แต่ละรอบของอัลกอริทึม:

- นำค่าตัวถัดไปในส่วนที่ยังไม่ได้เรียงลำดับมาเปรียบเทียบกับค่าทั้งหมดในส่วนที่เรียงลำดับแล้ว
- สอดแทรก (Insert) ค่าดังกล่าวในตำแหน่งที่เหมาะสมในส่วนที่เรียงลำดับ

**ตัวอย่าง**  
สมมติว่าเรามีอาร์เรย์:  
`[12, 11, 13, 5, 6]`

1. รอบที่ 1: เริ่มต้นจากค่าที่สอง (`11`) แล้วเปรียบเทียบกับค่าก่อนหน้า (`12`):  
    `=> [11, 12, 13, 5, 6]`
2. รอบที่ 2: นำค่าที่สาม (`13`) มาเปรียบเทียบ (`13` อยู่ในตำแหน่งที่ถูกต้องแล้ว):  
    `=> [11, 12, 13, 5, 6]`
3. รอบที่ 3: นำค่าที่สี่ (`5`) มาเปรียบเทียบกับค่าทั้งหมดในส่วนที่เรียงลำดับแล้ว:  
    `=> [5, 11, 12, 13, 6]`
4. รอบที่ 4: นำค่าที่ห้า (`6`) มาเปรียบเทียบกับค่าทั้งหมดในส่วนที่เรียงลำดับแล้ว:  
    `=> [5, 6, 11, 12, 13]`

```c
void insertionSort(int arr[], int n) {  
     for (int i = 1; i < n; i++) {  
         int key = arr[i];  
         int j = i - 1;  
  
         while (j >= 0 && arr[j] > key) {  
             arr[j + 1] = arr[j];  
             j--;  
         }  
         arr[j + 1] = key;  
     }  
}
```

# Print data

```c
void printArray(int array[], int size) {  
    for (int i = 0; i < size; ++i) {  
        printf("%d ", array[i]);  
    }  
    printf("\n");  
}
```

# main

```c
#include <stdio.h>

int main() {  
    int arr[] = {64, 34, 25, 12, 22, 11, 90};  
    int n = sizeof(arr) / sizeof(arr[0]);  
  
    printf("Original array: ");  
    printArray(arr, n);  
  
    selectionSort(arr, n);  
  
    printf("insertionSort Sorted array: ");  
    printArray(arr, n);  
  
    return 0;  
}
```