import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean bool=true ;
        while (bool) {
            /*
            ctrl+alt+l美观代码
             */
            System.out.println("请输入用户名:");
            Scanner sc = new Scanner(System.in);//接受键盘输入
            String username = sc.next();//阻塞方法
            System.out.println("你输入的用户名是:" + username);
            System.out.println("请输入密码:");
            String password = sc.next();
            System.out.println("你输入的密码是:" + password);

            /*
            开始读文件
             */
            //File file=new File("C:\\Users\\Lenovo\\IdeaProjects\\CmdShop\\src\\users.xlsx");//users.xlsx右键copy path粘贴到此处

            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();//创建对象
            User users[] = readExcel.readExcel(in);
            System.out.println("从数据库中拿到的密码：" + users[0].getPassword());

            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername().trim()) && password.equals(users[i].getPassword().trim())) {
                    System.out.println("登录成功");
                    bool=false;
                    break;
                } else {
                    System.out.println("登陆失败");
                }
            }
        }

    }
}
