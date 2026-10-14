package org.yuyuan.algorithm.recursion.tailrec

import scala.annotation.tailrec

/**
 * 尾递归求和练习：计算 1 + 2 + ... + n。
 */
object Sum {

  /** 对外入口：从 n 累加到 1，使用 Long 累加器避免整型溢出 */
  def sum(n: Int): Long = sumLoop(n, 0L)

  /**
   * 尾递归核心：把已求出的部分和放入累加器 acc，递归只依赖 acc，
   * 编译器可将其优化为循环，栈深度恒定，n 很大时也不会栈溢出。
   *
   * @param n   当前待累加的数
   * @param acc 累加器，存放已累加的部分和
   * @return 1..n 的和
   */
  @tailrec
  private def sumLoop(n: Int, acc: Long): Long =
    if (n <= 0) acc else sumLoop(n - 1, acc + n)

  def main(args: Array[String]): Unit = {
    // 自检：1..100 = 5050，空和为 0
    assert(sum(100) == 5050L)
    assert(sum(0) == 0L)
    assert(sum(5) == 15L)
    println(sum(100))
  }
}
