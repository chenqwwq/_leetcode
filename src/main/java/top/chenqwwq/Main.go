package main

import "fmt"

/**
  @user: chenqwwq
  @date: 2020/12/18
*/

const file1 = "/home/chen/Desktop/xh/questions/sql/user_1.json"
const file2 = "/home/chen/Desktop/xh/questions/sql/use_2.json"

type Teacher struct {
	Id         int    `json:"id"`
	Name       string `json:"name"`
	SchoolId   int    `json:"schoolId"`
	SchoolName string `json:"schoolName"`
}

func main() {

	m := make(map[int32]bool)

	m[1] = false

	b, v := m[1]

	fmt.Println(b)
	fmt.Println(v)

}
