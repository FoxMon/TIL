package leetCode.minStack;

import java.util.ArrayList;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
    int pointer;
    ArrayList<Integer> list;

    public MinStack() {
        this.pointer = -1;
        this.list = new ArrayList<>();
    }

    public void push(int val) {
        this.list.add(val);
        this.pointer += 1;
    }

    public void pop() {
        if(this.list.size() == 0) {
            return;
        }
        this.list.remove(this.pointer);
        this.pointer -= 1;
    }

    public int top() {
        if(this.list.size() == 0) {
            return 0;
        }
        return this.list.get(this.pointer);
    }

    public int getMin() {
        if(this.list.size() == 0) {
            return 0;
        }
        int min = this.list.get(0);
        for(int i = 1; i < list.size(); i++) {
            min = Math.min(min, this.list.get(i));
        }
        return min;
    }
}

public class Solution {
}
