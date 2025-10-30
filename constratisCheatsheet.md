
## 🚀 1. Understanding Constraints

Constraints tell you:
- How large the input can be.
- What range values can take.
- Whether your solution will run fast enough.

---

### 📋 Example:
```

2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9

````

| Constraint | Meaning |
|-------------|----------|
| `2 <= nums.length <= 10^4` | The array will have between 2 and 10,000 elements. |
| `-10^9 <= nums[i] <= 10^9` | Each number can be very large (positive or negative). |
| `-10^9 <= target <= 10^9` | The target value can also be large. |

💡 Big range of values means you should avoid brute-force loops that take too long.

---

## ⏱️ 2. Big-O Time Complexity Reference Table

| Input Size (n) | Feasible Complexities | Example Problem | Notes |
|----------------|------------------------|------------------|-------|
| `n ≤ 10` | ✅ O(n!), O(2^n), O(n³) | Generate all subsets, permutations | Try all possibilities (brute force ok) |
| `n ≤ 100` | ✅ O(n²) | Bubble Sort, Insertion Sort | Nested loops are fine |
| `n ≤ 10⁴` | ✅ O(n log n), ⚠️ O(n²) maybe okay | Sorting, Binary Search, Merge Sort | Prefer sorting-based or hashing |
| `n ≤ 10⁶` | ✅ O(n), O(n log n) | Two Sum, Prefix Sum, Counting Sort | Use linear scans or hash maps |
| `n ≤ 10⁹` | ✅ O(log n), O(1) | Binary Search, Math Problems | Formula-based or divide and conquer |

---

## 💡 Quick Rule of Thumb

| n | Maximum Allowed Time Complexity |
|----|-------------------------------|
| ≤ 10 | O(n!) or O(2^n) |
| ≤ 100 | O(n²) |
| ≤ 10⁴ | O(n log n) |
| ≤ 10⁵ | O(n log n) or O(n) |
| ≤ 10⁶ | O(n) |
| ≤ 10⁹ | O(log n) or O(1) |

---

## 🧮 3. Time Complexity Examples

### 🐢 O(n²) — Quadratic
👉 Typical for **nested loops** (check every pair).

**Example:**  
🔹 Problem: [Two Sum (Brute Force)](https://leetcode.com/problems/two-sum/)  
🔹 Logic: For every element, check all others to find complement.

```js
for (let i = 0; i < n; i++) {
  for (let j = i + 1; j < n; j++) {
    if (nums[i] + nums[j] === target) return [i, j];
  }
}
````

---

### ⚙️ O(n log n) — Sorting Level

👉 Common when sorting or using divide & conquer.

**Examples:**

* **Merge Sort / Quick Sort**
* **Binary Search**
* **Kth Largest Element (using Heap)**

```js
nums.sort((a,b) => a - b);
```

---

### 🚀 O(n) — Linear Time

👉 Single pass through data (best possible for large inputs).

**Examples:**

* **Two Sum (Hash Map)**
* **Max Subarray Sum (Kadane’s Algorithm)**
* **Counting Frequencies**

```js
const map = new Map();
for (let i = 0; i < nums.length; i++) {
  const complement = target - nums[i];
  if (map.has(complement)) return [map.get(complement), i];
  map.set(nums[i], i);
}
```

---

### ⚡ O(log n) — Logarithmic Time

👉 Each step cuts problem in half.

**Examples:**

* **Binary Search**
* **Finding Power (fast exponentiation)**
* **Search in Rotated Sorted Array**

```js
let left = 0, right = nums.length - 1;
while (left <= right) {
  let mid = Math.floor((left + right) / 2);
  if (nums[mid] === target) return mid;
  if (nums[mid] < target) left = mid + 1;
  else right = mid - 1;
}
```

---

### 💥 O(1) — Constant Time

👉 Same time regardless of input.

**Examples:**

* Accessing an array index
* Using mathematical formulas
  e.g. `sum = n * (n + 1) / 2`

---

## ⚙️ 4. Space Complexity Rules

| Memory Limit | You Can Store                                 |
| ------------ | --------------------------------------------- |
| 256 MB       | ~10⁷ integers                                 |
| Avoid        | Storing large arrays repeatedly               |
| Prefer       | Hash Map / Prefix arrays for efficient lookup |

---

## 🪜 5. Universal Problem-Solving Approach

| Step                  | What to Do           | Example                                |
| --------------------- | -------------------- | -------------------------------------- |
| 1️⃣ Understand        | Restate the problem  | “Find two numbers that sum to target.” |
| 2️⃣ Check Constraints | Estimate input size  | n ≤ 10⁴ → O(n log n) or O(n) needed    |
| 3️⃣ Brute Force       | Try simple way first | Check all pairs                        |
| 4️⃣ Find Bottleneck   | What repeats?        | Checking same pairs                    |
| 5️⃣ Optimize          | Use data structure   | Hash Map for complements               |
| 6️⃣ Validate          | Test edge cases      | Duplicates, negatives, zeros           |

---

## 🧠 6. Problem Type → Pattern Matching

| Problem Type               | Pattern / DS                 | Example Problem                  | Time Complexity  |
| -------------------------- | ---------------------------- | -------------------------------- | ---------------- |
| Pair / Sum                 | HashMap                      | Two Sum                          | O(n)             |
| Sorted Array               | Two Pointers / Binary Search | Two Sum II                       | O(n) or O(log n) |
| Subarray / String Window   | Sliding Window               | Longest Substring Without Repeat | O(n)             |
| Order of Elements          | Stack                        | Next Greater Element             | O(n)             |
| Shortest Path / Connection | BFS / DFS                    | Graph Traversal                  | O(V + E)         |
| Frequent Elements          | Heap / HashMap               | Top K Frequent                   | O(n log k)       |
| Optimize / Min / Max       | Dynamic Programming          | Climbing Stairs                  | O(n)             |
| Search or Range            | Binary Search                | Search Insert Position           | O(log n)         |

---

## 🧩 7. Real-World Examples by Complexity

### 🐌 Brute Force (O(n²) or worse)

* Two Sum (naive)
* Longest Palindromic Substring
* 3Sum (nested loops)

### ⚙️ O(n log n)

* Merge Sort / Quick Sort
* Binary Search problems
* Kth Largest Element (heap)
* Interval Merging

### 🚀 O(n)

* Two Sum (hash map)
* Longest Substring Without Repeating Characters
* Kadane’s Algorithm (max subarray sum)
* Counting Sort

### ⚡ O(log n)

* Search in Rotated Array
* Find Peak Element
* Square Root (Binary Search)

### 💥 O(1)

* Find Missing Number (formula)
* Swap Two Variables
* Access array element

---

## 🧮 8. Operations Estimation (Per Second)

| Complexity | Safe for n | Example                |
| ---------- | ---------- | ---------------------- |
| O(n!)      | n ≤ 10     | Permutations           |
| O(2^n)     | n ≤ 20     | Subsets, Recursion     |
| O(n³)      | n ≤ 300    | Triple loops           |
| O(n²)      | n ≤ 10⁴    | Matrix problems        |
| O(n log n) | n ≤ 10⁶    | Sorting, Binary Search |
| O(n)       | n ≤ 10⁷    | Linear scan            |
| O(log n)   | n ≤ 10⁹    | Binary search          |
| O(1)       | Always     | Direct access          |

---

## 🧭 9. Thinking Process (Example: Two Sum)

| Thought                                  | Insight                                                    |
| ---------------------------------------- | ---------------------------------------------------------- |
| “I can check all pairs.”                 | That’s O(n²) brute force.                                  |
| “I keep repeating searches.”             | Store seen numbers.                                        |
| “HashMap can find complement instantly.” | O(1) lookup → total O(n).                                  |
| “Can I make it faster?”                  | No, O(n) is optimal since every element is processed once. |

---

## 🧰 10. Optimization Pattern Summary

| Problem              | Brute Force            | Optimized Idea      | Pattern          |
| -------------------- | ---------------------- | ------------------- | ---------------- |
| Two Sum              | Nested loops           | Use HashMap         | Hashing          |
| Longest Substring    | Restart for each index | Sliding Window      | Sliding Window   |
| Search Element       | Loop all items         | Binary Search       | Divide & Conquer |
| Balanced Parentheses | Count manually         | Use Stack           | Stack            |
| Max Subarray Sum     | Check all subarrays    | Dynamic Programming | Kadane’s Algo    |

---

## 🧩 11. Pattern Cheat Sheet

| Category  | Pattern         | Core Idea                   | Example                   |
| --------- | --------------- | --------------------------- | ------------------------- |
| Array     | Two Pointers    | Move inward from both ends  | Container With Most Water |
| Array     | Sliding Window  | Expand & shrink range       | Longest Substring         |
| Hashing   | HashMap / Set   | Fast lookup or counting     | Two Sum, Anagram          |
| Stack     | Monotonic Stack | Track increasing/decreasing | Next Greater Element      |
| Queue     | BFS             | Level-by-level processing   | Binary Tree Level Order   |
| Recursion | Backtracking    | Explore all combinations    | Subsets, Permutations     |
| Graph     | DFS / BFS       | Explore nodes & paths       | Connected Components      |
| Heap      | Priority Queue  | Maintain top K elements     | Kth Largest Element       |
| DP        | Memoization     | Store subproblem results    | Climbing Stairs           |
| Math      | Prefix / Modulo | Reuse computed values       | Subarray Sum Equals K     |

---

## 🧠 12. Tips to Build Logic Faster

* Ask: **“What am I doing repeatedly?”**
* Think: **“Can I store or skip something?”**
* Use **patterns**, not random memorization.
* Dry run on small input manually.
* Estimate complexity before coding.
* Write **brute → optimize → reflect**.

---

## ✅ 13. Final Checklist Before Coding

☑️ Understand input & output clearly
☑️ Identify constraints
☑️ Write brute force logic
☑️ Find inefficiency
☑️ Optimize using pattern
☑️ Test edge cases
☑️ Analyze complexity
☑️ Reflect which pattern you used


```
