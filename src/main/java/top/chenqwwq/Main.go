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
	f1, err := os.Open(file1)
	f2, err := os.Open(file2)
	if err != nil {
		return
	}

	c1, err := ioutil.ReadAll(f1)
	c2, err := ioutil.ReadAll(f2)

	var t1 []Teacher
	var t2 []Teacher

	err = json.Unmarshal([]byte(c1), &t1)
	err = json.Unmarshal([]byte(c2), &t2)

	fmt.Println(len(t1) + len(t2))

	hash := map[int][]Teacher{}
	schoolName := map[int]string{}
	for _, v := range t1 {
		schoolName[v.SchoolId] = v.SchoolName
		hash[v.SchoolId] = append(hash[v.SchoolId], v)
	}
	for _, v := range t2 {
		schoolName[v.SchoolId] = v.SchoolName
		hash[v.SchoolId] = append(hash[v.SchoolId], v)
	}

}
