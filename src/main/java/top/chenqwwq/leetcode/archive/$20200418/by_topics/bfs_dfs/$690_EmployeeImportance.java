package top.chenqwwq.leetcode.archive.$20200418.by_topics.bfs_dfs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 690. Employee Importance
 * Easy
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.
 * <p>
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 * <p>
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 * <p>
 * <p>
 * Note:
 * <p>
 * One employee has at most one direct leader and may have several subordinates.
 * The maximum number of employees won't exceed 2000.
 *
 * @author chen
 * @date 2019/10/21 上午8:31
 */
public class $690_EmployeeImportance {

    @Data
    @AllArgsConstructor
    @Accessors(chain = true)
    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    class Solution {
        int result = 0;

        public int getImportance(List<Employee> employees, int id) {
            // 不使用Map,使用桶排的思路
            // The maximum number of employees won't exceed 2000.
            Employee[] employeeArr = new Employee[2000];
            for (Employee employee : employees) {
                employeeArr[employee.id] = employee;
            }
            addImportance(id, employeeArr);
            return result;
        }

        private void addImportance(int id, Employee[] employees) {
            result += employees[id].importance;
            if (employees[id].subordinates == null || employees[id].subordinates.isEmpty()) {
                return;
            }
            for (int innerId : employees[id].subordinates) {
                addImportance(innerId, employees);
            }
        }
    }

//    class Solution {
//        public int getImportance(List<Employee> employees, int id) {
//            int res = 0;
//            // 遍历一遍全部加入到Map中
//            Map<Integer,Employee> map = new HashMap<>(employees.size());
//            // id - employee
//            for (Employee employee : employees){
//                map.put(employee.id,employee);
//            }
//
//            Stack<Integer> stack = new Stack<>();
//            stack.push(id);
//
//            // 递归叠加
//            while (!stack.isEmpty()){
//                Employee employee = map.get(stack.pop());
//
//                res += employee.importance;
//
//                for (int i : employee.subordinates){
//                    stack.push(i);
//                }
//            }
//
//            return res;
//        }
//    }
}
