class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

       // Bucket array where index represents frequency
      // Size = nums.length + 1 because max frequency can be nums.length
      List<Integer>[] bucket = new ArrayList[nums.length + 1];

        //count frequency 
        for(int i=0;i<n;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        // bucket array fill
        for(Integer key:map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>(); //checking whether a bucket at index freq is created or not
            }
            bucket[freq].add(key);
        }

        // result array
        int[] res = new int[k]; // it is result array size = k (Top k)
        int counter = 0; //It keeps track of how many elements you have added to result

        for(int pos=bucket.length - 1;pos >= 0 && counter < k; pos--) {
            if(bucket[pos] != null) {
                for(Integer num:bucket[pos]) {
                    res[counter++] = num;
                }
            }

        }
        return res;  
    }
}
