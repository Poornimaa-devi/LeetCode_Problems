<h2><a href="https://leetcode.com/problems/minimum-cost-to-acquire-required-items">3789. Minimum Cost to Acquire Required Items</a></h2>

<p>You are given five integers <code>cost1</code>, <code>cost2</code>, <code>costBoth</code>, <code>need1</code>, and <code>need2</code>.</p>

<p>There are three types of items available:</p>

<ul>
	<li>An item of <strong>type 1</strong> costs <code>cost1</code> and contributes 1 unit to the type 1 requirement only.</li>
	<li>An item of <strong>type 2</strong> costs <code>cost2</code> and contributes 1 unit to the type 2 requirement only.</li>
	<li>An item of <strong>type 3</strong> costs <code>costBoth</code> and contributes 1 unit to <strong>both</strong> type 1 and type 2 requirements.</li>
</ul>

<p>You must collect enough items so that the total contribution toward type 1 is <strong>at least</strong> <code>need1</code> and the total contribution toward type 2 is <strong>at least</strong> <code>need2</code>.</p>

<p>Return an integer representing the <strong>minimum</strong> possible total cost to achieve these requirements.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Original</button><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io"><span class="group relative my-1 flex min-w-0 flex-col rounded-sd-md bg-sd-muted px-3 py-1.5 transition-opacity" data-example-lang-cards=""><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int cost1 = 3;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int cost2 = 2;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int costBoth = 1;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int need1 = 3;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int need2 = 2;</span><button type="button" aria-label="Copy" title="Copy" class="absolute flex h-[22px] w-[22px] items-center justify-center rounded-[4px] border right-1.5 top-1.5 border-border-quaternary dark:border-border-quaternary bg-layer-02 dark:bg-layer-02 hover:bg-fill-tertiary dark:hover:bg-fill-tertiary focus-visible:opacity-100 [@media(hover:hover)]:opacity-0 [@media(hover:hover)]:group-hover:opacity-100"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3 h-3.5 w-3.5 text-text-primary dark:text-text-primary"><svg aria-hidden="true" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" height="1em" width="1em" class="svg-inline--fa fa-clone absolute h-[1em] -translate-x-1/2 -translate-y-1/2 align-[-0.125em] left-1/2 top-1/2"><path fill="currentColor" d="M64 464H288c8.8 0 16-7.2 16-16V384h48v64c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V224c0-35.3 28.7-64 64-64h64v48H64c-8.8 0-16 7.2-16 16V448c0 8.8 7.2 16 16 16zM224 304H448c8.8 0 16-7.2 16-16V64c0-8.8-7.2-16-16-16H224c-8.8 0-16 7.2-16 16V288c0 8.8 7.2 16 16 16zm-64-16V64c0-35.3 28.7-64 64-64H448c35.3 0 64 28.7 64 64V288c0 35.3-28.7 64-64 64H224c-35.3 0-64-28.7-64-64z"></path></svg></div></button></span></span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>After buying three type 3 items, which cost <code>3 * 1 = 3</code>, the total contribution to type 1 is 3 (<code>&gt;= need1 = 3</code>) and to type 2 is 3 (<code>&gt;= need2 = 2</code>).<br data-end="229" data-start="226">
Any other valid combination would cost more, so the minimum total cost is 3.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io"><span class="group relative my-1 flex min-w-0 flex-col rounded-sd-md bg-sd-muted px-3 py-1.5 transition-opacity" data-example-lang-cards=""><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int cost1 = 5;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int cost2 = 4;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int costBoth = 15;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int need1 = 2;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int need2 = 3;</span><button type="button" aria-label="Copy" title="Copy" class="absolute flex h-[22px] w-[22px] items-center justify-center rounded-[4px] border right-1.5 top-1.5 border-border-quaternary dark:border-border-quaternary bg-layer-02 dark:bg-layer-02 hover:bg-fill-tertiary dark:hover:bg-fill-tertiary focus-visible:opacity-100 [@media(hover:hover)]:opacity-0 [@media(hover:hover)]:group-hover:opacity-100"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3 h-3.5 w-3.5 text-text-primary dark:text-text-primary"><svg aria-hidden="true" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" height="1em" width="1em" class="svg-inline--fa fa-clone absolute h-[1em] -translate-x-1/2 -translate-y-1/2 align-[-0.125em] left-1/2 top-1/2"><path fill="currentColor" d="M64 464H288c8.8 0 16-7.2 16-16V384h48v64c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V224c0-35.3 28.7-64 64-64h64v48H64c-8.8 0-16 7.2-16 16V448c0 8.8 7.2 16 16 16zM224 304H448c8.8 0 16-7.2 16-16V64c0-8.8-7.2-16-16-16H224c-8.8 0-16 7.2-16 16V288c0 8.8 7.2 16 16 16zm-64-16V64c0-35.3 28.7-64 64-64H448c35.3 0 64 28.7 64 64V288c0 35.3-28.7 64-64 64H224c-35.3 0-64-28.7-64-64z"></path></svg></div></button></span></span></p>

<p><strong>Output:</strong> <span class="example-io">22</span></p>

<p><strong>Explanation:</strong></p>

<p>We buy <code>need1 = 2</code> items of type 1 and <code>need2 = 3</code> items of type 2: <code>2 * 5 + 3 * 4 = 10 + 12 = 22</code>.<br>
Any other valid combination would cost more, so the minimum total cost is 22.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io"><span class="group relative my-1 flex min-w-0 flex-col rounded-sd-md bg-sd-muted px-3 py-1.5 transition-opacity" data-example-lang-cards=""><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int cost1 = 5;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int cost2 = 4;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int costBoth = 15;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int need1 = 0;</span><span class="min-w-0 overflow-x-auto whitespace-pre py-0.5 pr-8 font-menlo text-xs font-normal leading-5 text-sd-foreground">int need2 = 0;</span><button type="button" aria-label="Copy" title="Copy" class="absolute flex h-[22px] w-[22px] items-center justify-center rounded-[4px] border right-1.5 top-1.5 border-border-quaternary dark:border-border-quaternary bg-layer-02 dark:bg-layer-02 hover:bg-fill-tertiary dark:hover:bg-fill-tertiary focus-visible:opacity-100 [@media(hover:hover)]:opacity-0 [@media(hover:hover)]:group-hover:opacity-100"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3 h-3.5 w-3.5 text-text-primary dark:text-text-primary"><svg aria-hidden="true" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" height="1em" width="1em" class="svg-inline--fa fa-clone absolute h-[1em] -translate-x-1/2 -translate-y-1/2 align-[-0.125em] left-1/2 top-1/2"><path fill="currentColor" d="M64 464H288c8.8 0 16-7.2 16-16V384h48v64c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V224c0-35.3 28.7-64 64-64h64v48H64c-8.8 0-16 7.2-16 16V448c0 8.8 7.2 16 16 16zM224 304H448c8.8 0 16-7.2 16-16V64c0-8.8-7.2-16-16-16H224c-8.8 0-16 7.2-16 16V288c0 8.8 7.2 16 16 16zm-64-16V64c0-35.3 28.7-64 64-64H448c35.3 0 64 28.7 64 64V288c0 35.3-28.7 64-64 64H224c-35.3 0-64-28.7-64-64z"></path></svg></div></button></span></span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>Since no items are required (<code>need1 = need2 = 0</code>), we buy nothing and pay 0.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= cost1, cost2, costBoth &lt;= 10<sup>6</sup></code></li>
	<li><code>0 &lt;= need1, need2 &lt;= 10<sup>9</sup></code></li>
</ul>


---

Error connecting to AI API: The model `llama-3.3-70b-versatile` does not exist or you do not have access to it.