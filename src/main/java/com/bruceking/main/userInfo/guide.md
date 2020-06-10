# SpringBoot前后端+数据库操作示例
#### 1、为了查询，首先需要建立一个实体类，对应数据库中的一个表，每个属性对应着表中的列名
```java
/**
customer的实体类
**/
/**快速创建getter和setter方法：Alt+Ins**/
public class customer {
    private int customer_id;
    private String customer_name;
    private String customer_mobile;
    private String customer_email;
    private String customer_username;
    private String customer_password;
    private String customer_address;
    private int customer_age;
    private String customer_sex;
    private Date customer_date;



    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_mobile() {
        return customer_mobile;
    }

    public void setCustomer_mobile(String customer_mobile) {
        this.customer_mobile = customer_mobile;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public int getCustomer_age() {
        return customer_age;
    }

    public void setCustomer_age(int customer_age) {
        this.customer_age = customer_age;
    }

    public String getCustomer_sex() {
        return customer_sex;
    }

    public void setCustomer_sex(String customer_sex) {
        this.customer_sex = customer_sex;
    }

    public String getCustomer_date() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(customer_date);
    }

    public void setCustomer_date(Date customer_date) {
        this.customer_date = customer_date;
    }
    public int getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public String getCustomer_name() {
        return customer_name;
    }
}
```
#### 2、前端发起Ajax请求，后端Controller捕获请求，利用Service实现业务逻辑，Dao层用来为Service层提供数据库的访问或处理
```java
/**
controller
**/
@Controller /**创建Contorller需要改注解**/
//@ResponseBody  /**用该注解不能跳转页面**/
/**
以上两个可以用 @RestController代替，表示不跳转页面，只是返回数据，可以配合前端请求。
**/
public class userInfoController {
    @Autowired
    private userInfoService userInfoService;

    @RequestMapping("/userInfo")/**@RequestMapping注解是用来与前端请求连接进行对接**/
    public String getUserInfo(Model model){ /**Model是用来向Thymeleaf页面传入数据**/
        //获取当前登录的username
        String currentUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principl instanceof UserDetails) {
            currentUser = ((UserDetails)principl).getUsername();
        }else {
            currentUser = principl.toString();
        }
        //获取userInfo
        customer userInfo = userInfoService.getUserInfo(currentUser);
        model.addAttribute("userInfo",userInfo); //向页面注入一个名为userInfo的数据
        return "userInfo";/**跳转到userInfo.html(位于resources/templates/中**/
    }

    @RequestMapping("/updateUserInfo") /**@RequestMapping注解是用来与前端请求连接进行对接**/
/**
@RequestParam注解是用来接受前端传入的参数
**/
    public void updateUserInfo(@RequestParam("name") String name, 
                                 @RequestParam("age") String age,
                                 @RequestParam("sex") String sex,
                                 @RequestParam("mobile") String mobile,
                                 @RequestParam("email") String email,
                                 @RequestParam("address") String address,
                                 @RequestParam("date") String dateString){
/**
下面这一部分是用来获取当前登录用户的username
**/
        String currentUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principl instanceof UserDetails) {
            currentUser = ((UserDetails)principl).getUsername();
        }else {
            currentUser = principl.toString();
        }

/**
下面调用Service中的方法来实现业务逻辑
**/
        Date sqlDate=Date.valueOf(dateString);
        userInfoService.updateUserInfo(currentUser,name,age,sex,mobile,email,address,sqlDate);
    }
}
```
```js
/**
前端请求示例，注意：js、css等静态资源都放在resources/static中
*/
$.ajax({
            url:"/updateUserInfo",
            type:"GET",
            data: data,
            success: function (result) {
                //。。。。。//
            }
        })
/**
url与Controller中的@RequestMapping对应 
**/
/**
data是形如{"name": "aaa"}的键值对，键的名字要与Controller中的@RequestParam注解里的值一一对应
**/
```
```java
/**
Service
**/
@Service  /**注解**/
public class userInfoService {

    @Autowired
    private userInfoDao userInfoDao; //忽略错误

/** 
以下是两个方法，处理业务逻辑 
**/
//获取
    public customer getUserInfo(String s){
        customer userInfo = userInfoDao.getUserInfoByUsername(s); //调用Dao中的方法
        return userInfo;
    }
//更新
    public void updateUserInfo(String username,
                               String name,
                               String age,
                               String sex,
                               String mobile,
                               String email,
                               String address,
                               Date date){
        userInfoDao.updateUserInfo(username,name,age,sex,mobile,email,address,date); //调用Dao中方法
    }
}
```

```java
/**
Dao
**/
@Mapper
public interface userInfoDao {
/**
在注解里写SQL语句进行各种数据库操作，#{XXX}是用于向SQL语句里传入变动的参数。 
**/
    @Select("select * from customer where customer_username=#{s}")
    public customer getUserInfoByUsername(String s);

    @Update("update customer set customer_name=#{name}," +
            "customer_age=#{age},customer_sex=#{sex},customer_mobile=#{mobile}," +
            "customer_email=#{email},customer_address=#{address}" +
            ",customer_date=#{date} where customer_username=#{username}")
    public void updateUserInfo(String username,
                               String name,
                               String age,
                               String sex,
                               String mobile,
                               String email,
                               String address,
                               Date date);

}
```