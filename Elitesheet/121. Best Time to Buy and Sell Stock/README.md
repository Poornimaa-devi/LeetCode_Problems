<h2><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">121. Best Time to Buy and Sell Stock</a></h2>

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>

<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Best-Time-to-Buy-and-Sell-Stock | Explained

## Approach 1 (Single Pass)
### Intuition
Imagine you're at a stock market, and you want to buy and sell a stock to maximize your profit. You would want to buy the stock when its price is the lowest and sell it when its price is the highest. This problem can be solved by keeping track of the minimum price seen so far and the maximum profit that can be achieved.

### Approach
The algorithm works by iterating over the array of stock prices. At each step, it checks if the current price is less than the minimum price seen so far. If it is, the minimum price is updated. Then, it calculates the profit that can be achieved by selling the stock at the current price and buys it at the minimum price seen so far. If this profit is greater than the maximum profit seen so far, the maximum profit is updated.

### Code
```java
int minprice = prices[0];
int maxprofit = 0;
for (int i = 0; i < prices.length; i++) {
    int profit = prices[i] - minprice;
    if (profit > maxprofit) maxprofit = profit;
    if (prices[i] < minprice) minprice = prices[i];
}
return maxprofit;
```

### Complexity
- Time: O(n), where n is the number of days (i.e., the length of the `prices` array), since we are scanning the array once.
- Space: O(1), since we are using a constant amount of space to store the minimum price and the maximum profit.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
- What if you can buy and sell the stock multiple times? In this case, you would need to use a different approach, such as finding the peak and valley in the stock prices and calculating the profit for each peak and valley.
- What if you need to wait for a certain number of days before selling the stock? In this case, you would need to modify the algorithm to keep track of the minimum price seen so far and the maximum profit that can be achieved after waiting for the specified number of days.