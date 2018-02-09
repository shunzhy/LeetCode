刚开始觉得这个题目很简单，不就是多重循环嚒。<br/>
但是开始写代码后，才发现没那么简单，因为传入的参数digits的长度是不确定的，我们根本不知道要循环多少次。

所以，寻求算法的角度来解决这个问题。想了一会，终于想起这不就是典型的分治！

百科：
分治算法的基本思想是将一个规模为N的问题分解为K个规模较小的子问题，这些子问题相互独立且与原问题性质相同。求出子问题的解，就可得到原问题的解。

很明显的，我们的问题完全可以分解成多个子问题，通过分治组合，很轻松的就解决了问题。