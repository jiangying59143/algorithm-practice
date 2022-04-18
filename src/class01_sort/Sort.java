package class01_sort;

public class Sort {
    public static void Bubble(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            for(int j=0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void selection(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap2(arr, i, minIndex);
        }
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--) {
                swap(arr, j, j+1);
            }
        }
    }

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int help[] = new int[arr.length];
        processMerge(arr, 0, arr.length -1, help);
        for (int i = 0; i < help.length; i++) {
            arr[i] = help[i];
        }

    }

    public static void processMerge(int[] arr, int L, int R, int[] help){
        if(L >= R){
            return;
        }
        int M = L + ((R-L)>>1);
        processMerge(arr, L, M, help);
        processMerge(arr, M+1, R, help);
        merge(arr, L, M, R, help);
    }

    public static void merge(int[] arr, int L, int M, int R, int[] help){
        int helpIndex = L;
        int leftIndex = L;
        int rightIndex = M+1;
        while(leftIndex<=M && rightIndex<=R){
            if(arr[leftIndex] > arr[rightIndex]){
                help[helpIndex++] = arr[rightIndex++];
            }else{
                help[helpIndex++] = arr[leftIndex++];
            }
        }

        while(leftIndex <= M){
            help[helpIndex++] = arr[leftIndex++];
        }

        while(rightIndex<=R){
            help[helpIndex++] = arr[rightIndex++];
        }
    }

    public static void quickSort(int[] arr){
        processQuick(arr, 0, arr.length - 1);
    }

    public static void processQuick(int[] arr, int L, int R){
        int partition = L + (int)Math.random()*(R-L+1);
        swap(arr, partition, R);
        int[] equArea = equalArea(arr, L, R);
        processQuick(arr, L, equArea[0]-1);
        processQuick(arr, equArea[1]+1, R);
    }

    public static int[] equalArea(int[] arr, int L, int R){
        if(L>R){
            return new int[]{-1,-1};
        }
        if(L == R){
            return new int[]{L, R};
        }
        int lessIndex = L-1;
        int moreIndex = R;
        int index = L;
        while(index < moreIndex){
            if(arr[index]==arr[R]){
                index ++;
            }else if(arr[index] < arr[R]){
                swap(arr, ++lessIndex, index++);
            }else{
                swap(arr, index, --moreIndex);
            }
        }
        swap(arr, moreIndex, R);
        return new int[]{lessIndex+1, moreIndex};
    }

    public static void heapSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        swap2(arr, 0, arr.length-1);
        int j = arr.length-1;
        for (int i = 0; i < j; i++) {
            heapify(arr, 0, j);
            swap2(arr, 0, --j);
        }
    }

    public static void heapInsert(int[] arr, int i){
        while(arr[i] > arr[(i-1)/2]){
            swap2(arr, i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    public static void heapify(int[] arr, int i, int heapSize){
        while(2*i+1 < heapSize){
            int rightIndex = 2*i +2;
            int maxIndex = rightIndex >= heapSize || arr[2*i+1] > arr[rightIndex] ? 2*i+1 : rightIndex;
            if(arr[i] < arr[maxIndex]){
                swap2(arr, i, maxIndex);
                i=maxIndex;
            }
        }
    }

    public static void RadixSort(int[] arr){

    }

    public static int getMaxBit(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        int res = 0;
        while(max != 0){
            res++;
            max /=10;
        }
        return res;
    }

    public static void processRadix(int[] arr, int bit){
        int buckets[] = new int[10];
        int[] help = new int[arr.length];
        for (int b = 1; b <= bit; b++) {
            for (int i = 0; i < arr.length; i++) {
                buckets[getBitNumber(arr[i], b)]++;
            }
            for (int i = 1; i < buckets.length; i++) {
                buckets[i] += buckets[i-1];
            }
            for (int j = arr.length-1; j >= 0; j--) {
                help[buckets[getBitNumber(arr[j], b)]-- -1] = arr[j];
            }
            for (int i = 0; i < help.length; i++) {
                arr[i] = help[i];
            }

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = 0;
            }
        }
    }

    public static int getBitNumber(int x, int b){
        return x / (int)Math.pow(10, b-1) % 10;
    }




    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void swap2(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
