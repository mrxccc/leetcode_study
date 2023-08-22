双指针法
双指针法（快慢指针法）： 通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。

定义快慢指针

快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
慢指针：指向更新 新数组下标的位置
很多同学这道题目做的很懵，就是不理解 快慢指针究竟都是什么含义，所以一定要明确含义，后面的思路就更容易理解了。

删除过程如下：
![](https://code-thinking.cdn.bcebos.com/gifs/27.%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0-%E5%8F%8C%E6%8C%87%E9%92%88%E6%B3%95.gif)
快慢指针法在数组和链表的操作中是非常常见的，很多考察数组、链表、字符串等操作的面试题，都使用双指针法。

快慢指针法
```
public int removeElement(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
```

双向指针法：
```
public int removeElement(int[] nums, int val) {
    int left = 0;
    int right = nums.length - 1;
    while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
    while(left <= right) {
        if(nums[left] == val) { //left位置的元素需要移除
            //将right位置的元素移到left（覆盖），right位置移除
            nums[left] = nums[right];
            right--;
        }
        left++;
        while(right >= 0 && nums[right] == val) right--;
    }
    return left;
}
```
