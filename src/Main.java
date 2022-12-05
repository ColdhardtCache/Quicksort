public class Main {
    public static void main(String[] args) {
        int[] nums = {1,8,4,3,9,7};
        quickSort(nums,0,nums.length-1);
        for(int num: nums){
            System.out.print(num + " ");
        }

    }
    public static void quickSort(int[]nums, int lowIndex, int highIndex){
        if(lowIndex >= highIndex){
            return;
        }
        int partition = nums[highIndex];
        int lp = lowIndex;
        int rp = highIndex;
        while (lp < rp){
            while (nums[lp] <= partition && lp < rp){
                ++lp;
            }
            while (nums[rp] >= partition && lp < rp){
                --rp;
            }
            swap(nums,lp,rp);
        }
        swap(nums, lp, highIndex);
        quickSort(nums, lowIndex, lp-1); // Left recursive call
        quickSort(nums,lp+1,highIndex); // Right recursive call
    }
    public static void swap(int[] nums, int index1, int index2){
        if(index1 == index2) {
            return;
        }
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
    }
}