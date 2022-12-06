/*
Brian Grier-GrierTechSolutions
Professor Stanley Bridgewater State Uni
12/5/2022
Version 1.0
 */

//Standard main function
public class Main {
    public static void main(String[] args) {
        // Manually creates and Integer Array of unsorted numbers that will be used to test quicksort
        int[] nums = {1,8,4,3,9,7};
        /*
        quicksort function has 3 parameters that will be explained later
         1) the array that needs to be sorted
         2) the lowest index (start of the list i.e 1)
         3) the highest index (end of the list i.e 7)
         */
        //NOTE: This method will not work until created later
        quickSort(nums,0,nums.length-1);
        /*
         Uses a 'for loop' to print of every number in the list
         This reads "for each item/integer in nums (the array); do this
        */
        for(int num: nums){
            //print out the number with a space after it to read easier
            System.out.print(num + " ");
        }

    }
    /*
    Now we create our method
    The return type is void because we do not want the function to return a value, just sort an already created list
    1) First it needs to an array to sort (i.e. int[] = integer array 'nums' we created above
    //NOTE: when creating these parameters, you must tell java what type it is!
    2) Next create an integer to identify the first number in the list
    I'm using low and high instead of first and last because we are going to compare the two and I don't want
    that to be confusing
    3) Create an integer to represent the last value in the list
    */
    public static void quickSort(int[]nums, int lowIndex, int highIndex){
        /*
        //NOTE: This is a base case or a case created so highlight a point in which the recursion should stop
        //NOTE: Recursion simply means we call the function inside itself
        Check if the lowIndex is greater than OR equal to the highIndex
        If this is true, return/ finish the process
        */
        if(lowIndex >= highIndex){
            return;
        }
        /*
        Create a partition or pivot that will be used to separate the list into two halves
        Initialize this to the last value in the list (highIndex)
        In order to get the actual value there make sure you index the array nums[highIndex]
        //NOTE: Indexing just means your checking the actual value in that spot!
        */
        int partition = nums[highIndex];
        /*
        create an integer lp (left pointer) and set it to the lowIndex
        We are making redundant variables so we can change one without affecting the value of the other
        This pointer starts at the left most part of the array
        */
        int lp = lowIndex;
        /*
        Create another integer rp (right pointer) and set it to the highIndex
        This pointer starts at the right most part of the array
        //NOTE: These are integers because the values in the array are integers!
         */
        int rp = highIndex;
        /*
        This first while loop checks if the left pointer is < the right pointer
        While this is true, move onto the next step
         */
        while (lp < rp){
            /*
            This next loop is called a nested while loop and will only occur as long as the outer while loop is
            true.
            In this loop, while the value at the left pointer is less than OR equal to the partition AND
            the left pointer is less than the right pointer (double-check the outer case),
            increment lp (left pointer)
            This basically tells the computer to set lp to the next value in the list
            */
            while (nums[lp] <= partition && lp < rp){
                ++lp;
            }
            /*
            This is another nested while loop
            In this loop, while the value at the right pointer is greater than OR equal to the partition AND
            the left pointer is less than the right pointer (double-check the outer case),
            decrement rp (right pointer)
            This tells the computer to set rp the previous value in the list
            */
            while (nums[rp] >= partition && lp < rp){
                --rp;
            }
            /*
            Both the previous steps will continue simultaneously until they are set to false
            at this point, swap lp and rp
            This method will be explained later
            */
            //NOTE: Swap method will not work until created later
            swap(nums,lp,rp);
        }
        /*
        When the outer condition (while lp < rp) is false, the loop will break
        Here we must swap lp (left pointer) with the highIndex (last value in the list)
        This basically means that the highest value found so far will be placed at the end of the list
        this can be done with lp or rp as at this point they will point to the same value, we're using lp for
        demonstration
        */
        swap(nums, lp, highIndex);
        /*
        We will now recursively call the quicksort method, this time we will set the highIndex (last number) to
        lp-1. This means we will be only sorting the values to the left of the partition
        */
        quickSort(nums, lowIndex, lp-1); // Left recursive call
        /*
        We then create another recursive call starting from lp+1 to the highIndex
        This basically just means we are only checking the values on the right side of the partition
        */
        quickSort(nums,lp+1,highIndex); // Right recursive call
    }

    /*
    Next we will create the swap method.This will take 3 parameters
    1) the array list with the values we are using to swap
    2) an integer index1 (first value used for swapping)
    3) another integer index2 (second value used for swapping)
    */
    public static void swap(int[] nums, int index1, int index2){
        /*
        First create a base case to check if the 2 indexes are the same. This will prevent this method from running
        forever inside the loop. If this is true, return or leave the function
        */
        if(index1 == index2) {
            return;
        }
        /*
        First we need to create a temporary variable to store the value of the first index
        //NOTE: in order to get the value of an index, you must index the array list
        nums[index1] returns a value, nums returns an address in memory, and index1 will just return the spot
        that number is at.
        Next, swap the value of index1 with the value of index2.
        Finally, swap the value of index2 with the temporary variable
        */
            int temp = nums[index1]; //if index1 = 3, temp now equals 3
            nums[index1] = nums[index2]; // If index2 = 6, index1 now equals 6
            nums[index2] = temp; // index2 would now equal 3, successfully swapping the two values
    }
}
//YOU DID IT, Try running the code to test your results, try changing the values of the array to further test!