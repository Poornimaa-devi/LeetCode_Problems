<h2><a href="https://leetcode.com/problems/stone-removal-game">3360. Stone Removal Game</a></h2>

<p>Alice and Bob are playing a game where they take turns removing stones from a pile, with <em>Alice going first</em>.</p>

<ul>
	<li>Alice starts by removing <strong>exactly</strong> 10 stones on her first turn.</li>
	<li>For each subsequent turn, each player removes <strong>exactly</strong> 1 fewer<strong> </strong>stone<strong> </strong>than the previous opponent.</li>
</ul>

<p>The player who cannot make a move loses the game.</p>

<p>Given a positive integer <code>n</code>, return <code>true</code> if Alice wins the game and <code>false</code> otherwise.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 12</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Alice removes 10 stones on her first turn, leaving 2 stones for Bob.</li>
	<li>Bob cannot remove 9 stones, so Alice wins.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Alice cannot remove 10 stones, so Alice loses.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 50</code></li>
</ul>


---

# 🛍️ Stone-Removal-Game | Explained

## Approach 1: Greedy Simulation
### Intuition
Imagine Alice and Bob taking turns removing a decreasing number of stones from a pile: first 10 stones, then 9, then 8, and so on. The player who cannot make a move loses. Because the removal size is predetermined and strictly decreasing, we can simply simulate the process until the pile is too small for the next required removal. The parity of the turn at that moment tells us the winner.

### Algorithm Visualized
```mermaid
A["Start"] --> B["Check n >= remove"] --> C["Subtract remove"] --> D["Decrement remove"] --> E["Flip turn"] --> B
B --> F["Loop ends"] --> G["Return winner"]
```

### Approach
1. Initialise the first removal size to 10 and assume it is Alice’s turn.  
2. While the remaining stones `n` are at least the current `remove` value, perform a move:
   * Reduce `n` by `remove`.
   * Decrease `remove` by one for the next round.
   * Toggle the turn flag.
3. When the loop stops, the player whose turn would be next cannot move, so the opposite player wins. Return that result.

### Detailed Code Analysis
- **Initialisation (lines 2‑4).** The method receives the total stones `n`. `remove` is set to 10, the maximum allowed removal, and `aliceTurn` tracks whose turn it is, starting with Alice.
- **Main loop (lines 5‑9).** The `while` condition ensures a move is possible only when `n` is not smaller than the required removal. Inside the loop we deduct the stones, shrink the removal amount for the next round, and flip the turn flag. Because `remove` decreases each iteration, the loop executes at most 10 times.
- **Result (line 10).** After exiting the loop, `aliceTurn` indicates whose turn would be next. The player who just played is the winner, which is the logical negation of `aliceTurn`. The method returns this boolean.

### Code
```java
class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean aliceTurn = true;
        while (n >= remove) {
            n -= remove;
            remove--;
            aliceTurn = !aliceTurn;
        }
        return !aliceTurn;
    }
}
```

### Complexity
- **Time:** O(1) – the loop runs at most 10 iterations, independent of `n`.  
- **Space:** O(1) – only a few primitive variables are used.  