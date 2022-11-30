package com.datastructure.HashTable;

/**
 * @author binbin
 * @date 2022年11月30日  下午7:21
 */
public class HashTableDemo {
    public static void main(String[] args) {

    }
}

class Employee{
    public Integer id;
    public String name;
    public Employee next;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Employee(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmployeeLinkedList{
    /**设置头指针，指向第一个Employee雇员的*/
    public Employee head=null;


    /**
     * @author binbin
     * @date 2022/11/30 下午7:30
     * @param employee
     * 添加雇员到链表的最后（默认）
     */
    public void addEmployee(Employee employee){
        //如果head为空，直接添加赋值即可
        if (head==null){
            head=employee;

        }else{
            //否则表示头指针head不为空，此时需要辅助指针来遍历
            Employee temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=employee;
        }

    }

    /**
     * @author binbin
     * @date 2022/11/30 下午7:34
     * 编写方法来遍历链表
     */
    public void list(int no){
            //首先需要判断链表是否为空
        if (head==null){
            throw new RuntimeException("第"+(no+1)+"条链表为空，无法遍历!");
        }else{
            Employee temp=head;
            System.out.print("第"+(no+1)+"条链表的信息为：");
            while (true){
                System.out.printf("=>id=%d,name=%s",temp.id,temp.name);
                if (temp.next==null){
                    //如果已经到了最后，则直接退出
                    break;
                }
                temp= temp.next;
            }
        }
    }

    /**
     * @author binbin
     * @date 2022/11/30 下午8:13
     * @param id 雇员的id
     * @return com.datastructure.HashTable.Employee 在链表中查找到的雇员对象
     * 根据雇员的id在链表中查找对应的雇员信息,如果找不到就返回为null
     */
    public Employee findEmployeeById(int id){
        Employee curEmployee=null;
        if (head==null){
            //如果头指针为空，则表示空链表
            System.out.println("链表为空");
            return curEmployee;
        }else{
            //如果头指针不为空，则不是空链表
             curEmployee=head;
            while (true){
                if (curEmployee.id==id){
                    break;
                }
                if (curEmployee.next==null){
                    //此处表示已经到最后一个元素了，还是没找到，那么就返回null
                    break;
                }
                curEmployee=curEmployee.next;

            }
        }
        return curEmployee;

    }

    /**
     * @author binbin
     * @date 2022/11/30 下午8:41
     * @param id 待删除雇员的id
     * @return int 状态结果，-1表示删除失败，0表示删除成功
     */
    public int deleteEmployeeById(int id){
        if (head==null){
            return -1;
        }else{
            Employee curEmployee=head;
            while (true){
                if (curEmployee.next==null){
                    curEmployee=null;
                    break;
                }
                curEmployee=curEmployee.next;
            }
        }
        return 0;
    }
}

class HashTab{
    /**表示的是链表数组，存放的是一条条链表*/
    EmployeeLinkedList[] arr;
    int size;

  public HashTab(int size){
      this.size=size;
      arr=new EmployeeLinkedList[size];
      //此处需要对各个链表进行初始化，因为上述只表示数组创建，其中的内容为null，此时无法进行添加等操作
      for (int i = 0; i <size ; i++) {
          arr[i]=new EmployeeLinkedList();
      }
  }

  /**
   * @author binbin
   * @date 2022/11/30 下午7:48
   * @param id 传入对应的id
   * @return int 返回对应的哈希值
   * 编写对应的散列函数，此处使用取模法
   */
  public int hashFunction(int id){
      return id % size;
  }

  /**
   * @author binbin
   * @date 2022/11/30 下午7:48
   * @param employee  待加入的员工
   *  使用此方法来增加员工进入哈希表
   */
  public void add(Employee employee){
      //获取对应的链表的存放位置
      int employeeLinkedListNo=hashFunction(employee.id);
      //将对应的对象放入链表
      arr[employeeLinkedListNo].addEmployee(employee);

  }

  /**
   * @author binbin
   * @date 2022/11/30 下午8:34
   * @param id  待查找的id
   */
    public void findEmployeeById(int id){
        //获取对应的链表的存放位置
        int employeeLinkedListNo=hashFunction(id);
        Employee employee=arr[employeeLinkedListNo].findEmployeeById(id);
        if (employee==null){
            System.out.println("未在哈希表中找到该对象");
        }else{
            System.out.println(employee);
        }
    }

    /**
     * @author binbin
     * @date 2022/11/30 下午8:52
     * @param id 待删除的id
     * @return int 返回的状态1
     */
    public int deleteEmployeeById(int id){
        return arr[hashFunction(id)].deleteEmployeeById(id);
    }
  /**
   * @author binbin
   * @date 2022/11/30 下午7:53
   * 遍历整个哈希表
   */
  public void list(){
      for (int i = 0; i <size ; i++) {
          arr[i].list(i);
      }
  }

}