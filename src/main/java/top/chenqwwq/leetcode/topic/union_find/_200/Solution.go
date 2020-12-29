package _200

/**
  @user: chenqwwq
  @date: 2020/12/29
*/

/**
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。

示例 1：
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1

示例 2：
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3

提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'
*/

type UnionFind struct {
	tree []int
}

func NewUnionFind(grid [][]byte) (*UnionFind, int, int) {
	q := len(grid)
	if q == 0 {
		return nil, -1, -1
	}
	p := len(grid[0])
	tree := make([]int, q*p)
	// 一开始就在同一棵树上
	for i := 0; i < q; i++ {
		for j := 0; j < p; j++ {
			curr := i*p + j
			if grid[i][j] == '0' {
				tree[curr] = -1
			} else {
				tree[curr] = curr
			}
		}
	}
	return &UnionFind{tree: tree}, q, p
}

func (d *UnionFind) Find(i int) int {
	if d.tree[i] != i {
		d.tree[i] = d.Find(d.tree[i])
	}
	return d.tree[i]
}

func (d *UnionFind) Union(i, j int) {
	d.tree[d.Find(i)] = d.Find(j)
}

func numIslands(grid [][]byte) int {

	find, q, p := NewUnionFind(grid)
	if find == nil {
		return 0
	}

	for i := 0; i < q; i++ {
		for j := 0; j < p; j++ {
			if grid[i][j] == '0' {
				continue
			}
			grid[i][j] = '0'

			curr := i*p + j
			j1 := j - 1
			if j1 >= 0 && grid[i][j1] == '1' {
				find.Union(curr-1, curr)
			}

			j2 := j + 1
			if j2 < p && grid[i][j2] == '1' {
				find.Union(curr+1, curr)
			}

			i1 := i - 1
			if i1 >= 0 && grid[i1][j] == '1' {
				find.Union(curr-q, curr)
			}

			i2 := i + 1
			if i2 < q && grid[i2][j] == '1' {
				find.Union(curr+p, curr)
			}

		}
	}

	hash := make(map[int]interface{})
	for i := 0; i < len(find.tree); i++ {
		if find.tree[i] != -1 {
			hash[find.tree[i]] = "A"
		}
	}

	return len(hash)
}
