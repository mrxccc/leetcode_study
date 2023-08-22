这道题目不难，但是为什么通过率相对来说并不高呢，我理解是大家对边界处理的判断有所失误导致的。

这道题目，要在数组中插入目标值，无非是这四种情况。

![](https://code-thinking-1253855093.file.myqcloud.com/pics/20201216232148471.png)

目标值在数组所有元素之前
目标值等于数组中某一个元素
目标值插入数组中的位置
目标值在数组所有元素之后

暴力解法：
```
public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
```

二分法
```
public int searchInsert(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时
        if (target < nums[0]) {
            return 0;
        }
        if(target > nums[nums.length - 1]){
            return nums.length;
        }
        int left = 0, right = nums.length - 1;// 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) {// 当left==right，区间[left, right]依然有效，所以用 <=
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return right + 1;
    }
```
